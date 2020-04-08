package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class JCheckTest2 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JCheckBox chckbxNewCheckBox_1,chckbxNewCheckBox_2,chckbxNewCheckBox_3;
	private JTextArea textArea;
	private HashMap<String, String> CheckList=new HashMap<String, String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest2 frame = new JCheckTest2();
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
	public JCheckTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxNewCheckBox_1 = new JCheckBox("사과");
		chckbxNewCheckBox_1.addItemListener(this);
		panel_1.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("복숭아");
		chckbxNewCheckBox_2.addItemListener(this);
		panel_1.add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("포도");
		chckbxNewCheckBox_3.addItemListener(this);
		panel_1.add(chckbxNewCheckBox_3);
		
		textArea = new JTextArea();
		panel.add(textArea);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 각 체크박스가 체크되면 체크된 과일의 이름을
		// textArea 보여주기
		// 체크가 해제되면 textArea에 있던 과일의 이름은
		// 삭제 해주기
		// textArea => setText() = 항상 새롭게 교체, append(); = 기존에 추가.
		JCheckBox check = (JCheckBox)e.getItem();
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(check==chckbxNewCheckBox_1) CheckList.put("1",check.getText());
			else if(check==chckbxNewCheckBox_2) CheckList.put("2",check.getText());
			else if(check==chckbxNewCheckBox_3) CheckList.put("3",check.getText());
			
			textArea.setText(getList());
		}else {
			if(check==chckbxNewCheckBox_1) CheckList.remove("1");
			else if(check==chckbxNewCheckBox_2) CheckList.remove("2");
			else if(check==chckbxNewCheckBox_3) CheckList.remove("3");
			
			
			textArea.setText(getList());
		}

		
//		if(e.getStateChange()==ItemEvent.SELECTED) {
//			textArea.append(" "+check.getText());
//		}else {
//			//textArea에 있는 전체 문자열
//			String contents = textArea.getText();
//			//체크가 해제된 체크박스 문자열
//			String delTxt=check.getText();
//			
//			StringBuffer buf = new StringBuffer(contents);
//			int start = buf.indexOf(delTxt);
//			int end = start+delTxt.length();
//			buf.delete(start, end);
//			textArea.setText(buf.toString());
//			
//		}
			
		
	}
	
	public String getList() {
		String s="";
		Iterator<String> it = CheckList.keySet().iterator();
		while(it.hasNext()) {
			s = s+" "+CheckList.get(it.next()); // get으로 value값을 가지고 옴
		}
		return s;
	}

}
