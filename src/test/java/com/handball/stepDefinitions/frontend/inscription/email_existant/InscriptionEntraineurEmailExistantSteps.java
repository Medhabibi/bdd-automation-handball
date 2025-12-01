package com.handball.stepDefinitions.frontend.inscription.email_existant;

import com.handball.helper.Config;
import com.handball.pages.frontend.inscription.email_existant.InscriptionEntraineurEmailExistantPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class InscriptionEntraineurEmailExistantSteps {

    WebDriver driver = Config.getDriver();
    InscriptionEntraineurEmailExistantPage page =
            new InscriptionEntraineurEmailExistantPage(driver);

    @Given("je suis sur la page d'inscription entraîneur")
    public void ouvrirPage() {
        driver.get(Config.getProperty("inscription.entraineur"));
    }

    @And("je clique sur l'onglet inscription entraîneur")
    public void cliquerOnglet() {
        page.cliquerOnglet();
    }

    @And("je remplis tous les champs obligatoires de l'entraîneur sauf l'email")
    public void remplirObligatoiresSansEmail() {
        page.saisirNom(Config.getData("entraineur.nom"));
        page.saisirPrenom(Config.getData("entraineur.prenom"));
        page.saisirDate(Config.getData("entraineur.date_naissance"));
        page.saisirTel(Config.getData("entraineur.telephone"));
        page.choisirSexe(Config.getData("entraineur.sexe"));
        page.choisirPays(Config.getData("entraineur.pays"));
        page.choisirTypeContrat(Config.getData("entraineur.type_contrat"));
        page.saisirMDP(Config.getData("entraineur.password"));
        page.saisirConfirmMDP(Config.getData("entraineur.password_confirm"));
    }

    @And("je saisis un email déjà existant pour l'entraîneur")
    public void emailExistant() {
        page.saisirEmail(Config.getData("entraineur.email_existant"));
    }

    @And("je remplis les champs facultatifs de l'entraîneur")
    public void remplirFacultatifs() {
        page.saisirClubActuel(Config.getData("entraineur.club_actuel"));
        page.choisirNational(Config.getData("entraineur.national"));
        page.choisirPaysClubAct(Config.getData("entraineur.pays_club_actuel"));
        page.choisirSpecialite(Config.getData("entraineur.specialite"));
        page.uploadPhoto(Config.getData("entraineur.photo"));
    }

    @When("je clique sur le bouton d'inscription entraîneur")
    public void clickBouton() {
        page.cliquerInscription();
    }

    @Then("un message d'erreur email existe déjà doit s'afficher")
    public void verifErreur() {
        assertEquals("L'email existe déjà. Veuillez en choisir un autre.",
                page.getAlertMessage());
    }

    @And("l'inscription entraîneur doit échouer")
    public void inscriptionEchoue() {
        assertTrue(driver.getCurrentUrl().contains("inscri_entraineur"));
    }
}
