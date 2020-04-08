package container;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutTest1 extends JFrame {

	public BoxLayoutTest1() {
		setTitle("BoxLayout");
		setBounds(200,200,450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		//축을 지정해서 컴포넌트를 생성가능
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		List<JButton> list = new ArrayList<JButton>();
		
		for(int i=0;i<6;i++) {
			list.add(new JButton("box"+1));
			panel.add(list.get(i));
		}
		
		add(panel);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxLayoutTest1 box = new BoxLayoutTest1();
	}

}
