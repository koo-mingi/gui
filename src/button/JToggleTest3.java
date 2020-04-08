package button;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JToggleTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JToggleButton tglbtnNewToggleButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JToggleTest3 frame = new JToggleTest3();
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
	public JToggleTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tglbtnNewToggleButton = new JToggleButton("토글 버튼");
		tglbtnNewToggleButton.addActionListener(this);
		contentPane.add(tglbtnNewToggleButton, BorderLayout.NORTH);
		
		
		btnNewButton = new JButton("일반 버튼");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		AbstractButton btn = (AbstractButton)e.getSource();
		
		if(btn==btnNewButton) { //일반버튼
			lblNewLabel.setText("일반버튼 클릭");
		}else {
			
			if(btn.isSelected()) { // 토글버튼
				lblNewLabel.setText("Button on");
			
			}else {
				lblNewLabel.setText("Button off");
			}
		}
		
				
//		if(e.getSource()==btnNewButton) {
//			lblNewLabel.setText("일반버튼 클릭");
//		}else {
//			JToggleButton tgl = (JToggleButton) e.getSource();
//				
//			if(tgl.isSelected()) {
//				lblNewLabel.setText("Button on");
//			
//			}else {
//				lblNewLabel.setText("Button off");
//			}
//		}
		
		// 토글버튼과 일반버튼의 부모객체를 이용
		
	}

}
