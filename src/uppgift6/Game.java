package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Game {
	
	private GameListener gameListener;
	private Dealer dealer;
	
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		
		
	}
	

	
	public void dealCards(){
		
		dealer.dealCards();
		
	}
	
	public int checkScore(ArrayList<Card> cards){
		int score = 0;
		for(Card card : cards){
			score += card.getRank();
		}
		return score;
	}
	
	

}
