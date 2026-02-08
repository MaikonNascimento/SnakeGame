package com.snake.model;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {

	private LinkedList<Point> body = new LinkedList<>();
    private int dx = 20;
    private int dy = 0;
    
    public Snake() {
        body.add(new Point(100, 100));
    }
    
    
    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.x + dx, head.y + dy);
        System.out.println("Moveu para X:" + dx + " Y:" + dy);
        body.addFirst(newHead);
        body.removeLast();
    }
    
    public LinkedList<Point> getBody() {
    	return body;
    }
    
    public void setDirection (int dx, int dy) {
    	this.dx = dx;
    	this.dy = dy;
    }

    public Point getHead() {
    	return body.getFirst();
    }
    
    public boolean hitWall(int width, int height) {
        Point head = body.getFirst();

        return head.x < 0 || head.y < 0 || head.x >= width || head.y >= height;
    }
    
}
