package com.snake.main;

import javax.swing.JFrame;

public class SnakeGame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Welcome to SnakeGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
