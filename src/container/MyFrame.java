package container;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("MyFream");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,100);
	
		
		JPanel totalpane = new JPanel();
		totalpane.setLayout(new BoxLayout(totalpane,BoxLayout.Y_AXIS));
		//totalpane.setLayout(new GridLayout(0,1,5,5));
		//totalpane.setLayout(new BorderLayout());
		
		JPanel toppane = new JPanel();
		JLabel label = new JLabel("자바 피자에 오신 것을 환영합니다. 파지의 종류를 선택하시오");
		toppane.add(label);
		totalpane.add(toppane);
		//totalpane.add(toppane);
		//totalpane.add(toppane,BorderLayout.NORTH);
		
		
		JPanel midpane = new JPanel();
		JButton btn1 = new JButton("콤보피자");
		JButton btn2 = new JButton("포테이토피자");
		JButton btn3 = new JButton("불고기피자");
		JLabel numberlabel = new JLabel("개수");
		JTextField feild = new JTextField(10);
		
		midpane.add(btn1);
		midpane.add(btn2);
		midpane.add(btn3);
		midpane.add(numberlabel);
		midpane.add(feild);
		totalpane.add(midpane);
		//totalpane.add(midpane);
		//totalpane.add(midpane,BorderLayout.CENTER);
	
		
		add(totalpane);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		MyFrame my = new MyFrame();

	}

}
