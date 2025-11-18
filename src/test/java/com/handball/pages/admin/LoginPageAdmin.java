package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe représentant la page de connexion de l'administrateur Handball Management.
 * Utilise le modèle Page Object Model (POM) avec PageFactory et XPath.
 */
public class LoginPageAdmin {

    // =============================
    // 🔹 Déclaration du WebDriver
    // =============================
    WebDriver driver;

    // =============================
    // 🔹 Constructeur
    // =============================
    public LoginPageAdmin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // initialise les @FindBy
    }

    // =============================
    // 🔹 Localisateurs des éléments
    // =============================

    @FindBy(name = "adresse")
    private WebElement emailInput;

    @FindBy(name = "mot_de_passe")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Connexion')]")
    private WebElement connexionButton;

    // =============================
    // 🔹 Méthodes d’action (Steps)
    // =============================

    /** Ouvre directement la page de connexion de l’admin */
    public void ouvrirPageConnexion() {
        driver.get("https://www.handball-management.com/interface_admin/login.php");
    }

    /** Saisit le nom d'utilisateur (adresse e-mail) */
    public void saisirNomUtilisateur(String username) {
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    /** Saisit le mot de passe */
    public void saisirMotDePasse(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /** Clique sur le bouton Connexion */
    public void cliquerConnexion() {
        connexionButton.click();
    }

    /** Récupère le titre de la page actuelle (utile pour la validation après login) */
    public String getTitrePage() {
        return driver.getTitle();
    }
}
