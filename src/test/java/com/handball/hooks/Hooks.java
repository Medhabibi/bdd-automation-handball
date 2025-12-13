package com.handball.hooks;

import com.handball.helper.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver; // ✅ DRIVER PARTAGÉ

    @Before
    public void setUp() {
        System.out.println("🚀 [Before] Initialisation du navigateur...");
        Config.initialize();
        driver = Config.getDriver(); // ✅ INITIALISÉ ICI
    }

    @After
    public void tearDown() {
        System.out.println("🧹 [After] Fin scénario");
        // Config.closeBrowser();
    }
}
