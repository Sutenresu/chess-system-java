package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Piece {
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

	public List<Piece> possibleMoves(){
		List<Piece> p = new ArrayList<>();
		return p;
	}
	public boolean possibleMove(Position position) {
		return true;

	}
	
	public boolean isThereAnyPossibleMove() {
		return false;
	}
}
