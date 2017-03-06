package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.xs.bean.Student;
import com.xs.bean.Teacher;
import com.xs.dao.IStudentDao;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.StudentDaoImpl;
import com.xs.dao.impl.TeacherDaoImpl;

/**
 *
 * @author flyblue
 */
public class UpdatePwdFrame extends javax.swing.JFrame {
    /**
	 * 成员变量
	 */
	private static final long serialVersionUID = 1L;
	
	protected StuFuncPortalFrame parentFrame;
	protected TchFuncPortalFrame parentFrame1;
	private String flagId;
	
	// Variables declaration                     
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JPasswordField jPasswordField3;

    /**
     * 构造方法
     */
    public UpdatePwdFrame() {
        initComponents();
    }

    public UpdatePwdFrame(String flagId) {
    	this.flagId=flagId;
        initComponents();
    }

    // <Generated Code">                          
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jPasswordField3 = new JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     	setTitle("修改个人密码");        // 设置窗体标题      
   		setResizable(false);   		// 设置窗口不可变
     	
     	// 居中显示。
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-350) / 2, (screenHeightpx-230) / 2);
   		setLocationByPlatform(false);
   		
        // 设置窗口最小化时显示的图标，可选。
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

        // 功能按钮区域
        jButton1.setText("确认修改");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        
        jButton2.setText("返回上级菜单");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        // 密码框
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("修改密码"));

        jLabel1.setText("当前密码");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("新密码");

        jLabel3.setText("确认密码");

        jPasswordField1.setText("");

        jPasswordField2.setText("");

        jPasswordField3.setText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1)
                    .addComponent(jPasswordField2)
                    .addComponent(jPasswordField3))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * 按钮事件绑定，处理方法
     * 
     */
	private void jButton1ActionPerformed(ActionEvent evt) {

		char[] text = jPasswordField1.getPassword();
		String password1 = String.valueOf(text);
		text = jPasswordField2.getPassword();
		String password2 = String.valueOf(text);
		text = jPasswordField3.getPassword();
		String password3 = String.valueOf(text);

		if (password1.equals("") || password2.equals("") || password3.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (password2.equals(password3)) {
			if (parentFrame != null) {
				IStudentDao stuDao = new StudentDaoImpl();
				Student student = stuDao.selectByPrimaryKey(Integer.parseInt(flagId));
				if (password1.equals(student.getStudent_login_pwd())
						&& stuDao.updateStuPwd(Integer.parseInt(flagId), password2) == 1) {
					JOptionPane.showMessageDialog(null, "修改成功", "提示信息", JOptionPane.ERROR_MESSAGE);

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							UpdatePwdFrame.this.parentFrame.setVisible(true);
						}
					});
					UpdatePwdFrame.this.setVisible(false);
					return;
				} else {
					JOptionPane.showMessageDialog(null, "密码错误或修改失败", "提示信息", JOptionPane.ERROR_MESSAGE);
					jPasswordField2.setText("");
					jPasswordField3.setText("");
					return;
				}
			} else if (parentFrame1 != null) {
				// 教工信息
				ITeacherDao tchDao = new TeacherDaoImpl();
				Teacher teacher = tchDao.selectByPrimaryKey(Integer.parseInt(flagId));
				if (password1.equals(teacher.getTeacher_login_pwd())
						&& tchDao.updateTeaPwd(Integer.parseInt(flagId), password2) == 1) {
					JOptionPane.showMessageDialog(null, "修改成功", "提示信息", JOptionPane.ERROR_MESSAGE);

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							UpdatePwdFrame.this.parentFrame1.setVisible(true);
						}
					});
					UpdatePwdFrame.this.setVisible(false);
					return;
				} else {
					JOptionPane.showMessageDialog(null, "密码错误或修改失败", "提示信息", JOptionPane.ERROR_MESSAGE);
					jPasswordField2.setText("");
					jPasswordField3.setText("");
					return;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "两次密码不一致", "提示信息", JOptionPane.ERROR_MESSAGE);
			jPasswordField2.setText("");
			jPasswordField3.setText("");
			return;
		}
	}          
    
    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    	if (UpdatePwdFrame.this.parentFrame!=null 
    			&& UpdatePwdFrame.this.parentFrame.equals(parentFrame)) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					UpdatePwdFrame.this.parentFrame.setVisible(true);
				}
			});
			UpdatePwdFrame.this.setVisible(false);
		} else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					UpdatePwdFrame.this.parentFrame1.setVisible(true);
				}
			});
			UpdatePwdFrame.this.setVisible(false);
		}
    }                                        

    /**
     * 窗体效果测试
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UpdatePwdFrame().setVisible(true);
//            }
//        });
//    }


}
