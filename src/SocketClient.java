import messageActions.Command;
import messageActions.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient {
    private final static String address = "localhost";
    private final static int serverPort = 8091;

    private static String userName = "AkredD";
    static Socket socket = null;

    public static void main( String[] args ) {
        System.out.println("Вас приветствует клиент чата!\n");
        System.out.println("Введите свой ник и нажмите Enter ");
        BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );
        try {
            userName = keyboard.readLine();
            System.out.println();
        } catch ( IOException e ) { e.printStackTrace(); }

        try {
            try {
                InetAddress ipAddress = InetAddress.getByName( address );
                socket = new Socket( ipAddress, serverPort );
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream( outputStream );
                ObjectInputStream objectInputStream = new ObjectInputStream( inputStream );
                objectOutputStream.writeObject( new Message( userName, "User join to the chat(Auto-message)" ) );
                //new Ping( objectOutputStream, objectInputStream );
                new ServerListenerThread( objectOutputStream, objectInputStream );
                String chat = null;
                String message = null;
                String[] commands;
                System.out.println("Наберите сообщение или комманду \n");
                boolean menu = true;
                while (true) {
                    if (menu){
                        System.out.println("Введите комманду");
                        commands = keyboard.readLine().split(" ");
                        //System.out.println(commands[0] + " " + commands[1]);
                        if (commands[0].equals("create")){
                            System.out.println("cool");
                        }else{
                            System.out.println("not cool");
                        }
                        objectOutputStream.writeObject( new Command( commands[0], commands[1] ) );
                        menu = false;
                    }else {
                        if (chat == null) {
                            System.out.println("Введите название чата, куда хотите написать");
                            chat = keyboard.readLine();
                        }
                        message = keyboard.readLine();
                        if (message == "/back"){
                            menu = false;
                        }else {
                            objectOutputStream.writeObject(new Message(userName, message, chat));
                        }
                    }
                }
            } catch ( Exception e ) { e.printStackTrace(); }
        }
        finally {
            try {
                if ( socket != null ) { socket.close(); }
            } catch ( IOException e ) { e.printStackTrace(); }
        }
    }
}