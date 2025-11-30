# 🐞 Bug Reports – Handball Management (Frontend)

> ⚠️ **Ce document concerne UNIQUEMENT la partie FRONTEND**  
La partie ADMIN disposera d’un fichier BugReports séparé.

Ce document recense **uniquement les anomalies RÉELLES** détectées dans le module  
**Frontend – Handball Management**, lors des tests manuels et automatisés.

Chaque bug suit les standards ISTQB :  
- ID unique  
- Sévérité  
- Priorité  
- Étapes de reproduction  
- Résultat attendu / obtenu  
- Analyse technique  
- Impact  
- Lien vers les tests associés  

---

# 🧩 Résumé global

| 🔢 Total Bugs | 🟥 Critiques | 🟦 Hautes | 🟧 Moyennes | 🟨 Mineures | ⚙️ Corrigés | ⏳ Ouverts |
|--------------|--------------|-----------|------------|------------|------------|-----------|
| **2** | 0 | **2** | 0 | 0 | 0 | **2** |

---

# 🐞 Détails des anomalies (Frontend)

---

## 🐞 **BUG001 – Mauvaise redirection du menu “Managers”**

| Champ | Valeur |
|-------|--------|
| **ID** | BUG001 |
| **Module** | Frontend – Navigation |
| **Type** | Fonctionnel |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Statut** | 🟡 Open |
| **Reproductibilité** | Toujours |
| **Environnement** | Chrome 142 / Edge 142 – Windows 11 |
| **Test lié** | TC001 |
| **Exécution** | TestExecution – TC001 |

### 🎯 Résultat attendu
Rediriger vers une interface dédiée managers, par exemple :

```
connexion/inscri_equipe.php
```

### ❌ Résultat obtenu
Redirection vers l’interface **Joueurs** :

```
connexion/inscri_joueurs.php
```

### 🔍 Analyse technique
Lien HTML incorrect :

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

➡ Le lien pointe vers la mauvaise page.

### 📎 Impact
- Rupture du parcours Manager  
- Impossible d’accéder à l’inscription Manager  
- Bug visible en production  

---

## 🐞 **BUG002 – Formulaires de connexion non automatisables (blocage JS)**

| Champ | Valeur |
|-------|--------|
| **ID** | BUG002 |
| **Module** | Frontend – Connexions Joueur/Manager/Entraîneur/Préparateur |
| **Type** | Technique – Automatisation |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Statut** | 🟢 Closed (limitation technique documentée) |
| **Reproductibilité** | Toujours |
| **Environnement** | Selenium (Chrome + Edge) |
| **Tests liés** | TC002-S1 / TC002-S2 / TC002-S3 |

### 🎯 Description
Les formulaires utilisent :

```
jqBootstrapValidation.js
```

Cette librairie **intercepte les événements clavier**, ce qui empêche Selenium de saisir du texte.

### ⚠️ Symptômes
- `sendKeys()` ignoré  
- événements `blur/change` bloqués  
- `ElementNotInteractableException`  
- `Timeout waiting for visibility`  

### 🎯 Résultat attendu
Les champs doivent être interactifs et automatisables.

### ❌ Résultat obtenu
Automatisation **impossible** (100% d’échec).  
Fonctionnel manuel → **OK**.

### 📎 Impact
- Toute la partie Connexion doit rester **en test MANUEL**  
- Réduction de la couverture automatisée  
- Campagne E2E plus longue  

### 🧩 Décision QA
- Fonctionnel : ✔ OK  
- Automatisation : ❌ Impossible  
- Documenté dans :  
  - TestCases.md  
  - TestExecution.md  

---

# 🧾 Rédigé par  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Novembre 2025  
📍 Projet : Handball Management – FRONTEND  
