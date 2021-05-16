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

public class Three_mode_playingScene extends JFrame {
	
    private static Three_mode_playingScene frame;
	private JPanel contentPane;
	private JLabel trophie1;
	private JLabel trophie2;
	private JButton btnStart;
	private JLabel lblPlayer1;
	private JLabel lblPlayer2;
	private JLabel lblPlayer3;
	private JLabel handcard_1_1;
	private JLabel handcard_1_2;
	private JLabel handcard_2_1;
	private JLabel handcard_2_2;
	private JLabel handcard_3_1;
	private JLabel handcard_3_2;
	private JButton btnOffer;
	private JButton btnChooseCard;
	private JButton btnDealCard;
	private Player_real pr;
	private JLabel lblThisIsNo;
	private JButton btnGiveTheTrophies;
	private JButton btnShowTheJest;
	public static Card tro1;
	public static Card tro2;
	
	/**
	 * Launch the application.
	 */
	
	public void set_player_real(Player_real pr) {
		this.pr=pr;
	}
	
	public static Three_mode_playingScene getinstance() {
		if(frame == null) {
			frame=new Three_mode_playingScene();
		}
		return frame;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Three_mode_playingScene frame = new Three_mode_playingScene();
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
	private Three_mode_playingScene() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 668);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(0, 250, 154));
		frame=this;
		
		ImageIcon regle_img=new ImageIcon("image_de_projet/Regles.png");
		JLabel label=new JLabel(regle_img);
		contentPane.add(label);
		label.setBounds(0, 0, 213, 306);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReferenceCard = new JLabel("Reference card");
		lblReferenceCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReferenceCard.setBounds(45, 316, 138, 27);
		contentPane.add(lblReferenceCard);
		
		
		//JLabel lblNewLabel = new JLabel("New label");
		
		
		trophie1=new JLabel(new ImageIcon("image_de_projet/dos.png"));
		trophie1.setBounds(370, 218, 100, 145);////100///////145
		contentPane.add(trophie1);
		//trophie1.setVisible(false);
		
		trophie2=new JLabel(new ImageIcon("image_de_projet/dos.png"));
		trophie2.setBounds(476, 218, 100, 145);
		contentPane.add(trophie2);
		//trophie2.setVisible(false);
		
		JLabel lblJest = new JLabel("Trophies");
		lblJest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJest.setBounds(439, 189, 116, 39);
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
		lblPlayer2.setBounds(505, 155, 83, 13);
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
		handcard_3_2.setBounds(832, 147, 100, 145);
		contentPane.add(handcard_3_2);
		handcard_3_2.setVisible(false);
		
		btnStart = new JButton("Start");
		//this.set_jest();
		btnStart.setBounds(223, 10, 101, 27);
		contentPane.add(btnStart);
		new Three_playground_controle(frame,btnStart,trophie1,trophie2,lblJest,handcard_1_1,handcard_1_2);
		
		btnOffer = new JButton("Offer");
		btnOffer.setBounds(224, 93, 100, 21);
		contentPane.add(btnOffer);
		btnOffer.setVisible(false);
		
		//new
		
		new Three_playground_Offer(btnOffer);
		
		
		
		btnChooseCard = new JButton("Choose Card");
		btnChooseCard.setBounds(223, 124, 124, 21);
		contentPane.add(btnChooseCard);
		btnChooseCard.setVisible(false);
		
		//new 
		new Three_playground_ChooseCard(btnChooseCard);
		
		btnDealCard = new JButton("deal card");
		btnDealCard.setBounds(223, 62, 101, 21);
		contentPane.add(btnDealCard);
		
		lblThisIsNo = new JLabel("This is No.    round");
		lblThisIsNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThisIsNo.setBackground(SystemColor.activeCaption);
		lblThisIsNo.setBounds(58, 369, 230, 69);
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
		btnShowTheJest.setBounds(223, 155, 124, 27);
		contentPane.add(btnShowTheJest);
		btnShowTheJest.setVisible(false);
		
		btnGiveTheTrophies = new JButton("give the Trophies");
		btnGiveTheTrophies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_all_jests saj=new show_all_jests();
				saj.set_players();
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				int[] jest_scores;
				Trophies tp=Trophies.getinstance();
			      Card tp1=new Card();
			      Card tp2=new Card();
			     
						tp1=Three_mode_playingScene.tro1;
						tp2=Three_mode_playingScene.tro2;
						gm.award(tp1);
					    gm.award(tp2);
			    	  jest_scores=new int[3];
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
		btnGiveTheTrophies.setBounds(223, 189, 124, 32);
		contentPane.add(btnGiveTheTrophies);
		btnGiveTheTrophies.setVisible(false);
		
		
		btnDealCard.setVisible(false);
		btnDealCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				GM.use_for_three_phase1();
				
				handcard_1_1.setVisible(true);
				handcard_1_2.setVisible(true);
				handcard_2_1.setVisible(true);
				handcard_2_2.setVisible(true);
				handcard_3_1.setVisible(true);
				handcard_3_2.setVisible(true);
				
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
 	    Card c2=dd.pick_card();
 	   
 	    Trophies tp=Trophies.getinstance();
 	    tp.addCard(c1);
 	    tp.addCard(c2);
		this.tro1=new Card();
		this.tro2=new Card();
		tro1=tp.getFirst();
		tro2=tp.getLast();
		Set_card set_card=new Set_card();
		tp.afficher();
		trophie1.setIcon(set_card.set_card(tro1));
		trophie2.setIcon(set_card.set_card(tro2));
		
		
		//trophie1.setBounds(424, 218, 176, 256);////176///////256
		//contentPane.add(trophie1);
		trophie1.setVisible(false);
		
		
		//trophie2.setBounds(490, 218, 176, 256);
		//contentPane.add(trophie2);
		trophie2.setVisible(false);
	}
	
	public void set_name() {
		
		lblPlayer1.setText(Three_p_s_next.player1_name);
		lblPlayer2.setText(Three_p_s_next.player2_name);
		lblPlayer3.setText(Three_p_s_next.player3_name);
		
	}
	
	public void set_hand_card(Player p,Card c1,Card c2) {//只要set玩家的手牌即可
		Set_card set_card=new Set_card();
		p.show_hands();
		
		//if(p.get_nom()==Three_p_s_next.player1_name) {
			//handcard_1_1.setIcon(set_card.set_card(c1));
		    //handcard_1_2.setIcon(set_card.set_card(c2));
		//}else if(p.get_nom()=="Computer1") {
			//handcard_2_1.setIcon(set_card.set_card(c1));
		    //handcard_2_2.setIcon(set_card.set_card(c2));
		//}else if(p.get_nom()=="Computer2") {
			//handcard_3_1.setIcon(set_card.set_card(c1));
		   // handcard_3_2.setIcon(set_card.set_card(c2));
		//}
		
	}
	
	public void change_num_round(int i) {
		lblThisIsNo.setText("This is No."+i+" round");
		lblThisIsNo.setVisible(true);
	}
}
