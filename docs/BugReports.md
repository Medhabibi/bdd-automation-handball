# 🐞 Bug Reports – Handball Management

Ce document répertorie les anomalies détectées lors des campagnes de test du module **Handball Management**.  
Chaque bug est documenté selon les standards ISTQB : ID unique, description, sévérité, priorité et reproductibilité.

---

## 🧩 Résumé global

| 🔢 Total Bugs | 🟥 Critiques | 🟧 Moyens | 🟨 Mineurs | ⚙️ Corrigés | ⏳ Ouverts |
|---------------|--------------|-----------|------------|-------------|------------|
| 3 | 1 | 1 | 1 | 0 | 3 |

---

## 🐞 Détails des anomalies

### **BUG001 – Absence de message d’erreur lors d’un login incorrect**
| Champ | Détail |
|-------|--------|
| **ID** | BUG001 |
| **Module** | Login Joueur |
| **Étapes pour reproduire** | 1️⃣ Email valide + 2️⃣ Mot de passe incorrect + 3️⃣ Cliquer sur *Connexion* |
| **Résultat attendu** | Un message d’erreur clair : **"Identifiants incorrects"** |
| **Résultat obtenu** | Aucun message affiché → retour silencieux |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Statut** | 🟡 Ouvert |
| **Reproductibilité** | Toujours |
| **Cas de test liés** | [TC008](TestCases.md#module--login-joueur) / [TC009](TestCases.md#module--login-joueur) |

---

### **BUG002 – Le champ “Âge” accepte du texte**
| Champ | Détail |
|-------|--------|
| **ID** | BUG002 |
| **Module** | Inscription Joueur |
| **Étapes pour reproduire** | 1️⃣ Aller sur le formulaire d’inscription <br> 2️⃣ Champ “Âge” = `abc` <br> 3️⃣ Cliquer sur *S’inscrire* |
| **Résultat attendu** | Message : **"L’âge doit être un nombre"** |
| **Résultat obtenu** | Formulaire accepté → validation défaillante |
| **Sévérité** | Moyenne |
| **Priorité** | Moyenne |
| **Statut** | 🟡 Ouvert |
| **Reproductibilité** | Toujours |
| **Cas de test lié** | [TC005](TestCases.md#module--inscription-joueur) |

---

### **BUG003 – Le bouton “Login” reste actif avec champs vides**
| Champ | Détail |
|-------|--------|
| **ID** | BUG003 |
| **Module** | Login Joueur |
| **Étapes pour reproduire** | 1️⃣ Laisser les champs email et mot de passe vides <br> 2️⃣ Cliquer sur *Connexion* |
| **Résultat attendu** | Bouton désactivé tant que les champs sont vides |
| **Résultat obtenu** | Bouton cliquable → rechargement inutile |
| **Sévérité** | Basse |
| **Priorité** | Moyenne |
| **Statut** | 🟡 Ouvert |
| **Reproductibilité** | Toujours |
| **Cas de test lié** | [TC010](TestCases.md#module--login-joueur) |

---

## 📈 Synthèse des anomalies

| Catégorie | Nombre | Pourcentage |
|------------|----------|-------------|
| 🟥 Critiques | 1 | 33% |
| 🟧 Moyens | 1 | 33% |
| 🟨 Mineurs | 1 | 33% |
| ⚙️ Corrigés | 0 | 0% |

📌 **Analyse :**
- Le module **Login Joueur** présente plusieurs anomalies de validation.
- Aucune erreur bloquante pour la navigation générale, mais **l’expérience utilisateur est dégradée**.
- Ces anomalies doivent être corrigées avant l’intégration en production.

---

✍️ **Rédigé par :**  
**Mohamed Taib Ben Salha** – QA Engineer  
📅 Date de mise à jour : Novembre 2025  
📍 Projet : *Handball Management – QA Automation*
