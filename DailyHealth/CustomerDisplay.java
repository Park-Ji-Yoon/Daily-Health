package health;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}

	JPanel customerPanel;
	
	public static JLabel nameLabel;
	public static JLabel idLabel;
	public static JLabel addressLabel;
	public static JLabel phoneLabel;
	public static JLabel ageLabel;
	public static JLabel heightLabel;
	public static JLabel bmiLabel;
	public static JLabel bmrLabel;
	public static JLabel remainDaysLabel;
	public static JButton attendBtn;
	public static JLabel info;
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
		remainDaysLabel.setBounds(480, 50, 160, 100);
		remainDaysLabel.setFont(new Font("���� ���", Font.BOLD, 52));
		remainDaysLabel.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		remainDaysLabel.setBackground(Color.pink);
		
		// �⼮ Button
		attendBtn = new JButton("���");
		customerPanel.add(attendBtn);
		attendBtn.setBounds(655, 70, 70, 60);
		attendBtn.setFont(new Font("���� ���", Font.PLAIN, 18));
		attendBtn.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		attendBtn.setBackground(Color.pink);
		attendBtn.setBorderPainted(false);
		attendBtn.setFocusPainted(false);
		attendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(remainDaysLabel.getText()) > 0 && attend(idLabel.getText()) == true) {
					SimpleDateFormat custom_format = new SimpleDateFormat ( "yyyy�� MM�� dd��");
					Date time = new Date();
					String today = custom_format.format(time);
					JOptionPane.showMessageDialog(null, idLabel.getText() + "��, " + today + "�� ������� ���Ǿ����ϴ�", "�⼮üũ", JOptionPane.PLAIN_MESSAGE);
					remainDaysLabel.setText(String.valueOf(Integer.parseInt(remainDaysLabel.getText()) -1));
				}else if(Integer.parseInt(remainDaysLabel.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "<html>" + idLabel.getText() + "��, ���� �̿����� �����ϴ�<br>��� �̿��� ���Ͻø� �߰� ������ ���ּ���</html>", "�⼮üũ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		// �⼮üũ ����
		info = new JLabel("�⼮üũ", JLabel.LEFT);
		customerPanel.add(info);
		info.setBounds(745, 50, 270, 100);
		info.setFont(new Font("���� ���", Font.PLAIN, 12));
		info.setOpaque(true); //Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
		info.setForeground(new Color(136,150,159));
		info.setText("<html>��� ��ư�� ������ ���� �ϼ��� �����˴ϴ�<br>��� ��ư�� ������ ���Թ��� �����ϴ�<br>�߰� ���� => ī���ͷ� ����</html>");
		
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
				BmiFrame bmi = new BmiFrame();
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
				BmrFrame bmr = new BmrFrame();
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
	
	// �⼮üũ �޼���
	public boolean attend(String id) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set remain_days=? where id=?");

            pst.setDouble(1, Integer.parseInt(remainDaysLabel.getText()) - 1);
            pst.setString(2, id);

            int numRows = pst.executeUpdate();

            System.out.format("�⼮üũ : %d���� ���� �ٲ����ϴ�.", numRows);

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
class BmiFrame extends JFrame{
	JFrame frame;
	JPanel bmiPanel;
	
	JTextField WeightField;
	JTextField HeightField;
	JLabel BmiResult;
	JButton BmiUpdate;
	
	double bmi;
	
	BmiFrame() {
		frame = new JFrame(); //frame ����
		frame.setResizable(false); //frame�� ���̵��� ����
		frame.setBounds(470, 200, 1000, 600); //frame�� ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݵ��� ����
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
		frame.setTitle("Daily Health - bmi ���"); //Ÿ��Ʋ ����
		
		//��Ŷ�� ����Ͽ� �̹��� �����
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png ������ �̹��� ���ϸ� ����
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		bmiPanel = new JPanel();
		bmiPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(bmiPanel);
		bmiPanel.setLayout(null);

		JLabel WeightLabel = new JLabel("\uBAB8\uBB34\uAC8C : ");
		WeightLabel.setBounds(48, 109, 113, 34);
		WeightLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		
		bmiPanel.add(WeightLabel);
		
		WeightField = new JTextField();
		WeightField.setBounds(162, 109, 172, 35);
		bmiPanel.add(WeightField);
		WeightField.setColumns(10);
		WeightField.setFont(new Font("���� ���", Font.PLAIN, 22));
		WeightField.setText(CustomerDisplay.currentWeightLabel.getText());
		
		JLabel lblkg = new JLabel("(kg\uB2E8\uC704)");
		lblkg.setBounds(337, 109, 104, 34);
		lblkg.setFont(new Font("���� ���", Font.BOLD, 25));
		bmiPanel.add(lblkg);
		
		JLabel HeightLabel = new JLabel("\uD0A4 : ");
		HeightLabel.setBounds(48, 158, 113, 34);
		HeightLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		bmiPanel.add(HeightLabel);
		
		HeightField = new JTextField();
		HeightField.setBounds(162, 158, 172, 35);
		HeightField.setColumns(10);
		HeightField.setFont(new Font("���� ���", Font.PLAIN, 22));
		HeightField.setText(CustomerDisplay.heightLabel.getText());
		bmiPanel.add(HeightField);
		
		JLabel lblcm = new JLabel("(cm\uB2E8\uC704)");
		lblcm.setBounds(337, 158, 104, 34);
		lblcm.setFont(new Font("���� ���", Font.BOLD, 25));
		bmiPanel.add(lblcm);
		
		BmiUpdate = new JButton();
		
		JButton BmiButton = new JButton("BMI \uC9C0\uC218 \uACC4\uC0B0");
		BmiButton.setFont(new Font("���� ���", Font.BOLD, 22));
		BmiButton.setBackground(new Color(151, 201, 210));
		BmiButton.setBounds(468, 112, 180, 85);
		BmiButton.setBorderPainted(false);
		BmiButton.setFocusPainted(false);
		bmiPanel.add(BmiButton);
		BmiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(BmiResult != null) {
						BmiResult.setVisible(false);
					}
					double weight = Double.parseDouble(WeightField.getText()); //�Է¹��� �����Ը� ���� weight�� �־��ش�
					double height = Double.parseDouble(HeightField.getText()); //�Է¹��� Ű�� ���� height�� �־��ش�
					double var = weight/((height*(0.01))*(height*(0.01))); //Bmi������ ���ϴ� �����̴�
					if(0<var && var<18.5) { //���Ǽ�����
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ��ü���Դϴ�"); //���̺��� �̿��� ���
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(18.5<=var && var<23) {//���Ǽ�����
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ����ü���Դϴ�");//���̺��� �̿��� ���
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(23<=var && var<25) {//���Ǽ�����
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ��ü���Դϴ�");//���̺��� �̿��� ���
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(25<=var && var<30) { //���Ǽ�����
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �浵���Դϴ�");//���̺��� �̿��� ���
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(var<=30 && var<40) {//���Ǽ�����
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �����Դϴ�");//���̺��� �̿��� ���
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);		
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else {//���ǵ� �� �� �ÿ�
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �ʰ����Դϴ�");
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI ����ϱ�");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmi) + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
					}//end of if~else if~else��
				// bmi db�� �߰��ϴ� �ڵ�
				}catch(NumberFormatException num) {
					BmiResult = new JLabel("���ڸ� �Է����ּ���");
					BmiResult.setForeground(Color.RED);
					bmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);	
				}
			}
		});
		
		BmiUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel + "��, " + BmiResult.getText() + "�� bmi ������ ����Ͻðڽ��ϱ�?", "bmi ����ϱ�", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
					JOptionPane.showMessageDialog(null, "bmi ������ ��ϵǾ����ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
					CustomerDisplay.bmiLabel.setText(BmiResult.getText());
				}else if(option == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "bmi ���� ����� ����ϼ̽��ϴ�", "bmi ����ϱ�", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		// bmi�� ���� �񸸵� �̹���
		JButton bmiImage = new JButton("");
		bmiImage.setBounds(139, 378, 742, 110);
		bmiImage.setIcon(new ImageIcon("./image/bmi.png")); //bmi������ ���� �񸸵��� �����ִ� ����
		bmiPanel.add(bmiImage);
		bmiImage.setBorderPainted(false);
		bmiImage.setFocusPainted(false);
		
		// �������� ȭ��
		JButton gotoMain_bmi = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmi.setFont(new Font("���� ���", Font.PLAIN, 15));
		gotoMain_bmi.setBackground(new Color(218, 226, 234));
		gotoMain_bmi.setBounds(863, 12, 105, 27);
//		bmiPanel.add(gotoMain_bmi);
		
		JLabel lblBmi = new JLabel("BMI ���� ���ϱ�");
		lblBmi.setFont(new Font("���� ���", Font.BOLD, 30));
		lblBmi.setBounds(48, 31, 239, 47);
		bmiPanel.add(lblBmi);
		bmiImage.setBorderPainted(false);
		bmiImage.setFocusPainted(false);
		
		// bmi ���� Label
		JLabel bmiInfo = new JLabel("<html>BMI�� �ڽ��� ������(kg)�� Ű�� ����(m)���� ���� ���Դϴ�<br>"
				+ "*���� : ������, ������ ���� �� ������ �ݿ����� ���� �� �ֽ��ϴ�</html>", JLabel.LEFT);
		bmiInfo.setFont(new Font("���� ���", Font.BOLD, 13));
		bmiInfo.setForeground(new Color(136,150,159));
		bmiInfo.setBounds(300, 15, 410, 80);
		bmiPanel.add(bmiInfo);
		
		// �ʱ�ȭ ��ư
		JButton new_bmi = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
		new_bmi.setFont(new Font("���� ���", Font.PLAIN, 17));
		new_bmi.setBackground(new Color(218, 226, 234));
		new_bmi.setBorderPainted(false);
		new_bmi.setFocusPainted(false);
		new_bmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BmiResult != null) {
					BmiResult.setVisible(false);
				}
				WeightField.setText("");
				HeightField.setText("");
			}
		});
		new_bmi.setBackground(new Color(200,222,228));
		new_bmi.setBounds(845, 49, 120, 30);
		
		bmiPanel.add(new_bmi);
		
		gotoMain_bmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	public boolean updateBmi(double bmi) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set bmi=? where id=?");

            pst.setDouble(1, Math.round(bmi));
            pst.setString(2, CustomerDisplay.idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("bmi ��� : %d���� ���� �ٲ����ϴ�.", numRows);

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

class BmrFrame extends JFrame{
	JFrame frame;
	JPanel bmrPanel;
	
	JTextField Weight_t;
	JTextField Height_t;
	JTextField Age_t;
	
	JLabel BmrResult;
	JButton BmrUpdate;
	
	double bmr;
	
	BmrFrame() {
		frame = new JFrame(); //frame ����
		frame.setResizable(false); //frame�� ���̵��� ����
		frame.setBounds(470, 200, 1000, 600); //frame�� ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݵ��� ����
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
		frame.setTitle("Daily Health - bmr ���"); //Ÿ��Ʋ ����
		
		//��Ŷ�� ����Ͽ� �̹��� �����
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png ������ �̹��� ���ϸ� ����
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		bmrPanel = new JPanel();
		bmrPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(bmrPanel);
		bmrPanel.setLayout(null);
		
		JRadioButton Man = new JRadioButton("\uB0A8\uC790");
		Man.setFont(new Font("���� ���", Font.BOLD, 20));
		Man.setBounds(159, 140, 77, 27);
		bmrPanel.add(Man);
		
		JRadioButton Woman = new JRadioButton("\uC5EC\uC790");
		Woman.setFont(new Font("���� ���", Font.BOLD, 20));
		Woman.setBounds(159, 171, 77, 27);
		bmrPanel.add(Woman);
		
		JLabel Gender = new JLabel("\uC131\uBCC4 : ");
		Gender.setFont(new Font("���� ���", Font.BOLD, 22));
		Gender.setBounds(61, 140, 69, 27);
		bmrPanel.add(Gender);
		
		JLabel Weight = new JLabel("\uCCB4\uC911 : ");
		Weight.setFont(new Font("���� ���", Font.BOLD, 22));
		Weight.setBounds(61, 236, 69, 27);
		bmrPanel.add(Weight);
		
		JLabel Height = new JLabel("\uD0A4(cm) : ");
		Height.setFont(new Font("���� ���", Font.BOLD, 22));
		Height.setBounds(61, 312, 91, 27);
		bmrPanel.add(Height);
		
		JLabel Age = new JLabel("\uB098\uC774 : ");
		Age.setFont(new Font("���� ���", Font.BOLD, 22));
		Age.setBounds(61, 381, 69, 27);
		bmrPanel.add(Age);
		
		Weight_t = new JTextField();
		Weight_t.setBounds(159, 236, 137, 29);
		bmrPanel.add(Weight_t);
		Weight_t.setColumns(10);
		Weight_t.setText(CustomerDisplay.currentWeightLabel.getText());
		Weight_t.setFont(new Font("���� ���", Font.PLAIN, 20));
		
		Height_t = new JTextField();
		Height_t.setColumns(10);
		Height_t.setBounds(159, 312, 137, 29);
		bmrPanel.add(Height_t);
		Height_t.setText(CustomerDisplay.heightLabel.getText());
		Height_t.setFont(new Font("���� ���", Font.PLAIN, 20));
		
		Age_t = new JTextField();
		Age_t.setColumns(10);
		Age_t.setBounds(159, 381, 137, 29);
		bmrPanel.add(Age_t);
		Age_t.setText(CustomerDisplay.ageLabel.getText());
		Age_t.setFont(new Font("���� ���", Font.PLAIN, 20));
		
		JPanel ChoicePanel = new JPanel();
		ChoicePanel.setBackground(new Color(240, 237, 240));
		ChoicePanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(ChoicePanel);
		ChoicePanel.setLayout(null);
		
		JButton gotoMain_bmr = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmr.setBounds(863, 12, 105, 27);
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
//		bmrPanel.add(gotoMain_bmr);
		gotoMain_bmr.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		JButton BmrButton = new JButton("\uACC4\uC0B0\uD558\uAE30");
		BmrButton.setFont(new Font("���� ���", Font.BOLD, 22));
		BmrButton.setBackground(new Color(102, 159, 175));
		BmrButton.setBounds(61, 463, 235, 55);
		BmrButton.setBorderPainted(false);
		BmrButton.setFocusPainted(false);
		bmrPanel.add(BmrButton);
		gotoMain_bmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoicePanel.setVisible(true);
				bmrPanel.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 25));
		lblNewLabel.setBounds(381, 220, 515, 69);
		bmrPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uAD6C\uD558\uAE30");
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 30));
		lblNewLabel_1.setBounds(61, 46, 259, 47);
		bmrPanel.add(lblNewLabel_1);
		
		gotoMain_bmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoicePanel.setVisible(true);
				bmrPanel.setVisible(false);
			}
		});
		
		BmrButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bmrPanel.setVisible(true);
				ChoicePanel.setVisible(false);
				BmrResult = new JLabel();
				//BmrResult.setVisible(false);
				bmrPanel.setVisible(true);
				int num;
				if(Man.isSelected()==true) { //������ ���õ� ��
					num = 1;//num = 1�̴�
				}else if(Woman.isSelected()==true) {//������ ���õ� ��
					num = 2;//num = 2�̴�
				}else {
					num = 0;
				}
				try {
					if(BmrResult != null) {
						BmrResult.setVisible(false);
					}
					switch(num) {
					case 1 : //num�� 1�϶�
						double Weight_m = Double.parseDouble(Weight_t.getText());
						double Height_m = Double.parseDouble(Height_t.getText());
						int Age_m = Integer.parseInt(Age_t.getText());
						double Bmr_m = 66.47 + (13.75*Weight_m) + (5*Height_m) - (6.76*Age_m); //������ ���� ���ʴ�緮 ����
						BmrResult = new JLabel("���ʴ�緮�� " + Math.round(Bmr_m*100)/100.0 + "kcal�Դϴ�");
						bmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("���� ���", Font.PLAIN, 25));
						BmrResult.setBounds(370, 230, 600, 50);
						BmrResult.setVisible(true);//���̺��� �̿��� ���ʴ�緮 ����� ������ش�
						
						bmr = Math.round(Bmr_m*100)/100.0;
						
						BmrUpdate = new JButton("bmr ����ϱ�");
						bmrPanel.add(BmrUpdate);
						BmrUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmrUpdate.setBounds(370, 300, 200, 60);
						BmrUpdate.setVisible(true);
						BmrUpdate.setForeground(Color.BLACK);
						BmrUpdate.setBackground(new Color(223,161,158));
						BmrUpdate.setBorderPainted(false);
						BmrUpdate.setFocusPainted(false);
											
						BmrUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmr) + "�� bmr ������ ����Ͻðڽ��ϱ�?", "bmr ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updatebmr(bmr) == true) {
									JOptionPane.showMessageDialog(null, "bmr ������ ��ϵǾ����ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmrLabel.setText(String.valueOf(bmr));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmr ���� ����� ����ϼ̽��ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmr ���� ����� ����ϼ̽��ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
						
						break;//���۱׸�
					case 2 : //num�� 2�϶�
						double Weight_w = Double.parseDouble(Weight_t.getText());
						double Height_w = Double.parseDouble(Height_t.getText());
						int Age_w = Integer.parseInt(Age_t.getText());
						double Bmr_w = 655.1 + (9.56*Weight_w) + (1.85*Height_w) - (4.68*Age_w); //������ ���� ���ʴ�緮 ����
						BmrResult.setLocation(1300, 600);
						BmrResult = new JLabel("���ʴ�緮�� " + Math.round(Bmr_w*100)/100.0 + "kcal�Դϴ�");
						bmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("���� ���", Font.PLAIN, 25));
						BmrResult.setBounds(370, 230, 600, 50);
						BmrResult.setVisible(true); //���̺��� �̿��� ���ʴ�緮 ����� ������ش�
						
						bmr = Math.round(Bmr_w*100)/100.0;
						
						BmrUpdate = new JButton("bmr ����ϱ�");
						bmrPanel.add(BmrUpdate);
						BmrUpdate.setFont(new Font("���� ���", Font.BOLD, 22));
						BmrUpdate.setBounds(370, 300, 200, 60);
						BmrUpdate.setVisible(true);
						BmrUpdate.setForeground(Color.BLACK);
						BmrUpdate.setBackground(new Color(223,161,158));
						BmrUpdate.setBorderPainted(false);
						BmrUpdate.setFocusPainted(false);
											
						BmrUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "��, " + String.valueOf(bmr) + "�� bmr ������ ����Ͻðڽ��ϱ�?", "bmr ����ϱ�", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updatebmr(bmr) == true) {
									JOptionPane.showMessageDialog(null, "bmr ������ ��ϵǾ����ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmrLabel.setText(String.valueOf(bmr));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmr ���� ����� ����ϼ̽��ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmr ���� ����� ����ϼ̽��ϴ�", "bmr ����ϱ�", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
						
						break;//���۱׸�
					}
				}catch(NumberFormatException ex) {
					BmrResult = new JLabel("���ڸ� �Է����ּ���");
					bmrPanel.add(BmrResult);
					BmrResult.setFont(new Font("���� ���", Font.PLAIN, 25));
					BmrResult.setBounds(370, 230, 600, 50);
					BmrResult.setVisible(true); 
					BmrResult.setForeground(Color.RED);
				}
			}
		});
		JButton new_bmr = new JButton("�ʱ�ȭ");
		new_bmr.setFont(new Font("���� ���", Font.PLAIN, 15));
		new_bmr.setBackground(new Color(218, 226, 234));
		new_bmr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BmrResult != null) {
					BmrResult.setVisible(false);
				}
				Weight_t.setText("");
				Height_t.setText("");
				Age_t.setText("");
			}
		});
		new_bmr.setBounds(863, 51, 105, 27);
		new_bmr.setBorderPainted(false);
		new_bmr.setFocusPainted(false);
		bmrPanel.add(new_bmr);
	}
	public boolean updatebmr(double bmr) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set bmr=? where id=?");

            pst.setDouble(1, Math.round(bmr));
            pst.setString(2, CustomerDisplay.idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("bmr ��� : %d���� ���� �ٲ����ϴ�.", numRows);

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