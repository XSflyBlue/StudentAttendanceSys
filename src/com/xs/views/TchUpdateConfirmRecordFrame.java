package com.xs.views;

import com.xs.bean.AttendInfoMore;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.TeacherDaoImpl;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

/**
 * 学生考勤管理系统
 * 学生考勤提交修改窗口
 *    
 * @author flyblue
 */
public class TchUpdateConfirmRecordFrame extends javax.swing.JFrame {

	/**
	 * 成员变量
	 */
	private static final long serialVersionUID = 1L;
	
	protected TchUpdateRecordFrame parentFrame;
    private String flagId;
	// Variables declaration                      
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;                 

    /**
     * 构造函数
     */
    public TchUpdateConfirmRecordFrame() {
        initComponents();
    }
    
    public TchUpdateConfirmRecordFrame(String flagId) {
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
        jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     	setTitle("修改考勤信息");        // 设置窗体标题
//   		setResizable(false);   		    // 设置窗口不可变
     	
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
   		// 下拉列表初始化
        JComboBox<String> jComboBox=new JComboBox<String>();
        jComboBox.addItem("正常");
        jComboBox.addItem("迟到");
        jComboBox.addItem("旷课");
        jComboBox.addItem("请假");
        // 通过教师ID查询教学班考勤信息
        ITeacherDao TchDao = new TeacherDaoImpl();
        List<AttendInfoMore> attInfo =null;
        attInfo = TchDao.selectAttendByTea(Integer.parseInt(flagId));
        // 记录为空时默认显示，拥有记录时信息填充
        if(attInfo==null){
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                            "教学班号", "课程名称", "学生ID", "姓名", "考勤时间", "考勤记录"
                    }
            ));
        }else{
            String[][] obj= new String[attInfo.size()][6];
            for(int i=0;i<attInfo.size();i++)
            {
                obj[i][0] = String.valueOf(attInfo.get(i).getClass_id());
                obj[i][1] = attInfo.get(i).getCourse_name();
                obj[i][2] = String.valueOf(attInfo.get(i).getStudent_id());
                obj[i][3] = attInfo.get(i).getStudent_name();
                obj[i][4] = attInfo.get(i).getRecord_time();
                obj[i][5] = attInfo.get(i).getAttendance_status();
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
                    new String [] {
                            "教学班号", "课程名称", "学生ID", "姓名", "考勤时间", "考勤记录"
                    }
            ));
            TableColumnModel tableColumnModel=jTable1.getColumnModel();
            tableColumnModel.getColumn(5).setCellEditor(new DefaultCellEditor(jComboBox));
            jTable1.setEnabled(true);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        // 功能按钮区域
        jButton1.setText("返回上级菜单");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("提交修改记录");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
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
    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchUpdateConfirmRecordFrame.this.parentFrame.setVisible(true);
			}
		});
    	TchUpdateConfirmRecordFrame.this.setVisible(false);
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {
        ITeacherDao TchDao = new TeacherDaoImpl();
        List<AttendInfoMore> attInfo =null;
        attInfo = TchDao.selectAttendByTea(Integer.parseInt(flagId));
        int num=0;
        for(AttendInfoMore attendInfoMore : attInfo){
            if(!attendInfoMore.getAttendance_status().equals(jTable1.getValueAt(num,5).toString()))
            {
                attendInfoMore.setAttendance_status(jTable1.getValueAt(num, 5).toString());
                TchDao.updateAttendBytea(attendInfoMore);
            }
            num++;
        }

        JOptionPane.showMessageDialog(null, "修改成功", "提示信息", JOptionPane.ERROR_MESSAGE);

        TchUpdateRecordFrame frame = new TchUpdateRecordFrame(flagId);
        frame.setVisible(true);
        frame.parentFrame = TchUpdateConfirmRecordFrame.this.parentFrame.parentFrame;
        TchUpdateConfirmRecordFrame.this.dispose();
    }                   

    /**
     * 窗体效果测试
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TchUpdateConfirmRecordFrame().setVisible(true);
//            }
//        });
//    }

   
}
