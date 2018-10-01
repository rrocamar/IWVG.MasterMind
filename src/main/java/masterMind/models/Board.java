package masterMind.models;

import java.util.*;

class Board {

	ArrayList<Result> attemps;

	Permutation secretCode;

	Result lastResult;

	int MAX_TURNS = 10;

	public Board(){
		this.attemps = new ArrayList<Result>();
		this.secretCode = new Permutation();
		this.secretCode.random();
	}

	public boolean endGame(){
		return attemps.size()==MAX_TURNS || isBrokenSecretCode();
	}

	public ArrayList<Result> getAttemps(){
		return attemps;
	}

	public void tryCode(Permutation code) {
		lastResult = new Result(secretCode,code);
		attemps.add(lastResult);
	}

	boolean isBrokenSecretCode() {
		return lastResult.getDead() == secretCode.size();
	}

	void clear() {
		this.attemps = new ArrayList<Result>();
		this.secretCode = new Permutation();
		this.secretCode.random();
	}

	public Result getLastResult() {
		return lastResult;
	}

	public boolean isFull() {
		return getAttemps().size() >= MAX_TURNS;
	}
}
