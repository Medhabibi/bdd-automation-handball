package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.pages.admin.LoginAdminPage;
import com.handball.pages.admin.AdminNavigationPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class NavigationAdminSteps {

    WebDriver driver = Config.getDriver();
    LoginAdminPage loginPage = new LoginAdminPage(driver);
    AdminNavigationPage nav = new AdminNavigationPage(driver);

    // ==================================================
    // 🔧 Background – Connexion admin
    // ==================================================
    @Given("que l'admin ouvre la page de connexion admin")
    public void ouvrir_connexion_admin() {
        driver.get(Config.getProperty("admin.login.url"));
    }

    @And("il saisit l'email {string}")
    public void saisir_email(String email) {
        loginPage.champEmail.sendKeys(email);
    }

    @And("il saisit le mot de passe admin valide")
    public void saisir_mot_de_passe() {
        loginPage.champMotDePasse.sendKeys(Config.getProperty("admin.password"));
    }

    @And("il clique sur le bouton Connexion")
    public void cliquer_connexion() {
        loginPage.boutonConnexion.click();
    }

    @Then("la page {string} doit s'afficher")
    public void verifier_page_dashboard(String page) {
        assertTrue(driver.getCurrentUrl().contains(page));
    }

    // ==================================================
    // 📌 TC-ADMIN-NAV-001 : Vérifier visibilité des menus
    // ==================================================
    @Then("le menu {string} doit être visible")
    public void menu_visible(String menu) {

        switch (menu) {
            case "Dashboard":
                assertTrue(nav.menuDashboard.isDisplayed());
                break;

            case "Historique":
                assertTrue(nav.menuHistorique.isDisplayed());
                break;

            case "Messages non lus":
                assertTrue(nav.menuMessagesNonLus.isDisplayed());
                break;

            case "Messages lus":
                assertTrue(nav.menuMessagesLus.isDisplayed());
                break;

            case "Conversation":
                assertTrue(nav.menuConversation.isDisplayed());
                break;

            case "Tables":
                assertTrue(nav.menuTables.isDisplayed());
                break;

            case "Tables d'annonces":
                assertTrue(nav.menuTablesAnnonces.isDisplayed());
                break;

            default:
                fail("Menu inconnu : " + menu);
        }
    }

    // ==================================================
    // 📌 TC-ADMIN-NAV-002 : Navigation
    // ==================================================
    @When("l'admin clique sur le menu {string}")
    public void cliquer_menu(String menu) {

        switch (menu) {
            case "Dashboard":
                nav.menuDashboard.click();
                break;

            case "Historique":
                nav.menuHistorique.click();
                break;

            case "Messages non lus":
                nav.menuMessagesNonLus.click();
                break;

            case "Messages lus":
                nav.menuMessagesLus.click();
                break;

            case "Conversation":
                nav.menuConversation.click();
                break;

            case "Tables":
                nav.menuTables.click();
                break;

            case "Tables d'annonces":
                nav.menuTablesAnnonces.click();
                break;

            default:
                fail("Menu inconnu : " + menu);
        }
    }
}

