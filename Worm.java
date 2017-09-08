import java.util.ArrayList;
import java.util.*;
import java.awt.Graphics;

public class Worm {

     private int pieceLength;
     private int x; // x position of the head of the worm
     private int y; // y position of the head of the worm
     private Direction direction; // direction of the head of the worm
     private List<Piece> pieces; // list of pieces that make up the worm. Last Piece of the list is the head
     private boolean shouldGrow; // determines whether or not the worm should grow during the next move()

     public Worm(int originalX, int originalY, Direction originalDirection, int pieceLength) {
          this.pieceLength = pieceLength;

          x = originalX;
          y = originalY;
          direction = originalDirection;

          pieces = new ArrayList<Piece>();
          Piece piece  = new Piece(originalX,originalY);
          pieces.add(piece);
     }

     public int getX() {
          return x;
     }

     public int getY() {
          return y;
     }

     public Direction getDirection() {
          return direction;
     }

     public void setDirection(Direction dir) {
          direction = dir;
     }

     public int getLength() {
          return pieces.size();
     }

     public List<Piece> getPieces() {
          return pieces;
     }

     public void move() {
          // change position based on direction
          switch(direction) {
               case UP:
                    y -= pieceLength;
                    break;
               case RIGHT:
                    x += pieceLength;
                    break;
               case DOWN:
                    y += pieceLength;
                    break;
               case LEFT:
                    x -= pieceLength;
                    break;
          }

          // if worm is smaller than 3 pieces, the worm should keep growing
          if(pieces.size() < 3) {
               shouldGrow = true;
          }

          pieces.add(new Piece(x,y)); // add the new piece to the worm

          if(shouldGrow) {
               shouldGrow = false; //don't remove a piece if the worm should grow
          } else {
               pieces.remove(0); //remove the first piece of the list if the worm shouldn't grow
          }
     }

     // set shouldGrow = true so that a piece isn't removed on the next move() call
     public void grow() {
          shouldGrow = true;
     }

     // check if the piece is on the same position as any Piece of the worm
     public boolean runsInto(Piece piece) {
          for(Piece wormPiece : pieces) {
               if(wormPiece.runsInto(piece)) {
                    return true;
               }
          }
          return false;
     }

     // check if any Piece of the worm is on the same position as another Piece of the worm
     public boolean runsIntoItself() {
          for(int i = 0, len = pieces.size(); i<len-1; ++i) {
               for(int j = i+1; j<len; ++j) {
                    if(pieces.get(i).runsInto(pieces.get(j))) {
                         return true;
                    }
               }
          }
          return false;
     }

     public void draw(Graphics graphics) {
          for(Piece piece : pieces) {
               graphics.fill3DRect(piece.getX(),piece.getY(),pieceLength,pieceLength,false);
          }
     }
}
