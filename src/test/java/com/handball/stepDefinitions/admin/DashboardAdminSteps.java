package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.pages.admin.DashboardAdminPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class DashboardAdminSteps {

    WebDriver driver = Config.getDriver();
    DashboardAdminPage dashboard = new DashboardAdminPage(driver);

    // =====================================================
    // 🔹 When : Cliquer sur une card du Dashboard
    // =====================================================
    @When("l'admin clique sur la card {string}")
    public void adminCliqueSurLaCard(String cardName) {

        switch (cardName) {

            case "Joueurs":
                dashboard.clickCardJoueurs();
                break;

            case "Entraîneurs":
                dashboard.clickCardEntraineurs();
                break;

            case "Préparateurs":
                dashboard.clickCardPreparateurs();
                break;

            case "Managers":
                dashboard.clickCardManagers();
                break;

            case "Annonces joueurs":
                dashboard.clickCardAnnoncesJoueurs();
                break;

            case "Annonces entraîneurs":
                dashboard.clickCardAnnoncesEntraineurs();
                break;

            case "Annonces préparateurs":
                dashboard.clickCardAnnoncesPreparateurs();
                break;

            case "Messages lus":
                dashboard.clickCardMessagesLus();
                break;

            case "Messages non lus":
                dashboard.clickCardMessagesNonLus();
                break;

            default:
                throw new RuntimeException("❌ Card inconnue : " + cardName);
        }
    }

    // =====================================================
    // 🔹 Then : Vérifier que l'URL contient la page attendue
    //   (évite la duplication de steps Cucumber)
    // =====================================================
    @Then("l'URL doit contenir {string}")
    public void urlDoitContenir(String page) {
        String currentUrl = driver.getCurrentUrl();
        assertTrue("❌ L'URL ne contient pas : " + page + "\nURL actuelle : " + currentUrl,
                currentUrl.contains(page));
    }
}
