package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminNavigationPage {

    WebDriver driver;

    public AdminNavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =============================
    // 🔹 Menus latéraux (HTML réel)
    // =============================

    @FindBy(xpath = "//a[@href='Admin.php']")
    public WebElement menuDashboard;

    @FindBy(xpath = "//a[@href='historique_inscri.php']")
    public WebElement menuHistorique;

    @FindBy(xpath = "//a[@href='messages_non_lus.php']")
    public WebElement menuMessagesNonLus;

    @FindBy(xpath = "//a[@href='messages_lus.php']")
    public WebElement menuMessagesLus;

    @FindBy(xpath = "//a[@href='conversation.php']")
    public WebElement menuConversation;

    @FindBy(xpath = "//a[@href='tabJoueurs.php']")
    public WebElement menuTables;

    @FindBy(xpath = "//a[@href='tabClubChJ.php']")
    public WebElement menuTablesAnnonces;
}
