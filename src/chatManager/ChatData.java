package chatManager;

import messageActions.Command;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatData{
    private static ChatData instance;
    private static HashMap<String, Chat> chats = new HashMap<>();
    private static ObjectOutputStream objectOutputStream;

    private ChatData(){

    }

    public static ChatData getInstance(){
        if (instance == null){
            instance = new ChatData();
        }
        return instance;
    }

    public void setStream(ObjectOutputStream objectOutputStream){
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectOutputStream getStream(){
        return objectOutputStream;
    }

    public Chat getChat(String name){
        return chats.get(name);
    }

    public void addChat(String name){
        chats.put(name, new Chat(name));
    }

    public void deleteChat(String name){
        chats.remove(name);
    }

    public boolean containsChat(String name){
        return chats.containsKey(name);
    }

    public HashMap<String, Chat> getChats(){ return chats;}

    public void createChat(String name){
        addChat(name);
        formCommandToServer("create", name);
    }

    public void connectToChat(String name){
        addChat(name);
        formCommandToServer("connect", name);
    }

    private void formCommandToServer(String command, String name){
        try {
            objectOutputStream.writeObject(new Command(command, name));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}