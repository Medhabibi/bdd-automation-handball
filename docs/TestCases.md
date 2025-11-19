# 🧪 Test Cases – Handball Management 

Ce document regroupe **uniquement les cas de test RÉELS** exécutés dans le cadre du projet  
**Handball Management – QA Manual & Automation**.

Tous les tests suivent les standards **ISTQB**, avec :  
ID unique, objectif, préconditions, données, étapes, résultats attendus, et statut d’automatisation.

---

# 📋 Table des matières

1. [TC001 – Vérifier la navigation du menu Managers](#tc001)
2. [TC002 – Connexion Joueur (Test NON AUTOMATISABLE)](#tc002)

---

# 🧩 **TC001 – Vérifier la navigation du menu Managers**  
### ID : TC001  
### Module : Frontend – Menu principal  
### Type : Test MANUEL + Automatisation (possible)  
### Lien Bug : **BUG001 – Ouvert**  

---

## 🎯 **Objectif**
Vérifier que le lien “Managers” dans le menu principal redirige vers la bonne page d’interface Manager.

---

## 🔧 **Préconditions**
- Navigateur : Chrome 142 / Edge 142  
- OS : Windows 11  
- Accès à : https://www.handball-management.com  
- Aucun cookie ni session active  

---

## 📥 **Données de test**
Aucune donnée nécessaire (test de navigation simple).

---

## 📝 **Étapes à suivre**
1. Ouvrir :  
   `https://www.handball-management.com/index.php`
2. Repérer le menu principal.
3. Cliquer sur l’onglet **“Managers”**.
4. Observer l’URL et la page chargée.

---

## 🎯 **Résultat attendu**
L’utilisateur doit être redirigé vers **une page dédiée aux managers**, par exemple :  
`connexion/inscri_equipe.php`  
ou une interface Managers spécifique.

---

## ❌ **Résultat obtenu (réel)**  
➡ Redirection vers une page **Joueurs** :  
`connexion/inscri_joueurs.php`

**Le lien HTML pointe vers une mauvaise page :**

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

---

## 🏷️ **Statut d’automatisation**
🟢 **Automatisable**  
→ Le test sera implémenté dans :  
`features/frontend/navigation.feature`  
Scénario : _Accès à la page Managers_

---

## 📌 **Statut final du test**
❌ **Échoué**  
➡ Bug **BUG001** créé et documenté.

---

---

# 🧩 **TC002 – Connexion Joueur (Test NON AUTOMATISABLE)**  
### ID : TC002  
### Module : Frontend – Authentification Joueur  
### Type : Test MANUEL uniquement  
### Lien Bug : Aucun bug fonctionnel trouvé  
### Statut : **NON AUTOMATISABLE**

---

## 🎯 **Objectif**
Vérifier la connexion Joueur avec :  
- Identifiants valides  
- Email incorrect  
- Mot de passe incorrect

---

## 🔧 **Préconditions**
- Navigateur : Chrome/Edge  
- URL Login Joueur :  
  `https://handball-management.com/connexion/inscri_joueurs.php`

---

## 📥 **Données de test (réelles du fichier config.properties)**

| Jeu | Email | Mot de passe |
|-----|--------|---------------|
| Valide | admin@gmail.com | Azert123@ |
| Email incorrect | xxxx@gmail.com | Azert123@ |
| Mot de passe incorrect | admin@gmail.com | aaaaaa |

---

## 📝 **Étapes (pour les 3 scénarios)**

1. Accéder à la page de connexion Joueur.  
2. Saisir un email selon le scénario.  
3. Saisir un mot de passe selon le scénario.  
4. Cliquer sur **Connexion**.  
5. Observer le comportement.

---

## 🎯 **Résultats attendus**

### ✔ SCÉNARIO 1 – Identifiants valides
- Redirection vers :  
  `les_interfaces/joueurs_club.php`

### ✔ SCÉNARIO 2 – Email incorrect
- Affichage message :  
  **“L'email n'existe pas.”**

### ✔ SCÉNARIO 3 – Mot de passe incorrect
- Affichage message :  
  **“Le mot de passe n'est pas correct.”**

---

# 🔥 **Pourquoi ce test est NON AUTOMATISABLE ? (réel)**

Le champ email/mot de passe utilise le script JavaScript : **jqBootstrapValidation**, qui :

- empêche Selenium de déclencher les bons événements :
  - `input`
  - `blur`
  - `change`
- intercepte le `submit`
- empêche le focus clavier réel
- bloque l’interaction WebDriver → *ElementNotInteractableException*

➡ Résultat :  
**Selenium ne peut PAS interagir correctement avec les champs.**

📌 **Test instable → non fiable → NON AUTOMATISABLE.**

---

## 🏷️ **Statut d’automatisation**
🔴 **NON AUTOMATISABLE**  
Documenté dans : `BugReports.md`

---

## 📌 **Statut final du test**
✔ Tous les tests manuels OK  
❌ Automatisation impossible → comportement technique bloquant

---

✍️ Rédigé par :  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Mise à jour : Novembre 2025  
📍 Projet : Handball Management  
