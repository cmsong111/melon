package com.gulio.screen;

import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainScreen extends JFrame implements ActionListener {

    JButton button = new JButton("Click me");

    JTextField textField = new JTextField();

    public MainScreen() {
        super("Main Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.setBounds(130, 100, 100, 40);
        button.addActionListener(this);

        textField.setBounds(130, 200, 100, 40);
        add(button);
        add(textField);

        setSize(400, 500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                new YoutubeScreen(textField.getText());
            } catch (UnsupportedPlatformException ex) {
                throw new RuntimeException(ex);
            } catch (CefInitializationException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
