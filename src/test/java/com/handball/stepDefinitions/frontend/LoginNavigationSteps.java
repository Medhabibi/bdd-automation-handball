package com.handball.stepDefinitions.frontend;

import com.handball.helper.Config;
import com.handball.pages.frontend.LoginPageFrontend;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginNavigationSteps {

    WebDriver driver = Config.getDriver();
    LoginPageFrontend loginPage = new LoginPageFrontend(driver);

    // ============================
    // 🔹 Given – Arrivée sur une interface Login
    // ============================
    @Given("l'utilisateur se trouve sur l'interface de connexion Joueurs")
    public void user_is_on_player_login_page() {
        loginPage.openLoginPage("login.joueur");
        assertTrue(driver.getCurrentUrl().contains("inscri_joueurs.php"));
    }

    @Given("l'utilisateur se trouve sur l'interface de connexion Managers")
    public void user_is_on_manager_login_page() {
        loginPage.openLoginPage("login.equipe");
        assertTrue(driver.getCurrentUrl().contains("inscri_equipe.php"));
    }

    @Given("l'utilisateur se trouve sur l'interface de connexion Entraîneurs")
    public void user_is_on_coach_login_page() {
        loginPage.openLoginPage("login.entraineur");
        assertTrue(driver.getCurrentUrl().contains("inscri_entraineur.php"));
    }

    @Given("l'utilisateur se trouve sur l'interface de connexion Préparateurs")
    public void user_is_on_trainer_login_page() {
        loginPage.openLoginPage("login.preparateur");
        assertTrue(driver.getCurrentUrl().contains("inscri_preparateur.php"));
    }

    // ============================
    // 🔹 When – Actions utilisateur
    // ============================
    @When("il clique sur la flèche droite")
    public void user_clicks_right_arrow() {
        loginPage.cliquerFlecheDroite();
    }

    @When("il clique sur la flèche gauche")
    public void user_clicks_left_arrow() {
        loginPage.cliquerFlecheGauche();
    }

    @When("il clique sur le logo d'accueil")
    public void user_clicks_home_logo() {
        loginPage.cliquerLogoAccueil();
    }

    // ============================
    // 🔹 Then – Vérifications
    // ============================
    @Then("il doit se trouver sur l'interface de connexion Joueurs")
    public void should_be_on_players_login_page() {
        assertTrue(driver.getCurrentUrl().contains("inscri_joueurs.php"));
    }

    @Then("il doit se trouver sur l'interface de connexion Managers")
    public void should_be_on_managers_login_page() {
        assertTrue(driver.getCurrentUrl().contains("inscri_equipe.php"));
    }

    @Then("il doit se trouver sur l'interface de connexion Entraîneurs")
    public void should_be_on_coach_login_page() {
        assertTrue(driver.getCurrentUrl().contains("inscri_entraineur.php"));
    }

    @Then("il doit se trouver sur l'interface de connexion Préparateurs")
    public void should_be_on_trainer_login_page() {
        assertTrue(driver.getCurrentUrl().contains("inscri_preparateur.php"));
    }

    @Then("il doit être redirigé vers la page d'accueil")
    public void should_be_redirected_to_homepage() {
        assertTrue(driver.getCurrentUrl().contains("index.php"));
    }

    // ============================
    // 🔹 Then – Step manquant (retour cycle flèches)
    // ============================
    @Then("il doit revenir sur l'interface de connexion Joueurs")
    public void should_return_to_players_login_page() {
        assertTrue(driver.getCurrentUrl().contains("inscri_joueurs.php"));
    }
}
