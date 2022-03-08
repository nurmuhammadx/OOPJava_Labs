package lab_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private void drawHome(Graphics g) {
		
		//green line
		g.setColor(new Color(0,255, 0));
		g.fillRect(0, 590, 1366, 60);
		
		//body
		g.setColor(new Color(240, 116, 39));
		g.fillRect(50, 180, 450, 410);
		
		//window and lines
		g.setColor(new Color(49, 140, 231));
		g.fillRect(100, 250, 150, 150);
		g.setColor(new Color(0, 0, 0));
		g.drawLine(190, 250, 190, 400);
		g.drawLine(190, 320, 249, 320);
		
		//door
		g.setColor(new Color(128, 128, 128));
		g.fillRect(320, 320, 140, 270);
		
		//roof
		g.setColor(new Color(64, 0, 0));
		int[] arrayX = {0, 550, 275};
		int[] arrayY = {180, 180, 10};
		g.fillPolygon(new Polygon(arrayX, arrayY, 3));
	
	}
	
	private void drawTrees(Graphics g) {
		
		//brawn line for tree
		g.setColor(new Color(128, 64, 0));
		g.fillRect(700, 330, 35, 260);
		g.fillRect(1220, 519, 35, 70);
		
		//green oval for tree
		g.setColor(new Color(0, 128, 0));
		g.fillOval(590, 90, 250, 245);
		
		//first triangle
		int[] arrayX = {1120, 1360, 1237};
		int[] arrayY = {519, 519, 420};
		g.fillPolygon(new Polygon(arrayX, arrayY, 3));
		
		//second triangle
		int[] arrayX2 = {1140, 1340, 1237};
		int[] arrayY2 = {421, 421, 340};
		g.fillPolygon(new Polygon(arrayX2, arrayY2, 3));
		
		//third triangle
		int[] arrayX3 = {1160, 1315, 1237};
		int[] arrayY3 = {341, 341, 270};
		g.fillPolygon(new Polygon(arrayX3, arrayY3, 3));
		
	}
	
	private void drawDogHome(Graphics g) {
		
		//body
		g.setColor(new Color(0, 128, 255));
		g.fillRect(850, 400, 200, 189);
		
		//roof
		g.setColor(new Color(192, 192, 192));
		int[] arrayX = {830, 1070, 950};
		int[] arrayY = {400, 400, 320};
		g.fillPolygon(new Polygon(arrayX, arrayY, 3));
		
		//door
		g.setColor(new Color(128, 128, 128));
		g.fillOval(885, 459, 130, 130);
		
	}
	
	private void drawSun(Graphics g) {
		
		//sun
		g.setColor(new Color(244, 202, 22));
		g.fillOval(1000, 50, 100, 100);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		drawHome(g);
		drawTrees(g);
		drawDogHome(g);
		drawSun(g);
	}
}