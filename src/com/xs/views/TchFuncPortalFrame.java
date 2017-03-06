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
 * 学生考勤管理系统 
 *  客户端信息窗体(教工)
 *    
 * @author flyblue
 */
public class TchFuncPortalFrame extends javax.swing.JFrame {

    /**
	 * 成员变量
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
     * 构造函数
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
     	setTitle("学生考勤系统");        // 设置窗体标题
//   		setResizable(false);   		   // 设置窗口不可变
     	jTable2.setEnabled(false);
     	// 居中显示。
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-500) / 2, (screenHeightpx-470) / 2);
   		setLocationByPlatform(false);
   		
        // 设置窗口最小化时显示的图标，可选。
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setSize(90,110);
        //	个人照片展示
		// 加载TPictureConfig.properties配置文件
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
    		// 加载TPictureConfig.properties配置文件
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
		//  显示ID
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
        
        // 面板边框
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        // 核心功能区(按钮的事件绑定)
        jButton1.setText("查看个人信息");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("修改个人信息");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("修改个人密码");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("录入考勤信息");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("修改考勤记录");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("查看学生信息");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("查看考勤记录");
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
        // 面板边框
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        // 查询区域
        jLabel3.setText("请输入要查询的考勤记录的课程编号");
        // 文本输入框默认为空
        jTextField1.setText("");
        // 查询按钮
        jButton6.setText("查询");
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
        
        // 面板边框
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        // 表格默认显示
		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {},
				new String[] { 
						"学生学号", "学生姓名", "考勤课程", "考勤时间", "考勤结果" 
						}
					));
        // 表格置于滚动窗体中
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
     * 按钮事件绑定，处理方法
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
    	            	"学生学号","学生姓名","考勤课程","考勤时间","考勤结果"
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
                            "学生学号","学生姓名","考勤课程","考勤时间","考勤结果"
                        }
                    ));
        	}else{
        		JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.ERROR_MESSAGE);
        		jTable2.setModel(new javax.swing.table.DefaultTableModel(
        	            new Object [][] {},
        	            new String [] {
        	            	"学生学号","学生姓名","考勤课程","考勤时间","考勤结果"
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
     * 窗体效果测试
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
