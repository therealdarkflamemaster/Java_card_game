package Controleur;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CARD.Card;

public class Set_card {
	public static ImageIcon joker;
	public static ImageIcon carreau_2;
	public static ImageIcon coeur_2;
	public static ImageIcon pic_2;
	public static ImageIcon trefle_2;
	public static ImageIcon carreau_3;
	public static ImageIcon coeur_3;
	public static ImageIcon pic_3;
	public static ImageIcon trefle_3;
	public static ImageIcon carreau_4;
	public static ImageIcon coeur_4;
	public static ImageIcon pic_4;
	public static ImageIcon trefle_4;
	public static ImageIcon carreau_As;
	public static ImageIcon Coeur_As;
	public static ImageIcon pic_As;
	public static ImageIcon trefle_As;
	public static ImageIcon dos;
	
	
	public Set_card() {
		ImageIcon img_joker=new ImageIcon("image_de_projet/Joker.png");
		joker=img_joker;
		
		ImageIcon img_2_carreau=new ImageIcon("image_de_projet/2_carreau.png");
		carreau_2=img_2_carreau;
		
		ImageIcon img_2_coeur=new ImageIcon("image_de_projet/2_coeur.png");
		coeur_2=img_2_coeur;
		
		ImageIcon img_2_pic=new ImageIcon("image_de_projet/2_pic.png");
		pic_2=img_2_pic;
		
		ImageIcon img_2_trefle=new ImageIcon("image_de_projet/2_trefle.png");
		trefle_2=img_2_trefle;
		
		ImageIcon img_3_carreau=new ImageIcon("image_de_projet/3_carreau.png");
		carreau_3=img_3_carreau;
		
		ImageIcon img_3_coeur=new ImageIcon("image_de_projet/3_coeur.png");
		coeur_3=img_3_coeur;
		
		ImageIcon img_3_pic=new ImageIcon("image_de_projet/3_pic.png");
		pic_3=img_3_pic;
		
		ImageIcon img_3_trefle=new ImageIcon("image_de_projet/3_trefle.png");
		trefle_3=img_3_trefle;
		
		ImageIcon img_4_carreau=new ImageIcon("image_de_projet/4_carreau.png");
		carreau_4=img_4_carreau;
		
		ImageIcon img_4_coeur=new ImageIcon("image_de_projet/4_coeur.png");
		coeur_4=img_4_coeur;
		
		ImageIcon img_4_pic=new ImageIcon("image_de_projet/4_pic.png");
		pic_4=img_4_pic;
		
		ImageIcon img_4_trefle=new ImageIcon("image_de_projet/4_trefle.png");
		trefle_4=img_4_trefle;
		
		ImageIcon img_1_carreau=new ImageIcon("image_de_projet/As_carreau.png");
		carreau_As=img_1_carreau;
		
		ImageIcon img_1_coeur=new ImageIcon("image_de_projet/As_Coeur.png");
		Coeur_As=img_1_coeur;
		
		ImageIcon img_1_pic=new ImageIcon("image_de_projet/As_pic.png");
		pic_As=img_1_pic;
		
		ImageIcon img_1_trefle=new ImageIcon("image_de_projet/As_trefle.png");
		trefle_As=img_1_trefle;
		
		ImageIcon img_dos=new ImageIcon("image_de_projet/dos.png");
		dos=img_dos;
		
	}
	public ImageIcon set_card(Card c) {
		
		if(c.getValue()==0 && c.getCondition()==0) {//joker
			return joker;
		}
		else if(c.getValue()==2 && c.getColor()==2 && c.getCondition()==0) {
			return carreau_2;
		}
		else if(c.getValue()==2 && c.getColor()==1 && c.getCondition()==0) {
			return coeur_2;
		}
		else if(c.getValue()==2 && c.getColor()==4 && c.getCondition()==0) {
			return pic_2;
		}
		else if(c.getValue()==2 && c.getColor()==3 && c.getCondition()==0) {
			return trefle_2;
		}
		else if(c.getValue()==3 && c.getColor()==1 && c.getCondition()==0) {
			return coeur_3;
		}
		else if(c.getValue()==3 && c.getColor()==2 && c.getCondition()==0) {
			return carreau_3;
		}
		else if(c.getValue()==3 && c.getColor()==3 && c.getCondition()==0) {
			return trefle_3;
		}
		else if(c.getValue()==3 && c.getColor()==4 && c.getCondition()==0) {
			return pic_3;
		}
		else if(c.getValue()==4 && c.getColor()==1 && c.getCondition()==0) {
			return coeur_4;
		}
		else if(c.getValue()==4 && c.getColor()==2 && c.getCondition()==0) {
			return carreau_4;
		}
		else if(c.getValue()==4 && c.getColor()==3 && c.getCondition()==0) {
			return trefle_4;
		}
		else if(c.getValue()==4 && c.getColor()==4 && c.getCondition()==0) {
			return pic_4;
		}
		else if(c.getValue()==1 && c.getColor()==1 && c.getCondition()==0) {
			return Coeur_As;
		}
		else if(c.getValue()==1 && c.getColor()==2 && c.getCondition()==0) {
			return carreau_As;
		}
		else if(c.getValue()==1 && c.getColor()==3 && c.getCondition()==0) {
			return trefle_As;
		}
		else if(c.getValue()==1 && c.getColor()==4 && c.getCondition()==0) {
			return pic_As;
		}
		else {//cad, le revers de la carte
			return dos;
		}
	}

}
