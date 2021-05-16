# Java Card Game

This project is built with IDE Eclipse.

Like the name of this project, I have made a  card game and the rules are rather complicate.

- starting interface

  ![image-20210517000225202](\images_de_projet\image-20210517000225202.png)

- Setting interface

  ![image-20210517000303407](\images_de_projet\image-20210517000303407.png)

- Playing interface

  ![image-20210517000326060](\images_de_projet\image-20210517000326060.png)

  ![image-20210517000359605](\images_de_projet\image-20210517000359605.png)

## Introduction

It is possible to play this game with 3 or 4 persons or otherwise some virtual players are provided.

There are three levels of difficulties with these virtual players, which are Easy, Normal, Difficult. This part is the implementation of the Strategy Design Pattern.

And it's possible to play in the terminal and in the graphic interface in the same time, which is realized by Multi-Thread.



- **Design Patterns** in this project

    - Visitor

      ... used for calculate the score of each player. After each round of game, the class of `Visitor` will visit each player's hand cards and calculate their score of this round.

      file : /src/CARD/VisitordeJest.java



- Strategy

  ... used for building the virtual players which has three levels of difficulties.

  file : /src/Liverable_1/Com-easy.java & Com_impossible.java & Com_normal.java



- Singleton

  ... used for many classes to keep the changes in memory like the the card deck which is the distributor of the cards.

  file : /src/CARD/Draw_deck.java



- Iterator

  ... used for traverse all the Collections used in the project

  file : /src/CARD/Draw_deck.java



- **Swing Graphic**

  all of classes in the folder `Vue` of the project.

  example :

  ![image-20210517001122174](\images_de_projet\image-20210517001122174.png)

- **VMC structure**

  ![image-20210517000632899](\images_de_projet\image-20210517000632899.png)

- **Multi-Thread**

  ![image-20210517001255824](\images_de_projet\image-20210517001255824.png)

## Resources

- UML of classes

  ![img](\images_de_projet\Diag_class_uml.jpg)

- Rules

  ![image-20210517000058940](\images_de_projet\image-20210517000058940.png)

  >  copy right of the rule belongs to www.goodlittlegames.co.uk