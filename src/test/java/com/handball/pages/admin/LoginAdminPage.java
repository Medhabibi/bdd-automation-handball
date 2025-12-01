package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAdminPage {

    WebDriver driver;

    public LoginAdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Champs login admin
    @FindBy(name = "adresse")
    public WebElement champEmail;

    @FindBy(name = "mot_de_passe")
    public WebElement champMotDePasse;

    @FindBy(xpath = "//button[contains(text(), 'Connexion')]")
    public WebElement boutonConnexion;
}
