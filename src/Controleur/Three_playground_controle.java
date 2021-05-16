package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CARD.Card;
import CARD.Draw_deck;
import CARD.Trophies;
import Livrable_1.Com_easy;
import Livrable_1.Com_impossible;
import Livrable_1.Com_normal;
import Livrable_1.Computer_player;
import Livrable_1.GM;
import Livrable_1.Player;
import Livrable_1.Player_real;
import Vue.Three_mode_playingScene;

public class Three_playground_controle {
	private GM gm=GM.getinstance();
	private int num_real=1;
	private final int num_p=3;
	
	// 按钮start
	public Three_playground_controle(JFrame frame,JButton btnStart,JLabel trophie1,JLabel trophie2,JLabel lblJest,JLabel handcard_1_1,JLabel handcard_1_2) {
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "now the game starts");
				gm.set_num(1, 3);
				Three_mode_playingScene scene=Three_mode_playingScene.getinstance();
				scene.set_jest();
				scene.set_name();
				gm.reset_game();
				trophie1.setVisible(true);
				trophie2.setVisible(true);
				lblJest.setVisible(true);
				btnStart.setVisible(false);
				
				scene.set_button3_visible();
				
				
				//最后要改成gm.first_round(round_number)，再加上循环
				}

		});

		
	}

}
