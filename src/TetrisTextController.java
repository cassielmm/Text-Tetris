import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * TetrisTextController is a controller for the command line Tetris game
 * It takes input from the user, changes the model, and updates the view
 */

/**
 * @author cassielm
 * with help from Rock, Paper, Scissors example skeleton classes
 * and TA Emma
 */

public class TetrisTextController {
	
	//create an instance of the model
	TetrisGame model;
	
	//create an instance of the view
	TetrisTextView view;
	
	//create an instance of the scanner
	public Scanner scanner;
	
	/**
	 * Set up the model, view, and first input
	 */
	public static void main(String[] args) {

		TetrisTextController controller = new TetrisTextController();
		controller.model = new TetrisGame();
		controller.view = new TetrisTextView(controller.model.board);
		controller.view.getBoardView();
		controller.getInput();

	}
	
	/**
	 * Constructor
	 */
	public TetrisTextController() {

		super();

	}

	/**
	 * Updates model with user input
	 * @param key pressed
	 */
	public void updateModel(String key) {
			
		int[] pos = model.board.getCurrentPosition();
		boolean legal = model.legalMove(key, pos);
		
		//if the move is legal, move the piece
		if (legal) {
			if (key.equals("r")) {
				model.board.moveRight();
			}
			else if (key.equals("l")) {
				model.board.moveLeft();
			}
			else if (key.equals("d")) {
				model.board.moveDown();
			}
			else if (key.equals("x")) {
				model.board.getCurrentPiece().rotateCW();
			}
			else if (key.equals("z")) {
				model.board.getCurrentPiece().rotateCCW();
			}
			else {
				view.errorMessage();
			}
		}
		
		//if the piece can't go down any further, it has hit bottom
		//abandon the piece and make a new one
		if (!legal && key.equals("d")) {
			
			model.newPiece();
			
			//if the new piece can't enter the screen, game over
			if (!model.checkRotation(model.startPos[0], model.startPos[1],
									model.board.getCurrentPiece().pieceMatrix)) {
				scanner.close();
			}
			
		}
		
		model.checkForLineClear();
		
		updateView();
	
	}
	
	/**
	 * Updates view
	 */
	public void updateView() {

		view.getBoardView();
		getInput();

	}
	
	/**
	 * Gets user input
	 */	
	public void getInput() {
		
		//print options and scores
		view.turnMessage(model.getScore(), model.getTetrisScore());
		
		//get input from user
		scanner = new Scanner(System.in);
		String input =  scanner.next();
		
		try {
			//either quit
			if (input.equals("quit")) {
				scanner.close();
				view.endMessage(true);
			}
			// or send the input to the model
			else {
				updateModel(input);
			}
		}
		//if the player has lost, end the game
		catch (NoSuchElementException e) {
			view.endMessage(false);
		}
		
	}
	
}
