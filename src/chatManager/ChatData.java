package chatManager;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatData{
    private static ChatData instance;
    private static HashMap<String, Chat> chats = new HashMap<>();
    private static ObjectOutputStream objectOutputStream;

    public ChatData(){

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
}