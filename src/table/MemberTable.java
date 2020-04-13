package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.MemberDAO;
import database.MemberVO;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class MemberTable extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textGender;
	private JTextField textField;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textdeleteField;
	private JTable table_1;
	
	private MemberDAO dao;
	//전체조회
	private DefaultTableModel model;
	//하나조회
	private DefaultTableModel model1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberTable frame = new MemberTable();
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
	public MemberTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//DB 객체 생성
		dao = new MemberDAO();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("회원등록", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelName = new JLabel("이름");
		panel.add(labelName);
		
		textName = new JTextField();
		panel.add(textName);
		textName.setColumns(10);
		
		JLabel labelAge = new JLabel("나이");
		panel.add(labelAge);
		
		textAge = new JTextField();
		panel.add(textAge);
		textAge.setColumns(10);
		
		JLabel labelGender = new JLabel("성별");
		panel.add(labelGender);
		
		textGender = new JTextField();
		panel.add(textGender);
		textGender.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("회원조회", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("회원번호");
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		model1 = getModel();
		table = new JTable(model1);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(table);
		panel_1.add(scrollPanel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("회원수정", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("번호");
		panel_5.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("나이");
		panel_5.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("수정할 회원 정보 입력");
		panel_2.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("수정");
		panel_2.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("회원삭제", null, panel_3, null);
		
		JLabel lblNewLabel_4 = new JLabel("회원번호");
		panel_3.add(lblNewLabel_4);
		
		textdeleteField = new JTextField();
		panel_3.add(textdeleteField);
		textdeleteField.setColumns(10);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panel_3.add(btnDelete);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("회원전체조회", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		//memberTBL의 전체 내용을 가져오기
						
		table_1 = new JTable(getModel());
		list();
		scrollPane.setViewportView(table_1);
		
		
		textGender.addActionListener(this);
		
	}
	
	public DefaultTableModel getModel() {
		String columnNames[] = {"번호","이름","나이","성별"};
		model = new DefaultTableModel(columnNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}
	
	public void list() {
		Vector<MemberVO> vecList = dao.getList();
		
		//vecList에 들어있는 값을 table에 보여주기
		for(MemberVO vo:vecList) {
			Object[] data = {vo.getNo(),vo.getName(),vo.getAge(),vo.getGender()};
			
			model.addRow(data);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==textGender) {
			// 이름과 나이와 성별을 가져온 후
			MemberVO vo = new MemberVO();
			vo.setName(textName.getText());
			vo.setAge(Integer.parseInt(textAge.getText()));
			vo.setGender(textGender.getText());
			
			// 데이터베이스에 입력하기
			int result = dao.insert(vo);
			
			if(result>0) {
				JOptionPane.showMessageDialog(this, "성공");
				// 모델이 가지고 있었던 데이터초기화
				model.setNumRows(0);
				list();
			}else {
				JOptionPane.showMessageDialog(this, "실패");
			}
		}else if(e.getActionCommand().equals("조회")) {
			//사용자가 입력한 번호 가져오기
			int no = Integer.parseInt(textField.getText());
			
			
			//번호에 해당하는 정보 가져온 후 보여주기
			MemberVO vo = dao.getRow(no);
			
			Object[] data = {vo.getNo(),vo.getName(),vo.getAge(),vo.getGender()};
			model1 = (DefaultTableModel) table.getModel();
			model1.setNumRows(0); //모델이 가지고 있던 데이터 초기화
			model1.addRow(data); //모델에 가져온 데이터 넘기기
			//table에는 getModel()을 통해서 model 객체가 넘어가 있는 상태이기 때문에
			//table에 따로 model을 할당해 줄 필요가 없다.
			
			
		}else if(e.getActionCommand().equals("삭제")) {
			// 사용자가 입력한 번호 가져오기
			int no = Integer.parseInt(textdeleteField.getText());
						
			// 해당하는 회원 삭제해주기
			int result = dao.remove(no);
			if(result>0) {
				JOptionPane.showMessageDialog(this, "성공");
				// 모델이 가지고 있었던 데이터초기화
				model.setNumRows(0);
				list();
				
			}else {
				JOptionPane.showMessageDialog(this, "실패");
			}

		}

	}
}
