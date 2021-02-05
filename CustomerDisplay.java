package health;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	
	public CustomerDisplay() {
		frame = new JFrame(); //frame ����
		frame.setResizable(false); //frame�� ���̵��� ����
		frame.setBounds(470, 200, 1000, 600); //frame�� ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݵ��� ����
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
		frame.setTitle("Daily Health - ȸ�� ������"); //Ÿ��Ʋ ����
		
		//��Ŷ�� ����Ͽ� �̹��� �����
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png ������ �̹��� ���ϸ� ����
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(customerPanel);
		customerPanel.setLayout(null);
	}
	public static void main(String[] args) {
		new CustomerDisplay();
	}
}