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
			io.writeln("Generado codigo secreto. 4 colores. ****");

	}

	void writeWinner() {
		IO io = new IO();
		io.writeln("Victoria!!!! " + "La clave ha sido descifrada!!" + "! Victoria!!!!");
	}

	void writeLoser(String secretCode) {
		IO io = new IO();
		io.writeln("Lo sentimos. Ha agotado el numero de intentos. La clave era: " + secretCode);
		io.writeln("	Vuelva a intentarlo.");
	}

}
