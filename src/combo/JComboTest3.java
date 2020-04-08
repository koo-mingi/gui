package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class JComboTest3 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest3 frame = new JComboTest3();
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
	public JComboTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String items[] = {"bird","Cat","Dog","Pig","Rabbit"};
		JComboBox<String> combo = new JComboBox<String>(items);
		combo.addItemListener(this);
		contentPane.add(combo,BorderLayout.NORTH);
		
		label = new JLabel("",SwingConstants.CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
		contentPane.add(label,BorderLayout.CENTER);
		
	}

	
	public void itemStateChanged(ItemEvent e) {
		
		JComboBox<String> com = (JComboBox<String>)e.getSource();
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(com.getSelectedIndex()==0) {
				label.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
			}else if(com.getSelectedIndex()==1) {
				label.setIcon(new ImageIcon(getClass().getResource("Cat.gif")));
			}else if(com.getSelectedIndex()==2) {
				label.setIcon(new ImageIcon(getClass().getResource("dog2.gif")));
			}else if(com.getSelectedIndex()==3) {
				label.setIcon(new ImageIcon(getClass().getResource("Pig.gif")));
			}else if(com.getSelectedIndex()==4) {
				label.setIcon(new ImageIcon(getClass().getResource("Rabbit.gif")));
			}
		}
		
//		String animal = (String) e.getItem();
//		label.setIcon(new ImageIcon(getClass().getResource(animal+".gif")));
		
	}

}
