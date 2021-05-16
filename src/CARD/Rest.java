package CARD;
import java.util.*;

import Livrable_1.Player;

/**
 *<h1>Classe Reste</h1>
 */
public class Rest {
	private LinkedList<Card> rest_this_round;
	
	/**
	 * Constucteur de classe reste.
	 */
     public Rest() {
    	this.rest_this_round = new LinkedList<Card>();
     }
     
     /**
      * getteur du reste
      * @return LinkedList de cartes restantes.
      */
     public LinkedList<Card> return_rest(){
    	 return this.rest_this_round;
     }
     
     /**
      * Methode d'ajout d'une carte au reste.
      * @param c la carte à ajouter au reste.
      */
     public void addtorest(Card c) {
    	 this.rest_this_round.add(c);
     }
     
     /**
      * getteur d'instance d'itérateur de cartes
      * @return une instance d'itérateur de cartes
      */
     public Iterator<Card> iterator() {
    	 return this.rest_this_round.iterator();
     }
}
