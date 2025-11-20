# 🧪 Test Cases – Handball Management (Réel)

Ce document regroupe **uniquement les cas de test RÉELS** exécutés dans le cadre du projet  
**Handball Management – QA Manual & Automation**.

Tous les tests suivent les standards **ISTQB**, avec :  
✔ ID unique  
✔ Objectif clair  
✔ Préconditions  
✔ Données de test  
✔ Étapes détaillées  
✔ Résultats attendus  
✔ Statut (Pass / Fail / Non automatisable)  
✔ Lien Bug si applicable  

---

# 📋 Table des matières

1. [TC001 – Vérifier la navigation du menu Managers](#tc001)
2. [TC002 – Connexion Joueur (Test NON AUTOMATISABLE)](#tc002)

---

---

# 🧩 <a name="tc001"></a> **TC001 – Vérifier la navigation du menu Managers**

### **ID :** TC001  
### **Module :** Frontend – Menu principal  
### **Type :** Test MANUEL + Automatisation (possible)  
### **Lien Bug :** ✔ **BUG001 – Ouvert**  

---

## 🎯 **Objectif**
Vérifier que le lien **“Managers”** dans le menu principal redirige vers la bonne page prévue pour les managers.

---

## 🔧 **Préconditions**
- Navigateur : Chrome 142 / Edge 142  
- OS : Windows 11  
- URL de départ : https://www.handball-management.com/index.php  
- Aucune session existante  
- Cookies vidés  

---

## 📥 **Données de test**
Aucune donnée nécessaire (simple test de navigation de menu).

---

## 📝 **Étapes à suivre**
1. Ouvrir :  
   `https://www.handball-management.com/index.php`
2. Repérer le **menu principal**.
3. Cliquer sur l’onglet **“Managers”**.
4. Observer **la redirection** et **l'URL obtenue**.

---

## 🎯 **Résultat attendu**
👉 L’utilisateur doit être redirigé vers une page **dédiée aux managers**,  
par exemple :

```
connexion/inscri_equipe.php
```

ou une interface Manager spécifique.

---

## ❌ **Résultat obtenu (réel)**
➡ Redirection vers la page **Joueurs** :

```
connexion/inscri_joueurs.php
```

Le code source confirme l’erreur :

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

➡ Le lien pointe vers la **mauvaise page** (Joueurs).

---

## 🏷️ **Statut d’automatisation**
🟢 **Automatisable**  
Ce test sera automatisé dans :

```
features/frontend/navigation.feature
```

Scénario :  
✔ _Accès à la page Managers_

---

## 📌 **Statut final**
❌ **ÉCHOUÉ**  
➡ Bug généré : **BUG001**

---

---

# 🧩 <a name="tc002"></a> **TC002 – Connexion Joueur (Test NON AUTOMATISABLE)**

### **ID :** TC002  
### **Module :** Frontend – Authentification Joueur  
### **Type :** Test MANUEL uniquement  
### **Bug :** Aucun bug fonctionnel  
### **Statut :** 🔴 **NON AUTOMATISABLE**

---

## 🎯 **Objectif**
Vérifier le comportement réel du formulaire de connexion Joueur avec :

- Identifiants valides  
- Email incorrect  
- Mot de passe incorrect  

---

## 🔧 **Préconditions**
- Navigateur : Chrome / Edge  
- URL page login Joueur :

```
https://handball-management.com/connexion/inscri_joueurs.php
```

---

## 📥 **Données de test (réelles issues de config.properties)**

| Jeu | Email | Mot de passe |
|------|---------------------|----------------|
| Valide | admin@gmail.com | Azert123@ |
| Email incorrect | xxxx@gmail.com | Azert123@ |
| Mot de passe incorrect | admin@gmail.com | aaaaaa |

---

## 📝 **Étapes (communes aux 3 scénarios)**

1. Ouvrir l’URL :  
   `https://handball-management.com/connexion/inscri_joueurs.php`
2. Saisir un email selon le scénario.
3. Saisir le mot de passe correspondant.
4. Cliquer sur **Connexion**.
5. Observer le résultat.

---

## 🎯 **Résultats attendus**

### ✔ **Scénario 1 — Identifiants valides**
➡ Redirection vers :

```
les_interfaces/joueurs_club.php
```

---

### ✔ **Scénario 2 — Email incorrect**
➡ Affichage du message :

> **“L'email n'existe pas.”**

---

### ✔ **Scénario 3 — Mot de passe incorrect**
➡ Affichage du message :

> **“Le mot de passe n'est pas correct.”**

---

# 🔥 **Pourquoi ce test est NON AUTOMATISABLE ?**

Le formulaire utilise **jqBootstrapValidation.js**, un script JS qui bloque Selenium :

### 🚫 Problèmes rencontrés :
- Événements `input`, `blur`, `change` interceptés  
- `submit()` bloqué  
- Fausse gestion du focus  
- Le champ ne reçoit pas les valeurs envoyées par WebDriver  
- Échec systématique sur la visibilité / interaction

➡ **Tous les tests Selenium échouent** (Edge + Chrome).

### 🔍 Conclusion QA
✔ Fonctionnel **OK**  
❌ Automatisation **IMPOSSIBLE** (non fiable + instable)

Documenté dans :  
`BugReports.md → BUG002`

---

## 🏷️ **Statut d’automatisation**
🔴 **NON AUTOMATISABLE**

---

## 📌 **Statut final**
✔ Tests manuels : **réussis**  
❌ Automatisation : **impossible (techniquement bloqué)**

---

✍️ Rédigé par :  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Mise à jour : Novembre 2025  
📍 Projet : Handball Management – QA réel  
