import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JList;






		

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
    JList list = new JList();
    String removeBook;
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("issue for one moth");
	private JRadioButton rdbtnIssueForComplete = new JRadioButton("issue for complete Semester");
	
	MongoDatabase db;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	public String name;
	public String author;
	public String edition;
	private JTable table_1;
	private JTextField textField_16;
	JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textField_17;
	private JTable table_2;
	
	public void issueBook() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		try {
			String uri = "mongodb://localhost:27017";
			  Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
				MongoClientURI url = new MongoClientURI(uri);
				 try (MongoClient client = new MongoClient(url)) {
					 db = client.getDatabase("SSProject");
					 System.out.println("connection established with Database");
					 MongoCollection<Document> collection = db.getCollection("IssuedBooks");
					    
					    Document dc = new Document("issuedbookname",textField_17.getText().toString());
					    
					    if(rdbtnNewRadioButton.isSelected()) {
					    	dc.append("Duration", rdbtnNewRadioButton.getText());}
					    
					    else if(rdbtnIssueForComplete.isSelected()) {
					    	dc.append("Duration",rdbtnIssueForComplete.getText());}
					    
					    
					    
					    dc.append("Date of Issuence", strDate);
					    collection.insertOne(dc);
				}
			
		    JOptionPane.showMessageDialog(null, "You just issued a Book successfully ");
//		    tabbedPane_1.setSelectedIndex(1);	
		}
		catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public void showtable() {
		
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
	
	public void showissuetable() {
		
		 MongoClient mongoClient = null;
		 
          
          try {
              mongoClient = new MongoClient( "localhost" , 27017 );
                MongoDatabase database = mongoClient.getDatabase("SSProject");
                MongoCollection<Document> collection = database.getCollection("IssuedBooks");
                FindIterable<Document> iterDoc = collection.find();
                Iterator<Document> it = iterDoc.iterator();
              System.out.println("till Now everything is Good ");
              String[] columnNames = {"id" ,"BookName", "Duration", "issuence Date"};
              DefaultTableModel model = (DefaultTableModel) table_2.getModel();
              model.setColumnIdentifiers(columnNames);
              
                    
             
               while(it.hasNext()) {
                     Document dc  = it.next();
                     String id = dc.get("_id").toString();
                     String name = dc.get("issuedbookname").toString();
                     String author = dc.get("Duration").toString();
                     String edition = dc.get("Date of Issuence").toString();
                     model.addRow(new Object[] {id,name,author,edition});
                     
               }
              
              table_2.setModel(model);
              tabbedPane_1.setSelectedIndex(10);
              
              mongoClient.close();
          }
          
          finally {
              
              if (mongoClient != null) {
                   mongoClient.close();
              }   
          }
	}


	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	   
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					   myThread t1 = new myThread();
					   t1.start();
					   t1.join();
					   Timer timer = new Timer(9550, (ActionListener) new ActionListener(){
				             public void actionPerformed(ActionEvent evt) {
				            	 DashBoard window = new DashBoard();
									window.frmMuetLibraryManagement.setVisible(true);
				             }
				         });
				         timer.setRepeats(false);
				         timer.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
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
		frmMuetLibraryManagement.setLocationRelativeTo(null);
		frmMuetLibraryManagement.getContentPane().setLayout(null);
		
		
		tabbedPane_1.setBounds(0, 0, 1011, 723);
		frmMuetLibraryManagement.getContentPane().add(tabbedPane_1);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("", null, panel_1, null);
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
		tabbedPane_1.addTab("", null, panel_2, null);
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
		
		JButton btnNewButton_9 = new JButton("Back to Home");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(0);
			}
		});
		btnNewButton_9.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9.setBounds(10, 10, 145, 32);
		panel_2.add(btnNewButton_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 153));
		tabbedPane_1.addTab("", null, panel, null);
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
		
		JButton btnNewButton_9_1 = new JButton("Back to Home");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(0);
				
			}
		});
		btnNewButton_9_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1.setBounds(0, 0, 145, 32);
		panel.add(btnNewButton_9_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 0, 204));
		tabbedPane_1.addTab(null, null, panel_3, null);
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
					
				    JOptionPane.showMessageDialog(null, "Account created successfully ");
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
		
		JButton btnNewButton_9_1_1 = new JButton("Back to Log In");
		btnNewButton_9_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(1);
			}
		});
		btnNewButton_9_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_1.setBounds(0, 10, 145, 32);
		panel_3.add(btnNewButton_9_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 153));
		tabbedPane_1.addTab("", null, panel_4, null);
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
		lblNewLabel_5.setBounds(189, 197, 175, 39);
		panel_4.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showtable();
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\library (1).png"));
		btnNewButton_4.setBounds(218, 232, 124, 68);
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("issue a Book");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(582, 197, 175, 39);
		panel_4.add(lblNewLabel_5_1);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(9);
			}
		});
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\book.png"));
		btnNewButton_4_1.setBounds(622, 232, 124, 68);
		panel_4.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("return a Book");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblNewLabel_5_1_1.setBounds(189, 382, 175, 39);
		panel_4.add(lblNewLabel_5_1_1);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			  returnBook = 	list.getSelectedValue();
				 MongoClient mongoClient = null;
				 
		          
		          try {
		              mongoClient = new MongoClient( "localhost" , 27017 );
		                MongoDatabase database = mongoClient.getDatabase("SSProject");
		                MongoCollection<Document> collection = database.getCollection("IssuedBooks");
		                FindIterable<Document> iterDoc = collection.find();
		                Iterator<Document> it = iterDoc.iterator();
		              System.out.println("till Now everything is Good ");
		              
		              DefaultListModel<String> l = new DefaultListModel<>();        
		               while(it.hasNext()) {
		                     Document dc  = it.next();
		                   
		                     String name = dc.get("issuedbookname").toString();
		                     l.addElement(name);
		                     
		                    
		                     
		               }
		               System.out.println(l);
		                   list.setModel(l);
		              
		            
		              tabbedPane_1.setSelectedIndex(14);
		              
		              mongoClient.close();
		          }
		          
		          finally {
		              
		              if (mongoClient != null) {
		                   mongoClient.close();
		              }   
		          }
				
			}
		});
		btnNewButton_4_1_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\return.png"));
		btnNewButton_4_1_1.setBounds(218, 413, 124, 68);
		panel_4.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("view all issued books");
		lblNewLabel_5_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_5_1_1_2.setBounds(606, 385, 149, 27);
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JButton btnNewButton_4_1_1_2 = new JButton("");
		btnNewButton_4_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showissuetable();
			}
		});
		btnNewButton_4_1_1_2.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\library.png"));
		btnNewButton_4_1_1_2.setBounds(622, 413, 124, 68);
		panel_4.add(btnNewButton_4_1_1_2);
		
		JButton btnNewButton_9_1_2 = new JButton("Back to Home");
		btnNewButton_9_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane_1.setSelectedIndex(0);
			}
		});
		btnNewButton_9_1_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2.setBounds(0, 10, 145, 32);
		panel_4.add(btnNewButton_9_1_2);
		
		JButton btnNewButton_9_1_2_1 = new JButton("Log Off");
		btnNewButton_9_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(1);
			}
		});
		btnNewButton_9_1_2_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1.setBounds(851, 14, 145, 32);
		panel_4.add(btnNewButton_9_1_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 153, 255));
		tabbedPane_1.addTab("", null, panel_5, null);
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
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MongoClient mongoClient = null;
				 
		            
		            try {
		                mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("newUser");
		                  FindIterable<Document> iterDoc = collection.find();
		                  Iterator<Document> it = iterDoc.iterator();
                        System.out.println("till Now everything is Good ");
		                String[] columnNames = {"Name" ,"Email"};
		                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		                model.setColumnIdentifiers(columnNames);
		                
		                      
		               
		                 while(it.hasNext()) {
		                       Document dc  = it.next();
		                       String name = dc.get("Name").toString();
		                       String email = dc.get("Email").toString();
		                      
		                       model.addRow(new Object[] {name,email});
		                       
		                 }
		                
		                table_1.setModel(model);
		                tabbedPane_1.setSelectedIndex(11);
		                
		                mongoClient.close();
		            }
		            
		            finally {
		                
		                if (mongoClient != null) {
		                     mongoClient.close();
		                }   
		            }
				
				
			}
		});
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
		btnNewButton_4_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane_1.setSelectedIndex(12);
			}
		});
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
			showtable();
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
			    tabbedPane_1.setSelectedIndex(13);
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
		btnNewButton_4_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(8);
			}
		});
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
		btnNewButton_4_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(7);
			}
		});
		btnNewButton_4_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Zohaib\\Downloads\\phonebook.png"));
		btnNewButton_4_1_1_1_1.setBounds(728, 485, 124, 68);
		panel_5.add(btnNewButton_4_1_1_1_1);
		
		JButton btnNewButton_9_1_3 = new JButton("Back to Home");
		btnNewButton_9_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(0);
			}
		});
		btnNewButton_9_1_3.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_3.setBounds(0, 0, 145, 32);
		panel_5.add(btnNewButton_9_1_3);
		
		JButton btnNewButton_9_1_2_1_1 = new JButton("Log Off");
		btnNewButton_9_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(2);
			}
		});
		btnNewButton_9_1_2_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1.setBounds(851, 4, 145, 32);
		panel_5.add(btnNewButton_9_1_2_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 204, 204));
		tabbedPane_1.addTab("", null, panel_6, null);
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
		table.setBackground(Color.WHITE);
		
		JButton btnNewButton_9_1_3_1 = new JButton("Back to S_DashBoard");
		btnNewButton_9_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				tabbedPane_1.setSelectedIndex(4);
			}
		});
		btnNewButton_9_1_3_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_3_1.setBounds(10, 10, 190, 32);
		panel_6.add(btnNewButton_9_1_3_1);
		
		JButton btnNewButton_9_1_2_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1.setBounds(773, 4, 223, 32);
		panel_6.add(btnNewButton_9_1_2_1_1_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(70, 130, 180));
		tabbedPane_1.addTab("", null, panel_13, null);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel(" Book Name");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_8.setBounds(108, 87, 124, 39);
		panel_13.add(lblNewLabel_8);
		
		textField_12 = new JTextField();
		textField_12.setBounds(209, 92, 186, 36);
		panel_13.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("Search");
		textField_13 = new JTextField();
		textField_14 = new JTextField();
		textField_15 = new JTextField();
		
		textField_13.setForeground(Color.BLACK);
		textField_13.setColumns(10);
		textField_13.setBackground(Color.WHITE);
		textField_13.setBounds(365, 229, 210, 36);
		panel_13.add(textField_13);
		
		
		textField_14.setForeground(Color.BLACK);
		textField_14.setColumns(10);
		textField_14.setBackground(Color.WHITE);
		textField_14.setBounds(365, 349, 210, 36);
		panel_13.add(textField_14);
		
		textField_15.setForeground(Color.BLACK);
		textField_15.setColumns(10);
		textField_15.setBackground(Color.WHITE);
		textField_15.setBounds(365, 491, 210, 36);
		panel_13.add(textField_15);
		
		
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					String uri = "mongodb://localhost:27017";
					  Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
						MongoClientURI url = new MongoClientURI(uri);
						 
						     String bookName = textField_12.getText().toString();
						 try (MongoClient client = new MongoClient(url)) {
							 db = client.getDatabase("SSProject");
							 System.out.println("connection established with Database");
							 MongoCollection<Document> collection = db.getCollection("Books");
							 
							 Document data = collection.find(new Document("BookName",bookName)).first();
							 if(data==null) {JOptionPane.showMessageDialog(null, "Book Not Found on DataBase");
							    textField_12.setText("");
							 }
							 else if(data.containsValue(bookName)==true ) {
//								 JOptionPane.showMessageDialog(null, "logged in successfully...");
//							     tabbedPane_1.setSelectedIndex(5);
								  name = data.get("BookName").toString();
								  author = data.get("Author").toString();
								  edition = data.get("Edition").toString();
								 System.out.println(name + " " + author + " " + edition);
								 textField_13.setText(name);
								 textField_14.setText(author);
								 textField_15.setText(edition);
							   }
							   else {JOptionPane.showMessageDialog(null, "something went wrong");}
							 
						 }	
				}
				
				
			}
		);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.setBackground(new Color(240, 240, 240));
		btnNewButton_7.setBounds(426, 97, 85, 21);
		panel_13.add(btnNewButton_7);
		
		JLabel lblNewLabel_6_2 = new JLabel("Update Book Name");
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(407, 206, 126, 24);
		panel_13.add(lblNewLabel_6_2);
		
	
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Update Author Name");
		lblNewLabel_6_1_2.setForeground(Color.WHITE);
		lblNewLabel_6_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1_2.setBounds(407, 328, 126, 24);
		panel_13.add(lblNewLabel_6_1_2);
		
		
		
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("Update Book Edition");
		lblNewLabel_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1_1_1.setBounds(407, 469, 126, 24);
		panel_13.add(lblNewLabel_6_1_1_1);
		
		
		
		
		JButton btnNewButton_5_1 = new JButton("Update");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(name + " " + author + " " + edition);
				
				int result = JOptionPane.showConfirmDialog(null, "are you sure you want to Update this Book",null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) {
					String uri = "mongodb://localhost:27017";
					  Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
						MongoClientURI url = new MongoClientURI(uri);
						 
						    
						 try (MongoClient client = new MongoClient(url)) {
							 db = client.getDatabase("SSProject");
							 System.out.println("connection established with Database");
							 MongoCollection<Document> collection = db.getCollection("Books");
							 
							  UpdateResult result1 = collection.updateOne(Filters.eq("BookName", name), Updates.set("BookName", textField_13.getText()));
							  result1 = collection.updateOne(Filters.eq("Author", author), Updates.set("Author", textField_14.getText()));
							  result1 = collection.updateOne(Filters.eq("Edition",edition), Updates.set("Edition", textField_15.getText()));
//							   System.out.println("BookName Updated successfulyy" + result1.getModifiedCount());
							  JOptionPane.showMessageDialog(frmMuetLibraryManagement, "Book's Information Updated Successfully");
							  textField_13.setText("");
							  textField_14.setText("");
							  textField_15.setText("");
							 
							 
							 
						 }	
				}
				
			
				
			}
		});
		btnNewButton_5_1.setBounds(425, 561, 85, 21);
		panel_13.add(btnNewButton_5_1);
		
		JButton btnNewButton_9_1_2_1_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1_1.setBounds(760, 10, 223, 32);
		panel_13.add(btnNewButton_9_1_2_1_1_1_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(102, 51, 102));
		tabbedPane_1.addTab("", null, panel_12, null);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Book Name to Remove from Library");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Sitka Text", Font.BOLD, 22));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(224, 162, 519, 66);
		panel_12.add(lblNewLabel_7);
		
		textField_11 = new JTextField();
		textField_11.setBounds(309, 238, 292, 40);
		panel_12.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Remove");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "are you sure you want to delete this book it will not be restored",null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) {
					 MongoClient mongoClient = null;
					try {
						 mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("Books");
		                  collection.deleteOne(Filters.eq("BookName", textField_11.getText()));
		                  System.out.println("book Deleted");
		                  JOptionPane.showMessageDialog(frmMuetLibraryManagement, "Book removed Successfulyy");
					}
					catch (Exception e2) {System.out.println(e2.getMessage());}
					
				}
				else {JOptionPane.showMessageDialog(frmMuetLibraryManagement, "Good don't delete books they are important");}
			}
		});
		btnNewButton_6.setBounds(409, 347, 85, 21);
		panel_12.add(btnNewButton_6);
		
		JButton btnNewButton_9_1_2_1_1_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1_1_1.setBounds(773, 10, 223, 32);
		panel_12.add(btnNewButton_9_1_2_1_1_1_1_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaption);
		tabbedPane_1.addTab("", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7_2 = new JLabel("Enter Book Name to issue from Library");
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("SimSun", Font.BOLD, 22));
		lblNewLabel_7_2.setBounds(220, 169, 519, 66);
		panel_7.add(lblNewLabel_7_2);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(267, 245, 417, 66);
		panel_7.add(textField_17);
		
		JButton btnNewButton_6_2 = new JButton("issue");
		
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(297, 387, 173, 27);
		panel_7.add(rdbtnNewRadioButton);
		
		
		rdbtnIssueForComplete.setForeground(Color.WHITE);
		rdbtnIssueForComplete.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		rdbtnIssueForComplete.setBackground(SystemColor.activeCaption);
		rdbtnIssueForComplete.setBounds(297, 431, 225, 27);
		panel_7.add(rdbtnIssueForComplete);
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnIssueForComplete);
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MongoClient mongoClient = null;
					try {
						 mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("Books");
		                  FindIterable<Document> data = collection.find(new Document("BookName",textField_17.getText()));
		                  if(data==null) {JOptionPane.showMessageDialog(frmMuetLibraryManagement, "The Book You are trying to borrow is not available in our DataBase");
		                  textField_17.setText("");
		                  G.clearSelection();
		                  }
		                  else {issueBook();
		                  textField_17.setText("");
		                  G.clearSelection();}
		                  }
		                  
                     
		                  
		                 
					
					catch (Exception e2) {System.out.println(e2.getMessage());}
				
			
			}
		});
		btnNewButton_6_2.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton_6_2.setBounds(398, 599, 89, 27);
		panel_7.add(btnNewButton_6_2);
		
		JButton btnNewButton_9_1_3_1_1 = new JButton("Back to S_DashBoard");
		btnNewButton_9_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(4);			}
		});
		btnNewButton_9_1_3_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_3_1_1.setBounds(10, 10, 190, 32);
		panel_7.add(btnNewButton_9_1_3_1_1);
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(153, 102, 102));
		tabbedPane_1.addTab("", null, panel_8, null);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(103, 46, 728, 598);
		panel_8.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_9_1_3_1_1_1 = new JButton("Back to S_DashBoard");
		btnNewButton_9_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dm = (DefaultTableModel)table_2.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				tabbedPane_1.setSelectedIndex(4);
			}
		});
		btnNewButton_9_1_3_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_3_1_1_1.setBounds(0, 0, 190, 32);
		panel_8.add(btnNewButton_9_1_3_1_1_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(112, 128, 144));
		tabbedPane_1.addTab("", null, panel_9, null);
		panel_9.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(147, 64, 711, 531);
		panel_9.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_9_1_2_1_1_1_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dm = (DefaultTableModel)table_1.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1_1_1_1.setBounds(773, 10, 223, 32);
		panel_9.add(btnNewButton_9_1_2_1_1_1_1_1_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(72, 61, 139));
		tabbedPane_1.addTab("", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel("Enter Student Name to Remove ");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Sitka Text", Font.BOLD, 22));
		lblNewLabel_7_1.setBounds(228, 175, 519, 66);
		panel_10.add(lblNewLabel_7_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(313, 251, 292, 40);
		panel_10.add(textField_16);
		
		JButton btnNewButton_6_1 = new JButton("Remove");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "are you sure you want to remove  this student ",null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) {
					
					 MongoClient mongoClient = null;
					try {
						 mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("newUser");
		                  collection.deleteOne(Filters.eq("Name", textField_16.getText()));
		                  System.out.println("book Deleted");
		                  JOptionPane.showMessageDialog(frmMuetLibraryManagement, "student  removed");
					}
					catch (Exception e2) {System.out.println(e2.getMessage());}
					
				}
				else {JOptionPane.showMessageDialog(frmMuetLibraryManagement, "you just save one student");}
				
			}
		});
		btnNewButton_6_1.setBounds(413, 360, 85, 21);
		panel_10.add(btnNewButton_6_1);
		
		JButton btnNewButton_9_1_2_1_1_1_1_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1_1_1_1_1.setBounds(773, 10, 223, 32);
		panel_10.add(btnNewButton_9_1_2_1_1_1_1_1_1_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(102, 102, 102));
		tabbedPane_1.addTab("", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Book Name");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(427, 170, 126, 24);
		panel_11.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_8.setForeground(Color.BLACK);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(385, 193, 210, 36);
		panel_11.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Enter Author Name");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(427, 292, 126, 24);
		panel_11.add(lblNewLabel_6_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_9.setForeground(Color.BLACK);
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(385, 313, 210, 36);
		panel_11.add(textField_9);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Enter Book Edition");
		lblNewLabel_6_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_6_1_1.setBounds(427, 433, 126, 24);
		panel_11.add(lblNewLabel_6_1_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_10.setForeground(Color.BLACK);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
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
					
				    JOptionPane.showMessageDialog(null, "New Book added successfully ");
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
		
		JButton btnNewButton_9_1_2_1_1_1_1_1_1_1_1 = new JButton("Back to Admin_DashBoard");
		btnNewButton_9_1_2_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(5);
			}
		});
		btnNewButton_9_1_2_1_1_1_1_1_1_1_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_2_1_1_1_1_1_1_1_1.setBounds(773, 10, 223, 32);
		panel_11.add(btnNewButton_9_1_2_1_1_1_1_1_1_1_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(0, 204, 153));
		tabbedPane_1.addTab("", null, panel_14, null);
		panel_14.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(187, 198, 661, 64);
		panel_14.add(scrollPane_3);
		scrollPane_3.setViewportView(list);
		
		JButton btnNewButton_8 = new JButton("return ");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				removeBook = list.getSelectedValue().toString();
				 MongoClient mongoClient = null;
					try {
						 mongoClient = new MongoClient( "localhost" , 27017 );
		                  MongoDatabase database = mongoClient.getDatabase("SSProject");
		                  MongoCollection<Document> collection = database.getCollection("IssuedBooks");
		                  collection.deleteOne(Filters.eq("issuedbookname", list.getSelectedValue()));
		                  
		                  JOptionPane.showMessageDialog(frmMuetLibraryManagement, "Book  returned Successfulyy");
		                  tabbedPane_1.setSelectedIndex(4);
		                  
					}
					catch (Exception e2) {System.out.println(e2.getMessage());}
				
			}
		});
		btnNewButton_8.setFont(new Font("SimSun", Font.BOLD, 15));
		btnNewButton_8.setBounds(419, 307, 101, 36);
		panel_14.add(btnNewButton_8);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Your Issued Books ");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblNewLabel_1_2_1_1.setBounds(10, 120, 952, 87);
		panel_14.add(lblNewLabel_1_2_1_1);
		
		JButton btnNewButton_9_1_3_1_1_2 = new JButton("Back to S_DashBoard");
		btnNewButton_9_1_3_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane_1.setSelectedIndex(4);
			}
		});
		btnNewButton_9_1_3_1_1_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_9_1_3_1_1_2.setBounds(10, 10, 190, 32);
		panel_14.add(btnNewButton_9_1_3_1_1_2);

	}
}
