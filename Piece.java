package Tetris;
import java.awt.*;

public class Piece 
{
protected final int size=30;
protected Point p = new Point(0,160);
private Color[] colors={Color.YELLOW,Color.BLUE,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.CYAN};


	
	public Piece(Color[] colors,int x,int y)
	{
		this.colors=colors;
		p.x = x;
		p.y = y;
		
	}
	public Color[] getColors() {
		return colors;
	}
	public void setColors(Color[] colors) {
		this.colors = colors;
	}
	public void drawPiece(int x,int y)
	{
		g.drawRect(x,y,size,size);
	}

}
