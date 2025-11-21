package com.handball.pages.frontend.login;

import com.handball.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginManagerPage extends BasePage {

    WebDriver driver;

    public LoginManagerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🔹 Lien "Connexion" en haut
    @FindBy(xpath = "//*[@id='userform']//a[@data-toggle='tab' and contains(text(),'Connexion')]")
    private WebElement ongletConnexion;


    // 🔹 Champs email & mot de passe
    @FindBy(id = "email_club")
    private WebElement emailInput;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordInput;

    // 🔹 Bouton Connexion
    @FindBy(id = "submit")
    private WebElement boutonConnexion;

    // 🔹 Messages d'erreur EXACTS
    @FindBy(xpath = "//div[contains(text(),\"L'email n'existe pas.\")]")
    private WebElement erreurEmail;

    @FindBy(xpath = "//div[contains(text(),'Le mot de passe n')]")
    private WebElement erreurMotDePasse;

    public void ouvrirPageLogin() {
        driver.get("https://www.handball-management.com/connexion/inscri_equipe.php");
    }

    public void cliquerOngletConnexion() {
        click(ongletConnexion);
    }

    public void saisirEmail(String email) {
        write(emailInput, email);
    }

    public void saisirMotDePasse(String password) {
        write(passwordInput, password);
    }

    public void cliquerConnexion() {
        click(boutonConnexion);
    }

    public boolean estSurDashboardCommun() {
        return driver.getCurrentUrl().contains("joueurs_club.php");
    }

    public boolean erreurEmailVisible() {
        return isVisible(erreurEmail);
    }

    public boolean erreurMotDePasseVisible() {
        return isVisible(erreurMotDePasse);
    }
}
