package com.handball.hooks;

import com.handball.helper.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("🚀 [Before] Initialisation du navigateur et ouverture du site...");
        Config.initialize();  // on lance le navigateur via ta classe Config
    }

    @After
    public void tearDown() {
        System.out.println("🧹 [After] Fermeture du navigateur...");
       // Config.closeBrowser();  // on ferme proprement le navigateur via Config
    }
}
