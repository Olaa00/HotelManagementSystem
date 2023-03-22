package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateRoom extends JFrame implements ActionListener{
    JLabel heading, customerID, room, available, cleanstatus,amountpaid,pendingamount;
    JTextField roomnr,tfavailable,tfcleanstatus;
    Choice ccustomer;
    JButton check, update, back;
    
    UpdateRoom(){
        
         
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        heading =  new JLabel("UPADTE ROOM STATUS");
        heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
        heading.setBounds(350,-10,300,40);
        add(heading);
        
        customerID = new JLabel("Customer ID");
        customerID.setBounds(30,60,100,20);
        add(customerID);
        
        
        
        ccustomer=new Choice();
        ccustomer.setBounds(180,60,150,30);
        add(ccustomer);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer");
            
            while(rs.next()){
            ccustomer.add(rs.getString("number"));
            }
            
        }catch (Exception e){
        e.printStackTrace();
        }
        
        room = new JLabel("Room number");
        room.setBounds(30,120,100,20);
        add(room);
        
        roomnr = new JTextField();
        roomnr.setBounds(180,120,150,25);
        add(roomnr);
        
        
        available = new JLabel("Availability");
        available.setBounds(30,180,100,20);
        add(available);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(180,180,150,25);
        add(tfavailable);
        
        
        cleanstatus = new JLabel("Cleaning status");
        cleanstatus.setBounds(30,240,100,20);
        add(cleanstatus);
        
        tfcleanstatus = new JTextField();
        tfcleanstatus.setBounds(180,240,150,25);
        add(tfcleanstatus);
        
        
        

        
        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rooomstatus.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
         image.setBounds(400,40,500,300);
         add(image);
        
        
        setBounds(300,200,980,400);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";  //select id customer 
            try{
                
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
            roomnr.setText(rs.getString("roomnumber"));  //sign roomnr
            
            }
            ResultSet rs2 = c.s.executeQuery("select* from room where roomnumber = '"+roomnr.getText()+"'");
            while(rs2.next()){
                tfavailable.setText(rs2.getString("availibility"));  //availibility status from DB/
                tfcleanstatus.setText(rs2.getString("cleaning_status")); //status from DB
            }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()== update){
            String number = ccustomer.getSelectedItem();
            String room = roomnr.getText();
            String available = tfavailable.getText();
            String cleanstatus = tfcleanstatus.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availibility ='"+available+"',cleaning_status ='"+cleanstatus+"' where roomnumber = '"+room+"'");
                JOptionPane.showMessageDialog(null, "Data updated succesfully");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e){
            e.printStackTrace();
            }
        
        } else {
              setVisible(false);
              new Reception();
        }
    }
    

    
    public static void main (String [] args){
    new UpdateRoom();
        }
}