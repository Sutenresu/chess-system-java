package chess;

import boardgame.BoardException;
//Makes easy to use catch in the higher level application, as ChessException is in fact a kind of BoardException

public class ChessException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}
}
