package Tetris;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game extends JPanel {

	public static final int sizeX = 520;
	public static final int sizeY = 600;
	public static final int pieceSize = 30;
	public static final int startX = 130;
	public static final int startY = -105;
	
	public static Color[][] board = new Color[10][18];
	
	public static Block curBlock = new Block(0,0);
	private Color[] colors = { Color.YELLOW, Color.BLUE, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.CYAN };
	
	private static final long serialVersionUID = -3969675782215042594L;
	
	public Dimension getPreferredSize() {
		return new Dimension(sizeX,sizeY);
	}

	// Override paint
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (curBlock.blockCoords[i][j] && curBlock.p.y + (j*30) > 0) {
					int curBoardX = ((curBlock.p.x-10)/pieceSize)+i, curBoardY = ((curBlock.p.y-15)/pieceSize)+j;
					board[curBoardX][curBoardY] = colors[curBlock.type]; // put piece in board array
					if (((curBlock.p.y-15)/pieceSize)+j >= 17 || board[curBoardX][curBoardY+1] != Color.black) {
						curBlock.isFalling = false;
					}
				}
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				g.setColor(board[i][j]);
				g.fillRect(i*30+10,j*30+15,30,30);
			}
		}
		
		// create gui
		g.setColor(new Color(0,0,150)); 
		g.fillRect(0,0,310,15);
		g.fillRect(0,0,10,570);
		g.fillRect(310,0,10,570);
		g.fillRect(0,555,310,15);
		g.setColor(new Color(100,0,20));
		g.fillRect(360,240,130,90);
		g.setColor(Color.black);
		g.fillRect(365,245,120,80);
	}
	
	public static void drawBlocks(JPanel panel) {
		curBlock = new Block(startX,startY);
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
		panel.repaint();
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
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				board[i][j] = Color.black; // sets all variables in board to black
			}
		}
		
		KeyListener l = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP && curBlock.p.y > 0){
					int n = 3;
					if (curBlock.type < 2) n = 4;

					boolean[][] temp = new boolean[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							temp[i][j] = curBlock.blockCoords[i][j]; // put blockCoords into temp
						}
					}

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							board[((curBlock.p.x-10)/pieceSize)+i][((curBlock.p.y-15)/pieceSize)+j] = Color.black; // remove existing piece from board array
							curBlock.blockCoords[i][j] = temp[j][n-i-1]; // rotate blockCoords 90 degrees
						}
					}
					
					
				    panel.repaint();
		        }
				else if (e.getKeyCode() == KeyEvent.VK_LEFT && curBlock.p.x > 15){
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (curBlock.blockCoords[i][j] && curBlock.p.y + (j*30) > 0) {
								board[((curBlock.p.x-10)/pieceSize)+i][((curBlock.p.y-15)/pieceSize)+j] = Color.black; // remove existing piece from board array
							}
						}
					}
					
					curBlock.p.x -= pieceSize;
					panel.repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT && curBlock.p.x < pieceSize*7-15){
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (curBlock.blockCoords[i][j] && curBlock.p.y + (j*30) > 0) {
								board[((curBlock.p.x-10)/pieceSize)+i][((curBlock.p.y-15)/pieceSize)+j] = Color.black; // remove existing piece from board array
							}
						}
					}

					curBlock.p.x += pieceSize;
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
		drawBlocks(panel);
		
		ActionListener fall = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curBlock.isFalling) {
						
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (curBlock.blockCoords[i][j] && curBlock.p.y + (j*30) > 0) {
								board[((curBlock.p.x-10)/pieceSize)+i][((curBlock.p.y-15)/pieceSize)+j] = Color.black; // remove existing piece from board array
							}
						}
					}
					
					curBlock.p.y += pieceSize;
					panel.repaint();
				}
				else {
					drawBlocks(panel);
				}
			}
		};
		Timer timer = new Timer(500,fall);
		timer.start();
	}
}

