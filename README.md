# 学生考勤系统

注意：
运行安装StudentAttendanceSys_windows-x64_1_3_X.exe，要求jdk版本1.6以上、64位jvm(虚拟机)。

x64_1_3_1——数据库名stuattendance，数据库用户root，密码123456
x64_1_3_2——数据库名stuattendance，数据库用户root，密码root

文件结构：
│  StudentAttendanceSys_windows-x64_1_3_1.exe
│  StudentAttendanceSys_windows-x64_1_3_2.exe
│      
├─工程文件(源码)
│      StudentAttendanceSys
│      
└─数据库(sql导出文件)



StudentAttendanceSys文件结构
│  .classpath
│  .project
│  commons-dbcp2-2.1.1.jar       //连接池所需jar包
│  commons-logging-1.2.jar
│  commons-pool2-2.4.2.jar
│  mysql-connector-java-5.1.36-bin.jar
│  SPictureConfig.properties     //个人照片路径配置文件
│  TPictureConfig.properties
│      
├─bin                           //class输出文件
│ 
└─src
    │  dbcpconfig.properties
    │  
    ├─com
    │  └─xs
    │      ├─bean              //表所映射对象（包含数据库多表连接查询结果集映射）
    │      │      Admin.java
    │      │      AttendanceInfo.java
    │      │      AttendInfoMore.java
    │      │      ClassInfo.java
    │      │      ClassInfoMore.java
    │      │      College.java
    │      │      Faculty.java
    │      │      Record.java
    │      │      Student.java
    │      │      Teacher.java
    │      │      TeacherInfo.java
    │      │      
    │      ├─dao               //[接口]数据库操作（仅包含SQL语句和参数传递）
    │      │  │  IAdminDao.java
    │      │  │  IAttendanceInfoDao.java
    │      │  │  IClassInfoDao.java
    │      │  │  ICollegeDao.java
    │      │  │  IFacultyDao.java
    │      │  │  IRecordDao.java
    │      │  │  IStudentDao.java
    │      │  │  ITeacherDao.java
    │      │  │  
    │      │  └─impl	  //数据库操作（该程序主要用到StudentDaoImpl.java，TeacherDaoImpl.java）
    │      │          AdminDaoImpl.java
    │      │          AttendanceInfoDaoImpl.java
    │      │          ClassInfoDaoImpl.java
    │      │          CollegeDaoImpl.java
    │      │          FacultyDaoImpl.java
    │      │          RecordDaoImpl.java
    │      │          StudentDaoImpl.java
    │      │          TeacherDaoImpl.java
    │      │          
    │      ├─service           //[空]
    │      ├─util
    │      │  │  JdbcUtil.java          //普通数据库连接
    │      │  │  JdbcUtil_DBCP.java     //DBCP数据源实现连接池
    │      │  │  WindowsHandler.java    //窗口事件的绑定（主要是关闭）（仅限实验报告演示代码）
    │      │  │  
    │      │  └─db
    │      │          BeanHandler.java     //结果集映射单个对象
    │      │          BeanListHandler.java //结果集映射多个对象
    │      │          DatabaseUtil.java    //数据库语句执行update（增删改），query（查）
    │      │          ResultSetHandler.java//[接口]结果集映射处理
    │      │          
    │      └─views
    │              MainLoginFrame.java      //登陆入口
    │              StuFuncPortalFrame.java  //学生客户端功能页
    │              StuInfoFrame.java        //学生信息页
    │              StuLoginFrame.java       //学生登录窗口
    │              StuUpdateEmailFrame.java //学生更新邮箱页
    │              StuViewCourseFrame.java  //学生查看课程信息页
    │              StuViewTchFrame.java     //学生查看教师信息
    │              TchFuncPortalFrame.java  //教师客户端功能页
    │              TchInfoFrame.java        //教师信息页
    │              TchLoginFrame.java       //教师登录窗口
    │              TchRecordFrame.java      //教师记录考勤页
    │              TchUpdateConfirmRecordFrame.java//教师提交考勤记录修改页
    │              TchUpdateEmailFrame.java //教师更新邮箱页
    │              TchUpdateFrame.java      //教师更新个人信息页
    │              TchUpdateRecordFrame.java//教师修改考勤记录页（确认修改时跳转到提交考勤记录修改页）
    │              TchViewRecordFrame.java  //教师查看学生考勤记录页
    │              TchViewStuFrame.java     //教师查看学生信息页
    │              UpdatePwdFrame.java      //更新密码页（通用）
    │              
    └─images
            001.png                          //窗口图标
            student.jpg                      //学生默认头像
            teacher.jpg                      //教师默认头像
            top1.jpg                         //窗口背景图片
            