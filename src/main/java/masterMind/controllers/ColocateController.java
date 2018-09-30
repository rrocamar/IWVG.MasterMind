package masterMind.controllers;

import masterMind.models.Game;

abstract class ColocateController extends OperationController {

	private AttempController attempController;

	protected ColocateController(Game game, 
			AttempController attempController) {
		super(game);
		assert attempController != null;
		this.attempController = attempController;
	}

	public AttempController getAttempController(){
		return attempController;
	}

}
