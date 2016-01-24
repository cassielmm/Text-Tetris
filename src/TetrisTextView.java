/**
 * TetrisTextView is the view for the command line game of Tetris
 * It displays information and receives updates from the controller
 */

/**
 * @author cassielm
 *
 */
public class TetrisTextView {
	
	private TetrisBoard board;
	
	private String lineBreak = "====================";
	
	private String input;
	
	/**
	 * Constructor for TetrisTextView
	 */
	public TetrisTextView(TetrisBoard b) {

		board = b;

	}
	
	/**
	 * Called by the controller
	 * Prints out string with the board and the currentPiece
	 */
	public void getBoardView() {
		
		int row = board.getCurrentPosition()[0];
		int col = board.getCurrentPosition()[1];
		
		System.out.println(lineBreak);
		
		for (int i = 0; i < board.getNumRows(); i++){
			String line = "";
			for (int j = 0; j < board.getNumCols(); j++) {
				if (board.boardMatrix[i][j] == true) {
					line+="x";
				}
				else if (i >= row && i <= row+3 && j >= col && j <= col+3) {
					if (board.getCurrentPiece().pieceMatrix[i-row][j-col] == true) {
							line+="x";
						}
					else {
						line+=" ";
						}
					}
				else {
						line+=" ";
				}
				
			}
			System.out.println(line);
			line="";
		}
		System.out.println(lineBreak);
		
	}
	
	/**
	* Print the information at the beginning of each turn
	* Key options and scores
	*/
	public void turnMessage(int score, int tetrisScore) {
		
		System.out.println("Enter an option: l, r, d, x, z, quit");
		System.out.println("Lines cleared: "+score);
		System.out.println("Tetrises cleared: "+tetrisScore);
	
	}
	
	/**
	* Prints an ending message
	* Different if player says exit or if player loses
	*/
	public void endMessage(boolean voluntaryExit) {
		
		System.out.println(lineBreak);
		String message = "";
		if (!voluntaryExit) {
			message+="You've lost. ";
		}
		message+="Thank you for playing!";
		System.out.println(message);
		System.out.println(lineBreak);
	}
	
	/**
	* Prints an error message
	*/
	public void errorMessage() {
		System.out.println("Unrecognized symbol.");
	}
	
	/**
	* Getter
	*/
	public String getInput() {
		return input;
	}
	
}
