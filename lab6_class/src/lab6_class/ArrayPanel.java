package lab6_class;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class ArrayPanel extends JPanel {
	
	private int[][] arr;
	private int w, h;
	
	
	public ArrayPanel() {
		try {
			Scanner sc = new Scanner(new File("C:\\temp\\input.txt"));
			
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[w][h];
			
			for(int y = 0; y < h; y++) {
				for(int x = 0; x < w; x++) {
					arr[x][y] = sc.nextInt();
				}
			}
			
			sc.close();
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
				
				g.drawRect(10 + x * 60, 10 + y * 60, 60, 60);
			}
		}
		
	}

}
