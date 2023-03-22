package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {
    JLabel lblname, lblage, lblgender,lblcarcompany, lblcarmodel,lblavailable,lbllocation;
    JTextField tfname, tfage,tfcarcompany,tfcarmodel,tflocation;
    JRadioButton rbmale, rbfemale;
    JComboBox cbavailable;
    JButton adddriver, cancel;
    
            
    AddDriver() {
     
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD,18 ));
        heading.setBounds(150,0,200,20);
        add(heading);
        
        //NAME
        lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);




        //AGE
        lblage= new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);


        //GENDER
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 130, 115, 30);
        add(Gender);


        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200,130,100,30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(300,130,100,30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);



        lblcarcompany = new JLabel("CAR COMPANY");
        lblcarcompany.setBounds(60,180,120,30);
        lblcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( lblcarcompany);
       
        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(200,180,150,30);
        add(tfcarcompany);
        
      
    
        lblcarmodel= new JLabel("CAR MODEL");
        lblcarmodel.setBounds(60,230,120,30);
        lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcarmodel);

        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(200,230,150,30);
        add(tfcarmodel);

        
        lblavailable= new JLabel("AVAILABILITY");
        lblavailable.setBounds(60,280,120,30);
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblavailable);
        
        String string[]= {"Available", "Notavailable"};
        cbavailable = new JComboBox(string);
        cbavailable.setBounds(200,280,150,30);
        add(cbavailable);

        
        lbllocation= new JLabel("LOCATION");
        lbllocation.setBounds(60,330,120,30);
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,330,150,30);
        add(tflocation);

     

        //BUTTON
        adddriver = new JButton("ADD DRIVER");
        adddriver.setBackground(Color.BLACK);
        adddriver.setForeground(Color.WHITE);
        adddriver.setBounds(200,400,150,40);
        add(adddriver);
        adddriver.addActionListener(this);
        
       //BUTTON BACK
        cancel= new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(40,400,150,40);
        add(cancel);
        cancel.addActionListener(this);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(400, 60 ,420  , 370 );
        add(image);




        //**********************************************
        setLocation(100,100);
        setBounds(350,200,850,540);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args){
    new AddDriver();
    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == adddriver){
           String name = tfname.getText();
           String age = tfage.getText();
           String company = tfcarcompany.getText();
           String model = tfcarmodel.getText();
           String availibility = (String)cbavailable.getSelectedItem();
           String location = tflocation.getText(); 
           
           String gender = null;
           if(rbmale.isSelected()){
               gender = "Male";
           }else if(rbfemale.isSelected()){
               gender = "Female";
           }
         if(name.equals("") || age.equals("") ||company.equals("") ||model.equals("")||availibility.equals("") || location.equals("")){
             JOptionPane.showMessageDialog(null,"Fields cannot be empty, please fill in the missing fields ");
             return;
             }
           try {
               Conn conn = new Conn();
               String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"', '"+availibility+"','"+location+"')";
               conn.s.executeUpdate(str);
               
              JOptionPane.showMessageDialog(null, "New driver added succesfully");
              setVisible(false);
               
           } catch (Exception e){
               e.printStackTrace();
           }
           
           
    }else{
           setVisible(false);
       }
}}

