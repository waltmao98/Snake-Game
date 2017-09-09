import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;

public class KeyboardListener implements KeyListener {

     private SnakeGame snakeGame;
     private Snake snake;
     private Component component;

     public KeyboardListener(SnakeGame snakeGame, Component component) {
          this.component = component;
          this.snakeGame = snakeGame;
          snake = snakeGame.getSnake();
     }

     @Override
     public void keyPressed(KeyEvent e) {

     if(snakeGame.getContinueGame()) {
          if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
               System.exit(0);
          }
          if(e.getKeyCode() == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
               snake.setDirection(Direction.LEFT);
          }
          if(e.getKeyCode() == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
               snake.setDirection(Direction.RIGHT);
          }
          if(e.getKeyCode() == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
               snake.setDirection(Direction.UP);
          }
          if(e.getKeyCode() == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
               snake.setDirection(Direction.DOWN);
          }
     } else {
          if(e.getKeyCode() == KeyEvent.VK_ENTER) {
               snakeGame.resetGame();
          }
     }
          component.repaint();
     }

     @Override
     public void keyReleased(KeyEvent e) {
     }

     @Override
     public void keyTyped(KeyEvent ke) {
     }
}
