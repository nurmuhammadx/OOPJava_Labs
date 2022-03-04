package lab_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Font;

public class Lab3_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab3_Main window = new Lab3_Main();
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
	public Lab3_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Лабораторная работа №3");
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 585, 443);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		panel.add(textArea, BorderLayout.CENTER);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(605, 23, 171, 20);
		spinner.setValue(5);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Размер фигуры");
		lblNewLabel.setBounds(605, 10, 141, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Фигура №1 (While)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				//up
				int t = n;
				while(t > 1) {
					int j = n;
					while(j > (n - t)) {
						result += j + " ";
						j--;
						}
						result += "\n" + String.join("", Collections.nCopies((n - t) + 1, "  "));
						t--;
				}
				//down
				int i = 1;
				while(i <= n) {
					int j = n;
					if(i > 1)
						result += "\n" + String.join("", Collections.nCopies((n - i), "  "));
					while(j > (n - i)) {
						result += j + " ";
						j--;
						}
					i++;
				}
				textArea.setText(result);
			}
		});
		btnNewButton.setBounds(605, 53, 171, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Фигура №2 (DoWhile)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				
				int i = n;
				do {
					int j = 1;
					do {
						result += j + " ";
						j++;
					}while (j <= i );
					i--;
					result += "\n" + String.join("", Collections.nCopies((n - i), "  "));
				}while (i > 1);
				
				i = 0;
				int k = 1;
				do {
					int t = 0;
					int j = k;
					do {
						result += j + " ";
						j--;
						t++;
					}while (t <= i);
					result += "\n" + String.join("", Collections.nCopies((n - 1), "  "));
					k++;
					i++;
				}while (i < n);
				textArea.setText(result);
			}
		});
		btnNewButton_1.setBounds(605, 99, 171, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Фигура №3 (While)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				
				int i = 1;
				while (i < n) {
					result += String.join("", Collections.nCopies(n - i, "  "));
					int j = 1;
					while (j <= i) {
						result += j + " ";
						j++;
					}
					result += "\n";
					i++;
				}
				
				i = 1;
				while (i <= n) {
					int j = i;
					while (j <= n) {
						result += j + " ";
						j++;
					}
					result += "\n" + String.join("", Collections.nCopies(i, "  "));
					//System.out.println();
					i++;
				}
				textArea.setText(result);
			}
		});
		btnNewButton_2.setBounds(605, 144, 171, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Фигура №4 (DoWhile)");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				
				int i = n;
				do {
					int j = n;
					do {
						result += j + " ";
						j--;
					}while(j > (n - i));
					result += "\n" + String.join("", Collections.nCopies((n - i) + 1, "  "));
					i--;		
				}while(i > 1);
				
				i = 0;
				int k = n;
				do {
					int t = 0;
					int j = k;
					do {
						result += j + " ";
						j++;
						t++;
					}while (t <= i);
					result += "\n" + String.join("", Collections.nCopies((n - 1), "  "));
					k--;
					i++;
				}while (i < n);
				textArea.setText(result);
			}
		});
		btnNewButton_3.setBounds(605, 189, 171, 35);
		frame.getContentPane().add(btnNewButton_3);
	}
}
