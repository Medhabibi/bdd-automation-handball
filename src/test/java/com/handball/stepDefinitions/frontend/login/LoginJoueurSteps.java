package com.handball.stepDefinitions.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.frontend.login.LoginJoueurPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginJoueurSteps {

    WebDriver driver = Config.getDriver();
    LoginJoueurPage loginPage = new LoginJoueurPage(driver);

    // ==========================
    // GIVEN
    // ==========================

    @Given("l'utilisateur est sur la page de connexion Joueur")
    public void user_is_on_player_login_page() {
        loginPage.ouvrirPageLogin();
    }

    // ==========================
    // WHEN
    // ==========================

    @When("il saisit l'email joueur {string}")
    public void user_enters_email(String emailKey) {
        loginPage.saisirEmail(Config.getProperty(emailKey));
    }

    @When("il saisit le mot de passe joueur {string}")
    public void user_enters_password(String passwordKey) {
        loginPage.saisirMotDePasse(Config.getProperty(passwordKey));
    }

    @When("il clique sur Connexion joueur")
    public void user_clicks_login() {
        loginPage.cliquerConnexion();
    }

    // ==========================
    // THEN
    // ==========================

    @Then("il doit être redirigé vers le tableau de bord joueur")
    public void should_redirect_to_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("joueurs_club"));
    }

    @Then("un message d'erreur email joueur doit s'afficher")
    public void should_show_email_error() {
        assertTrue(loginPage.erreurEmailVisible());
    }

    @Then("un message d'erreur mot de passe joueur doit s'afficher")
    public void should_show_password_error() {
        assertTrue(loginPage.erreurMotDePasseVisible());
    }
}
