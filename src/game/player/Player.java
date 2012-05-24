package game.player;

import game.grid.Grid;

public abstract class Player {
	private Player opponent;
	
	public Player getOpponent() {
		return opponent;
	}
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	public abstract int play(Grid g);

}
