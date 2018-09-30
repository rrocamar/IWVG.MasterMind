package masterMind.views;

import masterMind.controllers.OperationController;
import masterMind.models.Coordinate;
import masterMind.utils.IO;

class BoardView {

	private OperationController controller;

	BoardView(OperationController controller) {
		assert controller != null;
		this.controller = controller;
	}

	void write() {
		IO io = new IO();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				new ColorView(controller.getColor(new Coordinate(i, j)))
						.write(" ");
			}
			io.writeln();
		}
	}
}
