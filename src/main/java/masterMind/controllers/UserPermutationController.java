package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;

public class UserPermutationController extends PermutationController {

	protected UserPermutationController(Game game) {
		super(game);
	}

	@Override
	public Coordinate getOrigin() {
		return new Coordinate();
	}

	@Override
	public Coordinate getTarget() {
		return new Coordinate();
	}
	
}
