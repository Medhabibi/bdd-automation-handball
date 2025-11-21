package com.handball.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ==========================================
    // 🔹 WAIT
    // ==========================================
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ==========================================
    // 🔹 WRITE
    // ==========================================
    public void write(WebElement element, String text) {
        waitForVisibility(element);
        scrollTo(element);
        element.clear();
        element.sendKeys(text);
    }

    // ==========================================
    // 🔹 CLICK
    // ==========================================
    public void click(WebElement element) {
        waitForVisibility(element);
        scrollTo(element);
        element.click();
    }

    // ==========================================
    // 🔹 Vérifier si un élément est visible
    // ==========================================
    public boolean isVisible(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ==========================================
    // 🔹 Scroll automatique pour éviter non-interactable
    // ==========================================
    public void scrollTo(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception ignored) {}
    }

    // ==========================================
    // 🔹 Exécution JS utile pour activer un onglet
    // ==========================================
    public void executeJS(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
