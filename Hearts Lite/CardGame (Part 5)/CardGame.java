import java.util.*;
import java.lang.Math;
public class CardGame {
  private Deck deckOfCards;
  private String nameOfGame = "";
  private ArrayList<CardPlayer> players;
  private int numberOfPlayers;
  private int currentPlayer;

  public CardGame(String name, int numPlayers, String[] namePlay, int currentPlay){
    deckOfCards = new Deck();
    
    nameOfGame = name;
    players = new ArrayList<CardPlayer>();
    numberOfPlayers = numPlayers;
    currentPlayer = currentPlay;
    for(int i=0; i < namePlay.length; i++){

      CardPlayer player = new CardPlayer(namePlay[i], 0, new ArrayList<>());
      players.add(player);
      //players.get(i).setName(namePlay[i]);
      System.out.println("Player Player"+ i + " is a CardPlayer");
    }
  }
  public void initializeDeck(){
      deckOfCards = new Deck();
  }
  public Deck getDeckOfCards() {
    return deckOfCards;
  }
  public void setDeckOfCards(Deck d) {
    deckOfCards = d;
  }
  public String getNameOfGame() {
    return nameOfGame;
  }
  public void setNameOfGame(String s) {
    nameOfGame = s;
  }
  public ArrayList<CardPlayer> getPlayers() {
    return players;
  }

  public void setPlayers(ArrayList<CardPlayer> cp) {
    players = cp;
  }
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }
  public void setNumberOfPlayers(int n) {
    numberOfPlayers = n;
  }
  public int getCurrentPlayer() {
    return currentPlayer;
  }
  public void setCurrentPlayer() {
    currentPlayer = setCurrentPlayerToStartingPlayer();
  }
  public CardPlayer getPlayer(int i){
    return players.get(i);
  }

  public void deal(int num, int play) {
    //System.out.println(deckOfCards);
    //System.out.println(num);
    for(int i = 0; i < num; i++) {
      // System.out.println(deckOfCards.getDeck().size());
      players.get(play).addCard(deckOfCards.dealTopCard());
      
    }
  }

  public int setCurrentPlayerToStartingPlayer(){
    Card tempcard = new Card("2","clubs",2);
    for(int o = 0; o<numberOfPlayers;o++){
      if(players.get(o).getHand().contains(tempcard)){
      //System.out.println("debug "+cardhand.indexOf(tempcard));
      return o;
      }
    }
    System.out.println("Error missing 2 of clubs/n"+deckOfCards);
    System.out.println(players);
    return -1;
  }

  public int takesRound(int leader ,ArrayList<Card> round){
    ArrayList<Card> contenders = new ArrayList<Card>();
    Card tempcard = new Card();
    for(int i=1;i<round.size();i++){
        if(round.get(0).getSuit().equals(round.get(i).getSuit())&&round.get(i).getRank()>round.get(0).getRank()){
          contenders.add(round.get(i));
        }
    } 
    contenders.add(round.get(0));
      Collections.sort(contenders);
      tempcard=contenders.get(contenders.size()-1);
      if(round.indexOf(tempcard)+leader>=numberOfPlayers){
        return round.indexOf(tempcard)+leader-numberOfPlayers;
      }
      return round.indexOf(tempcard)+leader;
  }

  public void updateScore(int winner ,ArrayList<Card> round){
    Card tempcard2 = new Card("Q","spades",12);
    for(int i=0;i<round.size();i++){
      if(round.get(i).getSuit().equals("hearts")){
        players.get(winner).updateScore(1);
        //System.out.println(round.get(i) + "Adding 1 to " + players.get(winner));
      }
      if(round.get(i).equals(tempcard2)){
        players.get(winner).updateScore(13);
      }
    }
  }

  public void playGame(){
    Card tempcard = new Card();
    int playerThatLed;
 

    playerThatLed=setCurrentPlayerToStartingPlayer();
    ArrayList<Card> cardsPlayedInGame = new ArrayList<Card>();

    for(int round=1;round<=13;round++){
      ArrayList<Card> cardsPlayedInRound = new ArrayList<Card>();
      currentPlayer=playerThatLed;
      for(int i=0;i<players.size();i++){
        tempcard=players.get(currentPlayer).chooseCard(cardsPlayedInRound, cardsPlayedInGame);
        cardsPlayedInRound.add(tempcard);
        cardsPlayedInGame.add(tempcard);
        currentPlayer++;
        if(currentPlayer>=players.size()){
          currentPlayer=0;
        }
      }
      checkRound(cardsPlayedInRound, playerThatLed);
      playerThatLed=takesRound(playerThatLed, cardsPlayedInRound);
      updateScore(playerThatLed, cardsPlayedInRound);

      
    }
    
    System.out.print(">>> playGame() ");
    for(int i=0; i<numberOfPlayers; i++){
       System.out.print("Player" + i + "(" + players.get(i).getScore()+ ") ");
      //System.out.print("Player" + i + "(" + players.get(i).getScore()+ ") ");
    }
    System.out.println();
  }

  public void checkRound(ArrayList<Card> round, int startingPlayer) {
    //System.out.print(startingPlayer + " ");
   // Establish what the suit to match is
   String roundSuit = round.get(0).getSuit(); 
   // For all other players
   //System.out.println(round.size());
   for (int i = 1; i < round.size(); i++) { 
      // If their card doesn't match suit, check to see if they're incorrect
      
      if (!round.get(i).getSuit().equals(roundSuit)) { 
         CardPlayer player = players.get((i + startingPlayer) % round.size());
         // Go through their cards
         for (Card c : player.getHand()) { 
            // If incorrect, print out offending card and that they're incorrect
            if (c.getSuit().equals(roundSuit)) { 
               System.out.println("*** INCORRECT ***" + player.getName() + " playing " + round.get(i) + " in " + round + " while having " + player.getHand());
               break;
            }
         }
      }
   }
}


  public String toString(){
    for(int i=0; i<4; i++){
      System.out.println("Player"+ i + " (0) "+ " []");
      
    }
    return "deck -> " + deckOfCards.toString();
    // return "Name of game: " + nameOfGame + "Players: " + players + "Deck of cards" + deckOfCards;
  }
}