package Controleur;

import Livrable_1.GM;

public class Pmake_offer {
	private GM gm=GM.getinstance();
	
	public void make_offer_realp() {
		gm.set_num(1, 3);
		gm.pmake_offer();
	}

}
