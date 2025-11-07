# TP3 : Le jeu du pendu

Le but de ce TP est de créer un programme qui permette de jouer au jeu du Pendu, c’est-à-dire faire deviner un mot à l’utilisateur en lui permettant de proposer des lettres une à une, avec un nombre limité d’erreurs possibles.

Pour cette version, on considère que la 10ème erreur entraîne un Game Over.

1ère étape : Vous utiliserez une liste prédéfinie de mots de votre choix, prenez des mots simples pas trop longs. Au lancement de la partie, un mot aléatoire sera choisi (et l’utilisateur ne doit pas savoir lequel). On affiche ensuite un nombre de tiret égal au nombre de lettres dans le mot.

2ème étape : On demande à l’utilisateur d’entrer une lettre Si la lettre est dans le mot, on la révèle dans son ou ses emplacements dans notre affichage à tirets. Si le mot est révélé en entier, on gagne la partie.

Si la lettre n’est pas dans le mot, on informe l’utilisateur du nombre d’erreurs restantes avant le Game Over. Si on arrive à 10 erreurs, on affiche un message pour prévenir l’utilisateur, on affiche le mot et on arrête le programme.
Cette étape doit être répétée jusqu’à ce que l’utilisateur trouve le mot, ou jusqu’à ce qu’il perde.

3ème étape : Après avoir bien testé notre jeu, s’être assuré qu’il fonctionne avec des mots variés, qu’il est bien robuste, on peut l’améliorer :
A chaque tour, afficher la liste des lettres déjà proposées par le joueur qui ne sont pas dans le mot.
