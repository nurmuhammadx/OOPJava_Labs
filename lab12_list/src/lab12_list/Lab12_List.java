package lab12_list;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Lab12_List {

	private JFrame frame;
	private JTable table;
    private LinkedList<ListElem> list = new LinkedList<>();
	private boolean elemDirection = true;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab12_List window = new Lab12_List();
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
	public Lab12_List() {
		initialize();
		
		String[] strList = {"apple", "mango", "banana", "apricot", "avocado", "melon", "orange"};
		
		for (int i = 0; i < strList.length; i++) {
			list.add(new ListElem(strList[i]));
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Лабораторная работа №12");
		frame.setBounds(100, 100, 437, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        table = new JTable();
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setModel(new DefaultTableModel(
            new String[][] {},
            new String[] {
                "Список строк"
            }
        ));
        table.setBounds(10, 10, 594, 426);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 222, 408);
        frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Вывод списка");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                Iterator<ListElem> iter = list.iterator();

                model.setRowCount(0);

                while (iter.hasNext()) {
                    ListElem currentElem = iter.next();
                    model.addRow(new Object[] {currentElem.elem});
                } 
			}
		});
		btnNewButton.setBounds(242, 16, 171, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Сменить направления");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				Iterator<ListElem> iter;
	
                if(elemDirection == true) {
                	iter = list.descendingIterator();
                }else {
                	iter = list.iterator();	
                }

                model.setRowCount(0);
                
                while (iter.hasNext()) {
                    ListElem currentElem = iter.next();
                    model.addRow(new Object[] {currentElem.elem});
                }

                elemDirection = !elemDirection;
			}
		});
		btnNewButton_1.setBounds(242, 56, 171, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Поле для ввода запроса");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(242, 96, 171, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(242, 112, 171, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Поиск");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();           
                Iterator<ListElem> iter = list.iterator();

                model.setRowCount(0);

                while (iter.hasNext()) {
                    ListElem currentElem = iter.next();
                    if (currentElem.elem.equals(textField.getText())) {
                        model.addRow(new Object[] {currentElem.elem});
                    }
                }
			}
		});
		btnNewButton_2.setBounds(241, 152, 172, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Добавить в голову");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                list.addFirst(new ListElem(textField.getText()));
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.addRow(new Object[] {textField.getText()});
			}
		});
		btnNewButton_3.setBounds(242, 192, 171, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Добавить в хвост");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                list.addLast(new ListElem(textField.getText()));
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.addRow(new Object[] {textField.getText()});
			}
		});
		btnNewButton_4.setBounds(242, 232, 171, 30);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Удалить по запросу");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
                
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).elem.equals(textField.getText())) {
                        list.remove(i);
                        break;
                    }
                }

                Iterator<ListElem> it = list.iterator();
                while (it.hasNext()) {
                	ListElem currentElem = it.next();
                    model.addRow(new Object[] {currentElem.elem});
                }
			}
		});
		btnNewButton_5.setBounds(242, 272, 171, 30);
		frame.getContentPane().add(btnNewButton_5);
	}
}
