package masterMind.views;

import masterMind.controllers.ContinueController;
import masterMind.controllers.AttempController;
import masterMind.controllers.Error;
import masterMind.controllers.OperationController;
import masterMind.controllers.RandomAttempController;
import masterMind.controllers.StartController;
import masterMind.controllers.UserAttempController;
import masterMind.models.Coordinate;
import masterMind.models.Permutation;
import masterMind.utils.IO;
import masterMind.utils.LimitedIntDialog;
import masterMind.utils.YesNoDialog;

public class MasterMIndView {

	private IO io = new IO();

	public void interact(OperationController controller) {
		assert controller != null;
		if (controller instanceof StartController) {
			this.interact((StartController) controller);
		} else if (controller instanceof AttempController) {
			this.interact((AttempController) controller);
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
/*
	private void interact(AttempController attempController) {
		ColorView colorView = new ColorView(attempController.take());
		colorView.writeln("Pone el jugador ");
		Coordinate target;
		Error error = null;
		do {
			target = this.getTarget("En",
					putController.getAttempController());
			error = putController.validateTarget(target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		putController.tryCode (target);
		new BoardView(putController).write();
		if (putController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	private Coordinate getTarget(String title,
			AttempController attempController) {
		if (attempController instanceof UserAttempController) {
			return this.getTarget(title,
					(UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this.getTarget(title,
					(RandomAttempController) attempController);
		}
		return null;
	}

	private Coordinate getTarget(String title,
			UserAttempController coordinateController) {
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView(title, coordinate).read();
		return coordinate;
	}
*/
	private Permutation getAttemp(String title,
								  RandomAttempController coordinateController) {
		Permutation attemp = coordinateController.getAttemp();
		new AttempView("La máquina pone: ", attemp).write();
		io.readString(". Pulse enter para continuar");
		return attemp;
	}

	private Coordinate getOrigin(AttempController attempController) {
		if (attempController instanceof UserAttempController) {
			return this
					.getOrigin((UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this
					.getOrigin((RandomAttempController) attempController);
		}
		return null;
	}

	private Coordinate getOrigin(UserAttempController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("De", coordinate).read();
		return coordinate;
	}

	private Coordinate getOrigin(RandomAttempController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("La máquina quita de ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private Coordinate getTarget(String title,
								 AttempController attempController, Coordinate origin) {
		if (attempController instanceof UserAttempController) {
			return this.getTarget(title,
					(UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this.getTarget(title,
					(RandomAttempController) attempController, origin);
		}
		return null;
	}

	private Coordinate getTarget(String title,
								 RandomAttempController coordinateController, Coordinate origin) {
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
