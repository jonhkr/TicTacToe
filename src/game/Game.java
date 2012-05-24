package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import game.grid.Grid;
import game.player.Computer;
import game.player.Human;
import game.player.Player;
import game.ui.GameWindow;

public class Game implements ActionListener{

	private static Player human;
	private static Player computer;
	private static Grid grid;
	private static GameWindow window;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		human = new Human();
		computer = new Computer();
		grid = new Grid();
		grid.setOpponents(human, computer);
		window = new GameWindow();
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = ((JButton)e.getSource());
			Integer index = window.getButtonIndex(btn);
			grid.makeMove(index, human);
			btn.setText("X");
			btn.setEnabled(false);
			
			if(!grid.isGameOver()){
				int cmove = computer.play(grid);
				grid.makeMove(cmove, computer);
				JButton bcmove = window.getButton(cmove);
				bcmove.setText("O");
				bcmove.setEnabled(false);
			}
			if(grid.isGameOver()){
				if(grid.getWinner() != null){
					for(int i : grid.getValidMoves()){
						window.getButton(i).setEnabled(false);
					}
					for(int i : grid.getWinningCombo()){
						window.getButton(i).setBackground(Color.GRAY);
					}
				}
			}
		}
	}

}
