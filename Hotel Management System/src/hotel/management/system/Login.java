package hotel.management.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JLabel user, pass;
    JButton login,cancel;
    
    Login(){
//        setLocation(100, 100);
//        setSize(600, 300);

        setBounds(500,200,600,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //USER
        user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150,20,150,30); 
        add(username);
   
        
        //PASS
                
        pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        password = new JPasswordField();  
        password.setBounds(150,70,150,30); //x, y, length, breadth 
        add(password);
        
        //LOGIN BUTTON
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this); //button--> next page--> Login
        
        //CANCEL BUTTON
        cancel = new JButton("Cancel");
        cancel.setBounds(200,150,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this); //button--> next page--> Login 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
//        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(400,-10,138,200);  //location x, location y, length, breadth 
        
        add(image);
        
        setVisible(true);
        
    }
    


public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            try { 
                Conn c = new Conn();
           
                String query ="select * from login where username = '" + user + "' and password = '" + pass + "'";
               
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()){
                    setVisible(false);
                    new Dashboard();
                    
                    
                } else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
                }
                
            } catch (Exception e){
                e.printStackTrace();
               
            }
            finally {
          
            }

        } else if (ae.getSource()== cancel){
            setVisible(false);

        }
    }
}
