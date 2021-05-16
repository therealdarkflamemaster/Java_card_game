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
import Vue.Four_mode_offers;
import Vue.Four_mode_playingScene;
import Vue.Three_mode_offers;
import Vue.Three_mode_playingScene;
import Vue.You_have_chosen_4version;


public class Four_playground_ChooseCard {
	
	//ѡ�ƽ׶���Ҫ����
		public Four_playground_ChooseCard(JButton btnChooseCard) {
			btnChooseCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GM gm=GM.getinstance();
					LinkedList<Player> players=gm.return_Players();
					LinkedList<Player> players_sorted=gm.sort_player();
					Four_mode_playingScene frame=Four_mode_playingScene.getinstance();
					int num_p=4;
					
					JOptionPane.showMessageDialog(frame,"Now, start to choose card phrase");
					///////////////////////////////////////////////
					Four_mode_offers tmo=Four_mode_offers.getinstance(); 
					
					Card c1=new Card();
					Card c2=new Card();
					Card c3=new Card();
					Card c4=new Card();
					
					for(Iterator<Player> it=players.iterator();it.hasNext();) {
						it.next().change_chosen(false);
					}
					
					Rest rest_this_round=new Rest();
					
					Player first_one=players_sorted.getFirst();//correcte
					Four_mode_offers.rest_num=4;
					JOptionPane.showMessageDialog(frame, "The first one to choose the card to his/her Jest is player "+first_one.get_nom());
					
					
					//Ҫ�ֳɵ��Ժ���Ҳ�ͬ���㷨   1/2
					if(first_one instanceof Player_real) {
						//��һ���������
						
						Four_mode_offers.rest_num=3;
						first_one.change_chosen(true);
						c1=first_one.take_his_card();
						//��ʱ�������Ѿ�����jest���ƿ���
						//ok 
					}else {
						//��һ������ǵ���
						
						c1=first_one.take_his_card();
						You_have_chosen_4version.first=first_one;
						Four_mode_offers.rest_num=3;
						Player second_one=null;
						second_one=gm.find_player(c1);
						second_one.change_chosen(true);//�ڶ����˱�ѡ����
						//la fin de first_one
						You_have_chosen_4version.second=second_one;
						
						
						JOptionPane.showMessageDialog(frame, "Computer Player "+first_one.get_nom()+"have chosen the card of "+second_one.get_nom()+"  Now the player "+second_one.get_nom()+" can choose the card.");
						if(second_one instanceof Player_real) {
							
							Four_mode_offers.rest_num=2;
							second_one.take_his_card();//ok
							
							
						}else {
							//��1,2������ǵ���
							Player fourth_one=null;
							first_one.change_chosen(false);
							c2=second_one.take_his_card();
							second_one.change_chosen(true);//�ڶ����˱�ѡ����
							Player third_one=null;
							third_one=gm.find_player(c2);
							Four_mode_offers.rest_num=2;
						     if( third_one.get_nom().equals(first_one.get_nom())) {
						    	 You_have_chosen_4version.isthreeequelone=true;
								// c'est le cas que  players 3 et 4  auront encore comparer leurs offers
								first_one.change_chosen(true);
								second_one.change_chosen(true);
								
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
								You_have_chosen_4version.third=third_one;
								You_have_chosen_4version.fourth=fourth_one;
								
								System.out.println("For the player "+third_one.get_nom());
								if(third_one instanceof Player_real) {
									Four_mode_offers.rest_num=1;
									c4=third_one.take_his_card(fourth_one);
									//���ỹҪд�������,��You����haven-chosen����4version����д
								}else {
									
									c4=third_one.take_his_card(fourth_one);
								    rest_this_round.addtorest(c4);
								    Card c5=new Card();
								    System.out.println("For the player "+fourth_one.get_nom());
								    //player 1��2��3���ǵ��ԣ����ĸ����һ��������
								    Four_mode_offers.rest_num=0;
								    	c5=fourth_one.take_his_card(third_one);
								        //��Ҫд���˴��غϽ��� 
								    }
								}else {
									Four_mode_offers.rest_num=2;
									for(Iterator<Player> it=players.iterator();it.hasNext();) {
										it.next().change_chosen(false);
									}
									c4=new Card();
									first_one.change_chosen(false);
									second_one.change_chosen(true);
									third_one.change_chosen(false);
									//��3�����ѡ�Ĳ��ǵ�һ����ң��˴����������
									first_one.change_chosen(false);
									You_have_chosen_4version.third=third_one;
									if(third_one instanceof Player_real) {
										first_one.change_chosen(false);
										second_one.change_chosen(true);
										Four_mode_offers.rest_num=1;
										c4=third_one.take_his_card();
										//���ỹҪд�������
										
									}else {
										//player 1,2,3 sont computers
										c4=third_one.take_his_card();
										
										rest_this_round.addtorest(c4);
										fourth_one=gm.find_player(c4);
										fourth_one.change_chosen(false);
										// le troisieme joueur a fini le procedure de choisir la carte
										//��ô���ĸ�һ��������
										Four_mode_offers.rest_num=0;
										if(fourth_one.get_nom().equals(first_one.get_nom())) {
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
											You_have_chosen_4version.fourth=fourth_one;
											c5=fourth_one.take_his_card(fourth_one);
											
											
										}else {
											// le cas normal
											Card c5=new Card();
											You_have_chosen_4version.fourth=fourth_one;
											c5=fourth_one.take_his_card(first_one);
										
										}
										
									}
                                    
									
									

									
									
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



