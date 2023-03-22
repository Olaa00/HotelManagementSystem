 package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
 
 
public class HotelManagementSystem extends JFrame implements ActionListener{
HotelManagementSystem()
{
//    setSize(1080, 675);
//    setLocation(100, 100);
    setBounds(250 ,100, 1080,675);
    setLayout(null);
    
    //IMAGE=FRONT
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0,0,1080,675);  //location x, location y, length, breadth 
    add(image);
    
    
    //IMAGE+TEXT
    JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(150,480,1000,90); 
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif", Font.PLAIN, 50)); 
    image.add(text);
    
    //BUTTONS
    JButton next = new JButton("Next");
    next.setBounds(965 ,0,100,50);
    next.setBackground(Color.white);
    next.setFont(new Font("serif", Font.PLAIN, 20));
    image.add(next);
    next.addActionListener(this); //button--> next page--> Login
  
    setVisible(true);
    

    //        flashing
   while(true){
           text.setVisible(false);
          try{
                Thread.sleep(500);

        }
          catch (Exception e){
                e.printStackTrace();

           }
            text.setVisible(true);
            try{
                 Thread.sleep(1000);
            }catch (Exception e){
               e.printStackTrace();
        }
   }        
        
   }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }

    //button --> login view
    @Override
    public void actionPerformed(ActionEvent ac) {
        setVisible(false);
        new Login();
    }
    
}
