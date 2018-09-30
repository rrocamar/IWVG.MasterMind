package masterMind;

import masterMind.controllers.Logic;
import masterMind.controllers.OperationController;
import masterMind.views.MasterMIndView;

public class MasterMind {

	private Logic logic;
	
	private MasterMIndView view;
	
	public MasterMind() {
		logic = new Logic();
		view = new MasterMIndView();
	}
	
	public void play() {
		OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
		
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
