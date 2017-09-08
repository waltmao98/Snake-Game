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


     public WormGameInterface() {
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          frameWidth = screenSize.width;
          frameHeight = screenSize.height;
          pieceLength = (frameWidth - 10) / 50;

          wormGame = new WormGame(frameWidth,frameHeight,pieceLength);
     }

     @Override
     public void run() {
         frame = new JFrame("Worm Game");

         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

         createComponents(frame.getContentPane());

         frame.setBounds(0,0,frameWidth, frameHeight);

         frame.setResizable(false);

         frame.setVisible(true);
     }

     private void createComponents(Container container) {
          DrawingBoard drawingBoard = new DrawingBoard(wormGame.getWorm(),wormGame.getApple(),pieceLength);
          container.add(drawingBoard);
          frame.addKeyListener(new KeyboardListener(wormGame,drawingBoard));
     }

}
