package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xs.bean.ClassInfoMore;
import com.xs.dao.IStudentDao;
import com.xs.dao.impl.StudentDaoImpl;

/**
 * 学生考勤管理系统 
 * 学生查看课程信息
 *    
 * @author flyblue
 */
public class StuViewCourseFrame extends javax.swing.JFrame {
	/**
	 * 成员变量
	 */
	private static final long serialVersionUID = 1L;
	
	protected StuFuncPortalFrame parentFrame;
    private String flagId;
	
    // Variables declaration                    
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;                

	/**
     * 构造方法
     */
    public StuViewCourseFrame() {
        initComponents();
    }

    public StuViewCourseFrame(String flagId) {
    	this.flagId=flagId;
        initComponents();
    }

    // <"Generated Code">                          
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel3 = new JPanel();
        jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     	setTitle("查看课程信息");        		// 设置窗体标题
//   		setResizable(false);     	   		// 设置窗口不可变
   		jTable1.setEnabled(false);
     	// 居中显示。
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-500) / 2, (screenHeightpx-380) / 2);
   		setLocationByPlatform(false);
   		
        // 设置窗口最小化时显示的图标，可选。
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

   		/** 
   		 * 页面布局
   		 * 
   		 */
   		// 通过ID查询学生课程
   		IStudentDao stuDao = new StudentDaoImpl();
   		List<ClassInfoMore> ClassInfo =null;
   		ClassInfo = stuDao.selectClassBystuId(Integer.parseInt(flagId));
   		// 判断查询结果并给出相应展示
        if(ClassInfo==null){
        	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                        "课程名字", "上课起始时间", "任课教师", "结束周次"
                    }
                ));
    	}else{
    		String[][] obj= new String[ClassInfo.size()][4];
        	for(int i=0;i<ClassInfo.size();i++)
			{
				obj[i][0] = ClassInfo.get(i).getCourse_name();
				obj[i][1] = ClassInfo.get(i).getClass_time();
				obj[i][2] = ClassInfo.get(i).getTeacher_name();
				obj[i][3] = String.valueOf(ClassInfo.get(i).getClass_end_week());
			}
        	jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
                    new String [] {
                    	"课程名字", "上课起始时间", "任课教师", "结束周次"
                    }
                ));
    	}
   		
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        // 功能按钮区域
        jButton1.setText("返回上级菜单");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.add(jButton1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				StuViewCourseFrame.this.parentFrame.setVisible(true);
			}
		});
    	StuViewCourseFrame.this.setVisible(false);
    }                                        

    /**
     * 窗体效果测试
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StuViewCourseFrame().setVisible(true);
//            }
//        });
//    }


}
