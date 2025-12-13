@admin @entraineurs @actions
Feature: Actions sur les entraîneurs (Admin)

  Background:
    Given que l'admin est connecté
    And il clique sur le menu "Tables"
    And il ouvre la section joueurs depuis la card
    And il change la table vers "Entraîneurs"

  #####################################################################
  # 🔍 TEST 1 — Voir détails (modal)
  #####################################################################

  @voir_entraineur
  Scenario: Voir les détails d'un entraîneur
    And l'admin force la recherche complète de l'entraîneur "saleh"
    When l'admin clique sur le bouton voir de l'entraîneur "saleh"
    Then la modal des détails doit s'afficher
    And la modal doit contenir "Nom", "Prénom", "Date de Naissance", "Pays", "Sexe"
    And l'admin ferme la modal des détails

  #####################################################################
  # ✏ TEST 2 — Editer un entraîneur
  #####################################################################

  @editer_entraineur
  Scenario: Editer un entraîneur
    And l'admin force la recherche complète de l'entraîneur "saleh"
    When l'admin clique sur le bouton editer de l'entraîneur "saleh"
    Then la page d'édition doit s'afficher
    And les champs d'édition doivent être visibles
    When l'admin modifie le champ "Nom" avec "test-edit"
    And il clique sur le bouton Enregistrer
    Then la sauvegarde doit réussir

  #####################################################################
  # 🗑 TEST 3 — Page de suppression (sans supprimer)
  #####################################################################

  @supprimer_entraineur
  Scenario: Ouvrir la page de suppression d'un entraîneur
    And l'admin force la recherche complète de l'entraîneur "saleh"
    When l'admin clique sur le bouton supprimer de l'entraîneur "saleh"
    Then la page de suppression doit s'afficher
    And les boutons "Annuler" et "confirmer la suppression" doivent être visibles
    When l'admin clique sur Annuler
    Then il doit revenir à la table des entraîneurs
