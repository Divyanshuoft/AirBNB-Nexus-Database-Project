import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.plaf.nimbus.State;
import com.mysql.cj.xdevapi.PreparableStatement;

public class EmployeeDao {

    public static void createEmployee(Employee employee) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.usersinsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, employee.getUid());
        preparableStatement.setString(2, employee.getName());
        preparableStatement.setString(3, employee.getAddress());
        preparableStatement.setString(4, employee.getDob());
        preparableStatement.setString(5, employee.getOccupation());
        preparableStatement.setString(6, employee.getSin());
        preparableStatement.setString(7, employee.getPayment_info());
        System.out.println("User created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    // loginEmployee
    public static boolean loginEmployee(int uid, String username) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userslogin;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, uid);
        preparableStatement.setString(2, username);
        ResultSet resultSet = preparableStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("User logged in successfully");
            return true;
        } else {
            System.out.println("User not found");
            return false;
        }
    }

    public static ArrayList<Employee> readEmployees() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Connection conn = DB.connect();
        String query = Query.usersread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            employees.add(employee);
        }
        System.out.println("Users read successfully");
        statement.close();
        return employees;
    }

    public static void updateEmployee(int id, String name, String address, String dob, String occupation, String sin,
            String payment_info) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.usersupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, name);
        preparableStatement.setString(2, address);
        preparableStatement.setString(3, dob);
        preparableStatement.setString(4, occupation);
        preparableStatement.setString(5, sin);
        preparableStatement.setString(6, payment_info);
        preparableStatement.setInt(7, id);
        System.out.println("User updated successfully");
        preparableStatement.executeUpdate();
        preparableStatement.close();
    }

    public static void deleteEmployee(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.usersdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("User deleted successfully");
        preparableStatement.executeUpdate();
        preparableStatement.close();
    }
}
