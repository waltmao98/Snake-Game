import javax.swing.SwingUtilities;
import java.util.Scanner;
import java.lang.System;

// entry point to worm game
public class Main{
     public static void main(String[] args) {
          WormGameInterface ui = new WormGameInterface();
          SwingUtilities.invokeLater(ui);

          // quit program if user types "q"
          Scanner in = new Scanner(System.in);
          if(in.nextLine().equals("q")) {
               System.exit(0);
          }
     }
}
