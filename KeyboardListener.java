import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;

public class KeyboardListener implements KeyListener {

     private WormGame wormGame;
     private Worm worm;
     private Component component;

     public KeyboardListener(WormGame wormGame, Component component) {
          this.component = component;
          this.wormGame = wormGame;
          worm = wormGame.getWorm();
     }

     @Override
     public void keyPressed(KeyEvent e) {
     switch(e.getKeyCode()) {
          case KeyEvent.VK_ESCAPE:
               System.exit(0);
          case KeyEvent.VK_LEFT:
               worm.setDirection(Direction.LEFT);
               break;
          case KeyEvent.VK_RIGHT:
               worm.setDirection(Direction.RIGHT);
               break;
          case KeyEvent.VK_UP:
               worm.setDirection(Direction.UP);
               break;
          case KeyEvent.VK_DOWN:
               worm.setDirection(Direction.DOWN);
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
