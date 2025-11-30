# 🧪 Test Cases – Handball Management (Frontend)

> ⚠️ **Ce document concerne UNIQUEMENT la partie FRONTEND**  
La partie ADMIN aura son propre fichier TestCases séparé.

Ce document regroupe les **cas de test RÉELS** exécutés dans le module  
**Handball Management – Frontend**, selon les standards ISTQB.

Chaque test inclut :  
- ID unique  
- Objectif  
- Préconditions  
- Données de test  
- Étapes détaillées  
- Résultat attendu  
- Résultat obtenu  
- Statut  
- Automatisabilité  
- Lien Bug (si applicable)

---

# 📋 Liste des cas de test (Frontend)

1. [TC001 – Navigation menu → Managers](#tc001)  
2. [TC002 – Connexion Joueur (3 scénarios)](#tc002)

---

---

# 🧩 <a name="tc001"></a> **TC001 – Navigation du menu “Managers”**

### 🔖 Informations générales
| Champ | Valeur |
|-------|--------|
| **ID** | TC001 |
| **Module** | Frontend – Navigation |
| **Type** | Fonctionnel |
| **Criticité** | Haute |
| **Automatisation** | 🟢 Oui |
| **Bug lié** | BUG001 |
| **Statut final** | ❌ ÉCHOUÉ |

---

## 🎯 Objectif
Vérifier que le lien **Managers** du menu principal redirige vers la page correcte.

---

## 🔧 Préconditions
- Navigateur : Chrome 142 / Edge 142  
- OS : Windows 11  
- Cookies vidés  
- URL :

```
https://www.handball-management.com/index.php
```

---

## 📥 Données de test
Aucune donnée nécessaire (test de navigation simple).

---

## 📝 Étapes
1. Ouvrir la page d’accueil du site.  
2. Localiser le menu principal.  
3. Cliquer sur **Managers**.  
4. Vérifier l’URL et l’interface obtenues.

---

## 🎯 Résultat attendu
Redirection vers une **page dédiée Managers**, exemple :

```
connexion/inscri_equipe.php
```

---

## ❌ Résultat obtenu
Le lien redirige vers :

```
connexion/inscri_joueurs.php
```

👉 Le lien HTML est incorrect.

---

## 🏷 Automatisation
🟢 **Possible** – Ce test sera automatisé dans :

```
features/frontend/navigation.feature
```

---

## 📌 Statut final
❌ **ÉCHOUÉ** (BUG001 ouvert)

---

---

# 🧩 <a name="tc002"></a> **TC002 – Connexion Joueur (3 scénarios)**

> ⚠️ Les 3 scénarios sont **NON AUTOMATISABLES** à cause de  
  la librairie `jqBootstrapValidation.js`.

---

## 🔖 Informations générales
| Champ | Valeur |
|-------|--------|
| **ID** | TC002 |
| **Module** | Frontend – Authentification Joueur |
| **Type** | Fonctionnel |
| **Criticité** | Haute |
| **Automatisation** | 🔴 Non automatisable |
| **Statut global** | ✔ Réussi en MANUEL |

---

## 🔧 Préconditions
- Navigateur : Chrome / Edge  
- URL :

```
https://handball-management.com/connexion/inscri_joueurs.php
```

---

## 📥 Données de test utilisées

| Cas | Email | Mot de passe |
|------|------------------------|----------------|
| Valide | admin@gmail.com | Azert123@ |
| Email incorrect | xxxx@gmail.com | Azert123@ |
| Mot de passe incorrect | admin@gmail.com | aaaaaa |

---

# ⭐ **TC002-S1 – Connexion valide**

### Étapes
1. Saisir email valide  
2. Saisir mot de passe valide  
3. Cliquer sur Connexion  

### 🎯 Résultat attendu
Redirection vers :

```
les_interfaces/joueurs_club.php
```

### ✔ Résultat obtenu
Identique → connexion réussie

### 📌 Statut
✔ Réussi (MANUEL)  
🔴 Non automatisable

---

# ⚠️ **TC002-S2 – Email incorrect**

### Résultat attendu
Afficher :

> "L'email n'existe pas."

### ✔ Résultat obtenu
Message identique

### 📌 Statut
✔ Réussi (MANUEL)  
🔴 Non automatisable

---

# ⚠️ **TC002-S3 – Mot de passe incorrect**

### Résultat attendu
Afficher :

> "Le mot de passe n'est pas correct."

### ✔ Résultat obtenu
Message identique

### 📌 Statut
✔ Réussi (MANUEL)  
🔴 Non automatisable

---

# 🚫 Motif de NON AUTOMATISATION (réel)

Les champs du formulaire utilisent :

```
jqBootstrapValidation.js
```

Cette librairie bloque Selenium :  
- `sendKeys()` ne fonctionne pas  
- focus intercepté  
- `blur/change` désactivés  
- `submit()` bloqué  
- erreurs WebDriver → `ElementNotInteractableException`, `Timeout`

➡ **Conclusion : tests 100% MANUELS**

---

# 🧾 Rédigé par  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Novembre 2025  
📍 Projet : Handball Management – FRONTEND  
