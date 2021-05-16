package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import CARD.Card;
import CARD.Draw_deck;
import CARD.Trophies;
import CARD.VisitordeJest;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Livrable_1.Com_easy;
import Livrable_1.Com_impossible;
import Livrable_1.Com_normal;
import Livrable_1.Computer_player;
import Livrable_1.GM;
import Livrable_1.Player;
import Livrable_1.Player_real;
import Vue.Choose_card;
import Vue.Three_mode_offers;
import Vue.Three_mode_playingScene;

public class Three_playground_Offer {
	private int num_round=0;
	private GM gm=GM.getinstance();
	private LinkedList<Player> players=gm.return_Players();

    //Offer °´Å¥µÄ¼àÌý
	public Three_playground_Offer(JButton btnOffer) {
		btnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
				if(e.getSource()==btnOffer) {
					num_round++;
					frame.change_num_round(num_round);
				}

				Three_mode_offers tmo=Three_mode_offers.getinstance();
				tmo.set_new();
				
				try {
					Thread.sleep(500);
				}catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				
				int i=1;
				int num_real=Three_p_s_next.getinstance().get_num_real();
				GM gm=GM.getinstance();
				//LinkedList<Player> players=gm.return_Players();
				
				Three_p_s_next tpsn=Three_p_s_next.getinstance();
				
				
				
				int level_num=tpsn.return_level_com();
				Draw_deck dd=Draw_deck.getinstance();
				//end of the game
			    
			    LinkedList<Player> players=gm.return_Players();
			    if(dd.return_cards().size()==3) {
			    	 for(Iterator<Card> itc=dd.return_cards().iterator();itc.hasNext();) {
						   for(Iterator<Player> itp=players.iterator();itp.hasNext();) {
						      itp.next().addToJest(itc.next());
						   }
					  }
			    	 
			    	 
			    }
			    //end of the game
				
	 if( !(dd.return_cards().size()==3) ) {
				gm.set_handcards();//important
				
				int j=0;
				for(j=num_real+1;j<=players.size();j++) {
						 Computer_player p=null;
						 Card cc=new Card();
							if(level_num==2) {
								
								p=(Com_normal)players.get(j-1);
								 p.show_hands();
								JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
								
								cc=p.make_offer();
								
								
								//Three_mode_offers tmo=Three_mode_offers.getinstance();
							    tmo.add_card(p, cc);
				
							}else if (level_num==1){
								//p.setGameStrategy(new Com_easy());
								p=(Com_easy)players.get(j-1);
								 p.show_hands();
								JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
								
								cc=p.make_offer();
								
								
								//Three_mode_offers tmo=Three_mode_offers.getinstance();
							    tmo.add_card(p, cc);
							    
							}else {
								p=(Com_impossible)players.get(j-1);
								 p.show_hands();
								JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
								
								cc=p.make_offer();
								
								
								//Three_mode_offers tmo=Three_mode_offers.getinstance();
							    tmo.add_card(p, cc);
							    
							}
					 System.out.println("the offer of computer is "+cc.toString()+"of "+p.get_nom());
					 
				}
				
				
				
				
				i=1;
				for(Iterator<Player> it=players.iterator();it.hasNext();) {
					
					 if(i<=num_real) { 
						Player_real pr=new Player_real();
						pr=(Player_real)it.next();
						i++;
						Choose_card choose_card=new Choose_card();
					    choose_card.changeTitle(pr.get_nom());
						Card handcard1=new Card();
						Card handcard2=new Card();
						handcard1=pr.get_hands().get(0);
						handcard2=pr.get_hands().get(1);
						choose_card.set_up(handcard1,handcard2);
						choose_card.setPlayer(pr);
						choose_card.setVisible(true);
					}else {
						break;
					}
				}
	 }else {
		 frame.set_button4_invisible();
		 frame.last_2_buttons_visible();
		 JOptionPane.showMessageDialog(frame,"There are 0 card in the draw deck");
		 int num_p=3;
		 int[] jest_scores;
	    
		 if(num_p==3) {
	    	  jest_scores=new int[3];
	      }else {
	    	  jest_scores=new int[4];
	      }
	      VisitordeJest vdj=new VisitordeJest();
	       i=0;
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
	      for(Iterator<Player> it=players.iterator();it.hasNext();) {
	    	  Player p=it.next();
	    	  System.out.println("The player"+p.get_nom());
	    	  p.show_jest();
	      }
	      Trophies tp=Trophies.getinstance();
	      Card tp1=new Card();
	      Card tp2=new Card();
	     
				tp1=Three_mode_playingScene.tro1;
				tp2=Three_mode_playingScene.tro2;
				gm.award(tp1);
			    gm.award(tp2);
	      
	      
	      
	    	  jest_scores=new int[3];
	     
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
	 
		
				
				
				
				
				
				
				
				
				
				//JOptionPane.showMessageDialog(frame,"Now it's time for Player "+p.get_nom()+" to make an offer(mean choose one faceUP card of two)");
				
				
				
				//Three_mode_offers tmo=new Three_mode_offers();
			    //tmo.changer_card(p, c1);
			    //tmo.setVisible(true);
				//gm.pmake_offer();
			}
		});
		
		
		
	}
	
	
	
}

