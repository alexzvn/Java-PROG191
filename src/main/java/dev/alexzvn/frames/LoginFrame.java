package dev.alexzvn.frames;

import javax.swing.*;

import dev.alexzvn.WarehouseScreen;

public class LoginFrame extends JFrame {
    private JPanel panel;
    private JTextField usernameInput;
    private JButton loginButton;
    private JPasswordField passwordInput;
    private JLabel infoLabel;

    private Credentials auth = new Credentials("admin", "password");

    public LoginFrame() {
        setContentPane(panel);
        setTitle("Login to manager application");

        loginButton.addActionListener(e -> {
            String username = usernameInput.getText();
            String password = new String(passwordInput.getPassword());

            if (! auth.attempt(username, password)) {
                infoLabel.setText("Invalid username or password");
                return;
            }

            WarehouseScreen.frame.switchToManagerFrame();
            dispose();
        });
    }

    private class Credentials {
        private String username;
        private String password;
        private int attempt = 0;

        public Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean attempt(String username, String password) {
            attempt++;
            return this.username.equals(username) && this.password.equals(password);
        }

        public int countAttempts() {
            return attempt;
        }
    }
}
