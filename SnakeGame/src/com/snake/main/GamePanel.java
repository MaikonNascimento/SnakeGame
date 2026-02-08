package com.snake.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.snake.model.Snake;

public class GamePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129974308297116576L;	
	
	private Timer timer = null;	
	private Snake snake = new Snake();
	private boolean gameOver = false;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private boolean showBlinkText = true;
    private boolean paused = false;
    private long lastBlinkTime = 0;
    private static final int BLINK_INTERVAL = 500; 

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
    	    @Override
    	    public void keyPressed(KeyEvent e) {
    	        switch (e.getKeyCode()) {
    	            case KeyEvent.VK_UP:
    	                snake.setDirection(0, -20);
    	                break;
    	            case KeyEvent.VK_DOWN:
    	                snake.setDirection(0, 20);
    	                break;
    	            case KeyEvent.VK_LEFT:
    	                snake.setDirection(-20, 0);
    	                break;
    	            case KeyEvent.VK_RIGHT:
    	                snake.setDirection(20, 0);
    	                break;
    	            case KeyEvent.VK_ENTER:
    	                if (gameOver) {
    	                    snake = new Snake();
    	                    gameOver = false;
    	                    timer.start();
    	                    paused = false;
    	                } else {
    	                	paused = !paused;
    	                }

    	                break;
    	        }
    	    }
    	});

        timer = new Timer(150, this);
        timer.start();
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	    g.setColor(Color.GREEN);

	    for (Point p : snake.getBody()) {
	    	 g.fillRect(p.x, p.y, 20, 20);
	    }

		if (gameOver) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			String textGameOver = "GAME OVER";
		    int textWidth = g.getFontMetrics().stringWidth(textGameOver);
		    g.drawString(textGameOver, (getWidth() - textWidth) / 2, getHeight() / 2);
		    if (showBlinkText) {
			    g.setFont(new Font("Arial", Font.BOLD, 20));
			    String textPressENTER = "Pressione ENTER para reiniciar";
			    int textWidth2 = g.getFontMetrics().stringWidth(textPressENTER);
			    g.drawString(textPressENTER, (getWidth() - textWidth2) / 2, getHeight() / 2 + 50);
		    }
		    return;
		 }
		
		if (paused && showBlinkText && !gameOver) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			String textPressEnter = "Pressione ENTER para continuar";
			int textWidth2 = g.getFontMetrics().stringWidth(textPressEnter);
		    g.drawString(textPressEnter, (getWidth() - textWidth2) / 2, getHeight() / 2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		long now = System.currentTimeMillis();

		if (now - lastBlinkTime >= BLINK_INTERVAL) {
			showBlinkText = !showBlinkText;
	    	lastBlinkTime = now;
		}

		if (gameOver) {
			repaint();
			return;
		}

		if (!paused) {
			snake.move();  
	
			if (snake.hitWall(getWidth(), getHeight())) {
		        gameOver = true;
		    }
		}

		repaint();
	}

}
