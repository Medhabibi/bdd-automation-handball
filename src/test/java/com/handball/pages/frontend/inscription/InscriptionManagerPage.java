package com.handball.pages.frontend.inscription;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InscriptionManagerPage {

    WebDriver driver;

    public InscriptionManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // 🟦 ONGLET INSCRIPTION
    // ============================================================

    @FindBy(xpath = "//a[@href='#signup' and text()='Inscription']")
    private WebElement ongletInscription;

    // ============================================================
    // 🟥 CHAMPS BLOQUANTS
    // ============================================================

    @FindBy(id = "nom_club")
    private WebElement nomClubInput;

    @FindBy(id = "manager_club")
    private WebElement managerClubInput;

    // Messages d’erreur (à confirmer via HTML !)
    @FindBy(id = "nomClubError")
    private WebElement nomClubError;

    @FindBy(id = "managerClubError")
    private WebElement managerClubError;

    // ============================================================
    // 🟩 AUTRES CHAMPS
    // ============================================================

    @FindBy(id = "localisation")
    private WebElement localisationInput;

    @FindBy(id = "federation")
    private WebElement federationSelect;

    @FindBy(id = "email_club")
    private WebElement emailClubInput;

    @FindBy(id = "national_club")
    private WebElement divisionSelect;

    @FindBy(id = "description")
    private WebElement descriptionTextarea;

    @FindBy(id = "logo_club")
    private WebElement logoClubInput;

    @FindBy(id = "mot_de_passe")
    private WebElement motDePasseInput;

    @FindBy(id = "c_mot_de_passe")
    private WebElement confirmerMotDePasseInput;

    // ============================================================
    // 🟨 BOUTON INSCRIPTION
    // ============================================================

    @FindBy(id = "submit")
    private WebElement boutonInscription;

    // ============================================================
    // 🧩 MÉTHODES ACTIONS
    // ============================================================

    public void cliquerOngletInscription() {
        ongletInscription.click();
    }

    public void remplirNomClub(String nom) {
        nomClubInput.clear();
        nomClubInput.sendKeys(nom);
    }

    public void remplirManagerClub(String manager) {
        managerClubInput.clear();
        managerClubInput.sendKeys(manager);
    }

    public void remplirLocalisation(String localisation) {
        localisationInput.clear();
        localisationInput.sendKeys(localisation);
    }

    public void choisirFederation(String pays) {
        federationSelect.sendKeys(pays);
    }

    public void remplirEmailClub(String email) {
        emailClubInput.clear();
        emailClubInput.sendKeys(email);
    }

    public void choisirDivision(String division) {
        divisionSelect.sendKeys(division);
    }

    public void remplirDescription(String texte) {
        descriptionTextarea.clear();
        descriptionTextarea.sendKeys(texte);
    }

    public void uploaderLogo(String chemin) {
        logoClubInput.sendKeys(chemin);
    }

    public void remplirMotDePasse(String mdp) {
        motDePasseInput.clear();
        motDePasseInput.sendKeys(mdp);
    }

    public void remplirConfirmationMotDePasse(String mdp) {
        confirmerMotDePasseInput.clear();
        confirmerMotDePasseInput.sendKeys(mdp);
    }

    public void cliquerBoutonInscription() {
        boutonInscription.click();
    }

    // ============================================================
    // 🟧 MÉTHODE SPÉCIALE POUR TESTER LE BLOCAGE
    // ============================================================

    public void tenterNavigation() {
        try {
            // Clic sur un champ suivant pour déclencher erreur
            localisationInput.click();
        } catch (Exception ignored) {}
    }

    // ============================================================
    // 🟧 MESSAGES D’ERREURS
    // ============================================================

    public String getErreurNomClub() {
        return nomClubError.getText().trim();
    }

    public String getErreurManagerClub() {
        return managerClubError.getText().trim();
    }

    public boolean erreurNomClubVisible() {
        return nomClubError.isDisplayed();
    }

    public boolean erreurManagerClubVisible() {
        return managerClubError.isDisplayed();
    }
}
