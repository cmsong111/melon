package com.gulio.screen;

import com.gulio.repository.MelonRepository;
import com.gulio.repository.MelonRepositoryImpl;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainScreen extends JFrame implements ActionListener {

    JButton button = new JButton("Click me");
    JButton button2 = new JButton("chart");

    JTextField textField = new JTextField();

    MelonRepository melonRepository = new MelonRepositoryImpl();

    public MainScreen() {
        super("Main Screen");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button.setBounds(130, 100, 100, 40);
        button.addActionListener(this);

        textField.setBounds(130, 200, 100, 40);

        button2.setBounds(130, 300, 100, 40);
        button2.addActionListener(this);

        add(button2);

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
            } catch (UnsupportedPlatformException | CefInitializationException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == button2) {
            try {
                new SongChartScreen(melonRepository.getMelonChart());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
