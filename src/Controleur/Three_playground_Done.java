package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Three_playground_Done {
	private int choose_num;
	
	public Three_playground_Done(JFrame frame,JButton btnDone,JComboBox comboBox ) {
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose_num=comboBox.getSelectedIndex()-1;
				
				//////////////////////
				////////////////
				//////////
				////
				//
			    //choose_num 怎么传回去？？？？
				//////////
				///////////
				///////////////
				///////////////////
			}
		});
		
	}
	
	
	

}
