# 🐞 Bug Reports – Handball Management (Frontend)
Ce document liste les anomalies RÉELLES détectées lors des tests du module Frontend de la plateforme Handball Management.  
Objectif : fournir une visibilité claire aux équipes Dev/QA sur les dysfonctionnements identifiés.

---

## 📊 Résumé global des anomalies

| ID | Titre | Sévérité | Priorité | Statut |
|----|--------|-----------|-----------|---------|
| BUG001 | Mauvaise redirection du menu “Managers” | Haute | Haute | Ouvert |
| BUG002 | Formulaires de connexion non automatisables | Haute | Haute | Ouvert |

Total anomalies : **2** — toutes de sévérité **Haute**.

---

# 🐞 BUG001 – Mauvaise redirection du menu “Managers”

**ID :** BUG001  
**Module :** Navigation Frontend  
**Type :** Fonctionnel  
**Sévérité :** Haute  
**Priorité :** Haute  
**Statut :** Ouvert  
**Reproductibilité :** Toujours  
**Test associé :** TC001  

### 🔎 Description du problème  
Le bouton **“Managers”** du menu principal redirige l’utilisateur vers la page d’inscription **Joueurs**, ce qui casse entièrement le parcours Manager.

### 🎯 Résultat attendu  
Accès à une page dédiée Managers, par exemple :  
connexion/inscri_equipe.php

shell
Copier le code

### ❌ Résultat obtenu  
connexion/inscri_joueurs.php

kotlin
Copier le code

### 📌 Analyse technique  
Extrait HTML réel :
```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
➡ L’attribut href pointe vers une interface Joueurs au lieu d'une interface Managers.

⚠ Impact
Parcours Manager inutilisable

Expérience utilisateur dégradée

Blocage potentiel lors de l’inscription Manager

🐞 BUG002 – Formulaires de connexion impossibles à automatiser
ID : BUG002
Module : Connexions Frontend (Joueur, Manager, Entraîneur, Préparateur)
Type : Technique – Automatisation
Sévérité : Haute
Priorité : Haute
Statut : Ouvert
Reproductibilité : Toujours
Tests associés : TC002 → TC005

🔎 Description du problème
Les formulaires utilisent la librairie suivante :

bash
Copier le code
assets/js/jqBootstrapValidation.js
Elle intercepte des événements critiques pour Selenium (input, change, blur), rendant les champs instables et bloquant la validation automatique.

❌ Symptômes observés avec Selenium
sendKeys() non détecté

Bouton Connexion non activé

Formulaire non soumis

Exceptions fréquentes :

TimeoutException

ElementNotInteractableException

🎯 Fonctionnel manuel
✔ Fonctionnel OK — l’utilisateur réel peut se connecter.
❌ Automatisation KO — impossible de stabiliser un test auto.

⚠ Impact
Les tests de connexion doivent rester manuels

Réduction de la couverture d’automatisation

Temps de régression plus élevé

Risque accru de bugs de login en production

✍️ Rédigé par : Mohamed Taib Ben Salha – QA Engineer
📅 Date : Novembre 2025
