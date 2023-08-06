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

    public static ArrayList<Listing> readListingforHost(int uid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadforhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, uid);
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<Listing> listings = new ArrayList<Listing>();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static double getPricing(int lid) throws SQLException {
        // give the pricing for the lid
        Connection conn = DB.connect();
        String query = Query.listingreadprice;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        double price = 0;
        while (resultSet.next()) {
            price = resultSet.getDouble(1);
        }
        preparableStatement.close();
        return price;
    }

    public static ArrayList<Listing> readListings(double latitude, double longitude, double distance)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadnearby;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadnearby = "SELECT * FROM listing WHERE (latitude - ?)
        // * (latitude - ?) + (longitude - ?) * (longitude - ?) <= ? * ? ORDER BY
        // (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) ASC";

        preparableStatement.setDouble(1, latitude);
        preparableStatement.setDouble(2, latitude);
        preparableStatement.setDouble(3, longitude);
        preparableStatement.setDouble(4, longitude);
        preparableStatement.setDouble(5, distance);
        preparableStatement.setDouble(6, distance);
        preparableStatement.setDouble(7, latitude);
        preparableStatement.setDouble(8, latitude);
        preparableStatement.setDouble(9, longitude);
        preparableStatement.setDouble(10, longitude);

        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> readListingsPriceWiseSortLowtoHigh() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadpricewise;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> postalcodesearch(String postal_code) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadpostal;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadpostal = "SELECT * FROM listing WHERE postal LIKE
        // CONCAT(SUBSTRING(?, 1, CHAR_LENGTH(?) - 1), '_', SUBSTRING(?, -1)) ORDER BY
        // ABS(postal - ?) LIMIT 5";
        preparableStatement.setString(1, postal_code);
        preparableStatement.setString(2, postal_code);
        preparableStatement.setString(3, postal_code);
        preparableStatement.setString(4, postal_code);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> addresssearch(String address) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadaddress;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadaddress = "SELECT * FROM listing WHERE address = ?";
        preparableStatement.setString(1, address);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> pricehigtolow() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingPriceHighttoLow;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    // static String listingreadcountry = "SELECT country, COUNT(*) FROM listing
    // GROUP BY country";
    public static ArrayList<Listing> countrysearch(String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountry;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadcountry = "SELECT * FROM listing WHERE country = ?";
        preparableStatement.setString(1, country);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    // static String listingreadcountrycity = "SELECT country, city, COUNT(*) FROM
    // listing GROUP BY country, city";
    public static ArrayList<Listing> countrycitysearch(String country, String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycity;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadcountrycity = "SELECT * FROM listing WHERE country =
        // ? AND city = ?";
        preparableStatement.setString(1, country);
        preparableStatement.setString(2, city);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    // static String listingreadcountrycitypostal = "SELECT country, city, postal,
    // COUNT(*) FROM listing GROUP BY country, city, postal";
    public static ArrayList<Listing> countrycitypostalsearch(String country, String city, String postal)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycitypostal;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadcountrycitypostal = "SELECT * FROM listing WHERE
        // country = ? AND city = ? AND postal = ?";
        preparableStatement.setString(1, country);
        preparableStatement.setString(2, city);
        preparableStatement.setString(3, postal);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
        return listings;
    }

    public static void ListingHostCountryRanking(String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountryhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadcountrycount = "SELECT host_id, COUNT(*) FROM
        // listing WHERE country = ? GROUP BY host_id ORDER BY COUNT(*) DESC";
        preparableStatement.setString(1, country);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Host ID: " + resultSet.getInt(1) + " Number of listings: " + resultSet.getInt(2));
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
    }

    public static void ListingHostCityRanking(String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcityhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadcitycount = "SELECT host_id, COUNT(*) FROM listing
        // WHERE city = ? GROUP BY host_id ORDER BY COUNT(*) DESC";
        preparableStatement.setString(1, city);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Host ID: " + resultSet.getInt(1) + " Number of listings: " + resultSet.getInt(2));
        }
        System.out.println("Listings read successfully");
        preparableStatement.close();
    }
}
