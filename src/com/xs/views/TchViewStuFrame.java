package com.xs.views;

import com.xs.bean.Student;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.TeacherDaoImpl;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * ѧ�����ڹ���ϵͳ
 * ��ʦ�鿴ѧ����Ϣ����
 *    
 * @author flyblue
 */
public class TchViewStuFrame extends javax.swing.JFrame {


	/**
	 * ��Ա����
	 */
	private static final long serialVersionUID = 1L;
	
	protected TchFuncPortalFrame parentFrame;
    private String flagId;
    // Variables declaration                   
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;                 

	/**
     * ���췽��
     */
    public TchViewStuFrame() {
        initComponents();
    }

    public TchViewStuFrame(String flagId) {
    	this.flagId=flagId;
    	initComponents();
	}
    
    // <"Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("�鿴ѧ����Ϣ");        // ���ô������
//   		setResizable(false);   		// ���ô��ڲ��ɱ�
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
   		//��ѯ��ʽ�����б�
        jLabel1.setText("��ѡ���ѯ��ʽ");

        jComboBox1.addItem("��������ѯ");
        jComboBox1.addItem("����ѧ���ѯ");
        jComboBox1.addItem("��רҵ��ѯ");
        jComboBox1.addItem("��ѧ�Ų�ѯ");
        jComboBox1.setSelectedIndex(0);
        

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jLabel2.setText("�������ѯ�ؼ���");

        jTextField1.setText("");

        jButton1.setText("��ѯ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        // Ĭ����ʾ���
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "����", "ѧ��", "����ѧԺ", "רҵ"
            }
        ));
        
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        // ���ܰ�ť����
        jButton2.setText("���¿�ʼ��ѯ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setText("�����ϼ��˵�");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     * ��ť�¼��󶨣�������
     * 
     */
    private void jButton1ActionPerformed(ActionEvent evt) {

        if(jTextField1.getText().trim()!=null && !jTextField1.getText().trim().equals("") ) {
            int i = jComboBox1.getSelectedIndex();
            ITeacherDao iTeacherDao = new TeacherDaoImpl();
            List<Student> students=null;
            if (i == 0) {
                 students = iTeacherDao.selectByStuname(Integer.parseInt(flagId), jTextField1.getText().trim());
            } else if (i == 1) {
            	if (!jTextField1.getText().trim().matches("^[0-9]*$")) {
        			JOptionPane.showMessageDialog(null, "����ȷ�����ѯ����", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
        			jTextField1.setText("");
        			return;
        		}else{
        			students  = iTeacherDao.selectByClassId(Integer.parseInt(flagId), Integer.parseInt(jTextField1.getText().trim()));
        		}
            } else if (i == 2) {
                 students  = iTeacherDao.selectByStuMajor(Integer.parseInt(flagId), jTextField1.getText().trim());
			} else {
				if (!jTextField1.getText().trim().matches("^[0-9]*$")) {
        			JOptionPane.showMessageDialog(null, "����ȷ�����ѯ����", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
        			jTextField1.setText("");
        			return;
        		}else{
				 students = iTeacherDao.selectByStuId(Integer.parseInt(flagId),
							Integer.parseInt(jTextField1.getText().trim()));
        		}
            }
            if(students!=null){
                String[][] obj= new String[students.size()][4];
                for(int a=0;a<students.size();a++)
                {
                    obj[a][0] = students.get(a).getStudent_name();
                    obj[a][1] = String.valueOf(students.get(a).getStudent_id());
                    obj[a][2] = students.get(a).getStudent_college();
                    obj[a][3] = students.get(a).getStudent_major();
                }
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        obj,
                        new String [] {
                                "����", "ѧ��", "����ѧԺ", "רҵ"
                        }
                ));
            }else{
            	JOptionPane.showMessageDialog(null, "�޲�ѯ���", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
            	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {},
                        new String [] {
                                "����", "ѧ��", "����ѧԺ", "רҵ"
                        }
                ));
            }
        }
        else{  jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "����", "ѧ��", "����ѧԺ", "רҵ"
                }
        ));
        }
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    	jButton1ActionPerformed(evt);
    }                                        

    private void jButton3ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchViewStuFrame.this.parentFrame.setVisible(true);
			}
		});
    	TchViewStuFrame.this.setVisible(false);
    }  

    /**
     * ����Ч������
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TchViewStuFrame().setVisible(true);
//            }
//        });
//    }


}
