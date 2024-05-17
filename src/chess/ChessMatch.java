package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.King;
import boardGame.Board;
import chess.pieces.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Railan Santana Data: 11 de mai. de 2024
 */
public class ChessMatch {

    private Board board;
    private int turn;
    private Color currentPlayer;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.BLACK;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        if (capturedPiece != null) {
            capturedPieces.add(capturedPiece);
            piecesOnTheBoard.remove(capturedPiece);
        }
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("Piece not exists");
        }
        if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible movies for the chosen piece");
        }

    }

    private void validateTargetPosition(Position source, Position Target) {
        if (!board.piece(source).possibleMove(Target)) {
            throw new ChessException("The chosen piece can't move to target position.");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(ChessPiece piece, char column, int row) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
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
