package boardGame;

/**
 *
 * @author Railan Santana
 * Data: 11 de mai. de 2024
 */
public class Piece {
    protected Position position;
    protected Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
    
    
}
