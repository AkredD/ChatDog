package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Dimension;

public class GuiChatDog extends JFrame {

    private JPanel contentPane;
    private JTextField txtActiveChats;
    private JTextField txtActiveUsers;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuiChatDog frame = new GuiChatDog();
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
    public GuiChatDog() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 705, 462);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JToolBar toolBar = new JToolBar();
        panel_1.add(toolBar);

        JMenu mnChat = new JMenu("Chat");
        toolBar.add(mnChat);

        JMenu mnNewMenu = new JMenu("New menu");
        toolBar.add(mnNewMenu);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setForeground(Color.GREEN);
        contentPane.add(splitPane, BorderLayout.WEST);

        JPanel panel = new JPanel();
        splitPane.setLeftComponent(panel);
        panel.setLayout(new BorderLayout(0, 0));

        txtActiveChats = new JTextField();
        txtActiveChats.setText("Active chats");
        panel.add(txtActiveChats, BorderLayout.NORTH);
        txtActiveChats.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        splitPane.setRightComponent(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        txtActiveUsers = new JTextField();
        txtActiveUsers.setText("Active users");
        panel_2.add(txtActiveUsers, BorderLayout.NORTH);
        txtActiveUsers.setColumns(18);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_2.add(scrollPane_1, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("CHAT NAME");
        panel_4.add(lblNewLabel, BorderLayout.CENTER);

        Panel panel_6 = new Panel();
        panel_4.add(panel_6, BorderLayout.WEST);

        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5, BorderLayout.SOUTH);
        panel_5.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton = new JButton("New button");
        panel_5.add(btnNewButton, BorderLayout.EAST);

        JTextArea textArea = new JTextArea();
        panel_5.add(textArea, BorderLayout.CENTER);

        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7, BorderLayout.CENTER);
        panel_7.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_7.add(scrollPane_2, BorderLayout.CENTER);
    }

}
