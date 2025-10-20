package com.handball.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {

    public static WebDriver driver;
    public static Properties prop;
    public static final Logger logger = LogManager.getLogger(Config.class);

    // Initialise le navigateur et charge la config
    public static void initialize() {
        try {
        	prop = new Properties();
        	prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));


            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = prop.getProperty("url");
            driver.get(url);
            logger.info("Navigated to: " + url);

        } catch (IOException e) {
            logger.error("Failed to load configuration file: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Driver initialization error: " + e.getMessage());
        }
    }

    // Ferme proprement le navigateur
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }
}
