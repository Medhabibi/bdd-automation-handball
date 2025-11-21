package com.handball.pages.frontend.login;

import com.handball.helper.Config;
import com.handball.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginEntraineurPage extends BasePage {

    WebDriver driver;

    public LoginEntraineurPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='userform']/ul/li[1]/a")
    private WebElement ongletConnexion;

    @FindBy(id = "email_entraineur")
    private WebElement emailInput;

    @FindBy(id = "mot_de_passe")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement boutonConnexion;

    @FindBy(xpath = "//div[contains(text(),\"L'email n'existe pas.\")]")
    private WebElement erreurEmail;

    @FindBy(xpath = "//div[contains(text(),'Le mot de passe n')]")
    private WebElement erreurMotDePasse;

    public void ouvrirPageLogin() {
        driver.get(Config.getProperty("login.entraineur"));
        sleep(1500);
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

    public boolean estSurDashboard() {
        return driver.getCurrentUrl().contains("joueurs_club.php");
    }

    public boolean erreurEmailVisible() {
        return isVisible(erreurEmail);
    }

    public boolean erreurMotDePasseVisible() {
        return isVisible(erreurMotDePasse);
    }
}
