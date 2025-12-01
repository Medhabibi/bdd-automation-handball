# 🧪 Test Cases – Handball Management (Frontend)
Document basé à 100% sur les tests RÉELS exécutés dans le Frontend : Navigation, Connexions, Inscriptions.

---

## 📋 Liste des cas de test (Frontend)

- TC001 – Navigation menu → Managers  
- TC002 – Connexion Joueur  
- TC003 – Connexion Entraîneur  
- TC004 – Connexion Manager  
- TC005 – Connexion Préparateur  
- TC006 – Navigation depuis écrans de login  
- TC007 – Inscription Joueur  
- TC008 – Inscription Entraîneur  
- TC009 – Inscription Manager  
- TC010 – Inscription Entraîneur → Email existant  

---

# 🧩 TC001 – Navigation “Managers”
**Type :** Manuel + Automatisable  
**Bug lié :** BUG001  
**Statut :** Échoué  

### Objectif  
Vérifier que le lien “Managers” redirige vers l’interface Manager.

### Étapes  
1. Ouvrir la page d’accueil  
2. Cliquer sur “Managers”  
3. Vérifier l’URL

### Attendu  
`connexion/inscri_equipe.php`

### Obtenu  
`connexion/inscri_joueurs.php`

---

# 🧩 TC002 – Connexion Joueur
**Type :** Manuel  
**Automatisation :** Impossible (BUG002)  
**Statut :** Réussi  

### Scénarios  
- Identifiants valides  
- Email incorrect  
- Mot de passe incorrect  

---

# 🧩 TC003 – Connexion Entraîneur
**Type :** Manuel  
**Automatisation :** Non (BUG002)  
**Statut :** Réussi  

---

# 🧩 TC004 – Connexion Manager
**Type :** Manuel  
**Automatisation :** Non  
**Statut :** Réussi  

---

# 🧩 TC005 – Connexion Préparateur
**Type :** Manuel  
**Automatisation :** Non  
**Statut :** Réussi  

---

# 🧩 TC006 – Navigation depuis les écrans de login
**Type :** Manuel + Automatisable  
**Statut :** Réussi  

---

# 🧩 TC007 – Inscription Joueur
**Type :** Manuel + Automatisable  
**Statut :** Réussi  

### Vérifications  
- Champs obligatoires  
- Message de succès  
- Redirection correcte  

---

# 🧩 TC008 – Inscription Entraîneur
**Type :** Manuel + Automatisable  
**Statut :** Réussi  

---

# 🧩 TC009 – Inscription Manager
**Type :** Manuel + Automatisable  
**Statut :** Réussi  

---

# 🧩 TC010 – Inscription Entraîneur – Email déjà existant
**Type :** Manuel + Automatisable  
**Statut :** Réussi  

---

✍️ Rédigé par : **Mohamed Taib Ben Salha – QA Engineer**
