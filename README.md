# Projet : Medical Cabinet


### Modélisation cabinet médical à domicile
#### Gestion des patients
- afficher tous les patients (patients + infirmiers liés à chaque patient)
- afficher patient par id
- afficher patient par nom
- créer un patient
- modifier un patient
- supprimer un patient (pas de suppression en BDD)

#### Gestion des infirmiers
- afficher tous les infirmiers
- afficher infirmier par id
- afficher infirmier par nom
- créer un infirmier
- modifier un infirmier
- supprimer un infirmier (pas de suppression en BDD)

#### Gestion des déplacements
- afficher déplacements par patient
- afficher déplacements par infirmier et par patient
- créer un déplacement
- modifier un déplacement
- supprimer un déplacement

### Attributs :
#### patient :
- nom
- prénom
- date de naissance
- sexe
- adresse
- numéro de sécu

#### infirmier :
- nom
- prénom
- numéro professionnel
- numéro tel mobile
- numéro tel fixe

#### déplacement :
- cout
- date

### Particularités :
- un patient n’a qu’un infirmier
- un infirmier à plusieurs patients
- un déplacement ne concerne qu’un patient

### Bonus :
- afficher le nombre d’infirmier qui se sont trouvés en déplacement pour une date donnée
- afficher le nombre total de déplacement pour un infirmier
- afficher le cout total des déplacements pour un patient

> ## API Specification
- **GET {uri}/infirmier**			:		*obtenir la liste de tous les infirmiers*
- **GET {uri}/infirmier/{id}**		 	:	*trouver informateur par identifiant*
- **GET {uri}/infirmier/search/{nom}**	:	*trouver infirmier par nom*
- **GET {uri}/{id}/patients**			:	*trouver des patients par un infirmier*

- **POST {uri}/infirmier + body**	:		*ajouter un infirmier*

- **PATCH {uri}/infirmier/{id}/add/patient** :	*ajouter un patient à l'infirmier*



- **GET {uri}/patient**				:    *obtenir une liste de tous les patients*
- **POST {uri}/patient/new**		:	*ajouter un nouveau patient*

- **GET {uri}/deplacements**		:	*obtenir tous les déplacements*
- **POST {uri}/deplacements**		:	*ajouter un nouveau déplacement*