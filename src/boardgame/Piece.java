package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board; 
	//To make the relation between Board and Piece and evalue the moves
	//# means protected.
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	//The layer information in the project tell us that this relationship should not be seen to the above classes
	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				if(mat[i][j])
					return true;
			}
		}
		return false;
	}
}
