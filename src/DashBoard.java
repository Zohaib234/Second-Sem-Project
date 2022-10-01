import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DashBoard {

	private JFrame frmMuetLibraryManagement;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frmMuetLibraryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMuetLibraryManagement = new JFrame();
		frmMuetLibraryManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zohaib\\Downloads\\icons8-library-building-50.png"));
		frmMuetLibraryManagement.setTitle("Muet Library Management System");
		frmMuetLibraryManagement.setResizable(false);
		frmMuetLibraryManagement.setBounds(100, 100, 1025, 760);
		frmMuetLibraryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMuetLibraryManagement.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 1011, 723);
		frmMuetLibraryManagement.getContentPane().add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Intro", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Muet Library");
		lblNewLabel_1.setForeground(new Color(153, 0, 255));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 55));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 33, 800, 87);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\Library_Management-removebg-preview.png"));
		lblNewLabel_2.setBounds(145, 145, 800, 443);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(1);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\graduated.png"));
		btnNewButton.setBounds(104, 297, 163, 73);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("For Students");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 272, 116, 25);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(2);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\avatar.png"));
		btnNewButton_1.setBounds(728, 297, 163, 73);
		panel_1.add(btnNewButton_1);
		
		JLabel lblForLibrariyan = new JLabel("For Librariyan");
		lblForLibrariyan.setHorizontalAlignment(SwingConstants.CENTER);
		lblForLibrariyan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForLibrariyan.setBounds(728, 272, 116, 25);
		panel_1.add(lblForLibrariyan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 153));
		tabbedPane_1.addTab("Student", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Muet Library Sign In Portal");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 55));
		lblNewLabel_1_1.setBounds(100, 28, 800, 87);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("carefully  provide correct Information");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(254, 152, 447, 47);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(390, 287, 61, 21);
		panel_2.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(390, 308, 175, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(390, 418, 61, 21);
		panel_2.add(lblNewLabel_4_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(390, 440, 175, 32);
		panel_2.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Sign In");
		btnNewButton_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_2.setBounds(427, 505, 85, 27);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sign Up");
		btnNewButton_3.setBounds(768, 506, 85, 21);
		panel_2.add(btnNewButton_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("if You are new User");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(758, 482, 118, 21);
		panel_2.add(lblNewLabel_4_2);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Librarian", null, panel, null);
		panel.setLayout(null);
		
//		JLabel lblNewLabel_1 = new JLabel("Welcome to Muet Library");
//		lblNewLabel_1.setForeground(new Color(153, 0, 255));
//		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 55));
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setBounds(64, 33, 800, 87);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\Library_Management-removebg-preview.png"));
//		lblNewLabel_2.setBounds(145, 145, 800, 443);
//		panel.add(lblNewLabel_2);
//		
//		JButton btnNewButton = new JButton("");
//		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\graduated.png"));
//		btnNewButton.setBounds(104, 297, 163, 73);
//		panel.add(btnNewButton);
	}
}
