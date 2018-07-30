package ex2_card_deck;
// Chapter 14 Exercise 2 Answer

/*
 Write a program to store a deck of 52 cards in a linked list in random sequence
 using a Random class object. You can represent a card as a two-character string ?
 "1C" for the ace of clubs, "JD" for the jack of diamonds, and so on.
 Output the cards from the linked list as four hands of 13 cards.
 */

 /*
  I chose to store the unshuffled deck in a Vector<>, then transfer the cards
  selected at random into a linked list.
  */
import java.util.Vector;
import java.util.LinkedList;
import java.util.Random;
import java.util.ListIterator;

public class DealCards {
  public static void main(String[] args) {
    String[] suits = {"C", "D", "H", "S"};
    String[] cardValues = { "1","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    int cardsInDeck = 52;
    Vector<String> deck = new Vector<>(cardsInDeck);
    LinkedList<String> shuffledDeck = new LinkedList<>();
    Random chooser = new Random();                                     // Card chooser

    // Load the deck
    for(String suit : suits) {
      for(String cardValue : cardValues) {
        deck.add(cardValue + suit);
      }
  }

    // Select cards at random from the deck to transfer to shuffled deck
    int selection = 0;                                                 // Selected card index
    for(int i = 0 ; i < cardsInDeck ; ++i) {
      selection = chooser.nextInt(deck.size());
      shuffledDeck.add(deck.remove(selection));
    }

    // Deal the cards from the shuffled deck into four hands
    StringBuffer[] hands = { new StringBuffer("Hand 1:"), new StringBuffer("Hand 2:"),
                             new StringBuffer("Hand 3:"), new StringBuffer("Hand 4:")};
    ListIterator<String> cards = shuffledDeck.listIterator();

    while(cards.hasNext()) {
      for(StringBuffer hand : hands) {
        hand.append(' ').append(cards.next());
      }
    }

    // Display the hands
    for(StringBuffer hand : hands) {
      System.out.println(hand);
    }
  }
}
