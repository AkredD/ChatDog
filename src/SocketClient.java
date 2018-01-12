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
                String message = null;
                System.out.println("Наберите сообщение и нажмите \n");

                while (true) {
                    message = keyboard.readLine();
                    objectOutputStream.writeObject( new Message( userName, message ) );
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