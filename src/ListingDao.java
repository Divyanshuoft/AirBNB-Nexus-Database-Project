import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ListingDao {
    public static void createListing(Listing listing) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listinginsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, listing.getLid());
        preparableStatement.setInt(2, listing.getHid());
        preparableStatement.setString(3, listing.getType());
        preparableStatement.setDouble(4, listing.getPrice());
        preparableStatement.setDouble(5, listing.getLatitude());
        preparableStatement.setDouble(6, listing.getLongitude());
        preparableStatement.setString(7, listing.getAddress());
        preparableStatement.setString(8, listing.getPostal());
        preparableStatement.setString(9, listing.getCity());
        preparableStatement.setString(10, listing.getCountry());
        System.out.println("Listing created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<Listing> readListing() throws SQLException {
        ArrayList<Listing> listings = new ArrayList<Listing>();
        Connection conn = DB.connect();
        String query = Query.listingread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        statement.close();
        return listings;
    }

    public static void updateListing(int lid, int hid, String type, double price, double latitude, double longitude,
            String address, String postal, String city, String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, hid);
        preparableStatement.setString(2, type);
        preparableStatement.setDouble(3, price);
        preparableStatement.setDouble(4, latitude);
        preparableStatement.setDouble(5, longitude);
        preparableStatement.setString(6, address);
        preparableStatement.setString(7, postal);
        preparableStatement.setString(8, city);
        preparableStatement.setString(9, country);
        preparableStatement.setInt(10, lid);
        System.out.println("Listing updated successfully");
        preparableStatement.executeUpdate();
        preparableStatement.close();
    }

    public static void deleteListing(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("Listing deleted successfully");
        preparableStatement.executeUpdate();
        preparableStatement.close();
    }

}
