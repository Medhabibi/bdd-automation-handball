# 🐞 Bug Reports – Handball Management (Réel)

Ce document répertorie uniquement les **anomalies réellement observées**
lors des tests (manuels ou automatisés) du projet **Handball Management**.

Chaque bug est documenté avec un ID unique, une description claire,
et un niveau de sévérité/priorité conforme aux standards QA/ISTQB.

---

## 🧩 Résumé global

| 🔢 Total Bugs | 🟥 Critiques | 🟦 Hautes | 🟧 Moyennes | 🟨 Mineures | ⚙️ Corrigés | ⏳ Ouverts |
|--------------|--------------|-----------|------------|------------|------------|-----------|
| **1** | 0 | **1** | 0 | 0 | 0 | **1** |

> 📌 Ce document sera mis à jour à chaque nouveau bug réel identifié.

---

## 🐞 Détails des anomalies réelles

---

### **BUG001 – Le menu “Managers” redirige vers la page Joueurs**

| Champ | Détail |
|-------|--------|
| **ID** | BUG001 |
| **Module** | Frontend – Navigation du menu principal |
| **Type de test** | Test automatisé (Cucumber + Selenium) + vérification manuelle |
| **Environnement** | Chrome 142 – Windows 11 – URL : https://www.handball-management.com |

#### 🔁 Étapes pour reproduire :
1. Ouvrir la page d’accueil : `https://www.handball-management.com/index.php`
2. Cliquer sur **“Managers”** dans le menu principal
3. Observer la page affichée

connexion/inscri_equipe.php
#### ✅ Résultat attendu :
L’utilisateur doit être redirigé vers une **page dédiée aux managers**, par exemple :

#### ❌ Résultat obtenu :
L’utilisateur est redirigé vers une page d'inscription **Joueurs** :
https://handball-management.com/connexion/inscri_joueurs.php

#### 🔍 Analyse technique :
Le code HTML indique une mauvaise configuration du lien :

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
➡ Le lien pointe vers club_joueurs.php au lieu d’une page managers.
🎯 Impact :


Les managers n’ont pas accès à leur interface depuis le menu.


Rupture complète du parcours utilisateur.


Bug visible en production.


Impact fonctionnel important.


🏷️ Sévérité : Haute
⏱️ Priorité : Haute
🔄 Statut : 🟡 Ouvert
♻️ Reproductibilité : Toujours
🔗 Tests automatisés liés :


Feature : src/test/resources/features/frontend/navigation.feature


Scénario : Scenario: Accès à la page Managers


Tag recommandé : @bug_menu_managers


📎 Évidences à conserver :


Capture du menu montrant “Managers”


Capture de l’URL affichée (inscri_joueurs.php)


Capture de l’HTML du lien incorrect


Logs Cucumber montrant :
URL attendue : inscri_equipe.php, obtenue : inscri_joueurs.php

### Automatisation
❌ Test NON AUTOMATISABLE

**Motif :** Le formulaire utilise `jqBootstrapValidation`, un script JavaScript qui empêche
 Selenium d’interagir correctement avec les champs (événements `input`, `blur`, `change`).
 Le test automatique serait instable et non fiable.




✍️ Rédigé par :
Mohamed Taib Ben Salha – QA Engineer
📅 Mise à jour : Novembre 2025
📍 Projet : Handball Management – QA Automation (réel)




