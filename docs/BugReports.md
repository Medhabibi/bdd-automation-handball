# 🐞 Bug Reports – Handball Management 

Ce document contient **uniquement les anomalies réellement détectées**
lors des tests manuels et automatisés du projet **Handball Management**.

Chaque bug est documenté selon les standards QA/ISTQB :
ID unique, sévérité, priorité, reproductibilité, environnement et analyse technique.

---

## 🧩 Résumé global des anomalies réelles

| 🔢 Total Bugs | 🟥 Critiques | 🟦 Hautes | 🟧 Moyennes | 🟨 Mineures | ⚙️ Corrigés | ⏳ Ouverts |
|--------------|--------------|-----------|------------|------------|------------|-----------|
| **1** | 0 | **1** | 0 | 0 | 0 | **1** |

---

# 🐞 Détails des anomalies réelles

---

## **BUG001 – Le menu “Managers” redirige vers la page Joueurs**

| Champ | Détail |
|-------|--------|
| **ID** | BUG001 |
| **Module** | Frontend – Menu principal |
| **Type de test** | Test automatisé + vérification manuelle |
| **Environnement** | Windows 11 – Chrome 142 – https://www.handball-management.com |
| **Statut** | 🟡 Ouvert |
| **Sévérité** | Haute |
| **Priorité** | Haute |
| **Reproductibilité** | Toujours |

---

### 🔁 Étapes pour reproduire :

1. Ouvrir : https://www.handball-management.com/index.php  
2. Cliquer sur **“Managers”** dans le menu principal  
3. Observer la redirection

---

### ✅ Résultat attendu :
Redirection vers **la page Managers**, ex : `connexion/inscri_equipe.php`

---

### ❌ Résultat obtenu :
Redirection vers **la page Joueurs** :

```
https://handball-management.com/connexion/inscri_joueurs.php
```

---

### 🔍 Analyse technique :

```html
<a class="nav-link" href="les_interfaces/club_joueurs.php">Managers</a>
```

➡ Mauvais lien → pointe vers **club_joueurs.php**.

---

### 🎯 Impact :

- Le rôle *Manager* devient inaccessible  
- Parcours utilisateur bloqué  
- Bug présent en production  
- Impact fonctionnel majeur

---

### 🧪 Tests automatisés liés :

- Feature : frontend/navigation.feature  
- Scénario : Accès menu Managers  
- Tag : `@bug_menu_managers`

---

### 📎 Preuves à conserver :

- Capture du menu “Managers”
- Capture de l’URL obtenue
- Extrait HTML du lien
- Logs Cucumber/Selenium montrant la mauvaise URL

---

## ❌ Test NON AUTOMATISABLE

Ce bug a été découvert en automatisation,  
**mais le test de connexion Joueur lié reste NON AUTOMATISABLE** pour les raisons suivantes :

### **Motif technique :**

Le formulaire de connexion utilise **jqBootstrapValidation**, un plugin JS qui :

- intercepte les événements `input`, `change`, `keyup`, `blur`  
- bloque l’interaction Selenium quand les champs ne sont pas “validés” côté JS  
- empêche l’écriture directe via WebDriver dans certains navigateurs modernes  
- injecte des conditions dynamiques avant l’envoi du formulaire  

### **Conclusion :**
Le test d'automatisation devient :

- instable  
- non déterministe  
- non fiable en CI/CD  

👉 **Classification QA : Test NON AUTOMATISABLE (formulaire incompatible avec Selenium).**

Ce statut est **officiel** et doit être indiqué dans `TestExecution.md`.

---

### ✍️ Auteur & Historique
- **Rédigé par :** Mohamed Taib Ben Salha – QA Engineer  
- **Dernière mise à jour :** Novembre 2025  
- **Projet :** Handball Management – QA 
