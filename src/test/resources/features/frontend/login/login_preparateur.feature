@frontend @login @loginPreparateur
Feature: Connexion Préparateur Physique
  Afin d'accéder à son espace dédié,
  un préparateur doit pouvoir se connecter depuis le formulaire dédié.

  Background:
    Given l'utilisateur est sur la page de connexion Préparateur

  @login_preparateur_success
  Scenario: Connexion réussie du préparateur
    When il saisit l'email préparateur "email_valide_preparateur"
    And il saisit le mot de passe préparateur "motdepasse_valide_preparateur"
    And il clique sur Connexion préparateur
    Then il doit être redirigé vers le tableau de bord préparateur

  @login_preparateur_invalid_email
  Scenario: Connexion échouée - email incorrect
    When il saisit l'email préparateur "email_incorrect"
    And il saisit le mot de passe préparateur "motdepasse_valide_preparateur"
    And il clique sur Connexion préparateur
    Then un message d'erreur email préparateur doit s'afficher

  @login_preparateur_invalid_password
  Scenario: Connexion échouée - mot de passe incorrect
    When il saisit l'email préparateur "email_valide_preparateur"
    And il saisit le mot de passe préparateur "motdepasse_incorrect"
    And il clique sur Connexion préparateur
    Then un message d'erreur mot de passe préparateur doit s'afficher
