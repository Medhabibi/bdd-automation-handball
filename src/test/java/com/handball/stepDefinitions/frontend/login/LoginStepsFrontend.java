package com.handball.stepDefinitions.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.frontend.login.HomePageFrontend;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepsFrontend {

    HomePageFrontend homePage;

    @Given("l'utilisateur ouvre la page d'accueil du site")
    public void ouvrirPageAccueil() {
        // Rien à faire : Config.initialize() ouvre automatiquement la home page
        homePage = new HomePageFrontend();
    }

    @When("il clique sur le menu Joueurs")
    public void cliquerMenuJoueurs() {
        homePage = new HomePageFrontend();
        homePage.clickMenuJoueurs();
    }

    @When("il clique sur le menu Managers")
    public void cliquerMenuManagers() {
        homePage = new HomePageFrontend();
        homePage.clickMenuManagers();
    }

    @When("il clique sur le menu Entraîneurs")
    public void cliquerMenuEntraineurs() {
        homePage = new HomePageFrontend();
        homePage.clickMenuEntraineurs();
    }

    @When("il clique sur le menu Préparateurs physiques")
    public void cliquerMenuPreparateursPhysiques() {
        homePage = new HomePageFrontend();
        homePage.clickMenuPreparateurs();
    }



    @Then("l'URL doit contenir {string}")
    public void urlDoitContenir(String urlPart) {
        String currentUrl = Config.getDriver().getCurrentUrl();
        Assert.assertTrue("❌ URL attendue contenant : " + urlPart +
                        ", obtenue : " + currentUrl,
                currentUrl.contains(urlPart));

        System.out.println("✅ URL correcte : " + currentUrl);
    }
}
