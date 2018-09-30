package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;

public abstract class PermutationController extends Controller {

	protected PermutationController(Game game) {
		super(game);
	}

	public abstract Coordinate getOrigin();
	
	public abstract Coordinate getTarget();

}
