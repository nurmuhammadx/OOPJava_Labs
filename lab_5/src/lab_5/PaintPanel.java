package lab_5;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	int figureType = 0;
	int deep = 0;

	//4
	private void fourPointedStar(Graphics g, int x, int y, int s) {
		
		g.drawLine(x - s / 4, y - s / 4, x, y - s);//1
		g.drawLine(x - s, y, x - s / 4, y - s / 4);//2
		g.drawLine(x - s / 4, y + s / 4, x - s, y);//3
		g.drawLine(x - s / 4, y + s / 4, x, y + s);//4
		g.drawLine(x, y + s, x + s / 4 , y + s / 4);//5
		g.drawLine(x + s / 4 , y + s / 4, x + s, y);//6
		g.drawLine(x + s, y, x + s / 4, y - s / 4);//7
		g.drawLine(x + s / 4, y - s / 4, x, y - s);//8
		
	}
	//4
	private void recurFourPointedStar(Graphics g, int x, int y, int s, int d) {
		
		if (d <= 0) {
	        return;
	    }
		fourPointedStar(g, x, y, s);
		recurFourPointedStar(g, x, y - s, s / 2, d - 1);
		recurFourPointedStar(g, x, y + s, s / 2, d - 1);
		recurFourPointedStar(g, x - s, y, s / 2, d - 1);
		recurFourPointedStar(g, x + s, y, s / 2, d - 1);
		
	}
	
	//5
	private void fivePointedStar(Graphics g, int x, int y, int s) {
		
		g.drawLine(x, y - s, x + s / 5, y - s / 4);//1
		g.drawLine(x + s / 5, y - s / 4, x + s, y - s / 4);//2
		g.drawLine(x + s, y - s / 4, x + s / 3, y + s / 10);//3
		g.drawLine(x + s / 3, y + s / 10, x + s / 2, y + s);//4+
		g.drawLine(x + s / 2, y + s, x - s/50, y + s / 4);//4+
		g.drawLine(x - s/50, y + s / 4, x - s / 2, y + s / 1);//5+
		g.drawLine(x - s / 2, y + s / 1, x - s / 3, y + s / 10);//6+
		g.drawLine(x - s / 3, y + s / 10, x - s, y - s / 4);//7
		g.drawLine(x - s, y - s / 4, x - s / 5, y - s / 4);//7
		g.drawLine(x - s / 5, y - s / 4, x, y - s);//8
		
	}
	//5
	private void recurFivePointedStar(Graphics g, int x, int y, int s, int d) {
		
		if (d <= 0) {
	        return;
	    }
		fivePointedStar(g, x, y, s);
		recurFivePointedStar(g, x, y - s, s / 2, d - 1);
		recurFivePointedStar(g, x + s, y - s / 4, s / 2, d - 1);
		recurFivePointedStar(g, x + s / 2, y + s / 1, s / 2, d-1);
		recurFivePointedStar(g, x - s / 2, y + s / 1, s / 2, d - 1);
		recurFivePointedStar(g, x - s, y - s / 4, s /2, d - 1);
		
	}
	
	// косвенная рекурсия
	private void recurFourPointedStarCos(Graphics g, int x, int y, int s, int d) {
		
		fourPointedStar(g, x, y, s);
		if (d <= 0) {
	        return;
	    }
		recurFivePointedStarCos(g, x, y - s, s / 2, d - 1);
		recurFivePointedStarCos(g, x, y + s, s / 2, d - 1);
		recurFivePointedStarCos(g, x - s, y, s / 2, d - 1);
		recurFivePointedStarCos(g, x + s, y, s / 2, d - 1);
		
	}
	// косвенная рекурсия
	private void recurFivePointedStarCos(Graphics g, int x, int y, int s, int d) {
		
		fivePointedStar(g, x, y, s);
		if (d <= 0) {
	        return;
	    }
		recurFourPointedStarCos(g, x, y - s, s / 2, d - 1);
		recurFourPointedStarCos(g, x + s, y - s / 4, s / 2, d - 1);
		recurFourPointedStarCos(g, x + s / 2, y + s / 1, s / 2, d-1);
		recurFourPointedStarCos(g, x - s / 2, y + s / 1, s / 2, d - 1);
		recurFourPointedStarCos(g, x - s, y - s / 4, s /2, d - 1);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if (figureType == 0) 
			recurFourPointedStar(g, 230, 230, 100, deep);
		else if (figureType == 1)
			recurFivePointedStar(g, 230, 230, 100, deep);
		else if (figureType == 2)
			recurFivePointedStarCos(g, 230, 230, 100, deep);
		
	}

}
