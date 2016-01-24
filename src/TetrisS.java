/**
 * TetrisS gives an S piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisS extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisS() {
		pieceMatrix = getPieceMatrixR1();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] {
			{false, true, true, false},
			{true, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] {
			{true, false, false, false},
			{true, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] {
			{false, true, true, false},
			{true, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] {
			{true, false, false, false},
			{true, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };	
	}
	
}
