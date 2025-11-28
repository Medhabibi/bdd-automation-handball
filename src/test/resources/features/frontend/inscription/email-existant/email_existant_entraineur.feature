@frontend @inscription @entraineur @email_existant
Feature: Inscription Entraîneur - Email déjà existant

  Scenario: Inscription Entraîneur échoue — Email existant
    Given l'utilisateur ouvre la page d'inscription Entraineur
    And il clique sur l'onglet Inscription Entraineur

    And il remplit le champ "Nom" avec une valeur valide Entraineur
    And il remplit le champ "Prénom" avec une valeur valide Entraineur
    And il remplit le champ "Date de naissance" avec une valeur valide Entraineur
    And il remplit le champ "Téléphone" avec une valeur valide Entraineur
    And il sélectionne le sexe Entraineur
    And il remplit tous les autres champs obligatoires Entraineur

    And il saisit un email déjà utilisé Entraineur
    And il remplit les champs facultatifs Entraineur

    When il clique sur le bouton Inscription Entraineur
    Then un message d'erreur doit s'afficher "L'email existe déjà. Veuillez en choisir un autre."
    And l'inscription Entraineur doit échouer
