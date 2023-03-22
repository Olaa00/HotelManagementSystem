package hotel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JButton checkout, cancel;
    JLabel lblid, lblroomnumber, lblcheckintime, lblcheckouttime;
    Checkout(){
        
        JLabel heading = new JLabel("CHECKOUT");
        heading.setBounds(300,00,200,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20 ));
        add(heading);
        
        
        lblid =  new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin time");
        lblcheckin.setBounds(30,170,100,30);
        add(lblcheckin);
        
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,170,150,30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout time");
        lblcheckout.setBounds(30,220,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150,220,150,30);
        add(lblcheckouttime);
        
        
     
        
       //BUTTON
        
       checkout =  new JButton("CHECKOUT");
       checkout.setBackground(Color.black);
       checkout.setForeground(Color.white);
       checkout.setBounds(100,300,150,30);
       checkout.addActionListener(this);
       add(checkout);
 
      cancel = new JButton("CANCEL");
      cancel.setBackground(Color.black);
      cancel.setForeground(Color.white);
      cancel.setBounds(300,300,150,30);
      cancel.addActionListener(this);
      add(cancel);
      
            
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer");
            
            while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("roomnumber"));
            lblcheckintime.setText("checkin_time");
            }
            
        }catch (Exception e){
        e.printStackTrace();
        }
      
      ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/OUT.JPG.CRDOWNLOAD"));
      Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel (i3);
      image.setBounds(320, 30 ,600  , 300 );
      add(image);

        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    public static void main(String [] args){
            new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availibility = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
            
            try{
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Checkout done");
            setVisible(false);
            new Reception(); 
            } catch(Exception e){
            e.printStackTrace();
            }
        } else{
        setVisible(false);
        new Reception();
        }
    }
}