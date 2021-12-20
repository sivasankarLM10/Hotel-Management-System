package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class waiter 
{

	private JFrame waiter;
	
	JPanel updt_pers_wt;
	JPanel updt_pricewt;
	JPanel off_det_wt;
	JPanel persn_det_wt;
	JPanel review_wt;
	
	String HName;
	
	Manager mobj;
	Dishes dobj;
	hotel hobj;

	public waiter(String ssn) throws Exception{
		mobj = new Manager(ssn);
		mobj.init();
		dobj = new Dishes();
		dobj.init();
		hobj = new hotel();
		hobj.init();
		initialize();
	}

	
	private void initialize() throws SQLException 
	{
		JFrame alert = new JFrame();
		waiter = new JFrame();//Waiter frame details
		waiter.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		waiter.getContentPane().setBackground(new Color(7, 22, 137));
		waiter.setBackground(Color.DARK_GRAY);
		waiter.setSize(2000,780);
		waiter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		waiter.setVisible(true);
		
		ImageIcon  i = new ImageIcon("E:\\\\Eclipse workspace\\\\NSS.png");//logo
		waiter.getContentPane().setLayout(null);
		
		
		JPanel sidebar = new JPanel();//SIDE PANEL
		sidebar.setBounds(0, 0,200,1000);
		sidebar.setBackground(new Color(253, 130, 4));
		waiter.getContentPane().add(sidebar);
		sidebar.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(0,0, 400, 143);
		sidebar.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel title = new JPanel();//HEADING PANEL
		title.setBounds(167, 32, 1203, 49);
		title.setBackground(new Color(0, 173, 217));
		waiter.getContentPane().add(title);
		title.setLayout(null);
		
		JLabel restaurantname = new JLabel("NSS Restaurant Group- Waiter");//RESTAURANT NAME
		restaurantname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		restaurantname.setForeground(Color.WHITE);
		restaurantname.setBounds(105, 11, 542, 38);
		title.add(restaurantname);
		
		JButton BACK = new JButton("BACK");//BACK BUTTON
		BACK.setForeground(Color.WHITE);
		BACK.setBackground(Color.BLACK);
		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BACK.setBounds(1075, 11, 89, 23);
		title.add(BACK);
		BACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				waiter.setVisible(false);
				try {
					new login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton ViewOfficialDet = new JButton("View Official Details");//View Official Details Buttons
		ViewOfficialDet.setBackground(Color.WHITE);
		ViewOfficialDet.setBounds(10, 271,175, 36);
		sidebar.add(ViewOfficialDet);

		
		ViewOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				off_det_wt.setVisible(true);
				updt_pers_wt.setVisible(false);
				updt_pricewt.setVisible(false);
				review_wt.setVisible(false);
			}
		});
		
		JButton UpdateOfficialDet = new JButton("Update Personal Details");//Update Personal Details Button
		UpdateOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers_wt.setVisible(true);
				updt_pricewt.setVisible(false);
				off_det_wt.setVisible(false);
				review_wt.setVisible(false);
			}
		});
		UpdateOfficialDet.setBackground(Color.WHITE);
		UpdateOfficialDet.setBounds(10, 224,175, 36);
		sidebar.add(UpdateOfficialDet);
		
		JButton review = new JButton("Review");//Update Personal Details Button
		review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers_wt.setVisible(false);
				updt_pricewt.setVisible(false);
				off_det_wt.setVisible(false);
				review_wt.setVisible(true);
			}
		});
		review.setBackground(Color.WHITE);
		review.setBounds(10,320,175, 36);
		sidebar.add(review);
		
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(199, 118, 1150, 571);
		waiter.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//------------------------------------update personal details panel-----------------------------------------------
		
		updt_pers_wt = new JPanel();//update personal details panel
		updt_pers_wt.setVisible(false);
		updt_pers_wt.setBounds(255, 62, 621, 194);
		panel_3.add(updt_pers_wt);
		updt_pers_wt.setLayout(null);
		
		JLabel pers_dtwt_lbl = new JLabel("Update Personal Details:");//heading label of panel
		pers_dtwt_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pers_dtwt_lbl.setBounds(6, 6, 220, 21);
		updt_pers_wt.add(pers_dtwt_lbl);
		
		JLabel phonewt_lbl = new JLabel("Phone:");//phone label
		phonewt_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phonewt_lbl.setBounds(20, 43, 46, 14);
		updt_pers_wt.add(phonewt_lbl);
		
		JTextField phonewt_txt = new JTextField(null);// phone text field
		phonewt_txt.setBounds(155, 43, 245, 20);
		updt_pers_wt.add(phonewt_txt);
		phonewt_txt.setColumns(10);
		
		JLabel addrwt_lbl = new JLabel("Address:");//address label
		addrwt_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addrwt_lbl.setBounds(20, 83, 80, 14);
		updt_pers_wt.add(addrwt_lbl);
		
		JTextField addrwt_txt = new JTextField(null);// phone text field
		addrwt_txt.setBounds(155, 83, 245, 20);
		updt_pers_wt.add(addrwt_txt);
		addrwt_txt.setColumns(10);
		
		JButton updatewt = new JButton("Update");//update button
		updatewt.setForeground(Color.WHITE);
		updatewt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatewt.setBackground(Color.BLACK);
		updatewt.setBounds(440, 150, 120, 23);
		updt_pers_wt.add(updatewt);
		
		updatewt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = phonewt_txt.getText();
				String add = addrwt_txt.getText();
				
				try {
					mobj.UpdatePersonaldetails(phone, add);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(alert,"Invalid Details !!");
				}
				JOptionPane.showMessageDialog(alert,"Details Updated !!");
			}
		});
		
		
		//-------------------------------------
		
		Object[] dets = mobj.ViewOfficialdetails();
		
		off_det_wt = new JPanel();
		off_det_wt.setBounds(258, 50, 621, 194);
		off_det_wt.setVisible(false);
		panel_3.add(off_det_wt);
		off_det_wt.setLayout(null);
 
		JLabel off_hcf_wt = new JLabel("Official details:");
		off_hcf_wt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		off_hcf_wt.setBounds(10, 11, 800, 20);
		off_det_wt.add(off_hcf_wt);
		
		JLabel ssn_wt = new JLabel("SSN:" + dets[0]);
		ssn_wt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssn_wt.setBounds(30, 53, 800, 20);
		off_det_wt.add(ssn_wt);
		
		JLabel desig_wt = new JLabel("Designation:" + dets[1]);
		desig_wt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		desig_wt.setBounds(30, 93, 800, 14);
		off_det_wt.add(desig_wt);
		
		JLabel wrkplc_wt = new JLabel("Workplace :" + dets[3]);
		wrkplc_wt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wrkplc_wt.setBounds(30, 133, 800, 14);
		off_det_wt.add(wrkplc_wt);
		
		JLabel sal_wt = new JLabel("Salary :" + dets[2]);
		sal_wt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sal_wt.setBounds(30, 173, 800, 14);
		off_det_wt.add(sal_wt);
	}		
}