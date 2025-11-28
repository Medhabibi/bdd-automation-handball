package com.handball.pages.frontend.inscription;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InscriptionEntraineurPage {

    WebDriver driver;

    public InscriptionEntraineurPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // 🔵 ONGLET INSCRIPTION
    // ============================================================
    @FindBy(xpath = "//a[@href='#signup' and text()='Inscription']")
    private WebElement ongletInscription;

    // ============================================================
    // 🔴 CHAMPS BLOQUANTS
    // ============================================================
    @FindBy(id = "nom")
    private WebElement nomInput;

    @FindBy(id = "prenom")
    private WebElement prenomInput;

    @FindBy(id = "phone")
    private WebElement telephoneInput;

    // Messages d’erreur
    @FindBy(id = "nomError")
    private WebElement nomError;

    @FindBy(id = "prenomError")
    private WebElement prenomError;

    @FindBy(id = "phoneError")
    private WebElement telephoneError;

    // ============================================================
    // 🟩 AUTRES CHAMPS
    // ============================================================
    @FindBy(id = "date_de_naiss")
    private WebElement dateNaissanceInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "sexe")
    private WebElement sexeSelect;

    @FindBy(id = "pays")
    private WebElement paysSelect;

    @FindBy(id = "statut_pro")
    private WebElement typeContratSelect;

    @FindBy(id = "specialite")
    private WebElement specialiteSelect;

    @FindBy(id = "club_actuel")
    private WebElement clubActuelInput;

    @FindBy(id = "national")
    private WebElement nationalSelect;

    @FindBy(id = "pays_club_act")
    private WebElement paysClubActuelSelect;

    @FindBy(id = "photo_profil")
    private WebElement photoInput;

    @FindBy(id = "mot_de_passe")
    private WebElement motDePasseInput;

    @FindBy(id = "c_mot_de_passe")
    private WebElement confirmerMotDePasseInput;

    @FindBy(id = "submit")
    private WebElement boutonInscription;

    // ✅ Message "Inscription réussie" OU "Email existe déjà" (même id)
    @FindBy(id = "message-alert")
    private WebElement messageSucces;

    // ============================================================
    // 🛠 MÉTHODES
    // ============================================================
    public void cliquerOngletInscription() {
        ongletInscription.click();
    }

    public void saisirNom(String nom) {
        nomInput.clear();
        nomInput.sendKeys(nom);
    }

    public void saisirPrenom(String prenom) {
        prenomInput.clear();
        prenomInput.sendKeys(prenom);
    }

    public void saisirTelephone(String tel) {
        telephoneInput.clear();
        telephoneInput.sendKeys(tel);
    }

    public void saisirDateNaissance(String date) {
        dateNaissanceInput.sendKeys(date);
    }

    public void saisirEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void choisirPays(String pays) {
        Select select = new Select(paysSelect);
        select.selectByVisibleText(pays);
    }

    public void choisirTypeContrat(String type) {
        typeContratSelect.sendKeys(type);
    }

    public void choisirSpecialite(String val) {
        specialiteSelect.sendKeys(val);
    }

    public void saisirClubActuel(String club) {
        clubActuelInput.sendKeys(club);
    }

    public void choisirNational(String val) {
        nationalSelect.sendKeys(val);
    }

    public void choisirPaysClubActuel(String pays) {
        Select select = new Select(paysClubActuelSelect);
        select.selectByVisibleText(pays);
    }

    public void choisirSexe(String sexe) {
        Select select = new Select(sexeSelect);
        select.selectByVisibleText(sexe);
    }

    public void televerserPhoto(String chemin) {
        photoInput.sendKeys(chemin);
    }

    public void saisirMotDePasse(String mdp) {
        motDePasseInput.sendKeys(mdp);
    }

    public void saisirConfirmationMotDePasse(String mdp) {
        confirmerMotDePasseInput.sendKeys(mdp);
    }

    public void cliquerBoutonInscription() {
        boutonInscription.click();
    }

    // ============================================================
    // TAB pour déclencher validation
    // ============================================================
    public void tabNom() {
        nomInput.sendKeys(Keys.TAB);
    }

    public void tabPrenom() {
        prenomInput.sendKeys(Keys.TAB);
    }

    public void tabTelephone() {
        telephoneInput.sendKeys(Keys.TAB);
    }

    // ============================================================
    // VISIBILITÉ DES ERREURS
    // ============================================================
    public boolean erreurNomVisible() {
        try {
            return nomError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean erreurPrenomVisible() {
        try {
            return prenomError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean erreurTelephoneVisible() {
        try {
            return telephoneError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getMessageErreur() {
        if (erreurNomVisible()) return nomError.getText().trim();
        if (erreurPrenomVisible()) return prenomError.getText().trim();
        if (erreurTelephoneVisible()) return telephoneError.getText().trim();
        return "";
    }

    // ============================================================
    // 🔥 MESSAGE DE SUCCÈS AVEC WAIT
    // ============================================================
    public boolean messageSuccesVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(messageSucces));
            return messageSucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ============================================================
    // 🔥 MESSAGE POUR EMAIL EXISTANT (même div, autre texte)
    // ============================================================
    public String getMessageAlerte() {
        try {
            // ✅ On attend que le message soit visible avant de lire le texte
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(messageSucces));
            return messageSucces.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
