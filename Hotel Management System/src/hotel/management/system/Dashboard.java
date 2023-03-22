
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
        Dashboard(){
        setBounds(250 ,100, 971,620);
        setLayout(null);

        //IMAGE=FRONT
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,971,625);  //location x, location y, length, breadth 
        add(image);
         
        JLabel text = new JLabel("WELCOME TO THE PALM HOTEL GROUP");
        text.setBounds(55,60,1000,90); 
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 45)); 
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);    
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);

        
        JMenu admin = new JMenu("ADMIN");
        hotel.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);
        addEmployee.addActionListener(this);
        
        
        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        admin.add(addRooms);
        addRooms.addActionListener(this);
        
        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);

        
           setVisible(true);
        }
    
    
    
     public static void main(   String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){ 
            new AddEmployee();
    }   else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
    } else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
    } else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
    }
    }}