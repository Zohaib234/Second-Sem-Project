
import javax.swing.*;
import java.awt.*;
public class SplashScreen {





    JFrame frame;
    JLabel image=new JLabel("");
    JLabel text=new JLabel("TUTORIALS FIELD");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    SplashScreen()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setVisible(true);

    }
    public void addImage(){
        image.setSize(600,200);
        image.setIcon(new ImageIcon("cl.jpg"));
        frame.add(image);
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(170,220,600,40);
        text.setForeground(Color.BLUE);
        frame.add(text);
		JLabel lblNewLabel_1 = new JLabel("Developed By Zohaib Ahmed");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 529, 240, 72);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Muet Library Management System");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(80, 10, 566, 89);
		frame.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("21SW031");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(478, 529, 240, 72);
		frame.add(lblNewLabel_1_2);
    }
    public void addMessage()
    {
        message.setBounds(250,320,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("LOADING "+Integer.toString(i)+"%");
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
}
