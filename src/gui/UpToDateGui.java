package gui;

import chatManager.Chat;
import chatManager.ChatData;
import sas.swing.plaf.MultiLineLabelUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList<String> historyChat = ChatData.getInstance().getChat(name).getHistory();
        ArrayList<String> onlineUsersFrom = ChatData.getInstance().getChat(name).getUsers();
        String[] onlineUsers = new String[onlineUsersFrom.size()];

        for (int i = 0; i < onlineUsers.length; ++i){
            onlineUsers[i] = onlineUsersFrom.get(i);
        }
        super.users.setListData(onlineUsers);
        StringBuilder formHistory = new StringBuilder();
        //super.history.
        formHistory.append("<html>");
        formHistory.append("<font face=’verdana’ size = 5>");
        for (int i = 0; i < historyChat.size(); ++i){
            formHistory.append(historyChat.get(i));
        }
        formHistory.append("</html>");
        super.history.setText(formHistory.toString());
    }

    public void setChat(String name){
        chatName.setText(name);
        this.activeChat = name;
        upToDateHistoryChat(name);
        UpToDateActiveChats();
    }

    public void UpToDateActiveChats(){
        HashMap<String, Chat> chatsFromData = ChatData.getInstance().getChats();
        String labelsChat[] = new String[chatsFromData.size()];
        int i = 0;
        for (Map.Entry<String, Chat> entry : chatsFromData.entrySet()){
            labelsChat[i++] = entry.getKey();
        }
        chats.setListData(labelsChat);
    }

    public String getActiveChat(){
        return activeChat;
    }
}