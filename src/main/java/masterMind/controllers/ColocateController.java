package masterMind.controllers;

import masterMind.models.Game;

abstract class ColocateController extends OperationController {

	private PermutationController permutationController;

	protected ColocateController(Game game, 
			PermutationController permutationController) {
		super(game);
		assert permutationController != null;
		this.permutationController = permutationController;
	}

	public PermutationController getPermutationController(){
		return permutationController;
	}

}
