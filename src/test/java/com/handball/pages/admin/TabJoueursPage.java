package com.handball.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabJoueursPage {

    WebDriver driver;

    public TabJoueursPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==========================================
    // TABLE PRINCIPALE
    // ==========================================
    @FindBy(id = "datatablesSimple")
    public WebElement tableauJoueurs;


    // ==========================================
    // BARRE DE RECHERCHE
    // ==========================================
    @FindBy(css = "input.datatable-input[placeholder='Search...']")
    public WebElement champRecherche;

    public void rechercher(String valeur) {
        champRecherche.clear();
        champRecherche.sendKeys(valeur);
    }


    // ==========================================
// 🔥 PAGINATION
// ==========================================

    // 🔥 Page active = LI parent contenant la classe "datatable-active"
    @FindBy(css = "li.datatable-pagination-list-item.datatable-active a.datatable-pagination-list-item-link")
    public WebElement paginationActive;


    // ➤ Pagination
    // Page suivante ›
    @FindBy(xpath = "//a[contains(text(),'›')]")
    public WebElement btnPageSuivant;
    // Page précédente ‹
    @FindBy(xpath = "//a[contains(text(),'‹')]")
    public WebElement btnPagePrecedent;

    // ➤ Select lignes
    @FindBy(css = "select.datatable-selector")
    public WebElement selectorLignes;

    // ➤ Lignes visibles tableau
    @FindBy(css = "#datatablesSimple tbody tr")
    public java.util.List<WebElement> listeLignes;



    // ==========================================
    // COLONNES
    // ==========================================
    @FindBy(xpath = "//a[text()='ID_joueurs']") public WebElement colId;
    @FindBy(xpath = "//a[text()='Nom']") public WebElement colNom;

    // ---- fix UTF-8 sur accents ----
    @FindBy(xpath = "//a[contains(translate(text(),'ÉÈÊËéèêë','EEEEeeee'),'Prenom')]")
    public WebElement colPrenom;

    @FindBy(xpath = "//a[text()='Date de naissance']") public WebElement colDateNaissance;
    @FindBy(xpath = "//a[text()='Pays']") public WebElement colPays;
    @FindBy(xpath = "//a[text()='Email']") public WebElement colEmail;

    // ---- fix accent "Tél" ----
    @FindBy(xpath = "(//th[@data-sortable='true'])[7]")
    public WebElement colTel;

    @FindBy(xpath = "//a[text()='Sexe']") public WebElement colSexe;
    @FindBy(xpath = "//a[text()='Taille']") public WebElement colTaille;
    @FindBy(xpath = "//a[text()='Poids']") public WebElement colPoids;
    @FindBy(xpath = "//a[text()='Postes']") public WebElement colPostes;
    @FindBy(xpath = "//a[text()='Type de contrat']") public WebElement colTypeContrat;
    @FindBy(xpath = "//a[text()='Statut pro']") public WebElement colStatutPro;
    @FindBy(xpath = "//a[text()='Equipe actuelle']") public WebElement colEquipeActuelle;
    @FindBy(xpath = "//a[text()='Division']") public WebElement colDivision;

    // ---- accent "Pays d’équipe act" ----
    @FindBy(xpath = "(//th[@data-sortable='true'])[16]") public WebElement colPaysEquipeAct;

    @FindBy(xpath = "//a[text()='Instagram']") public WebElement colInstagram;
    @FindBy(xpath = "//a[text()='Facebook']") public WebElement colFacebook;
    @FindBy(xpath = "//a[text()='Linkedin']") public WebElement colLinkedin;
    @FindBy(xpath = "//a[text()='Youtube']") public WebElement colYoutube;

    // ---- accent "Vidéo" ----
    @FindBy(xpath = "//a[contains(translate(text(),'ÉÈÊËéèêë','EEEEeeee'),'Video')]")
    public WebElement colVideo;

    @FindBy(xpath = "//a[text()='Photo de profil']") public WebElement colPhotoProfil;
    @FindBy(xpath = "//a[text()='Photo de licence']") public WebElement colPhotoLicence;
    @FindBy(xpath = "//a[text()='CV']") public WebElement colCV;
    @FindBy(xpath = "//a[text()='Visible']") public WebElement colVisible;

    // ---- accent "Statut d'inscri" ----
    @FindBy(xpath = "//a[contains(normalize-space(text()),\"Statut d'inscri\")]")
    public WebElement colStatutInscri;


    // ---- accent "Dernière visite" ----
    @FindBy(xpath = "//a[contains(translate(text(),'ÉÈÊËéèêë','EEEEeeee'),'Derniere visite')]")
    public WebElement colDerniereVisite;

    @FindBy(xpath = "//a[text()='Mot de passe']") public WebElement colMDP;
    @FindBy(xpath = "//a[text()='Action']") public WebElement colAction;

}
