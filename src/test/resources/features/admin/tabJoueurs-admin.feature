@admin @table_joueurs @A
Feature: Table Joueurs - Affichage et présence des colonnes
  L’administrateur doit pouvoir afficher la table des joueurs
  et voir toutes les colonnes prévues dans l’interface.

  Background:
    Given que l'admin ouvre la page de connexion admin
    And il saisit l'email "AdminManagement"
    And il saisit le mot de passe admin valide
    And il clique sur le bouton Connexion
    And il clique sur le menu "Tables"
    Then la page "tabJoueurs.php" doit s'afficher

  @table_affichage
  Scenario: Vérifier que le tableau des joueurs s'affiche correctement
    Then le tableau des joueurs doit être visible

  @colonnes_joueurs
  Scenario: Vérifier la présence de toutes les colonnes du tableau joueurs
    Then la colonne "ID_joueurs" doit être visible
    And la colonne "Nom" doit être visible
    And la colonne "Prenom" doit être visible
    And la colonne "Date de naissance" doit être visible
    And la colonne "Pays" doit être visible
    And la colonne "Email" doit être visible
    And la colonne "Tél" doit être visible
    And la colonne "Sexe" doit être visible
    And la colonne "Taille" doit être visible
    And la colonne "Poids" doit être visible
    And la colonne "Postes" doit être visible
    And la colonne "Type de contrat" doit être visible
    And la colonne "Statut pro" doit être visible
    And la colonne "Equipe actuelle" doit être visible
    And la colonne "Division" doit être visible
    And la colonne "Pays d'équipe act" doit être visible
    And la colonne "Instagram" doit être visible
    And la colonne "Facebook" doit être visible
    And la colonne "Linkedin" doit être visible
    And la colonne "Youtube" doit être visible
    And la colonne "Photo de profil" doit être visible
    And la colonne "Photo de licence" doit être visible
    And la colonne "CV" doit être visible
    And la colonne "Vidéo" doit être visible
    And la colonne "Visible" doit être visible
    And la colonne "Statut d'inscri" doit être visible
    And la colonne "Dernière visite" doit être visible
    And la colonne "Mot de passe" doit être visible
    And la colonne "Action" doit être visible
