package CARD;
import java.util.*;

import Livrable_1.Player;

//singleton + collections-linkedlist
/**
 * <h1>Classe Troph�es</h1>
 */
public class Trophies{
      public final int num=2;//???
      private LinkedList<Card> cards;
      private static Trophies tt;
      
      /**
       * Setteur des troph�es pour une partie � 3 joueurs
       * @param c1 1ere carte � ajouter aux troph�es.
       * @param c2 2eme carte � ajouter aux troph�es.
       */
      private Trophies(Card c1,Card c2) {//three players mode
    	  cards = new LinkedList<Card> ();
    	  c1.changeCondition("up");
    	  c2.changeCondition("up");
    	  cards.add(c1);
    	  cards.add(c2); 
      }
      
      /**
       * Constructeur de la classe troph�e : une LinkedList de cartes
       */
      private Trophies() {
    	  cards = new LinkedList<Card> ();
      }
      
      /**
       * Setteur des troph�es pour une partie � 4 joueurs
       * @param c 1ere carte � ajouter aux troph�es
       */
      private Trophies(Card c) { //four players mode
    	  cards = new LinkedList<Card> ();
    	  c.changeCondition("up");
    	  cards.add(c);
      }
      
      /**
       * getteur d'instance de la classe troph�es pour singleton
       * @return l'instance si elle existe, sinon, la cr�e et la retourne.
       */
      public static Trophies getinstance() {
    	  if(tt == null) {
    		  tt = new Trophies();
    	  }
    	  
    	  return tt;
      }
      
      /**
       * Methode d'ajout de carte aux troph�es
       * @param c la carte � ajouter
       */
      public void addCard(Card c) {
    	  cards.add(c);
      }
      
      /**
       * Methode d'affichage des troph�es
       */
      public void afficher() {
    	  System.out.println("Trophies is/are :");
    	  for(Iterator<Card> it=this.cards.iterator();it.hasNext();) {
    		  it.next().changeCondition("up");
    	  }
    	  for(Iterator<Card> it=this.cards.iterator();it.hasNext();) {
    		  System.out.println(it.next().toString());
    	  }
      }
      
      /**
       * getteur du premier troph�e
       * @return
       */
      public Card getFirst() {
    	  return cards.getFirst();
      }
      
      /**
       * getteur du second troph�e
       * @return
       */
      public Card getLast() {
    	  return cards.getLast();
      }
      
      /**
       * Methode de r�initialisation des troph�es.
       */
      public void reset_trophies() {
    	  tt.cards=new LinkedList<Card>();
      }
      
      
}
