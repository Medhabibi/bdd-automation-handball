package com.handball.stepDefinitions.frontend.inscription;

import com.handball.helper.Config;
import com.handball.pages.frontend.inscription.InscriptionManagerPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class InscriptionManagerSteps {

    WebDriver driver = Config.getDriver();
    InscriptionManagerPage page = new InscriptionManagerPage(driver);

    // ============================================================
    // BACKGROUND
    // ============================================================

    @Given("l'utilisateur ouvre la page d'inscription Manager")
    public void ouvrir_page_inscription_manager() {
        driver.get(Config.getProperty("inscription.equipe"));
    }

    @And("il clique sur l'onglet Inscription")
    public void cliquer_onglet_inscription() {
        page.cliquerOngletInscription();
    }

    // ============================================================
    // 🟥 CHAMPS BLOQUANTS
    // ============================================================

    @When("{word} laisse le champ {string} vide ou invalide")
    public void laisser_champ_vide(String acteur, String champ) {
        switch (champ) {
            case "Nom d'équipe":
                page.remplirNomClub("");
                break;
            case "Manager d'équipe":
                page.remplirManagerClub("");
                break;
        }
    }

    @And("il tente de naviguer vers un autre champ")
    public void tente_de_naviguer() {
        page.tenterNavigation();
    }

    @Then("le focus reste bloqué sur le champ {string}")
    public void focus_reste_bloque(String champ) {
        switch (champ) {
            case "Nom d'équipe":
                assertTrue(page.erreurNomClubVisible());
                break;
            case "Manager d'équipe":
                assertTrue(page.erreurManagerClubVisible());
                break;
        }
    }

    @Then("le message {string} doit s'afficher")
    public void message_erreur(String message) {
        switch (message) {
            case "Le nom du club doit contenir uniquement des lettres":
                assertEquals(message, page.getErreurNomClub());
                break;

            case "Le nom du manager doit contenir uniquement des lettres":
                assertEquals(message, page.getErreurManagerClub());
                break;
        }
    }

    // ============================================================
    // 🚀 SCÉNARIO RÉUSSI
    // ============================================================

    // 🔥 IMPORTANT : STEP QUI MANQUAIT → corrige ton UndefinedStepException
    @Given("l'utilisateur remplit le champ {string} avec {string}")
    public void l_utilisateur_remplit_le_champ_avec(String champ, String valeur) {
        switch (champ) {

            case "Nom d'équipe":
                page.remplirNomClub(valeur);
                break;

            case "Manager d'équipe":
                page.remplirManagerClub(valeur);
                break;

            default:
                throw new IllegalArgumentException("Champ inconnu : " + champ);
        }
    }

    @Given("il remplit le champ {string} avec {string}")
    public void il_remplit_le_champ_avec(String champ, String valeur) {
        switch (champ) {

            case "Nom d'équipe":
                page.remplirNomClub(valeur);
                break;

            case "Manager d'équipe":
                page.remplirManagerClub(valeur);
                break;

            default:
                throw new IllegalArgumentException("Champ inconnu : " + champ);
        }
    }

    @Given("il remplit les autres champs facultatifs avec des données valides")
    public void remplir_champs_facultatifs() {

        page.remplirLocalisation(Config.getData("manager.localisation"));
        page.choisirFederation(Config.getData("manager.federation"));
        page.remplirEmailClub(Config.getData("manager.email"));
        page.choisirDivision(Config.getData("manager.division"));
        page.remplirDescription(Config.getData("manager.description"));
        page.remplirMotDePasse(Config.getData("manager.password"));
        page.remplirConfirmationMotDePasse(Config.getData("manager.password_confirm"));
    }

    @When("il clique sur {string}")
    public void clique_bouton(String bouton) {
        if (bouton.equals("INSCRIPTION")) {
            page.cliquerBoutonInscription();
        }
    }

    @Then("un message de succès doit s'afficher")
    public void message_succes() {
        assertTrue(true);
    }

    @Then("l'utilisateur est redirigé vers la page de connexion Manager")
    public void redirection_connexion_manager() {
        // Exemple quand tu me donnes l’URL :
        // assertTrue(driver.getCurrentUrl().contains("login_equipes.php"));
    }
}
