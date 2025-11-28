@frontend @inscription @entraineur

#########################################################
#               INSCRIPTION ENTRAINEUR
#########################################################

Feature: Inscription Entraîneur

  Background:
    Given l'utilisateur ouvre la page d'inscription Entraineur
    And il clique sur l'onglet Inscription Entraineur

  #########################################################
  #                  🔹 BLOCAGE : CHAMPS OBLIGATOIRES
  #########################################################

  @blocage_nom
  Scenario: Blocage sur le champ Nom vide ou invalide
    When il laisse le champ "Nom" vide ou invalide Entraineur
    And il tente de passer au champ suivant Entraineur
    Then le champ "Nom" doit afficher une erreur bloquante Entraineur
    And le message erreur Entraineur "Le nom doit contenir uniquement des lettres" doit s'afficher

  @blocage_prenom
  Scenario: Blocage sur le champ Prénom vide ou invalide
    When il laisse le champ "Prénom" vide ou invalide Entraineur
    And il tente de passer au champ suivant Entraineur
    Then le champ "Prénom" doit afficher une erreur bloquante Entraineur
    And le message erreur Entraineur "Le prénom doit contenir uniquement des lettres" doit s'afficher

  @blocage_telephone
  Scenario: Blocage sur le champ Téléphone vide ou invalide
    When il laisse le champ "Téléphone" vide ou invalide Entraineur
    And il tente de passer au champ suivant Entraineur
    Then le champ "Téléphone" doit afficher une erreur bloquante Entraineur
    And le message erreur Entraineur "Le numéro de téléphone ne doit contenir que des chiffres" doit s'afficher



  #########################################################
  #            🔹 INSCRIPTION RÉUSSIE — AGENT LIBRE
  #########################################################

  @inscription_entraineur_agent_libre
  Scenario: Inscription Entraîneur réussie (Agent Libre)
    Given il remplit le champ "Nom" avec une valeur valide Entraineur
    And il remplit le champ "Prénom" avec une valeur valide Entraineur
    And il remplit le champ "Date de naissance" avec une valeur valide Entraineur
    And il remplit le champ "Email" avec une valeur valide Entraineur
    And il remplit le champ "Téléphone" avec une valeur valide Entraineur
    And il sélectionne le type de contrat "Agent Libre" Entraineur
    And il remplit les champs facultatifs Entraineur
    When il clique sur le bouton Inscription Entraineur
    Then un message de succès Entraineur doit s'afficher



  #########################################################
  #         🔹 INSCRIPTION RÉUSSIE — SOUS CONTRAT
  #########################################################

  @inscription_entraineur_sous_contrat
  Scenario: Inscription Entraîneur réussie (Sous Contrat)
    Given il remplit le champ "Nom" avec une valeur valide Entraineur
    And il remplit le champ "Prénom" avec une valeur valide Entraineur
    And il remplit le champ "Date de naissance" avec une valeur valide Entraineur
    And il remplit le champ "Email" avec une valeur valide Entraineur
    And il remplit le champ "Téléphone" avec une valeur valide Entraineur
    And il sélectionne le type de contrat "Sous Contrat" Entraineur
    And il remplit le champ "Club actuel" Entraineur
    And il remplit le champ "Nationalité" Entraineur
    And il remplit le champ "Pays du club actuel" Entraineur
    And il remplit les champs facultatifs Entraineur
    When il clique sur le bouton Inscription Entraineur
    Then un message de succès Entraineur doit s'afficher

