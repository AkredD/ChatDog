package gui;

import chatManager.ChatData;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

class WindowOfConnection extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowOfConnection frame = new WindowOfConnection();
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    frame.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            //e.getComponent().
                            e.getWindow().dispose();
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
    private WindowOfConnection() {
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
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    ChatData.getInstance().connectToChat(textField.getText());
                    UpToDateGui.getInstance().setChat(textField.getText());
                    dispose();
                }
                if (e.getKeyCode() == KeyEvent.VK_CANCEL) dispose();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        textField.setColumns(10);


        JSplitPane splitPaneBottom = new JSplitPane();
        splitPaneBottom.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setRightComponent(splitPaneBottom);

        JButton btnConnect = new JButton("Connect");
        btnConnect.addActionListener(new ChatConnect());
        splitPaneBottom.setLeftComponent(btnConnect);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelAction());
        splitPaneBottom.setRightComponent(btnCancel);
    }

    class ChatConnect implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ChatData.getInstance().connectToChat(textField.getText());
            UpToDateGui.getInstance().setChat(textField.getText());
            dispose();
        }
    }

    class CancelAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }

}
