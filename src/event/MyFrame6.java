package event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame6 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnyellow;;
	private JButton btnred;
	private JButton btnClose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame6 frame = new MyFrame6();
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
	public MyFrame6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnyellow = new JButton("노랑");
		btnyellow.addActionListener(this);
		panel.add(btnyellow);
		
		btnred = new JButton("빨강");
		btnred.addActionListener(this);
		panel.add(btnred);
		
		btnClose = new JButton("닫기");
		btnClose.addActionListener(this);
		panel.add(btnClose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// btnYellow or btnRed
		Object source = e.getSource();
		
		if(source==btnyellow) {
			contentPane.setBackground(Color.YELLOW);
			panel.setBackground(Color.GRAY);
			
		}else if(source==btnred){
		
			contentPane.setBackground(Color.RED);
			panel.setBackground(Color.BLACK);
		}else{
			//프레임 종료
			System.exit(0);
		}
	}

}
