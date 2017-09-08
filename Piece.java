import java.awt.Graphics;

public class Piece {

     private int pieceLength;
     private int pieceRadius;
     private int x;
     private int y;

     public Piece(int x, int y, int pieceLength) {
          this.x = x;
          this.y = y;
          this.pieceLength = pieceLength;
          this.pieceRadius = pieceLength/2;
     }

     public void setX(int x) {
          this.x = x;
     }

     public void setY(int y) {
          this.y = y;
     }

     public int getX() {
          return x;
     }

     public int getY() {
          return y;
     }

     public int getRadius() {
          return pieceRadius;
     }

     public boolean runsInto(Piece piece) {

          boolean xCollisionLeft = this.x + pieceRadius >= piece.getX() - piece.getRadius() &&
                                   this.x + pieceRadius <= piece.getX() + piece.getRadius();
          boolean xCollisionRight = this.x - pieceRadius <= piece.getX() + piece.getRadius() &&
                                    this.x - pieceRadius >= piece.getX() - piece.getRadius();
          boolean yCollisionTop = this.y + pieceRadius >= piece.getY() - piece.getRadius() &&
                                  this.y + pieceRadius <= piece.getY() + piece.getRadius();
          boolean yCollisionBottom = this.y - pieceRadius <= piece.getY() + piece.getRadius() &&
                                     this.y - pieceRadius >= piece.getY() - piece.getRadius();
          boolean collision = (xCollisionLeft && yCollisionTop) || (xCollisionLeft && yCollisionBottom) ||
                              (xCollisionRight && yCollisionTop) || (xCollisionRight && yCollisionBottom);
          return collision;
     }

     public String toString() {
          return "(" + x + "," + y + ")";
     }

}
