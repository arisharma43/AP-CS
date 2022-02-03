class Main {
  public static void main(String[] args) {
    
    TestCardGame();
    
    
}

public static void TestCardGame(){
  String[] names = {"Ben", "Alicia", "Jacob", "Bob" };
    CardGame game = new CardGame("Joe", 4, names, 0);
    System.out.println("***Hearts***");
    System.out.println(game);

    
    
    for(int i=0; i<10000; i++){
      game.initializeDeck();
      game.getDeckOfCards().shuffle();
      game.deal(13, 0);
      game.deal(13, 1);
      game.deal(13, 2);
      game.deal(13, 3);
      //game.setCurrentPlayer();
      game.playGame();
    }
    
    

    int total=0;
    for (int i=0; i <= 3; i++) {
      total = total + game.getPlayer(i).getScore();
      //System.out.println("Debug: " + game2.getPlayer(i));
    }

    System.out.println("total score= " + total);
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
      // ((int) ((game2.getPlayer(i).getPscore()/(double) total) * 10000))/ 100.0;
      System.out.println("Player"+ i + " " + game.getPlayers().get(i).getScore() + " " + (((int) ((game.getPlayer(i).getScore()/(double) total) * 10000))/ 100.0) + "%");
    }

    
  }
}
