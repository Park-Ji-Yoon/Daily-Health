package health;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	JPanel customerPanel;
	
	public static JLabel nameLabel;
	public static JLabel idLabel;
	public static JLabel addressLabel;
	public static JLabel phoneLabel;
	public static JLabel ageLabel;
	public static JLabel heightLabel;
	public static JLabel bmiLabel;
	public static JLabel bmrLabel;
	public static JLabel  remainDaysLabel;
	public static JLabel currentWeightLabel;
	public static JLabel targetWeightLabel;
	
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
		
		customerPanel = new JPanel();
		customerPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(customerPanel);
		customerPanel.setLayout(null);
		
		// �̸� label
		nameLabel = new JLabel("�ӽ��̸�", JLabel.CENTER);
		customerPanel.add(nameLabel);
		nameLabel.setBounds(60, 35, 200, 70);
		nameLabel.setFont(new Font("���� ���", Font.BOLD, 36));
		nameLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		nameLabel.setBackground(Color.pink);
		
		// ���̵� label
		idLabel = new JLabel("�ӽþ��̵�", JLabel.CENTER);
		customerPanel.add(idLabel);
		idLabel.setBounds(60, 115, 200, 40);
		idLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		idLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		idLabel.setBackground(Color.pink);
		
		// �ּ�  label
		addressLabel = new JLabel("�ӽ��ּ��Դϴ����", JLabel.CENTER);
		customerPanel.add(addressLabel);
		addressLabel.setBounds(60, 205, 250, 40);
		addressLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		addressLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		addressLabel.setBackground(Color.pink);
		
		// ��ȭ��ȣ label
		phoneLabel = new JLabel("01051354735", JLabel.CENTER);
		customerPanel.add(phoneLabel);
		phoneLabel.setBounds(60, 255, 250, 40);
		phoneLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		phoneLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		phoneLabel.setBackground(Color.pink);
		
		// ����  label
		ageLabel = new JLabel("18��", JLabel.CENTER);
		customerPanel.add(ageLabel);
		ageLabel.setBounds(60, 305, 120, 40);
		ageLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		ageLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		ageLabel.setBackground(Color.pink);
		
		// Ű label
		heightLabel = new JLabel("height", JLabel.CENTER);
		customerPanel.add(heightLabel);
		heightLabel.setBounds(60, 385, 120, 40);
		heightLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		heightLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		heightLabel.setBackground(Color.pink);
		
		// bmi label
		bmiLabel = new JLabel("bmi", JLabel.CENTER);
		customerPanel.add(bmiLabel);
		bmiLabel.setBounds(60, 435, 120, 40);
		bmiLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		bmiLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		bmiLabel.setBackground(Color.pink);
		
		// bmr label
		bmrLabel = new JLabel("bmr", JLabel.CENTER);
		customerPanel.add(bmrLabel);
		bmrLabel.setBounds(60, 485, 120, 40);
		bmrLabel.setFont(new Font("���� ���", Font.PLAIN, 24));
		bmrLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		bmrLabel.setBackground(Color.pink);
		
		// ���� ����  label
		remainDaysLabel = new JLabel("90��", JLabel.CENTER);
		customerPanel.add(remainDaysLabel);
		remainDaysLabel.setBounds(600, 50, 160, 100);
		remainDaysLabel.setFont(new Font("���� ���", Font.BOLD, 52));
		remainDaysLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		remainDaysLabel.setBackground(Color.pink);
		
		// ���� ������ label
		currentWeightLabel = new JLabel("Current", JLabel.CENTER);
		customerPanel.add(currentWeightLabel);
		currentWeightLabel.setBounds(480, 190, 150, 70);
		currentWeightLabel.setFont(new Font("���� ���", Font.PLAIN, 36));
		currentWeightLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		currentWeightLabel.setBackground(Color.pink);
		
		// ���� ������ ���� Button
		JButton changeCurrentWeightBtn = new JButton("���� ������ ����");
		customerPanel.add(changeCurrentWeightBtn);
		changeCurrentWeightBtn.setBounds(480, 260, 150, 30);
		changeCurrentWeightBtn.setBackground(Color.green);
		changeCurrentWeightBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
		changeCurrentWeightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newCurrentWeightStr = JOptionPane.showInputDialog(null, "���� �����Ը� ���� �Է����ּ���", "���� ������ ����", JOptionPane.QUESTION_MESSAGE);
				if(Current(newCurrentWeightStr) && newCurrentWeightStr != null) {
					JOptionPane.showMessageDialog(null, "���� �����԰� ����Ǿ����ϴ�", "���� ������ ����", JOptionPane.PLAIN_MESSAGE);
					currentWeightLabel.setText(newCurrentWeightStr);
				}else if(Current(newCurrentWeightStr) == false){
					JOptionPane.showMessageDialog(null, "���� �����Ը� �������� ���߽��ϴ�", "���� ������ ����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// ȭ��ǥ ��ư
		JButton arrow = new JButton("");
		arrow.setBounds(650, 215, 50, 50);
		customerPanel.add(arrow);
		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
		arrow.setBorderPainted(false);
		arrow.setContentAreaFilled(false);
		arrow.setFocusPainted(false);
		
		// ��ǥ ������  label
		targetWeightLabel = new JLabel("Target", JLabel.CENTER);
		customerPanel.add(targetWeightLabel);
		targetWeightLabel.setBounds(720, 190, 150, 70);
		targetWeightLabel.setFont(new Font("���� ���", Font.PLAIN, 36));
		targetWeightLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		targetWeightLabel.setBackground(Color.pink);
		
		// ��ǥ ������ ���� Button
		JButton changeTargetWeightBtn = new JButton("��ǥ ������ ����");
		customerPanel.add(changeTargetWeightBtn);
		changeTargetWeightBtn.setBounds(720, 260, 150, 30);
		changeTargetWeightBtn.setBackground(Color.green);
		changeTargetWeightBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
		changeTargetWeightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newTargetWeightStr = JOptionPane.showInputDialog(null, "��ǥ �����Ը� ���� �Է����ּ���", "��ǥ ������ ����", JOptionPane.QUESTION_MESSAGE);
				if(Target(newTargetWeightStr) && newTargetWeightStr != null) {
					JOptionPane.showMessageDialog(null, "��ǥ �����԰� ����Ǿ����ϴ�", "��ǥ ������ ����", JOptionPane.PLAIN_MESSAGE);
					targetWeightLabel.setText(newTargetWeightStr);
				}else if(Current(newTargetWeightStr) == false){
					JOptionPane.showMessageDialog(null, "��ǥ �����Ը� �������� ���߽��ϴ�", "��ǥ ������ ����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// bmi ��� ��ư
		JButton bmiBtn = new JButton("bmi ���� ���");
		bmiBtn.setBounds(480, 385, 250, 50);
		customerPanel.add(bmiBtn);
		bmiBtn.setBackground(Color.green);
		bmiBtn.setFont(new Font("���� ���", Font.PLAIN, 22));
		bmiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
//		arrow.setBorderPainted(false);
//		arrow.setContentAreaFilled(false);
//		arrow.setFocusPainted(false);
		
		// bmr ��� ��ư
		JButton bmrBtn = new JButton("���ʴ�緮(bmr) ���");
		bmrBtn.setBounds(480, 455, 250, 50);
		customerPanel.add(bmrBtn);
		bmrBtn.setBackground(Color.green);
		bmrBtn.setFont(new Font("���� ���", Font.PLAIN, 22));
		bmrBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
//		arrow.setBorderPainted(false);
//		arrow.setContentAreaFilled(false);
//		arrow.setFocusPainted(false);
		
		// �α׾ƿ� ��ư
		JButton logoutBtn = new JButton("�α׾ƿ�");
		logoutBtn.setBounds(870, 510, 105, 35);
		customerPanel.add(logoutBtn);
		logoutBtn.setBackground(Color.green);
		logoutBtn.setFont(new Font("���� ���", Font.PLAIN, 17));
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LogoChoice();
			}
		});
	}
	public static void main(String[] args) {
		new CustomerDisplay();
	}
	
	// ���� ������ ���� �޼���
	public boolean Current(String cw) {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set CurrentWeight=? where id=?");

            pst.setString(1, cw);
            pst.setString(2, idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("%d���� ���� �ٲ����ϴ�.", numRows);

            pst.close();
            conn.close();
			
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	// ��ǥ ������ ���� �޼���
	public boolean Target(String tg) {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
	        
	        PreparedStatement pst=conn.prepareStatement("update jiyoon set TargetWeight=? where id=?");
	
	        pst.setString(1, tg);
	        pst.setString(2, idLabel.getText());
	
	        int numRows = pst.executeUpdate(); //insert, delete, 
	
	        System.out.format("%d���� ���� �ٲ����ϴ�.", numRows);
	
	        pst.close();
	        conn.close();
			
	        return true;
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}