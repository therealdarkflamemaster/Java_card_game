package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CARD.Card;
import CARD.Draw_deck;
import Controleur.Set_card;
import Livrable_1.GM;
import Livrable_1.Player;
import Livrable_1.Player_real;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
public class You_have_chosen_4version extends JFrame {

	private JPanel contentPane;
	private JLabel lblCard;
	private JButton btnOk;
	private Player next_one;
	public static Player first;
	public static Player second;
	public static Player third;
	public static Player fourth;
	public static boolean isthreeequelone=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					You_have_chosen_4version frame = new You_have_chosen_4version();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public You_have_chosen_4version() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 258);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You have chosen the card...");
		lblNewLabel.setBounds(10, 10, 189, 13);
		contentPane.add(lblNewLabel);
		
		lblCard = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCard.setBounds(105, 33, 100, 145);
		contentPane.add(lblCard);
		
		btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new part of choose card,add to the jest
				//第一个玩家是人的情况
				Four_mode_offers tmo=Four_mode_offers.getinstance();
				dispose();
				JFrame frame=tmo.get_frame();
				   GM gm=GM.getinstance();
			       LinkedList<Player> players=gm.return_Players();
				   LinkedList<Player> players_sorted=gm.sort_player();
				 You_have_chosen_4version.first=players_sorted.getFirst();
				if(Four_mode_offers.rest_num==0) {
				   JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button OFFER");
				}else {
				   
				   if(Four_mode_offers.rest_num==3) {
					     //还有三个玩家的情况
					   next_one=null;
					   next_one=tmo.return_next_player();
					   You_have_chosen_4version.second=next_one;
					   JOptionPane.showMessageDialog(frame, "Now the player "+next_one.get_nom()+" can choose the card.");
					   if(next_one instanceof Player_real) {
						   //第二个玩家是人，选两个人模式，然后这种情况会回到这里
						   
						   Four_mode_offers.rest_num=2;
						   second.take_his_card();
 
					   }else {
						   //如果第二个玩家是电脑，这里执行结束
						   Four_mode_offers.rest_num=2;
						   Card c2=new Card();
						   c2=second.take_his_card();
						   
						   //再判断第三个人，第三个是玩家，单人选牌模式
						   third=gm.find_player(c2);
						   You_have_chosen_4version.first=players_sorted.getFirst();
						   
						   
						  
						   if(third.equals(first)) {
							   You_have_chosen_4version.isthreeequelone=true;
							   LinkedList<Player> pp =new LinkedList<Player> ();
								Player p=null;
								for(Iterator<Player> it=players.iterator();it.hasNext();) {
									 p=it.next();
									if( (p!=first) && (p!=second) ) {
										pp.add(p);
									}
								}
								
								third=pp.getFirst();
								fourth=pp.getLast();
								
								JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
								Four_mode_offers.rest_num=2;
								
								if(third instanceof Player_real) {
									third.take_his_card(fourth);
									//该种情况会回到这里
								}else {
									//
									Card cc=new Card();
									third.take_his_card(fourth);
									Card c5=new Card();
									System.out.println("For the player "+fourth.get_nom());
									Four_mode_offers.rest_num=1;
									if(fourth instanceof Player_real) {
										
										c5=fourth.take_his_card(third);
										//该种情况会回到这里
									}else {
										c5=fourth.take_his_card(third);
										JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
										//termine
									}
								}
								
						   }else {
							   
							   JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
							   Four_mode_offers.rest_num=2;
							   
							   if(third instanceof Player_real) {
								    Card c4=new Card();
									second.change_chosen(true);
									third.change_chosen(false);
									first.change_chosen(false);
									Four_mode_offers.rest_num=1;
									c4=third.take_his_card(); 
									
								   
							   }else {
								    Card c4=new Card();
									second.change_chosen(true);
									third.change_chosen(false);
									first.change_chosen(false);
									c4=third.take_his_card(); 
									fourth=gm.find_player(c4);
									
									// le troisieme joueur a fini le procedure de choisir la carte
									Four_mode_offers.rest_num=1;
									if(fourth.get_nom().equals(first.get_nom())) {
										first.change_chosen(true);
										second.change_chosen(true);
										third.change_chosen(true);
										for(Iterator<Player> it=players.iterator();it.hasNext();) {
											Player p=it.next();
											if(!p.get_chosen()) {// si ce joueur n'a pas ete choisi
												fourth=p;
											}
										}
										
										
										Card c5=new Card();
										Four_mode_offers.rest_num=0;
										if(fourth instanceof Player_real) {
											c5=fourth.take_his_card(fourth);
										}else {
											c5=fourth.take_his_card(fourth);
											JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
											//termine
										}
									}else {
										// le cas normal
										Four_mode_offers.rest_num=0;
										Card c5=new Card();
										if(fourth instanceof Player_real) {
											c5=fourth.take_his_card(first);
										}else {
											c5=fourth.take_his_card(first);
											JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
											//termine
										}
										
									}
							   }
						   
					        }
					   }
					   
				   }else if(Four_mode_offers.rest_num==2) {
					   next_one=null;
					   next_one=tmo.return_next_player();
					   
					   You_have_chosen_4version.second=tmo.return_player_turn();
					   You_have_chosen_4version.third=next_one;
					   
					   
					   
					   if(You_have_chosen_4version.isthreeequelone) {
						   LinkedList<Player> pp =new LinkedList<Player> ();
							Player p=null;
							for(Iterator<Player> it=players.iterator();it.hasNext();) {
								 p=it.next();
								if( (p!=first) && (p!=second) ) {
									pp.add(p);
								}
							}
							Player fourth=null;
							third=pp.getFirst();
							fourth=pp.getLast();
							
							JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
							
							if(third instanceof Player_real) {
								Four_mode_offers.rest_num=1;
								third.take_his_card(fourth);
								//该种情况会回到这里
							}else {
								//
								Card cc=new Card();
								third.take_his_card(fourth);
								Card c5=new Card();
								System.out.println("For the player "+fourth.get_nom());
								Four_mode_offers.rest_num=0;
								if(fourth instanceof Player_real) {
									
									c5=fourth.take_his_card(third);
									//该种情况会回到这里
								}else {
									c5=fourth.take_his_card(third);
									JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
									//termine
								}
							}
							
					   }else {
						   
						   JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
						   Four_mode_offers.rest_num=2;
						   
						   if(third instanceof Player_real) {
							    Card c4=new Card();
								second.change_chosen(true);
								third.change_chosen(false);
								first.change_chosen(false);
								Four_mode_offers.rest_num=1;
								c4=third.take_his_card(); 
								
							   
						   }else {
							    Card c4=new Card();
							    
								second.change_chosen(true);
								third.change_chosen(false);
								first.change_chosen(false);
								c4=third.take_his_card(); 
								fourth=gm.find_player(c4);
								
								// le troisieme joueur a fini le procedure de choisir la carte
								
								if(fourth.get_nom().equals(first.get_nom())) {
									first.change_chosen(true);
									second.change_chosen(true);
									third.change_chosen(true);
									for(Iterator<Player> it=players.iterator();it.hasNext();) {
										Player p=it.next();
										if(!p.get_chosen()) {// si ce joueur n'a pas ete choisi
											fourth=p;
										}
									}
									
									
									Card c5=new Card();
									Four_mode_offers.rest_num=0;
									if(fourth instanceof Player_real) {
										c5=fourth.take_his_card(fourth);
									}else {
										c5=fourth.take_his_card(fourth);
										JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
										//termine
									}
								}else {
									// le cas normal
									Four_mode_offers.rest_num=0;
									Card c5=new Card();
									if(fourth instanceof Player_real) {
										c5=fourth.take_his_card(first);
									}else {
										c5=fourth.take_his_card(first);
										JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
										//termine
									}
									
								}
						   }
					   
				        }
				   
					   
				   }
				   else if(Four_mode_offers.rest_num==1){
					   //只有最后一个玩家的情况
				     
					   You_have_chosen_4version.first=players_sorted.getFirst();
					   You_have_chosen_4version.third=tmo.return_player_turn();
					   
					   
					
						// le troisieme joueur a fini le procedure de choisir la carte
						
						
						
						 if( You_have_chosen_4version.isthreeequelone ) {
							 
							 LinkedList<Player> pp =new LinkedList<Player> ();
								Player p=null;
								for(Iterator<Player> it=players.iterator();it.hasNext();) {
									 p=it.next();
									if( (p!=first) && (p!=second) ) {
										pp.add(p);
									}
								}
								Player fourth=null;
								fourth=pp.getLast();
								
								JOptionPane.showMessageDialog(frame, "Now the player "+fourth.get_nom()+" can choose the card.");
								Four_mode_offers.rest_num=0;
								Card ccc=fourth.take_his_card(third);
								//termine
						 }else {
							   next_one=null;
							   next_one=tmo.return_next_player();
							   You_have_chosen_4version.fourth=next_one;
						  if(fourth.get_nom().equals(first.get_nom())) {
							   first.change_chosen(true);
							   second.change_chosen(true);
							   third.change_chosen(true);
							   for(Iterator<Player> it=players.iterator();it.hasNext();) {
								   Player p=it.next();
								   if(!p.get_chosen()) {// si ce joueur n'a pas ete choisi
									  fourth=p;
								   }
							   }
							   Card c5=new Card();
							   Four_mode_offers.rest_num=0;
							   if(fourth instanceof Player_real) {
								  c5=fourth.take_his_card(fourth);
							   }else {
								  c5=fourth.take_his_card(fourth);
								JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
								//termine
							}
						  }else {
							// le cas normal
							Four_mode_offers.rest_num=0;
							  Card c5=new Card();
							  if(fourth instanceof Player_real) {
								  c5=fourth.take_his_card(first);
							  }else {
								  c5=fourth.take_his_card(first);
								  JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
								  //termine
							}
							
						}
						 }
						
				   }
			   
				}
					
					   
				   }
				   
				
				
				
				
				
			
		});
		btnOk.setBounds(225, 186, 85, 21);
		contentPane.add(btnOk);
	}
	
	public void setCardimage(Card c) {
		c.changeCondition("up");
		Set_card set_card=new Set_card();
		ImageIcon img=new ImageIcon();
		img=set_card.set_card(c);
		this.lblCard.setIcon(img);
	}
	
	public void getinfos(Player next_one) {
		this.next_one=null;
		this.next_one=next_one;
	}
	
	
}
