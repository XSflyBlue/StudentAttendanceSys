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
	 * ѧ�����ڹ���ϵͳ 
	 *   ��¼��ڴ���
	 * 
	 * @author flyblue
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 300; //Ĭ�ϴ�����
	private static final int DEFAULT_HEIGHT = 300;//Ĭ�ϴ���߶�

	public MainLoginFrame(String title) { 		  //������
		/**
		 * ���峣������
		 * 
		 */		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);      // ���ô����С
		setTitle(title);							 // ���ô������
		
		// ������ʾ��
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height;
		setLocation((screenWidthpx-getWidth()) / 2, (screenHeightpx-getHeight()) / 2);
		setLocationByPlatform(false);
		
		// ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
		setIconImage(img);
		
		// ���ô����������壬�������������е���ЧGUI�����Ϣ
		MainLoginPanel loginPanel = new MainLoginPanel();
		setContentPane(loginPanel);
		
		// ���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		// ע�ᴰ�ڼ�����
		addWindowListener(new WindowsHandler());
	}

	private class MainLoginPanel extends JPanel { //���������
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// �����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel;
		JButton stuLoginButton, tchLoginButton;
		JPanel infoPanel;

		// ��½����panel���죬�����пؼ�Ԫ��װ��������
		public MainLoginPanel() {
			// �������пؼ�����
			picLabel = new JLabel();
			stuLoginButton = new JButton("�����ת��ѧ����¼����"); // ����������Ϊ��ť��ʾ�ı�
			tchLoginButton = new JButton("�����ת���̹���¼����");
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
			infoPanel.add(stuLoginButton);
			infoPanel.add(tchLoginButton);
			add(infoPanel, BorderLayout.CENTER);
			// ������Ӱ�ť�ؼ������������ buttonPanel���ֹ�����Ĭ�������֣�
			// ����buttonPanel�ؼ���ΪStuLoginPanel�ĵ׶������
			//�¼���
			ButtonAction buttonAction = new ButtonAction();
			stuLoginButton.addActionListener(buttonAction);
			tchLoginButton.addActionListener(buttonAction);
		}
		
		private class ButtonAction implements ActionListener { //��ť������
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(stuLoginButton)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							StuLoginFrame frame = new StuLoginFrame("ѧ����½���");
						}
					});
					MainLoginFrame.this.setVisible(false);
				} else {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							TchLoginFrame frame = new TchLoginFrame("�̹���½���");
						}
					});
					MainLoginFrame.this.setVisible(false);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//�������
		MainLoginFrame frame = new MainLoginFrame("ѧ�����ڹ���ϵͳ");
	}
}
