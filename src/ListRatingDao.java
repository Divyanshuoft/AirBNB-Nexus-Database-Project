import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

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

    // give the function code to view the body of the rating static String
    // listratingreadbody = "SELECT body FROM listing_rating WHERE listing = ?";
    public static void CombinedBodyForListing(int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listratingreadbody;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        // create teh dicnitonaity with word and count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        ArrayList<ListingRating> userRating2 = new ArrayList<ListingRating>();
        while (resultSet.next()) {
            ListingRating userRating = new ListingRating(resultSet.getInt("lrid"), resultSet.getInt("rater"),
                    resultSet.getInt("listing"), resultSet.getInt("rating"), resultSet.getString("body"),
                    resultSet.getString("date"));
            userRating2.add(userRating);
            String[] words = userRating.getBody().split(" ");
            for (String word : words) {
                word.replaceAll("[^a-zA-Z0-9]", "");
            }
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }
        // use iterator to safely remove elements with length less than 3
        int sdf = 0;
        Iterator<Map.Entry<String, Integer>> iterator = wordCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (sdf == 5)
                break;
            // find if the word is noun or not
            if (entry.getKey().length() < 3 || entry.getKey().charAt(0) >= 'a' && entry.getKey().charAt(0) <= 'z') {
                iterator.remove();
            } else {
                System.out.println(entry.getValue() + " people said " + entry.getKey() + " about this listing");
                sdf++;
            }
        }

        preparableStatement.execute();
        preparableStatement.close();
    }
}
