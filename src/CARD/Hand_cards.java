package CARD;

import java.util.*;

/*
 * <h1>Classe Main des joueurs</h1>
 */
public class Hand_cards {
      public final int maxNum=2;//? peut-etre il n'y pas de sens de le definer
      private LinkedList<Card> hands;
      
      /**
       * Contructeur de la main.
       */
      public Hand_cards() {
    	  hands = new LinkedList<Card> ();
      }
      
      /**
       * methode pour changer l'état des cartes de la main sur "Up" afin que le joueur puisse les voir
       */
      public void makeHandsVisible() {
    	  for(Iterator<Card> it=hands.iterator();it.hasNext();) {
    		  it.next().changeCondition("up");
    	  }
      }
      
      /**
       * methode pour montrer les cartes de la main
       */
      public void afficher() {
    	  for(Iterator<Card> it=hands.iterator(); it.hasNext();) {
    		  System.out.println("You hand cards are :"+it.next().toString());
    	  }
      }
      
      /**
       * Getteur de carte
       * @param a numéro de la carte que l'on souhaite voir.
       * @return la carte à la position a dans la main du joueur.
       */
      public Card get(int a) {
    	  return hands.get(a);
      }
      
      /**
       * Methode d'ajout des cartes de la main.
       * @param c 1ere carte à ajouter à la main.
       * @param a 2eme carte à ajouter à la main.
       */
      public void add_card(Card c,Card a) {
    	  this.hands.add(c);
    	  this.hands.add(a);
      }
      
      /**
       * Initialisation de la main
       */
      public void initaliser() {
    	  hands = new LinkedList<Card> ();
      }
      
      /**
       * getteur d'instance d'itérateur de carte.
       * @return une instance d'itérateur des cartes de la main/
       */
      public Iterator<Card> iterator(){
    	  return this.hands.iterator();
      }
      
      /**
       * getteur du nombre de cartes dans la main.
       * @return le nombre de cartes dans la main.
       */
      public int size() {
    	  return this.hands.size();
      }
}
