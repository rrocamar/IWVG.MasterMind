package masterMind.controllers;

import masterMind.models.Game;

public class Logic {

	private Game game;

	private AttempController attempsController;
	
	private StartController startController;

	private ContinueController continueController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		attempsController = new RandomAttempController(game);
		continueController = new ContinueController(game);
	}

	public OperationController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return attempsController;
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
