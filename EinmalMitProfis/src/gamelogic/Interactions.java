package gamelogic;

public class Interactions {
  static int score = 0;

  public static void inrceaseScore() {
    score++;
    score+=score/1000;
  }
  
  public static int getScore() {
    return score;
  }

  public static void resetScore() {
    score=0;
  }
}
