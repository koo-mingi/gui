package text;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class JPasswordTest extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lbltext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPasswordTest frame = new JPasswordTest();
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
	public JPasswordTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('&');
		contentPane.add(passwordField, BorderLayout.NORTH);
		
		lbltext = new JLabel("New label");
		contentPane.add(lbltext, BorderLayout.SOUTH);
		
		passwordField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JPasswordField pf = (JPasswordField)e.getSource();
		
		if(pf==passwordField) {
			// lbltext.setText(new String(pf.getPassword())); 1번 방법
			lbltext.setText(String.valueOf(pf.getPassword()));
		
		}
	}

}
