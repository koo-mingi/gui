package exam;

import java.awt.PageAttributes.OriginType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertMile extends JFrame implements ActionListener{

	private JLabel disLable;
	private JTextField disText;
	private JButton convert;
	private JTextField resultText;
	
	public ConvertMile() {
		setTitle("마일을 킬로미터로 변환");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel totalpane = new JPanel();
		totalpane.setLayout(new BoxLayout(totalpane, BoxLayout.Y_AXIS));
		
		JPanel top1pane = new JPanel();
		disLable = new JLabel("거리를 마일단위로 입력하세요");
		disText = new JTextField(10);
		top1pane.add(disLable);
		top1pane.add(disText);
		totalpane.add(top1pane);
	
		
		JPanel top2pane = new JPanel();
		convert = new JButton("변환");
		convert.addActionListener(this);
		top2pane.add(convert);
		totalpane.add(top2pane);
		
		JPanel top3pane = new JPanel();
		resultText = new JTextField(20);
		top3pane.add(resultText);
		totalpane.add(top3pane);
		
					
		getContentPane().add(totalpane);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		ConvertMile CM = new ConvertMile();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int mile = Integer.parseInt(disText.getText());
		resultText.setText(String.valueOf(mile * 1.6)+"km");
		
	}

}
