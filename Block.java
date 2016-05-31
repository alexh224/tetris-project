package Tetris;
import java.awt.Point;

public class Block {
	
	public Point p = new Point(0,0);
	public int type;
	public boolean isFalling;
	public boolean[][] blockCoords = new boolean[4][4];
	
	public Block(int x, int y) {
		p.x = x;
		p.y = y;
		type = (int)(Math.random()*7);
		isFalling = true;
	}

}
