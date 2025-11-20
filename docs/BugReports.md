# 🐞 Bug Reports – Handball Management 

Ce document répertorie uniquement les **anomalies réellement observées**
lors des tests manuels et automatisés du projet **Handball Management**.

Chaque bug est documenté selon les standards QA/ISTQB :
ID unique, description, sévérité, priorité, reproductibilité.

---

## 🧩 Résumé global

| 🔢 Total Bugs | 🟥 Critiques | 🟦 Hautes | 🟧 Moyennes | 🟨 Mineures | ⚙️ Corrigés | ⏳ Ouverts |
|--------------|--------------|-----------|------------|------------|------------|-----------|
| **2** | 0 | **2** | 0 | 0 | 0 | **2** |

---

# 🐞 Détails des anomalies réelles

---

## **BUG001 – Le menu “Managers” redirige vers la page Joueurs**

| Champ | Valeur |
|-------|--------|
| **ID** | BUG001 |
| **Module** | Frontend – Navigation principale |
| **Type de test** | Automatisé + Manuel |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Statut** | 🟡 Ouvert |
| **Reproductibilité** | Toujours |
| **Environnement** | Chrome/Edge – Windows 11 |

### 🔁 Étapes pour reproduire
1. Aller sur : https://www.handball-management.com/index.php  
2. Cliquer sur **Managers**  
3. Observer la redirection

### ✅ Résultat attendu  
Redirection vers une **page dédiée managers**  
(ex : inscri_equipe.php)

### ❌ Résultat obtenu  
Redirection vers la page **inscription Joueurs**

### 🔍 Analyse technique  
Lien HTML incorrect :

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

➡ Le lien pointe vers **club_joueurs.php** au lieu d’une page managers.

### 🎯 Impact  
- Rupture du parcours manager  
- Impossible d’accéder à son interface  
- Bug visible en production  

---

## **BUG002 – Formulaires de connexion impossibles à automatiser**

| Champ | Valeur |
|-------|--------|
| **ID** | BUG002 |
| **Module** | Frontend – Connexions Joueur / Manager / Entraîneur / Préparateur |
| **Type de test** | Automatisé (KO) + Manuel (OK) |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Statut** | 🟢 Corrigé côté test (contournement) |
| **Reproductibilité** | Toujours |
| **Environnement** | Selenium (Chrome + Edge) |

### 🔁 Étapes pour reproduire
1. Ouvrir une page de connexion (ex : inscri_joueurs.php)  
2. Automatiser la saisie email / password via Selenium  
3. Observer l’erreur

### ❌ Erreur Selenium  
`Timeout waiting for visibility of element #email`

### 🔍 Analyse technique  
Le site utilise **jqBootstrapValidation.js**, un script JS incompatible avec Selenium.  
Il **bloque la propagation des événements input / blur / focus**, ce qui empêche Selenium
d'interagir correctement avec les champs.

### 🎯 Impact  
Tous les tests login deviennent :  
➡ **NON AUTOMATISABLES** (instables + non fiables)

### 🧩 Décision QA  
✔ Test manuel validé  
✔ Documenté dans TestExecution  
✔ Marqué comme “Non Automatisable” selon les standards ISTQB  

---

✍️ Rédigé par : **Mohamed Taib Ben Salha – QA Engineer**  
📅 Mise à jour : Novembre 2025  
📍 Projet : Handball Management – QA  & Automation  
