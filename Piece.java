import java.awt.Graphics;

public class Piece {

     private int x;
     private int y;

     public Piece(int x, int y, int pieceLength) {
          this.x = x;
          this.y = y;
     }

     public int getX() {
          return x;
     }

     public int getY() {
          return y;
     }

     public boolean runsInto(Piece piece) {
          return piece.getX() == x && piece.getY() == y;
     }

     public String toString() {
          return "(" + x + "," + y + ")";
     }

     public void draw(Graphics graphics, int pieceLength) {
          graphics.fillOval(x, y, pieceLength, pieceLength);
     }

}
