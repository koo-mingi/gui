package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class JCheckTest4 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest4 frame = new JCheckTest4();
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
	public JCheckTest4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Apple");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.addItemListener(this);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Grape");
		chckbxNewCheckBox_2.setSelected(true);
		chckbxNewCheckBox_2.addItemListener(this);
		panel_1.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Orange");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.addItemListener(this);
		panel_1.add(chckbxNewCheckBox);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/apple.gif")));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/grape.gif")));
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/orange.gif")));
		panel.add(lblNewLabel_2);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		JCheckBox check = (JCheckBox)e.getItem();
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(check.getText().equals("Apple")) {
				lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/checkbox/apple.gif")));
			}else if(check.getText().equals("Grape")) {
				lblNewLabel_1.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/grape.gif")));
			}else{
				lblNewLabel_2.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/orange.gif")));
			}
		}else {
			if(check.getText().equals("Apple")) {
				lblNewLabel.setIcon(null);
			}else if(check.getText().equals("Grape")) {
				lblNewLabel_1.setIcon(null);
			}else{
				lblNewLabel_2.setIcon(null);
			}
		}
	}

}
