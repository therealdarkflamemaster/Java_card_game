package Livrable_1;

import CARD.Card;
import CARD.Color;
import CARD.Draw_deck;
import CARD.Hand_cards;
import CARD.Offers;
import CARD.Rest;
import CARD.Trophies;
import CARD.TypeofCard;
import CARD.VisitordeJest;
import Controleur.Four_p_s_next;
import Controleur.Three_p_s_next;
import Controleur.Three_playground_controle;
import Livrable_1.Player;
import Vue.Choose_card;
import Vue.Three_mode_offers;
import Vue.Three_mode_playingScene;
import Vue.enter_mode;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * <h1>Classe game master</h1> 
 */
public class GM {

	private static GM gm = null; //singleton
	public static int num_p;
	private static int num_real;
	private static LinkedList<Player> players;
	private int level_num;

	
	/**
	 * Methode lancer la phsase une du jeu
	 * @param real le nombre de oueurs r閑ls
	 */
	public void start_game_phase1(int real) {
		
	    	 
	    	 Draw_deck dd = Draw_deck.getinstance();
	     	 dd.melanger();
	    	 num_real=real;
	    	 enter_mode em=enter_mode.getinstance();
	     	 num_p=em.get_num_p();
	    	 
	    	 int num_player=num_p;
	}
	
	/**
	 * Methode r閕nitialiser le jeu
	 */
	public void reset_game() {
		Trophies tt=Trophies.getinstance();
		tt.reset_trophies();
	}
	
	/**
	 * Methode lancer le jeu
	 */
    public void start_game() {
    	Card refer=new Card(TypeofCard.Reference_card,Color.Null);
    	refer.changeCondition("up");
    	System.out.println(refer.toString());
    	Draw_deck dd = Draw_deck.getinstance();
    	dd.melanger();
    	//dd.afficher();
    	enter_mode em=enter_mode.getinstance();
    	num_p=em.get_num_p();
    	Three_p_s_next tps=Three_p_s_next.getinstance();
    	num_real=tps.get_num_real();
    	this.start_game_phase1(num_real) ;
    	
    	
    	int number_level_com=0;
   	 if((num_p-num_real)!=0) {
   		Three_p_s_next tps_next=Three_p_s_next.getinstance();
   		level_num=tps_next.return_level_com();
   	 }
    }
    
    /**
     * constructeur GameMaster priv� pour singleton 
     */
    private GM() {
    	players= new LinkedList<Player>();
     }
    
    /**
     * Getteur d'instance pour singleton
     * @return l'instance ou la cr閑 puis la retourne
     */
    public static GM getinstance() {
    	if(gm == null) {
    		gm = new GM();
    	}
    	return gm;
    }
    
    /**
     * methode m閘anger les cartes
     * @return les cartes m閘ang閑s
     */
	private Card deal_card() {
		Draw_deck dd = Draw_deck.getinstance();
		dd.melanger();//necessaire??
		return dd.pick_card();
		
	}
	
	/**
	 * Getteur de trophies
	 * @return les trophies
	 */
	public Trophies get_Trophies() {
		Trophies tt=Trophies.getinstance();
		if(tt.getFirst()!=null) {
			return tt;
		}
		else {
			System.out.println("no trophie return ");
			return null;
		}
	}
	
	
	/**
	 * Setteur de main des joueurs
	 */
	public void set_handcards() {
		
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			it.next().get_hands().initaliser();
		}
		
		Draw_deck dd = Draw_deck.getinstance();
		Iterator<Player> itp=players.iterator();
		Iterator<Card> itc=dd.return_cards().iterator();
		int num_Cards_Taken =0;
		int num_Cards_Taken_Max=6;
		int num_player=1;
		
