@frontend @entraineur_email_existant
Feature: Vérification Email Existant - Inscription Entraineur

  Scenario: Un entraîneur ne peut pas s'inscrire avec un email déjà utilisé
    Given je suis sur la page d'inscription entraîneur
    And je clique sur l'onglet inscription entraîneur

    And je remplis tous les champs obligatoires de l'entraîneur sauf l'email
    And je saisis un email déjà existant pour l'entraîneur

    And je remplis les champs facultatifs de l'entraîneur

    When je clique sur le bouton d'inscription entraîneur
    Then un message d'erreur email existe déjà doit s'afficher
    And l'inscription entraîneur doit échouer
