package masterMind.views;

import masterMind.controllers.ContinueController;
import masterMind.controllers.AttempController;
import masterMind.controllers.Error;
import masterMind.controllers.OperationController;
import masterMind.controllers.RandomAttempController;
import masterMind.controllers.StartController;
import masterMind.controllers.UserAttempController;
import masterMind.models.Mode;
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
		int mode = new LimitedIntDialog("Opción?", 1, 2).read();
		startController.setMode(mode == 1 ? Mode.PLAYER : Mode.DEMO);
		new BoardView(startController).write();
	}

	private void interact(AttempController attempController) {
		Permutation attemp = this.getAttemp(attempController);
        attempController.tryCode(attemp);
		BoardView boardView = new BoardView(attempController);
		boardView.write();
		if (attempController.isBrokenSecretCode()) {
			boardView.writeWinner();
		}
		/*else
			if(!attempController.isMoreAttemps()){
				boardView.writeWinner();
			}
				*/
	}

	private Permutation getAttemp(AttempController attempController) {
		if (attempController instanceof UserAttempController) {
			return this.getAttemp((UserAttempController) attempController);
		} else if (attempController instanceof RandomAttempController) {
			return this.getAttemp((RandomAttempController) attempController);
		}
		return null;
	}


	private Permutation getAttemp(RandomAttempController attempController) {
		Permutation attemp = attempController.getAttemp();
		attemp.random();
		io.write("La máquina pone: " + attemp);
		io.readString(". Pulse enter para continuar");
		return attemp;
	}

	private Permutation getAttemp(UserAttempController attempController) {
		Permutation attemp = attempController.getAttemp();
		AttempView attempView = new AttempView(attempController.getNumberOfAttemps(), attemp);
		attempView.read();
		return attemp;
	}


	private void interact(ContinueController continueController) {
		continueController.setContinue(new YesNoDialog("Desea continuar")
				.read());
	}

}
