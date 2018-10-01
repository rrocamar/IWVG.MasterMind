package masterMind.views;

import masterMind.controllers.ContinueController;
import masterMind.controllers.AttempController;
import masterMind.controllers.Error;
import masterMind.controllers.OperationController;
import masterMind.controllers.RandomAttempController;
import masterMind.controllers.StartController;
import masterMind.controllers.UserAttempController;
import masterMind.models.Permutation;
import masterMind.utils.IO;
import masterMind.utils.LimitedIntDialog;
import masterMind.utils.YesNoDialog;

public class MasterMindView {

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

	private void interact(AttempController attempController) {
		AttempView attempView = new AttempView(attempController.getAttemp());
		attempView.writeln("Pone el jugador ");
		Permutation attemp = attempController.getAttemp();

		attempController.tryCode(attemp);
		new BoardView(attempController).write();
		if (attempController.isBrokenSecretCode()) {
			attempView.writeWinner();
		}
	}

	private Permutation getAttemp(String title,
								  AttempController attempController) {
		if (attempController instanceof UserAttempController) {
			return this.getAttemp(title,
					(UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this.getAttemp(title,
					(RandomAttempController) attempController);
		}
		return null;
	}

	private Permutation getAttemp(String title,
								  UserAttempController coordinateController) {
		Permutation coordinate = coordinateController.getAttemp();
		new AttempReadView(title, coordinate).read();
		return coordinate;
	}

	private Permutation getAttemp(String title,
								  RandomAttempController coordinateController) {
		Permutation attemp = coordinateController.getAttemp();
		new AttempView(attemp).write("La máquina pone: ");
		io.readString(". Pulse enter para continuar");
		return attemp;
	}

	private Permutation getAttemp(AttempController attempController) {
		if (attempController instanceof UserAttempController) {
			return this
					.getAttemp((UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this
					.getAttemp((RandomAttempController) attempController);
		}
		return null;
	}


	private void interact(ContinueController continueController) {
		continueController.setContinue(new YesNoDialog("Desea continuar")
				.read());
	}

}
