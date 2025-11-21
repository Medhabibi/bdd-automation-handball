package com.handball.pages.frontend.login;

import com.handball.pages.BasePage;
import com.handball.helper.Config;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginJoueurPage extends BasePage {

    WebDriver driver;

    public LoginJoueurPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==========================================
    // 🔹 Champs email & mot de passe
    // ==========================================
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordInput;

    // ==========================================
    // 🔹 Bouton Connexion Joueur
    // ==========================================
    @FindBy(id = "submit")
    private WebElement boutonConnexion;

    // ==========================================
    // 🔹 Messages d’erreurs exacts
    // ==========================================
    @FindBy(xpath = "//div[contains(text(),\"L'email n'existe pas.\")]")
    private WebElement erreurEmail;

    @FindBy(xpath = "//div[contains(text(),'mot de passe')]")
    private WebElement erreurMotDePasse;

    // ==========================================
    // 🔹 Activation automatique de l’onglet LOGIN
    // ==========================================
    public void activerOngletLogin() {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("$('a[href=\"#signin\"]').tab('show');");

            Thread.sleep(500); // donne le temps pour rendre visible
        } catch (Exception ignored) {}
    }

    // ==========================================
    // 🔹 Ouvrir la page
    // ==========================================
    public void ouvrirPageLogin() {
        driver.get(Config.getProperty("login.joueur"));
        activerOngletLogin();
    }

    // ==========================================
    // 🔹 Actions
    // ==========================================
    public void saisirEmail(String email) {
        write(emailInput, email);
    }

    public void saisirMotDePasse(String password) {
        write(passwordInput, password);
    }

    public void cliquerConnexion() {
        click(boutonConnexion);
    }

    // ==========================================
    // 🔹 Vérification Dashboard
    // ==========================================
    public boolean estSurDashboardJoueur() {
        return driver.getCurrentUrl().contains("joueurs_club.php");
    }

    // ==========================================
    // 🔹 Vérifications erreurs
    // ==========================================
    public boolean erreurEmailVisible() {
        return isVisible(erreurEmail);
    }

    public boolean erreurMotDePasseVisible() {
        return isVisible(erreurMotDePasse);
    }
}
