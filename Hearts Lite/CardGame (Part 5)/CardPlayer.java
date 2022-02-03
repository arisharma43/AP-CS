import java.util.*;
import java.util.Random;
public class CardPlayer extends Player{
  private ArrayList<Card> hand = new ArrayList<Card>();
  private ArrayList<Card> takenCards = new ArrayList<Card>(); 
  

  public CardPlayer(String name, int score, ArrayList<Card> h){
    super(name, score);
    hand.addAll(h);
  }

  

  public void setHand(ArrayList<Card> c){
    hand.clear();
    for(Card n: c){
      this.hand.add(n);
    }
    //this.hand = c;
  }

  public ArrayList<Card> getHand(){
    return hand;
  }
  
  public void setTakenCards(ArrayList<Card> c){
    takenCards.clear();
    this.takenCards = c;
  }
  
  public ArrayList<Card> getTakenCards(){
    return takenCards;
  }

  public void addCard (Card a){
    
    hand.add(a);
  }

  public Card playCard (int i){
    Card c = new Card();
    //System.out.println(hand);
    c = hand.get(i);
    hand.remove(i);
    return c;
  }

  public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
    //System.out.println(hand);
    Card twoClubs = new Card("2","clubs",2);
    if (game.isEmpty()&&hand.contains(twoClubs)){
      //game.add(twoClubs);
      //round.add(twoClubs);
      return playCard(hand.indexOf(twoClubs));
    }
    else if (round.isEmpty()){
       int q = (int)(Math.random()*hand.size());
       //game.add(hand.get(q));
       //round.add(hand.get(q));
       return playCard(q);
    }
    else{
      ArrayList<Card> a = new ArrayList<Card>();
      for (int i=0; i<hand.size();i++){
        if (hand.get(i).getSuit().equals(round.get(0).getSuit())){
          a.add(hand.get(i));
        }
      }
        if (!a.isEmpty()){
          int k = (int) (Math.random() * a.size());
          return playCard(hand.indexOf(a.get(k)));
        }
      else if (!round.get(0).getSuit().equals("hearts")){
        for (int i=0; i<hand.size();i++){
          if (hand.get(i).getSuit().equals("hearts")){
            a.add(hand.get(i));
          }
        }
      }
        if (!a.isEmpty()) {
          int k = (int) (Math.random() * a.size());
          return playCard(hand.indexOf(a.get(k)));
        }
        else{
          int k = (int) (Math.random() * hand.size());
          return playCard(k);
        }
      }
  }
  public String toString(){
    Collections.sort(hand);
    return getName() + "(" + getScore() + ")" + hand;
  }
}