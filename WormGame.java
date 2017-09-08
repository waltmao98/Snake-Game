import javax.swing.Timer;
import java.util.Random;
import java.awt.event.*;

public class WormGame implements ActionListener{

     private Worm worm;
     private Apple apple;
     private int frameWidth; // width of the frame containing the game
     private int frameHeight; // height of the frame containing the game
     private int pieceLength; // width of a piece
     private boolean continueGame; // determines whether the game continues or not
     private Random random; // for setting the apple
     private DrawingBoard drawingBoard;
     private Timer timer;
     private int minDelay;
     private int originalDelay;

     public WormGame(int frameWidth, int frameHeight, int pieceLength) {
          this.frameWidth = frameWidth;
          this.frameHeight = frameHeight;
          this.pieceLength = pieceLength;

          continueGame = true;
          worm = new Worm(frameWidth/2,frameHeight/2,Direction.DOWN,pieceLength);

          random = new Random();
          int appleX = random.nextInt(frameWidth-pieceLength*3+1) + 2*pieceLength;
          int appleY = random.nextInt(frameHeight-pieceLength*3+1) + 2*pieceLength;
          apple = new Apple(appleX,appleY,pieceLength);

          minDelay = 10;
          originalDelay = 300;

          timer = new Timer(minDelay+originalDelay,this);
          timer.start();
     }

     public Worm getWorm() {
          return worm;
     }

     public Apple getApple() {
          return apple;
     }

     public void resetApple() {
          int appleX = random.nextInt(frameWidth-pieceLength*3+1) + 2*pieceLength;
          int appleY = random.nextInt(frameHeight-pieceLength*3+1) + 2*pieceLength;
          apple.setX(appleX);
          apple.setY(appleY);
     }

     public void setDrawingBoard(DrawingBoard drawingBoard) {
          this.drawingBoard = drawingBoard;
     }

     private void keepWormInBounds() {
          if(worm.getX() <= 0) {
               worm.setX(worm.getX() + frameWidth);
          }
          if(worm.getY() <= 0) {
               worm.setY(worm.getY() + frameHeight);
          }
          if(worm.getX() >= frameWidth) {
               worm.setX(worm.getX() - frameWidth);
          }
          if(worm.getY() >= frameHeight) {
               worm.setY(worm.getY() - frameHeight);
          }
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
          timer.setDelay(minDelay+originalDelay/worm.getLength());
          keepWormInBounds();
          worm.move();
          if(worm.runsInto(apple)) {
               resetApple();
               worm.grow();
          }
          if(worm.runsIntoItself()) {
               continueGame = false;
          }
          drawingBoard.repaint();
     }


}
