package masterMind.controllers;

import masterMind.models.Game;
import masterMind.models.Permutation;

public abstract class AttempController extends OperationController {

	private AttempController attempController;

	protected AttempController(Game game) {
		super(game);
	}

	protected AttempController(Game game,
							   AttempController attempController) {
		super(game);
		assert attempController != null;
		this.attempController = attempController;
	}

	public AttempController getAttempController() {
		return attempController;
	}

	public abstract Permutation getAttemp();


}
