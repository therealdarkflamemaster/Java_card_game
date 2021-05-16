package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.First_controle;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//singleton
public class enter_mode extends JFrame {

	private JPanel contentPane;
	private static enter_mode em=null;
	private JButton btnPlayersMode;
	private JButton btnPlayersMode_1;
	private int num_p;
	

	/**
	 * Launch the application.
	 */
	public static enter_mode getinstance() {
		if(em==null) {
			em=new enter_mode();
		}
			return em;
	}
	
	public int get_num_p() {
		return num_p;
	}
	public void set_num_p(int a) {
		this.num_p=a;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enter_mode frame = new enter_mode();
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
	private enter_mode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose mode");
		lblNewLabel.setBounds(10, 64, 87, 28);
		contentPane.add(lblNewLabel);
		
		btnPlayersMode = new JButton("3 players mode");
		
		new First_controle(em,btnPlayersMode);//controler dehors
		
		
		btnPlayersMode.setBounds(56, 102, 161, 37);
		contentPane.add(btnPlayersMode);
		
		btnPlayersMode_1 = new JButton("4 players mode");
		btnPlayersMode_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(em, "you have choose the four persons mode");
				Four_players_start fps=new Four_players_start();
				//frame.dispose();
				//frame.setVisible(false);
				enter_mode em=enter_mode.getinstance();
				em.set_num_p(4);
				fps.setVisible(true);
				
			}
		});
		btnPlayersMode_1.setBounds(56, 161, 161, 37);
		contentPane.add(btnPlayersMode_1);
	}
	
	
}
