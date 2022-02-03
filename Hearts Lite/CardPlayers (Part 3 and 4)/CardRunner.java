import java.util.*;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    /*Player john = new Player("John", 8);
    john.updateScore(8);
    System.out.println(john);
    Deck a = new Deck();
      for (int q=0; i>4;i++){
      ArrayList<Card> (q+"h") = new ArrayList<Card>;
      for (int i=;i>(a.size/4);i++){
        int k = (int) (Math.random() * (a.size+1));
        (q+"h").add(a.getCard(k));
     }
      CardPlayer (q+"Card") = new CardPlayer(john, 0, h1);
    }
    ArrayList<Card> b = new ArrayList<Card>();
    ArrayList<Card> c = new ArrayList<Card>();
    ArrayList<Card> d = new ArrayList<Card>();
    for (int i=0;i<a.getDeck().size();i++){
      b.add(a.getCard(i));
    }
    CardPlayer johnCard = new CardPlayer("john", 0, b);
    System.out.println(johnCard);
    for (int i=0; i<(a.getDeck().size()/2);i++){
      Card w = johnCard.chooseCard(c,d);
      System.out.print(w+""+(i+1));
      d.add(w);
      c.add(w);
      if ((i+1)%4==0&&!(i==0)){
        System.out.println("|");
        c.clear();}
    }
    System.out.println("\n"+johnCard);
    for (int i=0; i<(a.getDeck().size()/2);i++){
      Card w = johnCard.chooseCard(c,d);
      System.out.print(w+""+(i+1));
      d.add(w);
      c.add(w);
      if ((i+1)%4==0&&!(i==0)){
        System.out.println("|");
        c.clear();}
    }
    */
    ArrayList<Card> daveHand = new ArrayList<Card>();
    Card twoClubs = new Card("2","clubs",2);
    Card threeClubs = new Card("3","clubs",3);
    Card threeHearts = new Card("3","hearts",3);
    Card fourHearts = new Card("4","hearts",4);
    Card fiveClubs = new Card("5","clubs",5);
    Card sixClubs = new Card("6","clubs",6);
    Card fiveSpades = new Card("5","spades",5);
    Card sixSpades = new Card("6","spades",6);
    daveHand.add(twoClubs);
    daveHand.add(threeClubs);
    daveHand.add(threeHearts);
    daveHand.add(fourHearts);
    daveHand.add(fiveClubs);
    daveHand.add(sixClubs);
    daveHand.add(fiveSpades);
    daveHand.add(sixSpades);
    CardPlayer player1 = new CardPlayer("dave",0,daveHand);
    ArrayList<Card> Round = new ArrayList<Card>();
    ArrayList<Card> Game = new ArrayList<Card>();
    System.out.println("Round = "+Round);
    System.out.println("Game = "+Game);
    Card pickedCard = player1.chooseCard(Round, Game);
    System.out.println("2clubs = "+pickedCard+", Player = "+player1);
    Round.add(twoClubs);
    System.out.println("Round = "+Round);
    for(int i=0;i<7;i++){
      pickedCard = player1.chooseCard(Round, Game);
      System.out.println("Random Card = "+pickedCard+", Player = "+player1);
      Round.add(pickedCard);
      System.out.println("Round = "+Round);}
  }
}
