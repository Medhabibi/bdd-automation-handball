Feature: Navigation du menu principal frontend

  Scenario: Accès à la page Joueurs
    Given l'utilisateur ouvre la page d'accueil du site
    When il clique sur le menu Joueurs
    Then l'URL doit contenir "inscri_joueurs.php"

  Scenario: Accès à la page Managers
    Given l'utilisateur ouvre la page d'accueil du site
    When il clique sur le menu Managers
    Then l'URL doit contenir "inscri_equipe.php"

  Scenario: Accès à la page Entraîneurs
    Given l'utilisateur ouvre la page d'accueil du site
    When il clique sur le menu Entraîneurs
    Then l'URL doit contenir "inscri_entraineur.php"

  Scenario: Accès à la page Préparateurs
    Given l'utilisateur ouvre la page d'accueil du site
    When il clique sur le menu Préparateurs physiques
    Then l'URL doit contenir "inscri_preparateur.php"
