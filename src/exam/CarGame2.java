package exam;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel2 extends JPanel{
	BufferedImage img = null;
	int img_x=100, img_y=100; // 그림을 처음에 출력할 좌표. 그림의 왼쪽 상단 모서리 부분이 기준
	
	public MyPanel2() {
		URL url = getClass().getResource("car.gif");
		try {
			img = ImageIO.read(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 포커스를 주는 것이 중요하다.
		// textField나 버튼은 기본적으로 포커스를 가지고 있다.
		// 하지만 JPanel 자체는 포커스를 가지고 있지 않다. 왜냐하면 그릇의 역할이니까.
		
		// 사용자가 4방향의 화살표를 클릭한 경우
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					img_y -= 10;
					break;
				case KeyEvent.VK_DOWN:
					img_y += 10;
					break;
				case KeyEvent.VK_LEFT:
					img_x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					img_x += 10;
					break;
				default:
					break;
				}
				repaint();
			}
		});
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX()+","+e.getY());
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
			
		});
		
		// 포커스 요청하기
		this.requestFocus();
		// 포커스를 계속 가질 수 있도록 해줌.
		setFocusable(true);
	}
	
	// paintComponent 메소드는 자동으로 호출되기 때문에
	// 직접 호출하는 것은 불가능하다.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
	
}

public class CarGame2 extends JFrame {

	public CarGame2() {
		setTitle("자동차 움직이기");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel2());
				
	}
	
	
	public static void main(String[] args) {
		CarGame2 car = new CarGame2();
		car.setVisible(true);

	}

}
