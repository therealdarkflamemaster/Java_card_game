package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CARD.Card;
import Controleur.Set_card;
import Controleur.Three_p_s_next;
import Controleur.Three_playground_Done;
import Controleur.Three_playground_controle;
import Livrable_1.Com_easy;
import Livrable_1.Com_impossible;
import Livrable_1.Com_normal;
import Livrable_1.Computer_player;
import Livrable_1.GM;
import Livrable_1.Player;
import Livrable_1.Player_real;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

// make for phase "Offer" button in Three_playground_scene
public class Choose_card extends JFrame {
    
	private JPanel contentPane;
	private JLabel handcard1;
	private JLabel handcard2;
	private JComboBox comboBox;
	private JButton btnDone;
	private int choose_num=-1;
	private Player_real p;
	private Card return_card;
	private JLabel lblPlayersName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose_card frame = new Choose_card();
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
	
	
	
	
	public Card getCard() {
		return return_card;
	}
	public void set_up(Card c1,Card c2) {
		Set_card sc=new Set_card();
		handcard1.setIcon(sc.set_card(c1));
		handcard2.setIcon(sc.set_card(c2));
	}
	
	public void set_choose_num(int a) {
		this.choose_num=a;
	}
	
	public int get_choose_num() {
		
		return choose_num;
	}
	
	public void setPlayer(Player_real p) {
		this.p=p;
	}
	
	public Choose_card() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		handcard1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		handcard1.setBounds(46, 31, 100, 145);
		contentPane.add(handcard1);
		
		handcard2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		handcard2.setBounds(206, 31, 100, 145);
		contentPane.add(handcard2);
		
		
		comboBox = new JComboBox();
		comboBox.addItem("--please choose--");
		comboBox.addItem(" Card 1");
		comboBox.addItem(" Card 2");
		
		comboBox.setBounds(219, 197, 116, 21);
		contentPane.add(comboBox);
		
		JLabel lblTypeIn = new JLabel("Type in 1 or 2 to choose the card ");
		lblTypeIn.setBounds(27, 201, 268, 13);
		contentPane.add(lblTypeIn);
		
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose_num=comboBox.getSelectedIndex();
				Card c1=new Card();
				Card c2=new Card();
				if(choose_num==1) {
					p.set_offer(p.get_hands().get(0));
					p.get_hands().get(1).changeCondition("down");
					c1=p.get_hands().get(0);
					c2=p.get_hands().get(1);
				}else if(choose_num==2) {//a==0
					  p.set_offer(p.get_hands().get(1));
					  p.get_hands().get(0).changeCondition("down");
					  c1=p.get_hands().get(1);
					  c2=p.get_hands().get(0);
				  }
				GM gm=GM.getinstance();
				if(gm.return_Players().size()==3) {
					 Three_mode_offers tmo=Three_mode_offers.getinstance();
			         tmo.add_card(p, c1);
			         dispose();
				}else {
					Four_mode_offers tmo=Four_mode_offers.getinstance();
			         tmo.add_card(p, c1);
			         dispose();
				}
				   
			        ////
			        
			        ////
			        
			        
			       
			        
			        //如果人数大于等于2，等于3，在以后新建立几个choose——card，还要记得把之前的卡隐藏起来
			        //tmo.setvisible(true); 成功了！！！！
			        
			        //需要知道怎么判断接下来是人还是电脑，在gm中把电脑的部分抠出来
			        
			        
				   //要把c1加到three mode offers里面，在offers里面建立一个牌堆，方便
				  //three mode offers 需要是singleton
				///////////////////
				
				
				
			}
		});
		//new Three_playground_Done(this,btnDone,comboBox);
		
		
		btnDone.setBounds(283, 252, 85, 21);
		contentPane.add(btnDone);
		
		lblPlayersName = new JLabel("Player's name : ");
		lblPlayersName.setBounds(10, 10, 136, 13);
		contentPane.add(lblPlayersName);
		
		
		
		
	}
	
	public void changeTitle(String playername) {
		lblPlayersName.setText("Player's name : "+playername);
	}
}
