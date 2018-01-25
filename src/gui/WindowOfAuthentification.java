package gui;

import chatManager.ChatData;
import socketClient.SocketClient;
import userManager.UserData;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class WindowOfAuthentification extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private static WindowOfAuthentification frame;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new WindowOfAuthentification();
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    frame.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            //e.getComponent().
                            //e.getWindow().dispose();
                            e.getWindow().setVisible(false);
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {

                        }

                        @Override
                        public void windowIconified(WindowEvent e) {

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {

                        }
                    });
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private WindowOfAuthentification() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 105);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        contentPane.add(splitPane, BorderLayout.NORTH);

        textField = new JTextField();
        splitPane.setLeftComponent(textField);
        textField.setColumns(10);


        JSplitPane splitPaneBottom = new JSplitPane();
        splitPaneBottom.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setRightComponent(splitPaneBottom);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new UserConfirm());
        splitPaneBottom.setLeftComponent(btnConfirm);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelAction());
        splitPaneBottom.setRightComponent(btnCancel);
    }

    class UserConfirm implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            UserData.getInstance().setName(textField.getText());
            //start work
            UpToDateGui.getInstance();
            frame.setVisible(false);
        }
    }

    class CancelAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
        }
    }

}
