package com.gulio.configuration;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.MavenCefAppHandlerAdapter;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import org.cef.CefApp;

import java.io.IOException;

public class JCEFInitializer {
    public static CefApp cefApp;

    public static void initializeJCEF() throws UnsupportedPlatformException, CefInitializationException, IOException, InterruptedException {
        if (cefApp != null) {
            return; // Already initialized
        }
        CefAppBuilder builder = new CefAppBuilder();
        builder.getCefSettings().windowless_rendering_enabled = false;
        builder.setAppHandler(new MavenCefAppHandlerAdapter() {
            @Override
            public void stateHasChanged(org.cef.CefApp.CefAppState state) {
                // Shutdown the app if the native CEF part is terminated
                if (state == CefApp.CefAppState.TERMINATED) {
                    System.exit(0);
                }
            }
        });
        cefApp = builder.build();
    }

    public static void shutdownJCEF() {
        if (cefApp != null) {
            cefApp.dispose();
            cefApp = null;
        }
    }
}
