package masterMind.models;

import java.util.*;

import masterMind.utils.Direction;

class Board {

	ArrayList<Permutation> permutations;

	Permutation secretCode;

	int MAX_TURNS = 10;

	public Board(){
		this.permutations = new ArrayList<Permutation>();
		this.secretCode = new Permutation();
		this.secretCode.random();
	}

	public boolean endGame(){
		return permutations.size()==MAX_TURNS || isBrokenSecretCode();
	}

	public int getPermutations(){
		return permutations.size();
	}

	public void introducirJugada(Jugada jugada) {
		jugadas.add(jugada);
	}

	boolean isBrokenSecretCode() {
		return false;
	}

	void put(Permutation permutation) {
		assert permutation != null;
		permutations.add(permutation);
	}



	void clear() {
		this.permutations = new ArrayList<Permutation>();
		this.secretCode = new Permutation();
		this.secretCode.random();
	}

}
