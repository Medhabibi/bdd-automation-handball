package com.handball.stepDefinitions.frontend.inscription;

import com.handball.helper.Config;
import com.handball.pages.frontend.inscription.InscriptionEntraineurPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InscriptionEntraineurSteps {

    WebDriver driver = Config.getDriver();
    InscriptionEntraineurPage page = new InscriptionEntraineurPage(driver);

    // ============================================================
    // NAVIGATION
    // ============================================================
    @Given("l'utilisateur ouvre la page d'inscription Entraineur")
    public void ouvrir_page() {
        driver.get(Config.getProperty("inscription.entraineur"));
    }

    @And("il clique sur l'onglet Inscription Entraineur")
    public void cliquer_onglet() {
        page.cliquerOngletInscription();
    }

    // ============================================================
    // CHAMPS BLOQUANTS
    // ============================================================
    @When("il laisse le champ {string} vide ou invalide Entraineur")
    public void champ_vide(String champ) {

        switch (champ) {
            case "Nom":
                page.saisirNom("");
                break;

            case "Prénom":
                page.saisirNom("TestNom");
                page.saisirPrenom("");
                break;

            case "Téléphone":
                page.saisirNom("TestNom");
                page.saisirPrenom("TestPrenom");
                page.saisirTelephone("");
                break;

            default:
                throw new IllegalArgumentException("Champ inconnu : " + champ);
        }
    }

    @And("il tente de passer au champ suivant Entraineur")
    public void tab_validation() {
        try { page.tabNom(); } catch (Exception ignored) {}
        try { page.tabPrenom(); } catch (Exception ignored) {}
        try { page.tabTelephone(); } catch (Exception ignored) {}
    }

    @Then("le champ {string} doit afficher une erreur bloquante Entraineur")
    public void erreur_bloquante(String champ) {

        switch (champ) {
            case "Nom":
                assertTrue("Erreur non affichée : Nom", page.erreurNomVisible());
                break;
            case "Prénom":
                assertTrue("Erreur non affichée : Prénom", page.erreurPrenomVisible());
                break;
            case "Téléphone":
                assertTrue("Erreur non affichée : Téléphone", page.erreurTelephoneVisible());
                break;
        }
    }

    @Then("le message erreur Entraineur {string} doit s'afficher")
    public void message_erreur(String attendu) {
        assertEquals(attendu, page.getMessageErreur());
    }

    // ============================================================
    // INSCRIPTION RÉUSSIE
    // ============================================================
    @Given("il remplit le champ {string} avec une valeur valide Entraineur")
    public void remplir_valide(String champ) {
        switch (champ) {
            case "Nom":
                page.saisirNom(Config.getData("entraineur.nom"));
                break;
            case "Prénom":
                page.saisirPrenom(Config.getData("entraineur.prenom"));
                break;
            case "Date de naissance":
                page.saisirDateNaissance(Config.getData("entraineur.date_naissance"));
                break;
            case "Email":
                page.saisirEmail(Config.getData("entraineur.email"));
                break;
            case "Téléphone":
                page.saisirTelephone(Config.getData("entraineur.telephone"));
                break;
        }
    }

    @And("il sélectionne le type de contrat {string} Entraineur")
    public void choisir_type_contrat(String type) {
        page.choisirTypeContrat(type);
    }

    @And("il remplit les champs facultatifs Entraineur")
    public void remplir_facultatifs() {
        page.choisirSpecialite(Config.getData("entraineur.specialite"));
        page.choisirPays(Config.getData("entraineur.pays"));     // Pays (obligatoire dans le formulaire)
        page.choisirSexe(Config.getData("entraineur.sexe"));     // Sexe (obligatoire dans le formulaire)
        page.saisirMotDePasse(Config.getData("entraineur.password"));
        page.saisirConfirmationMotDePasse(Config.getData("entraineur.password_confirm"));
        page.televerserPhoto(Config.getData("entraineur.photo"));
    }

    @And("il remplit le champ {string} Entraineur")
    public void champs_specifiques(String champ) {
        switch (champ) {
            case "Club actuel":
                page.saisirClubActuel(Config.getData("entraineur.club_actuel"));
                break;
            case "Nationalité":
                page.choisirNational(Config.getData("entraineur.national"));
                break;
            case "Pays du club actuel":
                page.choisirPaysClubActuel(Config.getData("entraineur.pays_club_actuel"));
                break;
        }
    }

    @When("il clique sur le bouton Inscription Entraineur")
    public void click_inscription() {
        page.cliquerBoutonInscription();
    }

    @Then("un message de succès Entraineur doit s'afficher")
    public void succes() {
        assertTrue("Message de succès introuvable !", page.messageSuccesVisible());
    }

    @Then("il est redirigé vers la page de connexion Entraineur")
    public void redirection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean redirected = wait.until(ExpectedConditions.urlContains("login_entraineurs"));
        assertTrue("Redirection vers la page de connexion non détectée", redirected);
    }

    // ============================================================
    // EMAIL DÉJÀ EXISTANT
    // ============================================================
    @And("il saisit un email déjà utilisé Entraineur")
    public void email_deja_existant() {
        page.saisirEmail(Config.getData("entraineur.email_existant"));
    }

    @Then("un message d'erreur doit s'afficher {string}")
    public void message_erreur_email(String attendu) {
        assertEquals(attendu, page.getMessageAlerte());
    }

    @And("l'inscription Entraineur doit échouer")
    public void inscription_echoue() {
        assertTrue("L'utilisateur ne devrait pas quitter la page d'inscription",
                driver.getCurrentUrl().contains("inscri_entraineur"));
    }
    // ============================================================
// STEPS MANQUANTS POUR LE SCÉNARIO EMAIL EXISTANT
// ============================================================

    @And("il sélectionne le sexe Entraineur")
    public void il_selectionne_le_sexe_entraineur() {
        page.choisirSexe(Config.getData("entraineur.sexe"));
    }

    @And("il remplit tous les autres champs obligatoires Entraineur")
    public void il_remplit_tous_les_autres_champs_obligatoires_entraineur() {
        page.choisirPays(Config.getData("entraineur.pays"));
        page.choisirTypeContrat(Config.getData("entraineur.type_contrat"));
        page.saisirClubActuel(Config.getData("entraineur.club_actuel"));
        page.choisirNational(Config.getData("entraineur.national"));
        page.choisirPaysClubActuel(Config.getData("entraineur.pays_club_actuel"));
    }

}
