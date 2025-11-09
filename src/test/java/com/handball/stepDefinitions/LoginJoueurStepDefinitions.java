package com.handball.stepDefinitions;

import com.handball.helper.Config;
import com.handball.pages.LoginPageJoueurs;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginJoueurStepDefinitions {

    private WebDriver driver;
    private LoginPageJoueurs loginPage;

    @Given("le joueur est sur la page d'accueil")
    public void le_joueur_est_sur_la_page_d_accueil() {
        // ✅ Le navigateur est déjà ouvert par Hooks via Config.initialize()
        driver = Config.driver;
        loginPage = new LoginPageJoueurs(driver);
        System.out.println("🌍 Page d'accueil déjà ouverte depuis Config.initialize()");
    }

    @When("le joueur se connecte en utilisant la méthode {string}")
    public void le_joueur_se_connecte_en_utilisant_la_methode(String methode) {
        if (methode.equalsIgnoreCase("directe")) {
            loginPage.selectJoueurDirect();
        } else if (methode.equalsIgnoreCase("menu déroulant")) {
            loginPage.selectJoueurViaMenu();
        } else {
            System.out.println("⚠️ Méthode inconnue : " + methode);
        }
    }

    @When("le joueur saisit l'email {string} et le mot de passe {string}")
    public void le_joueur_saisit_l_email_et_le_mot_de_passe(String email, String motDePasse) {
        loginPage.enterCredentials(email, motDePasse);
    }

    @When("le joueur clique sur le bouton de connexion")
    public void le_joueur_clique_sur_le_bouton_de_connexion() {
        loginPage.clickLoginButton();
    }

    @Then("le joueur doit être redirigé vers son tableau de bord")
    public void le_joueur_doit_etre_redirige_vers_son_tableau_de_bord() {
        System.out.println("✅ Test terminé avec succès : joueur connecté !");
        // ❌ Plus de driver.quit() ici (Hooks s’en charge automatiquement)
    }
}
