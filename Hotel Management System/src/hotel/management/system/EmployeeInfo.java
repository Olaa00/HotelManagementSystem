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
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    JLabel l1,l2,l3,l4,l5,l6, l7, l8;
   EmployeeInfo(){
    
    JLabel heading = new JLabel("EMPLOYEE INFO");
    heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
    heading.setBounds(420,0,200,20);
    add(heading);
           
    l1= new JLabel("NAME");
    l1.setBounds(60,40,200,30);
    add(l1);
    
    l2 = new JLabel("AGE");
    l2.setBounds(200,40,200,30);
    add(l2);
    
    l3 = new JLabel("GENDER");
    l3.setBounds(300,40,200,30);
    add(l3);
    
    l4 = new JLabel("JOB");
    l4.setBounds(430,40,200,30);
    add(l4);
    
    l5 = new JLabel("SALARY");
    l5.setBounds(550,40,200,30);
    add(l5);
  
    l6 = new JLabel("PHONE");
    l6.setBounds(690,40,200,30);
    add(l6);
    
     
    l7 = new JLabel("EMAIL");
    l7.setBounds(810,40,200,30);
    add(l7);
    
     
    l8 = new JLabel("AADHAR");
    l8.setBounds(930,40,200,30);
    add(l8);
    
    
    table = new JTable();
    table.setBounds(20,70,1000,400);
    add(table);
    
    cancel = new JButton("CANCEL");
    cancel.setBounds(420,500,200,50);
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    
   
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select  * from employee"); //SELECT FROM ALL ROOM DB
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e){
        e.printStackTrace();
    }
      
        
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(300,200,1050,600);
    setVisible(true);
   } 


    public static void main(String[] args){
    new EmployeeInfo();
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