package com.handball.stepDefinitions.frontend.inscription;

import com.handball.helper.Config;
import com.handball.pages.frontend.inscription.InscriptionJoueurPageFrontend;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class InscriptionJoueurSteps {

    WebDriver driver = Config.getDriver();
    InscriptionJoueurPageFrontend page = new InscriptionJoueurPageFrontend(driver);

    @Given("l'utilisateur est sur la page d'inscription joueur")
    public void user_is_on_registration_page() {
        driver.get(Config.getProperty("inscription.joueur"));
    }

    @And("il clique sur l'onglet inscription joueur")
    public void cliquer_onglet() {
        page.cliquerOnglet();
    }

    @When("il saisit l'adresse email du joueur {string}")
    public void saisir_email(String key) {
        page.saisirEmail(Config.getData(key));
    }

    @When("il saisit le nom joueur {string}")
    public void saisir_nom(String key) {
        page.saisirNom(Config.getData(key));
    }

    @When("il saisit le prenom joueur {string}")
    public void saisir_prenom(String key) {
        page.saisirPrenom(Config.getData(key));
    }

    @When("il saisit la date de naissance joueur {string}")
    public void saisir_date(String key) {
        page.saisirDateNaissance(Config.getData(key));
    }

    @When("il choisit le pays liste {string}")
    public void choisir_pays_liste(String key) {
        String pays = Config.getData(key);      // -> "Tunisie"
        page.choisirPaysListe(pays);           // select du <select id="pays">
    }

    @When("il choisit l'indicatif telephone {string}")
    public void choisir_indicatif(String key) {
        // On ignore la valeur "216", on force Tunisie dans le widget téléphone
        page.choisirIndicatifTunisie();

    }


    @When("il saisit le telephone joueur {string}")
    public void saisir_tel(String key) {
        page.saisirTelephone(Config.getData(key));
    }

    @When("il saisit la taille joueur {string}")
    public void saisir_taille(String key) {
        page.saisirTaille(Config.getData(key));
    }

    @When("il saisit le poids joueur {string}")
    public void saisir_poids(String key) {
        page.saisirPoids(Config.getData(key));
    }

    @When("il choisit le sexe joueur {string}")
    public void choisir_sexe(String key) {
        page.choisirSexe(Config.getData(key));
    }

    @When("il choisit le poste joueur {string}")
    public void choisir_poste(String key) {
        page.choisirPoste(Config.getData(key));
    }

    @When("il choisit le type de contrat joueur {string}")
    public void choisir_contrat(String key) {
        page.choisirContrat(Config.getData(key));
    }

    @When("il charge une photo de profil joueur {string}")
    public void charger_photo(String key) {
        page.chargerPhoto(Config.getData(key));
    }

    @When("il saisit le mot de passe inscription {string}")
    public void saisir_mdp(String key) {
        page.saisirMotDePasse(Config.getData(key));
    }

    @When("il confirme le mot de passe inscription {string}")
    public void confirmer_mdp(String key) {
        page.confirmerMotDePasse(Config.getData(key));
    }

    @When("il clique sur le bouton inscription joueur")
    public void cliquer_inscription() {
        page.cliquerInscription();
    }

    @Then("l'inscription joueur doit reussir")
    public void inscription_reussie() {
        assertTrue("Le message de succès n'est pas affiché",
                page.messageSuccesVisible());
    }

}
