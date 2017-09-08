import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Color;

public class DrawingBoard extends JPanel{

     private SnakeGame snakeGame;
     private Snake snake;
     private Apple apple;
     private int pieceLength;

     public DrawingBoard(SnakeGame snakeGame,int pieceLength) {
          super.setBackground(Color.black);
          this.snakeGame = snakeGame;
          this.snake = snakeGame.getSnake();
          this.apple = snakeGame.getApple();
          this.pieceLength = pieceLength;
     }

     @Override
     protected void paintComponent(Graphics graphics) {
          super.paintComponent(graphics);
          Color electricGreen = new Color(181,255,69);
          graphics.setColor(electricGreen);
          snake.draw(graphics);
          graphics.setColor(Color.red);
          graphics.fillOval(apple.getX(), apple.getY(), pieceLength, pieceLength);
     }

}
