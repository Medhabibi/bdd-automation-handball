package com.handball.pages.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EntraineurDeletePage {

    WebDriver driver;

    public EntraineurDeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'suppression') or contains(text(),'Supprimer')]")
    public WebElement titreSuppression;

    @FindBy(xpath = "//button[contains(text(),'Annuler')]")
    public WebElement boutonAnnuler;

    @FindBy(xpath = "//button[contains(text(),'confirmer') or contains(text(),'Confirmer')]")
    public WebElement boutonConfirmer;

    public boolean isDisplayed() {
        try { return titreSuppression.isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public boolean buttonsVisible() {
        return boutonAnnuler.isDisplayed() && boutonConfirmer.isDisplayed();
    }
}
