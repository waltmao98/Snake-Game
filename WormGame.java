import java.util.Timer;
import java.util.Random;

public class WormGame {

     private Worm worm;
     private Apple apple;
     private int frameWidth; // width of the frame containing the game
     private int frameHeight; // height of the frame containing the game
     private int pieceLength; // width of a piece
     private boolean continueGame; // determines whether the game continues or not

     public WormGame(int frameWidth, int frameHeight, int pieceLength) {
          this.frameWidth = frameWidth;
          this.frameHeight = frameHeight;
          this.pieceLength = pieceLength;
          worm = new Worm(frameWidth/2,frameHeight/2,Direction.DOWN,pieceLength);

          Random random = new Random();
          int appleX = random.nextInt(frameWidth+1);
          int appleY = random.nextInt(frameHeight+1);
          apple = new Apple(appleX,appleY);
     }

     public Worm getWorm() {
          return worm;
     }

     public void setWorm(Worm worm) {
          this.worm = worm;
     }

     public Apple getApple() {
          return apple;
     }

     public void setApple(Apple apple) {
          this.apple = apple;
     }

     public void action() {
          worm.move();
     }

}
