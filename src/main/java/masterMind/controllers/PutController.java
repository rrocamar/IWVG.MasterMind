package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;

public class PutController extends ColocateController {

	PutController(Game game, PermutationController permutationController) {
		super(game, permutationController);
	}

	@Override
	public void put(Coordinate target) {
		assert this.validateTarget(target) == null;
		super.put(target);
	}
	
	public Error validateTarget(Coordinate target) {
		return super.validateTarget(target);
	}
}
