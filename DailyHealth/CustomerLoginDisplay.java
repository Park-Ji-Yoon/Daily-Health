// ����â : ȸ������Ʈ ���
package health;

import java.awt.BorderLayout; // ��������(�����¿�)�� ����� ��ġ�� �� ������, �⺻���Դϴ�.
import java.awt.Color; //�� ColorŬ������ �⺻ sRGB���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���˴ϴ� 
import java.awt.Component; // Abstract Window Toolkit ��������� �߻� ���� Ŭ����, ������ ������Ҹ� ����� ���� Ŭ������ ���� Ȯ���� ���� �ֽ��ϴ�. 
import java.awt.Font; //�ڹٿ��� �Է��� ���ڿ� ȿ���� �� �� Font Ŭ������ Ȱ���Ѵ�.
import java.awt.Image; //�ڹٿ��� �̹����� java.awt.Image Ŭ������ ��ü�� ǥ��
import java.awt.Toolkit; //��Ŷ�� java.awt.Toolkit Ŭ������ ���� ���� / �������� ����� �ڵ����� ����
import java.awt.event.*; //�̺�Ʈ ������ ������ ������ �������ο��� �ַ� ��ġ��Ų��.
import java.util.*; //java.util ��Ű���� ��� Ŭ������ �ҷ����� ��
import javax.swing.*; //java���� gui�� �����ϱ� ���� jdk���� �⺻������ �����ϴ� ��
import javax.swing.table.DefaultTableModel;  //DefaultTableModel ��� => JTable ��ü�� ������ �� DefaultTableModel�̶�� �������� �������ִ� �Ͱ� ����
import java.awt.FlowLayout; //Button ������� ���弱���� FlowLayoutŬ������ ����ϰ� �ִ�. ���� ���� ��ư�� ����� ������� ��ġ�ϴ� Ŭ�����̴�.
import java.sql.*;

public class CustomerLoginDisplay extends JFrame implements MouseListener,ActionListener{
	private JFrame frame;
	JTextField idField;
	JPasswordField pwField;
	
	String name = "";
	String id = "";
	String address = "";
	String phone = "";
	String age = "";
	String height = "";
	String bmi = "";
	String bmr = "";
	String remain_days = "";
	String current_weight = "";
	String target_weight = "";
	
