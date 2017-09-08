import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WormGameInterface implements Runnable {

     private JFrame frame;
     private WormGame wormGame;
     private int frameWidth;
     private int frameHeight;
     private int pieceLength;
     private DrawingBoard drawingBoard;


     public WormGameInterface() {
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          frameWidth = screenSize.width * 5 / 6;
          frameHeight = screenSize.height * 5 / 6;
          pieceLength = frameWidth / 50;

          wormGame = new WormGame(frameWidth,frameHeight,pieceLength);
          drawingBoard = new DrawingBoard(wormGame,pieceLength);
          drawingBoard.setBounds(0,0,frameWidth,frameHeight);
          wormGame.setDrawingBoard(drawingBoard);
     }

     @Override
     public void run() {
         frame = new JFrame("Worm Game");

         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.setUndecorated(true);

         createComponents(frame.getContentPane());

         frame.setBounds(0,0,frameWidth,frameHeight);
         
         frame.setVisible(true);
     }

     private void createComponents(Container container) {
          container.add(drawingBoard);
          frame.addKeyListener(new KeyboardListener(wormGame,drawingBoard));
     }

}
