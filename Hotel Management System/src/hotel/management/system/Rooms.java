package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;
public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    JLabel roomnr,availability, cleanstatus, bedtype, price;
   Rooms(){
    
    JLabel heading = new JLabel("ROOM STATUS");
    heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
    heading.setBounds(150,0,200,20);
    add(heading);
           
    roomnr = new JLabel("ROOM NUMBER");
    roomnr.setBounds(20,40,200,30);
    add(roomnr);
    
    availability = new JLabel("AVAILIBILITY");
    availability.setBounds(130,40,200,30);
    add(availability);
    
    cleanstatus = new JLabel("STATUS");
    cleanstatus.setBounds(240,40,200,30);
    add(cleanstatus);
    
    bedtype = new JLabel("BED TYPE");
    bedtype.setBounds(340,40,200,30);
    add(bedtype);
    
    price = new JLabel("PRICE");
    price.setBounds(450,40,200,30);
    add(price);
    
    table = new JTable();
    table.setBounds(20,70,500,400);
    add(table);
    
  
    
    
   
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select  * from room"); //SELECT FROM ALL ROOM DB
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e){
        e.printStackTrace();
    }
      
    cancel = new JButton("CANCEL");
    cancel.setBounds(200,500,120,30);
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(550,0,470,500);
    add(image);
        
        
        
        
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(300,200,1050,600);
    setVisible(true);
   } 


    public static void main(String[] args){
    new Rooms();
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
    setVisible (false);
    new Reception();
   if (ae.getSource() == cancel){
            setVisible(false);
            new Reception();

                }
    }
    }