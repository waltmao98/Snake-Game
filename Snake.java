import java.util.ArrayList;
import java.util.*;
import java.awt.Graphics;

public class Snake {

     private int pieceLength;
     private int x; // x position of the head of the snake
     private int y; // y position of the head of the snake
     private Direction direction; // direction of the head of the snake
     private List<Piece> pieces; // list of pieces that make up the snake. Last Piece of the list is the head
     private boolean shouldGrow; // determines whether or not the snake should grow during the next move()
     private int frameWidth;
     private int frameHeight;

     public Snake(int originalX, int originalY, Direction originalDirection, int pieceLength) {
          this.pieceLength = pieceLength;

          x = originalX;
          y = originalY;
          direction = originalDirection;

          pieces = new ArrayList<Piece>();
          Piece piece  = new Piece(originalX,originalY,pieceLength);
          pieces.add(piece);
     }

     public int getX() {
          return x;
     }

     public int getY() {
          return y;
     }

     public void setX(int x) {
          this.x = x;
     }

     public void setY(int y) {
          this.y = y;
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
                    y -= 1.1* pieceLength;
                    break;
               case RIGHT:
                    x += 1.1* pieceLength;
                    break;
               case DOWN:
                    y += 1.1* pieceLength;
                    break;
               case LEFT:
                    x -= 1.1* pieceLength;
                    break;
          }

          // if snake is smaller than 3 pieces, the snake should keep growing
          if(pieces.size() < 3) {
               shouldGrow = true;
          }

          pieces.add(new Piece(x,y,pieceLength)); // add the new piece to the snake

          if(shouldGrow) {
               shouldGrow = false; //don't remove a piece if the snake should grow
          } else {
               pieces.remove(0); //remove the first piece of the list if the snake shouldn't grow
          }
     }

     // set shouldGrow = true so that a piece isn't removed on the next move() call
     public void grow() {
          shouldGrow = true;
     }

     // check if the piece is on the same position as any Piece of the snake
     public boolean runsInto(Piece piece) {
          for(Piece snakePiece : pieces) {
               if(snakePiece.runsInto(piece)) {
                    return true;
               }
          }
          return false;
     }

     // check if any Piece of the snake is on the same position as another Piece of the snake
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
