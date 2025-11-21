package com.handball.pages.frontend.login;

import com.handball.helper.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFrontend {

    private WebDriver driver;

    public HomePageFrontend() {
        this.driver = Config.getDriver();
        PageFactory.initElements(driver, this);
    }

    // ==============================
    // 🔹 Locators du menu principal
    // ==============================

    // Lien "Joueurs" dans le menu principal
    @FindBy(xpath = "//a[@class='nav-link' and normalize-space(text())='Joueurs']")
    private WebElement menuJoueurs;

    // Lien "Managers" dans le menu principal
    @FindBy(xpath = "//a[@class='nav-link' and normalize-space(text())='MANAGERS' or @class='nav-link' and normalize-space(text())='Managers']")
    private WebElement menuManagers;

    // Lien "Entraîneurs" dans le menu principal
    @FindBy(xpath = "//a[@class='nav-link' and contains(normalize-space(text()),'Entraîneurs')]")
    private WebElement menuEntraineurs;

    // Lien "Préparateurs physiques" dans le menu principal
    @FindBy(xpath = "//a[@class='nav-link' and normalize-space(text())='Préparateurs physiques']")
    private WebElement menuPreparateurs;

    // ==============================
    // 🔹 Actions
    // ==============================

    /** Clique sur le lien Joueurs du menu principal */
    public void clickMenuJoueurs() {
        menuJoueurs.click();
    }

    /** Clique sur le lien Managers du menu principal */
    public void clickMenuManagers() {
        menuManagers.click();
    }

    /** Clique sur le lien Entraîneurs du menu principal */
    public void clickMenuEntraineurs() {
        menuEntraineurs.click();
    }

    /** Clique sur le lien Préparateurs physiques du menu principal */
    public void clickMenuPreparateurs() {
        menuPreparateurs.click();
    }
}
