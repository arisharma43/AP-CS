import java.util.*;
import java.util.Arrays;
import java.util.Collections;


public class Main {
  
  public static void main(String[] args) {
    Deck test1 = new Deck();
    test1.shuffle();
    System.out.println(test1.toString());
    test1.sortDeck();
    System.out.println(test1.toString());
  }
}
