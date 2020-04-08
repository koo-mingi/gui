package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MouseEventTest1 extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseEventTest1 frame = new MouseEventTest1();
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
	public MouseEventTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addMouseListener(this);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(this);
		textArea.setText("");
		contentPane.add(textArea, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("클릭");
		
		// 클릭한 지점의 좌표
		System.out.println(e.getX()+","+e.getY()); 
		
		// 왼쪽버튼 1, 중간 휠 2, 오른쪽버튼 3.
		System.out.println(e.getButton()); 
		
		// 연속으로 버튼을 누른  회수
		System.out.println(e.getClickCount());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("누름");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("뗌");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		textField.setText("마우스 들어감");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		textField.setText("마우스 탈출");
		
	}

}
