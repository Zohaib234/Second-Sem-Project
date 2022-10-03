import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;




// creating a thread class to connect with MongoDB database

		

public class DashBoard {

	private JFrame frmMuetLibraryManagement;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	MongoDatabase db;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	


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
		lblNewLabel_1_1.setBounds(100, 28, 800, 87);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 55));
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("carefully  provide correct Information");
		lblNewLabel_3.setBounds(254, 152, 447, 47);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(390, 287, 61, 21);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(390, 308, 175, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setBounds(390, 418, 61, 21);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_4_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(390, 440, 175, 32);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Sign In");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "null" })
			public void actionPerformed(ActionEvent e) {
				try {
					String uri = "mongodb://localhost:27017";
					  Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
						MongoClientURI url = new MongoClientURI(uri);
						 
						  String email = textField.getText().toString();
						     String pass = textField_1.getText().toString();
						 try (MongoClient client = new MongoClient(url)) {
							 db = client.getDatabase("SSProject");
							 System.out.println("connection established with Database");
							 MongoCollection<Document> collection = db.getCollection("newUser"); 
							   Document db_email = collection.find(new Document("Email",email)).first();
							   if(db_email==null) {JOptionPane.showMessageDialog(null, "you don't have any account please create one");
							   textField.setText("");
							   textField_1.setText("");
							   }
							   else if(db_email.containsValue(pass)==true && db_email.containsValue(email)==true) {JOptionPane.showMessageDialog(null, "logged in successfully...");
							   tabbedPane_1.setSelectedIndex(4);
							   }
							   else {JOptionPane.showMessageDialog(null, "something went wrong");}
						}
						
						 
					

				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnNewButton_2.setBounds(427, 505, 85, 27);
		btnNewButton_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sign Up");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setBounds(768, 506, 85, 21);
		panel_2.add(btnNewButton_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("if You are new User");
		lblNewLabel_4_2.setBounds(758, 482, 118, 21);
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_4_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 153));
		tabbedPane_1.addTab("Librarian", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(" Muet Library Admin Portal");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Rockwell", Font.BOLD, 55));
		lblNewLabel_1_1_2.setBounds(89, 48, 800, 87);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("carefully  provide correct Information");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(243, 172, 447, 47);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_4 = new JLabel("Email");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_4.setBounds(379, 307, 61, 21);
		panel.add(lblNewLabel_4_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(379, 328, 175, 32);
		panel.add(textField_6);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Password");
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_2.setBounds(379, 438, 61, 21);
		panel.add(lblNewLabel_4_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(379, 460, 175, 32);
		panel.add(textField_7);
		
		JButton btnNewButton_2_2 = new JButton("Sign In");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uri = "mongodb://localhost:27017";
				  Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
					MongoClientURI url = new MongoClientURI(uri);
					 
					     String email = textField_6.getText().toString();
					     String pass = textField_7.getText().toString();
					 try (MongoClient client = new MongoClient(url)) {
						 db = client.getDatabase("SSProject");
						 System.out.println("connection established with Database");
						 MongoCollection<Document> collection = db.getCollection("Admin");
						 
						 Document data = collection.find(new Document("password",pass)).first();
						 if(data==null) {JOptionPane.showMessageDialog(null, "email or password incorrect");
						    textField_6.setText("");
						    textField_7.setText("");
						 }
						 else if(data.containsValue(email)==true && data.containsValue(pass)==true) {JOptionPane.showMessageDialog(null, "logged in successfully...");
						   tabbedPane_1.setSelectedIndex(5);
						   }
						   else {JOptionPane.showMessageDialog(null, "something went wrong");}
						 
					 }
				
			}
		});
		btnNewButton_2_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_2_2.setBounds(416, 525, 85, 27);
		panel.add(btnNewButton_2_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 0, 204));
		tabbedPane_1.addTab("Sign Up", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Muet Library Sign Up Portal");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 55));
		lblNewLabel_1_1_1.setBounds(87, 37, 800, 87);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("carefully  provide correct Information");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(241, 161, 447, 47);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Email");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3.setBounds(377, 296, 61, 21);
		panel_3.add(lblNewLabel_4_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(377, 317, 175, 32);
		panel_3.add(textField_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel(" confirm Password");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1.setBounds(377, 444, 122, 32);
		panel_3.add(lblNewLabel_4_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(377, 475, 175, 32);
		panel_3.add(textField_3);
		
		JButton btnNewButton_2_1 = new JButton("Sign Up");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uri = "mongodb://localhost:27017";
					  Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
						MongoClientURI url = new MongoClientURI(uri);
						 try (MongoClient client = new MongoClient(url)) {
							 db = client.getDatabase("SSProject");
							 System.out.println("connection established with Database");
							 MongoCollection<Document> collection = db.getCollection("newUser");
							    
							    Document dc = new Document("Name",textField_4.getText().toString());
							    dc.append("Email", textField_2.getText().toString());
							    dc.append("Password", textField_5.getText().toString());
							    dc.append("Confirm Password", textField_3.getText().toString());
							    collection.insertOne(dc);
						}
					
				    JOptionPane.showMessageDialog(null, "Data Added successfully into Collection");
				    tabbedPane_1.setSelectedIndex(1);	
				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			    
			}
		});
		btnNewButton_2_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(412, 517, 108, 32);
		panel_3.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Name");
		lblNewLabel_4_3_1.setForeground(Color.WHITE);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3_1.setBounds(377, 224, 61, 21);
		panel_3.add(lblNewLabel_4_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(377, 255, 175, 32);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Password");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1_1_1.setBounds(377, 370, 61, 21);
		panel_3.add(lblNewLabel_4_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(377, 401, 175, 32);
		panel_3.add(textField_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 153));
		tabbedPane_1.addTab("S-Dashboard", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Welcome to Muet Library Student Section");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Rockwell", Font.BOLD, 45));
		lblNewLabel_1_2.setBounds(10, 46, 952, 87);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("view All Books");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(375, 191, 175, 39);
		panel_4.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\library (1).png"));
		btnNewButton_4.setBounds(409, 262, 124, 68);
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("issue a Book");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(375, 340, 175, 39);
		panel_4.add(lblNewLabel_5_1);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\book.png"));
		btnNewButton_4_1.setBounds(409, 389, 124, 68);
		panel_4.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("return a Book");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1_1.setBounds(388, 488, 175, 39);
		panel_4.add(lblNewLabel_5_1_1);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\return.png"));
		btnNewButton_4_1_1.setBounds(409, 537, 124, 68);
		panel_4.add(btnNewButton_4_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 153, 255));
		tabbedPane_1.addTab("L_dashboard", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Welcome to Muet Library Admin Section");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Rockwell", Font.BOLD, 45));
		lblNewLabel_1_2_1.setBounds(10, 39, 952, 87);
		panel_5.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("view Students");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(112, 224, 175, 39);
		panel_5.add(lblNewLabel_5_2);
		
		JButton btnNewButton_4_2 = new JButton("");
		btnNewButton_4_2.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\graduated.png"));
		btnNewButton_4_2.setBounds(138, 255, 124, 68);
		panel_5.add(btnNewButton_4_2);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Remove a Student");
		lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_2.setForeground(Color.WHITE);
		lblNewLabel_5_1_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_5_1_2.setBounds(400, 227, 157, 33);
		panel_5.add(lblNewLabel_5_1_2);
		
		JButton btnNewButton_4_1_2 = new JButton("");
		btnNewButton_4_1_2.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\presentation.png"));
		btnNewButton_4_1_2.setBounds(422, 255, 124, 68);
		panel_5.add(btnNewButton_4_1_2);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("view All Books");
		lblNewLabel_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1_1_1.setBounds(699, 224, 175, 39);
		panel_5.add(lblNewLabel_5_1_1_1);
		
		JButton btnNewButton_4_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				 MongoClient mongoClient = null;
				 
		            
		            try {
		                mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("Books");
		                  FindIterable<Document> iterDoc = collection.find();
		                  Iterator<Document> it = iterDoc.iterator();
                           System.out.println("till Now everything is Good ");
		                String[] columnNames = {"id" ,"BookName", "Author", "Edition"};
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                model.setColumnIdentifiers(columnNames);
		                
		                      
		               
		                 while(it.hasNext()) {
		                       Document dc  = it.next();
		                       String id = dc.get("_id").toString();
		                       String name = dc.get("BookName").toString();
		                       String author = dc.get("Author").toString();
		                       String edition = dc.get("Edition").toString();
		                       model.addRow(new Object[] {id,name,author,edition});
		                       
		                 }
		                
		                table.setModel(model);
		                tabbedPane_1.setSelectedIndex(6);
		                
		                mongoClient.close();
		            }
		            
		            finally {
		                
		                if (mongoClient != null) {
		                     mongoClient.close();
		                }   
		            }
			}
		});
		btnNewButton_4_1_1_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\library (1).png"));
		btnNewButton_4_1_1_1.setBounds(728, 255, 124, 68);
		panel_5.add(btnNewButton_4_1_1_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Add New book");
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_2_1.setBounds(112, 454, 175, 39);
		panel_5.add(lblNewLabel_5_2_1);
		
		JButton btnNewButton_4_2_1 = new JButton("");
		btnNewButton_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    tabbedPane_1.setSelectedIndex(11);
			}
		});
		btnNewButton_4_2_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\update.png"));
		btnNewButton_4_2_1.setBounds(138, 485, 124, 68);
		panel_5.add(btnNewButton_4_2_1);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("remove a Book");
		lblNewLabel_5_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_2_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_5_1_2_1.setBounds(400, 457, 157, 33);
		panel_5.add(lblNewLabel_5_1_2_1);
		
		JButton btnNewButton_4_1_2_1 = new JButton("");
		btnNewButton_4_1_2_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\remove.png"));
		btnNewButton_4_1_2_1.setBounds(422, 485, 124, 68);
		panel_5.add(btnNewButton_4_1_2_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Update a Book");
		lblNewLabel_5_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_1.setBounds(699, 454, 175, 39);
		panel_5.add(lblNewLabel_5_1_1_1_1);
		
		JButton btnNewButton_4_1_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\phonebook.png"));
		btnNewButton_4_1_1_1_1.setBounds(728, 485, 124, 68);
		panel_5.add(btnNewButton_4_1_1_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 204, 204));
		tabbedPane_1.addTab("SVB", null, panel_6, null);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 79, 667, 524);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(51, 204, 204));
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("SIB", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("SRB", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("LVS", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("LRS", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(102, 102, 102));
		tabbedPane_1.addTab("LAB", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Book Name");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(427, 170, 126, 24);
		panel_11.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setBackground(Color.GRAY);
		textField_8.setBounds(385, 193, 210, 36);
		panel_11.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Enter Author Name");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(427, 292, 126, 24);
		panel_11.add(lblNewLabel_6_1);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setColumns(10);
		textField_9.setBackground(Color.GRAY);
		textField_9.setBounds(385, 313, 210, 36);
		panel_11.add(textField_9);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Enter Book Edition");
		lblNewLabel_6_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1_1.setBounds(427, 433, 126, 24);
		panel_11.add(lblNewLabel_6_1_1);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.GRAY);
		textField_10.setBounds(385, 455, 210, 36);
		panel_11.add(textField_10);
		
		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName= textField_8.getText().toString();
				String Author= textField_9.getText().toString();
				String edition= textField_10.getText().toString();
				try {
					String uri = "mongodb://localhost:27017";
					  Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
						MongoClientURI url = new MongoClientURI(uri);
						 try (MongoClient client = new MongoClient(url)) {
							 db = client.getDatabase("SSProject");
							 System.out.println("connection established with Database");
							 MongoCollection<Document> collection = db.getCollection("Books");
							    
							    Document dc = new Document("BookName",bookName);
							    dc.append("Author",Author );
							    dc.append("Edition",edition);
							    collection.insertOne(dc);
						}
					
				    JOptionPane.showMessageDialog(null, "Data Added successfully into Collection");
//				    tabbedPane_1.setSelectedIndex(1);	
				    textField_8.setText("");
				    textField_9.setText("");
				    textField_10.setText("");
				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}

				
				
			}
		});
		btnNewButton_5.setBounds(445, 525, 85, 21);
		panel_11.add(btnNewButton_5);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_1.addTab("LRB", null, panel_12, null);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		tabbedPane_1.addTab("LUB", null, panel_13, null);
		panel_13.setLayout(null);

	}
}
