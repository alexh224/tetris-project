package Tetris;
import java.awt.Point;

public class Block {
	
	public Point p = new Point(160,15);
	
	public int type;
	
	public boolean[][] blockCoords = {{false,false,false,false},
								      {false,false,false,false},
								      {false,false,false,false},
								      {false,false,false,false}};
	
	public Block(int x, int y) {
		p.x = x;
		p.y = y;
		type = (int)(Math.random()*7);
	}

}
