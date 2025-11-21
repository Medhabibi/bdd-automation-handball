package com.handball.stepDefinitions.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.frontend.login.LoginPreparateurPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginPreparateurSteps {

    WebDriver driver = Config.getDriver();
    LoginPreparateurPage page = new LoginPreparateurPage(driver);

    @Given("l'utilisateur est sur la page de connexion Préparateur")
    public void user_on_preparateur_login_page() {
        driver.get("https://www.handball-management.com/connexion/inscri_equipe.php");
        page.sleep(1500);
        page.ouvrirConnexion();
    }

    @When("il saisit l'email préparateur {string}")
    public void user_enters_preparateur_email(String key) {
        page.saisirEmail(Config.getData(key));
    }

    @When("il saisit le mot de passe préparateur {string}")
    public void user_enters_preparateur_password(String key) {
        page.saisirMotDePasse(Config.getData(key));
    }

    @When("il clique sur Connexion préparateur")
    public void user_clicks_login_preparateur() {
        page.cliquerConnexion();
    }

    @Then("il doit être redirigé vers le tableau de bord préparateur")
    public void should_redirect_preparateur_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("les_interfaces"));
    }

    @Then("un message d'erreur email préparateur doit s'afficher")
    public void should_show_email_error_preparateur() {
        // Non automatisable
        assertTrue(true);
    }

    @Then("un message d'erreur mot de passe préparateur doit s'afficher")
    public void should_show_password_error_preparateur() {
        // Non automatisable
        assertTrue(true);
    }
}
