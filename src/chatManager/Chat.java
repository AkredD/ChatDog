package  chatManager;

import messageActions.Message;

import java.util.ArrayList;

public class Chat{
    private String name;
    private ArrayList<String> history = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();


    public Chat(String name){
        this.name = name;
    }

    public void addMessage(Message message){
        ChatData.getInstance();
        this.history.add("[" + message.getDate() + "][" + name + "]" +
                message.getLogin() + ": " + message.getMessage() + "<br>");
        this.users = message.getUsers();
        //updateChatHistoryGUI(history);
    }

    public ArrayList<String> getUsers(){return users;}

    public ArrayList<String> getHistory(){
        return history;
    }

    public String getName(){
        return name;
    }

}