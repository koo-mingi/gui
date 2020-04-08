package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textGender;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest3 frame = new JTableTest3();
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
	public JTableTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("이름");
		panel.add(lblNewLabel);
		
		textName = new JTextField();
		panel.add(textName);
		textName.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("나이");
		panel.add(lblNewLabel_1);
		
		textAge = new JTextField();
		textAge.setColumns(5);
		panel.add(textAge);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		panel.add(lblNewLabel_2);
		
		textGender = new JTextField();
		textGender.setColumns(5);
		panel.add(textGender);
		
		JButton btnInput = new JButton("입력");
		panel.add(btnInput);
		
		JButton btnDel = new JButton("삭제");
		panel.add(btnDel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		// 컬럼명 작성
		String columnnames[]= {"이름","나이","성별"};
		model = new DefaultTableModel(columnnames,0);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		btnInput.addActionListener(this);
		btnDel.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		if(cmd.equals("입력")) { // 입력
		
		
		// 사용자가 입력한 이름,나이,성별 가져오기		
		String name = textName.getText();
		String age = textAge.getText();
		String gender = textGender.getText();
		Object[] data = {name,age,gender};
		Vector<String> rowdata = new Vector<String>();
		rowdata.add(name);
		rowdata.add(age);
		rowdata.add(gender);
		// 모델에 추가하기
		model = (DefaultTableModel)table.getModel();
		model.addRow(rowdata);
		
		// 다른 데이터를 입력할 수 있도록 기존 데이터 삭제하기
		textName.setText("");
		textAge.setText("");
		textGender.setText("");
		
		}else { // 테이블 선택 시 삭제
									
			int selectRow  = table.getSelectedRow(); //선택된 행의 값을 반환한다.
			model.removeRow(selectRow);
			
		}
		
		
	}

}
