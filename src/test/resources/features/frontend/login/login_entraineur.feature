@frontend @login @loginEntraineur
Feature: Connexion Entraîneur
  Validation de l'authentification pour l'entraîneur.

  Background:
    Given l'utilisateur est sur la page de connexion Entraîneur

  @login_success
  Scenario: Connexion réussie de l'entraîneur
    When il saisit l'email entraineur "email_valide_joueur"
    And il saisit le mot de passe entraineur "motdepasse_valide_joueur"
    And il clique sur Connexion entraineur
    Then il doit être redirigé vers le tableau de bord entraîneur

  @login_invalid_email
  Scenario: Connexion échouée - email incorrect
    When il saisit l'email entraineur "email_incorrect"
    And il saisit le mot de passe entraineur "motdepasse_valide_joueur"
    And il clique sur Connexion entraineur
    Then un message d'erreur email entraineur doit s'afficher

  @login_invalid_password
  Scenario: Connexion échouée - mot de passe incorrect
    When il saisit l'email entraineur "email_valide_joueur"
    And il saisit le mot de passe entraineur "motdepasse_incorrect"
    And il clique sur Connexion entraineur
    Then un message d'erreur mot de passe entraineur doit s'afficher
