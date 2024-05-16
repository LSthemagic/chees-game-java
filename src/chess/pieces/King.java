package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author Railan Santana Data: 13 de mai. de 2024
 */
public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
