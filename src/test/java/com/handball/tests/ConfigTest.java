package com.handball.tests;

import com.handball.helper.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    private static final Logger logger = LogManager.getLogger(ConfigTest.class);

    @Test
    void verifyConfig() {
        try {
            logger.info("=== Lancement du test ConfigTest ===");

            // Initialise le navigateur + charge l’URL depuis config.properties
            Config.initialize();

            // Pause pour observer
            Thread.sleep(3000);

            // Ferme le navigateur
            Config.closeBrowser();
            logger.info("=== Test terminé avec succès ===");

        } catch (Exception e) {
            logger.error("Erreur pendant le test : " + e.getMessage());
        }
    }
}
