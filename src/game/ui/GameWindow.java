package game.ui;

import game.Game;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7194802526304049251L;
	
	private JButton[] btn = new JButton[9];
	
	public GameWindow(){
		super("TicTacToe");
		
		this.setSize(200, 200);
		this.setLayout(new GridLayout(3,3));
		
		ActionListener l = new Game();
		for(int i = 0; i < btn.length; i++){
			btn[i] = new JButton();
			btn[i].addActionListener(l);
			this.add(btn[i]);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Integer getButtonIndex(JButton button){
		for(int i = 0; i < btn.length; i++){
			if(button.equals(btn[i])){
				return i;
			}
		}
		return -1;
	}
	
	public JButton getButton(int index){
		return btn[index];
	}
}
