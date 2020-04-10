package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	//Without set because the piece can't have the color changed during the match

}
