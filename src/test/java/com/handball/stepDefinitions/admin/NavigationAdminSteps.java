package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.pages.admin.AdminNavigationPage;
import com.handball.pages.admin.LoginAdminPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(d -> loginPage.boutonConnexion.isDisplayed());
        loginPage.boutonConnexion.click();

        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(d -> d.getCurrentUrl().contains("Admin.php"));
    }

    @Then("la page {string} doit s'afficher")
    public void verifier_page(String page) {
        assertTrue(driver.getCurrentUrl().contains(page));
    }

    // ==================================================
    // 📌 MENU NAVIGATION
    // ==================================================
    @When("il clique sur le menu {string}")
    public void click_menu(String menu) {
        switch (menu) {
            case "Tables":
                nav.menuTables.click();
                break;
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
            case "Tables d'annonces":
                nav.menuTablesAnnonces.click();
                break;
            default:
                fail("Menu inconnu → " + menu);
        }
    }

    // =====================================================================================
    // 🟢  recherche ⚠️
    // =====================================================================================
    @And("il ouvre la section joueurs depuis la card")
    public void ouvrir_section_joueurs_depuis_card() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By boutonJoueurs = By.xpath("//a[contains(@href,'tabJoueurs.php')]");

        // Si déjà sur tab -> skip direct (réexécution, pagination, etc)
        if(driver.getCurrentUrl().contains("tabJoueurs.php")) {
            return;
        }

        // 🔥 Scroll intelligent (pas full direct)
        for (int i = 0; i < 7; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
            Thread.sleep(400);

            if(!driver.findElements(boutonJoueurs).isEmpty()) {
                break;
            }
        }

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(boutonJoueurs));

        // 🔥 Double sécurité si premier clic non pris → reclick
        try {
            link.click();
        } catch(Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }

        // 🟩 Validation plus fiable → on attend la TABLE
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
    }
// =========================================================================
// 🔥 CONNEXION DIRECTE + ACCÈS À LA PAGE JOUEURS (réutilisable pagination)
// =========================================================================

    @Given("que l'admin est connecté")
    public void admin_est_connecte() {

        // force le chargement du fichier si pas déjà fait
        if(Config.getProperty("admin.email") == null) {
            Config.loadProperties();   // 🔥 version correcte
        }


        driver.get(Config.getProperty("admin.login.url"));

        String email = Config.getProperty("admin.username");
        String mdp   = Config.getProperty("admin.password");

        if(email == null || mdp == null || email.isEmpty() || mdp.isEmpty()) {
            throw new RuntimeException("❌ Email / Mot de passe admin non chargé dans config.properties");
        }

        loginPage.champEmail.sendKeys(email);
        loginPage.champMotDePasse.sendKeys(mdp);
        loginPage.boutonConnexion.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.urlContains("Admin.php"));

        System.out.println("✔ Connexion Admin OK !");
    }


    @And("il est sur la page {string}")
    public void il_est_sur_la_page(String page) {

        // si TAB JOUEURS demandé → navigation automatique
        if(page.equals("tabJoueurs.php")) {

            nav.menuTables.click(); // ouvre section Tables

            // utilise ton step existant
            try {
                ouvrir_section_joueurs_depuis_card();
            } catch (Exception ignored) {}
        }

        // vérification finale
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.urlContains(page));
    }

}


