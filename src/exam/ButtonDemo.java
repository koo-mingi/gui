package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ButtonDemo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnLeft;
	private JButton btnMiddle;
	private JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonDemo frame = new ButtonDemo();
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
	public ButtonDemo() {
		setTitle("버튼 이벤트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnLeft = new JButton("Disable middle button");
		btnLeft.setMnemonic('D'); // 알트 + D하면 이벤트 실행할 수 있는 단축키 지정
		btnLeft.setActionCommand("diable");
		btnLeft.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/left.gif")));
		btnLeft.addActionListener(this);
		panel.add(btnLeft);
		
		btnMiddle = new JButton("Middle Button");
		btnMiddle.setMnemonic('M'); // 단축키 : 알트 + M
		btnMiddle.setActionCommand("middle");
		btnMiddle.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/middle.gif")));
		btnMiddle.addActionListener(this);
		panel.add(btnMiddle);
		
		btnRight = new JButton("Enable Middle Button");
		btnRight.setMnemonic('E'); // 단축키 : 알트 + E
		btnRight.setActionCommand("Right");
		//이벤트 발생 시 이름(text)를 변경한다.
		btnRight.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/right.gif")));
		btnRight.addActionListener(this);
		panel.add(btnRight);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// e.getSource() / e.getActionCommand()
		
		String  cmd = e.getActionCommand(); // 이벤트 대상의 이름(text)을 가져오는 메소드
		if(cmd.equals("disable")) {
			btnMiddle.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(true);
		
		}else {
			btnMiddle.setEnabled(true);
			btnLeft.setEnabled(true);
			btnRight.setEnabled(false);
			
		}
		
	}

}
