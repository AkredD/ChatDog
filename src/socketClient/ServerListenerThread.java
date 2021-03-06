package socketClient;

import chatManager.ChatData;
import gui.UpToDateGui;
import messageActions.Message;
import messageActions.Ping;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;

class ServerListenerThread implements Runnable {
    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;

    public ServerListenerThread( ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream ) {
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message messageIn = (Message) objectInputStream.readObject();
                if ( messageIn instanceof Ping) {
                    objectOutputStream.writeObject( new Ping() );
                } else {
                    ChatData.getInstance().getChat(messageIn.getChatName()).addMessage(messageIn);
                    UpToDateGui.getInstance().upToDateHistoryChat(UpToDateGui.getInstance().getActiveChat());
                    //System.out.println("["  + messageIn.getDate().toString() +  "][" + messageIn.getChatName() + "]"
                    //        + messageIn.getLogin() +  ":"  + messageIn.getMessage());
                }
            }
        }
        catch ( SocketException e ) { e.getMessage(); }
        catch ( ClassNotFoundException e ) { e.getMessage(); }
        catch ( IOException e ) { e.getMessage(); }
    }
}