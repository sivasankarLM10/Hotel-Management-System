package project;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class selectHotel {

    private JFrame frame;
    int count;
    String Hname;
    customer cobj;


    public selectHotel() throws Exception {
        count = 0;
        initialize();
    }


    protected void initialize() throws Exception {
    	cobj = new customer();
    	
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
        frame.getContentPane().setBackground(new Color(88, 136, 169));
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(2000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon i = new ImageIcon("E:\\\\Eclipse workspace\\\\NSS.png"); //logo
        frame.getContentPane().setLayout(null);


        JPanel sidebar = new JPanel(); //SIDE PANEL
        sidebar.setBounds(0, 0,200,1000);
        sidebar.setBackground(new Color(217, 198, 146));
        frame.getContentPane().add(sidebar);
        sidebar.setLayout(null);
        JLabel label3 = new JLabel(i);
        label3.setBounds(0,0, 400, 143);
        sidebar.add(label3);
        label3.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel title = new JPanel(); //HEADING PANEL
        title.setBounds(167, 32, 1203, 49);
        title.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(title);
        title.setLayout(null);

        JLabel restaurantname = new JLabel("NSS RESTAURANT GROUP"); //RESTAURANT NAME
        restaurantname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        restaurantname.setForeground(Color.WHITE);
        restaurantname.setBounds(105, 11, 542, 38);
        title.add(restaurantname);

        JButton BACK = new JButton("BACK"); //BACK BUTTON
        BACK.setForeground(Color.WHITE);
        BACK.setBackground(Color.BLACK);
        BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        BACK.setBounds(1075, 11, 89, 23);
        title.add(BACK);
        BACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					new login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

        Panel contents = new Panel();
        contents.setBackground(new Color(255, 255, 255));
        contents.setBounds(199, 119, 1150, 571);
        frame.getContentPane().add(contents);
        contents.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Select a restaurant");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(32, 21, 155, 14);
        contents.add(lblNewLabel_1);

        JRadioButton Oriental = new JRadioButton("NSS Mandarin Oriental");
        Oriental.setBounds(32, 42, 155, 23);
        contents.add(Oriental);

        if (Oriental.isSelected()) {
            Hname = "NSS Mandarin Oriental";
        }

        JRadioButton Indigo = new JRadioButton("NSS Indigo");
        Indigo.setBounds(32, 66, 155, 23);
        contents.add(Indigo);

        if (Indigo.isSelected()) {
            Hname = "NSS Indigo";
        }

        JRadioButton Apollo = new JRadioButton("NSS New Apollo");
        Apollo.setBounds(32, 92, 155, 23);
        contents.add(Apollo);

        if (Apollo.isSelected()) {
            Hname = "NSS New Apollo";
        }

        JRadioButton Meadow = new JRadioButton("NSS Meadow Manor");
        Meadow.setBounds(32, 118, 155, 23);
        contents.add(Meadow);

        if (Meadow.isSelected()) {
            Hname = "NSS Meadow Manor";
        }

        JRadioButton Oasis = new JRadioButton("NSS The Oasis");
        Oasis.setBounds(32, 144, 155, 23);
        contents.add(Oasis);

        if (Oasis.isSelected()) {
            Hname = "NSS The Oasis";
        }

        JButton select = new JButton("Select");
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Oriental.isSelected()) {
                    Hname = "NSS Mandarin Oriental";
                }

                if (Indigo.isSelected()) {
                    Hname = "NSS Indigo";
                }

                if (Apollo.isSelected()) {
                    Hname = "NSS New Apollo";
                }

                if (Meadow.isSelected()) {
                    Hname = "NSS Meadow Manor";
                }

                if (Oasis.isSelected()) {
                    Hname = "NSS The Oasis";
                }
                try {
                	cobj.Hname = Hname;
                    new orderDishes(Hname,cobj);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);

            }
        });
        select.setBounds(32, 215, 125, 23);
        contents.add(select);
    }

   
}