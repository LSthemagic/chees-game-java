package boardGame;

/**
 *
 * @author Railan Santana
 * Data: 11 de mai. de 2024
 */
public abstract class Piece {
    protected Position position;
    protected Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
    
    public abstract boolean[][] possibleMoves();
    
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
}
