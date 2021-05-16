package Controleur;

import javax.swing.*;

import Livrable_1.ModeleFirstControler;
import Vue.Three_players_start;
import Vue.enter_mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First_controle {
	
	public First_controle(enter_mode frame,JButton btnPlayersMode) {
		btnPlayersMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "you have choose the three persons mode");
				Three_players_start tps=new Three_players_start();
				//frame.dispose();
				//frame.setVisible(false);
				
				enter_mode em=enter_mode.getinstance();
				em.set_num_p(3);
				tps.setVisible(true);
				
				
				
				
				
			}
		});
	}

}
