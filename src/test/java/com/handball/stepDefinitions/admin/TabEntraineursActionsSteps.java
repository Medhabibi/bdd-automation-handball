package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.hooks.Hooks;
import com.handball.pages.admin.EntraineurDeletePage;
import com.handball.pages.admin.EntraineurDetailsModal;
import com.handball.pages.admin.EntraineurEditPage;
import com.handball.pages.admin.TabEntraineursPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Before;

import java.time.Duration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TabEntraineursActionsSteps {

    WebDriver driver;

    TabEntraineursPage tab;
    EntraineurDetailsModal modalPage;
    EntraineurEditPage editPage;
    EntraineurDeletePage deletePage;

    @Before
    public void initPages() {
        driver = Hooks.driver;

        tab = new TabEntraineursPage(driver);
        modalPage = new EntraineurDetailsModal(driver);
        editPage = new EntraineurEditPage(driver);
        deletePage = new EntraineurDeletePage(driver);
    }


    public TabEntraineursActionsSteps() {
        // On récupère le driver centralisé
        this.driver = Config.getDriver();
    }

    // ---------------------------------------------------------
    // Utilitaire : initialiser les POM une seule fois, au bon moment
    // ---------------------------------------------------------
    private void initPagesIfNeeded() {
        if (tab == null) {
            tab = new TabEntraineursPage(driver);
        }
        if (modalPage == null) {
            modalPage = new EntraineurDetailsModal(driver);
        }
        if (editPage == null) {
            editPage = new EntraineurEditPage(driver);
        }
        if (deletePage == null) {
            deletePage = new EntraineurDeletePage(driver);
        }
    }
    private void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    // =========================================================================
    // 🔍 TEST 1 : Voir détails (modal)
    // =========================================================================

    @Given("l'admin force la recherche complète de l'entraîneur {string}")
    public void l_admin_force_la_recherche_complete_de_l_entraineur(String nom) {

        // 🔁 On force la pagination + recherche
        boolean trouve = tab.chercherDansToutesLesPages(nom);

        assertTrue(
                "❌ L'entraîneur n'a pas été trouvé après pagination complète : " + nom,
                trouve
        );

        // 🔄 Scroll horizontal pour préparer les boutons action
        tab.scrollHorizontal();
    }

    @When("l'admin clique sur le bouton voir de l'entraîneur {string}")
    public void l_admin_clique_sur_le_bouton_voir(String nom) {

        initPagesIfNeeded(); // IMPORTANT

        WebElement ligne = tab.getRow(nom);
        assertNotNull("❌ Ligne introuvable pour l'entraîneur : " + nom, ligne);

        WebElement boutonVoir = ligne.findElement(By.cssSelector("a.btn-outline-success"));
        boutonVoir.click();
    }

    @Then("la modal des détails doit s'afficher")
    public void la_modal_des_détails_doit_s_afficher() {

        initPagesIfNeeded();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> modalPage.isVisible());

        assertTrue("❌ La modal ne s'affiche pas !", modalPage.isVisible());
    }

    @Then("la modal doit contenir {string}, {string}, {string}, {string}, {string}")
    public void la_modal_doit_contenir(String nom, String prenom, String date, String pays, String sexe) {

        initPagesIfNeeded();

        String txt = modalPage.getModalText().toLowerCase();

        assertTrue(txt.contains(nom.toLowerCase()));
        assertTrue(txt.contains(prenom.toLowerCase()));
        assertTrue(txt.contains(date.toLowerCase()));
        assertTrue(txt.contains(pays.toLowerCase()));
        assertTrue(txt.contains(sexe.toLowerCase()));
    }

    @Then("l'admin ferme la modal des détails")
    public void l_admin_ferme_la_modal_des_détails() {
        initPagesIfNeeded();
        modalPage.close();
    }


    // =========================================================================
    // ✏ TEST 2 : Éditer un entraîneur
    // =========================================================================

    @When("l'admin clique sur le bouton editer de l'entraîneur {string}")
    public void l_admin_clique_sur_bouton_editer(String nom) {

        initPagesIfNeeded();

        WebElement ligne = tab.getRow(nom);
        assertNotNull("❌ Entraîneur non trouvé : " + nom, ligne);

        WebElement boutonEditer = ligne.findElement(By.cssSelector("a.btn-outline-primary"));
        boutonEditer.click();
    }

    @Then("la page d'édition doit s'afficher")
    public void la_page_d_edition_doit_s_afficher() {

        initPagesIfNeeded();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> editPage.isDisplayed());

        assertTrue("❌ La page d'édition ne s'affiche pas !", editPage.isDisplayed());
    }

    @Then("les champs d'édition doivent être visibles")
    public void les_champs_d_edition_visibles() {
        initPagesIfNeeded();
        assertTrue("❌ Les champs d'édition ne sont pas visibles !", editPage.champsVisibles());
    }

    @When("l'admin modifie le champ {string} avec {string}")
    public void l_admin_modifie_champ(String champ, String valeur) {
        initPagesIfNeeded();
        editPage.updateField(champ, valeur);
    }

    @When("il clique sur le bouton Enregistrer")
    public void il_clique_sur_bouton_enregistrer() {
        initPagesIfNeeded();
        editPage.boutonEnregistrer.click();
    }

    @Then("la sauvegarde doit réussir")
    public void la_sauvegarde_doit_reussir() {
        initPagesIfNeeded();
        assertTrue("❌ Sauvegarde échouée !", editPage.sauvegardeOK());
    }


    // =========================================================================
    // 🗑 TEST 3 : Suppression (sans supprimer)
    // =========================================================================

    @When("l'admin clique sur le bouton supprimer de l'entraîneur {string}")
    public void l_admin_clique_sur_bouton_supprimer(String nom) {

        initPagesIfNeeded();

        WebElement ligne = tab.getRow(nom);
        assertNotNull("❌ Ligne introuvable pour : " + nom, ligne);

        WebElement boutonSupprimer = ligne.findElement(By.cssSelector("a.btn-outline-danger"));
        boutonSupprimer.click();
    }

    @Then("la page de suppression doit s'afficher")
    public void la_page_de_suppression_affichee() {

        initPagesIfNeeded();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> deletePage.isDisplayed());

        assertTrue("❌ La page de suppression ne s'affiche pas !", deletePage.isDisplayed());
    }

    @Then("les boutons {string} et {string} doivent être visibles")
    public void les_boutons_visibles(String annuler, String confirmer) {
        initPagesIfNeeded();
        assertTrue("❌ Les boutons Annuler / Confirmer ne sont pas visibles !",
                deletePage.buttonsVisible());
    }

    @When("l'admin clique sur Annuler")
    public void l_admin_clique_sur_annuler() {
        initPagesIfNeeded();
        deletePage.boutonAnnuler.click();
    }

    @Then("il doit revenir à la table des entraîneurs")
    public void revenir_table_entraineurs() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("tabEntraineurs.php"));

        assertTrue(driver.getCurrentUrl().contains("tabEntraineurs.php"));
    }
}
