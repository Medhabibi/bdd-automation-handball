package com.handball.stepDefinitions.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.frontend.login.LoginEntraineurPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginEntraineurSteps {

    WebDriver driver = Config.getDriver();
    LoginEntraineurPage loginPage = new LoginEntraineurPage(driver);

    @Given("l'utilisateur est sur la page de connexion Entraîneur")
    public void user_is_on_entraineur_login_page() {
        loginPage.ouvrirPageLogin();
    }

    @When("il saisit l'email entraineur {string}")
    public void enter_email(String key) {
        loginPage.saisirEmail(Config.getProperty(key));
    }

    @When("il saisit le mot de passe entraineur {string}")
    public void enter_password(String key) {
        loginPage.saisirMotDePasse(Config.getProperty(key));
    }

    @When("il clique sur Connexion entraineur")
    public void click_login() {
        loginPage.cliquerConnexion();
    }

    @Then("il doit être redirigé vers le tableau de bord entraîneur")
    public void should_redirect_dashboard() {
        assertTrue(loginPage.estSurDashboard());
    }

    @Then("un message d'erreur email entraineur doit s'afficher")
    public void email_error() {
        assertTrue(loginPage.erreurEmailVisible());
    }

    @Then("un message d'erreur mot de passe entraineur doit s'afficher")
    public void password_error() {
        assertTrue(loginPage.erreurMotDePasseVisible());
    }
}
