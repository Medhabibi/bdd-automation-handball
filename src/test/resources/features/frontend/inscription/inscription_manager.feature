@frontend @inscription @manager

Feature: Inscription Manager

  @blocage_nom_club
  Scenario: Blocage sur le champ Nom d'équipe non valide
    Given l'utilisateur ouvre la page d'inscription Manager
    And il clique sur l'onglet Inscription
    When l'utilisateur laisse le champ "Nom d'équipe" vide ou invalide
    And il tente de naviguer vers un autre champ
    Then le focus reste bloqué sur le champ "Nom d'équipe"
    And le message "Le nom du club doit contenir uniquement des lettres" doit s'afficher

  @blocage_manager_club
  Scenario: Blocage sur le champ Manager d'équipe non valide
    Given l'utilisateur ouvre la page d'inscription Manager
    And il clique sur l'onglet Inscription
    And l'utilisateur remplit le champ "Nom d'équipe" avec "Barcelona"
    When il laisse le champ "Manager d'équipe" vide ou invalide
    And il tente de naviguer vers un autre champ
    Then le focus reste bloqué sur le champ "Manager d'équipe"
    And le message "Le nom du manager doit contenir uniquement des lettres" doit s'afficher

  @inscription_manager_success
  Scenario: Inscription Manager réussie avec données valides
    Given l'utilisateur ouvre la page d'inscription Manager
    And il clique sur l'onglet Inscription
    And l'utilisateur remplit le champ "Nom d'équipe" avec "Barcelona"
    And il remplit le champ "Manager d'équipe" avec "Xavi"
    And il remplit les autres champs facultatifs avec des données valides
    When il clique sur "INSCRIPTION"
    Then un message de succès doit s'afficher
    And l'utilisateur est redirigé vers la page de connexion Manager
