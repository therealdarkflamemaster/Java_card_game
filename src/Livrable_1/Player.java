package Livrable_1;

import java.util.*;
import CARD.Card;
import CARD.Hand_cards;
import CARD.Jest;
/**
 * <h1>Classe abstraite joueur</h1> 
 */
public abstract class Player {
	private Jest p_Jest;
	private Hand_cards hands;
	private String nom;
	private Card offer;
	private boolean chosen=false;
	private int jest_score;
	
	/**
	 * Constructeur joueeur
	 */
	public Player() {
	     this.hands=new Hand_cards();
	     this.p_Jest=new Jest();
	}
	
	/**
	 * Getteur d'offre
	 * @return l'offre du joueur
	 */
	public Card get_offer() {
		return this.offer;
	}
	
	/**
	 * setteur de nom
	 * @param a le nom
	 */
	public void set_nom(String a) {
		this.nom=a;
	}
	
	/**
	 * Getteur de main
	 * @return la main du joueru
	 */
	public Hand_cards get_hands() {
		return hands;
	}
	
	/**
	 * Getteur de nom
	 * @return le nom du joueur
	 */
	public String get_nom() {
		return this.nom;
	}
	
	/**
	 * Methode d'affichage de l amian du joueur
	 */
	public void show_hands() {
		hands.makeHandsVisible();
		hands.afficher();
	}
	
	/**
	 * M%ethode d'affichage de l'offre du joueur
	 */
	public void show_offer() {
		hands.afficher();
	}
	
	/**
	 * Methode faire l'offre
	 * @return la carte visible
	 */
	public abstract Card make_offer();
	
	
	/**
	 * setteur de choix
	 * @param a l'etat du choix (1 pour choisi et 0 pour non-choisi)
	 */
	public void change_chosen(boolean a){//est-ce qu'il a choisi la carte dans ce round?
		chosen=a;
	}
	
	/**
	 * Methode d'ajout d'une carte dans le jest
	 * @param a la carte a ajouter
	 */
	public void addToJest(Card a) {
		this.p_Jest.addtoJest(a);
	}
	
	/**
	 * Getteur de choix
	 * @return l'etat du choix
	 */
	public boolean get_chosen() {
		return this.chosen;
	}
	
	/**
	 * Methode d'affochage du Jest
	 */
	public void show_jest() {
		this.p_Jest.afficher();
		
	}
	
	/**
	 * Getteur de Jest
	 * @return le Jest
	 */
	public Jest returnjest() {
		
		return this.p_Jest;
	}
	
	/**
	 * Setteur du score du Jest
	 * @param a le score
	 */
	public void setJestscore(int a) {
		this.jest_score=a;
	}
	
	
	/**
	 * Getteur de score
	 * @return le score
	 */
	public int getJestscore() {
		return this.jest_score;
	}
	
	/**
	 * getteur de Jest
	 * @return le jest du joueur
	 */
	public Jest get_jest() {
		
		return this.p_Jest;
	}
	
	/**
	 * Methode récupérer une carte
	 * @return la carte choisie
	 */
	public abstract Card take_his_card() ;

	/**
	 * Prendre une carte
	 * @param p la joueur choisi
	 * @return la carte
	 */
	public abstract Card take_his_card(Player p);
	
	
}
