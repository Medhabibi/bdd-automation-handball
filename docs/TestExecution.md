# 📊 Test Execution – Handball Management

Ce rapport présente les **résultats d’exécution des tests manuels** pour le projet *Handball Management*.  
Les tests ont été exécutés dans le cadre du **Sprint 1** (modules Inscription + Login Joueur).

---

## 🏷️ Résultats d’exécution (Sprint 1)

| **ID Test** | **Titre du Test**              | **Résultat Attendu**              | **Résultat Obtenu**                  | **Statut** | **Bug lié** |
|-------------|--------------------------------|------------------------------------|--------------------------------------|-------------|-------------|
| TC001 | Inscription valide | Joueur inscrit avec succès | Joueur inscrit correctement | ✅ **Pass** | - |
| TC002 | Email vide | "Email obligatoire" | Message affiché | ✅ **Pass** | - |
| TC003 | Email invalide | "Format email invalide" | Message affiché | ✅ **Pass** | - |
| TC004 | Mot de passe trop court | "Mot de passe trop court" | Message affiché | ✅ **Pass** | - |
| TC005 | Âge non numérique | "Âge doit être un nombre" | Formulaire accepté → bug | ❌ **Fail** | [BUG002](BugReports.md#bug002--âge-accepte-du-texte) |
| TC006 | Pays non sélectionné | "Veuillez sélectionner un pays" | Message affiché | ✅ **Pass** | - |
| TC007 | Connexion valide | Redirection accueil joueur | Redirection correcte | ✅ **Pass** | - |
| TC008 | Email incorrect | "Identifiants incorrects" | Aucun message → bug | ❌ **Fail** | [BUG001](BugReports.md#bug001--message-derreur-absent-lors-dun-login-incorrect) |
| TC009 | Mot de passe incorrect | "Identifiants incorrects" | Aucun message → bug | ❌ **Fail** | [BUG001](BugReports.md#bug001--message-derreur-absent-lors-dun-login-incorrect) |
| TC010 | Champs vides | "Champs obligatoires" | Bouton actif → bug | ❌ **Fail** | [BUG003](BugReports.md#bug003--bouton-login-actif-si-champs-vides) |
| TC011 | Lien “Mot de passe oublié” | Redirection récupération | Redirection correcte | ✅ **Pass** | - |
| TC012 | Bouton “Créer un compte” | Redirection page inscription | Redirection correcte | ✅ **Pass** | - |

---

## 📈 Statistiques globales

| **Catégorie** | **Valeur** |
|----------------|------------|
| Nombre total de tests | 12 |
| Tests réussis (Pass) | 8 |
| Tests échoués (Fail) | 4 |
| **Taux de réussite global** | **66%** |
| Bugs critiques détectés | 3 |
| Modules testés | Inscription / Login Joueur |

---

## 🔎 Analyse des résultats

- ✅ **8 tests réussis** : la majorité des parcours utilisateurs fonctionnent.
- ❌ **4 tests échoués** :
  - **BUG001** → Absence de message d’erreur lors d’un login incorrect.  
  - **BUG002** → Le champ âge accepte du texte.  
  - **BUG003** → Le bouton Login reste actif même avec des champs vides.
- 📌 Ces anomalies sont classées en **haute priorité**, car elles affectent l’expérience utilisateur et la validation côté client.

---

## 🧩 Conclusion

La version testée du module Handball Management est **fonctionnelle à 66%**.  
Les points critiques concernent la **validation des formulaires** et le **feedback utilisateur** lors d’un échec de connexion.

➡️ Les correctifs seront revérifiés au **Sprint 2**, suivis d’une régression sur les modules Inscription & Login.

---

✍️ **Rédigé par :**  
**Mohamed Taib Ben Salha** – QA Engineer | ISTQB Certified  
📅 Dernière mise à jour : Novembre 2025  
📍 Projet : *Handball Management – QA Automation*
