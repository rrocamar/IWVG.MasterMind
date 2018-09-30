package masterMind.controllers;

import masterMind.models.Game;

public class Logic {

	private Game game;

	private ColocateController colocateController;
	
	private StartController startController;

	private ContinueController continueController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		colocateController = new ColocateControllerBuilder(game);
		continueController = new ContinueController(game);
	}

	public OperationController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return colocateControllerBuilder.getColocateController();
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
