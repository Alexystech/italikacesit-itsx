package com.itsx.italikacesit.view;

import javax.swing.*;

public class LoginLayout extends JFrame{
    public JTextField loginField;
    public JButton loginButton;
    private JPanel loginLayout;
    private JPanel navbarLogin;
    private JPanel loginFormPanel;
    public JPasswordField passwordLoginField;
    public JLabel formLoginValidation;
    public JLabel userNameLoginValidation;
    public JLabel passwordLoginValidation;

    public LoginLayout() {
        setContentPane(loginLayout);
        setSize(350,500);
        setResizable(false);
    }
}
