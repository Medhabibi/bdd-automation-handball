@frontend @login @loginManager
Feature: Connexion Manager
  Permettre à un manager de se connecter au système Handball Management.

  Background:
    Given l'utilisateur est sur la page de connexion Manager

  @loginManager_success
  Scenario: Connexion réussie du manager
    When il saisit l'email manager "email_valide_manager"
    And il saisit le mot de passe manager "motdepasse_valide_manager"
    And il clique sur Connexion manager
    Then il doit être redirigé vers le tableau de bord commun

  @loginManager_invalid_email
  Scenario: Connexion échouée - email incorrect
    When il saisit l'email manager "email_incorrect"
    And il saisit le mot de passe manager "motdepasse_valide_manager"
    And il clique sur Connexion manager
    Then un message d'erreur email manager doit s'afficher

  @loginManager_invalid_password
  Scenario: Connexion échouée - mot de passe incorrect
    When il saisit l'email manager "email_valide_manager"
    And il saisit le mot de passe manager "motdepasse_incorrect"
    And il clique sur Connexion manager
    Then un message d'erreur mot de passe manager doit s'afficher
