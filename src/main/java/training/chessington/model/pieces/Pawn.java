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
        //creates a list of allowed places the pawn can move to
        List<Move> allowedMoves = new ArrayList<>();
        //the pawn can move one forward
        if (this.getColour() == PlayerColour.WHITE){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() -1, from.getCol()))));
        }
        if (this.getColour() == PlayerColour.BLACK){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() +1, from.getCol()))));
        }
        //the pawn can move two forward if it has not moved yet
        if(this.getColour() == PlayerColour.WHITE && from.getRow() == 6){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() -2, from.getCol()))));
        }
        if(this.getColour() == PlayerColour.BLACK && from.getRow() == 1){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() +2, from.getCol()))));
        }
        return allowedMoves;
    }
}
