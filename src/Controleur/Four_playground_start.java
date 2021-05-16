package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Livrable_1.GM;
import Vue.Four_mode_playingScene;


public class Four_playground_start {
	private GM gm=GM.getinstance();
	private int num_real=1;
	private final int num_p=4;
	
	
	// °´Å¥start
		public Four_playground_start(JFrame frame,JButton btnStart,JLabel trophie1,JLabel lblJest) {
			
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame, "now the game starts");
					gm.set_num(1, 4);
					Four_mode_playingScene scene=Four_mode_playingScene.getinstance();
					scene.set_jest();
					scene.set_name();
					gm.reset_game();//ok
					trophie1.setVisible(true);
					lblJest.setVisible(true);
					btnStart.setVisible(false);
					scene.set_button3_visible();
					}

			});

			
		}

}
