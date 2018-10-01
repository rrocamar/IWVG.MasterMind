package masterMind.views;

import masterMind.models.Coordinate;
import masterMind.models.Permutation;
import masterMind.utils.IO;
import masterMind.utils.LimitedIntDialog;

class AttempReadView {
	
	private String title;

	private Permutation attemp;
	
	private IO io;

	AttempReadView(String title, Permutation attemp) {
		assert title != null;
		assert attemp != null;
		this.title = title;
		this.attemp = attemp;
		io = new IO();
	}

	void read() {
		String colors;
		do {
			colors = io.readString("Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]?");

		} while (false);
		//attemp.add();
	}


}
