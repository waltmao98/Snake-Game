import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;

public class DrawingBoard extends JPanel{

     private SnakeGame snakeGame;
     private Snake snake;
     private Apple apple;
     private int pieceLength;
     private final String GAME_OVER = "Game Over";
     private final String PLAY_AGAIN = "Press Enter/Return to play again";

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

          if(!snakeGame.getContinueGame()) {
               paintGameOver(graphics);
          }
     }

     private void paintGameOver(Graphics graphics) {
          paintMsg(GAME_OVER,Font.BOLD,5*pieceLength,graphics,0,5*pieceLength/3);
          paintMsg(PLAY_AGAIN,Font.PLAIN,2*pieceLength,graphics,pieceLength*2,pieceLength/2);
     }

     private void paintMsg(String msg,int fontStyle, int fontSize, Graphics graphics, int yOffset, int xOffset) {
          Font font = new Font(Font.SANS_SERIF,fontStyle,fontSize);
          graphics.setFont(font);
          graphics.setColor(Color.WHITE);
          graphics.drawString(msg,
                              snakeGame.getFrameWidth()/2-msg.length()* xOffset,
                              snakeGame.getFrameHeight()/2 + yOffset
                             );
     }

}
