package com.xs.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xs.bean.Student;
import com.xs.dao.IStudentDao;
import com.xs.dao.impl.StudentDaoImpl;

/**
 * ѧ�����ڹ���ϵͳ 
 *   ѧ����½����
 *    
 * @author flyblue
 */
public class StuLoginFrame extends JFrame {
	/**
	 * ��Ա����
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JFrame parentFrame;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public StuLoginFrame(String title) {			//������

		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);		// ���ô����С
		setTitle(title);		                    // ���ô������
		
		// ������ʾ
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation((screenWidthpx-300) / 2, (screenHeightpx-300) / 2);
		setLocationByPlatform(false);
		
		// ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
		setIconImage(img);
		
		// ���ô����������壬�������������е���ЧGUI�����Ϣ
		StuLoginPanel loginPanel = new StuLoginPanel();
		setContentPane(loginPanel);
		
		// ���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private class StuLoginPanel extends JPanel {		//���������
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// �����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel;
		JLabel idLabel, pwdLabel;
		JTextField stuIdTextField;
		JPasswordField pwdField;
		JButton okButton, clearButton;
		JPanel buttonPanel, infoPanel;

		// ��½����panel���죬�����пؼ�Ԫ��װ��������
		public StuLoginPanel() {
			// �������пؼ�����
			picLabel = new JLabel();
			idLabel = new JLabel("ѧ��ID�� "); // ����������Ϊ��ǩ��ʾ�ı�
			pwdLabel = new JLabel("��    �룺 "); // ����������Ϊ��ǩ��ʾ�ı�
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("��½"); // ����������Ϊ��ť��ʾ�ı�
			clearButton = new JButton("�����Ϣ");
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			// ����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout());
			// �������pic�� login��Ϣ�ؼ������������
			// ������infoPanel���ֹ�����ΪFlowLayout��
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT / 2);
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top1.jpg"));
			image.setImage(
					image.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_DEFAULT));
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			infoPanel.add(idLabel);
			infoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			infoPanel.add(stuIdTextField);
			infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			infoPanel.add(pwdLabel);
			infoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			infoPanel.add(pwdField);
			add(infoPanel, BorderLayout.CENTER);
			
			// ������Ӱ�ť�ؼ������������ buttonPanel���ֹ�����Ĭ�������֣�
			// ����buttonPanel�ؼ���ΪStuLoginPanel�ĵ׶������
			buttonPanel.add(okButton);
			buttonPanel.add(clearButton);
			add(buttonPanel, BorderLayout.SOUTH);
			//���¼�
			ButtonAction buttonAction = new ButtonAction();
			okButton.addActionListener(buttonAction);
			clearButton.addActionListener(buttonAction);
		}
		
		private class ButtonAction implements ActionListener {  //��ť������
			@Override
			public void actionPerformed(ActionEvent e) {        //��¼��֤
				if (e.getSource().equals(okButton)) {
					String username = stuIdTextField.getText().trim();
					char[] text = pwdField.getPassword();
					String password = String.valueOf(text);

					if (username.equals("")) {
						JOptionPane.showMessageDialog(null, "�û���Ϊ�գ�", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (password.equals("")) {
						JOptionPane.showMessageDialog(null, "����Ϊ�գ�", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							IStudentDao stuDao = new StudentDaoImpl();
							Student student=null;
							try {
								student = stuDao.selectByPrimaryKey(Integer.parseInt(username));
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							if (student != null && student.getStudent_login_pwd().equals(password)) {
								StuFuncPortalFrame frame = new StuFuncPortalFrame(username);
								frame.setVisible(true);
								frame.parentFrame = StuLoginFrame.this;
								StuLoginFrame.this.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "���������û��������ڣ�", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
								pwdField.setText("");
							}
						}
					});
				} else {
					stuIdTextField.setText("");
					pwdField.setText("");
				}
			}
		}
	}

    /**
     * ����Ч������
     */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		StuLoginFrame frame = new StuLoginFrame("ѧ����½����");
//	}
}
