package Tetris;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class CustomPanel extends JPanel {

	public static final int sizeX = 520;
	public static final int sizeY = 600;
	private static Point point = new Point(10,10);
	private boolean ready;
	
	private static final long serialVersionUID = -3969675782215042594L; // why
	
	public CustomPanel() {
		ready = false;
	}

	public Dimension getPreferredSize() {
		return new Dimension(sizeX,sizeY);
	}

	// Override paintComponent
	public void paint(Graphics g) {
		super.paint(g);
		
		// create gui
		if (!ready) {
			g.setColor(new Color(0,0,150));
			g.fillRect(0,0,330,570);
			g.setColor(new Color(100,0,20));
			g.fillRect(360,240,130,90);
			g.setColor(Color.black);
			g.fillRect(10,10,310,550);
			g.fillRect(365,245,120,80);
			ready = true;
		}
	
		// create square
		g.setColor(Color.white);
		g.fillRect(point.x,point.y,30,30);
	}
	
	public static void main(String[] args) {
		JPanel p = new CustomPanel();
		JFrame f = new JFrame("Tetris Game");
		
		// set up JFrame
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(sizeX,sizeY);
		p.setBackground(Color.black);
		p.setFocusable(true);

		// display frame
		f.getContentPane().add(p);
		f.setVisible(true);
		
		KeyListener l = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP){
				   point.y = point.y - 30;
		           p.repaint();
		        }
				else if (e.getKeyCode() == KeyEvent.VK_LEFT){
					point.x = point.x - 30;
				    p.repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN){
					point.y = point.y + 30;
				    p.repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					point.x = point.x + 30;
				    p.repaint();
				}
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyTyped(KeyEvent e) {
				
			}
		};
		p.addKeyListener(l);
	}
}
