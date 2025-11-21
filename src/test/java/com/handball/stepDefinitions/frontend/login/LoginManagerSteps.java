package com.handball.stepDefinitions.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.frontend.login.LoginManagerPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginManagerSteps {

    WebDriver driver = Config.getDriver();
    LoginManagerPage loginPage = new LoginManagerPage(driver);

    @Given("l'utilisateur est sur la page de connexion Manager")
    public void user_is_on_manager_login_page() {
        loginPage.ouvrirPageLogin();
        loginPage.cliquerOngletConnexion();
    }

    @When("il saisit l'email manager {string}")
    public void user_enters_email(String key) {
        loginPage.saisirEmail(Config.getProperty(key));
    }

    @When("il saisit le mot de passe manager {string}")
    public void user_enters_password(String key) {
        loginPage.saisirMotDePasse(Config.getProperty(key));
    }

    @When("il clique sur Connexion manager")
    public void user_clicks_login() {
        loginPage.cliquerConnexion();
    }

    @Then("il doit être redirigé vers le tableau de bord commun")
    public void should_redirect_to_dashboard() {
        assertTrue(loginPage.estSurDashboardCommun());
    }

    @Then("un message d'erreur email manager doit s'afficher")
    public void should_show_email_error() {
        assertTrue(loginPage.erreurEmailVisible());
    }

    @Then("un message d'erreur mot de passe manager doit s'afficher")
    public void should_show_password_error() {
        assertTrue(loginPage.erreurMotDePasseVisible());
    }
}
