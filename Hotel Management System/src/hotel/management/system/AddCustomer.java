package hotel.management.system;
import java.awt.*;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class AddCustomer extends JFrame implements ActionListener{

    JLabel lblID, lblnr, lblname, lblgender, lblcountry, lblroomnr, lblcheckin,checkintime, lbldeposit;
    JComboBox cbID;
    JButton add, cancel;
    JTextField tfnr, tfname, tfroomnr, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    AddCustomer() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350, 200, 800, 550);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(text);

        lblID = new JLabel("ID");
        lblID.setBounds(35, 80, 100, 20);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblID);

        String options[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
        cbID = new JComboBox(options);
        cbID.setBackground(Color.WHITE);
        cbID.setBounds(200, 80, 150, 30);
        add(cbID);

        lblnr = new JLabel("NUMBER");
        lblnr.setBounds(35, 120, 100, 20);
        lblnr.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblnr);

        tfnr = new JTextField();
        tfnr.setBounds(200, 120, 150, 30);
        add(tfnr);

        lblname = new JLabel("NAME");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 30);
        add(tfname);

        lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgender.setBounds(35, 200, 100, 30);
        add(lblgender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 200, 100, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(300, 200, 100, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 30);
        add(tfcountry);

        lblroomnr = new JLabel("ROOM NUMBER");
        lblroomnr.setBounds(35, 280, 150, 30);
        lblroomnr.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblroomnr);
        
        croom = new Choice();
        
        
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available' ";  // select from only available rooms
            ResultSet rs=  conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        croom.setBounds( 200,280,150,30);
        add(croom);
        
        lblcheckin = new JLabel("CHECKIN TIME");
        lblcheckin.setBounds(35,320,150,30);
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcheckin);
        
        
        Date date = new Date();
        checkintime = new JLabel("" +date);
        checkintime.setBounds(200,310,250,50);
        checkintime.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(checkintime);
        
         
        lbldeposit = new JLabel("DEPOSIT");
        lbldeposit.setBounds(35,360,200,30);
        lbldeposit.setFont(new Font("Tahoma", Font.PLAIN,16 ));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,30);
        add(tfdeposit);
    
        add =  new JButton("Add customer");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(60,420,150,30);
        add.addActionListener(this);
        add(add);

      cancel = new JButton("Cancel");
      cancel.setBackground(Color.black);
      cancel.setForeground(Color.white);
      cancel.setBounds(240,420,150,30);
      cancel.addActionListener(this);
      add(cancel);
    
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
      Image i2 = i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel (i3);
      image.setBounds(320, 30 ,600  , 300 );
      add(image);

      setVisible(true);
    }

  
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae. getSource()==add ){
            String comboiD = (String)cbID.getSelectedItem();
            String number = tfnr.getText();
            String name = tfname.getText();
            String gender =null;
            if(rbmale.isSelected()){
            gender= "Male";
            }else if(rbfemale.isSelected()){
            gender= "Female";
            }
            String country = tfcountry.getText();
            String roomnr = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            if(comboiD.equals("") || number.equals("") ||name.equals("") ||gender.equals("")|| country.equals("")|| roomnr.equals("")|| time.equals("")|| deposit.equals("") ){
              JOptionPane.showMessageDialog(null,"Fields cannot be empty, please fill in the missing fields ");
             return;
            }
            try{
                Conn conn = new Conn();
                String query = "insert into customer values('"+comboiD +"', '"+number +"', '"+name +"', '"+gender +"','"+country +"','"+roomnr+"', '"+time +"','"+deposit+"')";
                String query2 = "update room set availability= 'Occupied' where roomnumber = '"+roomnr+"'";   //update room status -->available-->occupied
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New customer added succesfully");
                setVisible(false);
                new Reception();
           
            } catch(Exception e){
            e.printStackTrace();}
            
        } 
     
        else if (ae.getSource() == cancel){
            setVisible(false);
            new Reception();

                }
    }
  public static void main(String[] args) {
        new AddCustomer();
    }
}

