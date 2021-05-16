package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import CARD.Card;
import CARD.Draw_deck;
import CARD.Rest;
import Livrable_1.GM;
import Livrable_1.Player;
import Livrable_1.Player_real;
import Vue.Three_mode_offers;
import Vue.Three_mode_playingScene;

public class Three_playground_ChooseCard {
	//选牌阶段主要函数
	public Three_playground_ChooseCard(JButton btnChooseCard) {
		btnChooseCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				LinkedList<Player> players_sorted=gm.sort_player();
				Three_mode_playingScene frame=Three_mode_playingScene.getinstance();
				int num_p=3;
				
				JOptionPane.showMessageDialog(frame,"Now, start to choose card phrase");
				Three_mode_offers tmo=Three_mode_offers.getinstance(); 
				
				Card c1=new Card();
				Card c2=new Card();
				Card c3=new Card();
				
				for(Iterator<Player> it=players.iterator();it.hasNext();) {
					it.next().change_chosen(false);
				}
				
				Rest rest_this_round=new Rest();
				
				Player first_one=players_sorted.getFirst();//correcte
				
				JOptionPane.showMessageDialog(frame, "The first one to choose the card to his/her Jest is player "+first_one.get_nom());
				
				
				//要分成电脑和玩家不同的算法   1/2
				if(first_one instanceof Player_real) {
					//第一个玩家是人
					
					Three_mode_offers.rest_num=2;
					c1=first_one.take_his_card();
					//此时两张牌已经加入jest和牌库了
				}else {
					//第一个玩家是电脑
					Three_mode_offers.rest_num=3;
					c1=first_one.take_his_card();
					Three_mode_offers.rest_num=2;
					Player second_one=null;
					second_one=gm.find_player(c1);
					
					//la fin de first_one
					
					
					
					JOptionPane.showMessageDialog(frame, "Computer Player "+first_one.get_nom()+"have chosen the card of "+second_one.get_nom()+"  Now the player "+second_one.get_nom()+" can choose the card.");
					if(second_one instanceof Player_real) {
						//第2个玩家是人
						Player p=null;
						Player third_one=null;
						for(Iterator<Player> it=players.iterator();it.hasNext();) {
							p=it.next();
							if((!p.get_nom().equals(first_one.get_nom())) && (!p.get_nom().equals(second_one.get_nom())) ) {// si ce joueur n'a pas ete choisi
								third_one=p;
							}
						}
						Three_mode_offers.rest_num=1;
						((Player_real) second_one).not_choose_from_his_card(second_one);
						
						
					}else {
						//第1,2个玩家是电脑
						first_one.change_chosen(false);
						c2=second_one.take_his_card();
						Player third_one=null;
						third_one=gm.find_player(c2);
						
					     if(num_p==3 && third_one.get_nom().equals(first_one.get_nom())) {
							Player p=null;
							
							for(Iterator<Player> it=players.iterator();it.hasNext();) {
								p=it.next();
								if((!p.get_nom().equals(first_one.get_nom())) && (!p.get_nom().equals(second_one.get_nom())) ) {// si ce joueur n'a pas ete choisi
									third_one=p;
								}
							}
							//这里third one要去拿自己的卡，建议新建一个函数，会输入player那种的
							Three_mode_offers.rest_num=0;	
							c3=((Player_real) third_one).take_his_card(third_one);
					            
					        }else if(num_p==3 && !( third_one.get_nom().equals( first_one.get_nom() ) )) {
								//third_one have to take card from the first_one
					        	Three_mode_offers.rest_num=0;
					        	c3=((Player_real) third_one).take_his_card(first_one);
							}
					
					//.....
				    }
				 //end of the game
				    Draw_deck dd=Draw_deck.getinstance();
				    if(dd.return_cards().size()==3) {
				    	 for(Iterator<Card> itc=dd.return_cards().iterator();itc.hasNext();) {
							   for(Iterator<Player> itp=players.iterator();itp.hasNext();) {
							      itp.next().addToJest(itc.next());
							   }
						  }
				    	 
				    }
				    //end of the game
				    
				}
			}
		});
	}

}
