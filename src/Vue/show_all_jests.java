package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;

import CARD.Card;
import Controleur.Four_p_s_next;
import Controleur.Three_p_s_next;
import Livrable_1.GM;
import Livrable_1.Player;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class show_all_jests {

	private JFrame frame;
	private JLabel lblTheWinnerIs;
	private JButton btnJestOfPlayer;
	private JButton btnJestOfPlayer_1;
	private JButton btnJestOfPlayer_2;
	private JButton btnJestOfPlayer_3;
	private boolean for_trophie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show_all_jests window = new show_all_jests();
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
	public show_all_jests() {
		initialize();
	}
	
	public void set_for_trophie(boolean a) {
	        for_trophie=a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 594, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTheWinnerIs = new JLabel("The WINNER is :");
		lblTheWinnerIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheWinnerIs.setBackground(Color.BLACK);
		lblTheWinnerIs.setForeground(Color.BLACK);
		lblTheWinnerIs.setBounds(36, 32, 289, 20);
		frame.getContentPane().add(lblTheWinnerIs);
		lblTheWinnerIs.setVisible(false);
		
		btnJestOfPlayer = new JButton("Jest of player 1");
		btnJestOfPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				Player p=null;
				p=players.getFirst();
				Jest_of_one_person jop=new Jest_of_one_person();
				jop.set_player(p);
				int i=1;
				for(Iterator<Card> itc=p.returnjest().iterator();itc.hasNext();) {
					jop.addtoJest(i, itc.next());
					i++;
				}
				jop.calcule_jest(p);
				
			    	  if(p.returnjest().size()>5 && for_trophie) {
			    		  Card tro1=new Card();
			    		  tro1=p.returnjest().return_last();
			    		  jop.ifTrophie(tro1);
			    	  }
			      
				jop.setVisible(true);
			}
		});
		btnJestOfPlayer.setBounds(36, 118, 158, 21);
		frame.getContentPane().add(btnJestOfPlayer);
		
		btnJestOfPlayer_1 = new JButton("Jest of player 2");
		btnJestOfPlayer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				Player p=null;
				p=players.get(1);
				Jest_of_one_person jop=new Jest_of_one_person();
				jop.set_player(p);
				int i=1;
				for(Iterator<Card> itc=p.returnjest().iterator();itc.hasNext();) {
					jop.addtoJest(i, itc.next());
					i++;
				}
				jop.calcule_jest(p);
				 if(p.returnjest().size()>5 && for_trophie ) {
		    		  Card tro1=new Card();
		    		  tro1=p.returnjest().return_last();
		    		  jop.ifTrophie(tro1);
		    	  }
				jop.setVisible(true);
				
			}
		});
		btnJestOfPlayer_1.setBounds(204, 118, 158, 21);
		frame.getContentPane().add(btnJestOfPlayer_1);
		
		btnJestOfPlayer_2 = new JButton("Jest of player 3");
		btnJestOfPlayer_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				Player p=null;
				p=players.get(2);
				Jest_of_one_person jop=new Jest_of_one_person();
				jop.set_player(p);
				int i=1;
				for(Iterator<Card> itc=p.returnjest().iterator();itc.hasNext();) {
					jop.addtoJest(i, itc.next());
					i++;
				}
				jop.calcule_jest(p);
				 if(p.returnjest().size()>5 && for_trophie ) {
		    		  Card tro1=new Card();
		    		  tro1=p.returnjest().return_last();
		    		  jop.ifTrophie(tro1);
		    	  }
				jop.setVisible(true);
			}
		});
		btnJestOfPlayer_2.setBounds(380, 118, 172, 21);
		frame.getContentPane().add(btnJestOfPlayer_2);
		
		btnJestOfPlayer_3 = new JButton("Jest of player 4");
		btnJestOfPlayer_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GM gm=GM.getinstance();
				LinkedList<Player> players=gm.return_Players();
				Player p=null;
				p=players.getLast();
				Jest_of_one_person jop=new Jest_of_one_person();
				jop.set_player(p);
				int i=1;
				for(Iterator<Card> itc=p.returnjest().iterator();itc.hasNext();) {
					jop.addtoJest(i, itc.next());
					i++;
				}
				jop.calcule_jest(p);
				 if(p.returnjest().size()>5 && for_trophie ) {
		    		  Card tro1=new Card();
		    		  tro1=p.returnjest().return_last();
		    		  jop.ifTrophie(tro1);
		    	  }
				jop.setVisible(true);
			}
		});
		btnJestOfPlayer_3.setBounds(204, 172, 158, 21);
		frame.getContentPane().add(btnJestOfPlayer_3);
	}
	
	public void set_players() {
		GM gm=GM.getinstance();
		if(gm.return_Players().size()==3) {
			btnJestOfPlayer.setText("Jest of player "+Three_p_s_next.player1_name);
		    btnJestOfPlayer_1.setText("Jest of player "+Three_p_s_next.player2_name);
		    btnJestOfPlayer_2.setText("Jest of player "+Three_p_s_next.player3_name);
		    btnJestOfPlayer_3.setVisible(false);
		}else {
			btnJestOfPlayer.setText("Jest of player "+Four_p_s_next.player1_name);
		    btnJestOfPlayer_1.setText("Jest of player "+Four_p_s_next.player2_name);
		    btnJestOfPlayer_2.setText("Jest of player "+Four_p_s_next.player3_name);
		    btnJestOfPlayer_3.setText("Jest of player "+Four_p_s_next.player4_name);
		}
		
		
	}
	
	public void setwinner(Player a) {
		lblTheWinnerIs.setText("The WINNER is :"+a.get_nom());
		lblTheWinnerIs.setVisible(true);
	}
	
	public void setVisible(boolean a) {
		frame.setVisible(a);
	}
}
