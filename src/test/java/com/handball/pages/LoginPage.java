package com.handball.pages;

import com.handball.helper.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.time.Duration;

public class LoginPage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Localisateurs =====
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(id = "message-alert")
    private WebElement errorMessage;

    // ===== Constructeur =====
    public LoginPage() {
        this.driver = Config.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ===== 🧭 Nouvelle méthode pour cliquer sur le menu rôle =====
    public void openRoleLoginPage(String roleName) {
        try {
            // XPath dynamique pour cliquer sur le lien du menu (insensible à la casse)
            String xpath = "//a[contains(translate(normalize-space(text()), " +
                    "'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÂÉÈÊËÎÏÔÛÙÜÇabcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüç', " +
                    "'abcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüçabcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüç'), '" +
                    roleName.toLowerCase() + "')]";

            WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            menuLink.click();
            logger.info("✅ Menu '" + roleName + "' cliqué avec succès !");
        } catch (Exception e) {
            logger.error("❌ Erreur lors du clic sur le menu '" + roleName + "' : " + e.getMessage());
        }
    }

    // ===== Saisir l'email =====
    public void enterEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailField));
            emailField.clear();
            emailField.sendKeys(email);
            logger.info("Email saisi : " + email);
        } catch (Exception e) {
            logger.error("Erreur lors de la saisie de l'email : " + e.getMessage());
        }
    }

    // ===== Saisir le mot de passe =====
    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            passwordField.clear();
            passwordField.sendKeys(password);
            logger.info("Mot de passe saisi (sécurisé)");
        } catch (Exception e) {
            logger.error("Erreur lors de la saisie du mot de passe : " + e.getMessage());
        }
    }

    // ===== Cliquer sur le bouton Connexion =====
    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            logger.info("Bouton 'Connexion' cliqué");
        } catch (Exception e) {
            logger.error("Erreur lors du clic sur le bouton Connexion : " + e.getMessage());
        }
    }

    // ===== Vérifier message d’erreur =====
    public boolean isErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            logger.warn("Message d’erreur détecté : " + errorMessage.getText());
            return true;
        } catch (Exception e) {
            logger.info("Aucun message d’erreur affiché");
            return false;
        }
    }
}
