package com.handball.pages.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EntraineurDetailsModal {

    WebDriver driver;

    public EntraineurDetailsModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".modal.show")
    public WebElement modal;

    @FindBy(css = ".modal.show button.close, .modal.show .btn-close, .modal.show button[data-bs-dismiss='modal']")
    public WebElement closeButton;

    public boolean isVisible() {
        try { return modal.isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public String getModalText() {
        return modal.getText();
    }

    public void close() {
        try { closeButton.click(); }
        catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
        }
    }
}
