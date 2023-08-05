import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CreateDB {
    public static void main(String[] args) {
        Student st = new Student();
        // st.createDatabase();
        st.createTable();
        // CURD
        // st.createData();
        // st.readData();
        // st.updateData();
        // st.DeleteData();
    }
}
