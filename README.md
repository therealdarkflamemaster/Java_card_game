# Java Card Game

This project is built with IDE Eclipse.

Like the name of this project, I have made a  card game and the rules are rather complicate.

- starting interface

  ![image-20210517000225202](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000225202.png)

- Setting interface

  ![image-20210517000303407](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000303407.png)

- Playing interface

  ![image-20210517000326060](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000326060.png)

  ![image-20210517000359605](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000359605.png)

## Introduction

It is possible to play this game with 3 or 4 persons or otherwise some virtual players are provided.

There are three levels of difficulties with these virtual players, which are Easy, Normal, Difficult. This part is the implementation of the Strategy Design Pattern.

And it's possible to play in the terminal and in the graphic interface in the same time, which is realized by Multi-Thread.



- **Design Patterns** in this project

    - Visitor

      ... used for calculate the score of each player. After each round of game, the class of `Visitor` will visit each player's hand cards and calculate their score of this round.

      file : [VisitordeJest.java](https://github.com/therealdarkflamemaster/Java_card_game/tree/master/src/CARD/VisitordeJest.java)
      



  - Strategy

    ... used for building the virtual players which has three levels of difficulties.

    file : 
    > - [Com-easy.java](https://github.com/therealdarkflamemaster/Java_card_game/blob/master/src/Livrable_1/Com_easy.java)
    > - [Com_normal.java](https://github.com/therealdarkflamemaster/Java_card_game/blob/master/src/Livrable_1/Com_normal.java)
    > - [Com_impossible.java](https://github.com/therealdarkflamemaster/Java_card_game/blob/master/src/Livrable_1/Com_impossible.java)




  - Singleton

    ... used for many classes to keep the changes in memory like the the card deck which is the distributor of the cards.

    file : [Draw_deck.java](https://github.com/therealdarkflamemaster/Java_card_game/tree/master/src/CARD/Draw_deck.java) 




  - Iterator

    ... used for traverse all the Collections used in the project

    file : [Draw_deck.java](https://github.com/therealdarkflamemaster/Java_card_game/tree/master/src/CARD/Draw_deck.java) 



- **Swing Graphic**

  all of classes in the folder `Vue` of the project.

  example :

  ![image-20210517001122174](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517001122174.png)

- **VMC structure**

  ![image-20210517000632899](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000632899.png)

- **Multi-Thread**

  ![image-20210517001255824](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517001255824.png)

## Resources

- UML of classes

  ![img](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/Diag_class_uml.jpg)

- Rules

  ![image-20210517000058940](https://raw.githubusercontent.com/therealdarkflamemaster/Java_card_game/master/image_de_projet/image-20210517000058940.png)

  >  copy right of the rule belongs to www.goodlittlegames.co.uk
