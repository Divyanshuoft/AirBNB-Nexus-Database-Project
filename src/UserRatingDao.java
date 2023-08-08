import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class UserRatingDao {
    public static void createUserRating(int urid, int rater, int ratee, int rating, String body, String date)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userratinginsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, urid);
        preparableStatement.setInt(2, rater);
        preparableStatement.setInt(3, ratee);
        preparableStatement.setInt(4, rating);
        preparableStatement.setString(5, body);
        preparableStatement.setString(6, date);
        System.out.println("UserRating created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<UserRating> readUserRating() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userratingread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<UserRating> userRating2 = new ArrayList<UserRating>();
        while (resultSet.next()) {
            UserRating userRating = new UserRating(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
            userRating2.add(userRating);
        }
        System.out.println("UserRating read successfully");
        statement.close();
        return userRating2;
    }

    public static void deleteUserRating(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userratingdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("UserRating deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void updateUserRating(int id, String body, int rating, String date) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userratingupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(4, id);
        preparableStatement.setString(2, body);
        preparableStatement.setInt(1, rating);
        preparableStatement.setString(3, date);
        System.out.println("UserRating updated successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void readUserRatingforUser(int uid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.userratingreadforuser;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, uid);
        preparableStatement.setInt(2, uid);
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<UserRating> userRating2 = new ArrayList<UserRating>();
        while (resultSet.next()) {
            System.out.println("UserRating read successfully");
            System.out.print("UserRating ID: " + resultSet.getInt(1));
            System.out.print(", Rater ID: " + resultSet.getInt(2));
            System.out.print(", Ratee ID: " + resultSet.getInt(3));
            System.out.print(", Rating: " + resultSet.getInt(4));
            System.out.println(", Date: " + resultSet.getString(6));
            System.out.println("Body: " + resultSet.getString(5));
        }
    }

}
