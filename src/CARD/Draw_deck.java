package CARD;
import java.util.*;

/**
 * <h1>Classe pioche</h1>
 */
public class Draw_deck  {
    private int num_remian;
    private final int num_inital=17;
    private LinkedList<Card> cards;
    private static Draw_deck dd = null;  //singleton
    
    /**
     * getteur du nombre de cartes restantes dans la pioche (Draw_deck)
     * @return le nombre de cartes restantes
     */
    public int getNum_remian() {
    	return num_remian;
    }
    
    /**
     * m�lange les cartes de la pioche.
     */
    public void melanger() {
    	Collections.shuffle(cards);
    }
    
    /**
     * getteur de carte
     * @return la carte s�lection�e
     */
    public LinkedList<Card> return_cards(){
    	return this.cards;
    }
    
    /**
     * retirer et r�cuperer une carte de la pioche
     * @return la carte selection�e
     */
    public Card pick_card() {
    	return cards.poll();
    	//pop&poll
    }
    
    /**
     * Constructor de la pioche avec singleton
     * Il cr�e une LinkedList de cartes compos�e de toutes les cartes jouables.
     */
    private Draw_deck() {
    	cards=new LinkedList<Card> ();
    	TypeofCard[] t=TypeofCard.values();
    	Color[] c=Color.values();
    	for(int i=1;i<=4;i++) {
    		for(int j=1;j<=4;j++) {
    			Card carte=new Card(t[i],c[j]);
    			cards.add(carte);
    		}
    	}
    	Card joker=new Card(TypeofCard.Joker,Color.Null);
    	cards.add(joker);
    	this.num_remian=this.num_inital;
    }
    
    /**
     * Retire une carte de la pioche
     * @param a la carte � retirer de la pioche.
     */
    public void remove_card(Card a) {
    	this.cards.remove(a);
    }
    
    /**
     * Ajoute une carte � la pioche
     * @param a la carte � ajouter � la pioche.
     */
    public void add_card(Card a) {
    	this.cards.add(a);
    }
   
   
    /**
     * getteur/setteur d'instance pour le singleton
     * Si une instance de la pioche exite, retourne cette instance, sinon, cr�e une instance et la retourne.
     * @return l'instance de la pioche.
     */
    public static Draw_deck getinstance() {
    	if(dd == null) {
    		dd=new Draw_deck();
    	}
    	return dd;
    }
    
    /**
     * getteur de "pioche vide"
     * @return un boul�en : 1 s'il n'y a plus de carte, 0 sinon.
     */
    public boolean isempty() {
    	return this.cards.isEmpty();
    }
    
  
}
