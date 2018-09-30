package masterMind.controllers;

import masterMind.models.*;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	protected int numPlayers() {
		return game.getNumPlayers();
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	protected void put(Permutation permutation) {
		assert permutation != null;
		game.put(permutation);
		if (game.isBrokenSecretCode()) {
			game.setState(State.FINAL);
		}
	}
	
	protected void clear() {
		game.clear();		
	}	

	
	public boolean existTicTacToe() {
		return game.existTicTacToe();
	}	
	
	public Color getColor(Coordinate coordinate){
		assert coordinate != null;
		return game.getColor(coordinate);
	}
	
}
