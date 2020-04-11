package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][]mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow()-1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				//Only will have the possibility of the longer move if the shorter exists
				p.setValues(position.getRow()-2, position.getColumn());
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//enPassant
			if(position.getRow()==3) {
				Position passant = new Position(position.getRow(),position.getColumn()-1);
				if(getBoard().positionExists(passant) && isThereOpponentPiece(passant) && getBoard().piece(passant)==chessMatch.getEnPassantVulnerable())
					mat[passant.getRow()-1][passant.getColumn()] = true;
				passant = new Position(position.getRow(),position.getColumn()+1);
				if(getBoard().positionExists(passant) && isThereOpponentPiece(passant) && getBoard().piece(passant)==chessMatch.getEnPassantVulnerable())
					mat[passant.getRow()-1][passant.getColumn()] = true;
			}
			
		}else {
			p.setValues(position.getRow()+1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				//Only will have the possibility of the longer move if the shorter exists
				p.setValues(position.getRow()+2, position.getColumn());
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
			p.setValues(position.getRow()+1, position.getColumn()-1);
			if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()+1, position.getColumn()+1);
			if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}	
			
			//enPassant
			if(position.getRow()==4) {
				Position passant = new Position(position.getRow(),position.getColumn()-1);
				if(getBoard().positionExists(passant) && isThereOpponentPiece(passant) && getBoard().piece(passant)==chessMatch.getEnPassantVulnerable())
					mat[passant.getRow()+1][passant.getColumn()] = true;
				passant = new Position(position.getRow(),position.getColumn()+1);
				if(getBoard().positionExists(passant) && isThereOpponentPiece(passant) && getBoard().piece(passant)==chessMatch.getEnPassantVulnerable())
					mat[passant.getRow()+1][passant.getColumn()] = true;
			}
		}
		
		return mat;
	}

}
