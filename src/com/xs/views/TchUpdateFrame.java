package com.xs.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.xs.bean.College;
import com.xs.bean.Faculty;
import com.xs.bean.Teacher;
import com.xs.dao.ICollegeDao;
import com.xs.dao.IFacultyDao;
import com.xs.dao.ITeacherDao;
import com.xs.dao.impl.CollegeDaoImpl;
import com.xs.dao.impl.FacultyDaoImpl;
import com.xs.dao.impl.TeacherDaoImpl;

/**
 * 学生考勤管理系统 
 * 教师信息修改窗口
 *    
 * @author flyblue
 */
public class TchUpdateFrame extends javax.swing.JFrame {

    /**
	 * 成员变量
	 */
	private static final long serialVersionUID = 1L;
	
	protected TchFuncPortalFrame parentFrame;
	private String flagId;
    private Teacher teacher;
    private Properties prop;
	private String picture;
	
	// Variables declaration                     
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField5;                 

	/**
     * 构造方法
     */
    public TchUpdateFrame() {
        initComponents();
    }

    public TchUpdateFrame(String flagId) {
    	this.flagId=flagId;
    	initComponents();
	}

    // <"Generated Code">                          
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField5 = new JTextField();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jPanel5 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jPanel3 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("教师个人信息修改");        // 设置窗体标题
   		setResizable(false);   		// 设置窗口不可变
   		
        // 居中显示。
   		Toolkit kit = Toolkit.getDefaultToolkit();
   		Dimension screenSize = kit.getScreenSize();
   		int screenWidthpx = screenSize.width;
     	int screenHeightpx = screenSize.height;
     	setLocation((screenWidthpx-350) / 2, (screenHeightpx-350) / 2);
   		setLocationByPlatform(false);
        
   		// 设置窗口最小化时显示的图标，可选。
     	Image img = new ImageIcon(this.getClass().getResource("/images/001.png")).getImage();
   		setIconImage(img);

   		/** 
   		 * 页面布局
   		 * 
   		 */
   		// 通过教师ID查询教师信息
		ITeacherDao tchDao = new TeacherDaoImpl();
		teacher = tchDao.selectByPrimaryKey(Integer.parseInt(flagId));
		// 教师信息展示
        jLabel3.setText("姓名");
        jTextField1.setEditable(false);
        jTextField1.setText(teacher.getTeacher_name());

        jLabel4.setText("教师编号");
        jTextField2.setEditable(false);
        jTextField2.setText(String.valueOf(teacher.getTeacher_id()));

        jLabel5.setText("所属学院");

        jLabel6.setText("所属科室");

        jLabel7.setText("电子邮箱");
        jTextField5.setText(teacher.getTeacher_email());
        
        // 查找所有学院
        ICollegeDao collegeDao = new CollegeDaoImpl();
        List<College> college = collegeDao.selectAll();
        // 查找所有科室
        IFacultyDao facultyDao = new FacultyDaoImpl();
        List<Faculty> faculty = facultyDao.selectAll();       
        int index = -1;// 下拉菜单选定项索引
        
