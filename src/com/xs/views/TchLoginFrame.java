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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xs.bean.Teacher;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.TeacherDaoImpl;

/**
 * 学生考勤管理系统 
 *   教工登陆窗体
 *    
 * @author flyblue
 */
public class TchLoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	public TchLoginFrame(String title) {		//窗体类
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);		// 设置窗体大小
		setTitle(title);		                    // 设置窗体标题
		
		// 居中显示。
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation((screenWidthpx-300) / 2, (screenHeightpx-300) / 2);
		setLocationByPlatform(false);
		
		// 设置窗口最小化时显示的图标，可选。
		Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
		setIconImage(img);
		
		// 设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		TchLoginPanel loginPanel = new TchLoginPanel();
		setContentPane(loginPanel);
		
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private class TchLoginPanel extends JPanel {		//面板容器类
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// 定义登陆容器Panel中的控件元素。
		JLabel picLabel;
		JLabel idLabel, pwdLabel;
		JTextField stuIdTextField;
		JPasswordField pwdField;
		JButton okButton, clearButton;
		JPanel buttonPanel, infoPanel;
		JCheckBox adminCheckBox;

		// 登陆容器panel构造，将所有控件元素装入容器。
		public TchLoginPanel() {
			// 生成所有控件对象
			picLabel = new JLabel();
			idLabel = new JLabel("教工ID： "); // 构造器参数为标签显示文本
			pwdLabel = new JLabel("密    码： "); // 构造器参数为标签显示文本
			stuIdTextField = new JTextField(20);
			pwdField = new JPasswordField(20);
			okButton = new JButton("登陆"); // 构造器参数为按钮显示文本
			clearButton = new JButton("清空信息");
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			adminCheckBox = new JCheckBox("我是管理员");
			
			// 设置TchLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout());
			// 依次添加pic、 login信息控件到面板容器，
			// 并设置infoPanel布局管理器为FlowLayout。
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
			
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			infoPanel.add(adminCheckBox);
			add(infoPanel, BorderLayout.CENTER);
			
			// 依次添加按钮控件到面板容器， buttonPanel布局管理器默认流布局，
			// 并将buttonPanel控件作为StuLoginPanel的底端组件。
			buttonPanel.add(okButton);
			buttonPanel.add(clearButton);
			add(buttonPanel, BorderLayout.SOUTH);
			//绑定事件
			ButtonAction buttonAction = new ButtonAction();
			okButton.addActionListener(buttonAction);
			clearButton.addActionListener(buttonAction);
		}

		private class ButtonAction implements ActionListener {		//按钮监听类
			@Override
			public void actionPerformed(ActionEvent e) {		//登录验证
				if (e.getSource().equals(okButton)) {
					String username = stuIdTextField.getText().trim();
					char[] text = pwdField.getPassword();
					String password = String.valueOf(text);

					if (username.equals("")) {
						JOptionPane.showMessageDialog(null, "用户名为空！", "登录失败", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (password.equals("")) {
						JOptionPane.showMessageDialog(null, "密码为空！", "登录失败", JOptionPane.ERROR_MESSAGE);
						return;
					}

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							ITeacherDao tchDao = new TeacherDaoImpl();
							Teacher teacher =null;
							try {
								teacher= tchDao.selectByPrimaryKey(Integer.parseInt(username));
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "数据库连接失败", "登录失败", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							if (teacher != null && teacher.getTeacher_login_pwd().equals(password)) {
								TchFuncPortalFrame frame = new TchFuncPortalFrame(username);
								frame.setVisible(true);
								frame.parentFrame = TchLoginFrame.this;
								TchLoginFrame.this.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "密码错误或用户名不存在！", "登录失败", JOptionPane.ERROR_MESSAGE);
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

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TchLoginFrame frame = new TchLoginFrame("教工登陆窗口");
//	}

}
