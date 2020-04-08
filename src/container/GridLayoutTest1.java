package container;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutTest1 extends JFrame {

	
	public GridLayoutTest1() {
		setTitle("GridLayout");
		setBounds(100,100,450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//패널
		JPanel panel = new JPanel();
		// panel.setLayout(new GridLayout(0,3));
		// 칼럼의 숫자를 지정해주면 row의 수는 자동으로 지정해줌.
		panel.setLayout(new GridLayout(0,3,5,5));
		// rows(행),cols(열),hgap(가로 간격),vgap(세로 간격)
		
		// for문으로 반복작업을 단순화하는 것이 좋음
		List<JButton> list = new ArrayList<JButton>();
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		JButton btn6 = new JButton("버튼6");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		add(panel);
	}

	public static void main(String[] args) {
		GridLayoutTest1 grid = new GridLayoutTest1();

	}

}
