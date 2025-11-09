# 🏐 BDD Automation – Handball Management
[![CI - BDD Automation Maven Build](https://github.com/Medhabibi/bdd-automation-handball/actions/workflows/maven.yml/badge.svg)](https://github.com/Medhabibi/bdd-automation-handball/actions/workflows/maven.yml)

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-success)](https://cucumber.io/)
[![JUnit](https://img.shields.io/badge/JUnit-5-red)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey)](LICENSE)

---

## 🧠 À propos du projet

Ce projet illustre un **cycle QA complet (manuel + automatisation)** appliqué à la plateforme réelle [Handball Management](https://www.handball-management.com/).

L’objectif est de **montrer la maîtrise d’un environnement professionnel QA** à travers :
- La **rédaction des cas de test manuels** et leur documentation.
- L’**automatisation des scénarios critiques** via **BDD (Cucumber + Selenium)**.
- La **génération de rapports** et la gestion des logs.
- Une **démonstration concrète** des compétences requises pour un poste de **QA Engineer / Test Automation Engineer**.

---

## 🎯 Objectifs pédagogiques et professionnels

- Appliquer la méthodologie **ISTQB** dans un projet web réel.  
- Centraliser la **documentation QA** (test cases, exécutions, anomalies).  
- Automatiser les **tests de connexion et rôles utilisateurs**.  
- Simuler un environnement **CI/CD et reporting professionnel**.  

---

## 🛠️ Stack technique

| Domaine | Outil / Technologie |
|----------|----------------------|
| Langage | Java 17 |
| Framework | Selenium WebDriver 4 + Cucumber 7 + JUnit 5 |
| Build Tool | Maven |
| IDE | IntelliJ IDEA / Eclipse |
| Logs | Log4j2 |
| CI/CD | GitHub Actions *(en cours d’intégration)* |
| Versioning | Git + GitHub |

---

## 📁 Structure du projet

```text
bdd-automation-handball/
│
├── docs/                           # Partie QA manuelle
│   ├── TestCases.md                # Cas de tests
│   ├── TestExecution.md            # Résultats d'exécution
│   └── BugReports.md               # Anomalies détectées
│
├── src/
│   ├── main/resources/
│   │   └── config.properties       # Configuration (URL, navigateur, etc.)
│   └── test/java/
│       ├── com/handball/helper/    # Gestion WebDriver & Config
│       ├── com/handball/pages/     # Page Object Models
│       ├── com/handball/runners/   # Runners JUnit 5 / Cucumber
│       ├── com/handball/hooks/     # Hooks (Before/After)
│       └── com/handball/stepDefinitions/  # Étapes Gherkin
│
├── src/test/resources/features/
│   └── login_joueur.feature        # Scénarios BDD Gherkin
│
├── pom.xml                         # Dépendances Maven
├── .gitignore                      # Fichiers ignorés
└── README.md                       # Présentation du projet
```

---

## 🧩 Exemple de scénario BDD

```gherkin
Feature: Login Functionality for all user roles
  As a registered user of Handball Management
  I want to log in based on my role
  So that I can access the right dashboard

  @SmokeTest @Login
  Scenario Outline: Login attempt for each role
    Given user is on the login page
    When user selects the role "<role>"
    And enters "<username>" and "<password>"
    And clicks on the login button
    Then the result should be "<expectedResult>"

    Examples:
      | role             | username          | password   | expectedResult             |
      | Player           | admin@gmail.com   | Azert123@  | success_redirect_dashboard |
      | Coach            | admin@gmail.com   | Azert123@  | success_redirect_dashboard |
      | Manager          | admin@gmail.com   | Azert123@  | success_redirect_dashboard |
      | Player (erreur)  | admin@gmail.com   | wrongPass  | error_invalid_credentials  |
```

---

## ▶️ Exécution locale

### 🧱 Prérequis
- Java 17+  
- Maven installé  
- Chrome + ChromeDriver  
- IDE configuré (Eclipse / IntelliJ)  

### 🚀 Lancer les tests
```bash
mvn test
```

Les rapports seront générés dans :
```
target/reports/
```

---

## 📊 Partie manuelle (docs/)
- Cas de tests manuels  
- Exécution et validation  
- Rapports d’anomalies  

---

## 👨‍💻 Auteur

**Mohamed Taib Ben Salha**  
🧩 *QA Engineer | Test Automation | ISTQB Certified*  
📍 Tunisie  
🔗 [GitHub – Medhabibi](https://github.com/Medhabibi)

---

## 🏁 Prochaines étapes

✅ Tests API (Postman / RestAssured)  
✅ CI/CD avec GitHub Actions  
⏳ Reporting avancé (Allure Reports)  
⏳ Extension des scénarios : Managers, Joueurs, Entraîneurs  

---

⭐ *Si ce projet t’a inspiré ou aidé, pense à lui mettre une star sur GitHub !*  
