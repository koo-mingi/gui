package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


// 클래스가 2개 있을 때에 public인 클래스를 main으로 잡으면 됨.

public class MyFrame2 extends JFrame {

	
	private JPanel contentPane;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();
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
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("버튼을 누르세요");
		panel.add(btnNewButton);
		//버튼과 리스너(이벤트 발생 감시자)를 연동하는 부분
		btnNewButton.addActionListener(new MyListener2());
		
		label = new JLabel("New label");
		panel.add(label);
	}
	
	//이벤트 처리를 위한 클래스를 외부 클래스로 작성하기
		class MyListener2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트 대상의 타이틀을 가져와버림
				System.out.println(e.getActionCommand());
				//현재 이벤트가 일어난 대상을 가져온다.
				System.out.println(e.getSource());
				
				//버튼을 누르면 버튼 글자 변경
				label.setText("버튼이 눌러짐");
			}
			
		}

}
