package com.handball.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Config {

    public static WebDriver driver;
    public static Properties prop;
    public static final Logger logger = LogManager.getLogger(Config.class);

    // ============================
    // 🔹 Chargement du fichier config.properties
    // ============================
    public static void loadProperties() {
        try {
            prop = new Properties();
            prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            logger.error("Erreur chargement config.properties : " + e.getMessage());
        }
    }

    // ============================
    // 🔹 Accès aux propriétés
    // ============================
    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }

    // ============================
    // 🔹 Initialisation WebDriver
    // ============================
    public static void initialize() {

        loadProperties(); // Charger les propriétés avant l'URL

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Charger l'URL d'accueil
            String url = getProperty("url");
            driver.get(url);

            logger.info("Navigated to: " + url);

        } catch (Exception e) {
            logger.error("Driver initialization error: " + e.getMessage());
        }
    }

    // ============================
    // 🔹 Récupérer driver (Singleton)
    // ============================
    public static WebDriver getDriver() {

        if (driver == null) {
            initialize();
        }

        return driver;
    }

    // ============================
    // 🔹 Fermer le navigateur
    // ============================
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }
}
