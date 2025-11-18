package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

    WebDriver driver;

    // =====================================================
    // 🔹 Constructeur
    // =====================================================
    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =====================================================
    // 🔹 Localisateurs des sections (cartes)
    // =====================================================

    @FindBy(xpath = "//*[contains(text(),'Total des joueurs')]")
    private WebElement totalJoueurs;

    @FindBy(xpath = "//*[contains(text(),'Total des entraîneurs')]")
    private WebElement totalEntraineurs;

    @FindBy(xpath = "//*[contains(text(),'Total des préparateurs')]")
    private WebElement totalPreparateurs;

    @FindBy(xpath = "//*[contains(text(),'Total des managers')]")
    private WebElement totalManagers;

    @FindBy(xpath = "//*[contains(text(),'Equipes cherchent des joueurs')]")
    private WebElement equipesCherchentJoueurs;

    @FindBy(xpath = "//*[contains(text(),'Equipes cherchent des entraîneurs')]")
    private WebElement equipesCherchentEntraineurs;

    @FindBy(xpath = "//*[contains(text(),'Equipes cherchent des préparateurs')]")
    private WebElement equipesCherchentPreparateurs;

    @FindBy(xpath = "//*[contains(text(),'Messages lus')]")
    private WebElement messagesLus;

    @FindBy(xpath = "//*[contains(text(),'Messages non lus')]")
    private WebElement messagesNonLus;


    // =====================================================
    // 🔹 Localisateurs des liens "Voir les détails"
    // =====================================================

    @FindBy(xpath = "//a[contains(@href,'tabJoueurs.php')]")
    private WebElement voirDetailsJoueurs;

    @FindBy(xpath = "//a[contains(@href,'tabEntraineurs.php')]")
    private WebElement voirDetailsEntraineurs;

    @FindBy(xpath = "//a[contains(@href,'tabPrepas.php')]")
    private WebElement voirDetailsPreparateurs;

    @FindBy(xpath = "//a[contains(@href,'tabManagers.php')]")
    private WebElement voirDetailsManagers;


    // =====================================================
    // 🔹 Méthodes de vérification des sections
    // =====================================================

    public boolean estTotalJoueursVisible() {
        return totalJoueurs.isDisplayed();
    }

    public boolean estTotalEntraineursVisible() {
        return totalEntraineurs.isDisplayed();
    }

    public boolean estTotalPreparateursVisible() {
        return totalPreparateurs.isDisplayed();
    }

    public boolean estTotalManagersVisible() {
        return totalManagers.isDisplayed();
    }

    public boolean estEquipesCherchentJoueursVisible() {
        return equipesCherchentJoueurs.isDisplayed();
    }

    public boolean estEquipesCherchentEntraineursVisible() {
        return equipesCherchentEntraineurs.isDisplayed();
    }

    public boolean estEquipesCherchentPreparateursVisible() {
        return equipesCherchentPreparateurs.isDisplayed();
    }

    public boolean estMessagesLusVisible() {
        return messagesLus.isDisplayed();
    }

    public boolean estMessagesNonLusVisible() {
        return messagesNonLus.isDisplayed();
    }


    // =====================================================
    // 🔹 Méthodes pour cliquer sur les liens de navigation
    // =====================================================

    public void cliquerVoirDetailsJoueurs() {
        voirDetailsJoueurs.click();
    }

    public void cliquerVoirDetailsEntraineurs() {
        voirDetailsEntraineurs.click();
    }

    public void cliquerVoirDetailsPreparateurs() {
        voirDetailsPreparateurs.click();
    }

    public void cliquerVoirDetailsManagers() {
        voirDetailsManagers.click();
    }
    public boolean sectionVisible(String section) {
        return driver.getPageSource().contains(section);
    }

}



