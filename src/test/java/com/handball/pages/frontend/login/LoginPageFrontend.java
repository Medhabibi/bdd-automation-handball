package com.handball.pages.frontend.login;

import com.handball.helper.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageFrontend {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPageFrontend(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    // ============================
    // Flèches navigation
    // ============================
    @FindBy(css = "span.arrow.right")
    private WebElement arrowRight;

    @FindBy(css = "span.arrow.left")
    private WebElement arrowLeft;

    // ============================
    // Logo accueil
    // ============================
    @FindBy(css = "img.logo-img")
    private WebElement homeLogo;

    // ============================
    // Actions navigation
    // ============================
    public void cliquerFlecheDroite() {
        wait.until(ExpectedConditions.elementToBeClickable(arrowRight)).click();
    }

    public void cliquerFlecheGauche() {
        wait.until(ExpectedConditions.elementToBeClickable(arrowLeft)).click();
    }

    public void cliquerLogoAccueil() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLogo)).click();
    }

    // ============================
    // Ouvrir une interface Login
    // ============================
    public void openLoginPage(String roleKey) {
        String url = Config.getProperty(roleKey);
        driver.get(url);
    }
}
