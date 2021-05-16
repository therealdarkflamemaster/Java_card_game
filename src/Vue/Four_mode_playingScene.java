package Vue;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import CARD.Card;
	import CARD.Draw_deck;
	import CARD.Trophies;
	import CARD.VisitordeJest;
import Controleur.Four_p_s_next;
import Controleur.Four_playground_ChooseCard;
import Controleur.Four_playground_Offer;
import Controleur.Four_playground_start;
import Controleur.Set_card;
	import Controleur.Three_p_s_next;
	import Controleur.Three_playground_ChooseCard;
	import Controleur.Three_playground_Offer;
	import Controleur.Three_playground_controle;
	import Livrable_1.GM;
	import Livrable_1.Player;
	import Livrable_1.Player_real;

	import java.awt.Color;
	import java.awt.SystemColor;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.awt.event.ActionEvent;
	import java.awt.Font;

public class Four_mode_playingScene extends JFrame {
		
	    private static Four_mode_playingScene frame;
		private JPanel contentPane;
		private JLabel trophie1;
		private JButton btnStart;
		private JLabel lblPlayer1;
		private JLabel lblPlayer2;
		private JLabel lblPlayer3;
		private JLabel lblPlayer4;
		private JLabel handcard_1_1;
		private JLabel handcard_1_2;
		private JLabel handcard_2_1;
		private JLabel handcard_2_2;
		private JLabel handcard_3_1;
		private JLabel handcard_3_2;
		private JLabel handcard_4_1;
		private JLabel handcard_4_2;
		private JButton btnOffer;
		private JButton btnChooseCard;
		private JButton btnDealCard;
		private Player_real pr;
		private JLabel lblThisIsNo;
		private JButton btnGiveTheTrophies;
		private JButton btnShowTheJest;
		public static Card tro1;
		
		
		/**
		 * Launch the application.
		 */
		
		public void set_player_real(Player_real pr) {
			this.pr=pr;
		}
		
