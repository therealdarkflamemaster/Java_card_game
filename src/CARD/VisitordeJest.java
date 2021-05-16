package CARD;

import java.util.Iterator;
import java.util.LinkedList;

import Livrable_1.GM;
import Livrable_1.Visitor;

/**
 * <h1>Classe abstraite de visiteur de Jest</h1>
 */
public class VisitordeJest implements Visitor {
	private Jest jest_visit;
	
	/**
	 * Methode de visite de Jest
	 * @param jest le Jest à visiter
	 * @return un entier correspondant au score du Jest visité
	 */
	public int visit(Jest jest) {
		   int score=0;
   	       int num_Heart=0;
   	       int count_Ace=0;
   	       boolean isJoker=false;
   	       
   	     //Analyse des cartes une par une
		 for(Iterator<Card> it=jest.iterator();it.hasNext();) {
			 Card c=it.next();	//On prend la prochaine carte du Jest en considération
			 
			 //Pics et Trefles
    		 if(c.getColor()==4 || c.getColor()==3) { 	//Si la carte est noire : 
    			 score+=c.getValue();				  	//On ajoute la valeur de la carte à au score
    			 
    		 //Carreaux	 
    		 }else if(c.getColor()==2) {				//Sinon Si la carte est un Carreau
    			 score-=c.getValue();					//On retire la valeur de la carte à au score
    		 } 
    		 
    		 //Joker et Coeurs
    		 if(c.getColor()==1) {	//Si la carte est un coeur 
    			 num_Heart++;		//On ajoute 1 au nombre de coeurs
    		 }
    		 if(c.getValue()==0) {	//Si la carte est le Joker
    			 isJoker=true;		//On change le booléen "Joker" sur true
    		 }
    		 if(c.getValue()==1) {	//Si la carte est un As
    			 count_Ace++;		//On incrémente le nombre d'as de 1. 
    		 }
         }
    	 if(isJoker && num_Heart==0) {	//Si le joueur à le joker et pas d'as
    		 score+=4;					//On ajoute 4 à son score
    	 }else if (( isJoker && num_Heart==1) ||(isJoker &&num_Heart==2) || (isJoker &&num_Heart==3)){ //si le joueur à le joker et 1, 2 ou 3 as
    		 for(Iterator<Card> it=jest.iterator();it.hasNext();)  {
        		 Card c=it.next();
        		 if(c.getColor()==1) { 		//Si la carte est un coeur
        			 score-=c.getValue();	//On décrémente le score de la valeur du coeur
        		 }
    		 }
    	 }else if(isJoker && num_Heart==4) { //Si le joueur a le joker et 4 as
    		 for(Iterator<Card> it=jest.iterator();it.hasNext();)  {
        		 Card c=it.next();
        		 if(c.getColor()==1) {	  //Si la carte est un coeur
        			 score+=c.getValue(); //On incrémente le score de la valeur du coeur
        		 }
    		 }
    	 }
    	 
    	 //Aces
    	 if(count_Ace==1) {	//Si le joueur à 1 as
    		 score+=4;		//On incerémente le score de 1
    	 }
    	 
    	 //Black pairs
    	 GM gm = GM.getinstance();
    	 int num_p = gm.getPlayerNumber();
    	 LinkedList<Card> jest_1 = new LinkedList<Card> ();
    	     	 
    	 int j = 0;
    	 for(Iterator<Card> it=jest.iterator();it.hasNext();) {
    		 jest_1.add(it.next());
    		 j++;
    	 }
    	 
    	
    	 for(int i = 0 ; i < jest_1.size() ; i++) {
    		 for(int h = i ; h < jest_1.size() ; h++) {
    			 if(jest_1.get(h).getValue() == jest_1.get(i).getValue() && (jest_1.get(h).getColor() >= 3) && (jest_1.get(i).getColor() >= 3)) { //Si les cartes ont la meme valeur et une couleur étant Pic ou Trefle
    				 score+=2; //On incrémente le score de 2
    			 }
    		 }
    	 }
    	 return score;
	}

}
