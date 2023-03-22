package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateCheck extends JFrame implements ActionListener{
    JLabel heading, customerID, room, name, checkintime,amountpaid,pendingamount;
    JTextField roomnr,tfname,tfcheckintime, tfamountpaid, tfpendingamount;
    Choice ccustomer;
    JButton check, update, back;
    
    UpdateCheck(){
        
         
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        heading =  new JLabel("UPADTE CHECK STATUS");
        heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
        heading.setBounds(350,-10,300,40);
        add(heading);
        
        customerID = new JLabel("Customer ID");
        customerID.setBounds(30,40,100,20);
        add(customerID);
        
        
        
        ccustomer=new Choice();
        ccustomer.setBounds(180,40,150,30);
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
        room.setBounds(30,80,100,20);
        add(room);
        
        roomnr = new JTextField();
        roomnr.setBounds(180,80,150,25);
        add(roomnr);
        
        
        name = new JLabel("Name");
        name.setBounds(30,120,100,20);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(180,120,150,25);
        add(tfname);
        
        
        checkintime = new JLabel("Checkin time");
        checkintime.setBounds(30,160,100,20);
        add(checkintime);
        
        tfcheckintime = new JTextField();
        tfcheckintime.setBounds(180,160,150,25);
        add(tfcheckintime);
        
        
        
        amountpaid = new JLabel("Amount paid");
        amountpaid.setBounds(30,200,100,20);
        add(amountpaid);
        
        tfamountpaid = new JTextField();
        tfamountpaid.setBounds(180,200,150,25);
        add(tfamountpaid);
        
        
        
        pendingamount = new JLabel("Pending amount");
        pendingamount.setBounds(30,240,100,20);
        add(pendingamount);
        
        tfpendingamount = new JTextField();
        tfpendingamount.setBounds(180,240,150,25);
        add(tfpendingamount);
        
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/check.jpg"));
        JLabel image =  new JLabel(i1);
        image.setBounds(400,40,500,300);
        add(image);
        
        
        
        
        setBounds(300,200,980,500);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== check){
            String number = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+number+"'";
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
            roomnr.setText(rs.getString("roomnumber"));
            tfname.setText(rs.getString("name"));
            tfcheckintime.setText(rs.getString("checkin_time"));
            tfamountpaid.setText(rs.getString("deposit"));  
            }
            
            ResultSet rs2 = c.s.executeQuery("select* from room where roomnumber = '"+roomnr.getText()+"'");
            while(rs2.next()){
            String price = rs2.getString("price");
            int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfamountpaid.getText()); //substract room price - paid deposit
            tfpendingamount.setText("" +amountPaid);
            
            }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()== update){
            String number = ccustomer.getSelectedItem();
            String room = roomnr.getText();
            String name = tfname.getText();
            String checkin = tfcheckintime.getText();
            String deposit = tfamountpaid.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set roomnumber ='"+room+"',name ='"+name+"',checkin_time ='"+checkin+"', deposit='"+deposit+"' where number = '"+number+"'");
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
    new UpdateCheck();
        }
}