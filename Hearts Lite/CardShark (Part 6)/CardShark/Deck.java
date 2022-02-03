import java.util.*;
import java.util.Arrays;
public class Deck{
  public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
  public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
  public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
  private ArrayList<Card> deck;

  public Deck() {
    initializeDeck();
  }

  public String[] getNames(){
    return NAMES;
  }
  
  public String[] getSuits() {
    return SUITS;
  }

  public int[] getRanks(){
    return RANKS;
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }

  public void setDeck(ArrayList<Card> c){
    deck.clear();
    for(Card b:c){
      deck.add(b);
    }
  }

  public ArrayList<Card> initializeDeck() {
    deck = new ArrayList<Card>();
    int i = 2;
    for (String suit : SUITS) {
      for (String names : NAMES){
        //Card c = new Card(names, suit, i);
        deck.add(new Card(names, suit, i));
        i++;
      }
      i = 2;
    }
    return deck;
  }
  
  public Card getCard(int index) {
    return deck.get(index);
  }
  
  public Card dealTopCard(){
    //System.out.println(this);
    
    Card c = getCard(0);
    deck.remove(0);
    return c;
  }
  
  public void shuffle2(){
    int k = (int) (Math.random() * 9 + 2);
    Card c1 = new Card();
    for (int j = 0; j < 20; j++){
      for (int i = 0; i < k; i++){
        c1 = getCard(i);
        deck.remove(i);
        deck.add((int)(Math.random() * 52), c1);
      }
    }
  }

  public void shuffle() {
    
    Collections.shuffle(deck);
  }

  public String toString(){
    if (deck.size() == 0) {
      return "No Cards in the deck!";
    } 
    else {
      String str = "";
      for (int i = 0; i < deck.size(); i++) {
        str += deck.get(i).toString();
      }
      return str;
    }
  }

  
}
