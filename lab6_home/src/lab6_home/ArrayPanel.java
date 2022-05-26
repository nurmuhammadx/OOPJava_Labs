package lab6_home;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class ArrayPanel extends JPanel {
	
	private int[][] arr;
	private int w, h;
	private int[] ax = new int[10];
	
	public ArrayPanel() {
		try {
			Scanner sc = new Scanner(new File("C:\\temp\\6\\input.txt"));
			
			h = sc.nextInt();
			w = sc.nextInt();
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
	
	public void process() {
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				System.out.printf("%d ", arr[x][y]);
			}
			System.out.println();
		}
		System.out.println();
		
	    //поиск суммы всех четных элемнтов столбца
		int sum = 0;
	    for (int x = 0; x < w; x++)
	    {
	        int max = arr[x][0];
	        for (int y = 0; y < h; y++)
	        {
	            if (arr[x][y] % 2 == 0)
	            {
	                sum += arr[x][y];
	                max = sum;
	            }
	        }
	        ax[x] = max;
	        sum = 0;
	    }
		
		
		//заменяем нечетные элементы
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				if(arr[x][y] % 2 != 0) {
					arr[x][y] = ax[x];
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				switch(arr[x][y]) {
				case 0:
					g.setColor(new Color(128,128,128));
					break;
				case 1:
					g.setColor(new Color(83, 104, 114));
					break;
				case 2:
					g.setColor(new Color(0,255,128));
					break;
				case 3:
					g.setColor(new Color(0,128,255));
					break;
				case 4:
					g.setColor(new Color(255,128,255));
					break;
				case 5:
					g.setColor(new Color(255,255,0));
					break;
				case 6:
					g.setColor(new Color(0,255,255));
					break;
				case 7:
					g.setColor(new Color(128,64,64));
					break;
				case 8:
					g.setColor(new Color(255,128,64));
					break;
				case 9:
					g.setColor(new Color(0,64,128));
					break;
				default:
					g.setColor(new Color(255,0,0));
				}
				
				g.fillRect(10 + x * 60, 10 + y * 60, 60, 60);
			}
		}
		
	}

}
