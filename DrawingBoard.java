import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.Timer;

public class DrawingBoard extends JPanel implements ActionListener{

     private WormGame wormGame;
     private Worm worm;
     private Apple apple;
     private int pieceLength;
     private Timer timer;

     public DrawingBoard(WormGame wormGame,int pieceLength) {
          super.setBackground(Color.WHITE);
          this.wormGame = wormGame;
          this.worm = wormGame.getWorm();
          this.apple = wormGame.getApple();
          this.pieceLength = pieceLength;

          int delay = 50;
          timer = new Timer(delay,this);
     }

     @Override
     protected void paintComponent(Graphics graphics) {
          super.paintComponent(graphics);
          worm.draw(graphics);
          apple.draw(graphics,pieceLength);
          timer.start();
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
          wormGame.action();
          repaint();
     }

}
