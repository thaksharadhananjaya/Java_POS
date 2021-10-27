package Code;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Thakshara Dhananjaya
 */
public class DBconnect {

    public static Connection connect() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Connection");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/aanya_fashion", "root", "afs@sms");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can't access database !", "Shop Management System", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        return conn;

    }
}//afs@sms
