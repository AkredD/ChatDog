import gui.WindowOfAuthentification;
import socketClient.SocketClient;
import userManager.UserData;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 24.01.2018.
 */


public class MainClient {
    public static void main(String[] args) throws Exception {
        WindowOfAuthentification.main();
        SocketClient.getInstance();
    }

}
