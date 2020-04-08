package container;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest1 extends JFrame{

	public BorderLayoutTest1() {
		//타이틀 지정
		setTitle("BorderLayout");
		//크기 지정
		setSize(500,500);
		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//창 띄우기
		setVisible(true);
		//패널 생성
		JPanel contentPanel = new JPanel();
		//패널에 BorderLayout() 지정
		contentPanel.setLayout(new BorderLayout());
		//버튼 생성
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
	
		//패널에 버튼 부착 - 위치지정 안하면 가운데만 붙음
		contentPanel.add(btn1,BorderLayout.EAST);
		contentPanel.add(btn2,BorderLayout.WEST);
		contentPanel.add(btn3,BorderLayout.CENTER);
		contentPanel.add(btn4,BorderLayout.NORTH);
		contentPanel.add(btn5,BorderLayout.SOUTH);
		//창의 크기를 키워도 가운데 버튼만 커짐.
		
		//프레임에 패널 부착
		add(contentPanel);
	}
	
	public static void main(String[] args) {
		BorderLayoutTest1 border = new BorderLayoutTest1();

	}

}
