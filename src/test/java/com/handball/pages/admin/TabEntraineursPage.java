package com.handball.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TabEntraineursPage {

    WebDriver driver;

    public TabEntraineursPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===========================================================
    // 🔹 TABLEAU + CONTAINER
    // ===========================================================
    @FindBy(id = "datatablesSimple")
    private WebElement tableauEntraineurs;

    @FindBy(css = ".datatable-container")
    private WebElement containerTableau;

    // ===========================================================
    // 🔹 BARRE DE RECHERCHE
    // ===========================================================
    @FindBy(css = "input.datatable-input[placeholder='Search...']")
    private WebElement champRecherche;

    public void rechercher(String texte) {
        champRecherche.clear();
        champRecherche.sendKeys(texte);
    }

    // ===========================================================
    // 🔹 PAGINATION
    // ===========================================================
    @FindBy(xpath = "//a[contains(text(),'›')]")
    private WebElement btnPageSuivant;

    // ===========================================================
    // 🔹 MÉTHODE CRUCIALE : LIGNES (DYNAMIQUE)
    // ===========================================================
    private List<WebElement> getLignes() {
        return driver.findElements(By.cssSelector("#datatablesSimple tbody tr"));
    }

    // ===========================================================
    // 🔹 SCROLLS
    // ===========================================================
    public void scrollVerticalBas() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollHorizontal() {
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollLeft = arguments[0].scrollWidth;",
                        containerTableau
                );
    }

    // ===========================================================
    // 🔥 RECHERCHE PAGINÉE STABLE
    // ===========================================================
    public boolean chercherDansToutesLesPages(String nomCible) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        while (true) {

            // 🔍 Parcours page courante
            for (WebElement ligne : getLignes()) {
                if (ligne.getText().toLowerCase().contains(nomCible.toLowerCase())) {
                    return true;
                }
            }

            // ➡️ Bouton suivant ?
            try {
                if (!btnPageSuivant.isDisplayed() || !btnPageSuivant.isEnabled()) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

            // 🔽 Scroll + clic JS (ANTI ElementClickIntercepted)
            js.executeScript("arguments[0].scrollIntoView(true);", btnPageSuivant);
            js.executeScript("arguments[0].click();", btnPageSuivant);

            // ⏳ Attente rechargement DataTable
            try { Thread.sleep(700); } catch (Exception ignored) {}
        }
    }

    // ===========================================================
    // 🔹 RÉCUPÉRER UNE LIGNE PAR NOM
    // ===========================================================
    public WebElement getRow(String nomCible) {

        for (WebElement ligne : getLignes()) {
            if (ligne.getText().toLowerCase().contains(nomCible.toLowerCase())) {
                return ligne;
            }
        }
        return null;
    }

    // ===========================================================
    // 🔹 VÉRIFIER BOUTONS ACTIONS
    // ===========================================================
    public boolean boutonsActionsVisibles(String nomCible) {

        WebElement ligne = getRow(nomCible);
        if (ligne == null) return false;

        try {
            WebElement view = ligne.findElement(By.cssSelector("a.btn-outline-success"));
            WebElement edit = ligne.findElement(By.cssSelector("a.btn-outline-primary"));
            WebElement delete = ligne.findElement(By.cssSelector("a.btn-outline-danger"));

            return view.isDisplayed() && edit.isDisplayed() && delete.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
