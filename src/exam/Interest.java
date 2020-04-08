package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseChronology;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interest extends JFrame implements ActionListener {

	
	private JLabel originLabel;
	private JLabel rateLabel;
	private JButton convert;
	private JTextField resultText;
	private JTextField originText;
	private JTextField rateText;
	
	
	public Interest() {
		setTitle("이자계산기");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel totalpane = new JPanel();
		totalpane.setLayout(new BoxLayout(totalpane, BoxLayout.Y_AXIS));
		
		JPanel top1pane = new JPanel();
		originLabel = new JLabel("원금을 입력하시오");
		originText = new JTextField(10);
		top1pane.add(originLabel);
		top1pane.add(originText);
		totalpane.add(top1pane);
		
		JPanel top2pane = new JPanel();
		rateLabel = new JLabel("이율을 입력하시오");
		rateText = new JTextField(10);
		top2pane.add(rateLabel);
		top2pane.add(rateText);
		totalpane.add(top2pane);
		
		JPanel top3pane = new JPanel();
		convert = new JButton("변환");
		convert.addActionListener(this);
		top3pane.add(convert);
		totalpane.add(top3pane);
		
		JPanel top4pane = new JPanel();
		resultText = new JTextField(20);
		top4pane.add(resultText);
		totalpane.add(top4pane);
		
		getContentPane().add(totalpane);
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		Interest interest = new Interest();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		double orin = Double.parseDouble(originText.getText());
		double rate = Double.parseDouble(rateText.getText());
		
		double result = orin * rate;
		
		resultText.setText(String.valueOf(result));
		
	}

}
