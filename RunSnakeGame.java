import javax.swing.SwingUtilities;
import java.util.Scanner;
import java.lang.System;

// entry point to snake game
public class RunSnakeGame{
     public static void main(String[] args) {
          SnakeGameInterface ui = new SnakeGameInterface();
          SwingUtilities.invokeLater(ui);

          // quit program if user types "q"
          Scanner in = new Scanner(System.in);
          if(in.nextLine().equals("q")) {
               System.exit(0);
          }
     }
}
