# 📊 Test Execution – Handball Management (Réel)

Ce document présente l’exécution **réelle** des cas de test du projet  
**Handball Management – Frontend (Navigation & Connexions)**.

Les résultats reflètent les tests **effectivement réalisés**, manuels et automatisés,  
entre Novembre 2025.

---

# 📋 Table des matières

1. [Résumé global d’exécution](#resume-global)
2. [Détails d’exécution – Par test case](#details)
   - TC001 – Navigation Managers
   - TC002 – Connexion Joueur (3 sous-tests réels)

---

# 🧩 <a name="resume-global"></a> Résumé global d’exécution

| ID Test | Description | Statut | Automatisation | Commentaire |
|--------|-------------|---------|----------------|-------------|
| **TC001** | Navigation menu → lien "Managers" | ❌ Échoué | 🟢 Automatisable | Bug réel trouvé → **BUG001** |
| **TC002-S1** | Login Joueur – Identifiants valides | ✔ Réussi (manuel) | 🔴 Non automatisable | Bloqué par script JS `jqBootstrapValidation` |
| **TC002-S2** | Login Joueur – Email incorrect | ✔ Réussi (manuel) | 🔴 Non automatisisable | Message d’erreur correct |
| **TC002-S3** | Login Joueur – Mot de passe incorrect | ✔ Réussi (manuel) | 🔴 Non automatisisable | Message d’erreur correct |

---

# 🧭 <a name="details"></a> Détails complets d’exécution

---

# 🧩 **TC001 – Navigation menu “Managers”**

### ✔ Informations générales
| Élément | Valeur |
|--------|--------|
| **Résultat** | ❌ ÉCHOUÉ |
| **Automatisation** | 🟢 Oui |
| **Bug lié** | **BUG001 – Ouvert** |
| **Date** | Novembre 2025 |
| **Navigateurs** | Chrome 142 / Edge 142 |
| **URL testée** | https://www.handball-management.com/index.php |
| **Tester** | Mohamed Taib Ben Salha |

---

## 📝 Étapes exécutées
1. Accéder à la page d’accueil.  
2. Cliquer sur **Managers** dans le menu principal.  
3. Observer la page redirigée.

---

## 🎯 Résultat attendu
L’utilisateur doit être redirigé vers la page dédiée aux managers :

```
connexion/inscri_equipe.php
```

---

## ❌ Résultat obtenu (réel)
Redirection vers :

```
connexion/inscri_joueurs.php
```

➡ Mauvaise URL → Mauvaise interface → Bug confirmé.

---

## 📎 Évidence technique (HTML réel)

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

➡ Le lien pointe vers **club_joueurs.php** → incorrect.

---

## 📌 Conclusion
- Bug confirmé  
- Bug documenté sous **BUG001**  
- Test restera **à automatiser** dans la suite du projet

---

---

# 🧩 **TC002 – Connexion Joueur (3 scénarios réels)**

👉 Ces tests ont été réalisés en **manuel**, car **NON AUTOMATISABLES**  
(dû au script JS bloquant Selenium).

---

# ⭐ **TC002-S1 – Connexion Joueur (valide)**

| Élément | Valeur |
|--------|--------|
| **Résultat** | ✔ Réussi (manuel) |
| **Automatisation** | 🔴 NON AUTOMATISABLE |
| **Comportement attendu** | Redirection tableau de bord |
| **Résultat obtenu** | ✔ Redirection OK |
| **URL finale** | `les_interfaces/joueurs_club.php` |

### Notes
- Le comportement utilisateur réel est correct  
- Selenium → ❌ échoue systématiquement (blocage JS)

---

# ⚠️ **TC002-S2 – Email incorrect**

| Élément | Valeur |
|--------|--------|
| **Résultat** | ✔ Réussi (manuel) |
| **Automatisation** | 🔴 NON AUTOMATISABLE |
| **Message attendu** | "L'email n'existe pas." |
| **Message obtenu** | ✔ Identique |

---

# ⚠️ **TC002-S3 – Mot de passe incorrect**

| Élément | Valeur |
|--------|--------|
| **Résultat** | ✔ Réussi (manuel) |
| **Automatisation** | 🔴 NON AUTOMATISABLE |
| **Message attendu** | "Le mot de passe n'est pas correct." |
| **Message obtenu** | ✔ Identique |

---

# 🚫 Pourquoi TC002 est NON AUTOMATISABLE ? (Réel)

Le formulaire utilise **jqBootstrapValidation**, un script qui :

- bloque les événements clavier  
- intercepte `input`, `blur`, `change`  
- empêche le `submit` natif  
- empêche WebDriver d’envoyer du texte réel  
- génère des erreurs :  
  - `ElementNotInteractableException`  
  - `Timeout waiting for visibility`  

➡ **Automatisation instable + impossible → Test 100% manuel**

Mentionné également dans :
- **BugReports.md**
- **TestCases.md**

---

# 🧾 Signature

✍️ Rédigé par :  
**Mohamed Taib Ben Salha – QA Engineer**  
📅 Novembre 2025  
📍 Projet : Handball Management – QA Réel  
