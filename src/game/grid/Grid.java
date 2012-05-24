package game.grid;

import java.util.ArrayList;
import java.util.List;

import game.player.Player;

public class Grid {
	
	private final Player EMPTY_POSITION = null;
	private final Integer[][] WINNING_COMBOS = {{0,1,2},{3,4,5},{6,7,8},
												{0,3,6},{1,4,7},{2,5,8},
												{0,4,8},{2,4,6}};
	private Player[] grid;
	private Player crosses = null;
	private Integer[] winningCombo = null;
	
	public Player getCrosses() {
		return crosses;
	}
	
	public void setOpponents(Player p1, Player p2){
		p1.setOpponent(p2);
		p2.setOpponent(p1);
	}

	public void setCrosses(Player crosses) {
		this.crosses = crosses;
	}
	
	public Grid(){
		grid = new Player[9];
	}

	public Player getWinner(){
		for(Integer[] combo : WINNING_COMBOS){
			if(grid[combo[0]] != null){
				if(grid[combo[0]] == grid[combo[1]] && grid[combo[0]] == grid[combo[2]]){
					this.setWinningCombo(combo);
					return grid[combo[0]];
				}
			}
		}
		return null;
	}
	
	public Integer[] getWinningCombo() {
		return winningCombo;
	}

	private void setWinningCombo(Integer[] winningCombo) {
		this.winningCombo = winningCombo;
	}

	public List<Integer> getValidMoves(){
		List<Integer> moves = new ArrayList<Integer>();
		
		for(int i = 0; i < grid.length; i++){
			if(grid[i] == EMPTY_POSITION){
				moves.add(i);
			}
		}
		return moves;
	}
	
	public Boolean isGameOver(){
		return this.getWinner() != null || this.getValidMoves().isEmpty();
	}
	
	public Boolean isMoveValid(Integer move){
		return grid[move] == EMPTY_POSITION;
	}
	
	public void makeMove(Integer move, Player player){
		if(this.isMoveValid(move)){
			grid[move] = player;
		}
	}
	
	public void undoMove(Integer move){
		grid[move] = EMPTY_POSITION;
	}
	
	public void print(){
		String sep = "|";
		for(int i = 0; i < grid.length; i++){
			if(grid[i] == EMPTY_POSITION){
				System.out.print(" ");
			}else{
				System.out.print((grid[i] == this.getCrosses()) ? "X" : "O");
			}
			if((i+1)%3 == 0){
				System.out.println();
			}else{
				System.out.print(sep);
			}
		}
		
	}
}
