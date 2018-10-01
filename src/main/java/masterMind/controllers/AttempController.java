package masterMind.controllers;

import masterMind.models.Game;
import masterMind.models.Permutation;

public abstract class AttempController extends OperationController {

	protected AttempController(Game game) {
		super(game);
	}

	public abstract Permutation getAttemp();


}
