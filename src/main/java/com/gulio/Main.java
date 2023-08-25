package com.gulio;


import com.gulio.configuration.JCEFInitializer;
import com.gulio.screen.MainScreen;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws UnsupportedPlatformException, CefInitializationException, IOException, InterruptedException {
        JCEFInitializer.initializeJCEF();
        SwingUtilities.invokeLater(MainScreen::new);
    }
}
