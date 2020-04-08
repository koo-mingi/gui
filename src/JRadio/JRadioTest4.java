package JRadio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JRadioTest4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panelTop;
	private JPanel panelMiddle;
	private JRadioButton rdo1,rdo2,rdo3;
	private JRadioButton rdo4,rdo5,rdo6,rdo7;
	private JRadioButton rdo8,rdo9,rdo10;
	private JButton btnOrder, btnCancel;
	private double total;
	private int priceSort, priceTop;
	private double priceSize=1;
	private ButtonGroup groupSort, groupTopping, groupSize;
	private String sort="", topping="", size="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest4 frame = new JRadioTest4();
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
	public JRadioTest4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelTop = new JPanel();
		contentPane.add(panelTop);
		
		JLabel lblNewLabel = new JLabel("자바 피자에 오신 것을 환영합니다");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		panelMiddle = new JPanel();
		contentPane.add(panelMiddle, BorderLayout.CENTER);
		panelMiddle.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_left = new JPanel();
		panel_left.setBorder(new TitledBorder(null, "\uC885\uB958", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMiddle.add(panel_left);
		panel_left.setLayout(new GridLayout(0, 1, 0, 0));
		
		//종류
		rdo1 = new JRadioButton("콤보");
		rdo1.addActionListener(this);
		panel_left.add(rdo1);
		
		rdo2 = new JRadioButton("포테이토");
		rdo2.addActionListener(this);
		panel_left.add(rdo2);
		
		rdo3 = new JRadioButton("불고기");
		rdo3.addActionListener(this);
		panel_left.add(rdo3);
		
		groupSort = new ButtonGroup();
		groupSort.add(rdo1);
		groupSort.add(rdo2);
		groupSort.add(rdo3);
		//토핑
		JPanel panel_mid = new JPanel();
		panel_mid.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uCD94\uAC00 \uD1A0\uD551", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMiddle.add(panel_mid);
		panel_mid.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdo4 = new JRadioButton("피망");
		rdo4.addActionListener(this);
		panel_mid.add(rdo4);
		
		rdo5 = new JRadioButton("치즈");
		rdo5.addActionListener(this);
		panel_mid.add(rdo5);
		
		rdo6 = new JRadioButton("페페로니");
		rdo6.addActionListener(this);
		panel_mid.add(rdo6);
		
		rdo7 = new JRadioButton("베이컨");
		rdo7.addActionListener(this);
		panel_mid.add(rdo7);
		
		groupTopping = new ButtonGroup();
		groupTopping.add(rdo4);
		groupTopping.add(rdo5);
		groupTopping.add(rdo6);
		groupTopping.add(rdo7);
		
		//크기
		JPanel panel_right = new JPanel();
		panel_right.setBorder(new TitledBorder(null, "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMiddle.add(panel_right);
		panel_right.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdo8 = new JRadioButton("Small");
		rdo8.addActionListener(this);
		panel_right.add(rdo8);
		
		rdo9 = new JRadioButton("Medium");
		rdo9.addActionListener(this);
		panel_right.add(rdo9);
		
		rdo10 = new JRadioButton("Large");
		rdo10.addActionListener(this);
		panel_right.add(rdo10);
		
		groupSize = new ButtonGroup();
		groupSize.add(rdo8);
		groupSize.add(rdo9);
		groupSize.add(rdo10);
		
		//주문 및 취소
		JPanel panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		
		btnOrder = new JButton("주문");
		btnOrder.addActionListener(this);
		panelBottom.add(btnOrder);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBottom.add(btnCancel);
		
		textField = new JTextField("금액 : ");
		panelBottom.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		//선택지 버튼 눌렀을 때
		if(e.getSource() instanceof JRadioButton) {
			JRadioButton rdb = (JRadioButton) e.getSource();
			
			//종류
			if(rdb==rdo1) {
				priceSort = 7000;
				sort = rdb.getText();
			}
			else if(rdb==rdo2) {
				priceSort = 8000;
				sort = rdb.getText();
			}
			else if(rdb==rdo3) {
				priceSort = 9000;
				sort = rdb.getText();
			}
			//토핑
			if(rdb==rdo4) {
				priceTop = 500;
				topping = rdb.getText();
			}
			else if(rdb==rdo5) {
				priceTop = 600;
				topping = rdb.getText();
			}
			else if(rdb==rdo6) {
				priceTop = 700;
				topping = rdb.getText();
			}
			else if(rdb==rdo7) {
				priceTop = 800;
				topping = rdb.getText();
			}
			//크기
			if(rdb==rdo8) {
				priceSize = 1;
				size = rdb.getText();
			}
			if(rdb==rdo9) {
				priceSize = 1.25;
				size = rdb.getText();
			}
			if(rdb==rdo10) {
				priceSize = 1.5;
				size = rdb.getText();
			}
			
			total = priceSort*priceSize + priceTop;
			
			textField.setText("금액 : "+total);
			
		// 주문 및 취소 버튼 눌렀을 때.
		}else if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			
			String order = "주문내역\n"+"종류 : "+sort+"\n토핑 : "+topping+"\n크기 : "+size+"\n가격은 "+total+" 원입니다. 주문하시겠습니까?";
			String option[] = {"예","아니오"};
			int select=0;
			//주문버튼 눌렀을 때					
			if(btn==btnOrder) {
				//선택이 다 되어있는지 확인
				if(sort.equals("")||topping.equals("")||size.equals("")){
					JOptionPane.showConfirmDialog(this, "주문이 다 선택되지 않았습니다","주문확인",JOptionPane.CLOSED_OPTION);
				}else {
					//JOptionPane.showopDialog(this, order,"주문",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
					select = JOptionPane.showOptionDialog(this, order, "주문", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null,option, option[0]);
					if(select == 0) {
						JOptionPane.showConfirmDialog(this, "주문이 접수되었습니다","주문",JOptionPane.CLOSED_OPTION);
						textField.setText("주문이 접수됨");
					}else {
						JOptionPane.showConfirmDialog(this, "주문이 취소되었습니다","주문",JOptionPane.CLOSED_OPTION);
						textField.setText("주문이 취소됨");
					}
				}
				
			}
			
			else {
				textField.setText("주문이 취소됨");
			}
			
			sort=""; topping="";size="";
			total =0; priceSort=0; priceSize=1; priceTop =0;
			
			groupSort.clearSelection();
			groupSize.clearSelection();
			groupTopping.clearSelection();
			
		}
		
		
	}

}
