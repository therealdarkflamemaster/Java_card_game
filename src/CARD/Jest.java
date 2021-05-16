package CARD;
import java.util.*;

public class Jest {
     public final int numMax=5;
     private LinkedList<Card> jest;
     
     public Jest() {
    	 jest=new LinkedList<Card> ();
     }
     
     public void addtoJest(Card c) {
    	 jest.add(c);
     }
     
     public void afficher() {
    	 int i=1;
    	 for(Iterator<Card> it=this.jest.iterator();it.hasNext();) {
    		Card c=it.next();
    		c.changeCondition("up");
     		System.out.println("Your Jest is : "+ "card"+i+": "+c.toString());
     		i++;
     	}
     }
     
     public Card return_last() {
    	 return jest.getLast();
     }
     public int size() {
    	 return jest.size();
     }
     
     public Iterator<Card> iterator(){
    	 return this.jest.iterator();
     }
     
     //visitor
     public int accept(VisitordeJest vdj) {
    	 int a;
    	 a=vdj.visit(this);
    	 return a;
     }
     
     public int num_of_four() {
    	 int i=0;
 		for(Iterator<Card> it=this.iterator();it.hasNext();) {
 			if(it.next().getValue()==4) {
 				i++;
 			}
 		}
 		return i;
 	 }
     
     public int num_of_three() {
    	 int i=0;
 		for(Iterator<Card> it=this.iterator();it.hasNext();) {
 			if(it.next().getValue()==3) {
 				i++;
 			}
 		}
 		return i;
 	 }

     public int num_of_two() {
    	 int i=0;
 		for(Iterator<Card> it=this.iterator();it.hasNext();) {
 			if(it.next().getValue()==2) {
 				i++;
 			}
 		}
 		return i;
 	 }
     
     public Jest add_if(Card c) {
    	 Jest jest_if=new Jest();
    	this.jest.add(c);
    	 jest_if=this;
    	 this.jest.remove(c);
    	 return jest_if;
     }
     
     public int calcule_score_if_card_in(Card c) {
    	 int score=0;
    	 Jest jest_if=this.add_if(c);
    	 VisitordeJest vdj=new VisitordeJest();
    	 score=jest_if.accept(vdj);
    	 return score;
    	 
     }
     
    
}