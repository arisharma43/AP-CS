class Main {
  public static void main(String[] args) {
    String[] names = {"Ben", "Alicia", "Jacob", "Bob" };
    CardGame game = new CardGame("Joe", 4, names, 0);
    System.out.println("***Hearts***");
    System.out.println(game);

    
    
    for(int i=0; i<2000; i++){
      game.initializeDeck();
      game.getDeckOfCards().shuffle();
      game.deal(13, 0);
      game.deal(13, 1);
      game.deal(13, 2);
      game.deal(13, 3);
      //game.setCurrentPlayer();
      game.playGame();
    }
    
    

    
    int totalBadPoints = 0;
    for(int i=0; i<game.getNumberOfPlayers(); i++){
      totalBadPoints += game.getPlayers().get(i).getScore();
    }
    System.out.println();
    System.out.println("Total Number of bad points = " + totalBadPoints);
    if(totalBadPoints==0){
      return;
    }
    for(int i=0; i<game.getNumberOfPlayers(); i++){
      
      System.out.println("Player"+ i + " " + game.getPlayers().get(i).getScore() + " " + (((int) ((game.getPlayer(i).getScore()/(double) totalBadPoints) * 10000))/ 100.0) + "%");
    }
    
      
      
      
    
    
  }
}
