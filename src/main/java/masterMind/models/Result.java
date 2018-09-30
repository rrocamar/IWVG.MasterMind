package masterMind.models;

public class Result {

    private int injured;

    private int dead;

    private Permutation secretCode;

    private Permutation tryCode;

    private int sizeOfCode;

    public Result(Permutation secretCode, Permutation tryCode){
        assert this.secretCode.size() == tryCode.size();
        this.injured = 0;
        this.dead = 0;
        this.secretCode = secretCode;
        this.tryCode = tryCode;
        this.sizeOfCode = this.secretCode.size();
        this.compare();
    }

    private void compare(){
        Permutation copySecret = new Permutation(secretCode);
        injured = 0;
        dead = 0;
        for(int i=0;i<4;i++) {
            if(tryCode.getColor(i).equals(copySecret.getColor(i))) {
                dead++;
                copySecret.removeColor(i);
            }
        }
        for(int i=0;i<4;i++) {
            if(copySecret.contains(tryCode.getColor(i))) {
                injured++;
                copySecret.removeColor(tryCode.getColor(i));
            }
        }
    }

    public int getInjured() {
        return injured;
    }

    public int getDead() {
        return dead;
    }
}
