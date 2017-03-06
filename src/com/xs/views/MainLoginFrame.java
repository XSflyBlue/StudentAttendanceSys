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
import javax.swing.JPanel;

import com.xs.util.WindowsHandler;

public class MainLoginFrame extends JFrame {
	/**
	 * 学生考勤管理系统 
	 *   登录入口窗体
	 * 
	 * @author flyblue
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 300; //默认窗体宽度
	private static final int DEFAULT_HEIGHT = 300;//默认窗体高度

	public MainLoginFrame(String title) { 		  //窗体类
		/**
		 * 窗体常见设置
		 * 
		 */		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);      // 设置窗体大小
		setTitle(title);							 // 设置窗体标题
		
		// 居中显示。
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation((screenWidthpx-getWidth()) / 2, (screenHeightpx-getHeight()) / 2);
		setLocationByPlatform(false);
		
		// 设置窗口最小化时显示的图标，可选。
		Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
		setIconImage(img);
		
		// 设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		MainLoginPanel loginPanel = new MainLoginPanel();
		setContentPane(loginPanel);
		
		// 设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		// 注册窗口监听器
		addWindowListener(new WindowsHandler());
	}

	private class MainLoginPanel extends JPanel { //面板容器类
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// 定义登陆容器Panel中的控件元素。
		JLabel picLabel;
		JButton stuLoginButton, tchLoginButton;
		JPanel infoPanel;

		// 登陆容器panel构造，将所有控件元素装入容器。
		public MainLoginPanel() {
			// 生成所有控件对象
			picLabel = new JLabel();
			stuLoginButton = new JButton("点击跳转到学生登录界面"); // 构造器参数为按钮显示文本
			tchLoginButton = new JButton("点击跳转到教工登录界面");
			infoPanel = new JPanel();
			// 设置StuLoginPanel布局为BorderLayout。
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
			infoPanel.add(stuLoginButton);
			infoPanel.add(tchLoginButton);
			add(infoPanel, BorderLayout.CENTER);
			// 依次添加按钮控件到面板容器， buttonPanel布局管理器默认流布局，
			// 并将buttonPanel控件作为StuLoginPanel的底端组件。
			//事件绑定
			ButtonAction buttonAction = new ButtonAction();
			stuLoginButton.addActionListener(buttonAction);
			tchLoginButton.addActionListener(buttonAction);
		}
		
		private class ButtonAction implements ActionListener { //按钮监听类
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(stuLoginButton)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							StuLoginFrame frame = new StuLoginFrame("学生登陆入口");
						}
					});
					MainLoginFrame.this.setVisible(false);
				} else {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							TchLoginFrame frame = new TchLoginFrame("教工登陆入口");
						}
					});
					MainLoginFrame.this.setVisible(false);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//程序入口
		MainLoginFrame frame = new MainLoginFrame("学生考勤管理系统");
	}
}
