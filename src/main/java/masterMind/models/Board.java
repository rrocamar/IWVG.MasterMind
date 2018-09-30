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

	public int getAttemps(){
		return attemps.size();
	}

	public void tryCode(Permutation code) {
		lastResult = new Result(secretCode,code);
		attemps.add(lastResult);
	}

	boolean isBrokenSecretCode() {
		return false;
	}

	void clear() {
		this.attemps = new ArrayList<Result>();
		this.secretCode = new Permutation();
		this.secretCode.random();
	}

}
