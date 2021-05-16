package Livrable_1;

import Vue.Four_players_start;
import Vue.Three_players_start;
import Vue.enter_mode;

public class FristControleObserver implements Observer{
	
	public void update(Object arg) {
		if(arg instanceof Integer) {
			if((int)arg==3) {
				Three_players_start tps=new Three_players_start();
				enter_mode em=enter_mode.getinstance();
				em.set_num_p(3);
				tps.setVisible(true);
			}else if((int)arg==4){
				Four_players_start fps=new Four_players_start();
				enter_mode em=enter_mode.getinstance();
				em.set_num_p(4);
				fps.setVisible(true);
		    }
		}
}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}