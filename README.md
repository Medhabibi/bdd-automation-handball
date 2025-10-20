# 🏐 BDD Automation – Handball Management

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-success)](https://cucumber.io/)
[![JUnit](https://img.shields.io/badge/JUnit-5-red)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey)](LICENSE)

---

## 🧠 À propos du projet

Projet QA complet (**manuel + automatisation**) réalisé sur la plateforme [Handball Management](https://www.handball-management.com/).

Ce dépôt illustre un **cycle de test QA complet** :
- Rédaction et documentation des cas de tests manuels.
- Automatisation des scénarios critiques en **BDD (Cucumber + Selenium)**.
- Exécution et génération de rapports de test.
- Vitrine technique pour un poste de **QA Engineer / Test Automation Engineer**.

---

## 🎯 Objectifs

- Appliquer la méthodologie **ISTQB** dans un vrai projet web.
- Centraliser la **documentation QA** : cas de tests, bugs, exécutions.
- Automatiser le parcours de connexion et les rôles utilisateurs.
- Simuler un environnement professionnel (CI/CD, logs, reports).

---

## 🛠️ Stack technique

| Domaine | Outil / Technologie |
|----------|----------------------|
| Langage | Java 17 |
| Framework | Selenium WebDriver 4 + Cucumber 7 + JUnit 5 |
| Build Tool | Maven |
| IDE | Eclipse / IntelliJ |
| Logs | Log4j2 |
| CI/CD | GitHub Actions *(à venir)* |
| Versioning | Git + GitHub |

---

## 📂 Structure du projet

# 🏐 BDD Automation – Handball Management

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-success)](https://cucumber.io/)
[![JUnit](https://img.shields.io/badge/JUnit-5-red)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey)](LICENSE)

---

## 🧠 À propos du projet

Projet QA complet (**manuel + automatisation**) réalisé sur la plateforme [Handball Management](https://www.handball-management.com/).

Ce dépôt illustre un **cycle de test QA complet** :
- Rédaction et documentation des cas de tests manuels.
- Automatisation des scénarios critiques en **BDD (Cucumber + Selenium)**.
- Exécution et génération de rapports de test.
- Vitrine technique pour un poste de **QA Engineer / Test Automation Engineer**.

---

## 🎯 Objectifs

- Appliquer la méthodologie **ISTQB** dans un vrai projet web.
- Centraliser la **documentation QA** : cas de tests, bugs, exécutions.
- Automatiser le parcours de connexion et les rôles utilisateurs.
- Simuler un environnement professionnel (CI/CD, logs, reports).

---

## 🛠️ Stack technique

| Domaine | Outil / Technologie |
|----------|----------------------|
| Langage | Java 17 |
| Framework | Selenium WebDriver 4 + Cucumber 7 + JUnit 5 |
| Build Tool | Maven |
| IDE | Eclipse / IntelliJ |
| Logs | Log4j2 |
| CI/CD | GitHub Actions *(à venir)* |
| Versioning | Git + GitHub |

---

## 📂 Structure du projet
# 🏐 BDD Automation – Handball Management

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-success)](https://cucumber.io/)
[![JUnit](https://img.shields.io/badge/JUnit-5-red)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey)](LICENSE)

---

## 🧠 À propos du projet

Projet QA complet (**manuel + automatisation**) réalisé sur la plateforme [Handball Management](https://www.handball-management.com/).

Ce dépôt illustre un **cycle de test QA complet** :
- Rédaction et documentation des cas de tests manuels.
- Automatisation des scénarios critiques en **BDD (Cucumber + Selenium)**.
- Exécution et génération de rapports de test.
- Vitrine technique pour un poste de **QA Engineer / Test Automation Engineer**.

---

## 🎯 Objectifs

- Appliquer la méthodologie **ISTQB** dans un vrai projet web.
- Centraliser la **documentation QA** : cas de tests, bugs, exécutions.
- Automatiser le parcours de connexion et les rôles utilisateurs.
- Simuler un environnement professionnel (CI/CD, logs, reports).

---

## 🛠️ Stack technique

| Domaine | Outil / Technologie |
|----------|----------------------|
| Langage | Java 17 |
| Framework | Selenium WebDriver 4 + Cucumber 7 + JUnit 5 |
| Build Tool | Maven |
| IDE | Eclipse / IntelliJ |
| Logs | Log4j2 |
| CI/CD | GitHub Actions *(à venir)* |
| Versioning | Git + GitHub |

---

## 📂 Structure du projet

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
│   │   └── config.properties       # Fichier de configuration (URL, navigateur…)
│   └── test/java/
│       ├── com/handball/helper/    # Gestion WebDriver et config
│       ├── com/handball/pages/     # Page Object Models
│       ├── com/handball/runners/   # Runner JUnit 5 (RunCucumberTests.java)
│       ├── com/handball/tests/     # Tests indépendants
│       └── com/handball/stepDefinitions/  # Étapes Gherkin
│
├── src/test/resources/features/
│   └── login.feature               # Scénarios BDD Gherkin
│
├── pom.xml                         # Dépendances Maven
├── .gitignore                      # Fichiers ignorés
└── README.md                       # Présentation du projet


---

## 🤖 Exemple de scénario BDD

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

▶️ Exécution locale
🧱 Prérequis

Java 17+

Maven installé

Chrome + ChromeDriver

Eclipse / IntelliJ configuré

🚀 Lancer les tests
mvn test

Les rapports seront disponibles dans :
target/cucumber-reports.html

📊 Partie manuelle (docs/)

Cas de tests

Exécutions

Bugs

👨‍💻 Auteur

Mohamed Taib Ben Salha
🧩 QA Engineer | Automation Tester | ISTQB Certified
📍 Tunisie
🔗 GitHub – Medhabibi

🏁 Prochaines étapes

✅ Ajout des tests API (RestAssured / Postman)

✅ Intégration CI/CD via GitHub Actions

⏳ Reporting avec Allure Reports

⏳ Extension des scénarios (Managers / Joueurs / Entraîneurs)

⭐ Si ce projet t’a inspiré, pense à lui mettre une star sur GitHub !


---

Souhaites-tu que je te le **prépare directement en fichier `README.md` téléchargeable**, pour que tu le
