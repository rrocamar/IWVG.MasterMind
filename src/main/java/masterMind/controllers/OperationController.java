package masterMind.controllers;

import masterMind.models.Game;

public abstract class OperationController extends Controller {

	protected OperationController(Game game) {
		super(game);
	}

}
