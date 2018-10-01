package masterMind.views;

import masterMind.controllers.OperationController;
import masterMind.models.Result;
import masterMind.utils.IO;

class BoardView {

	private OperationController controller;

	BoardView(OperationController controller) {
		assert controller != null;
		this.controller = controller;
	}

	void write() {
		IO io = new IO();
		Result result = controller.getLastResult();
		if (result != null)
			io.writeln("Heridos: " + result.getInjured() + " . Muertos: " + result.getDead());
		else
			io.writeln(controller.getSecret());

	}
}
