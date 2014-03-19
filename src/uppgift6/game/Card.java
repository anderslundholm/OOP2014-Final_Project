package uppgift6.game;

import java.awt.Image;

/**
 * @author Anders Lundholm
 *
 */
public class Card {

	private int rank;
	private Suits suit;
	private int index;
	private String rankString;
	private Image cardImage;
	
	/**
	 * The image icons are arranged with all cards of one 
	 * suit starting from 1 (Ace) up to 13 (King), 
	 * then the next suit and so on so every 13:th 
	 * card is a new suit.
	 * @param index is the index of the card in the deck.
	 */
	public Card(int index){
		this.index = index;
		rank = index % 13 +1;
		suit = Suits.values()[index/13];
	}
	
	public enum Suits { Hearts, Spades, Diamonds, Clubs }
	
	@Override
	public String toString(){
		switch(rank){
		case 1:
			rankString = "Ace";
			break;
		case 11: 
			rankString = "Jack";
			break;
		case 12:
			rankString = "Queen";
			break;
		case 13:
			rankString = "King";
			break;
		default:
			rankString = Integer.toString(rank);
		}
		return rankString + " of " + suit;
	}
	
	public int getRank(){ 
		if(rank > 10){
			rank = 10;
		}
		return rank; 
	}
	
	public int getIndex(){ return index; }
	public Suits getSuit(){ return suit; }
	public Image getImage(){ return cardImage; }
	public int getImageHeight() { return cardImage.getHeight(null);} 
	public int getImageWidth() { return cardImage.getWidth(null);}
	
}