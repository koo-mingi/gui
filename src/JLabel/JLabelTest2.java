package JLabel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JLabelTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JToggleButton tglbtn;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelTest2 frame = new JLabelTest2();
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
	public JLabelTest2() {
		setTitle("토글버튼을 이용한 아이콘");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("그림이 나타날 겁니다.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		tglbtn = new JToggleButton("이미지를 보려면 클릭하세요~");
		tglbtn.addActionListener(this);
		contentPane.add(tglbtn, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JToggleButton tgl = (JToggleButton) e.getSource();
		ImageIcon img = new ImageIcon(getClass().getResource("dog.gif"));
		
		if(tgl.isSelected()) {
			lblNewLabel.setIcon(img);
			lblNewLabel.setText("그림이 나타났어요");
		}else {
			lblNewLabel.setIcon(null);
			lblNewLabel.setText("그림이 사라졌어요");
		}
	}

}
