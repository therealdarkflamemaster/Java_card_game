package Livrable_1;

import CARD.Card;
/**
 * <h1>Interface Strategy</h1>
 */
public interface GameStrategy {
	
	/**
	 * Methode faire une offre
	 * @return la carte
	 */
	public Card make_offer();
	
	/**
	 * Methode récuperer ses cartes
	 * @return la carte
	 */
	public Card take_his_card();

	/**
	 * methode prendre la carte d'un joueur
	 * @param p le joueur
	 * @return la carte
	 */
	public Card take_his_card(Player p);

}
