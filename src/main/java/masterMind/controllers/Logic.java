package masterMind.controllers;

import masterMind.models.Game;
import masterMind.models.Mode;

public class Logic {

	private Game game;

	private AttempController attempsController;
	
	private StartController startController;

	private ContinueController continueController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		continueController = new ContinueController(game);
	}

	public OperationController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			if (attempsController == null) {
				if (game.getMode().equals(Mode.DEMO))
					attempsController = new RandomAttempController(game);
				else
					attempsController = new UserAttempController(game);
			}
			return attempsController;
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
