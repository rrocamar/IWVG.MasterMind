package masterMind.models;

import java.util.ArrayList;

public class Game {

	private State state;

	private Board board;

    private Mode mode;

	public Game() {
		state = State.INITIAL;
		board = new Board();
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}

	public void tryCode(Permutation attemp) {
		board.tryCode(attemp);
	}

	public void clear() {
		board.clear();		
	}

	public boolean isBrokenSecretCode() {
		return board.isBrokenSecretCode();
	}

	public ArrayList<Result> getAttemps() {
		return board.getAttemps();
	}

	public Result getLastResult() {
		return board.getLastResult();
	}

	public String getSecret() {
		return board.secretCode.toString();
	}

	public Mode getMode() {
		return mode;
	}

	public boolean moreAttemps() {
		return !board.isFull();
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
