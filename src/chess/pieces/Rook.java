package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author Railan Santana Data: 13 de mai. de 2024
 */
public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

}
