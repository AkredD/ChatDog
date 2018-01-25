package messageManager;

import chatManager.*;
import messageActions.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class SendMessage{
    private Message message;
    private ObjectOutputStream objectOutputStream;

    public SendMessage(String login, String chatName, String message){
        this.message = new Message(login, message, chatName);
        this.objectOutputStream = ChatData.getInstance().getStream();
        Send();
    }

    private void Send(){
        try {
            objectOutputStream.writeObject(message);
            //ChatData.getInstance().getChat(message.getChatName()).addMessage(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}