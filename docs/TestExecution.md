# 📊 Test Execution – Handball Management

## 🏷️ Sprint 1 – Résultats d’exécution (Inscription + Login Joueur)

| **ID Test** | **Titre du Test**               | **Résultat Attendu**             | **Résultat Obtenu**                 | **Statut** | **Bug lié** |
|-------------|----------------------------------|-----------------------------------|--------------------------------------|------------|-------------|
| TC001       | Inscription valide               | Joueur inscrit avec succès        | Joueur inscrit correctement          | ✅ Pass    | -           |
| TC002       | Email vide                       | "Email obligatoire"               | Message affiché                      | ✅ Pass    | -           |
| TC003       | Email invalide                   | "Format email invalide"           | Message affiché                      | ✅ Pass    | -           |
| TC004       | Mot de passe trop court          | "Mot de passe trop court"         | Message affiché                      | ✅ Pass    | -           |
| TC005       | Âge non numérique                | "Âge doit être un nombre"         | Formulaire accepté → bug             | ❌ Fail    | BUG002      |
| TC006       | Pays non sélectionné             | "Sélectionner un pays"            | Message affiché                      | ✅ Pass    | -           |
| TC007       | Connexion OK                     | Redirection accueil joueur        | Redirection correcte                 | ✅ Pass    | -           |
| TC008       | Email incorrect                  | "Identifiants incorrects"         | Aucun message → bug                  | ❌ Fail    | BUG001      |
| TC009       | Mot de passe incorrect           | "Identifiants incorrects"         | Aucun message → bug                  | ❌ Fail    | BUG001      |
| TC010       | Champs vides                     | "Champs obligatoires"             | Bouton actif → bug                   | ❌ Fail    | BUG003      |
| TC011       | Lien mot de passe oublié         | Redirection récupération          | Redirection correcte                 | ✅ Pass    | -           |
| TC012       | Bouton "Créer un compte"         | Redirection page inscription      | Redirection correcte                 | ✅ Pass    | -           |

---

## 🔎 Analyse des résultats
- ✅ **Pass** : 8 tests réussis  
- ❌ **Fail** : 4 tests échoués  
- **Bugs détectés** :  
  - **BUG001** → Login KO sans message  
  - **BUG002** → Âge accepte du texte  
  - **BUG003** → Bouton login actif champs vides  

📌 Les anomalies critiques concernent :  
1. **Login sans feedback utilisateur** (haute sévérité).  
2. **Validation insuffisante des champs (âge, login)**.  

