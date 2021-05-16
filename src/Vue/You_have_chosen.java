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

public class You_have_chosen extends JFrame {
    
	private JPanel contentPane;
	private JLabel lblCard;
	private JButton btnOk;
	private Player next_one;
	private static Player first;
	private static Player second;
	private static Player third;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					You_have_chosen frame = new You_have_chosen();
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
	public You_have_chosen() {
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
				Three_mode_offers tmo=Three_mode_offers.getinstance();
				dispose();
				JFrame frame=tmo.get_frame();
				if(Three_mode_offers.rest_num==0) {
				   JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button OFFER");
				}else {
				   
				   
				   //1 如果第二个玩家是电脑，这里执行结束，再判断第三个人，第三个是玩家，单人选牌模式
				   //2 第二个玩家是人，选两个人模式，然后这种情况会回到这里，再判断第三个人
				      //2.1 第三个是电脑，直接单人选完
				      //2.2 第三个也是人，单人模式
				   if(Three_mode_offers.rest_num==2) {
					     //还有两个玩家的情况
					   next_one=null;
					   next_one=tmo.return_next_player();
					   You_have_chosen.second=next_one;
					   JOptionPane.showMessageDialog(frame, "Now the player "+next_one.get_nom()+" can choose the card.");
					   if(next_one instanceof Player_real) {
						   //第二个玩家是人，选两个人模式，然后这种情况会回到这里
						   
						   Three_mode_offers.rest_num--;
						   ((Player_real) next_one).not_choose_from_his_card(second);
 
					   }else {
						   //如果第二个玩家是电脑，这里执行结束
						   Three_mode_offers.rest_num--;
						   Card c2=new Card();
						   c2=next_one.take_his_card();
						   
						   //再判断第三个人，第三个是玩家，单人选牌模式
						   GM gm=GM.getinstance();
					       LinkedList<Player> players=gm.return_Players();
						   LinkedList<Player> players_sorted=gm.sort_player();
						   You_have_chosen.first=players_sorted.getFirst();
						   Player third=null;
						   third=gm.find_player(c2);
						   You_have_chosen.third=third;
						   
						   if(third.equals(first)) {
							   Player p=null;
								for(Iterator<Player> it=players.iterator();it.hasNext();) {
									p=it.next();
									if( (!p.equals(first)) && (!p.equals(second))  ) {// si ce joueur n'a pas ete choisi
										third=p;
									}
								}
								JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
								Three_mode_offers.rest_num--;
								if(third instanceof Player_real) {
									third.take_his_card(third);
									
								}else {
									Card cc=new Card();
									third.take_his_card(third);
									JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
								}
								
						   }else {
							   JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
							   Three_mode_offers.rest_num--;
							   if(third instanceof Player_real) {
								   third.take_his_card(first);
							   }else {
								    Card cc=new Card();
									third.take_his_card(first);
									JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
								
							   }
						   
					        }
					   }
					   
				   }else if(Three_mode_offers.rest_num==1){
					   //只有最后一个玩家的情况
				       GM gm=GM.getinstance();
				       LinkedList<Player> players=gm.return_Players();
					   LinkedList<Player> players_sorted=gm.sort_player();
					   You_have_chosen.first=players_sorted.getFirst();
					   next_one=tmo.return_next_player();
					   
					   You_have_chosen.third=next_one;
					   
					   if(third.equals(first)) {
						   Player p=null;
							for(Iterator<Player> it=players.iterator();it.hasNext();) {
								p=it.next();
								if( (!p.equals(first)) && (!p.equals(second))  ) {// si ce joueur n'a pas ete choisi
									third=p;
								}
							}
							JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
							Three_mode_offers.rest_num--;
							if(third instanceof Player_real) {
								third.take_his_card(third);
								
							}else {
								Card cc=new Card();
								third.take_his_card(third);
								JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
							}
							
					   }else {
						   JOptionPane.showMessageDialog(frame, "Now the player "+third.get_nom()+" can choose the card.");
						   Three_mode_offers.rest_num--;
						   if(third instanceof Player_real) {
							   third.take_his_card(first);
						   }else {
							    Card cc=new Card();
								third.take_his_card(first);
								JOptionPane.showMessageDialog(frame, "Now all players have chosen their cards,please repress the button choose card");
							
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
