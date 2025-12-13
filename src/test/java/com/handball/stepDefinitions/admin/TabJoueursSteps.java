package com.handball.stepDefinitions.admin;

import com.handball.helper.Config;
import com.handball.pages.admin.TabJoueursPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TabJoueursSteps {

    WebDriver driver = Config.getDriver();
    TabJoueursPage joueurs = new TabJoueursPage(driver);

    // 🌍 UTILITAIRE POUR REMETTRE LE CHAMP RECHERCHE SOUS LES YEUX
    private void scrollToSearchBar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", joueurs.champRecherche);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(joueurs.champRecherche));
    }


    // ============================ A — COLONNES ============================
    @Then("le tableau des joueurs doit être visible")
    public void tableau_visible() { assertTrue(joueurs.tableauJoueurs.isDisplayed()); }

    @Then("la colonne {string} doit être visible")
    public void colonne_visible(String nom) {

        switch (nom) {
            case "ID_joueurs": assertTrue(joueurs.colId.isDisplayed()); break;
            case "Nom": assertTrue(joueurs.colNom.isDisplayed()); break;
            case "Prenom": assertTrue(joueurs.colPrenom.isDisplayed()); break;
            case "Date de naissance": assertTrue(joueurs.colDateNaissance.isDisplayed()); break;
            case "Pays": assertTrue(joueurs.colPays.isDisplayed()); break;
            case "Email": assertTrue(joueurs.colEmail.isDisplayed()); break;
            case "Tél": assertTrue(joueurs.colTel.isDisplayed()); break;
            case "Sexe": assertTrue(joueurs.colSexe.isDisplayed()); break;
            case "Taille": assertTrue(joueurs.colTaille.isDisplayed()); break;
            case "Poids": assertTrue(joueurs.colPoids.isDisplayed()); break;
            case "Postes": assertTrue(joueurs.colPostes.isDisplayed()); break;
            case "Type de contrat": assertTrue(joueurs.colTypeContrat.isDisplayed()); break;
            case "Statut pro": assertTrue(joueurs.colStatutPro.isDisplayed()); break;
            case "Equipe actuelle": assertTrue(joueurs.colEquipeActuelle.isDisplayed()); break;
            case "Division": assertTrue(joueurs.colDivision.isDisplayed()); break;
            case "Pays d'équipe act": assertTrue(joueurs.colPaysEquipeAct.isDisplayed()); break;
            case "Instagram": assertTrue(joueurs.colInstagram.isDisplayed()); break;
            case "Facebook": assertTrue(joueurs.colFacebook.isDisplayed()); break;
            case "Linkedin": assertTrue(joueurs.colLinkedin.isDisplayed()); break;
            case "Youtube": assertTrue(joueurs.colYoutube.isDisplayed()); break;
            case "Photo de profil": assertTrue(joueurs.colPhotoProfil.isDisplayed()); break;
            case "Photo de licence": assertTrue(joueurs.colPhotoLicence.isDisplayed()); break;
            case "CV": assertTrue(joueurs.colCV.isDisplayed()); break;
            case "Vidéo": assertTrue(joueurs.colVideo.isDisplayed()); break;
            case "Visible": assertTrue(joueurs.colVisible.isDisplayed()); break;
            case "Statut d'inscri": assertTrue(joueurs.colStatutInscri.isDisplayed()); break;
            case "Dernière visite": assertTrue(joueurs.colDerniereVisite.isDisplayed()); break;
            case "Mot de passe": assertTrue(joueurs.colMDP.isDisplayed()); break;
            case "Action": assertTrue(joueurs.colAction.isDisplayed()); break;
            default: throw new AssertionError("Colonne inconnue → " + nom);
        }
    }

    // ============================  B — RECHERCHE ============================
    private List<WebElement> getResults() {
        return driver.findElements(By.xpath("//tbody//tr/td"));
    }

    @Then("la table doit afficher uniquement les joueurs dont le nom contient {string}")
    public void verify_recherche_nom(String nom) {

        List<WebElement> noms = driver.findElements(By.xpath("//table//tbody//tr/td[2]")); // COLONNE NOM

        assertTrue("❌ Aucun résultat pour : " + nom, noms.size() > 0);

        for (WebElement cell : noms) {
            String text = cell.getText().toLowerCase();
            assertTrue("⚠ Mauvais résultat → " + text + " ne contient pas " + nom.toLowerCase(),
                    text.contains(nom.toLowerCase()));
        }

        System.out.println("✔ Recherche OK sur la colonne NOM uniquement");
    }




    @Then("la table doit afficher uniquement les joueurs dont l'email contient {string}")
    public void verify_recherche_email(String email) {
        assertTrue(getResults().size() > 0);
        getResults().forEach(cell -> {
            if (cell.getText().contains("@"))
                assertTrue(cell.getText().toLowerCase().contains(email.toLowerCase()));
        });
    }

    @Then("la table doit afficher uniquement les joueurs dont le pays contient {string}")
    public void verify_recherche_pays(String pays) {
        assertTrue(getResults().size() > 0);
        getResults().forEach(cell -> {
            if (cell.getText().length() > 3)
                assertTrue(cell.getText().toLowerCase().contains(pays.toLowerCase()));
        });
    }
    // ============================ B — SAISIE DANS BARRE RECHERCHE ============================

    @When("l'admin saisit {string} dans la barre de recherche")
    public void saisir_recherche(String nom) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 🔥 rendre la barre visible avant clic
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", joueurs.champRecherche);

        wait.until(ExpectedConditions.elementToBeClickable(joueurs.champRecherche));

        // 🔥 alternative : si le clic échoue → clic JS forcé
        try {
            joueurs.champRecherche.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", joueurs.champRecherche);
        }

        // 🟩 taper la valeur
        joueurs.champRecherche.clear();
        joueurs.champRecherche.sendKeys(nom);
    }



    // ============================  C — PAGINATION ============================

    // ======================================
    //  PAGINATION — SELECT NB LIGNES
    // ======================================
    @When("l'admin sélectionne {string} entrées par page")
    public void select_nb_lignes(String nb) {
        Select select = new Select(joueurs.selectorLignes);
        select.selectByVisibleText(nb);
    }

    @Then("le tableau doit afficher au maximum {string} lignes")
    public void verif_nb_lignes_max(String nb) {
        int max = Integer.parseInt(nb);
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(d -> joueurs.listeLignes.size() > 0);
        assertTrue("❌ Trop de lignes visibles !", joueurs.listeLignes.size() <= max);
    }



    // ======================================
