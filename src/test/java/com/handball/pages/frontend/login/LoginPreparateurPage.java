package com.handball.pages.frontend.login;

import com.handball.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPreparateurPage extends BasePage {

    public LoginPreparateurPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Onglet Connexion (en haut)
    @FindBy(xpath = "//*[@id='userform']/ul/li[1]/a")
    private WebElement ongletConnexion;

    // Champs email & mot de passe
    @FindBy(id = "email_club")
    private WebElement emailInput;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordInput;

    // Bouton Connexion (en bas)
    @FindBy(id = "submit")
    private WebElement boutonConnexion;

    public void ouvrirConnexion() {
        click(ongletConnexion);
        sleep(1500);
    }

    public void saisirEmail(String email) {
        write(emailInput, email);
    }

    public void saisirMotDePasse(String motdepasse) {
        write(passwordInput, motdepasse);
    }

    public void cliquerConnexion() {
        click(boutonConnexion);
        sleep(1500);
    }
}
