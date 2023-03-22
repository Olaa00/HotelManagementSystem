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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton cancel, submit;
    JLabel roomnr,availability, cleanstatus, bedtype, price, bed;
    JCheckBox available;
    JComboBox cbed;
   SearchRoom(){
    
    JLabel heading = new JLabel("SEARCH ROOM");
    heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
    heading.setBounds(450,0,200,20);
    add(heading);
           
    roomnr = new JLabel("ROOM NUMBER");
    roomnr.setBounds(50,170,200,30);
    add(roomnr);
    
    availability = new JLabel("AVAILIBILITY");
    availability.setBounds(300,170,200,30);
    add(availability);
    
    cleanstatus = new JLabel("STATUS");
    cleanstatus.setBounds(500,170,200,30);
    add(cleanstatus);
    
    bedtype = new JLabel("BED TYPE");
    bedtype.setBounds(680,170,200,30);
    add(bedtype);
    
 
    
    price = new JLabel("PRICE");
    price.setBounds(900,170,200,30);
    add(price);
    
   //bed type choice for searching 
    bed = new JLabel("BED TYPE");
    bed.setBounds(50,100,100,30);
    add(bed);
    cbed= new JComboBox(new String[]{"Single bed", "Double bed"});
    cbed.setBounds(150,100,150,30);
    cbed.setBackground(Color.WHITE);
    add(cbed);
   
    //options available || occupied
    available =  new JCheckBox("Only display available");
    available.setBounds(350,100,150,30);
    add(available);
    
    
    cancel = new JButton("CANCEL");
    cancel.setBounds(600,500,120,30);
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    submit = new JButton("SUBMIT");
    submit.setBounds(400,500,120,30);
    submit.setBackground(Color.black);
    submit.setForeground(Color.white);
    submit.addActionListener(this);
    add(submit);
     
     
    table = new JTable();
    table.setBounds(20,200,1000,400);
    add(table);
    
   
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select  * from room"); //SELECT FROM ALL ROOM DB
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e){
        e.printStackTrace();
    } 
        
      
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(300,200,1050,600);
    setVisible(true);
   } 

   
public static void main(String []args){
    new SearchRoom();
        }
    @Override
    public void actionPerformed(ActionEvent ae) {
if(ae.getSource() ==submit){
    try{
        String query1 = "select *from room where bed_type ='"+cbed.getSelectedItem()+"'";
        String query2 = "select *from room where availibility = 'Available' AND bed_type = '"+cbed.getSelectedItem()+"'";
        
            Conn conn = new Conn();
            ResultSet rs;
        if (available.isSelected()){
            rs = conn.s.executeQuery(query2);
        }else{
            rs = conn.s.executeQuery(query1);
        }
        table.setModel (DbUtils.resultSetToTableModel(rs));
    }catch (Exception e){
                e.printStackTrace();
    }
}else if (ae.getSource() == cancel){
            setVisible(false);
            new SearchRoom();
            new Reception();
            }
}}


    
 