		System.out.println("there are "+dd.return_cards().size()+" cards before");
		while(itc.hasNext() && num_Cards_Taken<num_Cards_Taken_Max) {
			 while(itp.hasNext() && num_player<=players.size()) {
				 num_player++;
				 num_Cards_Taken+=2;
				 Card c1=new Card();
				 Card c2=new Card();
				 c1=(Card)itc.next();
				 itc.remove();
				 c2=(Card)itc.next();
				 itc.remove();
				 Player p=null;
				 p=itp.next();
				 p.get_hands().add_card(c1, c2);
				  //此处的各个玩家的手牌分配都没问题
				 Three_mode_playingScene tmps=Three_mode_playingScene.getinstance();
				 tmps.set_hand_card(p, c1, c2);
			 }
 
		}
		System.out.println("there are "+dd.return_cards().size()+" cards before");
	}
	
	/**
	 * Methode lancement du round
	 * @param round_number le nombre de round
	 */
	public void first_round(int round_number) {
		Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
		JOptionPane.showMessageDialog(frame,"This is the round no."+round_number);
		gm.set_handcards();
		gm.pmake_offer();
		gm.take_card(gm.sort_player());
		//il faut MaJ a la fin d'un round
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			it.next().get_hands().initaliser();
		}
	}
	
	/**
	 * Methode d'ajout de carte a la pioche
	 * @param c la carte a ajouter
	 */
	public void add_to_deck(Card c) {
		//pour ajouter les cartes restes a la 'deck'
		Draw_deck dd = Draw_deck.getinstance();
		dd.add_card(c);
		dd.melanger();
		
	}
	
	/**
	 * Setteur du nombre de joueurs r閑ls et jou閟 par l'ordinateur
	 * @param a nb de joueur
	 * @param b nb de vrais joueurs
	 */
	public void set_num(int a,int b) {
		num_p=b;
		num_real=a;
	}
	
	/**
	 * Methode d'affichage des mains des joueurs
	 * @param p le joueur
	 */
	public void afficher_player_handcard(Player p) {
		String key=p.get_nom();
		System.out.println("The player "+key);
		System.out.println("Hand cards are : ");
		p.show_hands();
	}
	
	/**
	 * Methode joueur r閑l faire offre
	 * @param pr le vrai joueur
	 * @return la carte choisie
	 */
	public Card player_real_make_offer(Player_real pr) {
		
		Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
		
		try {
			Thread.sleep(500);
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		JOptionPane.showMessageDialog(frame,"Now it's time for Player "+pr.get_nom()+" to make an offer(mean choose one faceUP card of two)");
		
		Choose_card choose_card=new Choose_card();
		Card handcard1=new Card();
		Card handcard2=new Card();
		gm.set_handcards();
		handcard1=pr.get_hands().get(0);
		handcard2=pr.get_hands().get(1);
		choose_card.set_up(handcard1,handcard2);
		choose_card.setVisible(true);
		
		choose_card.setPlayer(pr);
		Card c1=null;

		
	    c1=choose_card.getCard();
	    
		//Card c1=p.make_offer();
		
		return c1;	
	}
	
	/**
	 * Methode faire offre pour les joueurs ordinateurs
	 */
	public void pmake_offer() {//pas de scanner now
		
		Offers offers_this_round=new Offers();
		int i=1;
		//System.out.println(num_p+"   "+num_real);   correcte
		
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			if(i<=this.num_real) {
				Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
				Player_real p=new Player_real();
				p=(Player_real)it.next();
				i++;
				frame.set_player_real(p);
				Card c1=new Card();
				c1=player_real_make_offer(p);
				
				offers_this_round.addtoOffers(c1);
				
			}else {
				Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
				Computer_player p=null;
				if(level_num==2) {
					
					p=(Com_normal)it.next();
					
					JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
					
					
					Card c1=p.make_offer();
					offers_this_round.addtoOffers(c1);

				}else if (level_num==1){
					//p.setGameStrategy(new Com_easy());
					p=(Com_easy)it.next();
					
					JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
					
					Card c1=p.make_offer();
					offers_this_round.addtoOffers(c1);
				}else {
					p=(Com_impossible)it.next();
					
					JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
					
					Card c1=p.make_offer();
					offers_this_round.addtoOffers(c1);
				}
				
			    
			}
		}
		//offers_this_round.afficher();
		System.out.println("And "+this.num_p+" face down cards from each player.");
		
	}
	
	/**
	 * retrouver le joueur a partir de la carte choisie
	 * @param c la carte
	 * @return le joueur 
	 */
	public Player find_player(Card c) {//utiliser la carte de retour pour trouver qui est le joueur suivant dans le procedure de "take_card"
		Player return_p=null;
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			Player p=it.next();
			Hand_cards hc=p.get_hands();
			for(Iterator<Card> itc=hc.iterator();itc.hasNext();) {
				Card a=itc.next();
				if(a.equals(c)) {
					return_p=p;
				}
			}
		}
		return return_p;
	}
	
	/**
	 * Methode r閏up閞ation des cartes
	 * @param players_sorted
	 */
	public void take_card(LinkedList<Player> players_sorted) {
		Card c1=new Card();
		Card c2=new Card();
		Card c3=new Card();
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			it.next().change_chosen(false);
		}
		Rest rest_this_round=new Rest();
		Player first_one=players_sorted.getFirst();
		System.out.println("The first one to choose the card to his/her Jest is player "+first_one.get_nom());
		c1=first_one.take_his_card();
		
		first_one.change_chosen(false);
		rest_this_round.addtorest(c1);
		Player second_one=this.find_player(c1);
		
		//la fin de first_one
		

		System.out.println("Now the player "+second_one.get_nom()+" can choose the card.");
		//le deuxieme jeueur a prete de chosir
		c2=second_one .take_his_card();
		rest_this_round.addtorest(c2);
		Player third_one=this.find_player(c2);
		
		//la fin de second_one
		
		//分类开始，分成三个人和四个人的情况分别写下去
		
		if(this.num_p==3 && third_one.get_nom().equals(first_one.get_nom())) {
			Player p=null;
			for(Iterator<Player> it=players.iterator();it.hasNext();) {
				p=it.next();
				if((!p.get_nom().equals(first_one.get_nom())) && (!p.get_nom().equals(second_one.get_nom())) ) {// si ce joueur n'a pas ete choisi
					third_one=p;
				}
			}
			//这里thirdone要去拿自己的卡，建议新建一个函数，会输入player那种的
			c3=third_one.take_his_card(third_one);
			rest_this_round.addtorest(c3);
	
		}else if(this.num_p==3 && !( third_one.get_nom().equals( first_one.get_nom() ) )) {
			//third_one have to take card from the first_one
			c3=third_one.take_his_card(first_one);
			rest_this_round.addtorest(c3);
			////sdsdsdsdsdsds
		}
		if(this.num_p==4) {
			Player fourth_one=null;
			
			first_one.change_chosen(true);
			second_one.change_chosen(true);
			
			if(third_one.get_nom().equals(first_one.get_nom())) {
				// c'est le cas que  players 3 et 4  auront encore comparer leurs offers
				LinkedList<Player> pp =new LinkedList<Player> ();
				Player p=null;
				for(Iterator<Player> it=players.iterator();it.hasNext();) {
					 p=it.next();
					if( (p!=first_one) && (p!=second_one) ) {
						pp.add(p);
					}
				}
				
				third_one=pp.getFirst();
				fourth_one=pp.getLast();
				
				Card c4=new Card();
				System.out.println("For the player "+third_one.get_nom());
				c4=third_one.take_his_card(fourth_one);
				rest_this_round.addtorest(c4);
				
				Card c5=new Card();
				System.out.println("For the player "+fourth_one.get_nom());
				c5=fourth_one.take_his_card(third_one);
				rest_this_round.addtorest(c5);
				
			}else {
				
				Card c4=new Card();
				second_one.change_chosen(true);
				third_one.change_chosen(false);
				
				first_one.change_chosen(false);
				c4=third_one.take_his_card(); 
				first_one.change_chosen(true);
				
				rest_this_round.addtorest(c4);
				fourth_one=this.find_player(c4);
				fourth_one.change_chosen(false);

				// le troisieme joueur a fini le procedure de choisir la carte
				if(fourth_one.get_nom().equals(second_one.get_nom())) {
					first_one.change_chosen(true);
					second_one.change_chosen(true);
					third_one.change_chosen(true);
					for(Iterator<Player> it=players.iterator();it.hasNext();) {
						Player p=it.next();
						if(!p.get_chosen()) {// si ce joueur n'a pas ete choisi
							fourth_one=p;
						}
					}
					Card c5=new Card();
					c5=fourth_one.take_his_card(first_one);
					rest_this_round.addtorest(c5);
				}
				
				else if(fourth_one.get_nom().equals(first_one.get_nom())) {
					first_one.change_chosen(true);
					second_one.change_chosen(true);
					third_one.change_chosen(true);
					for(Iterator<Player> it=players.iterator();it.hasNext();) {
						Player p=it.next();
						if(!p.get_chosen()) {// si ce joueur n'a pas ete choisi
							fourth_one=p;
						}
					}
					
					
					Card c5=new Card();
					
					c5=fourth_one.take_his_card(fourth_one);
					rest_this_round.addtorest(c5);
					
				}else {
					// le cas normal
					Card c5=new Card();
					c5=fourth_one.take_his_card(first_one);
					rest_this_round.addtorest(c5);
				}
			}
		}
		Draw_deck dd=Draw_deck.getinstance();
		if(!dd.isempty()) {
			for(Iterator<Card> it=rest_this_round.iterator();it.hasNext();) {
			   gm.add_to_deck(it.next());
			}
		}else {//c'est a dire the last round
			for(Iterator<Card> itc=rest_this_round.iterator();itc.hasNext();) {
				for(Iterator<Player> itp=players.iterator();itp.hasNext();) {
				   itp.next().addToJest(itc.next());
				}
			} 
		}
			}//marche bien
	
	/**
	 * Getteur du num閞o  du joueur
	 * @return le numero du joueur
	 */
	public int getPlayerNumber() {
		return this.num_p;
	}
	
	/**
	 * Methode retrouver un joueur avec son nom
	 * @param nom nom du joueur 
	 * @return le joueur
	 */
	public Player find_player(String nom) {
		Player p1 = new Player_real();
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			Player p=it.next();
			if(p.get_nom().equals(nom)) {
				p1=p;
				
			}
		}
		return p1;
	}
	public LinkedList<Player> sort_player(){
		Card[] cartes = new Card[5];
		int i=0;
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			cartes[i]=it.next().get_offer();
			i++;
		}
		//decider l'ordre de 'offers'
		for(i=0;i<=players.size()-1;i++) {
			for(int j=i;j<=players.size()-1;j++) {
				if(cartes[j].getValue()>cartes[i].getValue()) {
					Card c=cartes[i];
					cartes[i]=cartes[j];
					cartes[j]=c;
				}else if(cartes[j].getValue()==cartes[i].getValue()) {
					if(cartes[j].getColor()>cartes[i].getColor()) {
						Card c=cartes[i];
						cartes[i]=cartes[j];
						cartes[j]=c;
					}
				}	
			}
		}
		
		LinkedList<Player> players_sorted=new LinkedList<Player>();
		
		for(i=0;i<=2;i++) {
			for(Iterator<Player> it=players.iterator();it.hasNext();) {
				
				Player p=it.next();
				if(cartes[i]==p.get_offer()) {
					players_sorted.add(p);
					//System.out.println("the "+(i+1)+" player to take card is "+p.get_nom());
				}
			}
		}
		return players_sorted;
	}
	
	
	/**
	 * Methode afficher les joueurs
	 */
	public void afficher_players() {
		System.out.println("Here are "+this.num_p+" players");
		for(Iterator<Player> it=players.iterator();it.hasNext();) {
			String key=it.next().get_nom();
			System.out.println("The player "+key);
		}
	}
	
	
	public static void version_finle() {
		
		gm = GM.getinstance();
		gm.start_game();
		Three_p_s_next tps=Three_p_s_next.getinstance();
		String[] names=new String[4];
		names[0]=tps.player1_name;
		names[1]=tps.player2_name;
		names[2]=tps.player3_name;
		
		
		for(int i=1;i<=num_real;i++) {
			
			
			Player_real pr=new Player_real();
			pr.set_nom(names[i-1]);
			players.add(pr);
		}
		
		int remain_num=num_p-num_real;
		for(int j=1;j<=remain_num;j++) {
			
			Computer_player computer=null;
			
				
			
			if(gm.level_num==2) {
				computer=new Com_normal();
			}else if(gm.level_num==1) {
				computer=new Com_easy();
			}else {
				computer=new Com_impossible();
			}
			
			String a=new String("Computer"+j);
			computer.set_nom(a);
			players.add(computer);
		}
		
		gm.afficher_players();
		Draw_deck dd=Draw_deck.getinstance();
		
		int round_number=0;
		while(round_number>4 || (!dd.isempty())) {
			  round_number++;
		      gm.first_round(round_number);
		      
		}
	      System.out.println("This is 0 card remian in the Draw Deck.");
	      //marche bien
	      System.out.println("Now show your Jest");
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  Player p=it.next();
	    	  System.out.println("The player"+p.get_nom());
	    	  p.show_jest();
	      }
	     
	      
	      int[] jest_scores;
	      GM gm=GM.getinstance();
	      int num_p=gm.getPlayerNumber();
	      if(num_p==3) {
	    	  jest_scores=new int[3];
	      }else {
	    	  jest_scores=new int[4];
	      }
	      VisitordeJest vdj=new VisitordeJest();
	      int i=0;
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  Player p=it.next();
	    	  jest_scores[i]=p.returnjest().accept(vdj);
	    	  p.setJestscore(jest_scores[i]);
	    	  i++;
	      }
	      int j=0;
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  System.out.println("Jest (before award)of player "+it.next().get_nom()+" score is "+jest_scores[j]);
	    	  j++;
	      }     
	      
		  //le precedure de gagner les trophies
	    
	      Trophies tp=Trophies.getinstance();
	      Card tp1=new Card();
	      Card tp2=new Card();
	      if(gm.getPlayerNumber()==3) {
				tp1=tp.getFirst();
				tp2=tp.getLast();
				gm.award(tp1);
			    gm.award(tp2);
	      }else if(gm.getPlayerNumber()==4){
	    	  tp1=tp.getFirst();
	    	  gm.award(tp1);
	      }
	      
	      if(num_p==3) {
	    	  jest_scores=new int[3];
	      }else {
	    	  jest_scores=new int[4];
	      }
	      VisitordeJest vdj1=new VisitordeJest();
	      i=0;
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  Player p=it.next();
	    	  jest_scores[i]=p.returnjest().accept(vdj1);
	    	  p.setJestscore(jest_scores[i]);
	    	  i++;
	      }
	      System.out.println("Now show your Jest after award");
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  Player p=it.next();
	    	  System.out.println("The player"+p.get_nom());
	    	  p.show_jest();
	      }
	      
	      j=0;
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  System.out.println("Jest (after award)of player "+it.next().get_nom()+" score is "+jest_scores[j]);
	    	  j++;
	      }   
	}
	
	
	public static void use_for_three_phase1() {
		gm = GM.getinstance();
		gm.start_game();
		Three_p_s_next tps=Three_p_s_next.getinstance();
		String[] names=new String[4];
		names[0]=tps.player1_name;
		names[1]=tps.player2_name;
		names[2]=tps.player3_name;
		
		
		for(int i=1;i<=num_real;i++) {
			
			
			Player_real pr=new Player_real();
			pr.set_nom(names[i-1]);
			players.add(pr);
		}
		
		int remain_num=num_p-num_real;
		for(int j=1;j<=remain_num;j++) {
			
			Computer_player computer=null;
			
				
			
			if(gm.level_num==2) {
				computer=new Com_normal();
			}else if(gm.level_num==1) {
				computer=new Com_easy();
			}else {
				computer=new Com_impossible();
			}
			
			String a=new String("Computer"+j);
			computer.set_nom(a);
			players.add(computer);
		}
		
		gm.afficher_players();
		
		
	}
	
	public static void use_for_four_phase1() {
		gm = GM.getinstance();
		gm.start_game();
		Four_p_s_next tps=Four_p_s_next.getinstance();
		String[] names=new String[4];
		names[0]=Four_p_s_next.player1_name;
		names[1]=Four_p_s_next.player2_name;
		names[2]=Four_p_s_next.player3_name;
		names[3]=Four_p_s_next.player4_name;
		num_p=4;
		num_real=tps.get_num_real();
		for(int i=1;i<=num_real;i++) {
			Player_real pr=new Player_real();
			pr.set_nom(names[i-1]);
			players.add(pr);
		}
		
		int remain_num=num_p-num_real;
		for(int j=1;j<=remain_num;j++) {
			
			Computer_player computer=null;
			
				
			
			if(gm.level_num==2) {
				computer=new Com_normal();
			}else if(gm.level_num==1) {
				computer=new Com_easy();
			}else {
				computer=new Com_impossible();
			}
			
			String a=new String("Computer"+j);
			computer.set_nom(a);
			players.add(computer);
		}
		
		gm.afficher_players();
		
		
	}
	
	public LinkedList<Player> return_Players(){
		return players;
	}
	public void award(Card trophie) {
		
		LinkedList<Player> players_sorted=new LinkedList<Player>();
		players_sorted=this.sort_player();
		//cas 1
		// 此处的player有各自的jest
	
		if(trophie.getValue()==0) {//trophie1 est Joker
			  players_sorted.getFirst().addToJest(trophie);
		  }
		  
		  //cas 2
		else if(trophie.getValue()==1 && trophie.getColor()==1) {//trophie est Heart A
			  Player player_with_joker=null;
			  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					
					if(it1.next().getValue()==0) {//est Joker?
						player_with_joker=p;
					}
				}
			}
			if(player_with_joker!=null) {
				player_with_joker.addToJest(trophie);
				}
		  }
		  
		
		  //cas 3
		else if(trophie.getValue()==4 && trophie.getColor()==4) {
			  Player player1=null;
			  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					Card a=new Card();
					a=it1.next();
					if(a.getValue()==1 && a.getColor()==3) {
						player1=p;
					}
				}
			}
			if(player1!=null) {
				player1.addToJest(trophie);
				}
		  }
		  
		//cas 4
		else if(trophie.getValue()==4 && trophie.getColor()==3) {
		  Player player1=null;
		  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					Card a=new Card();
					a=it1.next();
					if(a.getValue()==1 && a.getColor()==4) {
						player1=p;
					}
				}
			}
			if(player1!=null) {
				player1.addToJest(trophie);
				}
		}
		
		//cas 5.1
		else if(trophie.getValue()==2 && trophie.getColor()==1) {
			Player player_with_joker=null;
			Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					if(it1.next().getValue()==0) {//est Joker?
						player_with_joker=p;
					}
				}
			}
			if(player_with_joker!=null) {
				player_with_joker.addToJest(trophie);
				}
		}
		
		//cas 6.1
		else if(trophie.getValue()==4 && trophie.getColor()==2) {
			Player p1=null;
			Player p=null;
			for(Iterator<Player> it=players_sorted.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					if(it1.next().getValue()!=0) {
						p1=p;
					}
			}
		     }
			if(p1!=null) {
			p1.addToJest(trophie);
			}
		}
		
		//cas 7.1
		else if(trophie.getValue()==4 && trophie.getColor()==1) {//trophie est Heart 4
			  Player player_with_joker=null;
			  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					if(it1.next().getValue()==0) {//est Joker?
						player_with_joker=p;
					}
				}
			}
			if(player_with_joker!=null) {
				player_with_joker.addToJest(trophie);
				}
		  }
		
		//cas 8.1
		else if(trophie.getValue()==3 && trophie.getColor()==1) {//trophie est Heart 3
			  Player player_with_joker=null;
			  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					if(it1.next().getValue()==0) {//est Joker?
						player_with_joker=p;
					}
				}
			}
			if(player_with_joker!=null) {
			player_with_joker.addToJest(trophie);
			}
		  }
		
		//cas 9
		else if(trophie.getValue()==1 && trophie.getColor()==4) {
	  		  Player player1=null;
	  		Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				 p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					Card a=new Card();
					a=it1.next();
					if(a.getValue()==4 && a.getColor()==3) {
						player1=p;
					}
				}
			}
			if(player1!=null) {
				player1.addToJest(trophie);
				}
  		}
		
		//cas 10
		else if(trophie.getValue()==1 && trophie.getColor()==3) {
		  Player player1=null;
		  Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					Card a=new Card();
					 a=it1.next();
					if(a.getValue()==4 && a.getColor()==4) {
						player1=p;
					}
				}
			}
			if(player1!=null) {
				player1.addToJest(trophie);
				}
		}
		//cas 10
		else if(trophie.getValue()==1 && trophie.getColor()==3) {
	  		  Player player1=null;
	  		Player p=null;
			for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
				p=it.next();
				for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
					Card a=new Card();
					 a=it1.next();
					if(a.getValue()==4 && a.getColor()==4) {
						player1=p;
					}
				}
			}
			if(player1!=null) {
				player1.addToJest(trophie);
				}
  		}
		//cas 11
		
		else if(trophie.getValue()==1 && trophie.getColor()==2) {
  		  Player player1=null;
  		  Player p=null;
  		  int[] num_of_4=new int[gm.getPlayerNumber()];
  		  int i;
  		  for(i=0;i<num_of_4.length;i++) {
  			  for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
  				  
  	  				 p=it.next();
  	  				num_of_4[i]=p.get_jest().num_of_four();
  			  }
  		  }
  		  int max=num_of_4[0];
  		  for(i=0;i<num_of_4.length;i++) {
  			  if(num_of_4[i]>max) {
  			      max=num_of_4[i];
  			  }
  		  }
  		  for(i=0;i<num_of_4.length;i++) {
  			  if(num_of_4[i]==max) {
  			      player1=players.get(i);
  			  }
  		  }
			
  		if(player1!=null) {
			player1.addToJest(trophie);
			}
  		}
		
		//cas 12
		else if(trophie.getValue()==2 && trophie.getColor()==4) {
				Player p=null;
	  		  Player player1=null;
	  		  int[] num_of_3=new int[gm.getPlayerNumber()];
	  		  int i;
	  		  for(i=0;i<num_of_3.length;i++) {
	  			  for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
	  				  
	  	  				 p=it.next();
	  	  				num_of_3[i]=p.get_jest().num_of_three();
	  			  }
	  		  }
	  		  int max=num_of_3[0];
	  		  for(i=0;i<num_of_3.length;i++) {
	  			  if(num_of_3[i]>max) {
	  			      max=num_of_3[i];
	  			  }
	  		  }
	  		  for(i=0;i<num_of_3.length;i++) {
	  			  if(num_of_3[i]==max) {
	  			      player1=players.get(i);
	  			  }
	  		  }
				
	  		if(player1!=null) {
				player1.addToJest(trophie);
				}
	  		}
		
		//cas 13
		else if(trophie.getValue()==2 && trophie.getColor()==3) {
		  		  Player player1=null;
		  		  Player p=null;
					for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
						 p=it.next();
						for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
							Card a=new Card();
							 a=it1.next();
							if(a.getValue()==1 && a.getColor()==1) {
								player1=p;
							}
						}
					}
					if(player1!=null) {
						player1.addToJest(trophie);
						}
		  		}
		//cas 14
		else if(trophie.getValue()==2 && trophie.getColor()==2) {
	  		  Player player1=null;
	  		  Player p=null;
				for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
					 p=it.next();
					for(Iterator<Card> it1=p.get_jest().iterator();it1.hasNext();) {
						Card a=new Card();
						a=it1.next();
						if(a.getValue()==4 && a.getColor()==2) {
							player1=p;
						}
					}
				if(player1!=null) {
				player1.addToJest(trophie);
				}
				}
		}
	  		
		//cas15
		else if(trophie.getValue()==3 && trophie.getColor()==4) {
				Player p=null;	
	  		  Player player1=null;
	  		  int[] num_of_2=new int[gm.getPlayerNumber()];
	  		  int i;
	  		  for(i=0;i<num_of_2.length;i++) {
	  			  for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
	  				  
	  	  				p=it.next();
	  	  				num_of_2[i]=p.get_jest().num_of_two();
	  			  }
	  		  }
	  		  int max=num_of_2[0];
	  		  for(i=0;i<num_of_2.length;i++) {
	  			  if(num_of_2[i]>max) {
	  			      max=num_of_2[i];
	  			  }
	  		  }
	  		  for(i=0;i<num_of_2.length;i++) {
	  			  if(num_of_2[i]==max) {
	  			      player1=players.get(i);
	  			  }
	  		  }
				
	  		if(player1!=null) {
				player1.addToJest(trophie);
				}
	  		}
		
		//cas 16
		else if(trophie.getValue()==3 && trophie.getColor()==3) {
	  		  Player player1=null;
	  		  Player p=null;
				for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
					 p=it.next();
					for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
						Card a=new Card();
						a=it1.next();
						if(a.getValue()==4 && a.getColor()==1) {
							player1=p;
						}
					}
				}
				if(player1!=null) {
					player1.addToJest(trophie);
					}
	  		}
		
		//cas 17
		else if(trophie.getValue()==3 && trophie.getColor()==2) {
	  		  Player player1=null;
	  		  Player p=null;
				for(Iterator<Player> it=this.players.iterator();it.hasNext();) {
					p=it.next();
					for(Iterator<Card> it1=p.returnjest().iterator();it1.hasNext();) {
						Card a=new Card();
						 a=it1.next();
						if(a.getValue()==1 && a.getColor()==2) {
							player1=p;
						}
					}
				}
				if(player1!=null) {
					player1.addToJest(trophie);
					}
	  		}
		
		}
	}
	


