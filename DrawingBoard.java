import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Color;

public class DrawingBoard extends JPanel{

     private WormGame wormGame;
     private Worm worm;
     private Apple apple;
     private int pieceLength;

     public DrawingBoard(WormGame wormGame,int pieceLength) {
          super.setBackground(Color.WHITE);
          this.wormGame = wormGame;
          this.worm = wormGame.getWorm();
          this.apple = wormGame.getApple();
          this.pieceLength = pieceLength;
     }

     @Override
     protected void paintComponent(Graphics graphics) {
          super.paintComponent(graphics);
          graphics.setColor(Color.black);
          worm.draw(graphics);
          graphics.setColor(Color.red);
          graphics.fillOval(apple.getX(), apple.getY(), pieceLength, pieceLength);
     }

}
