package com.handball.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageJoueurs {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageJoueurs(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // ✅ Locators
    @FindBy(css = "button.navbar-toggler")
    private WebElement menuToggleButton;

    @FindBy(css = "a.nav-link[href='les_interfaces/joueurs_club.php']")
    private WebElement joueurOption;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    // ✅ Ouvre la page d'accueil
    public void openHomePage() {
        driver.get("https://www.handball-management.com/");
        driver.manage().window().maximize();
        System.out.println("🌍 Page d'accueil ouverte et maximisée.");
    }

    // ✅ Sélection directe (desktop)
    public void selectJoueurDirect() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(joueurOption)).click();
            System.out.println("✅ Clic sur le lien 'Joueurs' effectué.");

            wait.until(ExpectedConditions.urlContains("inscri_joueurs.php"));
            Thread.sleep(1500);

            // 🔄 Force un refresh pour recharger les champs du formulaire
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
            System.out.println("🌍 Page d'inscription Joueur chargée et rafraîchie : " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("❌ Erreur lors de la sélection directe : " + e.getMessage());
        }
    }

    // ✅ Sélection via menu déroulant (mobile)
    public void selectJoueurViaMenu() {
        try {
            System.out.println("📱 Tentative d’ouverture du menu mobile...");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.navbar-toggler")));

            if (menuToggleButton.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(menuToggleButton)).click();
                System.out.println("✅ Bouton menu cliqué.");
            } else {
                System.out.println("⚠️ Bouton menu non visible — clic forcé via JS.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuToggleButton);
            }

            wait.until(ExpectedConditions.elementToBeClickable(joueurOption)).click();
            System.out.println("✅ Lien 'Joueurs' cliqué depuis le menu.");

            wait.until(ExpectedConditions.urlContains("inscri_joueurs.php"));
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
            System.out.println("🌍 Page d'inscription Joueur chargée après menu : " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("❌ Erreur lors de la sélection via menu déroulant : " + e.getMessage());
        }
    }

    // ✅ Saisie visible et lente (slow-motion)
    public void enterCredentials(String email, String motDePasse) {
        try {
            System.out.println("🕵️ Vérification champ email sur : " + driver.getCurrentUrl());

            wait.until(ExpectedConditions.visibilityOf(emailField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].focus();", emailField);
            Thread.sleep(800);

            // Efface et saisit lentement chaque caractère
            emailField.clear();
            for (char c : email.toCharArray()) {
                emailField.sendKeys(String.valueOf(c));
                Thread.sleep(120); // ⏳ vitesse de frappe visible
            }
            System.out.println("✍️ Email saisi lentement : " + email);

            wait.until(ExpectedConditions.visibilityOf(passwordField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].focus();", passwordField);
            Thread.sleep(600);

            passwordField.clear();
            for (char c : motDePasse.toCharArray()) {
                passwordField.sendKeys(String.valueOf(c));
                Thread.sleep(120);
            }
            System.out.println("✍️ Mot de passe saisi lentement : " + motDePasse);

            Thread.sleep(1000); // pause visible avant clic

        } catch (Exception e) {
            System.out.println("❌ Erreur lors de la saisie des identifiants : " + e.getMessage());
        }
    }

    // ✅ Clic visible et réaliste sur "Connexion"
    public void clickLoginButton() {
        try {
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].focus();", submitButton);
            Thread.sleep(700);

            // Mouvement visible avant clic
            System.out.println("👆 Clic sur le bouton 'Connexion'...");
            submitButton.click();
            Thread.sleep(1500);

            System.out.println("✅ Bouton 'Connexion' cliqué avec succès.");
            Thread.sleep(2000);
            System.out.println("🌍 Nouvelle URL après connexion : " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("❌ Erreur lors du clic sur le bouton 'Connexion' : " + e.getMessage());
        }
    }
}
