package chess;

import boardGame.Board;
import boardGame.Piece;

/**
 *
 * @author Railan Santana Data: 11 de mai. de 2024
 */
public class ChessPiece extends Piece{
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
