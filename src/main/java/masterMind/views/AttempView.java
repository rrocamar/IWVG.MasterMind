package masterMind.views;

import masterMind.models.Color;
import masterMind.models.Permutation;
import masterMind.utils.IO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AttempView {

    private Permutation attemp;

    private int numberOfAttemps;

    private IO io;

    AttempView(int numberOfAttemps, Permutation attemp) {
        this.numberOfAttemps = numberOfAttemps;
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
        Pattern pattern = Pattern.compile("([ARVZBN]){4}");
        Matcher matcher;
        do {
            colors = io.readString("Intento: " + numberOfAttemps + " [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]?");
            matcher = pattern.matcher(colors);
        } while (!matcher.find());
        for (char color : colors.toCharArray())
            switch (color) {
                case 'A':
                    attemp.add(Color.AMARILLO);
                    break;
                case 'Z':
                    attemp.add(Color.AZUL);
                    break;
                case 'B':
                    attemp.add(Color.BLANCO);
                    break;
                case 'N':
                    attemp.add(Color.NEGRO);
                    break;
                case 'R':
                    attemp.add(Color.ROJO);
                    break;
                case 'V':
                    attemp.add(Color.VERDE);
                    break;

            }


    }

    void writeWinner() {
        io.writeln("Victoria!!!! " + "La clave ha sido descifrada!!" + "! Victoria!!!!");
    }
}
