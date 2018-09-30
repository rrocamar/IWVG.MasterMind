package masterMind.views;

import masterMind.models.Permutation;
import masterMind.models.Result;
import masterMind.utils.IO;

class AttempView {
    private Permutation attemp;

    private IO io;

    AttempView(Permutation attemp) {
        this.attemp = attemp;
        io = new IO();
    }

    void write(String title) {
        io.write(title + this.toChar());
    }

    void writeln(String title) {
        this.write(title);
        io.writeln();
    }

    void writeWinner() {
        io.writeln("Victoria!!!! " + this.toChar() + "! " + this.toChar()
                + "! " + this.toChar() + "! Victoria!!!!");
    }

    private char toChar() {
        return COLORS[color.ordinal()];
    }
}
