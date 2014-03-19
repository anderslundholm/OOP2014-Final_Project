package uppgift6;

import java.util.ArrayList;

/**
 * @author Anders Lundholm
 *
 */
public class Game {
	
	private GameListener gameListener;
	private Dealer dealer;
	private int dealerScore;
	private int playerScore;
	private boolean stay = false;
	
	public Game(GameListener gameListener){
		
		this.gameListener = gameListener;
		
		dealer = new Dealer(gameListener);
		
		gameListener.gameStart();
		
		dealDealerCards();
		
		dealPlayerCards();
		dealPlayerCards();
	}
	

	
	public void dealPlayerCards(){	
		ArrayList<Card> playerCards = dealer.getPlayerCards();
		dealer.dealCards(1);
		playerScore = checkScore(playerCards);
		gameListener.setLabel("Player has: " + playerScore);
	}
	
	public void dealDealerCards(){		
		dealer.dealCards(0);
	}
	
	public void dealerPlay() {
		stay = true;
		ArrayList<Card> dealerCards = dealer.getDealerCards();
		dealerScore = checkScore(dealerCards);
//		dealDealerCards();
		
		if(dealerScore < 17){	
//			dealerCards = dealer.getDealerCards();
			System.out.println("Dealer has: " + dealerScore);
			gameListener.setLabel("Dealer has: " + dealerScore);
			dealDealerCards();
			dealerPlay();
		} else if(dealerScore > 21){
			System.out.println("Dealer bust! You Win!");
			gameListener.setLabel("Dealer bust! You Win!");
		} else {
			if(dealerCards.size() == 2 && dealerScore == 21){
				System.out.println("Dealer has BlackJack! You Loose!");
				gameListener.setLabel("Dealer has BlackJack! You Loose!");
			} else {
				decideWinner();
			}
		}
	}	

	private int checkScore(ArrayList<Card> cards){
		
		int score = 0;
		boolean ace = false;
		for(Card c : cards){
			
			if(c.getRank() == 1){
				ace = true;
				
				if(score <= 10){
					score += 11;
				} else {
					score += 1;
					ace = false;
				}
			} else if(ace == true && score > 21-c.getRank()) {
				score += c.getRank() - 10;
				ace = false;
			} else {
				score += c.getRank();
			}
		}
		return score;
	}	
	
	private void decideWinner(){
		System.out.println("Dealer has: " + dealerScore);
		System.out.println("Player has: " + playerScore);
		
		if(playerScore > dealerScore){
			System.out.println("Player wins!");
			gameListener.setLabel("Dealer has: " + dealerScore + ", Player has: " + playerScore + ", Player wins!");
		} else {
			System.out.println("Dealer wins!");
			gameListener.setLabel("Dealer has: " + dealerScore + ", Player has: " + playerScore + ", Dealer wins!");
		}
	}
	
	public boolean getStay(){ return stay; }
	
}
