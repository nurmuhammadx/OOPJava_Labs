package lab7_home;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	Image wallImg = new ImageIcon("images\\wall.png").getImage();
	Image trapImg = new ImageIcon("images\\trap.png").getImage();
	Image finishImg = new ImageIcon("images\\finish.png").getImage();
	Image playerImg = new ImageIcon("images\\player.png").getImage();
	private int[][] arr;
	private int h;
	private int w;
	private int px;
	private int py;
	private int fx;
	private int fy;
	private int lvl = 1;
	
	public void moveLeft() {
		if(arr[px - 1][py] == 0 | arr[px - 1][py] == 2) {
			px--;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Победа!, level up");
			}
		}
		repaint();
	}
	
	public void moveRight() {
		if(arr[px + 1][py] == 0 | arr[px + 1][py] == 2) {
			px++;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Победа!, level up");
			}
		}
		repaint();
	}
	
	public void moveUp() {
		if(arr[px][py - 1] == 0 | arr[px][py - 1] == 2) {
			py--;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Победа!, level up");
			}
		}
		repaint();
		
	}
	
	public void moveDown() {
		if(arr[px][py + 1] == 0 | arr[px][py + 1] == 2) {
			py++;
			if(arr[px][py] == 2) {
				lvl++; 
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Победа!, level up");
			}
		}
		repaint();
	}
	
	public GamePanel() {
		try {
			Scanner sc = new Scanner(new File("C:\\temp\\7\\level_1.txt"));
			
			h = sc.nextInt();
			w = sc.nextInt();
			px = sc.nextInt();
			py = sc.nextInt();
			fx = sc.nextInt();
			fy = sc.nextInt();
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
	
public void lvlUp() {
	
		try {
			switch(lvl) {
			case 2:
				Scanner sc = new Scanner(new File("C:\\temp\\7\\level_2.txt"));
				
				h = sc.nextInt();
				w = sc.nextInt();
				px = sc.nextInt();
				py = sc.nextInt();
				fx = sc.nextInt();
				fy = sc.nextInt();
				arr = new int[w][h];
				
				for(int y = 0; y < h; y++) {
					for(int x = 0; x < w; x++) {
						arr[x][y] = sc.nextInt();
					}
				}
				sc.close();	
				break;
			
			case 3:
				Scanner sc_1 = new Scanner(new File("C:\\temp\\7\\level_3.txt"));
				
				h = sc_1.nextInt();
				w = sc_1.nextInt();
				px = sc_1.nextInt();
				py = sc_1.nextInt();
				fx = sc_1.nextInt();
				fy = sc_1.nextInt();
				arr = new int[w][h];
			
				for(int y = 0; y < h; y++) {
					for(int x = 0; x < w; x++) {
						arr[x][y] = sc_1.nextInt();
					}
				}
				sc_1.close();	
				break;
	}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				
				if(arr[x][y] == 1)
					g.drawImage(wallImg, -13 + x * 60, -13 + y * 60, 105, 105, null);
				if(arr[x][y] == 0)
					g.drawImage(trapImg, -15 + x * 60, 9 + y * 60, 110, 65, null);
				
			}
			
		}
		g.drawImage(trapImg, -15 + fx * 60, 9 + fy * 60, 110, 65, null);
		g.drawImage(finishImg, 10 + fx * 60, 10 + fy * 60, 60, 65, null);
		g.drawImage(playerImg, 5 + px * 60, 5 + py * 60, 70, 65, null);
		
	}
	
}
