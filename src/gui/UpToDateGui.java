package gui;

import chatManager.Chat;
import chatManager.ChatData;

import javax.swing.*;
import java.util.ArrayList;

public class UpToDateGui extends GuiChatDog{
    private static UpToDateGui instance;
    private String activeChat = null;
    private UpToDateGui(){}

    public static UpToDateGui getInstance(){
        if (instance == null){
            instance = new UpToDateGui();
        }
        return instance;
    }
    public void upToDateHistoryChat(String name){
        history = new JLabel();
        ArrayList<String> historyChat = ChatData.getInstance().getChat(name).getHistory();
        StringBuilder formHistory = new StringBuilder();
        for (int i = 0; i < historyChat.size(); ++i){
            formHistory.append(historyChat.get(i));
            formHistory.append("\n");
        }
        history.setText(formHistory.toString());
    }

    public void setChat(String name){
        chatName.setText(name);
        this.activeChat = name;
        upToDateHistoryChat(name);
    }

    public String getActiveChat(){
        return activeChat;
    }
}