package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;


class MyButton extends JButton{
	static int count =0;
	int index;
	boolean changeable = false;
	
	public MyButton(String str) {
		super(str);
		index=count++;
	}
	
}

public class Puzzle extends JFrame implements ActionListener{

	private JPanel contentPane;
	private MyButton[] btn = new MyButton[9];
	private JPanel btnPanel;
	private JButton btnReset;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle frame = new Puzzle();
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
	public Puzzle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.CENTER);
		btnPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		// 버튼 배열 크기보다 1번 덜 돌림.
		for(int i=0;i<btn.length-1;i++) {
			btn[i]= new MyButton((i+1+""));	
		}
		
		btn[8] = new MyButton("");
		btn[8].changeable = true;
		
		changeAction(btn[8]);
		
		
		for(int i=0;i<btn.length;i++) {
			btnPanel.add(btn[i],Panel.CENTER_ALIGNMENT);
			btn[i].addActionListener(this);
		}
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.ORANGE);
		btnReset.setBackground(Color.BLACK);
		btnReset.setFont(new Font("굴림", Font.BOLD, 14));
		btnReset.addActionListener(this);
		contentPane.add(btnReset, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int position = 0;
		// 키패드의 숫자 버튼이 눌렸을 때 형변환.
		if(e.getSource() instanceof MyButton) {
			MyButton button = (MyButton) e.getSource();
		
		
		if(button.changeable==true && button.getText()!="") {
			//빈곳 위치 찾기
			for(int i=0;i<this.btn.length;i++) {
				if(btn[i].getText().equals("")){
					position=i;
					break;
				}
			}
			this.btn[position].setText(button.getText());
			button.setText("");
			changeFalse();
			changeAction(button);
		}
		}
		// reset버튼이 눌렸을 때.
		if(e.getSource() == btnReset) {
			resetAll();
		}
		
	}
	
	//변경 가능하도록 바꾸기
	public void changeAction(MyButton btn) {
		
		if(btn.getText().equals("")) {
			int position = btn.index;
			for(int i=0;i<this.btn.length;i++) {
				if(Math.abs(i-position)==1 || Math.abs(i-position)==3) {
					this.btn[i].changeable=true;
				}
			}
		}		
	}
	//모두 변경 못하게 바꾸기
	public void changeFalse() {
		for(int i=0;i<btn.length;i++) {
			btn[i].changeable =false;
		}
	}
	
	//모두 리셋하기
	public void resetAll() {
		for(int i=0;i<btn.length;i++) {
			btn[i].setText(""+(i+1));
		}
		
		btn[8].setText("");
		btn[8].changeable = true;
		
	}
	

}
