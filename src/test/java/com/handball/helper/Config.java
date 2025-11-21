package com.handball.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Config {

    public static WebDriver driver;
    public static Properties prop;
    public static final Logger logger = LogManager.getLogger(Config.class);

    // ============================================
    // 🔹 Charger config.properties
    // ============================================
    public static void loadProperties() {
        try {
            prop = new Properties();
            prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            logger.error("❌ Erreur chargement config.properties : " + e.getMessage());
        }
    }

    // ============================================
    // 🔹 Lire une clé depuis config.properties
    // ============================================
    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }

    // ============================================
    // 🔹 Lire une clé depuis testdata.properties
    // ============================================
    public static String getData(String key) {
        try {
            Properties data = new Properties();
            data.load(Config.class.getClassLoader().getResourceAsStream("testdata.properties"));
            return data.getProperty(key);
        } catch (Exception e) {
            logger.error("❌ Erreur lecture testdata.properties : " + e.getMessage());
            return null;
        }
    }

    // ============================================
    // 🔹 Initialisation WebDriver Edge
    // ============================================
    public static void initialize() {

        loadProperties();

        try {
            System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new EdgeDriver(options);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 🔥 Charger la base.url depuis config.properties
            String baseUrl = getProperty("base.url");
            driver.get(baseUrl);

            logger.info("🌍 Navigated to: " + baseUrl);

        } catch (Exception e) {
            logger.error("❌ Driver initialization error: " + e.getMessage());
        }
    }

    // ============================================
    // 🔹 Getter du WebDriver (Singleton)
    // ============================================
    public static WebDriver getDriver() {
        if (driver == null) {
            initialize();
        }
        return driver;
    }

    // ============================================
    // 🔹 Fermer le navigateur
    // ============================================
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("🧹 Browser closed successfully.");
        }
    }
}
