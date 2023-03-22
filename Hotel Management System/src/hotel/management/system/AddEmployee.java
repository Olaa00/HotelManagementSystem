package hotel.management.system;//package hotel.management.system;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;


public class AddEmployee extends JFrame implements ActionListener{


    JLabel lblname,lblage,lbljob,lblsalary, lblphone, lblemail,lblaadhar;
    JTextField tfname, tfage,tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit, cancel;
    JComboBox cbjob;

    AddEmployee(){



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

        //one option
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);



        //JOB

        lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String string[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        cbjob = new JComboBox(string);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        //SALARY
        lblsalary= new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        //PHONE
        lblphone= new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        //EMAIL
        lblemail= new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        //CHAR
        lblaadhar= new JLabel("ADDHAR");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);


        //BUTTON SUBMIT
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(40,430,150,40);
        add(submit);
        submit.addActionListener(this);
       //BUTTON CANCEL
        cancel= new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,430,150,40);
        add(cancel);
        cancel.addActionListener(this);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(400, 60 ,450  , 370 );
        add(image);




        //**********************************************
        setLocation(100,100);
        setBounds(350,200,850,540);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }





    public static void main( String[] args){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String name = tfname.getText();
       String age = tfage.getText();
       String salary = tfsalary.getText();
       String phone = tfphone.getText();
       String email = tfemail.getText();
       String aadhar = tfaadhar.getText();
       String job = (String) cbjob.getSelectedItem();

       if (ae.getSource() == cancel){
            setVisible(false);
            return;
       }
            
        if(name.equals("") || age.equals("") ||phone.equals("") ||email.equals("")||aadhar.equals("")){
             JOptionPane.showMessageDialog(null,"Fields cannot be empty, please fill in the missing fields ");
             return;
             }
               else if(!email.contains("@") && !email.contains(".com")){
                JOptionPane.showMessageDialog(null,"Email can not be empty and must contain @ and .com ");
            new AddEmployee();
           return;
      
      }   

             
        
        
       String gender = null;
       if(rbmale.isSelected()){
           gender = "Male";
       }else if(rbfemale.isSelected()){
           gender = "Female";
       }

     
       try{
           Conn conn = new Conn();
           String query = "insert into employee values('"+name+"','"+age+"','"+gender+"', '"+job+"','"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            conn.s.executeUpdate(query);


           JOptionPane.showMessageDialog(null, "Employee added succesfully");
           setVisible(false);
           
       }catch (Exception e){
           e.printStackTrace();
       }
       finally {
          
            }
    } 
}

