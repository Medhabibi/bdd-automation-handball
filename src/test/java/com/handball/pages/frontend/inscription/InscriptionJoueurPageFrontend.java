package com.handball.pages.frontend.inscription;

import org.openqa.selenium.By;
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

    // ---- Téléphone ----
    @FindBy(className = "iti__selected-flag")
    private WebElement flagMenu;

    @FindBy(id = "iti-0__country-listbox")
    private WebElement countryList;

    @FindBy(id = "phone")
    private WebElement telephoneInput;

    @FindBy(id = "taille")
    private WebElement tailleInput;

    @FindBy(id = "poids")
    private WebElement poidsInput;

    @FindBy(id = "sexe")
    private WebElement sexeSelect;

    @FindBy(id = "poste")
    private WebElement posteSelect;

    @FindBy(id = "type_contrat")
    private WebElement contratSelect;

    @FindBy(id = "photo")
    private WebElement photoUpload;

    @FindBy(id = "mot_de_passe")
    private WebElement motDePasseInput;

    @FindBy(id = "confirmation")
    private WebElement confirmationInput;

    @FindBy(id = "submit_inscription")
    private WebElement boutonInscription;

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

    public void choisirPaysTunisie() {
        flagMenu.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(countryList));

        WebElement tunisie = driver.findElement(By.cssSelector(".iti__country.iti__tn"));
        tunisie.click();
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

    public void chargerPhoto(String chemin) {
        photoUpload.sendKeys(chemin);
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
}
