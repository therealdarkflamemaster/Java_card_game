package Livrable_1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import CARD.Card;
import CARD.Hand_cards;
import CARD.Jest;
import Vue.Choose_card;
import Vue.Four_mode_offers;
import Vue.Three_mode_offers;

// player_real est avec le Scanner!!!!
/**
 * <h1>Classe joueur r閑l</h1> 
 */
public class Player_real extends Player {
	private Jest p_Jest;
	private Hand_cards hands;
	private String nom;
	private Card offer;
	private boolean chosen=false;
	private int jest_score;
	private int choose_num;//about ''Three_playground_Done''
	
	/**
	 * Constructeur joueur r閑l
	 */
	public Player_real() {
	     this.hands=new Hand_cards();
	     this.p_Jest=new Jest();
	}
      
	/**
	 * Getteur de main
	 * @return la main du joueur
	 */
	public Hand_cards get_hands() {
		return hands;
	}
	
	/**
	 * Getteur de nom
	 * @return le nom dui joueur
	 */
	public String get_nom() {
		return this.nom;
	}
	
	/**
	 * Methode affichage de main
	 */
	public void show_hands() {
		hands.makeHandsVisible();
		hands.afficher();
	}
	
	/**
	 * Methpde affichage de l'offre
	 */
	public void show_offer() {
		hands.afficher();
	}
	
	/**
	 * Getteur d'offre
	 * @return l'offre du joueur
	 */
	public Card get_offer() {
		return this.offer;
	}
	
	/**
	 * Setteur de nom
	 */
	public void set_nom(String a) {
		this.nom=a;
	}
	
	/**
	 * Methode faire une offre
	 * @return l'offre
	 */
	public Card make_offer() {
		
		Choose_card choose_card=new Choose_card();
		
		Card handcard1=new Card();
		Card handcard2=new Card();
		
		handcard1=this.get_hands().get(0);
		handcard2=this.get_hands().get(1);
		choose_card.set_up(handcard1,handcard2);
		choose_card.setVisible(true);
		int a=-1;
		
		
		a=choose_card.get_choose_num();
		      
		
		  if(a==1) {
			
			this.offer=hands.get(0);
			hands.get(1).changeCondition("down");
			return hands.get(0);
		  }else {//a==0
			
			  this.offer=hands.get(1);
			  hands.get(0).changeCondition("down");
			return hands.get(1);
		  }
		
	}
	
	/**
	 * Setteur d'offre
	 * @param a la carte a ajouter
	 */
	public void set_offer(Card a) {
		this.offer=a;
	}
	
	/**
	 * Methode r閏up閞er la carte restante
	 * @return la carte en question
	 */
	public Card take_his_card() { //version graphique 2020/1/1 & 2020/1/5
		
		GM gm=GM.getinstance();
	if(gm.return_Players().size()==3) {
		System.out.println("---------three mode of real player------------");
		Three_mode_offers tmo=Three_mode_offers.getinstance();
		tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
        //System.out.println("Player "+this.get_nom());
		//System.out.println("Please enter the name of the player to choose the cards of this player ");
		
		
		LinkedList<Player> players_afficher=new LinkedList<Player> ();
		
		
		tmo.set_not_afficher_card(this);
		Player p=null;
		
		for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
 			p=itp.next();
 			if(  p.get_chosen() ) {
 				tmo.set_not_afficher_card(p);
 			}
 		}
		
		tmo.setvisible(true);
		
		//             2020/1/1 1:58 然后去施工offers类的触发事件
		Player next_one=null;
		//String i=sc.nextLine();
		next_one=tmo.return_next_player();
		
		
		// first_one choisisse la carte de second_one
		
		Card rest_card=new Card();
		rest_card=tmo.return_rest_card();
		
		return rest_card;//返回需要加到本回合rest里的卡
	}else {
		System.out.println("---------four mode of real player------------");
		Four_mode_offers tmo=Four_mode_offers.getinstance();
		tmo.set_all_afficher();
		tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
		tmo.set_not_afficher_card(this);
		Player p=null;
		for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
 			p=itp.next();
 			if(  p.get_chosen() ) {
 				tmo.set_not_afficher_card(p);
 			}
 		}
		
		tmo.setvisible(true);
		
		
		/////
		///
		//             2020/1/1 1:58 然后去施工offers类的触发事件
		Player next_one=null;
		next_one=tmo.return_next_player();
		
		
		// first_one choisisse la carte de second_one
		Card rest_card=new Card();
		rest_card=tmo.return_rest_card();
		
		return rest_card;//返回需要加到本回合rest里的卡	
		}
	
	
	}
	
	
	
	/**
	 * Choisir la carte parmi deux joueurs
	 * @param p1 le premer joueur
	 * @param p2 le second joueur
	 */
	public void  choose_from_their_card(Player p1,Player p2) {
		GM gm=GM.getinstance();
		
		if(gm.return_Players().size()==3) {
		Three_mode_offers tmo=Three_mode_offers.getinstance();
		tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
		
		Player p=null;
		for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
 			p=itp.next();
 			if( (p!=p1) && (p!=p2) ) {
 				tmo.set_not_afficher_card(p);
 			}
 		}
		
		tmo.setvisible(true);
		}else {
			Four_mode_offers tmo=Four_mode_offers.getinstance();
			tmo.set_all_afficher();
			tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
			
			Player p=null;
			for(Iterator<Player> itp=gm.sort_player().iterator();itp.hasNext();) {
	 			p=itp.next();
	 			if( (p!=p1) && (p!=p2) ) {
	 				tmo.set_not_afficher_card(p);
	 			}
	 		}
			
			tmo.setvisible(true);
		}
	}
	
	/**
	 * Methode rejeter un joueur
	 * @param p le joueur 
	 */
	public void not_choose_from_his_card(Player p) {
		
		GM gm=GM.getinstance();
		if(gm.return_Players().size()==3) {
			Three_mode_offers tmo=Three_mode_offers.getinstance();
			tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
			tmo.set_not_afficher_card(p);
			tmo.setvisible(true);
		}else {
			Four_mode_offers tmo=Four_mode_offers.getinstance();
			tmo.set_all_afficher();
			tmo.setmessage_of_choose("Now Player "+this.get_nom()+" choose the card from :");
			tmo.set_not_afficher_card(p);
			tmo.setvisible(true);
		}
		
	}

	/**
	 * Methode choix d'jn oueur
	 * @param le jouer
	 * @return la carte
	 */
	public Card take_his_card(Player p) {  
		//System.out.println("Player "+this.get_nom());
		GM gm=GM.getinstance();
		if(gm.return_Players().size()==3) {
			Three_mode_offers tmo=Three_mode_offers.getinstance();
		tmo.setmessage_of_choose("Now, you have to choose from the player "+p.get_nom());
		
		//System.out.println("Now, you have to choose from the player "+p.get_nom());
		this.change_chosen(true);
		tmo.just_afficher(p);
		tmo.set_player_now(this);
		tmo.setvisible(true);
		
		return p .get_hands().get(0);
		}else {
			Four_mode_offers tmo=Four_mode_offers.getinstance();
			tmo.setmessage_of_choose("Now, you have to choose from the player "+p.get_nom());
			
			//System.out.println("Now, you have to choose from the player "+p.get_nom());
			
			tmo.just_afficher(p);
			tmo.set_player_now(this);
			tmo.setvisible(true);
			
			return p .get_hands().get(0);
		}
		
	}
	
	
     
}
