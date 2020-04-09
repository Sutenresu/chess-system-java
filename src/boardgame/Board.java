package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows <1||columns<1) {
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
		if (!positionExists(row,column)) {
			throw new BoardException("Position off-board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position off-board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//As was stated in the project specific methods to insert and modify pieces, we will not use getset
	public void placePiece(Piece piece, Position position){
		if(thereIsAPiece(position)) {
			throw new BoardException("There's already a piece on position "+position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;//protected can be accessed in the same package
	}
	
	private boolean positionExists(int row,int column) {
		return row >=0 && row<rows && column>=0 &&column<columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position off-board");
		}		
		return (piece(position) != null);
	}
}
