package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class KeyFrameTest1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyFrameTest1 frame = new KeyFrameTest1();
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
	public KeyFrameTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("뮨자를 입력하시오");
		panel.add(lblNewLabel);
		
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			// 이벤트를 처리하는 애들은 클래스 형태와 인터페이스 2가지가 존재
			// 클래스는 뒤에 ~Adapter가 붙음
			// 인터페이스는 뒤에 ~Listener
			// 인터페이스는 사용하지 않는 기능들도 끌고와야 한다는 단점이 있지만,
			// 클래스는 사용하는 기능만 끌고 올 수 있다는 장점이 있다.
			@Override
			public void keyPressed(KeyEvent e) {
				//키보드에서 키를 누를 때 발생하는 이벤트
				System.out.println(e.getKeyCode()); //아스키코드를 반환
				System.out.println(e.getKeyChar());
				int keyCode = e.getKeyCode();
				System.out.println(KeyEvent.getKeyText(keyCode)); // 특수키까지 출력
				
				if(keyCode >= 65 && keyCode<91 || keyCode>= 97 && keyCode<123) {
					textArea.setText("영어입니다.");
				}else {
					textArea.setText("영어가 아닙니다.");
				}
			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		
	}

}
