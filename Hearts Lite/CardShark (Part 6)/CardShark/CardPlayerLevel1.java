import java.util.*;
import java.util.Random;
public class CardPlayerLevel1 extends CardPlayer{
  
  public CardPlayerLevel1(String name, int score, ArrayList<Card> hand){
    super(name, score, hand);

    this.getHand().addAll(hand);
  }
  public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
    Card twoClubs = new Card("2","clubs",2);
    Card SpadeAce = new Card("A", "spades", 14);
    Card HeartsAce = new Card("A", "hearts", 14);
    Card DiamondsAce = new Card("A", "diamonds", 14);
    if (game.isEmpty()&&getHand().contains(twoClubs)){
      //game.add(twoClubs);
      //round.add(twoClubs);
      return playCard(getHand().indexOf(twoClubs));
    }
    
    else if (round.isEmpty()){
      int hIndex=0;
      int sIndex=0;
      int dIndex=0;
      if(getHand().contains(SpadeAce)||getHand().contains(HeartsAce)||getHand().contains(DiamondsAce)){
        hIndex = getHand().indexOf(HeartsAce);
        sIndex = getHand().indexOf(SpadeAce);
        dIndex = getHand().indexOf(DiamondsAce);
      }
       int q = (int)(Math.random()*getHand().size());
       if(!(hIndex==q)){
         return playCard(q);
       }else if(!(sIndex==q)){
         return playCard(q);
       }else if(!(dIndex==q)){
         return playCard(q);
       }
       //game.add(hand.get(q));
       //round.add(hand.get(q));
       return playCard(q);
    }
    else{
      ArrayList<Card> a = new ArrayList<Card>();
      for (int i=0; i<getHand().size();i++){
        if (getHand().get(i).getSuit().equals(round.get(0).getSuit())){
          a.add(getHand().get(i));
        }
        if(!getHand().get(i).getSuit().equals(round.get(0).getSuit())&&getHand().get(i).getSuit().equals("spades")&&getHand().get(i).getRank()==12){
          a.add(getHand().get(i));
        }
        if(!getHand().get(i).getSuit().equals(round.get(0).getSuit())&&getHand().get(i).getSuit().equals("hearts")&&getHand().get(i).getRank()>=10){
          a.add(getHand().get(i));
        }
      }
        if (!a.isEmpty()){
          int k = (int) (Math.random() * a.size());
          return playCard(getHand().indexOf(a.get(k)));
        }
      else if (!round.get(0).getSuit().equals("hearts")){
        for (int i=0; i<getHand().size();i++){
          if (getHand().get(i).getSuit().equals("hearts")){
            a.add(getHand().get(i));
          }
          
        }
      }
        if (!a.isEmpty()) {
          for (int i=0; i<getHand().size();i++){
            int high = 0;
            if(getHand().get(i).getRank()>high){
            high = getHand().get(i).getRank();
          }
          }
          
          int k = (int) (Math.random() * a.size());
          return playCard(getHand().indexOf(a.get(k)));
        }
        else{
          int k = (int) (Math.random() * getHand().size());
          return playCard(k);
        }
      }
  }
}