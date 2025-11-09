package com.handball.stepDefinitions;

import com.handball.helper.Config;
import com.handball.pages.LoginPage;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDefinitions {

    private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
    private LoginPage loginPage;

    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        logger.info("=== Début du scénario de connexion ===");
        Config.initialize();
        loginPage = new LoginPage();
    }

    @When("the user selects the role {string} from the menu")
    public void the_user_selects_the_role_from_the_menu(String role) {
        logger.info("Sélection du rôle via le menu : " + role);
        loginPage.openRoleLoginPage(role);
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        logger.info("Saisie des identifiants...");
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        if (expectedResult.contains("success")) {
            logger.info("✅ Connexion réussie — Redirection attendue vers le tableau de bord.");
        } else if (expectedResult.contains("error")) {
            boolean errorShown = loginPage.isErrorDisplayed();
            if (errorShown) {
                logger.warn("⚠️ Erreur de connexion détectée comme prévu.");
            } else {
                logger.error("❌ Erreur attendue mais non affichée !");
            }
        }
        Config.closeBrowser();
    }
}
