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
     switch(e.getKeyCode()) {
          case KeyEvent.VK_ESCAPE:
               System.exit(0);
          case KeyEvent.VK_LEFT:
               snake.setDirection(Direction.LEFT);
               break;
          case KeyEvent.VK_RIGHT:
               snake.setDirection(Direction.RIGHT);
               break;
          case KeyEvent.VK_UP:
               snake.setDirection(Direction.UP);
               break;
          case KeyEvent.VK_DOWN:
               snake.setDirection(Direction.DOWN);
               break;
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
