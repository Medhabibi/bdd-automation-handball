@admin @navigation
Feature: Navigation de l'interface Admin
  L'administrateur doit pouvoir se connecter
  et afficher correctement toutes les sections du menu Admin.

  ############################################################
  # 🔧 Background - Connexion Admin
  ############################################################
  Background:
    Given que l'admin ouvre la page de connexion admin
    And il saisit l'email "AdminManagement"
    And il saisit le mot de passe admin valide
    And il clique sur le bouton Connexion
    Then la page "Admin.php" doit s'afficher

  ############################################################
  # 📌 TC-ADMIN-NAV-001 : Vérifier l'affichage du menu Admin
  ############################################################
  @menu_admin_affichage
  Scenario: Vérifier la présence des éléments du menu admin
    Then le menu "Dashboard" doit être visible
    And le menu "Historique" doit être visible
    And le menu "Messages non lus" doit être visible
    And le menu "Messages lus" doit être visible
    And le menu "Conversation" doit être visible
    And le menu "Tables" doit être visible
    And le menu "Tables d'annonces" doit être visible

  ############################################################
  # 📌 TC-ADMIN-NAV-002 : Vérifier la navigation de chaque menu
  ############################################################
  @menu_admin_navigation
  Scenario Outline: Navigation vers les pages du menu Admin
    When l'admin clique sur le menu "<menu>"
    Then la page "<page>" doit s'afficher

    Examples:
      | menu                | page                  |
      | Dashboard           | Admin.php             |
      | Historique          | historique_inscri.php |
      | Messages non lus    | messages_non_lus.php  |
      | Messages lus        | messages_lus.php      |
      | Conversation        | conversation.php      |
      | Tables              | tabJoueurs.php        |
      | Tables d'annonces   | tabClubChJ.php        |
