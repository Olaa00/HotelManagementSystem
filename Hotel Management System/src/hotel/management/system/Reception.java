package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
    JButton customerfom,rooms, department,allemployees, customerinfo,managerinfo, checkout, updatestatus, updateroomstatus, pickupservice, searchroom, logout;
    Reception(){
    
        
        setLayout(null);
        setBounds(350,200,800,570);
        getContentPane().setBackground(Color.WHITE);
//        JLabel heading = new JLabel("Reception");
//        heading.setFont(new Font("Tahoma", Font.BOLD,18 ));
//        heading.setBounds(150,200,200,20);
//        add(heading);



        customerfom = new JButton("New customer form");
        customerfom.setBounds(10,40,200,30);
        customerfom.setBackground(Color.BLACK);
        customerfom.setForeground(Color.WHITE);
        add(customerfom);
        customerfom.addActionListener(this);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,80,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        
        department = new JButton("Department");
        department.setBounds(10,120,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
//        JLabel heading = new JLabel("Reception");
//        heading.setFont(new Font("Tahoma", Font.BOLD,18 ));
//        heading.setBounds(150,200,200,20);
//        add(heading);



        customerfom = new JButton("New customer form");
        customerfom.setBounds(10,40,200,30);
        customerfom.setBackground(Color.BLACK);
        customerfom.setForeground(Color.WHITE);
        add(customerfom);
        customerfom.addActionListener(this);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,80,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        
        
        department = new JButton("Department");
        department.setBounds(10,120,200,30);
        department.setForeground(Color.WHITE);
        add(department);
        
        
        allemployees = new JButton("All employees");
        allemployees.setBounds(10,160,200,30);
        allemployees.setBackground(Color.BLACK);
        allemployees.setForeground(Color.WHITE);
        allemployees.addActionListener(this);
        add(allemployees);
        
        
        customerinfo = new JButton("Customer info");
        customerinfo.setBounds(10,200,200,30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
        managerinfo = new JButton("Manager info");
        managerinfo.setBounds(10,240,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,280,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        
        updatestatus = new JButton("Update check status");
        updatestatus.setBounds(10,320,200,30);
        updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.addActionListener(this);
        add(updatestatus);
        
        updateroomstatus = new JButton("Update room status");
        updateroomstatus.setBounds(10,360,200,30);
        updateroomstatus.setBackground(Color.BLACK);
        updateroomstatus.setForeground(Color.WHITE);
        updateroomstatus.addActionListener(this);
        add(updateroomstatus);
        
        pickupservice = new JButton("Pickup service");
        pickupservice.setBounds(10,400,200,30);
        pickupservice.setBackground(Color.BLACK);
        pickupservice.setForeground(Color.WHITE);
        pickupservice.addActionListener(this);
        add(pickupservice);
        
        searchroom = new JButton("Search room");
        searchroom.setBounds(10,440,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(10,480,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,100,500,310);
        add(image);
        
        
        JLabel text = new JLabel("HOTEL RECEPTION");
        text.setBounds(300,10,500,90);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.PLAIN, 45)); 
        add(text);
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    if( ae.getActionCommand().equals("New customer form")){
        setVisible(false);
        new AddCustomer();
    } else if (ae.getActionCommand().equals("Rooms")){
        setVisible(false);
        new Rooms();
    }else if (ae.getActionCommand().equals("Department")){
    setVisible(false);
    new Department();
    }else if (ae.getActionCommand().equals("All employees")){
    setVisible(false);
        new EmployeeInfo();
    }else if (ae.getActionCommand().equals("Manager info")){
    setVisible(false);
        new ManagerInfo();
    }else if (ae.getActionCommand().equals("Customer info")){
    setVisible(false);
        new CustomerInfo();
    } else if(ae.getActionCommand().equals("Search room")){
    setVisible(false);
        new SearchRoom();
    } else if(ae.getActionCommand().equals("Update check status")){
    setVisible(false);
        new UpdateCheck();
    } else if(ae.getActionCommand().equals("Update room status")){
    setVisible (false);
    new UpdateRoom();
    }
    else if(ae.getActionCommand().equals("Pickup service")){
    setVisible (false);
    new Pickup();
    }
     else if (ae.getActionCommand().equals("Checkout")){
    setVisible (false);
    new Checkout();
    } else if(ae.getSource() == logout){
    setVisible(false);
    System.exit(0);
    }
    }
   public static void main(String[] args){
        new Reception();
        }
}

               
