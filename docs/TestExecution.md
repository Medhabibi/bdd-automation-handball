# 📊 Test Execution – Handball Management 

Ce document présente l’exécution **réelle** des cas de test du projet  
**Handball Management (Frontend – Joueurs / Navigation)**.

Les résultats sont basés sur des tests **effectivement réalisés**,  
manuels et automatisés, entre Novembre 2025.

---

# 📋 Table des matières

1. [Résumé global d’exécution](#resume-global)
2. [Détails d’exécution – Par test case](#details)
   - TC001 – Navigation Managers
   - TC002 – Connexion Joueur (3 sous-tests)

---

# 🧩 <a name="resume-global"></a> Résumé global d’exécution

| ID Test | Description | Statut | Automatisation | Commentaire |
|--------|-------------|---------|----------------|-------------|
| **TC001** | Navigation menu → lien "Managers" | ❌ Échoué | 🟢 Automatisable | Bug réel trouvé (BUG001) |
| **TC002-S1** | Login Joueur – Identifiants valides | ✔ Réussi (manuel) | 🔴 Non automatisable | Bloqué par script JS jqBootstrapValidation |
| **TC002-S2** | Login Joueur – Email incorrect | ✔ Réussi (manuel) | 🔴 Non automatisisable | Messages d’erreur OK |
| **TC002-S3** | Login Joueur – Mot de passe incorrect | ✔ Réussi (manuel) | 🔴 Non automatisisable | Messages d’erreur OK |

---

# 🧭 <a name="details"></a> Détail complet d’exécution – Test par test

---

# 🧩 **TC001 – Navigation menu “Managers”**  
### Résultat : ❌ **Échoué (réel)**  
### Automatisation : 🟢 **Oui (test automatisable)**  
### Bug lié : **BUG001 – Ouvert**

---

## 🔍 Informations d’exécution

| Élément | Valeur |
|--------|--------|
| **Date** | Novembre 2025 |
| **Navigateur** | Chrome 142 / Edge 142 |
| **URL** | https://www.handball-management.com/index.php |
| **Tester** | Mohamed Taib Ben Salha (QA Engineer) |

---

## 📝 Étapes exécutées
1. Ouvrir la page d’accueil.  
2. Cliquer sur le menu **Managers**.  
3. Observer la page affichée.

---

## 🎯 Résultat attendu
Page dédiée Managers :  
`connexion/inscri_equipe.php`  
ou interface Manager.

---

## ❌ Résultat obtenu (réel)
Redirection vers :  
`connexion/inscri_joueurs.php`

➡ Le test est **échoué** car **le lien HTML est mauvais**.

---

## 📎 Évidence technique
```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

---

## 📌 Conclusion
- Défaut confirmé  
- Bug documenté → **BUG001**  
- Test **à automatiser** dans la suite du projet

---

---

# 🧩 **TC002 – Connexion Joueur (3 scénarios)**  
➡ Tests réalisés en **manuel** (réels)  
➡ Automatisation **impossible** avec Selenium → documenté

---

# ⭐ **TC002-S1 – Connexion joueur – Identifiants valides**

| Élément | Valeur |
|--------|--------|
| Résultat | ✔ Réussi (manuel) |
| Automatisation | 🔴 Non automatisable |
| Notes | Redirection correcte vers joueurs_club.php |

### 🔍 Détails réels
- Email : admin@gmail.com  
- MDP : Azert123@  
- Résultat : Dashboard OK ✔  
- Selenium : ❌ Blocage → ElementNotInteractableException

---

# ⚠️ **TC002-S2 – Email incorrect**

| Élément | Valeur |
|--------|--------|
| Résultat | ✔ Réussi (manuel) |
| Automatisation | 🔴 Non automatisable |
| Message attendu | *"L'email n'existe pas."* |
| Message observé | ✔ Correct |

---

# ⚠️ **TC002-S3 – Mot de passe incorrect**

| Élément | Valeur |
|--------|--------|
| Résultat | ✔ Réussi (manuel) |
| Automatisation | 🔴 Non automatisisable |
| Message attendu | *"Le mot de passe n'est pas correct."* |
| Message observé | ✔ Correct |

---

# 🚫 Pourquoi TC002 est NON AUTOMATISABLE ? (réel)

Le formulaire utilise **jqBootstrapValidation**, un script JS qui :  
- bloque les événements clavier  
- empêche l’interaction WebDriver  
- intercepte le `submit`  
- produit des erreurs : ElementNotInteractableException  
- rend Selenium incapable de taper dans les champs

➡ Résultat : **Test instable et non fiable** → NON AUTOMATISABLE

Mentionné dans **BugReports.md + TestCases.md**

---

# 🧾 Signature

✍️ Rédigé par :  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Novembre 2025  
📍 Projet : Handball Management – QA   
