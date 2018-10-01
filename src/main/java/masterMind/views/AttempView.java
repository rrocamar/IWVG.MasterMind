package masterMind.views;

import masterMind.models.Permutation;
import masterMind.utils.IO;

class AttempView {
    private Permutation attemp;

    private IO io;

    AttempView(Permutation attemp) {
        this.attemp = attemp;
        io = new IO();
    }

    void write(String title) {
        io.write(title + ": " + attemp.toString());
    }

    void writeln(String title) {
        this.write(title);
        io.writeln();
    }

    void read() {
        String colors;
        do {
            colors = io.readString("Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]?");
        } while (false);
        attemp.random();
    }

    void writeWinner() {
        io.writeln("Victoria!!!! " + "La clave ha sido descifrada!!" + "! Victoria!!!!");
    }
}
