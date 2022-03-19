package lab_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import lab_5.PaintPanel;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab5_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab5_Main window = new Lab5_Main();
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
	public Lab5_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Лабораторная работа №5");
		frame.setBounds(100, 100, 675, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PaintPanel panel = new PaintPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 470, 470);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Глубина рекурсии");
		lblNewLabel.setBounds(490, 11, 147, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(490, 34, 156, 20);
		spinner.setValue(5);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("4 луч звезда");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				panel.deep = n;
				panel.figureType = 0;
				panel.repaint();
				
			}
		});
		btnNewButton.setBounds(490, 64, 156, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("5 луч звезда");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				panel.deep = n;
				panel.figureType = 1;
				panel.repaint();
				
			}
		});
		btnNewButton_1.setBounds(490, 104, 156, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Косвенная рекурсия");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				panel.deep = n;
				panel.figureType = 2;
				panel.repaint();
				
			}
		});
		btnNewButton_1_1.setBounds(490, 144, 156, 30);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
