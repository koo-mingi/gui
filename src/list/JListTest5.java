package list;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class JListTest5 extends JFrame implements ActionListener,ListSelectionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JList<String> list;
	private JTextArea textArea;
	private DefaultListModel<String> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListTest5 frame = new JListTest5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JListTest5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		
		model = new DefaultListModel<String>();
		list = new JList<>(model);
		list.addListSelectionListener(this);
		panel.add(list);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		panel.add(textArea);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		textField.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JTextField) {
			JTextField text = (JTextField)e.getSource();
			
			model.addElement(text.getText());
			text.setText("");
			
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if(e.getValueIsAdjusting()) {
			System.out.println(list.getSelectedIndex());
			System.out.println(model.toString());
			int pos = list.getSelectedIndex();
			if(pos!=-1) model.remove(pos);
			
		
		}
		
	}

	

}