//  PAGINATION — BAS DE TABLEAU
// ======================================

    private void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try { Thread.sleep(700); } catch (Exception ignored) {}
    }


    @When("l'admin clique sur page suivante")
    public void click_suivant() {
        scrollToBottom(); // REND LE BOUTON VISIBLE
        joueurs.btnPageSuivant.click();
    }

    @When("l'admin clique sur page précédente")
    public void click_precedent() {
        scrollToBottom();
        joueurs.btnPagePrecedent.click();
    }

    @When("l'admin clique sur la page {string}")
    public void click_page_specifique(String page) {
        scrollToBottom();
        driver.findElement(By.xpath("//a[@data-page='"+page+"']")).click();
    }
    @Then("la page active doit être > 1")
    public void verif_page_suivante() {
        String page = joueurs.paginationActive.getText();
        System.out.println("Page active détectée = " + page);
        assertTrue("❌ La page n'a pas avancé !", Integer.parseInt(page) > 1);
    }


    @Then("la page active doit être {string}")
    public void verif_page_specifique(String page) {
        assertTrue("❌ Mauvaise page active !", joueurs.paginationActive.getText().equals(page));
    }


    @Then("la page active doit être 1")
    public void verif_page_precedente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement activePage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("li.datatable-pagination-list-item.datatable-active > a")
        ));
        assertTrue("❌ On n'est pas revenu page 1", activePage.getText().equals("1"));
        System.out.println("✔ Page précédente validée → Retour sur 1 OK");
    }


}
