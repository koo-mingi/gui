package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JComboTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField field;
	private Vector<String> vector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest2 frame = new JComboTest2();
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
	public JComboTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//콤보박스에 들어갈 아이템 설정
//		String[] items = {"월","화","수","목","금","토"};
//		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(items);
//		JComboBox<String> combo = new JComboBox<String>();
//		combo.setModel(model);
		
		
		// Vector 이용
		vector = new Vector<String>();
		vector.add("사과");
		vector.add("배");
		vector.add("복숭아");
		vector.add("딸기");
		vector.add("바나나");
		JComboBox<String> combo = new JComboBox<String>(vector);
		combo.setSelectedIndex(-1);
		combo.addActionListener(this);
		
		contentPane.add(combo,BorderLayout.SOUTH);
		
		
		field = new JTextField();
		contentPane.add(field,BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox<String> com = (JComboBox<String>) e.getSource();
		field.setText(vector.get(com.getSelectedIndex()));
		
		
	}

}
