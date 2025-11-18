@frontend @login @loginJoueur
Feature: Connexion Joueur
  Validation de l'authentification du joueur et gestion des erreurs.

  Background:
    Given l'utilisateur est sur la page de connexion Joueur

  @login_success
  Scenario: Connexion réussie du joueur
    When il saisit l'email joueur "email_valide_joueur"
    And il saisit le mot de passe joueur "motdepasse_valide_joueur"
    And il clique sur Connexion joueur
    Then il doit être redirigé vers le tableau de bord joueur

  @login_invalid_email
  Scenario: Connexion échouée - email incorrect
    When il saisit l'email joueur "email_incorrect"
    And il saisit le mot de passe joueur "motdepasse_valide_joueur"
    And il clique sur Connexion joueur
    Then un message d'erreur email joueur doit s'afficher

  @login_invalid_password
  Scenario: Connexion échouée - mot de passe incorrect
    When il saisit l'email joueur "email_valide_joueur"
    And il saisit le mot de passe joueur "motdepasse_incorrect"
    And il clique sur Connexion joueur
    Then un message d'erreur mot de passe joueur doit s'afficher
