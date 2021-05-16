package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Livrable_1.GM;
import Vue.Three_mode_playingScene;

//singleton
public class Three_p_s_next {
	private static Three_p_s_next tps=null;
	
	public  static String player1_name;
	public  static String player2_name;
	public  static String player3_name;
	private static int num_p=3;
	private static int num_real;
	private static int level_com;
	
	private GM gm;
	
	public static Three_p_s_next getinstance() {
		if(tps == null) {
			tps=new Three_p_s_next();
		}
		return tps;
	}
	
	public int return_level_com() {
		return level_com;
	}
	
	
	
	public Three_p_s_next(JFrame frame,JComboBox comboBox,JComboBox comboBox_1,JButton btnNext,JTextField textField,JTextField textField_1,JTextField textField_2) {
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_real=comboBox_1.getSelectedIndex();// 'i' is the number of the real player
				//System.out.println("there are "+num_real+" players");
				int com_level=comboBox.getSelectedIndex();
				//System.out.println("the easy-1,normal-2,diffcult-3  "+com_level);
				player1_name=textField_1.getText();
				
				if(num_real==1) {					
						player2_name="Computer1";
						player3_name="Computer2";					
				}else if(num_real==2) {					
					    player2_name=textField.getText();
						player3_name="Computer1";					
				}else {
						player2_name=textField.getText();
						player3_name=textField_2.getText();
				}
				
				//System.out.println("the name is "+player1_name);
				Three_mode_playingScene three_mode_ps=Three_mode_playingScene.getinstance();
				if(num_real==0 || com_level==0 || textField_1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "you have to choose all the option,svp");
				}else {
					frame.dispose();
				    three_mode_ps.setVisible(true);
				}
			}
		});
	}
	
	public Three_p_s_next() {
		
	}
	
	public int get_num_real() {
		return num_real;
	}

}
