package boardGame;

/**
 *
 * @author Railan Santana Data: 11 de mai. de 2024
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)){
            throw new BoardException("Position not exists");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Position not exists");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    //adicionar uma peça
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position: "+position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    
    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not exists");
        }
        if (piece(position) == null){
            return null;
        }
        Piece pieceAux = piece(position);
        pieceAux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return pieceAux;
    }

    private Boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public Boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }
    
    //verificar se a peça existe
    public Boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not exists");
        }
        return piece(position) != null;
    }
}
