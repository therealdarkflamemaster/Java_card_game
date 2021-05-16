package CARD;
/**
 * <h1>Classe Carte</h1>
 */
public  class Card {
	private Condition_card condition;//on & down
	private TypeofCard value;
	private Color color;
	
	public Card (TypeofCard b,Color c) {
		this.condition=Condition_card.Down;
		this.value=b;
		this.color=c;
	}
	
	/**
	 * constructeur de classe abstraite
	 */
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * getteur de condition de carte
	 * @return l'état de la carte : face montrée ou cachée (on or down).
	 */
	public int getCondition() {
		return this.condition.ordinal();
	}
	
	/**
	 * getteur de valeur
	 * @return le nombre associié à la valeur de la carte : Joker : 0, Ace : 1, Two : 2, Three : 3, Four : 4, Reference_card : 5.
	 */
	public int getValue() {
		return this.value.ordinal();
	}
	
	/**
	 * getteur de couleur
	 * @return le nombre associé à la couleur de la carte : Null : 0, Heart : 1,Diamond : 2, Club : 3, Spade : 4
	 */
	public int getColor() {
		return this.color.ordinal();
	}
	
	
	/**
	 * toString d'une carte
	 * @return une chaine de caractère contenant la valeur, la couleur et l'état de la carte.
	 */
	public String toString() {
		if (this.condition == Condition_card.On) {
			return "Card is " + this.value + ", " + this.color + ", face" + this.condition;
		} else {
			return "A face down card.";
		}
	}
	
	/**
	 * setteur de condition
	 * @param a l'état (<b>"On"</b> ou <b>"Down"</b>) dans lequel da carte doit être changé
	 */
	public void changeCondition(String a) {
		if (a == "up") {
			this.condition = Condition_card.On;
		} else if (a == "down") {
			this.condition = Condition_card.Down;
		}
	}
}
