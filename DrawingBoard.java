import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DrawingBoard extends JPanel {

     private Worm worm;
     private Apple apple;
     private int pieceLength;

     public DrawingBoard(Worm worm, Apple apple, int pieceLength) {
          super.setBackground(Color.WHITE);
          this.worm = worm;
          this.apple = apple;
          this.pieceLength = pieceLength;
     }

     @Override
     protected void paintComponent(Graphics graphics) {
          super.paintComponent(graphics);
          worm.draw(graphics);
          apple.draw(graphics,pieceLength);
     }

}
