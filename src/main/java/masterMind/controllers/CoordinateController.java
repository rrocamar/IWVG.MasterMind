package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;

public abstract class CoordinateController extends Controller {

	protected CoordinateController(Game game) {
		super(game);
	}

	public abstract Coordinate getOrigin();
	
	public abstract Coordinate getTarget();

}
