package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardAdminPage {

    WebDriver driver;

    public DashboardAdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============================
    // 🔹 CARDS - LIENS EXACTS HTML
    // ============================

    @FindBy(xpath = "//a[@href='tabJoueurs.php']")
    private WebElement cardJoueurs;

    @FindBy(xpath = "//a[@href='tabEntraineurs.php']")
    private WebElement cardEntraineurs;

    @FindBy(xpath = "//a[@href='tabPreparateurs.php']")
    private WebElement cardPreparateurs;

    @FindBy(xpath = "//a[@href='tabManagers.php']")
    private WebElement cardManagers;

    @FindBy(xpath = "//a[@href='tabClubChJ.php']")
    private WebElement cardAnnoncesJoueurs;

    @FindBy(xpath = "//a[@href='tabClubChE.php']")
    private WebElement cardAnnoncesEntraineurs;

    @FindBy(xpath = "//a[@href='tabClubChP.php']")
    private WebElement cardAnnoncesPreparateurs;

    @FindBy(xpath = "//a[@href='messages_lus.php']")
    private WebElement cardMessagesLus;

    @FindBy(xpath = "//a[@href='messages_non_lus.php']")
    private WebElement cardMessagesNonLus;


    // ============================
    // 🔹 MÉTHODES DE CLIC
    // ============================

    public void clickCardJoueurs() { cardJoueurs.click(); }

    public void clickCardEntraineurs() { cardEntraineurs.click(); }

    public void clickCardPreparateurs() { cardPreparateurs.click(); }

    public void clickCardManagers() { cardManagers.click(); }

    public void clickCardAnnoncesJoueurs() { cardAnnoncesJoueurs.click(); }

    public void clickCardAnnoncesEntraineurs() { cardAnnoncesEntraineurs.click(); }

    public void clickCardAnnoncesPreparateurs() { cardAnnoncesPreparateurs.click(); }

    public void clickCardMessagesLus() { cardMessagesLus.click(); }

    public void clickCardMessagesNonLus() { cardMessagesNonLus.click(); }
}

