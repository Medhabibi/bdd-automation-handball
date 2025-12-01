# 📊 Test Execution – Handball Management (Frontend)
Résultats RÉELS des campagnes QA : Navigation, Connexions, Inscriptions.

---

## 📋 Résumé global d'exécution

| Test ID | Description | Statut | Auto | Commentaire |
|---------|-------------|---------|--------|-------------|
| TC001 | Navigation menu → Managers | ❌ | Oui | Mauvaise redirection → BUG001 |
| TC002 | Connexion Joueur | ✔ | Non | Script JS bloque Selenium (BUG002) |
| TC003 | Connexion Entraîneur | ✔ | Non | BUG002 |
| TC004 | Connexion Manager | ✔ | Non | BUG002 |
| TC005 | Connexion Préparateur | ✔ | Non | BUG002 |
| TC006 | Navigation login | ✔ | Oui | Comportement conforme |
| TC007 | Inscription Joueur | ✔ | Oui | Message + redirection OK |
| TC008 | Inscription Entraîneur | ✔ | Oui | OK |
| TC009 | Inscription Manager | ✔ | Oui | OK |
| TC010 | Email existant | ✔ | Oui | Message d’erreur affiché |

---

# 🧩 TC001 – Navigation “Managers”
❌ Échoué  
Mauvaise redirection confirmée.  
Bug enregistré : **BUG001**

---

# 🧩 TC002 → TC005 – Connexions (tous profils)
✔ Fonctionnel OK  
❌ Automatisation impossible → **BUG002**  
Motifs : blocage des événements clavier, submit, focus.

---

# 🧩 TC006 – Navigation depuis écrans de login
✔ Réussi  
Automatisation stable.

---

# 🧩 TC007 – Inscription Joueur
✔ Réussi  
- Champs obligatoires OK  
- Message succès OK  
- Redirection OK

---

# 🧩 TC008 – Inscription Entraîneur
✔ Réussi

---

# 🧩 TC009 – Inscription Manager
✔ Réussi

---

# 🧩 TC010 – Email existant (Entraîneur)
✔ Réussi  
Le système empêche la duplication.

---

✍️ Rédigé par : **Mohamed Taib Ben Salha – QA Engineer**
