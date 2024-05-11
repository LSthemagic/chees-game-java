package aplication;

import chess.ChessMatch;
/**
 *
 * @author Railan Santana
 * Data: 11 de mai. de 2024
 */
public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
