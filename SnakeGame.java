import javax.swing.Timer;
import java.util.Random;
import java.awt.event.*;

public class SnakeGame implements ActionListener{

     private final int minDelay = 10;
     private final int originalDelay = 300;

     private Snake snake;
     private Apple apple;
     private int frameWidth; // width of the frame containing the game
     private int frameHeight; // height of the frame containing the game
     private int pieceLength; // width of a piece
     private boolean continueGame; // determines whether the game continues or not
     private Random random; // for setting the apple
     private DrawingBoard drawingBoard;
     private Timer timer;

     public SnakeGame(int frameWidth, int frameHeight, int pieceLength) {
          this.frameWidth = frameWidth;
          this.frameHeight = frameHeight;
          this.pieceLength = pieceLength;

          continueGame = true;
          snake = new Snake(frameWidth/2,frameHeight/2,Direction.DOWN,pieceLength);

          random = new Random();
          int appleX = random.nextInt(frameWidth-pieceLength*4+1) + pieceLength;
          int appleY = random.nextInt(frameHeight-pieceLength*4+1) + pieceLength;
          apple = new Apple(appleX,appleY,pieceLength);

          timer = new Timer(minDelay+originalDelay,this);
          timer.start();
     }

     public Snake getSnake() {
          return snake;
     }

     public Apple getApple() {
          return apple;
     }

     public int getFrameWidth() {
          return frameWidth;
     }

     public int getFrameHeight() {
          return frameHeight;
     }

     public void resetApple() {
          int appleX = random.nextInt(frameWidth-pieceLength*4+1) + pieceLength;
          int appleY = random.nextInt(frameHeight-pieceLength*4+1) + pieceLength;
          apple.setX(appleX);
          apple.setY(appleY);
     }

     public void setDrawingBoard(DrawingBoard drawingBoard) {
          this.drawingBoard = drawingBoard;
     }

     private void keepSnakeInBounds() {
          if(snake.getX() <= pieceLength*2) {
               snake.setX(snake.getX() + frameWidth - pieceLength*2);
          }
          if(snake.getY() <= pieceLength*2) {
               snake.setY(snake.getY() + frameHeight - pieceLength*2);
          }
          if(snake.getX() >= frameWidth-pieceLength*2) {
               snake.setX(snake.getX() - frameWidth + pieceLength*2);
          }
          if(snake.getY() >= frameHeight-pieceLength*2) {
               snake.setY(snake.getY() - frameHeight + pieceLength*2);
          }
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
          timer.setDelay(minDelay+originalDelay/snake.getLength());
          keepSnakeInBounds();
          snake.move();
          if(snake.runsInto(apple)) {
               resetApple();
               snake.grow();
          }
          if(snake.runsIntoItself()) {
               stopGame();
          }
          drawingBoard.repaint();
     }

     private void stopGame() {
          timer.stop();
          continueGame = false;
     }

     public boolean getContinueGame() {
          return continueGame;
     }

     public void resetGame() {
          continueGame = true;
          snake.resetSnake();
          timer.start();
     }

}
