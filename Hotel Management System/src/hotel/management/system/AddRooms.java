package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {
    
    JLabel lblroomno, lblavailable, lblclean, lblbedtype, image, lblprice;
    JTextField tfroomno, tfprice;
    JComboBox availablecombo, cleancombo,bedtypecombo;
    JButton add, cancel;
    
    AddRooms(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);   
    
    JLabel heading = new JLabel("AddRooms");
    heading.setFont(new Font("Tahoma", Font.BOLD,18 ));
    heading.setBounds(150,20,200,20);
    add(heading);
    
    
    lblroomno = new JLabel("Room Number");
    lblroomno.setBounds(60,80,200,20);
    lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16 ));
    add(lblroomno);
    
    tfroomno = new JTextField();
    tfroomno.setBounds(220,80,150,30);
    add(tfroomno);
    
    lblavailable = new JLabel("Available");
    lblavailable .setBounds(60,140,200,30);
    lblavailable .setFont(new Font("Tahoma", Font.PLAIN,16 ));
    add(lblavailable );
    
    String availableOptions[]={"Available", "Occupied"};
    availablecombo = new JComboBox(availableOptions);
    availablecombo.setBounds(220,140,150,30);
    availablecombo.setBackground(Color.WHITE);
    add(availablecombo);
    
    
    lblclean = new JLabel("Cleaning status");
    lblclean .setBounds(60,200,200,30);
    lblclean .setFont(new Font("Tahoma", Font.PLAIN,16 ));
    add(lblclean);
    
    String cleanOptions[]={"Clean", "Dirty"};
    cleancombo = new JComboBox(cleanOptions);
    cleancombo.setBounds(220,200,150,30);
    cleancombo.setBackground(Color.WHITE);
    add(cleancombo);
    
    
    lblbedtype = new JLabel("Bed type");
    lblbedtype.setBounds(60, 260, 200, 30);
    lblbedtype .setFont(new Font("Tahoma", Font.PLAIN,16 ));
    add(lblbedtype);
    
    String bedtype[]= {"Single bed", "Double bed"};
    bedtypecombo = new JComboBox(bedtype);
    bedtypecombo.setBounds(220,260,150,30);
    bedtypecombo.setBackground(Color.WHITE);
    add(bedtypecombo);
    
    
    lblprice = new JLabel("Price");
    lblprice.setBounds(60,320,200,20);
    lblprice.setFont(new Font("Tahoma", Font.PLAIN,16 ));
    add(lblprice);
    
    tfprice = new JTextField();
    tfprice.setBounds(220,320,150,30);
    add(tfprice);
    
    add =  new JButton("Add room");
    add.setBackground(Color.black);
    add.setForeground(Color.white);
    add.setBounds(60,380,150,30);
    add.addActionListener(this);
    add(add);
    
    cancel = new JButton("Cancel");
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.setBounds(240,380,150,30);
    cancel.addActionListener(this);
    add(cancel);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nineth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(370, 30 ,600  , 300 );
        add(image);

    
//    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nineth.jpg"));
//    JLabel image = new JLabel(i1);
//    image.setBounds(400,30,500,300);
//    add(image);
//    
    
    
    setBounds(330 ,200, 940,470);
    setVisible(true);
    
}
    
    
    
    public static void main(String[] args){
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == add){
           String roomnumber = tfroomno.getText();
           String availibility =(String) availablecombo.getSelectedItem();
           String cleanstatus = (String)cleancombo.getSelectedItem();
           String bedtype = (String)bedtypecombo.getSelectedItem();
           String price = tfprice.getText(); 
           try {
               Conn conn = new Conn();
               String str = "insert into room values('"+roomnumber+"', '"+availibility+"', '"+cleanstatus+"','"+bedtype+"', '"+price+"')";
               conn.s.executeUpdate(str);
               
              JOptionPane.showMessageDialog(null, "New room added succesfully");
              setVisible(false);
               
           } catch (Exception e){
               e.printStackTrace();
           }
           
           
    }else{
           setVisible(false);
       }
}
}
