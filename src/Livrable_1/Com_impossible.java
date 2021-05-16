package Livrable_1;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CARD.Card;
import CARD.Draw_deck;
import CARD.Hand_cards;
import CARD.Jest;
import Vue.Four_mode_offers;
import Vue.Three_mode_offers;

/**
 * <h1>Classe Ordinateur Difficile</h1>
 */
public class Com_impossible extends Computer_player implements GameStrategy{
	public final String c_nom="Computer hell";
	 
	    private Jest p_Jest;
	 	private Hand_cards hands;
	 	private String nom;
	 	private Card offer;
	 	private boolean chosen=false;
	 	private int jest_score;
	 	
	 	/**
	 	 * Constructeur de calsse ordinateur difficile
	 	 */
		public Com_impossible() {
			this.hands=new Hand_cards();
		     this.p_Jest=new Jest();
		}
		
	 	
		 /**
	      * methode choix de carte à proposer
	      * @return une carte 
	      */
	 	public Card make_offer() {
			
	    	System.out.println("Hell Computer is choosing...");
	    	try
	    	{
	    	    Thread.sleep(500);
	    	}
	    	catch(InterruptedException ex)
	    	{
	    	    Thread.currentThread().interrupt();
	    	}
	    	Card c1=new Card();
	    	Card c2=new Card();
	    	
	    	c1=hands.get(0);
	    	c2=hands.get(1);
	    	
	    	Card return_one=new Card();
	    	return_one=c2;
	    	//comparer
	    	if(c1.getValue()>c2.getValue()) {
				return_one=c1;
			}else if(c1.getValue()==c2.getValue()) {
				if(c1.getColor()>c2.getColor()) {
					return_one=c1;
				}
	        }
	    	this.offer=return_one;
	    	return return_one;
		}
	 	
	 	 // on utilise les variables stochastiques 
	     /**
	      * Methode récupérer carte
	      */
	 	 public Card take_his_card() {
	 		    System.out.println("enter the part of com impossible 63");
		 		Player next_one=null;
		 		Player p=null;
		 		GM gm=GM.getinstance();
		 		if(gm.return_Players().size()==3 && Three_mode_offers.rest_num==0) {
		 	   		 Three_mode_offers tmo=Three_mode_offers.getinstance();
		 			 JFrame frame=tmo.get_frame();
		 	         JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
		 	         Card c=new Card();
		 	        System.out.println("enter the part of com impossible 71,whywhywhy...");
		 	         return c;
		 		}else if(gm.return_Players().size()==4 && Four_mode_offers.rest_num==0) {
					 Four_mode_offers tmo=Four_mode_offers.getinstance();
					 JFrame frame=tmo.get_frame();
		             JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
		             Card c=new Card();
			 	        System.out.println("enter the part of com impossible 71,whywhywhy...");
			 	         return c;
		 		}else {
		 		    
		 		    
			 		LinkedList<Player> players_waited=new LinkedList<Player> ();
			 		int score_final=-200;
			 		int score_unsure=0;
			 		int num_card_wait=0;
			 		int num_card_final=0;
			 		
			 		for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
			 			p=itp.next();
			 			if( (p.get_nom()!=this.get_nom()) && (!p.get_chosen()) ) {
			 			players_waited.add(p);
			 			}
			 		}
			 		// success
			 		for(Iterator<Player> itpp=players_waited.iterator();itpp.hasNext();) {
			 			    p=itpp.next();

			 				Card h1=new Card();
			 		 		Card h2=new Card();
			 		 		
			 		 		h1=p.get_hands().get(0);
			 		 		h2=p.get_hands().get(1);
			 		 		int score_h1=0;
			 		 		int score_h2=0;
			 		 		
			 		 		score_h1=this.p_Jest.calcule_score_if_card_in(h1);
			 		 		score_h2=this.p_Jest.calcule_score_if_card_in(h2);
			 		 		if(score_h1>score_h2) {
			 		 			score_unsure=score_h1;
			 		 			num_card_wait=0;
			 		 		}else {
			 		 			score_unsure=score_h2;
			 		 			num_card_wait=1;
			 		 		}
			 		 		
			 		 		if(score_unsure>score_final) {
			 		 			score_final=score_unsure;
			 		 			next_one=p;
			 		 			num_card_final=num_card_wait;
			 		 		}
			 			}
			 		
			 	
			 		
			 		
			 		this.addToJest(next_one.get_hands().get(num_card_final));
			 	    
			 	    System.out.println("the player "+this.get_nom()+" have get "+next_one.get_hands().get(num_card_final).toString());
			 	    //new
			 	    Draw_deck dd=Draw_deck.getinstance();
					dd.add_card(next_one.get_hands().get((1-num_card_final)));
					dd.melanger();
					//new
					if(next_one ==null) {
			 			System.out.println("problem in the 127 of com imposs");
			 		}else {
			 			System.out.println("problem not in the 127 of com imposs");
			 		}
			 	    return next_one.get_hands().get((1-num_card_final));	 
		 		}
		 				 
		 				 
		 		
		 	} 		
	 	
	 	/**
	      * methode choix de carte
	      * @param Un joueur
	      * @return La première carte
	      */
	 	 public Card take_his_card(Player p) {
	     	
	  		int j=1;
	  		Card h1=new Card();
	  		Card h2=new Card();
	  		
	  		h1=p.get_hands().get(0);
	  		h2=p.get_hands().get(1);
	  		int score_h1=0;
	  		int score_h2=0;
	  		score_h1=this.p_Jest.calcule_score_if_card_in(h1);
	  		score_h2=this.p_Jest.calcule_score_if_card_in(h2);
	  		
	  		if(score_h1>score_h2) {
	  			j=0;
	  		}
	  		
	  		this.addToJest(p.get_hands().get(j));
	  		
	 		Draw_deck dd=Draw_deck.getinstance();
			dd.add_card(p.get_hands().get(1-j));
			dd.melanger();
	  		
	  		System.out.println("the player "+this.get_nom()+" have get "+p.get_hands().get(j).toString());
	  		return p.get_hands().get((1-j));
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
