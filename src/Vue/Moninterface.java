package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JOptionPane;

import Livrable_1.ModeleFirstControler;

public class Moninterface {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moninterface window = new Moninterface();
					System.out.println("Now the game starts");
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
	public Moninterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon jest_img=new ImageIcon("image_de_projet/little_logo.jpg");
		JLabel label=new JLabel(jest_img);
		frame.getContentPane().add(label);
		label.setBounds(122, 10, jest_img.getIconWidth(), jest_img.getIconHeight());
		JButton btnStartGame = new JButton("Start game");
		btnStartGame.setIcon(null);
		
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "be sure you have read the rules");
				// on peut entrer l'interface suivante
				
				enter_mode em=enter_mode.getinstance();
				frame.dispose();
				//frame.setVisible(false);
				em.setVisible(true);
				System.out.println("-----------------------------------------------------------------------------------------------");
				
				
				ModeleFirstControler mfc=new ModeleFirstControler();
				new Thread(mfc).start();
			}
		});
		btnStartGame.setBounds(160, 116, 117, 21);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Rules_vue();
				
			}
		});
		btnRules.setBounds(176, 145, 85, 21);
		frame.getContentPane().add(btnRules);
	}
}
