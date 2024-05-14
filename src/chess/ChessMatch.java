package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;

/**
 *
 * @author Railan Santana
 * Data: 11 de mai. de 2024
 */
public class ChessMatch {
    private boardGame.Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
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
    
    private void initialSetup(){
        board.placePiece(new King(board, Color.BLACK), new Position(0, 0));
    }
    
    
}
