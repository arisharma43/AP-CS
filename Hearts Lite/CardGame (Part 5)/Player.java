public class Player{
  private String name;
  private int score;

  public Player(String n, int s){
    name = n;
    score = s;
  }

  public void setName(String n){
    this.name = n;
  }

  public String getName(){
    return name;
  }

  public void setScore(int s){
    this.score = s;
  }

  public int getScore(){
    return score;
  }

  public void updateScore(int i){
    score += i;
  }

  public String toString(){
    return name + " " + score;
  }
}