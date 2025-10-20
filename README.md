# 🏐 BDD Automation – Handball Management

Projet QA complet (manuel + automatisation) réalisé sur la plateforme [Handball Management](https://www.handball-management.com/).

L’objectif de ce dépôt est de démontrer un **cycle de test complet**, de la conception des cas de tests jusqu’à l’automatisation avec **Cucumber, JUnit 5 et Selenium**.

---

## 🎯 Objectifs
- Mettre en pratique la méthodologie QA (ISTQB).
- Documenter les cas de test manuels, exécutions et anomalies.
- Automatiser les scénarios critiques (BDD avec Gherkin).
- Fournir une vitrine professionnelle pour un poste de **QA Engineer**.

---

## 🛠️ Outils utilisés
- **Gestion de tests** : Jira / Xray (simulation), TestLink (formation)
- **Automatisation** : Java 17, Maven, Cucumber, JUnit 5, Selenium WebDriver
- **CI/CD (optionnel)** : GitHub Actions
- **Suivi de code** : Git + GitHub

---

## 📂 Structure du projet

bdd-automation-handball/
│── README.md # Présentation (ce fichier)
│── .gitignore # Fichiers ignorés
│── pom.xml # Dépendances Maven
│
├── docs/ # Partie QA manuelle
│ ├── TestCases.md # Cas de tests
│ ├── TestExecution.md # Résultats d’exécution
│ └── BugReports.md # Anomalies détectées
│
├── src/test/resources/
│ ├── features/ # Fichiers .feature (BDD)
│ │ └── login.feature
│ └── junit-platform.properties
│
└── src/test/java/
├── com/handball/runner/
│ └── RunCucumberTest.java
└── com/handball/steps/
└── LoginSteps.java

---

## 📝 Partie manuelle (docs/)
- [Cas de tests](docs/TestCases.md)  
- [Exécutions](docs/TestExecution.md)  
- [Bugs](docs/BugReports.md)  

---

## 🤖 Partie automatisée (BDD + Java)
### Exemple de scénario (login.feature)
```gherkin
Feature: Login

  Scenario: Connexion avec identifiants invalides
    Given I open the login page
    When I enter email "test@test.com" and password "wrongpass"
    And I click on login
    Then I should stay on the login page (no redirect)



