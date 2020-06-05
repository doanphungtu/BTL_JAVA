
package btl_java.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class connection {
    public Connection conn = null;
    public connection()
    {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                String user = "root";
                String pass = "";
                String bdurl = "jdbc:mysql://localhost:3306/quanlitotnghiep";

                conn = DriverManager.getConnection(bdurl, user, pass);
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}
