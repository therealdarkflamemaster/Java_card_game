package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Rules_vue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Rules_vue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setVisible(true);
		frame.setBounds(100, 340, 400, 300);
		JLabel lblDealCards=new JLabel("1. Deal cards");
		JLabel bb2=new JLabel("In the first round, deal each player 2 cards face-down from the draw deck.");
		JLabel bb3=new JLabel("In later rounds, first collect up the cards not taken from the players¡¯  to the number of players. Shuffle this stack and deal 2 cards to each player.");
		
		lblDealCards.setVerticalAlignment(SwingConstants.TOP);
		lblDealCards.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblDealCards);
		frame.getContentPane().add(bb2);
		bb2.setBounds(10,22,386,13);
		frame.getContentPane().add(bb3);
		bb3.setBounds(10,33,376,21);
		lblDealCards.setBounds(0,10,386,13);
		frame.getContentPane().setLayout(null);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
