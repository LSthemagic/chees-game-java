package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 *
 * @author Railan Santana Data: 11 de mai. de 2024
 */
public class ChessMatch {

    private boardGame.Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matPiece = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matPiece[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return matPiece;
    }

    private void placeNewPiece(ChessPiece piece, char column, int row) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece(new Rook(board, Color.WHITE), 'c', 1);
        placeNewPiece(new Rook(board, Color.WHITE), 'c', 2);
        placeNewPiece(new Rook(board, Color.WHITE), 'd', 2);
        placeNewPiece(new Rook(board, Color.WHITE), 'e', 2);
        placeNewPiece(new Rook(board, Color.WHITE), 'e', 1);
        placeNewPiece(new King(board, Color.WHITE), 'd', 1);

        placeNewPiece(new Rook(board, Color.BLACK), 'c', 7);
        placeNewPiece(new Rook(board, Color.BLACK), 'c', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'd', 7);
        placeNewPiece(new Rook(board, Color.BLACK), 'e', 7);
        placeNewPiece(new Rook(board, Color.BLACK), 'e', 8);
        placeNewPiece(new King(board, Color.BLACK), 'd', 8);
    }

}
