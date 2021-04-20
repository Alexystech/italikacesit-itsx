package com.itsx.italikacesit.view;

import javax.swing.*;

public class LoginLayout extends JFrame{
    private JTextField loginField;
    private JButton loginButton;
    private JPanel loginLayout;
    private JPanel navbarLogin;
    private JPanel loginFormPanel;
    private JPasswordField passwordLoginField;

    public LoginLayout() {
        setContentPane(loginLayout);
        setSize(400,300);
        setResizable(false);
    }
}
