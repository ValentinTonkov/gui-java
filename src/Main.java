import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI Test");

        JLabel userNameLabel = new JLabel("User name");
        JLabel passwordLabel = new JLabel("Password");
        JLabel loginText = new JLabel("Login");
        JButton button = new JButton("Login");

        Font current = loginText.getFont();
        loginText.setFont(current.deriveFont(20.0f));

        JTextField userNameText = new JTextField();
        JPasswordField passwordText = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginText.setBounds(55, 15, 100, 25);
        userNameLabel.setBounds(50, 55, 100, 25);
        userNameText.setBounds(50, 80, 100, 25);
        passwordLabel.setBounds(50, 125, 100, 25);
        passwordText.setBounds(50, 150, 100, 25);
        button.setBounds(50, 200, 100, 35);

        final String USERNAME = "user1";
        final String PASSWORD = "123456";
        final Color DEFAULT_COLOR = userNameText.getBackground();

        button.addActionListener(l -> {
            if (userNameText.getText().equals(USERNAME) && String.valueOf(passwordText.getPassword()).equals(PASSWORD)) {
                JOptionPane.showMessageDialog(frame, "Logged in", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong username or password", "Failed", JOptionPane.INFORMATION_MESSAGE, UIManager.getIcon("OptionPane.warningIcon"));
                userNameText.setBackground(Color.RED);
                passwordText.setBackground(Color.RED);
            }
        });

        userNameText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (userNameText.getBackground() == Color.RED){
                    userNameText.setBackground(DEFAULT_COLOR);
                    userNameText.setText("");
                    passwordText.setBackground(DEFAULT_COLOR);
                    passwordText.setText("");
                }
            }
        });


        passwordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (passwordText.getBackground() == Color.RED) {
                    passwordText.setBackground(DEFAULT_COLOR);
                    passwordText.setText("");
                    userNameText.setBackground(DEFAULT_COLOR);
                    userNameText.setText("");
                }
            }
        });

        frame.add(userNameText);
        frame.add(userNameLabel);
        frame.add(passwordText);
        frame.add(passwordLabel);
        frame.add(loginButton);
        frame.add(loginText);
        frame.add(button);

        frame.setLayout(null);
        frame.setSize(200, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}