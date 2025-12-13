@admin @tables @entraineurs @recherche @actions
Feature: Gestion des entraîneurs (Admin)

  L’administrateur doit pouvoir :
  - accéder au tableau des entraîneurs via la section Joueurs,
  - rechercher un entraîneur par statut professionnel,
  - naviguer dans la pagination pour trouver un entraîneur précis,
  - scroller horizontalement pour afficher les actions,
  - vérifier la présence des boutons d’action (edit, view, delete).


  Background:
    Given que l'admin est connecté
    And il clique sur le menu "Tables"
    And il ouvre la section joueurs depuis la card
    And il change la table vers "Entraîneurs"


  ###########################################################################
  # 🔍 SCENARIO — Recherche + pagination + scroll horizontal + actions
  ###########################################################################

  Scenario: Rechercher un entraîneur Agent Libre, le localiser dans les pages et vérifier les actions disponibles

    # 1. Recherche par statut pro
    When l'admin recherche un entraîneur par statut pro "Agent Libre"
    Then au moins un résultat doit s’afficher

    # 2. Scroll vertical + pagination pour trouver la ligne cible
    When l'admin scroll vers le bas pour afficher la pagination
    And l'admin recherche l'entraîneur nommé "Saleh Mbaya" dans toutes les pages
    Then l'entraîneur "Saleh Mbaya" doit être trouvé dans une des pages

    # 3. Scroll horizontal pour afficher les boutons d'action
    When l'admin scroll horizontalement la table entraîneurs

    # 4. Vérification des boutons (edit / view / delete)
    Then les boutons d'action "edit", "view", "delete" doivent être visibles pour l'entraîneur "Saleh Mbaya"
