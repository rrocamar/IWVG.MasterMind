package masterMind.controllers;

import masterMind.models.Game;
import masterMind.models.State;
import masterMind.utils.ClosedInterval;

public class StartController extends OperationController {

	StartController(Game game) {
		super(game);
	}
	
	public void setUsers(int users){
		assert this.getState() == State.INITIAL;
		this.setState(State.IN_GAME);
	}

}
