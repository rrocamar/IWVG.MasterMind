package masterMind.controllers;

import masterMind.models.Coordinate;
import masterMind.models.Game;

abstract class ColocateController extends OperationController {

	private CoordinateController coordinateController;

	protected ColocateController(Game game, 
			CoordinateController coordinateController) {
		super(game);
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}
	
	protected Error validateTarget(Coordinate target) {
		if (!this.empty(target)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

	public CoordinateController getCoordinateController(){
		return coordinateController;
	}

}
