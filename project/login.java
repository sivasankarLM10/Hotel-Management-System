package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class login extends JFrame
{
	JFrame Admin=null;

    public static JFrame home;//home frame
    
    public static JFrame loginframe;//elements of login frame
	public JTextField loginfield;
	public JPasswordField passwordField;
	private JButton loginbutton;
	
	
	private JFrame adminlogframe;//elements of admin login frame
	public JTextField adm_loginfield;
	public JPasswordField adm_passwordField;
	private JButton adm_loginbutton;
	
	private JFrame seniormanager;//senior manager frame	
	private JFrame branchmanager;
	private JFrame waiter;//branch manager frame	
	private JFrame chef; //chef frame 	
	private JFrame h_chef;//head chef frame

	private Connection connect = null;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void init() throws Exception{
    	try {
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel",
                    "postgres", "sankar37");
    		statement = connect.createStatement();
    	}
    	
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    login() throws Exception
    {
		init();
    	//--------------------------------------------------------HOME PAGE------------------------------------------------------------------------------------
    	home = new JFrame();
		home.setSize(1400,800);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img =new ImageIcon("E:\\\\Eclipse workspace\\\\Logo.png");//background
//      							------------------------------------------------------------------------------------
//                          		 This is the path of the image file stored in your system.this path may vary from system to system.
//                           		 So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		home.getContentPane().setLayout(null);
		home.setVisible(true);
		
		JButton viewmenu = new JButton("VIEW MENU");//view menu button
		viewmenu.setForeground(Color.WHITE);
		viewmenu.setBackground(Color.BLACK);
		viewmenu.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		viewmenu.setBounds(312, 588, 170, 42);
		home.getContentPane().add(viewmenu);
		
		JButton loginbt = new JButton("LOG IN");//login button
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					home.setVisible(false);
					loginframe.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		viewmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					home.setVisible(false);
					new selectHotel();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginbt.setBackground(Color.BLACK);
		loginbt.setForeground(Color.WHITE);
		loginbt.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		loginbt.setBounds(908, 588, 170, 42);
		home.getContentPane().add(loginbt);
		
		
		JLabel Background=new JLabel("",img,JLabel.CENTER);//background
		Background.setBounds(10, 0, 1350, 840);
		home.getContentPane().add(Background);
		
		//--------------------------------------------------------MAIN LOGIN FRAME-----------------------------------------------------------------------------------------
		
		loginframe = new JFrame();
		loginframe.setSize(1400,700);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		img =new ImageIcon("E:\\Eclipse workspace\\NSS HOME.png");//background
		//                           ------------------------------------------------------------------------------------
		//                           This is the path of the image file stored in your system.this path may vary from system to system.
		//                           So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		
		loginframe.getContentPane().setLayout(null);
		
		loginfield = new JTextField();//login textfield
		loginfield.setBounds(580, 255, 216, 39);
		loginframe.getContentPane().add(loginfield);
		loginfield.setColumns(10);
		
		passwordField = new JPasswordField();//password field
		passwordField.setBounds(580, 300, 216, 39);
		loginframe.getContentPane().add(passwordField);
		
		JButton adminlogin = new JButton("Admin Login");//admin login button
		adminlogin.setBackground(Color.BLACK);
		adminlogin.setForeground(Color.WHITE);
		adminlogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		adminlogin.setBounds(1158, 47, 131, 39);
		loginframe.getContentPane().add(adminlogin);
		
		adminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginframe.setVisible(false);
				adminlogframe.setVisible(true);
			}
		});
		
		
		loginbutton = new JButton("Login");//login button
		loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = loginfield.getText();
				String eid = new String(passwordField.getPassword());
				JFrame alert=new JFrame();  
				try {
 
					if(SR_MangerLogin(name,eid)) 		//if the employee is a senior manager,it loads the frame of senior manager.
					{
						loginframe.setVisible(false);
						new seniormanager(eid);	
					}
					else if(MangerLogin(name,eid))     //if the employee is a manager,it loads the frame of chef.
					{
						loginframe.setVisible(false);
						new branchmanager(eid);
					}
					else if(ChefLogin(name,eid))      //if the employee is a chef,it loads the frame of chef.
					{
						loginframe.setVisible(false);
						new chefview(eid);
					}
					else if(H_ChefLogin(name,eid))  //if the employee is a head chef,it loads the frame of head chef.
					{
						loginframe.setVisible(false);
						new headchef(eid);
					}
					else if(WaiterLogin(name,eid))  //if the employee is a head chef,it loads the frame of head chef.
					{
						loginframe.setVisible(false);
						new waiter(eid);
					}
					else 
					{
						JOptionPane.showMessageDialog(alert,"Invalid Credentials");
					}
					
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		loginbutton.setBackground(Color.BLACK);
		loginbutton.setForeground(Color.WHITE);
		loginbutton.setBounds(580, 378, 216, 39);
		loginframe.getContentPane().add(loginbutton);
		
		JLabel Background2=new JLabel("",img,JLabel.CENTER);//background
		Background2.setBounds(10, 0, 1350, 840);
		loginframe.getContentPane().add(Background2);
		
		JButton backbutton = new JButton("BACK");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(true);
				loginframe.setVisible(false);
			}
		});
		backbutton.setForeground(Color.WHITE);
		backbutton.setBackground(Color.BLACK);
		backbutton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		backbutton.setBounds(48, 49, 94, 32);
		loginframe.getContentPane().add(backbutton);
		//--------------------------------------------------------ADMIN LOGIN FRAME----------------------------------------------------------------------------------------
		
		adminlogframe = new JFrame();
		adminlogframe.setSize(1400,880);
		adminlogframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img2 =new ImageIcon("E:\\\\\\\\Eclipse workspace\\\\\\\\NSS ADMIN.png");//background
		//                           ------------------------------------------------------------------------------------
		//                           This is the path of the image file stored in your system.this path may vary from system to system.
		//                           So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		
		adminlogframe.getContentPane().setLayout(null);
		
		adm_loginfield = new JTextField();//login textfield
		adm_loginfield.setBounds(643, 410, 196, 39);
		adminlogframe.getContentPane().add(adm_loginfield);
		adm_loginfield.setColumns(10);
		
		adm_passwordField = new JPasswordField();//password field
		adm_passwordField.setBounds(643, 460, 196, 32);
		adminlogframe.getContentPane().add(adm_passwordField);
		
		adm_loginbutton = new JButton("Login");//login button
		adm_loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adm_loginbutton.setBackground(Color.BLACK);
		adm_loginbutton.setForeground(Color.WHITE);
		adm_loginbutton.setBounds(643, 518, 196, 39);
		adminlogframe.getContentPane().add(adm_loginbutton);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(655,0, 105, 32);
		adminlogframe.getContentPane().add(lblNewLabel);
		
		JLabel Background3=new JLabel("",img2,JLabel.CENTER);//background
		Background3.setBounds(10, 0, 1350, 840);
		adminlogframe.getContentPane().add(Background3);
		JFrame alert2=new JFrame();  
		adm_loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = adm_loginfield.getText();
				String eid = new String(adm_passwordField.getPassword());
				try {
					if(AdminLogin(name,eid)) 		//if the employee is a senior manager,it loads the frame of senior manager.
					{
						new AdminView();
						adminlogframe.setVisible(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(alert2,"Invalid Credentials");
					}
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton backbutton2 = new JButton("BACK");
		backbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginframe.setVisible(true);
				adminlogframe.setVisible(false);
			}
		});
		backbutton2.setForeground(Color.WHITE);
		backbutton2.setBackground(Color.BLACK);
		backbutton2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		backbutton2.setBounds(48, 49, 94, 32);
		adminlogframe.getContentPane().add(backbutton2);}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public boolean AdminLogin(String name,String password) throws SQLException// function to check login credentials of admin.
	{
		String sql = "SELECT ssn,designation FROM employee WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("Admin")) 
			{
				if(resultSet.getString("ssn").equals(password))
				{
					return true;
				}
			}
		}
		return false;

    }
	
	
	public boolean SR_MangerLogin(String name,String password) throws SQLException// function to check login credentials of senior manger.
	{
		String sql = "SELECT ssn,designation FROM employee WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("Admin_assistant")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					System.out.println("YOU ARE IN");
					return true;
				}
			}
		}
		return false;

    }
	
	public boolean MangerLogin(String name,String password) throws SQLException// function to check login credentials of  manger.
	{
		String sql = "SELECT ssn,designation FROM employee WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("MANAGER")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					System.out.println("YOU ARE IN");
					return true;
				}
			}
		}
		return false;

    }
	
	public boolean ChefLogin(String name,String password) throws SQLException// function to check login credentials of chef.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("Chef")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
	
	
	public boolean H_ChefLogin(String name,String password) throws SQLException// function to check login credentials of head chef.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			if(resultSet.getString("designation").equals("Hchef")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
	public boolean WaiterLogin(String name,String password) throws SQLException// function to check login credentials of head chef.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname ='"+name+"'";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next())
		{
			if(resultSet.getString("designation").equals("waiter")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
    public static void main(String[] args) throws Exception 
	{
		 new login();   
	}

}