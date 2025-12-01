@admin @dashboard
Feature: Dashboard Admin - Vérification des cards principales
  L'administrateur doit pouvoir cliquer sur chaque card
  et être redirigé vers la bonne page.

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
  # 📌 TC-ADMIN-DASH-001 : Vérifier les cards du Dashboard
  ############################################################
  @dashboard_cards_navigation
  Scenario Outline: Vérifier la navigation via les cards du Dashboard
    When l'admin clique sur la card "<card>"
    Then la page "<page>" doit s'afficher

    Examples:
      | card                         | page               |
      | Joueurs                      | tabJoueurs.php     |
      | Entraîneurs                  | tabEntraineurs.php |
      | Préparateurs                 | tabPreparateurs.php |
      | Managers                     | tabManagers.php     |
      | Annonces joueurs             | tabClubChJ.php      |
      | Annonces entraîneurs         | tabClubChE.php      |
      | Annonces préparateurs        | tabClubChP.php      |
      | Messages lus                 | messages_lus.php    |
      | Messages non lus             | messages_non_lus.php |
