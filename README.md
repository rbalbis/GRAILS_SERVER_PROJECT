# TP Grails Robin BALBIS - Geoffrey ROMAN
N'ayant pas tout de suite compris que le tp se portait uniquement sur la partie administration, nous avons modifié le système de messagerie pour qu'un utilisateur puisse voir uniquement les messages qui le concerne et l'administrateur puisse voir tous les messages

Le schema des principales relations se trouve dans le fichier Grails_Diagram_Relation 

Les identifiants pour la connections sont :
- compte administrateur username : admin  password : mdp
- compte utilisateur1 username : username1  password : mdp
- compte utilisateur2 username : username2  password : password

La collection postman est disponible en suivant [ce lien](https://www.getpostman.com/collections/57d471b9b311ede4d427)
La documentation de l'api REST est disponible [ici]( https://documenter.getpostman.com/view/5486241/RWgrxxYh)


Les images dans le dossier htdocs sont a mettre dans le dossier htdocs du serveur.

Bonus réalisé : 
- Upload des images grâce au drag&drop en ajax avant l'envoie du formulaire sur les pages de creation et d'edition d'un utilisateur.
- Securisation de l'api rest en fonction du type de compte (user ou admin n'ont pas acces aux mêmes fonction)
- Securisation de l'api grâce aux de tokens
