package lab10_class;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Lab10_Class {

	private JFrame frame;
	private int iters = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab10_Class window = new Lab10_Class();
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
	public Lab10_Class() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Лабораторная работа №10");
		frame.setResizable(false);
		frame.setBounds(100, 100, 575, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 10, 541, 187);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Обработать");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String[] str = textArea.getText().split(" ");

                Timer timer = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (iters == str.length) {
                            // останавливаем таймер, так как он больше не нужен
                            ((Timer)e.getSource()).stop();
                            JOptionPane.showMessageDialog(frame,  "Сортировка завершина!");
                        }
                        
                        for ( int i = str.length - 1; i > str.length - 2; i--) {
                        	for (int  j = 0; j < i; j++) {
                        		if(strcmp(str[j], str[j+1]) > 0) {
                                    String t = str[j];
                                    str[j] = str[j+1];
                                    str[j+1] = t;
                        		}
                        	}
                            textArea.setText(String.join(" ", str));
                        }
                        iters++;
                    }
         
                });

                timer.start();
			}
		});
		btnNewButton.setBounds(194, 207, 201, 51);
		frame.getContentPane().add(btnNewButton);
	}
    public int strcmp(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int ml = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < ml; i++) {
            if (arr1[i] != arr2[i]) {
                return arr1[i]-arr2[i];
            }
        }

        return arr1.length-arr2.length;
    }
}
