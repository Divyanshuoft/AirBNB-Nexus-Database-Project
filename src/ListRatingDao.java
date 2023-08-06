import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListRatingDao {
    public static void createListRating(int lrid, int uid, int lid, int rating, String body, String date)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listratinginsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lrid);
        preparableStatement.setInt(2, uid);
        preparableStatement.setInt(3, lid);
        preparableStatement.setInt(4, rating);
        preparableStatement.setString(5, body);
        preparableStatement.setString(6, date);
        System.out.println("ListRating created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<ListingRating> readListRatingforListing(int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listratingread;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        System.out.println("ListRating read successfully");
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<ListingRating> userRating2 = new ArrayList<ListingRating>();
        while (resultSet.next()) {
            System.out.println("UserRating read successfully");
            ListingRating userRating = new ListingRating(resultSet.getInt("lrid"), resultSet.getInt("rater"),
                    resultSet.getInt("listing"), resultSet.getInt("rating"), resultSet.getString("body"),
                    resultSet.getString("date"));
            userRating2.add(userRating);
        }
        preparableStatement.execute();
        preparableStatement.close();
        return userRating2;
    }
}
