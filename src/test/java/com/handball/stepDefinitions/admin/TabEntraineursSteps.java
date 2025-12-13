package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.pages.admin.TabEntraineursPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TabEntraineursSteps {

    WebDriver driver = Config.getDriver();
    TabEntraineursPage entraineurs = new TabEntraineursPage(driver);

    // -----------------------------------------------------------
    // Changer la table via le dropdown "Table ..."
    // -----------------------------------------------------------
    @Given("il change la table vers {string}")
    public void il_change_la_table_vers(String tableName) {

        WebElement dropdown = driver.findElement(
                By.xpath("//a[contains(@class,'dropdown-toggle') and contains(text(),'Table')]")
        );
        dropdown.click();

        try { Thread.sleep(500); } catch (Exception ignored) {}

        WebElement item = driver.findElement(
                By.xpath("//a[@class='dropdown-item' and text()='" + tableName + "']")
        );

        try {
            item.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
        }
    }

    // -----------------------------------------------------------
    // Recherche par statut pro
    // -----------------------------------------------------------
    @When("l'admin recherche un entraîneur par statut pro {string}")
    public void l_admin_recherche_un_entraîneur_par_statut_pro(String statutPro) {
        entraineurs.rechercher(statutPro);
    }

    @Then("au moins un résultat doit s’afficher")
    public void au_moins_un_résultat_doit_s_afficher() {
        // ✅ Vérification via une vraie ligne
        assertNotNull(
                "❌ Aucun résultat affiché",
                entraineurs.getRow("")
        );
    }

    // -----------------------------------------------------------
    // Recherche multi-pages (pagination incluse)
    // -----------------------------------------------------------
    @When("l'admin recherche l'entraîneur nommé {string} dans toutes les pages")
    public void l_admin_recherche_l_entraîneur_nommé_dans_toutes_les_pages(String nom) {
        boolean found = entraineurs.chercherDansToutesLesPages(nom);
        assertTrue("❌ Entraîneur " + nom + " introuvable dans toutes les pages", found);
    }

    @Then("l'entraîneur {string} doit être trouvé dans une des pages")
    public void l_entraîneur_doit_être_trouvé_dans_une_des_pages(String nom) {
        assertNotNull(
                "❌ Ligne non trouvée après pagination",
                entraineurs.getRow(nom)
        );
    }

    // -----------------------------------------------------------
    // Scroll horizontal pour afficher les boutons
    // -----------------------------------------------------------
    @When("l'admin scroll horizontalement la table entraîneurs")
    public void l_admin_scroll_horizontalement_la_table_entraîneurs() {
        entraineurs.scrollHorizontal();
    }

    // -----------------------------------------------------------
    // Vérification des boutons actions
    // -----------------------------------------------------------
    @Then("les boutons d'action {string}, {string}, {string} doivent être visibles pour l'entraîneur {string}")
    public void les_boutons_d_action_doivent_être_visibles_pour_l_entraîneur(
            String btn1, String btn2, String btn3, String nom) {

        boolean ok = entraineurs.boutonsActionsVisibles(nom);
        assertTrue(
                "❌ Les boutons " + btn1 + "/" + btn2 + "/" + btn3 + " ne sont pas visibles pour " + nom,
                ok
        );
    }
}
