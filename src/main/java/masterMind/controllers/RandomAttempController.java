package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;
import masterMind.models.Permutation;

public class RandomAttempController extends AttempController {

	protected RandomAttempController(Game game) {
		super(game);
	}

	@Override
	public Permutation getAttemp() {
		Permutation attemp = new Permutation();
		attemp.random();;
		return attemp;
	}
}
