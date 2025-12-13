@admin @table_joueurs @B
Feature: Table Joueurs - Fonction de recherche
  L’administrateur doit pouvoir rechercher un joueur
  par n'importe quel champ disponible.

  Background:
    Given que l'admin ouvre la page de connexion admin
    And il saisit l'email "AdminManagement"
    And il saisit le mot de passe admin valide
    And il clique sur le bouton Connexion
    And il clique sur le menu "Tables"
    And il ouvre la section joueurs depuis la card
    Then la page "tabJoueurs.php" doit s'afficher

  @recherche_nom
  Scenario: Rechercher un joueur par nom
    When l'admin saisit "korsan" dans la barre de recherche
    Then la table doit afficher uniquement les joueurs dont le nom contient "korsan"

  @recherche_email
  Scenario: Rechercher un joueur par email
    When l'admin saisit "korsan8ameur@gmail.com" dans la barre de recherche
    Then la table doit afficher uniquement les joueurs dont l'email contient "korsan8ameur@gmail.com"

  @recherche_pays
  Scenario: Rechercher un joueur par pays
    When l'admin saisit "France" dans la barre de recherche
    Then la table doit afficher uniquement les joueurs dont le pays contient "France"
