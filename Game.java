package Tetris;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Game extends JPanel {

	public static final int sizeX = 520;
	public static final int sizeY = 600;
	public static Point p = new Point(0, 160);
	public static final int pieceSize = 30;
	
	public static Block curBlock = new Block(160,15);
	private Color[] colors = { Color.YELLOW, Color.BLUE, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.CYAN };
	
	private static final long serialVersionUID = -3969675782215042594L; // why

	public Dimension getPreferredSize() {
		return new Dimension(sizeX,sizeY);
	}

	// Override paint
	public void paint(Graphics g) {
		super.paint(g);
		
		// create gui
		g.setColor(new Color(0,0,150));
		g.fillRect(0,0,320,570);
		g.setColor(new Color(100,0,20));
		g.fillRect(360,240,130,90);
		g.setColor(Color.black);
		g.fillRect(10,15,300,540);
		g.fillRect(365,245,120,80);
		
		g.setColor(colors[curBlock.type]);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (curBlock.blockCoords[i][j]) {
					g.fillRect(curBlock.p.x+(i*pieceSize),curBlock.p.y+(j*pieceSize),pieceSize,pieceSize);
				}
			}
		}
	}
	
	public static void drawBlocks() {
		if (curBlock.type == 0) {
			curBlock.blockCoords[1][1] = true; // 0 0 0 0 
			curBlock.blockCoords[2][1] = true; // 0 1 1 0 
			curBlock.blockCoords[1][2] = true; // 0 1 1 0
			curBlock.blockCoords[2][2] = true; // 0 0 0 0
		}
		else if (curBlock.type == 1) {
			curBlock.blockCoords[2][0] = true; // 0 0 1 0
			curBlock.blockCoords[2][1] = true; // 0 0 1 0
			curBlock.blockCoords[2][2] = true; // 0 0 1 0
			curBlock.blockCoords[2][3] = true; // 0 0 1 0
		}
		else if (curBlock.type == 2) {
			curBlock.blockCoords[1][0] = true; // 0 0 0 
			curBlock.blockCoords[1][1] = true; // 1 1 1 
			curBlock.blockCoords[1][2] = true; // 0 0 1 
			curBlock.blockCoords[2][2] = true; 
		}
		else if (curBlock.type == 3) {
			curBlock.blockCoords[1][0] = true; // 0 0 0 
			curBlock.blockCoords[1][1] = true; // 1 1 1 
			curBlock.blockCoords[1][2] = true; // 1 0 0 
			curBlock.blockCoords[2][0] = true; 
		}
		else if (curBlock.type == 4) {
			curBlock.blockCoords[1][1] = true; // 0 0 0 
			curBlock.blockCoords[2][1] = true; // 0 1 1 
			curBlock.blockCoords[0][2] = true; // 1 1 0 
			curBlock.blockCoords[1][2] = true;
		}
		else if (curBlock.type == 5) {
			curBlock.blockCoords[1][0] = true; // 0 0 0
			curBlock.blockCoords[1][1] = true; // 1 1 0
			curBlock.blockCoords[2][1] = true; // 0 1 1
			curBlock.blockCoords[2][2] = true;
		}
		else if (curBlock.type == 6) {
			curBlock.blockCoords[0][1] = true; // 0 0 0
			curBlock.blockCoords[1][1] = true; // 1 1 1
			curBlock.blockCoords[2][1] = true; // 0 1 0
			curBlock.blockCoords[1][2] = true;
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Tetris Game");
		JPanel panel = new Game();
		
		// set up JFrame
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(sizeX,sizeY);
		panel.setBackground(Color.black);
		panel.setFocusable(true);

		// display frame
		f.getContentPane().add(panel);
		f.setVisible(true);
		
		KeyListener l = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP){
				    p.y = p.y - 30;
				    panel.repaint();
		        }
				else if (e.getKeyCode() == KeyEvent.VK_LEFT){
					p.x = p.x - 30;
					panel.repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN){
					p.y = p.y + 30;
					panel.repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					p.x = p.x + 30;
					panel.repaint();
				}
			}
			
			public void keyReleased(KeyEvent e) {
				// no
			}
			
			public void keyTyped(KeyEvent e) {
				// no
			}
		};
		panel.addKeyListener(l);
		curBlock = new Block(160,15);
		drawBlocks();
		panel.repaint();
	}
}

