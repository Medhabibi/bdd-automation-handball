package com.handball.pages.frontend.inscription.email_existant;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InscriptionEntraineurEmailExistantPage {

    WebDriver driver;

    public InscriptionEntraineurEmailExistantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#signup' and text()='Inscription']")
    private WebElement onglet;

    @FindBy(id = "nom") private WebElement nom;
    @FindBy(id = "prenom") private WebElement prenom;
    @FindBy(id = "date_de_naiss") private WebElement date;
    @FindBy(id = "phone") private WebElement tel;

    @FindBy(id = "email") private WebElement email;

    @FindBy(id = "sexe") private WebElement sexe;
    @FindBy(id = "pays") private WebElement pays;
    @FindBy(id = "statut_pro") private WebElement typeContrat;
    @FindBy(id = "mot_de_passe") private WebElement mdp;
    @FindBy(id = "c_mot_de_passe") private WebElement confirmMDP;

    @FindBy(id = "club_actuel") private WebElement clubActuel;
    @FindBy(id = "national") private WebElement national;
    @FindBy(id = "pays_club_act") private WebElement paysClubAct;
    @FindBy(id = "specialite") private WebElement specialite;
    @FindBy(id = "photo_profil") private WebElement photo;

    @FindBy(id = "submit") private WebElement boutonInscription;

    @FindBy(id = "message-alert") private WebElement messageAlerte;


    // ---------- ACTIONS ----------
    public void cliquerOnglet() { onglet.click(); }

    public void saisirNom(String v) { nom.sendKeys(v); }
    public void saisirPrenom(String v) { prenom.sendKeys(v); }
    public void saisirDate(String v) { date.sendKeys(v); }
    public void saisirTel(String v) { tel.sendKeys(v); }
    public void saisirEmail(String v) { email.sendKeys(v); }

    public void choisirSexe(String v) { new Select(sexe).selectByVisibleText(v); }
    public void choisirPays(String v) { new Select(pays).selectByVisibleText(v); }
    public void choisirTypeContrat(String v) { typeContrat.sendKeys(v); }

    public void saisirMDP(String v) { mdp.sendKeys(v); }
    public void saisirConfirmMDP(String v) { confirmMDP.sendKeys(v); }

    public void saisirClubActuel(String v) { clubActuel.sendKeys(v); }
    public void choisirNational(String v) { national.sendKeys(v); }
    public void choisirPaysClubAct(String v) { new Select(paysClubAct).selectByVisibleText(v); }

    public void choisirSpecialite(String v) {
        scroll(specialite);
        new Select(specialite).selectByVisibleText(v);
    }

    public void uploadPhoto(String path) {
        scroll(photo);
        photo.sendKeys(path);
    }

    public void cliquerInscription() { boutonInscription.click(); }

    // ----------- UTILS -----------

    private void scroll(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(e));
    }

    public String getAlertMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOf(messageAlerte));
        return messageAlerte.getText().trim();
    }
}
