package game.player;

import game.grid.Grid;

public class Computer extends Player {

	@Override
	public int play(Grid g) {
		return minimax(g, this, 0).intValue();
	}
	
	public Float score(Grid grid, Integer depth){
		if(grid.getWinner() == this){
			return 1F/depth;
		}
		if(grid.getWinner() == null){
			return 0F;
		}
		return -1F/depth;
	}
	
	public Float minimax(Grid grid, Player player, Integer depth){
		if(grid.isGameOver()){
			return score(grid, depth);
		}
		
		Integer bestMove = 0;
		Float bestScore = null;
		
		for(int move : grid.getValidMoves()){
			
			grid.makeMove(move, player);
			Float score = minimax(grid, player.getOpponent(), depth+1);
			grid.undoMove(move);
			
			if(bestScore == null ||
			  (player == this && bestScore < score) ||
			  (player != this && bestScore > score)) {
				
				bestScore = score;
				bestMove = move;
			}
		}
		return (depth == 0) ? bestMove : bestScore;
	}

}
