package exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rock extends JFrame implements ActionListener{

	private JPanel totalPanel;
	private JLabel textLabel;
	private JPanel btnPanel;
	private JButton[] btn = new JButton[3];
	private JTextField resultText;	
	
	private static final int ROCK=0;
	private static final int PAPER=1;
	private static final int SCISSOR=2;
	
	public Rock() {
		setTitle("가위바위보");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());
		add(totalPanel);
		
		textLabel = new JLabel("아래의 버튼 중에서 하나를 클릭하시오");
		totalPanel.add(textLabel,BorderLayout.NORTH);
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0,3));
		totalPanel.add(btnPanel,BorderLayout.CENTER);
		
		List<String> list = new ArrayList<String>();
		list.add("ROCK");
		list.add("PAPER");
		list.add("SCIS");
		
		btn[0] = new JButton();
		btn[1] = new JButton();
		btn[2] = new JButton();
		
		btn[0].setIcon(new ImageIcon(getClass().getResource("rock.png")));
		btn[1].setIcon(new ImageIcon(getClass().getResource("paper.png")));
		btn[2].setIcon(new ImageIcon(getClass().getResource("scissor.png")));
		
		for(int i = 0;i<btn.length;i++) {
			btn[i].setText(list.get(i));
			btn[i].addActionListener(this);
			btnPanel.add(btn[i]);
		}
		
		resultText = new JTextField();
		totalPanel.add(resultText,BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
		
	public static void main(String[] args) {
		Rock rock = new Rock();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String comResult ="컴퓨터 : ";
		String userResult = "사용자 :"+source.getText()+" ";
		
		//컴퓨터의 가위,바위,보 생성하기
		Random random = new Random();
		// random.netxInt(3) : 괄호안의 숫자는 미포함해서 0,1,2 중에서 나오게 함.
		int computer = random.nextInt(3);
		if(computer==0) {
			comResult += "Rock ";
		}else if(computer==1) {
			comResult += "PAPER ";
		}else {
			comResult += "SCISSOR ";
		}
		
		
		//사용자가 누른 버튼의 값을 가져온 후
		//가위,바위,보를 해서 누가 이겼는지
		//textField에 보여주기
		String[] resultString = {"사용자가 이김","비김","컴퓨터가 이김"};
		
		switch (source.getText()) {
		case "ROCK": //사용자가 주먹
			if(computer==ROCK) {
				resultText.setText(comResult+userResult+" : "+resultString[1]);
			}else if(computer==PAPER) {
				resultText.setText(comResult+userResult+" : "+resultString[2]);
			}else {
				resultText.setText(comResult+userResult+" : "+resultString[0]);
			}
			break;
		case "PAPER": //사용자가 보
			if(computer==ROCK) {
				resultText.setText(comResult+userResult+" : "+resultString[0]);
			}else if(computer==PAPER) {
				resultText.setText(comResult+userResult+" : "+resultString[1]);
			}else {
				resultText.setText(comResult+userResult+" : "+resultString[2]);
			}
			break;
			
		case "SCIS": //사용자가 가위
			if(computer==ROCK) {
				resultText.setText(comResult+userResult+" : "+resultString[2]);
			}else if(computer==PAPER) {
				resultText.setText(comResult+userResult+" : "+resultString[0]);
			}else {
				resultText.setText(comResult+userResult+" : "+resultString[1]);
			}
			break;
		default:
			break;
		}
		
		
		
	}

}
