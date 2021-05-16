package Vue;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;

import CARD.Card;
import CARD.VisitordeJest;
import Controleur.Set_card;
import Livrable_1.GM;
import Livrable_1.Player;

public class Jest_of_one_person {

	private JFrame frame;
	private JLabel lblTheJestOf;
	private JLabel jest1;
	private JLabel jest2;
	private JLabel jest3;
	private JLabel jest4;
	private JLabel jest5;
	private JLabel lblCardTrophie;
	private JLabel lblTheScoreOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jest_of_one_person window = new Jest_of_one_person();
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
	public Jest_of_one_person() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 805, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTheJestOf = new JLabel("The jest of player :");
		lblTheJestOf.setBounds(10, 20, 220, 13);
		frame.getContentPane().add(lblTheJestOf);
		
		jest1 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		jest1.setBounds(20, 43, 100, 145);
		frame.getContentPane().add(jest1);
		
		jest2 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		jest2.setBounds(130, 43, 100, 145);
		frame.getContentPane().add(jest2);
		
		jest3 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		jest3.setBounds(240, 43, 100, 145);
		frame.getContentPane().add(jest3);
		
		jest4 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		jest4.setBounds(350, 43, 100, 145);
		frame.getContentPane().add(jest4);
		
		jest5 = new JLabel(new ImageIcon("image_de_projet/dos.png"));
		
		jest5.setBounds(460, 43, 100, 145);
		frame.getContentPane().add(jest5);
		
		lblTheScoreOf = new JLabel("The score of you jest :");
		lblTheScoreOf.setBounds(392, 217, 228, 13);
		frame.getContentPane().add(lblTheScoreOf);
		
		lblCardTrophie = new JLabel("Card trophie");
		lblCardTrophie.setBounds(607, 119, 100, 145);
		lblCardTrophie.setVisible(false);
		frame.getContentPane().add(lblCardTrophie);
	}
	
	  public void addtoJest(int i,Card c) {
		  Set_card set_card=new Set_card();
		  ImageIcon img=new ImageIcon();
		  img=set_card.set_card(c);
		  switch(i) {
		  case 1:
			  jest1.setIcon(img);
			  break;
		  case 2:
			  jest2.setIcon(img);
			  break;
		  case 3:
			  jest3.setIcon(img);
			  break;
		  case 4:
			  jest4.setIcon(img);
			  break;
		  case 5:
			  jest5.setIcon(img);
			  break;
		  }
	  }
	  
	  public void ifTrophie(Card trophie) {
		  Set_card set_card=new Set_card();
		  ImageIcon img=new ImageIcon();
		  img=set_card.set_card(trophie);
		  this.lblCardTrophie.setIcon(img);
		  
	  }
	  
	  public void set_visible_trophie(boolean a) {
		  if(a) {
			  lblCardTrophie.setVisible(true);
		  }
		  
	  }
	  public void set_player(Player p) {
		  lblTheJestOf.setText("The jest of player :"+p.get_nom());
	  }
	  
	  
	  public void calcule_jest(Player p1) {
		  int[] jest_scores;
	      GM gm=GM.getinstance();
	      int num_p=gm.getPlayerNumber();
	      if(num_p==3) {
	    	  jest_scores=new int[3];
		      
		      VisitordeJest vdj=new VisitordeJest();
		      LinkedList<Player> players=gm.return_Players();
		      int i=0;
		      for(Iterator<Player> it=players.iterator();it.hasNext();) {
		    	  Player p=it.next();
		    	  jest_scores[i]=p.returnjest().accept(vdj);
		    	  p.setJestscore(jest_scores[i]);
		    	  i++;
		      }
			  int j=0;
			  int fina=0;
			  for(Iterator<Player> it=players.iterator();it.hasNext();) {
		    	  Player p=it.next();
		    	  if(p.get_nom().equals(p1.get_nom())) {
		    		  fina=j;
		    	  }
		    	  j++;
			  }
			  String a=new String("The score of you jest "+jest_scores[fina]);
			  
		      lblTheScoreOf.setText(a);
		      lblTheScoreOf.setVisible(true);
	      }else {
	    	  jest_scores=new int[4];
		      
		      VisitordeJest vdj=new VisitordeJest();
		      LinkedList<Player> players=gm.return_Players();
		      int i=0;
		      for(Iterator<Player> it=players.iterator();it.hasNext();) {
		    	  Player p=it.next();
		    	  jest_scores[i]=p.returnjest().accept(vdj);
		    	  p.setJestscore(jest_scores[i]);
		    	  i++;
		      }
			  int j=0;
			  int fina=0;
			  for(Iterator<Player> it=players.iterator();it.hasNext();) {
		    	  Player p=it.next();
		    	  if(p.get_nom().equals(p1.get_nom())) {
		    		  fina=j;
		    	  }
		    	  j++;
			  }
			  String a=new String("The score of you jest "+jest_scores[fina]);
			  
		      lblTheScoreOf.setText(a);
		      lblTheScoreOf.setVisible(true);
	      }
	    	  
	  }
	  
	  public void setVisible(boolean a) {
		  frame.setVisible(a);
	  }
	  

	
}
