package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;
import masterMind.models.Permutation;

public class UserAttempController extends AttempController {

	protected UserAttempController(Game game) {
		super(game);
	}

	@Override
	public Permutation getAttemp() {
		return new Permutation();
	}
	
}
