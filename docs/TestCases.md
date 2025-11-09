# 📑 Test Cases – Handball Management

Ce document présente les cas de test manuels pour les modules **Inscription** et **Login Joueur** du projet *Handball Management*.  
Chaque test suit le modèle ISTQB : ID, préconditions, étapes, résultat attendu et lien avec les anomalies.

---

## 🏷️ Module : Inscription Joueur

| **ID**  | **Titre du Test**               | **Préconditions**                | **Étapes**                                                                 | **Résultat Attendu**                          |
|---------|---------------------------------|----------------------------------|-----------------------------------------------------------------------------|-----------------------------------------------|
| TC001   | Inscription valide d’un joueur  | L’utilisateur est sur la page d’inscription | 1️⃣ Remplir tous les champs valides <br> 2️⃣ Cliquer sur *S’inscrire* | ✅ Joueur inscrit avec succès + message confirmé |
| TC002   | Champ email vide                | Idem                             | 1️⃣ Laisser email vide <br> 2️⃣ Remplir autres champs <br> 3️⃣ S’inscrire | ⚠️ Message : *"Email obligatoire"* |
| TC003   | Format email invalide           | Idem                             | 1️⃣ Email = `abc.com` <br> 2️⃣ Remplir autres champs <br> 3️⃣ S’inscrire | ⚠️ Message : *"Format email invalide"* |
| TC004   | Mot de passe trop court         | Idem                             | 1️⃣ Mot de passe = `123` <br> 2️⃣ Remplir autres champs <br> 3️⃣ S’inscrire | ⚠️ Message : *"Mot de passe trop court"* |
| TC005   | Âge non numérique               | Idem                             | 1️⃣ Champ âge = `abc` <br> 2️⃣ Cliquer sur *S’inscrire* | ⚠️ Message : *"Âge doit être un nombre"* |
| TC006   | Pays non sélectionné            | Idem                             | 1️⃣ Ne pas choisir de pays <br> 2️⃣ S’inscrire | ⚠️ Message : *"Veuillez sélectionner un pays"* |

---

## 🏷️ Module : Login Joueur

| **ID**  | **Titre du Test**                  | **Préconditions**                 | **Étapes**                                                                 | **Résultat Attendu**                           |
|---------|-------------------------------------|-----------------------------------|-----------------------------------------------------------------------------|------------------------------------------------|
| TC007   | Connexion valide                    | Joueur existant                   | 1️⃣ Email correct <br> 2️⃣ Mot de passe correct <br> 3️⃣ Cliquer *Login* | ✅ Redirection vers le tableau de bord |
| TC008   | Email incorrect                     | Joueur existant                   | 1️⃣ Email invalide <br> 2️⃣ Mot de passe valide <br> 3️⃣ *Login* | ❌ Message : *"Identifiants incorrects"* |
| TC009   | Mot de passe incorrect              | Joueur existant                   | 1️⃣ Email correct <br> 2️⃣ Mauvais mot de passe <br> 3️⃣ *Login* | ❌ Message : *"Identifiants incorrects"* |
| TC010   | Champs vides                        | Aucun                             | 1️⃣ Laisser les champs vides <br> 2️⃣ Cliquer *Login* | ⚠️ Message : *"Champs obligatoires"* |
| TC011   | Lien “Mot de passe oublié”          | Aucun                             | 1️⃣ Cliquer sur le lien “Mot de passe oublié” | 🔁 Redirection vers page récupération |
| TC012   | Bouton “Créer un compte”            | Aucun                             | 1️⃣ Cliquer sur “Créer un compte” | 🔁 Redirection vers la page inscription |

---

## 🔗 Liens de traçabilité

| **Cas de Test** | **Bug Lié** | **Description** |
|------------------|-------------|-----------------|
| TC005 | [BUG002](BugReports.md#bug002--le-champ-âge-accepte-du-texte) | Champ âge accepte du texte |
| TC008 / TC009 | [BUG001](BugReports.md#bug001--absence-de-message-derreur-lors-dun-login-incorrect) | Login sans message d’erreur |
| TC010 | [BUG003](BugReports.md#bug003--le-bouton-login-reste-actif-avec-champs-vides) | Bouton actif champs vides |

---

## 📊 Statistiques du module

| Module | Nombre de tests | Tests PASS | Tests FAIL | Taux de réussite |
|---------|------------------|-------------|-------------|------------------|
| Inscription Joueur | 6 | 5 | 1 | 83% |
| Login Joueur | 6 | 4 | 2 | 67% |
| **Total global** | **12** | **9** | **3** | **75%** |

---

✍️ **Rédigé par :**  
**Mohamed Taib Ben Salha** – QA Engineer  
📅 Dernière mise à jour : Novembre 2025  
📍 Projet : *Handball Management – QA Automation*