		public static Four_mode_playingScene getinstance() {
			if(frame == null) {
				frame=new Four_mode_playingScene();
			}
			return frame;
		}
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Four_mode_playingScene frame = new Four_mode_playingScene();
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
		private Four_mode_playingScene() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 956, 668);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.activeCaption);
			contentPane.setForeground(new Color(0, 250, 154));
			frame=this;
			
			
			
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			//JLabel lblNewLabel = new JLabel("New label");
			
			
			trophie1=new JLabel(new ImageIcon("image_de_projet/dos.png"));
			trophie1.setBounds(444, 242, 100, 145);////100///////145
			contentPane.add(trophie1);
			//trophie2.setVisible(false);
			
			JLabel lblJest = new JLabel("Trophie");
			lblJest.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblJest.setBounds(467, 204, 116, 39);
			contentPane.add(lblJest);
			lblJest.setVisible(false);
			
			
			
			
			
			lblPlayer1 = new JLabel("Player 1");
			lblPlayer1.setBounds(505, 472, 100, 13);
			contentPane.add(lblPlayer1);
			
			handcard_1_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_1_1.setBounds(419, 486, 100, 145);
			contentPane.add(handcard_1_1);
			handcard_1_1.setVisible(false);
			
			handcard_1_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_1_2.setBounds(529, 486, 100, 145);
			contentPane.add(handcard_1_2);
			handcard_1_2.setVisible(false);
			
			///
			lblPlayer2 = new JLabel("Player 2");
			lblPlayer2.setBounds(500, 155, 83, 13);
			contentPane.add(lblPlayer2);
			
			handcard_2_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_2_1.setBounds(419, 0, 100, 145);
			contentPane.add(handcard_2_1);
			handcard_2_1.setVisible(false);
			
			handcard_2_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_2_2.setBounds(529, 0, 100, 145);
			contentPane.add(handcard_2_2);
			handcard_2_2.setVisible(false);
			
			////
			
			lblPlayer3 = new JLabel("Player 3");
			lblPlayer3.setBounds(733, 278, 89, 44);
			contentPane.add(lblPlayer3);
			
			handcard_3_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_3_1.setBounds(832, 306, 100, 145);
			contentPane.add(handcard_3_1);
			handcard_3_1.setVisible(false);
			
			handcard_3_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_3_2.setBounds(832, 151, 100, 145);
			contentPane.add(handcard_3_2);
			handcard_3_2.setVisible(false);
			
			btnStart = new JButton("Start");
			
			new Four_playground_start(frame,btnStart,trophie1,lblJest);
			
			//this.set_jest();
			btnStart.setBounds(10, 10, 101, 27);
			contentPane.add(btnStart);
			
			btnOffer = new JButton("Offer");
			btnOffer.setBounds(121, 44, 100, 21);
			contentPane.add(btnOffer);
			btnOffer.setVisible(false);
			
			//new
			
			new Four_playground_Offer(btnOffer);
			
			
			
			btnChooseCard = new JButton("Choose Card");
			btnChooseCard.setBounds(121, 72, 124, 21);
			contentPane.add(btnChooseCard);
			btnChooseCard.setVisible(false);
			
			//new 
			
			new Four_playground_ChooseCard(btnChooseCard);
			
			
			btnDealCard = new JButton("deal card");
			btnDealCard.setBounds(121, 13, 101, 21);
			contentPane.add(btnDealCard);
			
			lblThisIsNo = new JLabel("This is No.    round");
			lblThisIsNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblThisIsNo.setBackground(SystemColor.activeCaption);
			lblThisIsNo.setBounds(20, 123, 230, 69);
			lblThisIsNo.setVisible(false);
			contentPane.add(lblThisIsNo);
			
			btnShowTheJest = new JButton("Show the jest");
			btnShowTheJest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					show_all_jests saj=new show_all_jests();
					saj.set_players();
					saj.set_for_trophie(false);
					saj.setVisible(true);
					
				}
			});
			btnShowTheJest.setBounds(10, 41, 124, 27);
			contentPane.add(btnShowTheJest);
			btnShowTheJest.setVisible(false);
			
			btnGiveTheTrophies = new JButton("give the Trophie");
			btnGiveTheTrophies.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					show_all_jests saj=new show_all_jests();
					saj.set_players();
					GM gm=GM.getinstance();
					LinkedList<Player> players=gm.return_Players();
					int[] jest_scores;
					Trophies tp=Trophies.getinstance();
				      Card tp1=new Card();
				      
				     
							tp1=Four_mode_playingScene.tro1;
							
							gm.award(tp1);
						    
				    	  jest_scores=new int[4];
				      VisitordeJest vdj1=new VisitordeJest();
				      int i=0;
				      for(Iterator<Player> it=players.iterator();it.hasNext();) {
				    	  Player p=it.next();
				    	  jest_scores[i]=p.returnjest().accept(vdj1);
				    	  p.setJestscore(jest_scores[i]);
				    	  i++;
				      }
				      
				      int jest_score_max=-100;
				      Player winner=null;
				      for(Iterator<Player> it=players.iterator();it.hasNext();) {
				    	  Player p=it.next();
				    	  if(p.getJestscore()>jest_score_max) {
				    		  jest_score_max=p.getJestscore();
				    		  winner=p;
				    	  }
				      }
				      saj.set_for_trophie(true);
				      saj.setwinner(winner);
				      saj.setVisible(true);
				    
					
					
				}
			});
			
			btnGiveTheTrophies.setBounds(10, 80, 124, 32);
			contentPane.add(btnGiveTheTrophies);
			btnGiveTheTrophies.setVisible(false);
			
			lblPlayer4 = new JLabel("Player 4");
			lblPlayer4.setBounds(125, 327, 120, 13);
			contentPane.add(lblPlayer4);
			
			handcard_4_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_4_1.setBounds(10, 185, 100, 145);
			contentPane.add(handcard_4_1);
			handcard_4_1.setVisible(false);
			
			handcard_4_2 =new JLabel(new ImageIcon("image_de_projet/dos.png"));
			handcard_4_2.setBounds(11, 340, 100, 145);
			contentPane.add(handcard_4_2);
			handcard_4_2.setVisible(false);
			
			
			
			
			btnDealCard.setVisible(false);
			btnDealCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					GM.use_for_four_phase1();//probleme
					
					handcard_1_1.setVisible(true);
					handcard_1_2.setVisible(true);
					handcard_2_1.setVisible(true);
					handcard_2_2.setVisible(true);
					handcard_3_1.setVisible(true);
					handcard_3_2.setVisible(true);
					handcard_4_1.setVisible(true);
					handcard_4_2.setVisible(true);
					
					btnDealCard.setVisible(false);
					
				}
			});
			
			
			
			
			
			
		}
		
		public void set_button3_visible() {
			btnChooseCard.setVisible(true);
			btnOffer.setVisible(true);
			btnDealCard.setVisible(true);
		}
		
		public void last_2_buttons_visible() {
			btnGiveTheTrophies.setVisible(true);
			btnShowTheJest.setVisible(true);
		}
		
		public void set_button4_invisible() {
			btnChooseCard.setVisible(false);
			btnOffer.setVisible(false);
			btnDealCard.setVisible(false);
			this.lblThisIsNo.setVisible(false);
		}
		
		public void set_jest() {
			Draw_deck dd = Draw_deck.getinstance();
	    	dd.melanger();
			Card c1=dd.pick_card();
	 	   
	 	   
	 	    Trophies tp=Trophies.getinstance();
	 	    tp.addCard(c1);
	 	   
			this.tro1=new Card();
			
			tro1=tp.getFirst();
			
			Set_card set_card=new Set_card();
			tp.afficher();
			trophie1.setIcon(set_card.set_card(tro1));
			
			
			
			
			trophie1.setVisible(false);
			
			
			
			
		}
		
		public void set_name() {
			
			lblPlayer1.setText(Four_p_s_next.player1_name);
			lblPlayer2.setText(Four_p_s_next.player2_name);
			lblPlayer3.setText(Four_p_s_next.player3_name);
			lblPlayer4.setText(Four_p_s_next.player4_name);
			
		}
		
		public void set_hand_card(Player p,Card c1,Card c2) {//只要set玩家的手牌即可
			Set_card set_card=new Set_card();
			p.show_hands();
			
			
			
		}
		
		public void change_num_round(int i) {
			lblThisIsNo.setText("This is No."+i+" round");
			lblThisIsNo.setVisible(true);
		}
	}

