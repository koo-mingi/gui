package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SimpleCalc2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtResult;
	private	JButton btnAdd;
	private JButton btnCancel;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btndiv;
	private JLabel labelOp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc2 frame = new SimpleCalc2();
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
	public SimpleCalc2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtOp1 = new JTextField();
		panel.add(txtOp1);
		txtOp1.setColumns(10);
		
		labelOp = new JLabel("?");
		panel.add(labelOp);
		
		txtOp2 = new JTextField();
		panel.add(txtOp2);
		txtOp2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		panel.add(lblNewLabel_1);
		
		txtResult = new JTextField();
		panel.add(txtResult);
		txtResult.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);
		
		
		btnSub = new JButton("-");
		btnSub.addActionListener(this);
		panel_1.add(btnSub);
		
		btnMul = new JButton("*");
		btnMul.addActionListener(this);
		panel_1.add(btnMul);
		
		btndiv = new JButton("/");
		btndiv.addActionListener(this);
		panel_1.add(btndiv);
		
		btnCancel = new JButton("reset");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		pack();//창크기를 맞추어줌
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		int op1 =0;
		int op2 =0;
		if(!txtOp1.getText().isEmpty() && !txtOp2.getText().isEmpty()) {
			op1 = Integer.parseInt(txtOp1.getText());//String이라 int형으로 변환해야 한다.
			op2 = Integer.parseInt(txtOp2.getText());
		
		int result = 0;
		
		if(source == btnAdd) {
			//txtOp1, txtOp2 숫자를 가져와서 더하기를 한 후
			result = op1 + op2;
			//String이라 int형으로 변환해야 한다.
			labelOp.setText("+");
			
			//txtResult에 결과값 보여주기
			
		}else if(source == btnSub) {
			//txtOp1, txtOp2 숫자를 가져와서 빼기를 한 후
			labelOp.setText("-");
			
			//txtResult에 결과값 보여주기
			result = op1 -op2;
			
		}else if(source == btnMul) {
			//txtOp1, txtOp2 숫자를 가져와서 빼기를 한 후
			
			labelOp.setText("*");
			
			//txtResult에 결과값 보여주기
			result = op1 * op2;
		}
		else if(source == btndiv) {
			//txtOp1, txtOp2 숫자를 가져와서 빼기를 한 후
			labelOp.setText("/");
			
			//txtResult에 결과값 보여주기
			result = op1 / op2;
		}
		else {
			//txtOp1, txtOp2, txtResult 내용 지우기
			txtOp1.setText("");
			txtOp2.setText("");
			txtResult.setText("");
		}
		txtResult.setText(String.valueOf(result));
		
		}
		
	}

}