	//������ �޼ҵ�
	public CustomerLoginDisplay() { 
		frame = new JFrame(); //frame ����
		frame.setResizable(false); //frame�� ���̵��� ����
		frame.setBounds(470, 200, 1000, 600); //frame�� ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݵ��� ����
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
		frame.setTitle("Daily Health - ȸ�� �α��� ������"); //Ÿ��Ʋ ����
		
		//��Ŷ�� ����Ͽ� �̹��� �����
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png ������ �̹��� ���ϸ� ����
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("�α���", JLabel.CENTER);
		loginPanel.add(loginLabel);
		loginLabel.setFont(new Font("���� ���", Font.BOLD, 32));
		loginLabel.setBounds(350, 90, 300, 60);
		
		// ���̵� ��
		JLabel idLabel = new JLabel("���̵�");
		loginPanel.add(idLabel);
		idLabel.setBounds(290, 200, 70, 60);
		idLabel.setFont(new Font("���� ���", Font.PLAIN, 16));
		
		// ���̵� textfield
		idField = new JTextField();
		loginPanel.add(idField);
		idField.setBounds(390, 200, 300, 60);
		idField.setFont(new Font("���� ���", Font.PLAIN, 24));
		
		
		// ��й�ȣ textfield
		JLabel pwLabel = new JLabel("��й�ȣ");
		loginPanel.add(pwLabel);
		pwLabel.setBounds(290, 285, 70, 60);
		pwLabel.setFont(new Font("���� ���", Font.PLAIN, 16));
		
		// ��й�ȣ ��
		pwField = new JPasswordField();
		loginPanel.add(pwField);
		pwField.setBounds(390, 285, 300, 60);
		pwField.setFont(new Font("���� ���", Font.PLAIN, 24));
		
		// �α��� Ȯ�� ��ư
		JButton loginBtn = new JButton("�α���");
		loginPanel.add(loginBtn);
		loginBtn.setBounds(360, 380, 130, 70);
		loginBtn.setBackground(new Color(240, 237, 240));
		loginBtn.setFont(new Font("���� ���", Font.PLAIN, 24));
		
		// �α��� Ȯ�� ��ư Ŭ�� �̺�Ʈ
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CustomerLogin() == true) {
					idField.setText("");
					pwField.setText("");
					frame.setVisible(false);
					new CustomerDisplay();
					CustomerDisplay.nameLabel.setText(name);
                	CustomerDisplay.idLabel.setText(id);
                	CustomerDisplay.addressLabel.setText(address);
                	CustomerDisplay.phoneLabel.setText(phone);
                	CustomerDisplay.ageLabel.setText(age);
                	CustomerDisplay.currentWeightLabel.setText(current_weight);
                	CustomerDisplay.targetWeightLabel.setText(target_weight);
                	CustomerDisplay.heightLabel.setText(height);
                	CustomerDisplay.remainDaysLabel.setText(remain_days);
                	CustomerDisplay.bmiLabel.setText(bmi);
                	CustomerDisplay.bmrLabel.setText(bmr);
				}else {
					idField.setText("");
					pwField.setText("");
				}
			}
		});
		
		// �α��� ��� ��ư
		JButton loginExitBtn = new JButton("���");
		loginPanel.add(loginExitBtn);
		loginExitBtn.setBounds(520, 380, 130, 70);
		loginExitBtn.setBackground(new Color(218, 226, 234));
		loginExitBtn.setFont(new Font("���� ���", Font.PLAIN, 24));
		
		// �α��� ��� ��ư Ŭ�� �̺�Ʈ
		loginExitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LogoChoice();
			}
		});
		
	}//end of MainDisplay(and ������)
		
	public static void main(String[] args) {
		new CustomerLoginDisplay(); //Member-List Ŭ���� ����
	}//end of main

	public boolean CustomerLogin() {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            query = "SELECT id, pwd, name, homeAddress, phone, age, CurrentWeight, TargetWeight, height, period, remain_days, bmi, bmr FROM jiyoon";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
//			CustomerDisplay c = new CustomerDisplay();
			
            while (result = rset.next()) {
                if(rset.getString("id").equals(idField.getText()) && rset.getString("pwd").equals(pwField.getText())){
                	JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                	
                	name = rset.getString("name");
                	id = rset.getString("id");
                	address = rset.getString("homeAddress");
                	phone = rset.getString("phone");
                	age = rset.getString("age");
                	current_weight = rset.getString("CurrentWeight");
                	target_weight = rset.getString("TargetWeight");
                	height = rset.getString("height");
                	remain_days = rset.getString("remain_days");
                	bmi = rset.getString("bmi");
                	bmr = rset.getString("bmr");
                	
                	return true;
                }
            }
            
            //�α��� ���� ��
            if(result == false) {
            	JOptionPane.showMessageDialog(null, "���̵�, ��й�ȣ�� �߸��ԷµǾ����ϴ�.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
	
	//MouseListener �������̽��� ������ 4�� �޼ҵ嵵 ��� ������ �Ͽ��� ������ ��
	@Override
	public void mouseEntered(MouseEvent e) { //���콺�� �ش� ������Ʈ ���� ������ ���� �� �߻�	
	}
	@Override
	public void mouseExited(MouseEvent e) { //���콺�� �ش� ������Ʈ ���� ������ ���� �� �߻�	
	}
	@Override
	public void mousePressed(MouseEvent e) { //���콺 ��ư�� ���� �� �߻�
	
	}
	@Override
	public void mouseReleased(MouseEvent e) { //������ ���콺�� ���� �� �߻�
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
}//end of MainDisplay