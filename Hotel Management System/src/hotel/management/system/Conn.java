package hotel.management.system;
import java.sql.*;
public class Conn {

    public Connection  c;
    //      public Connection  conn;
    public Statement s;

    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "root");
//        conn = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "1111");
            System.out.println("Connected");
            s = c.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
