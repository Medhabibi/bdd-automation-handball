# 📑 Test Cases – Handball Management

## 🏷️ Module : Inscription Joueur

| **ID**  | **Titre du Test**                  | **Préconditions**                | **Étapes**                                                                 | **Résultat Attendu**                          |
|---------|-------------------------------------|----------------------------------|-----------------------------------------------------------------------------|-----------------------------------------------|
| TC001   | Inscription valide d’un joueur      | L’utilisateur est sur inscription | 1. Remplir tous les champs valides <br> 2. Cliquer sur "S’inscrire"        | Joueur inscrit avec succès + message confirmé |
| TC002   | Champ email vide                    | Idem                             | 1. Laisser email vide <br> 2. Remplir autres champs <br> 3. S’inscrire     | Message **"Email obligatoire"**               |
| TC003   | Format email invalide               | Idem                             | 1. Email = "abc.com" <br> 2. Remplir autres champs <br> 3. S’inscrire      | Message **"Format email invalide"**           |
| TC004   | Mot de passe trop court             | Idem                             | 1. Mot de passe = "123" <br> 2. Remplir autres champs <br> 3. S’inscrire   | Message **"Mot de passe trop court"**         |
| TC005   | Âge non numérique                   | Idem                             | 1. Entrer texte "abc" dans champ Âge <br> 2. S’inscrire                    | Message **"Âge doit être un nombre"**         |
| TC006   | Pays non sélectionné                | Idem                             | 1. Ne pas choisir un pays <br> 2. Remplir autres champs <br> 3. S’inscrire | Message **"Veuillez sélectionner un pays"**   |

---

## 🏷️ Module : Login Joueur

| **ID**  | **Titre du Test**                  | **Préconditions**                 | **Étapes**                                                                 | **Résultat Attendu**                           |
|---------|-------------------------------------|-----------------------------------|-----------------------------------------------------------------------------|------------------------------------------------|
| TC007   | Connexion avec identifiants valides | Joueur existe dans la base        | 1. Email correct <br> 2. Mot de passe correct <br> 3. Login                 | Redirection vers accueil joueur                |
| TC008   | Email incorrect                     | Joueur existe                     | 1. Mauvais email <br> 2. Login                                              | Message **"Identifiants incorrects"**          |
| TC009   | Mot de passe incorrect              | Joueur existe                     | 1. Email correct <br> 2. Mot de passe faux <br> 3. Login                    | Message **"Identifiants incorrects"**          |
| TC010   | Champs vides                        | -                                 | 1. Ne rien saisir <br> 2. Cliquer Login                                     | Message **"Champs obligatoires"**              |
| TC011   | Vérifier lien "Mot de passe oublié" | -                                 | 1. Cliquer sur lien "Mot de passe oublié"                                   | Redirection page récupération mot de passe     |
| TC012   | Vérifier bouton "Créer un compte"   | -                                 | 1. Cliquer sur "Créer un compte"                                            | Redirection vers la page inscription           |
