package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.xs.bean.AttendInfoMore;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.TeacherDaoImpl;

/**
 * ѧ�����ڹ���ϵͳ 
 *  �ͻ�����Ϣ����(�̹�)
 *    
 * @author flyblue
 */
public class TchFuncPortalFrame extends javax.swing.JFrame {

    /**
	 * ��Ա����
	 */
	private static final long serialVersionUID = 1L;
	
	protected TchLoginFrame parentFrame;
	private String flagId;
	private Properties prop;
	protected String picture;
	
    // Variables declaration                  
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    protected JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JTextField jTextField1;                  

	/**
     * ���캯��
     */
    public TchFuncPortalFrame() {
        initComponents();
    }

    public TchFuncPortalFrame(String flagId) {
		this.flagId=flagId;
		initComponents();
	}

    // <"Generated Code">                          
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel("",javax.swing.JLabel.CENTER);
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jPanel3 = new JPanel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton6 = new JButton();
        jPanel4 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 470));
     	setTitle("ѧ������ϵͳ");        // ���ô������
//   		setResizable(false);   		   // ���ô��ڲ��ɱ�
     	jTable2.setEnabled(false);
     	// ������ʾ��
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-500) / 2, (screenHeightpx-470) / 2);
   		setLocationByPlatform(false);
   		
        // ���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setSize(90,110);
        //	������Ƭչʾ
		// ����TPictureConfig.properties�����ļ�
        File file =new File("TPictureConfig.properties");
        InputStream in = null;
        prop = null;
        if(!file.exists())    
        {    
            try {    
                file.createNewFile();
                in = new FileInputStream("TPictureConfig.properties");
                prop = new Properties();
                prop.put("default", "/teacher.jpg");
                OutputStream fos = null;
                fos = new FileOutputStream("TPictureConfig.properties");
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                prop.store(fos, df.format(new Date()));
            } catch (IOException e) {   
                e.printStackTrace();    
            }    
        }else{
    		// ����TPictureConfig.properties�����ļ�
    		try {
    			in = new FileInputStream("TPictureConfig.properties");
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		prop = new Properties();
        }
		picture = null;
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		picture=prop.getProperty(flagId);
		if(picture==null){
			picture=prop.getProperty("default");
		}
        
		ImageIcon image = null;
		if(picture.substring(0,1).equals("/")){
			image = new ImageIcon(this.getClass().getResource("/images"+picture));
		}else{
			file =new File(picture);
			if(file.exists()){
				image = new ImageIcon(picture);
			}else{
				image = new ImageIcon(this.getClass().getResource("/images"+prop.getProperty("default")));
			}
		}
		image.setImage(
				image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
		jLabel1.setIcon(image);
		//  ��ʾID
		jLabel2.setText(flagId);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
        );
        
        // ���߿�
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        // ���Ĺ�����(��ť���¼���)
        jButton1.setText("�鿴������Ϣ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("�޸ĸ�����Ϣ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("�޸ĸ�������");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("¼�뿼����Ϣ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("�޸Ŀ��ڼ�¼");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("�鿴ѧ����Ϣ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("�鿴���ڼ�¼");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // ���߿�
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        // ��ѯ����
        jLabel3.setText("������Ҫ��ѯ�Ŀ��ڼ�¼�Ŀγ̱��");
        // �ı������Ĭ��Ϊ��
        jTextField1.setText("");
        // ��ѯ��ť
        jButton6.setText("��ѯ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        
        // ���߿�
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        // ���Ĭ����ʾ
		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {},
				new String[] { 
						"ѧ��ѧ��", "ѧ������", "���ڿγ�", "����ʱ��", "���ڽ��" 
						}
					));
        // ������ڹ���������
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * ��ť�¼��󶨣�������
     * 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchInfoFrame frame = new TchInfoFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchUpdateFrame frame = new TchUpdateFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }     
    
    private void jButton3ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				UpdatePwdFrame frame = new UpdatePwdFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame1 = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchRecordFrame frame = new TchRecordFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }                                        

    private void jButton5ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchUpdateRecordFrame frame = new TchUpdateRecordFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }  
    
    private void jButton6ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	String classId = jTextField1.getText().trim();
    	if(classId.equals("")){
    		jTable2.setModel(new javax.swing.table.DefaultTableModel(
    	            new Object [][] {},
    	            new String [] {
    	            	"ѧ��ѧ��","ѧ������","���ڿγ�","����ʱ��","���ڽ��"
    	            }
    	        ));
    		return;
    	}else{
    		ITeacherDao tchDao = new TeacherDaoImpl();
        	List<AttendInfoMore> attInfo = null;
        	attInfo =tchDao.selectAttendByClass(Integer.parseInt(flagId), Integer.parseInt(classId));
        	if(attInfo!=null){
        		String[][] obj= new String[attInfo.size()][5];
            	for(int i=0;i<attInfo.size();i++)
                {
            		obj[i][0] = String.valueOf(attInfo.get(i).getStudent_id());
            		obj[i][1] = attInfo.get(i).getStudent_name();
            		obj[i][2] = attInfo.get(i).getCourse_name();
					obj[i][3] = attInfo.get(i).getRecord_time();
					obj[i][4] = attInfo.get(i).getAttendance_status();			   
                }
            	jTable2.setModel(new javax.swing.table.DefaultTableModel(obj,
                        new String [] {
                            "ѧ��ѧ��","ѧ������","���ڿγ�","����ʱ��","���ڽ��"
                        }
                    ));
        	}else{
        		JOptionPane.showMessageDialog(null, "�޲�ѯ���", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
        		jTable2.setModel(new javax.swing.table.DefaultTableModel(
        	            new Object [][] {},
        	            new String [] {
        	            	"ѧ��ѧ��","ѧ������","���ڿγ�","����ʱ��","���ڽ��"
        	            }
        	        ));
        	}
    	}
    }                                        

    private void jButton7ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchViewStuFrame frame = new TchViewStuFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }
    
    private void jButton8ActionPerformed(ActionEvent evt) {
    	// TODO add your handling code here:
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchViewRecordFrame frame = new TchViewRecordFrame(flagId);
				frame.setVisible(true);
				frame.parentFrame = TchFuncPortalFrame.this;
			}
		});
    	TchFuncPortalFrame.this.setVisible(false);
    }
    
    /**
     * ����Ч������
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TchFuncPortalFrame().setVisible(true);
//            }
//        });
//    }


}
