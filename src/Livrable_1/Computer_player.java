package Livrable_1;

import java.util.Iterator;
import java.util.Scanner;

import CARD.Card;
import CARD.Hand_cards;
import CARD.Jest;

/**
 * <h1>Classe abstraite joueur ordinateur</h1>
 */
public abstract  class Computer_player extends Player {
	private Jest p_Jest;
	private Hand_cards hands;
	private String nom;
	private Card offer;
	private boolean chosen=false;
	private int jest_score;
	
	
	//private GameStrategy com_level;
	
	//public void setGameStrategy(GameStrategy c_level) {
		//this.com_level=c_level;
	//}
	
	
	//patron de strategie
	
	//patron de strategie
	public abstract  Card make_offer() ;
	
	public  abstract Card take_his_card();
	
	public abstract Card take_his_card(Player p);
	
	//patron de strategie
		
		
	public Computer_player() {
	     this.hands=new Hand_cards();
	     this.p_Jest=new Jest();
	}
	
	public Card get_offer() {
		return this.offer;
	}
	
	public void set_nom(String a) {
		this.nom=a;
	}
	
	public Hand_cards get_hands() {
		return hands;
	}
	public String get_nom() {
		return this.nom;
	}
	
	public void show_hands() {
		hands.makeHandsVisible();
		hands.afficher();
	}
	
	public void show_offer() {
		hands.afficher();
	}
	
	
	
	public void change_chosen(boolean a){//est-ce qu'il a choisi la carte dans ce round?
		chosen=a;
	}
	
	public void addToJest(Card a) {
		this.p_Jest.addtoJest(a);
	}
	public boolean get_chosen() {
		return this.chosen;
	}
	
	public void show_jest() {
		this.p_Jest.afficher();
		
	}
	
	public Jest returnjest() {
		return this.p_Jest;
	}
	
	public void setJestscore(int a) {
		this.jest_score=a;
	}
	
	public int getJestscore() {
		return this.jest_score;
	}


	
	
	
	
}
