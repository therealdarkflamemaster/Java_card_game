package Livrable_1;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CARD.Card;
import CARD.Draw_deck;
import CARD.Hand_cards;
import CARD.Jest;
import Vue.Four_mode_offers;
import Vue.Three_mode_offers;

/**
 * <h1>Classe Ordinateur Facile</h1>
 */
public class Com_easy   extends Computer_player implements GameStrategy {
	    public final String c_nom="Computer easy";
	    private Jest p_Jest;
	 	private Hand_cards hands;
	 	private String nom;
	 	private Card offer;
	 	private boolean chosen=false;
	 	private int jest_score;
	 	
	 	/**
	 	 * Constructeur de calsse ordinateur facile
	 	 */
 	public Com_easy() {
 		this.hands=new Hand_cards();
	     this.p_Jest=new Jest();
 	}
     
     // on utilise les variables stochastiques 
     /**
      * Methode récupérer carte
      */
     public Card take_his_card() {
    	 Player next_one=null;
	 	 Player p=null;
    	 if(Three_mode_offers.rest_num==0) {
    		 Three_mode_offers tmo=Three_mode_offers.getinstance();
			 JFrame frame=tmo.get_frame();
             JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
		 }else if(Four_mode_offers.rest_num==0) {
			 Four_mode_offers tmo=Four_mode_offers.getinstance();
			 JFrame frame=tmo.get_frame();
             JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
		 }else {
			 
			 System.out.println("Easy Computer is taking...");	
		       	try
		       	{
		       	    Thread.sleep(500);
		       	}
		       	catch(InterruptedException ex)
		       	{
		       	    Thread.currentThread().interrupt();
		       	}
		 		
		 		GM gm=GM.getinstance();
		 		for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
		 			p=itp.next();
		 			if( (p.get_nom()!=this.get_nom()) && (!p.get_chosen()) ) {
		 				next_one=p;
		 			}
		 		}
		 		
		 		if(next_one==null) {
		 			System.out.println("probleme in the 57 of com easy");
		 		}else {
		 			System.out.println("probleme not in the 57 of com easy");
		 		}
		 		
		 		int j=1;
		 		this.addToJest(next_one.get_hands().get(j));
		 	    
		 	    System.out.println("the player "+this.get_nom()+" have get "+next_one.get_hands().get(j).toString());
		 	    ///new 1/2
		 	    Draw_deck dd=Draw_deck.getinstance();
				dd.add_card(next_one.get_hands().get(0));
				dd.melanger();
				///new 1/2
		 }
    	 
 		return next_one.get_hands().get(0);//·µ»ØÐèÒª¼Óµ½±¾»ØºÏrestÀïµÄ¿¨
 		
 	}
     
     /**
      * methode choix de carte
      * @param Un joueur
      * @return La première carte
      */
     public Card take_his_card(Player p) {
 		int j=1;
 		this.addToJest(p.get_hands().get(j));
 		
 		System.out.println("the player "+this.get_nom()+" have get "+p.get_hands().get(j).toString());
 		this.addToJest(p.get_hands().get(j));
 		Draw_deck dd=Draw_deck.getinstance();
		dd.add_card(p.get_hands().get(1-j));
		dd.melanger();
 		return p.get_hands().get(0);
 	}
     
     /**
      * methode choix de carte à proposer
      * @return une carte 
      */
     public Card make_offer() {
      	System.out.println("Easy Computer is choosing...");	
      	try
      	{
      	    Thread.sleep(250);
      	}
      	catch(InterruptedException ex)
      	{
      	    Thread.currentThread().interrupt();
      	}
      	
      	this.offer=hands.get(0);
		hands.get(1).changeCondition("down");
		return this.hands.get(0);
      	
  	}
     
    /**
     * Getteur offres
     * @return la carte offre du joueur
     */
    public Card get_offer() {
 		return this.offer;
 	}
 	
    /**
     * Setteur de nom
     * @retrun
     */
 	public void set_nom(String a) {
 		this.nom=a;
 	}
 	
 	/**
 	 * Getteur de main
 	 * @return la main du joueur
 	 */
 	public Hand_cards get_hands() {
 		return hands;
 	}
 	
 	/**
 	 * getteur de nom
 	 * @retrun le nom du joueur
 	 */
 	public String get_nom() {
 		return this.nom;
 	}
 	
 	/**
 	 * Methode pour rendre la main visible et l'afficher
 	 */
 	public void show_hands() {
 		hands.makeHandsVisible();
 		hands.afficher();
 	}
 	
 	/**
 	 * Methode pour rendre l'offre visible et l'afficher
 	 */
 	public void show_offer() {
 		hands.afficher();
 	}
 	
 	/**
 	 *Setteur de choix
 	 */
 	public void change_chosen(boolean a){//est-ce qu'il a choisi la carte dans ce round?
		chosen=a;
	}
	
 	/**
 	 * Methode d'ajout d'une carte au jest
 	 * @param a la carte à ajouter
 	 */
	public void addToJest(Card a) {
		this.p_Jest.addtoJest(a);
	}
	
	/**
	 * Getteur de choix
	 * @return le choix
	 */
	public boolean get_chosen() {
		return this.chosen;
	}
	
	/**
	 * Methode affichage du Jest
	 */
	public void show_jest() {
		this.p_Jest.afficher();
		
	}
	
	/**
	 * Getteur de Jest
	 * @return le jest du joueur
	 */
	public Jest returnjest() {
		return this.p_Jest;
	}
	
	/**
	 * Setteur de score du Jest
	 */
	public void setJestscore(int a) {
		this.jest_score=a;
	}
	
	/**
	 * Getteur du score du Jest
	 */
	public int getJestscore() {
		return this.jest_score;
	}
     
     
     
 }

     
     

