import java.util.Collections;
import java.util.*;
import java.util.Arrays;

public class Card implements Comparable<Object>
{
  private String name;
  private String suit;
  private int rank;
  
  public Card()
  {
    name = "default";
    suit = "default";
    rank = 0;
  }

  public Card(String n, String s, int r)
  {
    name = n;
    suit = s;
    rank = r;
  }

  public void setName(String n)
  {
    name = n;
  }
  
  public void setSuit(String s)
  {
    suit = s;
  }

  public void setRank(int r)
  {
    rank = r;
  }

  public String getName()
  {
    return name;
  }

  public String getSuit()
  {
    return suit;
  }
  
  public int getRank()
  {
    return rank;
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


  /*public int compareTo(Object obj) {
    Card d = (Card) obj;
    if (this.equals(d))
      return 0;
    int rankNum = 0;
    int rankNum2 = 0;
    if (d.getSuit() == "clubs") 
      rankNum2 = 3;
    if (d.getSuit() == "spades") 
      rankNum2 = 2;
    if (d.getSuit() == "hearts")
      rankNum2 = 1;
    if (this.getSuit() == "clubs") 
      rankNum = 3;
    if (this.getSuit() == "spades") 
      rankNum = 2;
    if (this.getSuit() == "hearts")
      rankNum = 1;
    if (this.getSuit() == d.getSuit()) {
      if (this.getRank() > d.getRank())
        return 1;
      else 
        return -1;
    }
    else {
      if (rankNum > rankNum2)
        return 1;
      else 
        return -1;
    }
  }*/
  
  @Override
  public boolean equals(Object obj)
  {
    Card c = (Card) obj;
    if (getSuit().equals(c.getSuit()) && getName().equals(c.getName()) && getRank() == c.getRank())
    {
      return true;
    }
    else
    {
      return false;
    }
  
  }

  public String toString()
  {
    return (suit.charAt(0) + name + "(" + rank + ")");
  }

}
