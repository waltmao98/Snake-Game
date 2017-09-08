import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGameInterface implements Runnable {

     private JFrame frame;
     private SnakeGame snakeGame;
     private int frameWidth;
     private int frameHeight;
     private int pieceLength;
     private DrawingBoard drawingBoard;


     public SnakeGameInterface() {
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          frameWidth = screenSize.width * 5 / 6;
          frameHeight = screenSize.height * 5 / 6;
          pieceLength = frameWidth / 50;

          snakeGame = new SnakeGame(frameWidth,frameHeight,pieceLength);
          drawingBoard = new DrawingBoard(snakeGame,pieceLength);
          drawingBoard.setBounds(0,0,frameWidth,frameHeight);
          snakeGame.setDrawingBoard(drawingBoard);
     }

     @Override
     public void run() {
         frame = new JFrame("Snake Game");

         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, Color.WHITE));

         createComponents(frame.getContentPane());

         frame.setBounds(0,0,frameWidth,frameHeight);

         frame.setVisible(true);
     }

     private void createComponents(Container container) {
          container.add(drawingBoard);
          frame.addKeyListener(new KeyboardListener(snakeGame,drawingBoard));
     }

}
