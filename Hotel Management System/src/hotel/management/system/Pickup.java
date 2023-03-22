package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton cancel, submit;
    JLabel cartype, name, age, gender, company, model,available, location;
    Choice typeofcar;
   Pickup(){
    
    JLabel heading = new JLabel("PICKUP SERVICE");
    heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
    heading.setBounds(450,0,200,20);
    add(heading);
           
    name = new JLabel("NAME");
    name.setBounds(60,170,200,30);
    add(name);
    
    age = new JLabel("AGE");
    age.setBounds(200,170,200,30);
    add(age);
    
    gender = new JLabel("GENDER");
    gender.setBounds(350,170,200,30);
    add(gender);
    
    company = new JLabel("COMPANY");
    company.setBounds(480,170,200,30);
    add(company);
    
  
    model = new JLabel("MODEL");
    model.setBounds(650,170,200,30);
    add(model);
    
    available = new JLabel("AVAILABLE");
    available.setBounds(780,170,200,30);
    add(available);
    
    location = new JLabel("LOCATION");
    location.setBounds(900,170,200,30);
    add(location);
    
   //bed type choice for searching 
    cartype = new JLabel("CAR TYPE");
    cartype.setBounds(50,100,100,30);
    cartype.setFont(new Font("Tahoma", Font.PLAIN,18 ));
    add(cartype);
 
    typeofcar = new Choice();
    typeofcar.setBounds(150,105,200,25);
    add(typeofcar);
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select *from driver");
        while (rs.next()){
        typeofcar.add(rs.getString("model"));
                
        }
    }catch (Exception e){
        e.printStackTrace();
    }
   
 
    
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
        ResultSet rs = c.s.executeQuery("select  * from driver"); //SELECT FROM ALL DRIVER DB
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
    new Pickup();
        }
    @Override
    public void actionPerformed(ActionEvent ae) {
if(ae.getSource() ==submit){
    try{
        String query = "select *from driver where model ='"+typeofcar.getSelectedItem()+"'";

        
            Conn conn = new Conn();
            ResultSet rs;
            rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch (Exception e){
                e.printStackTrace();
    }
}else if (ae.getSource() == cancel){
            
            setVisible(false);
            new Reception();
            }
}}


    
 