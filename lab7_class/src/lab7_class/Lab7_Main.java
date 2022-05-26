package lab7_class;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lab7_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab7_Main window = new Lab7_Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lab7_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		GamePanel panel = new GamePanel();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				if(KeyCode == KeyEvent.VK_RIGHT)
					panel.moveRigh();
				else if(KeyCode == KeyEvent.VK_LEFT)
					panel.moveLeft();
				else if(KeyCode == KeyEvent.VK_DOWN)
					panel.moveDown();
				else if(KeyCode == KeyEvent.VK_UP)
					panel.moveUp();
			}
		});
		frame.setTitle("Лабораторная работа №7");
		frame.setBounds(100, 100, 664, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 625, 621);
		frame.getContentPane().add(panel);
	}
}
