package masterMind.models;

import java.util.ArrayList;
import java.util.Random;

public class Permutation implements Cloneable{

    public static final int NUMBER_OF_COLORS = 4;

    private ArrayList<Color> colors;

    public Permutation() {
        this.colors = new ArrayList<Color>();
    }

    public Permutation(Permutation permutation) {
        this.colors = new ArrayList<Color>(permutation.colors);
    }
    public void random() {
        Random random = new Random(System.currentTimeMillis());
        int numberOfColors = Color.values().length;
        while(!isCompleta()) {
            int randomColor = random.nextInt(numberOfColors);
            add(Color.values()[randomColor]);
        }

    }

    public void add(Color color){
        assert colors!=null;
        assert colors.size()<NUMBER_OF_COLORS;
        assert color != null;
        this.colors.add(color);
    }


    public void removeColor(int i){
        assert colors!=null;
        assert colors.size()>i;
        colors.set(i, null);
    }

    public void removeColor(Color color){
        removeColor(posicion(color));
    }

    public boolean isCompleta() {
        assert colors != null;
        return colors.size() == NUMBER_OF_COLORS;
    }

    public boolean contains(Color color){
        for(Color colorEnJugada:colors) {
            if (color.equals(colorEnJugada))
                return true;
        }
        return false;
    }

    public int posicion(Color color){
        assert contains(color);
        for(int i=0;i<this.size();i++) {
            if (color.equals(this.getColor(i)))
                return i;
        }
        return -1;
    }

    public Color getColor(int posicion){
        return this.colors.get(posicion);
    }

    public int size(){
        return this.colors.size();
    }

    @Override
    public String toString() {
        String result = "[";
        for (Color color : colors)
            result += color.getDescripcion() + ", ";
        return result + "]";
    }
}
