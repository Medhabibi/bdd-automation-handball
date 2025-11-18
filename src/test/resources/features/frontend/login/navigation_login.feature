@frontend @navigationLogin
Feature: Navigation entre les interfaces de connexion

  Scenario: Navigation vers les différentes interfaces via les flèches
    Given l'utilisateur se trouve sur l'interface de connexion Joueurs
    When il clique sur la flèche droite
    Then il doit se trouver sur l'interface de connexion Managers

    When il clique sur la flèche droite
    Then il doit se trouver sur l'interface de connexion Entraîneurs

    When il clique sur la flèche droite
    Then il doit se trouver sur l'interface de connexion Préparateurs

    When il clique sur la flèche droite
    Then il doit revenir sur l'interface de connexion Joueurs

  Scenario: Retour à l'accueil depuis une interface de connexion
    Given l'utilisateur se trouve sur l'interface de connexion Entraîneurs
    When il clique sur le logo d'accueil
    Then il doit être redirigé vers la page d'accueil

