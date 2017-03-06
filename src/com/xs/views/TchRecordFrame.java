package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xs.bean.AttendanceInfo;
import com.xs.bean.ClassInfo;
import com.xs.bean.Record;
import com.xs.bean.Student;
import com.xs.dao.IClassInfoDao;
import com.xs.dao.IStudentDao;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.ClassInfoDaoImpl;
import com.xs.dao.impl.StudentDaoImpl;
import com.xs.dao.impl.TeacherDaoImpl;

/**
 * ѧ�����ڹ���ϵͳ 
 * ѧ������¼�봰��
 *    
 * @author flyblue
 */
public class TchRecordFrame extends javax.swing.JFrame {
	/**
	 * ��Ա����
	 */
	private static final long serialVersionUID = 1L;
	
	protected TchFuncPortalFrame parentFrame;
    private String flagId;
    HashMap<ClassInfo, List<Student>> map;
    
	
    // Variables declaration                  
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;                

	/**
     * ���췽��
     */
    public TchRecordFrame() {
        initComponents();
    }

    public TchRecordFrame(String flagId) {
    	this.flagId=flagId;
    	initComponents();
	}

    // <"Generated Code">                          
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jTextField1 = new JTextField();
        jComboBox2 = new JComboBox<>();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jComboBox3 = new JComboBox<>();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     	setTitle("ѧ��������Ϣ¼��");        // ���ô������
   		setResizable(false);   		       // ���ô��ڲ��ɱ�
   		
