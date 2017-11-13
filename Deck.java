import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;  //宣告 ArrayList<Card> cards 
	public ArrayList<Card> usedCards = new ArrayList<Card>();  //宣告並實體化
	public int nUsed;  //宣告nUsed instance field

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int n = 1; n <= nDeck; n++) {  			//幾副牌
			for (int s = 1; s <= 4; s++) { 		 		//花色
				for (int r = 1; r <= 13; r++) {  		//數字
					if (s == 1) {			//花色為Club
						Card card = new Card(Card.Suit.Club, r);
						cards.add(card);
					}
					if (s == 2) {			//花色為Diamond
						Card card = new Card(Card.Suit.Diamond, r);
						cards.add(card);
					}
					if (s == 3) {			//花色為Heart
						Card card = new Card(Card.Suit.Heart, r);
						cards.add(card);
					}
					if (s == 4) {			//花色為Spade
						Card card = new Card(Card.Suit.Spade, r);
						cards.add(card);
					}
				}
			}
		}
		shuffle();
	}

	public Card getOneCard() {
		if (cards.size()==0)
		{
			shuffle();
		}
		Card drawer = cards.get(0);
		cards.remove(0);
		usedCards.add(drawer);
		nUsed += 1;
		return drawer;
	}

	public void shuffle() {		//洗牌
		for (int x = 0; x < nUsed; x++)
			cards.add(usedCards.get(x));
		for (int x = 0; x < 1000; x++) {
			Random rnd = new Random();
			int z = rnd.nextInt(cards.size());
			Card temp = cards.get(z);
			cards.get(z);
			cards.remove(cards.get(z));		//移除取出的牌
			cards.add(temp);
		}
		nUsed = 0;
		usedCards.clear();
	}

	public void printDeck() {
		for (int n = 0; n < cards.size(); n++) {
			cards.get(n).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}
