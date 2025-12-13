package com.handball.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntraineurEditPage {

    WebDriver driver;

    public EntraineurEditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Entraîneur')]")
    public WebElement titrePage;

    @FindBy(name = "nom")
    public WebElement champNom;

    @FindBy(css = "button.btn.btn-success")
    public WebElement boutonEnregistrer;

    public boolean isDisplayed() {
        try {
            return titrePage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean champsVisibles() {
        return champNom.isDisplayed();
    }

    public void updateField(String champ, String valeur) {
        if (champ.equalsIgnoreCase("Nom")) {
            champNom.clear();
            champNom.sendKeys(valeur);
        }
    }

    public boolean sauvegardeOK() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.or(
                            ExpectedConditions.urlContains("editeEntraineurs.php"),
                            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
                    ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
