package lab7_class;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private int[][] arr;
	private int h;
	private int w;
	private int px;
	private int py;
	
	public void moveRigh() {
		if(arr[px + 1][py] == 0)
			px++;
		repaint();
	}
	
	public void moveLeft() {
		if(arr[px - 1][py] == 0)
			px--;
		repaint();
	}
	
	public void moveDown() {
		if(arr[px][py + 1] == 0)
			py++;
		repaint();
	}
	
	public void moveUp() {
		if(arr[px][py - 1] == 0)
			py--;
		repaint();
	}
	
	public GamePanel() {
		try {
			Scanner sc = new Scanner(new File("C:\\temp\\7\\input.txt"));
			
			h = sc.nextInt();
			w = sc.nextInt();
			px = sc.nextInt();
			py = sc.nextInt();
			arr = new int[w][h];
			
			for(int y = 0; y < h; y++) {
				for(int x = 0; x < w; x++) {
					arr[x][y] = sc.nextInt();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				
				if(arr[x][y] == 1)
					g.setColor(new Color(0,0,0));
				else if(arr[x][y] == 0)
					g.setColor(new Color(128,128,128));
				
				g.fillRect(10 + x * 60, 10 + y * 60, 60, 60);
			}
		}
		
		g.setColor(new Color(244,202,22));
		g.fillRect(18 + px * 60, 18 + py * 60, 45, 45);
		
	}

}
