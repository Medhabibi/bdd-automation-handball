package com.handball.stepDefinitions.admin;

import com.handball.pages.admin.LoginPageAdmin;
import com.handball.pages.admin.AdminDashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.time.Duration;

public class AdminDashboardSteps {

    WebDriver driver;
    LoginPageAdmin loginPage;
    AdminDashboardPage dashboardPage;

    // =====================================================
    // 🔹 Background
    // =====================================================

    @Given("l'administrateur ouvre le navigateur")
    public void ouvrirNavigateur() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPageAdmin(driver);
        dashboardPage = new AdminDashboardPage(driver);
    }

    @Given("il accède à la page de connexion du tableau de bord")
    public void accederPageConnexion() {
        loginPage.ouvrirPageConnexion();
    }

    // =====================================================
    // 🔹 Actions du scénario
    // =====================================================

    @When("il saisit le nom d'utilisateur {string}")
    public void saisirNomUtilisateur(String username) {
        loginPage.saisirNomUtilisateur(username);
    }

    @When("il saisit le mot de passe {string}")
    public void saisirMotDePasse(String password) {
        loginPage.saisirMotDePasse(password);
    }

    @When("il clique sur le bouton {string}")
    public void cliquerConnexion(String bouton) {
        loginPage.cliquerConnexion();
    }

    // =====================================================
    // 🔹 Vérifications
    // =====================================================

    @Then("il doit être redirigé vers la page du tableau de bord")
    public void verifierRedirectionDashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("Admin.php"));
    }

    @Then("le titre de la page doit être {string}")
    public void verifierTitrePage(String titreAttendu) {
        String titreActuel = loginPage.getTitrePage();
        Assert.assertTrue(titreActuel.contains(titreAttendu));
    }

    @Then("les sections suivantes doivent être visibles :")
    public void verifierSections(io.cucumber.datatable.DataTable dataTable) {

        for (String section : dataTable.asList()) {
            boolean visible = dashboardPage.sectionVisible(section);
            Assert.assertTrue("Section NON trouvée : " + section, visible);
        }
    }
}
