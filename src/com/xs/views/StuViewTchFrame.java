package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xs.bean.TeacherInfo;
import com.xs.dao.IStudentDao;
import com.xs.dao.impl.StudentDaoImpl;

/**
 * ѧ�����ڹ���ϵͳ 
 * ѧ���鿴��ʦ��Ϣ
 *    
 * @author flyblue
 */
public class StuViewTchFrame extends javax.swing.JFrame {
    /**
	 * ��Ա����
	 */
	private static final long serialVersionUID = 1L;
	
	protected StuFuncPortalFrame parentFrame;
	private String flagId;
	
    // Variables declaration                     
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

	/**
     * ���췽��
     */
    public StuViewTchFrame() {
        initComponents();
    }

    public StuViewTchFrame(String flagId) {
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
        setTitle("�鿴��ʦ��Ϣ");        // ���ô������
//   		setResizable(false);       		// ���ô��ڲ��ɱ�	
   		jTable1.setEnabled(false);
        // ������ʾ��
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-500) / 2, (screenHeightpx-380) / 2);
   		setLocationByPlatform(false);
   		
        // ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

   		/** 
   		 * ҳ�沼��
   		 * 
   		 */
   		// ͨ��ID��ѯ��ʦ��Ϣ
   		IStudentDao stuDao = new StudentDaoImpl();
   		List<TeacherInfo> tchInfo =null;
   		tchInfo = stuDao.selectTeacherBystuId(Integer.parseInt(flagId));
   		// �жϲ�ѯ�����������Ӧչʾ
        if(tchInfo==null){
        	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                        "����", "�οογ�", "����ѧԺ"
                    }
                ));
    	}else{
    		String[][] obj= new String[tchInfo.size()][3];
        	for(int i=0;i<tchInfo.size();i++)
            {
            	   obj[i][0]=tchInfo.get(i).getTeacher_name();
            	   obj[i][1]=tchInfo.get(i).getCourse_name();
            	   obj[i][2]=tchInfo.get(i).getCollege_name();
            			   
            }
        	jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
                    new String [] {
                    	"����", "�οογ�", "����ѧԺ"
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        // ���ܰ�ť����
        jButton1.setText("�����ϼ��˵�");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * ��ť�¼��󶨣�������
     * 
     */
    private void jButton1ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				StuViewTchFrame.this.parentFrame.setVisible(true);
			}
		});
    	StuViewTchFrame.this.setVisible(false);
    }                                        

    /**
     * ����Ч������
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StuViewTchFrame().setVisible(true);
//            }
//        });
//    }


}

