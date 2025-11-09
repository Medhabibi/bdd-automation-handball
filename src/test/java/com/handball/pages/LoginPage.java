package com.handball.pages;

import com.handball.helper.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class LoginPage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public WebDriver driver;
    public WebDriverWait wait;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ===== 🚀 Ouvrir la page de connexion d’un rôle =====
    public void openRoleLoginPage(String roleName) {
        try {
            String xpath = "//a[contains(translate(normalize-space(text()), " +
                    "'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÂÉÈÊËÎÏÔÛÙÜÇabcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüç', " +
                    "'abcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüçabcdefghijklmnopqrstuvwxyzàâéèêëîïôûùüç'), '" +
                    roleName.toLowerCase() + "')]";

            WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuLink);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuLink);
            logger.info("✅ Menu '" + roleName + "' cliqué avec succès !");

            // --- attendre ouverture d’un nouvel onglet
            String originalWindow = driver.getWindowHandle();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> d.getWindowHandles().size() > 1);

            // --- basculer sur le nouvel onglet
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    logger.info("🪟 Changement d’onglet réussi !");
                    break;
                }
            }

            // --- attendre chargement complet du DOM
            new WebDriverWait(driver, Duration.ofSeconds(25)).until(
                    d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete")
            );

            String currentUrl = driver.getCurrentUrl();
            logger.info("📍 URL actuelle : " + currentUrl);

            // --- attendre champ email visible
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            logger.info("📄 Page login '" + roleName + "' chargée avec succès !");
        } catch (Exception e) {
            logger.error("❌ Erreur openRoleLoginPage: " + e.getMessage());
            takeScreenshot("openRoleLoginPage_error");
        }
    }

    // ===== ✉️ Saisir l'email =====
    public void enterEmail(String email) {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOf(emailField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
            field.click();
            field.clear();
            field.sendKeys(email);
            logger.info("📧 Email saisi : " + email);
        } catch (Exception e) {
            // fallback en JS si échec
            try {
                ((JavascriptExecutor) driver).executeScript("document.getElementById('email').value='" + email + "';");
                logger.info("📧 Email injecté via JavaScript : " + email);
            } catch (Exception js) {
                logger.error("❌ Erreur saisie email : " + js.getMessage());
            }
            takeScreenshot("email_error");
        }
    }

    // ===== 🔒 Saisir le mot de passe =====
    public void enterPassword(String password) {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOf(passwordField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
            field.click();
            field.clear();
            field.sendKeys(password);
            logger.info("🔒 Mot de passe saisi (sécurisé)");
        } catch (Exception e) {
            // fallback JS
            try {
                ((JavascriptExecutor) driver).executeScript("document.getElementById('mot_de_passe').value='" + password + "';");
                logger.info("🔒 Mot de passe injecté via JavaScript");
            } catch (Exception js) {
                logger.error("❌ Erreur saisie mot de passe : " + js.getMessage());
            }
            takeScreenshot("password_error");
        }
    }

    // ===== 🚀 Cliquer sur le bouton Connexion =====
    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
            logger.info("🚀 Bouton 'Connexion' cliqué avec succès !");
        } catch (Exception e) {
            logger.error("❌ Erreur clic sur Connexion : " + e.getMessage());
            takeScreenshot("click_error");
        }
    }

    // ===== ⚠️ Vérifier message d’erreur =====
    public boolean isErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            logger.warn("⚠️ Message d’erreur détecté : " + errorMessage.getText());
            return true;
        } catch (Exception e) {
            logger.info("✅ Aucun message d’erreur détecté.");
            return false;
        }
    }

    // ===== 📸 Capture d’écran =====
    public void takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "logs/screenshots/" + name + ".png";
            FileUtils.copyFile(src, new File(path));
            logger.info("📸 Screenshot sauvegardé : " + path);
        } catch (Exception e) {
            logger.error("Erreur capture écran : " + e.getMessage());
        }
    }
}
