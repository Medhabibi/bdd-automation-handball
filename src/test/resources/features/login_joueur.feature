Feature: Connexion du Joueur

  En tant que joueur,
  Je veux pouvoir me connecter directement ou via le menu déroulant
  Afin de vérifier que les deux méthodes de connexion fonctionnent correctement.

  @SmokeTest @Login @Joueur
  Scenario Outline: Connexion du joueur via différentes méthodes d'accès
    Given le joueur est sur la page d'accueil
    When le joueur se connecte en utilisant la méthode "<methode>"
    And le joueur saisit l'email "<email>" et le mot de passe "<motdepasse>"
    And le joueur clique sur le bouton de connexion
    Then le joueur doit être redirigé vers son tableau de bord

    Examples:
      | methode          | email             | motdepasse  |
      | directe           | admin@gmail.com   | Azert123@   |
      | menu déroulant    | admin@gmail.com   | Azert123@   |
