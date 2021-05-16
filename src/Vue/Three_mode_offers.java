package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import CARD.Card;
import CARD.Draw_deck;
import Controleur.Set_card;
import Controleur.Three_p_s_next;
import Livrable_1.GM;
import Livrable_1.Player;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//singleton et initalisation en meme temps
public class Three_mode_offers {
    private static Three_mode_offers tmo=null;
    private JFrame frame;
	private JLabel lblCard1_1;
	private JLabel lblCard2_1;
	private JLabel lblCard3_1;
	private JComboBox comboBox_player;
	private JComboBox comboBox_card;
	private JLabel lblMessageOfChoose;
	private JLabel lblCardDown1_2;
	private JLabel lblCardDown2_2;
	private JLabel lblCardDown3_2;
	private LinkedList<Card> offers;
	private Player player_return;
	private Player player_next;
	private Card add_to_drawdeck;
    public  static int rest_num=3; //还剩下的人数，根据这个调用不同的函数，还可以标识回合结束
	/**
	 * Launch the application.
	 */
	
	public static Three_mode_offers getinstance() {
		if(tmo==null) {
			tmo=new Three_mode_offers();
		}
		return tmo;
	}
	
	public JFrame get_frame() {
		return this.frame;
	}
	
	public Player return_next_player() {
		return player_next;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Three_mode_offers window = new Three_mode_offers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Three_mode_offers() {
		initialize();
		offers=new LinkedList<Card>();
	}
	
	public void set_new() {
		//initialize();
		offers=new LinkedList<Card>();
		this.player_next=null;
		this.player_return=null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 685, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblCard1_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCard1_1.setBounds(105, 45, 100, 145);
		frame.getContentPane().add(lblCard1_1);
		
		lblCard2_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCard2_1.setBounds(281, 45, 100, 145);
		frame.getContentPane().add(lblCard2_1);
		
		lblCard3_1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCard3_1.setBounds(456, 45, 100, 145);
		frame.getContentPane().add(lblCard3_1);
		
		lblCardDown1_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCardDown1_2.setBounds(105, 200, 100, 145);
		frame.getContentPane().add(lblCardDown1_2);
		
		lblCardDown2_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCardDown2_2.setBounds(281, 200, 100, 145);
		frame.getContentPane().add(lblCardDown2_2);
		
		lblCardDown3_2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		lblCardDown3_2.setBounds(456, 200, 100, 145);
		frame.getContentPane().add(lblCardDown3_2);
		
		comboBox_player = new JComboBox();
		comboBox_player.setBounds(177, 405, 106, 21);
		frame.getContentPane().add(comboBox_player);
		comboBox_player.addItem("--please choose--");
		comboBox_player.addItem(Three_p_s_next.player1_name);
		comboBox_player.addItem(Three_p_s_next.player2_name);
		comboBox_player.addItem(Three_p_s_next.player3_name);
		
		JLabel lblDecideToChoose = new JLabel("Decide to choose from...");
		lblDecideToChoose.setBounds(29, 382, 189, 13);
		frame.getContentPane().add(lblDecideToChoose);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(121, 405, 46, 13);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblCardOr = new JLabel("Card 1 or 2");
		lblCardOr.setBounds(321, 409, 95, 13);
		frame.getContentPane().add(lblCardOr);
		
		comboBox_card = new JComboBox();
		comboBox_card.addItem("--please choose--");
		comboBox_card.addItem(" Card 1");
		comboBox_card.addItem(" Card 2");
		comboBox_card.setBounds(408, 405, 100, 21);
		frame.getContentPane().add(comboBox_card);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				    Three_mode_offers tmo=Three_mode_offers.getinstance();
					
					GM gm=GM.getinstance();
					LinkedList<Player> players=gm.return_Players();
				    int choose_player_num=-1;
				    int choose_card=-1;
				    player_next=null;
				    choose_player_num=comboBox_player.getSelectedIndex()-1;
					choose_card=comboBox_card.getSelectedIndex()-1;
					player_next=players.get(choose_player_num);
					add_to_drawdeck=new Card();
					Card add_to_jest=new Card();
					Player player_now=null;
					player_now=tmo.return_player_turn();
					if(choose_card==0) {
						
						add_to_jest=player_next.get_offer();
					}else {
						if(player_next.get_hands().get(0)!=player_next.get_offer()) {
							add_to_jest=player_next.get_hands().get(0);
						}else {
							add_to_jest=player_next.get_hands().get(1);
						}
						
					}
					
					player_now.addToJest(add_to_jest);
					
					Draw_deck dd=Draw_deck.getinstance();
					if(player_next.get_hands().get(0)!=add_to_jest) {
						add_to_drawdeck=player_next.get_hands().get(0);
					}else {
						add_to_drawdeck=player_next.get_hands().get(1);
					}
					
					
					dd.add_card(add_to_drawdeck);
					dd.melanger();

					frame.dispose();
					You_have_chosen yhc=new You_have_chosen();
					
					yhc.setCardimage(add_to_jest);
					yhc.getinfos(player_next);
					yhc.setVisible(true);
				
				
				
				
			}
		});
		btnNext.setBounds(535, 442, 85, 21);
		frame.getContentPane().add(btnNext);
		
		JLabel lblPlayer_1 = new JLabel(Three_p_s_next.player1_name);
		lblPlayer_1.setBounds(118, 22, 87, 13);
		frame.getContentPane().add(lblPlayer_1);
		
		JLabel lblPlayer_2 = new JLabel(Three_p_s_next.player2_name);
		lblPlayer_2.setBounds(295, 22, 69, 13);
		frame.getContentPane().add(lblPlayer_2);
		
		JLabel lblPlayer_3 = new JLabel(Three_p_s_next.player3_name);
		lblPlayer_3.setBounds(469, 22, 70, 13);
		frame.getContentPane().add(lblPlayer_3);
		
		lblMessageOfChoose = new JLabel("Message of choose card :");
		lblMessageOfChoose.setBounds(10, 10, 292, 13);
		frame.getContentPane().add(lblMessageOfChoose);
	}
	
	public Card return_rest_card() {
		return  add_to_drawdeck;
	}
	
	public void set_player_now(Player p) {
		this.player_return=p;
	}
	
	public void add_card(Player p,Card c1) {//c1 is the card faceON 
		Set_card set_card=new Set_card();
		c1.changeCondition("up");
		ImageIcon img=set_card.set_card(c1);
		
		if(p.get_nom().equals(Three_p_s_next.player1_name)) {
			this.lblCard1_1.setIcon(img);
		}else if(p.get_nom().equals(Three_p_s_next.player2_name)) {
			this.lblCard2_1.setIcon(img);
		}else if(p.get_nom().equals(Three_p_s_next.player3_name)) {
			this.lblCard3_1.setIcon(img);
		}
		System.out.println(c1.toString());
		this.offers.add(c1);
		
		Card c2=new Card();
		if(p.get_hands().get(0)!=c1) {
			c2=p.get_hands().get(0);
		}else {
			c2=p.get_hands().get(1);
		}
		offers.add(c2);
	}
	
	public void setvisible(Boolean b) {
		this.frame.setVisible(b);
	}
	
	public void setmessage_of_choose(String a) {
		this.lblMessageOfChoose.setText(a);
	}
	
	public void set_not_afficher_card(Player p) {
		this.player_return=null;
		player_return=p;
		if(p.get_nom().equals(Three_p_s_next.player1_name)) {
			this.lblCardDown1_2.setVisible(false);
			this.lblCard1_1.setVisible(false);
			this.lblCard2_1.setVisible(true);
			this.lblCardDown2_2.setVisible(true);
			this.lblCard3_1.setVisible(true);
			this.lblCardDown3_2.setVisible(true);
			
		}else if(p.get_nom().equals(Three_p_s_next.player2_name)) {
			this.lblCardDown2_2.setVisible(false);
			this.lblCard2_1.setVisible(false);
			this.lblCardDown1_2.setVisible(true);
			this.lblCard1_1.setVisible(true);
			this.lblCard3_1.setVisible(true);
			this.lblCardDown3_2.setVisible(true);
			
		}else if(p.get_nom().equals(Three_p_s_next.player3_name)) {
			this.lblCardDown3_2.setVisible(false);
			this.lblCard3_1.setVisible(false);
			this.lblCardDown1_2.setVisible(true);
			this.lblCard1_1.setVisible(true);
			this.lblCard2_1.setVisible(true);
			this.lblCardDown2_2.setVisible(true);
		}
	}
	
	public void just_afficher(Player p) {
		if(p.get_nom().equals(Three_p_s_next.player1_name)) {
			this.lblCardDown1_2.setVisible(true);
			this.lblCard1_1.setVisible(true);
			this.lblCard2_1.setVisible(false);
			this.lblCardDown2_2.setVisible(false);
			this.lblCard3_1.setVisible(false);
			this.lblCardDown3_2.setVisible(false);
			
		}else if(p.get_nom().equals(Three_p_s_next.player2_name)) {
			this.lblCardDown2_2.setVisible(true);
			this.lblCard2_1.setVisible(true);
			this.lblCardDown1_2.setVisible(false);
			this.lblCard1_1.setVisible(false);
			this.lblCard3_1.setVisible(false);
			this.lblCardDown3_2.setVisible(false);
			
		}else if(p.get_nom().equals(Three_p_s_next.player3_name)) {
			this.lblCardDown3_2.setVisible(true);
			this.lblCard3_1.setVisible(true);
			this.lblCardDown1_2.setVisible(false);
			this.lblCard1_1.setVisible(false);
			this.lblCard2_1.setVisible(false);
			this.lblCardDown2_2.setVisible(false);
		}
	}
	
	public Player return_player_turn() {//此处返回的是正在选牌的玩家
		return player_return;
	}
}
