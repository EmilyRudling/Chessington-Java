package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        if (this.getColour() == PlayerColour.WHITE){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() -1, from.getCol()))));
        }
        if (this.getColour() == PlayerColour.BLACK){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() +1, from.getCol()))));
        }
        return allowedMoves;
    }





    public void CanMovePawn(Coordinates to, Coordinates from){
        //checks if it is an allowed move
        //if it is one square, MovePawnOne, if two MovePawnTwo
    }

    public void MovePawnOne(Coordinates to, Coordinates from){
        //moves the pawn to the correct place
        //if the space was occupied by an enemy piece, remove it from the board
    }

    public void MovePawnTwo(Coordinates to, Coordinates from){
        //moves the pawn to the correct place
        //if the space was occupied by an enemy piece, remove it from the board
    }
}
