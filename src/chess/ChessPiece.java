package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

/**
 *
 * @author Railan Santana Data: 11 de mai. de 2024
 */
public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
