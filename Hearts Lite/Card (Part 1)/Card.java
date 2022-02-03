public class Card{
  private String name;
  private String suit;
  private int rank;
  
  public Card(){
    name = "default";
    suit = "default";
    rank = 0;
  }
  public Card(String n, String s, int r){
    name = n;
    suit = s;
    rank = r;
  }
  public void setName(String n){
    name = n;
  }
  public void setSuit(String s){
    suit = s;
  }
  public void setRank(int r){
    rank = r;
  }
  public String getName(){
    return name;
  }
  
  public String getSuit(){
    return suit;
  }

  public int getRank(){
    return rank;
  }
  public boolean equals(Object obj){
    Card c = (Card) obj;
    if(c.getName().equals(name)&&c.getSuit().equals(suit)&&c.getRank()==rank){
      return true;
    }else{
      return false;
    }
  }
  public int compareTo(Object obj){
    Card c = (Card) obj;
    int rankC = c.sortRank();
    int ranked = sortRank();

    
    if (rankC>ranked) {
      return -1;
    }
    else if (rankC < ranked) {
      return 1;
    }else{
      return 0;
    }
    
  }   
  
  public int sortRank() {
    if (suit.equals("d")||suit.equals("diamonds")) {
      return rank;
    }
    else if (suit.equals("h")||suit.equals("hearts")) {
      return rank + 13;
    }
    else if (suit.equals("s")||suit.equals("spades")) {
      return rank + 26;
    }
    else if (suit.equals("c")||suit.equals("clubs")) {
      return rank + 39;
    }
    else {
      return 0;
    }
  }
  public String toString(){
    return suit.substring(0, 1) + name + "(" + rank + ")";
  }
}
