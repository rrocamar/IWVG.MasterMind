package masterMind.controllers;

import masterMind.models.*;

import java.util.ArrayList;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}

	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	public void tryCode(Permutation attemp) {
		assert attemp != null;
		game.tryCode(attemp);
        if (game.isBrokenSecretCode() || !game.moreAttemps()) {
			game.setState(State.FINAL);
		}
	}

    public Result getLastResult() {
        return game.getLastResult();
    }
	
	protected void clear() {
		game.clear();		
	}	

	public ArrayList<Result> getAttemps(){
		return  this.game.getAttemps();
	}

    public int getNumberOfAttemp() {
        return getAttemps().size() + 1;
    }

	public boolean isBrokenSecretCode() {
		return game.isBrokenSecretCode();
    }

    public String getSecret() {
        return game.getSecret();
    }

    protected void setMode(Mode mode) {
        this.game.setMode(mode);
    }

    public boolean moreAttemps() {
        return game.moreAttemps();
    }
}
