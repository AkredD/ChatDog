package userManager;

public class UserData {
    private static UserData instance;
    private static String userName = null;
    private UserData() {

    }
    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public synchronized void setName(String name) {userName = name;}

    public synchronized String getName() {return userName;}
}