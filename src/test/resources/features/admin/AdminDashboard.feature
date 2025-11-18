Feature: Dashboard Admin - Connexion et affichage du tableau de bord

  Background:
    Given l'administrateur ouvre le navigateur
    And il accède à la page de connexion du tableau de bord

  Scenario: Connexion réussie et affichage des sections du Dashboard
    When il saisit le nom d'utilisateur "AdminManagement"
    And il saisit le mot de passe "Handballmanagement25"
    And il clique sur le bouton "connexion"
    Then il doit être redirigé vers la page du tableau de bord
    And le titre de la page doit être "Handball Management"
    And les sections suivantes doivent être visibles :
      | Total des joueurs          |
      | Total des entraîneurs      |
      | Total des préparateurs     |
      | Total des managers         |
      | Equipes cherchent des joueurs |
      | Equipes cherchent des entraîneurs |
      | Equipes cherchent des préparateurs |
      | Messages lus               |
      | Messages non lus           |
