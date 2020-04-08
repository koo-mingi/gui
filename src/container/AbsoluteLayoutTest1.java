package container;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AbsoluteLayoutTest1 extends JFrame {

	public AbsoluteLayoutTest1() {
		setTitle("BoxLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		JPanel panel = new JPanel();
		//축을 지정해서 컴포넌트를 생성가능
		panel.setLayout(null);
		
//		List<JButton> list = new ArrayList<JButton>();
//		
//		for(int i=0;i<6;i++) {
//			list.add(new JButton("사과"+i));
//			list.get(i).setBounds(33,24,97,23);
//		}
		
		JButton btn1 = new JButton("사과");
		btn1.setBounds(33,24,97,23); //x좌표, y좌표, 컴포넌트 크기 가로,세로
		panel.add(btn1);
		
		JButton btn2 = new JButton("바나나");
		btn2.setBounds(297,65,97,23);
		panel.add(btn2);
		
		JButton btn3 = new JButton("수박");
		btn3.setBounds(73,180,97,23);
		panel.add(btn3);
		
		add(panel);
		
	}
	
	public static void main(String[] args) {
		AbsoluteLayoutTest1 ab = new AbsoluteLayoutTest1();

	}

}
