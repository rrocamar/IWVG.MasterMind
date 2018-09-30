package masterMind.views;

import masterMind.controllers.ContinueController;
import masterMind.controllers.PermutationController;
import masterMind.controllers.Error;
import masterMind.controllers.OperationController;
import masterMind.controllers.PutController;
import masterMind.controllers.RandomPermutationController;
import masterMind.controllers.StartController;
import masterMind.controllers.UserPermutationController;
import masterMind.models.Coordinate;
import masterMind.utils.IO;
import masterMind.utils.LimitedIntDialog;
import masterMind.utils.YesNoDialog;

public class TicTacToeView {

	private IO io = new IO();

	public void interact(OperationController controller) {
		assert controller != null;
		if (controller instanceof StartController) {
			this.interact((StartController) controller);
		} else if (controller instanceof PutController) {
			this.interact((PutController) controller);
		} else if (controller instanceof ContinueController) {
			this.interact((ContinueController) controller);
		}
	}

	private void interact(StartController startController) {
		io.writeln("1. Partida");
		io.writeln("2. Demo");
		int users = new LimitedIntDialog("Opción?", 0, 2).read();
		startController.setUsers(users);
		new BoardView(startController).write();
	}

	private void interact(PutController putController) {
		ColorView colorView = new ColorView(putController.take());
		colorView.writeln("Pone el jugador ");
		Coordinate target;
		Error error = null;
		do {
			target = this.getTarget("En",
					putController.getPermutationController());
			error = putController.validateTarget(target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		putController.put(target);
		new BoardView(putController).write();
		if (putController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	private Coordinate getTarget(String title,
			PermutationController permutationController) {
		if (permutationController instanceof UserPermutationController) {
			return this.getTarget(title,
					(UserPermutationController) permutationController);
		} else if (permutationController instanceof RandomPermutationController) {
			return this.getTarget(title,
					(RandomPermutationController) permutationController);
		}
		return null;
	}

	private Coordinate getTarget(String title,
			UserPermutationController coordinateController) {
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView(title, coordinate).read();
		return coordinate;
	}

	private Coordinate getTarget(String title,
			RandomPermutationController coordinateController) {
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView("La máquina pone en ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private Coordinate getOrigin(PermutationController permutationController) {
		if (permutationController instanceof UserPermutationController) {
			return this
					.getOrigin((UserPermutationController) permutationController);
		} else if (permutationController instanceof RandomPermutationController) {
			return this
					.getOrigin((RandomPermutationController) permutationController);
		}
		return null;
	}

	private Coordinate getOrigin(UserPermutationController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("De", coordinate).read();
		return coordinate;
	}

	private Coordinate getOrigin(RandomPermutationController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("La máquina quita de ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private Coordinate getTarget(String title,
								 PermutationController permutationController, Coordinate origin) {
		if (permutationController instanceof UserPermutationController) {
			return this.getTarget(title,
					(UserPermutationController) permutationController);
		} else if (permutationController instanceof RandomPermutationController) {
			return this.getTarget(title,
					(RandomPermutationController) permutationController, origin);
		}
		return null;
	}

	private Coordinate getTarget(String title,
								 RandomPermutationController coordinateController, Coordinate origin) {
		Coordinate coordinate = coordinateController.getTarget(origin);
		new CoordinateView("La máquina pone en ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private void interact(ContinueController continueController) {
		continueController.setContinue(new YesNoDialog("Desea continuar")
				.read());
	}

}
