package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Celsius extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Celsius frame = new Celsius();
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
	public Celsius() {
		setTitle("온도변환기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Celcius");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("convert");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Fahrenheit");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		pack();
	}

}
