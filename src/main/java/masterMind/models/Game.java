package masterMind.models;

public class Game {

	private State state;

	private Board board;
	
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
	
	public int getNumPlayers() {
		return NUM_PLAYERS;
	}
	
	public void put(Permutation permutation) {
		board.put(permutation);
	}

	public void clear() {
		board.clear();		
	}

	public boolean isBrokenSecretCode() {
		return board.isBrokenSecretCode();
	}
}
