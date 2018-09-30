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
		for(Result result:controller.getAttemps()){
			/*
				new ColorView(controller. ))
						.write(" ");
			*/
			}
			io.writeln();
		}
	}

