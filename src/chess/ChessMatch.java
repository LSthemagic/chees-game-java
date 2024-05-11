package chess;

import boardGame.Board;

/**
 *
 * @author Railan Santana
 * Data: 11 de mai. de 2024
 */
public class ChessMatch {
    private boardGame.Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }
    
    public ChessPiece[][] getPieces(){
        ChessPiece[][] matPiece = new ChessPiece[board.getRows()][board.getColumns()];
        
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matPiece[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        
        return matPiece;
    }
    
    
    
    
}
