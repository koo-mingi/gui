package container;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest5 extends JFrame{

	public JFrameTest5() {
		setTitle("다섯번째 프로그램");
		setBounds(200,300,100,100);//x좌표, y좌표, 가로크기,세로크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
		//컴포넌트 생성하기
		JPanel panel = new JPanel(); //컴포넌트이자 컨테이너
		panel.setLayout(new FlowLayout());
		//flowLayout은 컴포넌트를 붙이는대로 생성된다.
		
		JButton btn1 = new JButton("open");
		JButton btn2 = new JButton("save");
		JCheckBox check = new JCheckBox("GUI 프로그래밍");
		JColorChooser chooser = new JColorChooser();
		
		//컴포넌트 부착 - 패널에 부착
		panel.add(btn1);
		panel.add(btn2);
		panel.add(check);
		panel.add(chooser);
		
		//JPanel을 Frame에 부착
		add(panel);
		
			
	}
	
	
	public static void main(String[] args) {
		// 컨테이너 생성하기
		JFrameTest5 f = new JFrameTest5();
	}

}
