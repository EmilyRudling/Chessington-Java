package training.chessington.model;

import org.junit.Test;

import static training.chessington.model.pieces.Piece.PieceType.PAWN;
import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    @Test
    public void canMovePawnOneSpace() {
        // Arrange
        Board board = Board.forNewGame();

        Coordinates from = new Coordinates(6, 0);
        Coordinates to = new Coordinates(5, 0);

        // Act
        board.move(from, to);

        // Assert
        assertThat(board.get(from)).isNull();
        assertThat(board.get(to)).isColour(PlayerColour.WHITE).isPiece(PAWN);
    }
}
