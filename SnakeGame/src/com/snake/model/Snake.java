package com.snake.model;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {

	private LinkedList<Point> body = new LinkedList<>();
    public static final int TILE_SIZE = 20;
    private int dx = TILE_SIZE;
    private int dy = 0;
    private boolean grow = false;
    
    public Snake() {
        body.add(new Point(100, 100));
    }
    
    
    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.x + dx, head.y + dy);
        body.addFirst(newHead);

        if (!grow) {
            body.removeLast();
        } else {
            grow = false;
        }
    }
    
    public LinkedList<Point> getBody() {
    	return body;
    }
    
    public void setDirection (int dx, int dy) {
        if (dx != 0 && this.dx != 0)
            return;

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
    public void grow(){
       grow = true;
    }
}
