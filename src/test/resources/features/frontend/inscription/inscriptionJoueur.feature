@frontend @inscription @auto
Feature: Inscription Joueur
  Validation complète de l'inscription joueur avec données valides et invalides.

  Background:
    Given l'utilisateur est sur la page d'inscription joueur
    And il clique sur l'onglet inscription joueur

  @inscription_success
  Scenario: Inscription réussie du joueur
    When il saisit l'adresse email du joueur "email_valide"
    And il saisit le nom joueur "nom_valide"
    And il saisit le prenom joueur "prenom_valide"
    And il saisit la date de naissance joueur "date_valide"
    And il choisit le pays liste "pays_liste_valide"
    And il choisit l'indicatif telephone "indicatif_valide"
    And il saisit le telephone joueur "telephone_valide"
    And il saisit la taille joueur "taille_valide"
    And il saisit le poids joueur "poids_valide"
    And il choisit le sexe joueur "sexe_valide"
    And il choisit le poste joueur "poste_valide"
    And il choisit le type de contrat joueur "type_contrat_valide"
    And il charge une photo de profil joueur "photo_valide"
    And il saisit le mot de passe inscription "motdepasse_valide"
    And il confirme le mot de passe inscription "confirmation_valide"
    And il clique sur le bouton inscription joueur
    Then l'inscription joueur doit reussir

  @inscription_invalid
  Scenario: Inscription échouée — données invalides
    When il saisit le nom joueur "nom_invalide"
    And il saisit le prenom joueur "prenom_invalide"
    And il saisit le telephone joueur "telephone_invalide"
    And il saisit la taille joueur "taille_invalide"
    And il saisit le poids joueur "poids_invalide"
    And il saisit le mot de passe inscription "motdepasse_invalide"
    And il confirme le mot de passe inscription "confirmation_incorrecte"
    And il clique sur le bouton inscription joueur
    Then un message d'erreur inscription doit s'afficher
