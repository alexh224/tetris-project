package Tetris;

import java.awt.Color;

public class Block extends Piece 
{
	
	
	public Block(Color[] colors, int x, int y)
	{
		super(colors, x, y);
		
	}
	
	public void drawSquarePiece()
	{
		Piece square= new Piece(getColors(), size, size);
		
			square.drawPiece(p.x , p.y);
			square.drawPiece(p.x+30,p.y);
			square.drawPiece(p.x,p.y+30);
			square.drawPiece(p.x+30,p.y+30);
		
		
	}
	public void drawLine()
	{
		Piece line= new Piece(getColors(), size, size);
		
		line.drawPiece(p.x , p.y);
		line.drawPiece(p.x+30,p.y);
		line.drawPiece(p.x+60,p.y);
		line.drawPiece(p.x+90,p.y);
	}
	public void drawLBlock()
	{
Piece lBlock= new Piece(getColors(), size, size);
		
		lBlock.drawPiece(p.x , p.y);
		lBlock.drawPiece(p.x,p.y+size);
		lBlock.drawPiece(p.x,p.y+(size*2));
		lBlock.drawPiece(p.x+size,p.y+(size*2));
	}
	public void drawReverseLBlock()
	{
Piece ReverselBlock= new Piece(getColors(), size, size);
		
		ReverselBlock.drawPiece(p.x , p.y);
		ReverselBlock.drawPiece(p.x,p.y+size);
		ReverselBlock.drawPiece(p.x,p.y+(size*2));
		ReverselBlock.drawPiece(p.x-size,p.y+(size*2));
	}
	public void drawTBlock()
	{
Piece tBlock= new Piece(getColors(), size, size);
		
		tBlock.drawPiece(p.x , p.y);
		tBlock.drawPiece(p.x,p.y+size);
		tBlock.drawPiece(p.x+size,p.y+(size));
		tBlock.drawPiece(p.x-size,p.y+(size));
	}
	public void drawSBlock()
	{
Piece sBlock= new Piece(getColors(), size, size);
		
		sBlock.drawPiece(p.x , p.y);
		sBlock.drawPiece(p.x+size,p.y);
		sBlock.drawPiece(p.x,p.y+(size));
		sBlock.drawPiece(p.x-size,p.y+(size));
	}
	public void drawZBlock()
	{
Piece zBlock= new Piece(getColors(), size, size);
		
		zBlock.drawPiece(p.x , p.y);
		zBlock.drawPiece(p.x-size,p.y);
		zBlock.drawPiece(p.x,p.y+(size));
		zBlock.drawPiece(p.x+size,p.y+(size));
	}
	
	
	
}


