package socketClient;

import chatManager.ChatData;
import config.Config;
import messageActions.Command;
import messageActions.Message;
import userManager.UserData;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements Runnable {
    private Thread thread = null;
    private static SocketClient instance;
    private static Socket socket = null;

    private SocketClient(){
        thread = new Thread( this );
        thread.start();
    }

    public static SocketClient getInstance(){
        if (instance == null){
            instance = new SocketClient();
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            try {
                while (UserData.getInstance().getName() == null) continue;
                InetAddress ipAddress = InetAddress.getByName(Config.ADDRESS);
                socket = new Socket( ipAddress, Config.PORT );
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream( outputStream );
                ObjectInputStream objectInputStream = new ObjectInputStream( inputStream );
                objectOutputStream.writeObject( new Message( UserData.getInstance().getName(), "User join to the chat(Auto-message)" ) );
                ChatData.getInstance().setStream(objectOutputStream);
                Thread serverListenerThread = new Thread(new ServerListenerThread(objectOutputStream, objectInputStream));
                serverListenerThread.start();
                serverListenerThread.join();
            } catch ( InterruptedException  | IOException e  ) { e.printStackTrace(); }
        }
        finally {
            try {
                if ( socket != null ) { socket.close(); }
            } catch ( IOException e ) { e.printStackTrace(); }
        }
    }
}