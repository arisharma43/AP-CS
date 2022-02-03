class Main {
  public static void main(String[] args) {
    Card card1  = new Card("3","clubs",3);
    Card card3b = new Card("3","hearts",3);
    Card card4 = new Card("A","hearts",14);
    Card card5 = new Card("7","spades",7);
     
    System.out.println("  " + card1 + ".compareTo(" + card3b + ") is " + card1.compareTo(card3b));
    System.out.println("  " + card4 + ".compareTo(" + card5 + ") is " + card4.compareTo(card5));
  }
}
