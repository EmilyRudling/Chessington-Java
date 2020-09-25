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
        allowMoveForwardOne(allowedMoves, from);
        allowMoveForwardTwoIfFirstMove(allowedMoves, from);
        checkForPieceInFront(from, board, allowedMoves);
        isPawnAtTop(allowedMoves, from);
        return allowedMoves;
    }
    private void allowMoveForwardOne(List<Move> allowedMoves, Coordinates from){
        if (this.getColour() == PlayerColour.WHITE){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() -1, from.getCol()))));
        }
        if (this.getColour() == PlayerColour.BLACK){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() +1, from.getCol()))));
        }
    }
    private void allowMoveForwardTwoIfFirstMove(List<Move> allowedMoves, Coordinates from){
        if(this.getColour() == PlayerColour.WHITE && from.getRow() == 6){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() -2, from.getCol()))));
        }
        if(this.getColour() == PlayerColour.BLACK && from.getRow() == 1){
            allowedMoves.add(new Move(from, (new Coordinates(from.getRow() +2, from.getCol()))));
        }
    }
    private void checkForPieceInFront(Coordinates from, Board board, List<Move> allowedMoves){
        if (this.getColour() == PlayerColour.WHITE && board.get(from.plus(-1,0))!=null){
            allowedMoves.clear();
        }
        if (this.getColour() == PlayerColour.BLACK && board.get(from.plus(+1,0))!=null){
            allowedMoves.clear();
        }
    }
    private void isPawnAtTop(List<Move> allowedMoves, Coordinates from) {
        if (this.getColour() == PlayerColour.WHITE && from.getRow() == 0){
            allowedMoves.clear();
        }
        if (this.getColour() == PlayerColour.BLACK && from.getRow() == 7){
            allowedMoves.clear();
        }
    }
}
