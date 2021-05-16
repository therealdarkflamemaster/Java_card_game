package Livrable_1;

import java.util.*;
import Livrable_1.Observable;
import Vue.Four_players_start;
import Vue.Three_players_start;
import Vue.enter_mode;
//modele
public class ModeleFirstControler implements Observable, Runnable{
	public boolean change;
	private List<Observer> list=new ArrayList<Observer> ();
	private int num_p;
	
	public void run() {
		System.out.println("Please input the numbers of players");
		Scanner s=new Scanner(System.in);
		num_p=s.nextInt();
		Observer modeObserver=new FristControleObserver();
		this.addObserver(modeObserver);
		this.setChanged(true,num_p);
		
		if(num_p==3) {
			System.out.println("you have chosen the 3_mode");
		}else if(num_p==4){
			System.out.println("you have chosen the 4_mode");
		}else {
			System.out.println("Please reinput the numbers of players");
			run();
		}
		}
	

	public int get_nump() {
		return num_p;
	}
	protected void setChanged(boolean b, int num_p) {
		// TODO Auto-generated method stub
		change=b;
		this.notifyObservers(num_p);
	}
	
	public boolean hasChanged() {
		return change;
	}
	
	


	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		this.list.add(o);
	}


	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		for(Iterator<Observer> it=list.iterator();it.hasNext();) {
			it.next().update(arg);
		}
	}
	
	
	
	

}
