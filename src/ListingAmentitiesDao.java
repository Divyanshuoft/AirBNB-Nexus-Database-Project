import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ListingAmentitiesDao {
    public static void createListingAmentities(ListingAmentities listingAmentities) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingamentitiesinsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, listingAmentities.getLid());
        preparableStatement.setInt(2, listingAmentities.getAid());
        System.out.println("ListingAmentities created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<ListingAmentities> readListingAmentities() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingamentitiesread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<ListingAmentities> listingAmentities = new ArrayList<ListingAmentities>();
        while (resultSet.next()) {
            ListingAmentities listingAmentity = new ListingAmentities(resultSet.getInt(1), resultSet.getInt(2));
            listingAmentities.add(listingAmentity);
        }
        System.out.println("ListingAmentities read successfully");
        statement.close();
        return listingAmentities;
    }

    public static void deleteListingAmentities(int id, int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingamentitiesdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        preparableStatement.setInt(2, id);
        System.out.println("ListingAmentities deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    // public static void updateListingAmentities(int id, int aid) throws
    // SQLException {
    // Connection conn = DB.connect();
    // String query = Query.listingamentitiesupdate;
    // PreparedStatement preparableStatement = conn.prepareStatement(query);
    // preparableStatement.setInt(1, aid);
    // preparableStatement.setInt(2, id);
    // System.out.println("ListingAmentities updated successfully");
    // preparableStatement.execute();
    // preparableStatement.close();
    // }

    public static ArrayList<ListingAmentities> readAmenitiesforListingforlid(int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingamentitiesreadforlid;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<ListingAmentities> listingAmentities = new ArrayList<ListingAmentities>();
        while (resultSet.next()) {
            ListingAmentities listingAmentity = new ListingAmentities(resultSet.getInt(1), resultSet.getInt(2));
            listingAmentities.add(listingAmentity);
        }
        System.out.println("Amenities for Listing read successfully");
        preparableStatement.close();
        return listingAmentities;
    }
}
