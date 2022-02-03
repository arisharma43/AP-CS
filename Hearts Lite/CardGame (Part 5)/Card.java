public class Card implements Comparable<Object> {
  private int rank;
  private String name;
  private String suit;
  
  public Card(){
    rank = 0;
    name = "default";
    suit = "default";
  }
  public Card(String a, String b, int c){
    name = a;
    suit = b;
    rank = c;
  }
  public int getRank(){
    return rank;
  }
  public String getName(){
    return name;
  }
  public String getSuit(){
    return suit;
  }
  public void setRank(int a){
    rank = a;
  }
  public void setName(String a){
    name = a;
  }
  public void setSuit(String a){
    suit = a;
  }
  public boolean equals(Object obj){
		Card s = (Card) obj;
		return (name.equals(s.getName()) && suit.equals(s.getSuit()) && rank == s.getRank());
	}
  public int compareTo(Object obj){
    Card c = (Card) obj;
    int cValue = 0;
    int value = 0;
    if (c.getSuit().equals("clubs"))
      cValue = 42;
    if (c.getSuit().equals("spades"))
      cValue = 28;
    if (c.getSuit().equals("hearts"))
      cValue = 14;
    if (suit.equals("clubs"))
      value = 42;
    if (suit.equals("spades"))
      value = 28;
    if (suit.equals("hearts"))
      value = 14;
    cValue += c.getRank();
    value += rank;
    if (cValue > value)
      return -1;
    if (cValue < value)
      return 1;
    else 
      return 0;
  }
  public String toString(){
    return suit.charAt(0)+name+"("+rank+")";
  }
}
