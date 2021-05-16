package CARD;
import java.util.*;

import Livrable_1.Player;

//offers CaD les cards face-up sur la table

/**
 * <h1>Classe Offres</h1>
 */
public class Offers { 
	private LinkedList<Card> offers;
	
    /**
     * Constructeur de l'Offre d'un  joueur : création d'une LinkedList de Cartes.
     */
	public Offers() {
		this.offers=new LinkedList<Card>();
	}
	
	/**
	 * Methode d'affichage de l'offre/
	 */
	public void afficher() {
		System.out.println("Offers of this round are :");
		for(Iterator<Card> it=offers.iterator();it.hasNext();) {
			Card c = it.next();
			c.changeCondition("up");
			System.out.println(c.toString());
			
		}
	}
    
	/**
	 * Methode d'ajout d'une carte à l'offre.
	 * @param c la carte à ajouter à l'offre d'un joueur.
	 */
	public void addtoOffers(Card c) {
		offers.add(c);
	}
	
	/**
	 * getteur d'instance d'offre.
	 * @return une LinkedList de cartes étant l'offre du joueur.
	 */
	public LinkedList<Card> get_offers(){
		return offers;
	}
	
	/**
	 * Methode de (ré)initialisation de l'offre
	 */
	public void make_initial() {
		this.offers = new LinkedList<Card>();//marche chaque round
	}
	
	/**
	 * Methode de retait d'une carte de l'offre.
	 * @param c la carte à retirer de l'offre.
	 */
	public void removefromOffers(Card c) {//quand un autre joueur choisi la carte.
		offers.remove(c);
	}
	
	/**
	 * Methode d'affichage du joueur qui doit choisir une carte
	 * @param p le joueur qui doit choisir une carte
	 */
	public void afficher_toPlayer(Player p) {
		 System.out.println("Now it's time for the player "+p.get_nom()+" to take card.");
		System.out.println("The cards possible to take");
		for(Iterator<Card> it = offers.iterator();it.hasNext();) {
			if(it.next() != p.get_offer()) {
				System.out.println(it.next().toString());
			}
		}
	}
}