     	// ������ʾ��
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-300) / 2, (screenHeightpx-300) / 2);
   		setLocationByPlatform(false);
   		
        // ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);
   		// ���ñ���ͼ
        jLabel1.setSize(320,60);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top1.jpg"));
		image.setImage(
				image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
		jLabel1.setIcon(image);
		
   		/** 
   		 * ҳ�沼��
   		 * 
   		 */
   		// ͨ����ʦID��ѯ��ѧ����Ϣ
		IClassInfoDao classInfoDao = new ClassInfoDaoImpl();
        List<ClassInfo> classInfo = null;
        classInfo = classInfoDao.selectClassByTea(Integer.parseInt(flagId));
        List<Student> students = null;
        map = new HashMap<ClassInfo, List<Student>>();
   		// ͨ����ʦID��ѯ��ѧ����Ϣ
        IStudentDao stuDao = new StudentDaoImpl();
        // ��ʼ�������б��Լ��������б���ص��ı���
        if(classInfo!=null){
            for(int i=0;i<classInfo.size();i++)
            {
            	jComboBox1.addItem(String.valueOf(classInfo.get(i).getClass_id()));
            	List<Student> students1 = null;
                students1 = stuDao.selectStuByClass(classInfo.get(i).getClass_id());
				if (students1 != null) {
					map.put(classInfo.get(i), students1);
				}
            }
            jComboBox1.setSelectedIndex(0);
            
            String courseName = null;
            String stuName = null;
            
            for(ClassInfo cl : classInfo){
            	String a=(String) jComboBox1.getSelectedItem();
            	if(String.valueOf(cl.getClass_id()).equals(a)){
            		courseName=cl.getCourse_name();
            		students = map.get(cl);
            		for (int j = 0; j < students.size(); j++) {
						jComboBox2.addItem(String.valueOf(students.get(j).getStudent_id()));		
					}
                    stuName = students.get(jComboBox2.getSelectedIndex()).getStudent_name();
            	}
            }
            jTextField1.setText(courseName);
            jTextField2.setText(stuName);
        }
        // ����ʱ�����ϵͳ��ǰʱ��
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        jTextField3.setText(sdFormatter.format(nowTime));

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        
        // ��ʾ��ǩ
		jLabel2.setText("��ѧ���");
        jLabel3.setText("�γ�����");
        jLabel4.setText("ѧ  ��ID");
        jLabel5.setText("ѧ������");
        jLabel6.setText("����ʱ��");
        jLabel7.setText("���ڼ�¼");
        // �̶������б�����
        jComboBox3.addItem("����");
        jComboBox3.addItem("�ٵ�");
        jComboBox3.addItem("����");
        jComboBox3.addItem("����");
        jComboBox3.setSelectedIndex(0);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        // ���ܰ�ť����
        jButton1.setText("¼�뿼����Ϣ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("������һ���˵�");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * ��ť�¼��󶨣�������
     * 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // ¼���¼
    	Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	if(jTextField1.getText().equals("")
    			|| jTextField2.getText().equals("")
    			|| jTextField3.getText().equals("")){
    		JOptionPane.showMessageDialog(null, "��Ϣ������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    		jTextField3.setText(sdFormatter.format(nowTime));
    		return;
    	}
    	
    	String classid = (String) jComboBox1.getSelectedItem();
		IClassInfoDao classinfoDao = new ClassInfoDaoImpl();
		ClassInfo classinfo = classinfoDao.selectByPrimaryKey(Integer.parseInt(classid));
    	
    	String stuId = (String) jComboBox2.getSelectedItem();
		IStudentDao stuDao = new StudentDaoImpl();
		Student student = stuDao.selectByPrimaryKey(Integer.parseInt(stuId));
		
		String regex = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
    	
		if(!jTextField1.getText().equals(classinfo.getCourse_name())){
    		JOptionPane.showMessageDialog(null, "��ѧ�����γ����ֲ�ƥ��", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    		jTextField3.setText(sdFormatter.format(nowTime));
    		return;
		}else if(!jTextField2.getText().equals(student.getStudent_name())){
    		JOptionPane.showMessageDialog(null, "ѧ��ID��ѧ��������ƥ��", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    		jTextField3.setText(sdFormatter.format(nowTime));
    		return;
    	}else if(!jTextField3.getText().matches(regex)){
    		JOptionPane.showMessageDialog(null, "ʱ���ʽ����", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    		
            jTextField3.setText(sdFormatter.format(nowTime));
            return;
    	}else{
    		ITeacherDao tchDao = new TeacherDaoImpl();
    		Record record = new Record();
    		AttendanceInfo  attend = new AttendanceInfo();

    		attend.setRecord_time(jTextField3.getText());
    		attend.setClass_id(Integer.parseInt(classid));
    	    record.setStudent_id(Integer.parseInt(stuId));
    	    record.setAttendance_status(String.valueOf(jComboBox3.getSelectedItem())); 		
    		if(tchDao.insertAttendance(record,attend)==1){
    			JOptionPane.showMessageDialog(null, "¼�뿼����Ϣ�ɹ�", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    			jTextField3.setText(sdFormatter.format(nowTime));
    		}else{
    			JOptionPane.showMessageDialog(null, "¼�뿼����Ϣʧ��", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
    			jTextField3.setText(sdFormatter.format(nowTime));
    		}
    	}
    }    

    private void jButton2ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchRecordFrame.this.parentFrame.setVisible(true);
			}
		});
    	TchRecordFrame.this.setVisible(false);
    }   
    
    /**
     * �����б��¼��󶨣�������
     * 
     */
    private void jComboBox1ItemStateChanged(ItemEvent evt) {
    	jComboBox2.removeAllItems();
    	String classId = (String) evt.getItem();
    	
    	String courseName = null;
    	
    	for (Entry<ClassInfo, List<Student>> entry : map.entrySet()) {
    		if(String.valueOf(entry.getKey().getClass_id()).equals(classId)){
    			courseName=entry.getKey().getCourse_name();
    			for (int j = 0; j < entry.getValue().size(); j++) {
					jComboBox2.addItem(String.valueOf(entry.getValue().get(j).getStudent_id()));		
				}
    		}
    	}
        jTextField1.setText(courseName);
    }
    
    private void jComboBox2ItemStateChanged(ItemEvent evt) {
    	// TODO add your handling code here:
		String stuId = (String) evt.getItem();
		IStudentDao stuDao = new StudentDaoImpl();
		Student student = stuDao.selectByPrimaryKey(Integer.parseInt(stuId));

		jTextField2.setText(student.getStudent_name());
    }       

    /**
     * ����Ч������
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TchRecordFrame().setVisible(true);
//            }
//        });
//    }


}

