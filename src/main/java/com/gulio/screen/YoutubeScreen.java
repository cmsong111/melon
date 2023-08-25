package com.gulio.screen;

import com.gulio.configuration.JCEFInitializer;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class YoutubeScreen extends JFrame {
    public YoutubeScreen(String startURL) throws UnsupportedPlatformException, CefInitializationException, IOException, InterruptedException {
        super("Youtube Player");
        startURL = "https://www.youtube.com/embed/" + startURL;

        CefClient client = JCEFInitializer.cefApp.createClient();

        CefBrowser browser = client.createBrowser(startURL, false, false);
        Component browerUI = browser.getUIComponent();


        getContentPane().add(browerUI, BorderLayout.CENTER);
        pack();
        setSize(1280, 750);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                browser.close(true);
                dispose();
            }
        });
    }
}
