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

  // public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previous){
  //   Card tempcard = new Card("2","clubs",2);
  //   boolean hasSuit=false;
  //   int randomcard=(int)(Math.random()*hand.size());
  //   if(hand.contains(tempcard)){
  //     //System.out.println("debug "+hand.indexOf(tempcard));
  //     return playCard(hand.indexOf(tempcard));
  //   }
  //   if(round.size()==0){
  //     //System.out.println("DEBUG 1st player");
  //     return playCard((int)(Math.random()*hand.size()));
  //   }

  //   for(int i=0;i<hand.size();i++){
  //     //System.out.println("DEBUG get lead suit: " + round.get(0).getSuit());
  //     //System.out.println("DEBUG get suit hand: " + hand.get(i).getSuit());
  //     if(round.get(0).getSuit().equals(hand.get(i).getSuit() )){
  //       hasSuit=true;

  //     }
  //   }
  //   if(hasSuit==true){
  //     //System.out.println("DEBUG Select Random Suited Card: randomcard index " + randomcard);

  //     while(!hand.get(randomcard).getSuit().equals(round.get(0).getSuit())){
  //       randomcard=(int)(Math.random()*hand.size());
  //     }
  //     return playCard(randomcard);
  //   }

  //   // Select Random Heart
  //   for(int i=0;i<hand.size();i++){
  //     //System.out.println("DEBUG get suit hand: " + hand.get(i).getSuit());
  //     if(hand.get(i).getSuit().equals("hearts")){
  //       while(!hand.get(randomcard).getSuit().equals("hearts")){
  //         randomcard=(int)(Math.random()*hand.size());
  //       }
  //       return playCard(randomcard);
  //     }
  //   }

  //   // Return random card as can't follow suit and have no hearts.
  //   return playCard( (int)(Math.random()*hand.size()));
  // }
 
// cardPlayerLevel1
  // public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
  //   Card twoClubs = new Card("2","clubs",2);
  //   if (game.isEmpty()&&getHand().contains(twoClubs)){
  //     //game.add(twoClubs);
  //     //round.add(twoClubs);
  //     return playCard(getHand().indexOf(twoClubs));
  //   }
    
  //   else if (round.isEmpty()){
  //      int q = (int)(Math.random()*getHand().size());
  //      //game.add(hand.get(q));
  //      //round.add(hand.get(q));
  //      return playCard(q);
  //   }
  //   else{
  //     ArrayList<Card> a = new ArrayList<Card>();
  //     for (int i=0; i<getHand().size();i++){
  //       if (getHand().get(i).getSuit().equals(round.get(0).getSuit())){
  //         a.add(getHand().get(i));
  //       }
  //       if(!getHand().get(i).getSuit().equals(round.get(0).getSuit())&&getHand().get(i).getSuit().equals("spades")&&getHand().get(i).getRank()==12){
  //         a.add(getHand().get(i));
  //       }
  //     }
  //       if (!a.isEmpty()){
  //         int k = (int) (Math.random() * a.size());
  //         return playCard(getHand().indexOf(a.get(k)));
  //       }
  //     else if (!round.get(0).getSuit().equals("hearts")){
  //       for (int i=0; i<getHand().size();i++){
  //         if (getHand().get(i).getSuit().equals("hearts")){
  //           a.add(getHand().get(i));
  //         }
          
  //       }
  //     }
  //       if (!a.isEmpty()) {
  //         for (int i=0; i<getHand().size();i++){
  //           int high = 0;
  //           if(getHand().get(i).getRank()>high){
  //           high = getHand().get(i).getRank();
  //         }
  //         }
          
  //         int k = (int) (Math.random() * a.size());
  //         return playCard(getHand().indexOf(a.get(k)));
  //       }
  //       else{
  //         int k = (int) (Math.random() * getHand().size());
  //         return playCard(k);
  //       }
  //     }
  // }

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