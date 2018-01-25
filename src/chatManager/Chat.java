package  chatManager;

import messageActions.Message;

import java.util.ArrayList;

public class Chat{
    private static String name;
    private static ArrayList<String> history = new ArrayList<>();


    public Chat(String name){
        this.name = name;
    }

    public void addMessage(Message message){
        ChatData.getInstance();
        this.history.add("[" + message.getDate() + "][" + name + "]" +
                message.getLogin() + ": " + message.getMessage() + "<br>");
        //updateChatHistoryGUI(history);
    }

    public ArrayList<String> getHistory(){
        return history;
    }

    public String getName(){
        return name;
    }

}