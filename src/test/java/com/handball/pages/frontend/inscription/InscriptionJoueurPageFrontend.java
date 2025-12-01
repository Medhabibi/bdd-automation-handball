package com.handball.pages.frontend.inscription;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InscriptionJoueurPageFrontend {

    WebDriver driver;

    public InscriptionJoueurPageFrontend(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============================
    // 🔹 Onglet Inscription Joueur
    // ============================
    @FindBy(css = "a[href='#signup']")
    private WebElement ongletInscription;

    // ============================
    // 🔹 Champs Inscription
    // ============================
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "nom")
    private WebElement nomInput;

    @FindBy(id = "prenom")
    private WebElement prenomInput;

    @FindBy(id = "date_de_naiss")
    private WebElement dateNaissanceInput;

    @FindBy(id = "pays")
    private WebElement paysSelect;


    // ---- Téléphone ----
    @FindBy(className = "iti__selected-flag")
    private WebElement flagMenu;

    @FindBy(id = "iti-0__country-listbox")
    private WebElement countryList;

    @FindBy(id = "phone")
    private WebElement telephoneInput;

    // Option Tunisie dans la liste téléphone
    @FindBy(xpath = "//li[@data-country-code='tn']")
    private WebElement optionTunisie;


    @FindBy(id = "taille")
    private WebElement tailleInput;

    @FindBy(id = "poids")
    private WebElement poidsInput;

    @FindBy(id = "sexe")
    private WebElement sexeSelect;

    @FindBy(id = "postes")
    private WebElement posteSelect;

    @FindBy(id = "type_contrat")
    private WebElement contratSelect;

    @FindBy(id = "photo_profil")
    private WebElement photoUpload;


    @FindBy(id = "mot_de_passe")
    private WebElement motDePasseInput;

    @FindBy(id = "c_mot_de_passe")
    private WebElement confirmationInput;

    @FindBy(id = "submit")
    private WebElement boutonInscription;

    @FindBy(id = "message-alert")
    private WebElement messageSucces;


    // ============================
    // 🔹 Actions
    // ============================

    public void cliquerOnglet() {
        ongletInscription.click();
    }

    public void saisirEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void saisirNom(String nom) {
        nomInput.clear();
        nomInput.sendKeys(nom);
    }

    public void saisirPrenom(String prenom) {
        prenomInput.clear();
        prenomInput.sendKeys(prenom);
    }

    public void saisirDateNaissance(String date) {
        dateNaissanceInput.clear();
        dateNaissanceInput.sendKeys(date);
    }

    public void choisirIndicatifTunisie() {
        flagMenu.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionTunisie));
        optionTunisie.click();
    }

    public void saisirTelephone(String tel) {
        telephoneInput.clear();
        telephoneInput.sendKeys(tel);
    }

    public void saisirTaille(String taille) {
        tailleInput.clear();
        tailleInput.sendKeys(taille);
    }

    public void saisirPoids(String poids) {
        poidsInput.clear();
        poidsInput.sendKeys(poids);
    }

    public void choisirSexe(String sexe) {
        new Select(sexeSelect).selectByValue(sexe);
    }

    public void choisirPoste(String poste) {
        new Select(posteSelect).selectByValue(poste);
    }

    public void choisirContrat(String contrat) {
        new Select(contratSelect).selectByValue(contrat);
    }
    public void choisirPaysListe(String pays) {
        new Select(paysSelect).selectByVisibleText(pays);
    }

    public void chargerPhoto(String cheminFichier) {
        photoUpload.sendKeys(cheminFichier);
    }

    public void saisirMotDePasse(String mdp) {
        motDePasseInput.clear();
        motDePasseInput.sendKeys(mdp);
    }

    public void confirmerMotDePasse(String conf) {
        confirmationInput.clear();
        confirmationInput.sendKeys(conf);
    }

    public void cliquerInscription() {
        boutonInscription.click();
    }

    public boolean inscriptionReussie() {
        return driver.getCurrentUrl().contains("joueurs_club");
    }
    public boolean messageSuccesVisible() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(messageSucces));
            return messageSucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
