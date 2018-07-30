package ex2_card_deck;

class TryDeal {
  public static void main(String[] args) {
    CardDeck deck = new CardDeck();
    deck.shuffle();

    Hand myHand = deck.dealHand(5).sort();
    Hand yourHand = deck.dealHand(5).sort();
    System.out.println("\nMy hand is:\n" + myHand);
    System.out.println("\nYour hand is:\n" + yourHand);
  }
}
