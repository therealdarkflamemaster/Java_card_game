
package  Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.Four_p_s_next;
import Controleur.Three_p_s_next;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Four_players_start extends JFrame {
		
    private Four_players_start four_players_start;
	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNext;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel lblEnterTheName;
	private JLabel lblEnterTheName_1;
	private JLabel lblEnterTheName_2;
	private JLabel lblEnterTheName_3;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Four_players_start frame = new Four_players_start();
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
	public Four_players_start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheNumber = new JLabel("Enter the number of the real player :");
		lblEnterTheNumber.setBounds(63, 38, 239, 13);
		contentPane.add(lblEnterTheNumber);
		
		lblEnterTheName = new JLabel("Enter the name of the real player 1");
		lblEnterTheName.setBounds(63, 116, 272, 13);
		contentPane.add(lblEnterTheName);
		lblEnterTheName.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 113, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		lblEnterTheName_1 = new JLabel("Enter the name of the real player 2");
		lblEnterTheName_1.setBounds(63, 139, 239, 13);
		contentPane.add(lblEnterTheName_1);
		lblEnterTheName_1.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(277, 136, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		lblEnterTheName_2 = new JLabel("Enter the name of the real player 3");
		lblEnterTheName_2.setBounds(63, 162, 239, 13);
		contentPane.add(lblEnterTheName_2);
		lblEnterTheName_2.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(277, 159, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		lblEnterTheName_3 = new JLabel("Enter the name of the real player 4");
		lblEnterTheName_3.setBounds(63, 188, 239, 13);
		contentPane.add(lblEnterTheName_3);
		lblEnterTheName_3.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(277, 185, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		JLabel lblChooseTheLevel = new JLabel("Choose the level of the Computer");
		lblChooseTheLevel.setBounds(63, 73, 239, 13);
		contentPane.add(lblChooseTheLevel);
		
		 comboBox = new JComboBox();
		
		comboBox.addItem("--please choose--");
		comboBox.addItem(" easy");
		comboBox.addItem(" normal");
		comboBox.addItem(" diffcult");
		comboBox.setBounds(277, 69, 96, 21);
		contentPane.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int num_real=comboBox_1.getSelectedIndex();
		 		switch(num_real) {
		 		case 1:
		 			lblEnterTheName.setVisible(true);
		 			textField_1.setVisible(true);
		 			break;
		 		case 2:
		 			lblEnterTheName.setVisible(true);
		 			textField_1.setVisible(true);
		 			lblEnterTheName_1.setVisible(true);
		 			textField.setVisible(true);
		 			break;
		 		case 3:
		 			lblEnterTheName.setVisible(true);
		 			textField_1.setVisible(true);
		 			lblEnterTheName_1.setVisible(true);
		 			textField.setVisible(true);
		 			lblEnterTheName_2.setVisible(true);
		 			textField_2.setVisible(true);
		 			break;
		 		case 4:
		 			lblEnterTheName.setVisible(true);
		 			textField_1.setVisible(true);
		 			lblEnterTheName_1.setVisible(true);
		 			textField.setVisible(true);
		 			lblEnterTheName_2.setVisible(true);
		 			textField_2.setVisible(true);
		 			lblEnterTheName_3.setVisible(true);
		 			textField_3.setVisible(true);
		 			break;
		 		}
		 	}
		 });
		comboBox_1.addItem("--please choose--");
		comboBox_1.addItem(" 1 player");
		comboBox_1.addItem(" 2 player");
		comboBox_1.addItem(" 3 player");
		comboBox_1.addItem(" 4 player");
		
		
		
		comboBox_1.setBounds(277, 34, 96, 21);
		contentPane.add(comboBox_1);
		
		JButton btnNext = new JButton("NEXT");
		
		new Four_p_s_next(this,comboBox, comboBox_1,btnNext,textField,textField_1,textField_2,textField_3);
		
		btnNext.setBounds(341, 232, 85, 21);
		contentPane.add(btnNext);
		
		
	}
}
