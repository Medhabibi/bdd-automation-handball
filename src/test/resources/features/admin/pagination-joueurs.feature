@admin @table_joueurs @pagination
Feature: Pagination du tableau joueurs (Admin)

  Background:
    Given que l'admin est connecté
    And il clique sur le menu "Tables"
    And il ouvre la section joueurs depuis la card
    Then la page "tabJoueurs.php" doit s'afficher


  @pagination_lignes
  Scenario Outline: Changer le nombre d'entrées visibles
    When l'admin sélectionne "<lignes>" entrées par page
    Then le tableau doit afficher au maximum "<lignes>" lignes
    Examples:
      | lignes |
      | 5      |
      | 10     |
      | 15     |
      | 20     |


  @pagination_next
  Scenario: Aller à la page suivante
    When l'admin clique sur page suivante
    Then la page active doit être > 1

  @pagination_prev
  Scenario: Revenir à la page précédente
    Given l'admin clique sur page suivante
    When l'admin clique sur page précédente
    Then la page active doit être 1

  @pagination_page
  Scenario: Aller à une page spécifique
    When l'admin clique sur la page "3"
    Then la page active doit être "3"