        // 如果没有记录显示，默认显示；如果有则由记录写入
        if(college!=null && faculty!=null){
            for(int i=0;i<college.size();i++)
            {
            	jComboBox1.addItem(college.get(i).getCollege_name());
            	if(college.get(i).getCollege_name().equals(teacher.getCollege_name())){
            		index = i;
            	}
            }
            jComboBox1.setSelectedIndex(index);
            
        	for(int i=0;i<faculty.size();i++)
            {
        		jComboBox2.addItem(faculty.get(i).getFaculty_name());
            	if(faculty.get(i).getFaculty_name().equals(teacher.getFaculty_name())){
            		index = i;
            	}
            }
            jComboBox2.setSelectedIndex(index);
        }else {
        	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        }
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField5)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        
        // 个人照片展示区域
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
		
        jLabel1.setText("个人照片");
        jLabel2.setSize(105,120);
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
				image.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
		jLabel2.setIcon(image);

        jButton1.setText("修改个人照片");
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jLabel1))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        // 功能按钮区域
        jButton2.setText("确认修改");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("返回上一级菜单");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
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
    	// 修改本地图片
    	JFileChooser chooser = new JFileChooser();
    	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	chooser.setFileFilter(new FileNameExtensionFilter("image files(*.jpg,*.jpeg,*.gif,*.png)", "jpg","jpeg","gif","png"));
    	chooser.showDialog(new JLabel(), "选择");
    	File file=chooser.getSelectedFile();
    	String extention=null;
    	if(file==null){
    		return;
    	}
    	
    	int i = file.getName().lastIndexOf(".");
    	if(i>-1 && i<file.length()){
    		extention = file.getName().substring(i+1); //--扩展名
    	}
    	if(extention!=null 
    		&& (extention.equalsIgnoreCase("jpg")
    		|| extention.equalsIgnoreCase("jpeg")
    		|| extention.equalsIgnoreCase("gif")
   			|| extention.equalsIgnoreCase("png"))){ 
    		if(prop.getProperty(flagId)!=null
    			&& prop.getProperty(flagId).equals(file.getName())){
    			;
    		}else{
    			prop.put(flagId,file.getPath());
    			OutputStream fos;
				try {
					fos = new FileOutputStream("TPictureConfig.properties");
					DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	                prop.store(fos, df.format(new Date()));
	                JOptionPane.showMessageDialog(null, "个人照片修改成功", "提示信息", JOptionPane.ERROR_MESSAGE);
	                TchUpdateFrame frame = new TchUpdateFrame(flagId);
					frame.setVisible(true);
					frame.parentFrame = TchUpdateFrame.this.parentFrame;
					frame.parentFrame.parentFrame=parentFrame.parentFrame;
					TchUpdateFrame.this.dispose();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "文件类型不支持", "提示信息", JOptionPane.ERROR_MESSAGE);
    		chooser.showDialog(new JLabel(), "选择");
    	}
    }                                                   
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	// TODO add your handling code here:
    	TchUpdateFrame.this.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TchUpdateFrame.this.parentFrame.picture=picture;
				ImageIcon image = null;
				if(picture.substring(0,1).equals("/")){
					image = new ImageIcon(this.getClass().getResource("/images"+picture));
				}else{
					File file =new File(picture);
					if(file.exists()){
						image = new ImageIcon(picture);
					}else{
						image = new ImageIcon(this.getClass().getResource("/images"+prop.getProperty("default")));
					}
				}
				TchUpdateFrame.this.parentFrame.jLabel1.setSize(90,110);
				image.setImage(
						image.getImage().getScaledInstance(TchUpdateFrame.this.parentFrame.jLabel1.getWidth(), TchUpdateFrame.this.parentFrame.jLabel1.getHeight(), Image.SCALE_DEFAULT));
				TchUpdateFrame.this.parentFrame.jLabel1.setIcon(image);
				TchUpdateFrame.this.parentFrame.setVisible(true);
			}
		});
		TchUpdateFrame.this.setVisible(false);
    }      
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String email = jTextField5.getText().trim();
		String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";

		if (!email.matches(emailRegex)) {
			JOptionPane.showMessageDialog(null, "邮箱格式错误", "提示信息", JOptionPane.ERROR_MESSAGE);
		} else {
			ITeacherDao TchDao = new TeacherDaoImpl();
			if (!teacher.getTeacher_email().equals(email)
				|| !teacher.getCollege_name().equals(jComboBox1.getSelectedItem())
				|| !teacher.getFaculty_name().equals(jComboBox2.getSelectedItem())
					) {
				
				int flag = 0;
				if(teacher.getCollege_name()!=null
						&& teacher.getFaculty_name()!=null
						|| !teacher.getCollege_name().equals(jComboBox1.getSelectedItem())
						|| !teacher.getFaculty_name().equals(jComboBox2.getSelectedItem())){
					
							teacher.setCollege_name(jComboBox1.getSelectedItem().toString());
							teacher.setFaculty_name(jComboBox2.getSelectedItem().toString());
							flag=TchDao.updateTea(teacher);
					}else{
						flag=TchDao.updateTeaEmail(Integer.parseInt(flagId), email);
					}
				
				if (flag == 1) {
					JOptionPane.showMessageDialog(null, "修改成功", "提示信息", JOptionPane.ERROR_MESSAGE);
					TchUpdateFrame frame = new TchUpdateFrame(flagId);
					frame.setVisible(true);
					frame.parentFrame = TchUpdateFrame.this.parentFrame;
					TchUpdateFrame.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "修改失败", "提示信息", JOptionPane.ERROR_MESSAGE);
					jTextField5.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "没有任何更改", "提示信息", JOptionPane.ERROR_MESSAGE);
			}
		}
	}     
       

    /**
     * 窗体效果测试
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TchUpdateFrame().setVisible(true);
//            }
//        });
//    }


}
