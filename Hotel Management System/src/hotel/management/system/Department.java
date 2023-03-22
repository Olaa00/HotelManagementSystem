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
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    JLabel department, budget;
    
   Department(){
    
    JLabel heading = new JLabel("DEPARTMENT");
    heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
    heading.setBounds(250,0,200,20);
    add(heading);
           
    department = new JLabel("DEPARTMENT");
    department.setBounds(30,40,200,30);
    add(department);
    
    budget = new JLabel("BUDGET");
    budget.setBounds(330,40,200,30);
    add(budget);
    
    cancel = new JButton("CANCEL");
    cancel.setBounds(270,350,100,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
  
 
    table = new JTable();
    table.setBounds(20,70,600,600);
    add(table);
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select  * from department"); //SELECT FROM ALL ROOM DB
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
  
       
        
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(300,200,650,500);
    setVisible(true);
   } 


    public static void main(String[] args){
    new Department();
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