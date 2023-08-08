import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxExpr.Array;

import java.sql.Statement;
import java.time.LocalDate;

public class ListingDao {
    String[] bigCities = {
            "Tokyo", "Delhi", "Shanghai", "São Paulo", "Mumbai",
            "Beijing", "Cairo", "Dhaka", "Osaka", "Karachi",
            "Chongqing", "Istanbul", "Lahore", "Shenzhen", "Bangalore",
            "Moscow", "Tianjin", "Jakarta", "Kinshasa", "Seoul",
            "Mexico City", "Lima", "New York City", "Los Angeles", "Cairo",
            "London", "Bangkok", "Lagos", "Rio de Janeiro", "Paris",
            "Berlin", "Madrid", "Toronto", "Chicago", "Tokyo",
            "Singapore", "Sydney", "Hong Kong", "Miami", "Dubai",
            "Mumbai", "Delhi", "Moscow", "Cairo", "Shanghai",
            "Istanbul", "Kolkata", "Buenos Aires", "Manila", "Kuala Lumpur",
            "Cape Town", "Johannesburg", "Riyadh", "Rome", "Athens",
            "Amsterdam", "Vienna", "Stockholm", "Helsinki", "Dublin",
            "Oslo", "Zurich", "Copenhagen", "Warsaw", "Prague"
    };

    String[] mediumCities = {
            "Barcelona", "Munich", "Vancouver", "Milan", "Hamburg",
            "Montreal", "San Francisco", "Dallas", "Melbourne", "Amman",
            "Kiev", "Lisbon", "Brussels", "Marseille", "Budapest",
            "Vienna", "Warsaw", "Prague", "Oslo", "Helsinki",
            "Stockholm", "Copenhagen", "Zurich", "Dublin", "Riyadh",
            "Jeddah", "Kuwait City", "Doha", "Abu Dhabi", "Muscat",
            "Manama", "Tunis", "Algiers", "Casablanca", "Nairobi",
            "Nairobi", "Bogota", "Lima", "Santiago", "Brisbane",
            "Auckland", "Wellington", "Hobart", "Kolkata", "Chennai",
            "Bangalore", "Hyderabad", "Ahmedabad", "Pune", "Surat"
    };

    String[] smallCities = {
            // Indian Cities
            "Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata",
            "Hyderabad", "Pune", "Ahmedabad", "Jaipur", "Surat",
            "Kanpur", "Lucknow", "Nagpur", "Indore", "Thane",
            "Bhopal", "Visakhapatnam", "Pimpri-Chinchwad", "Patna", "Vadodara",
            "Ghaziabad", "Ludhiana", "Agra", "Nashik", "Faridabad",
            "Meerut", "Rajkot", "Kalyan-Dombivli", "Vasai-Virar", "Varanasi",
            "Srinagar", "Aurangabad", "Dhanbad", "Amritsar", "Navi Mumbai",
            "Allahabad", "Howrah", "Ranchi", "Coimbatore", "Jabalpur",
            "Gwalior", "Vijayawada", "Jodhpur", "Madurai", "Raipur",

            // Canadian Cities
            "Toronto", "Montreal", "Vancouver", "Calgary", "Edmonton",
            "Ottawa", "Quebec City", "Winnipeg", "Hamilton", "Kitchener",
            "London", "Victoria", "Halifax", "Oshawa", "Windsor",
            "Regina", "Saskatoon", "Kelowna", "St. John's", "Thunder Bay",
            "Moncton", "Fredericton", "Charlottetown", "Whitehorse", "Yellowknife",
            "Iqaluit", "Surrey", "Burnaby", "Vaughan", "Richmond",
            "Mississauga", "Brampton", "Markham", "Saskatoon", "Oakville",
            "Burlington", "Abbotsford", "Barrie", "Sherbrooke", "Trois-Rivières",
            "Gatineau", "Halifax", "Laval", "Longueuil", "Saguenay",
            "Levis", "Terrebonne", "Coquitlam", "Red Deer", "Lethbridge",
            "Nanaimo", "Kamloops", "Saint John", "Guelph", "Prince George",
            "Medicine Hat", "Peterborough", "Drummondville", "New Westminster", "Chilliwack",
            "Saint-Jérôme", "Sault Ste. Marie", "North Bay", "Shawinigan", "Cornwall"
    };

    public static double givePriceCity(String city) throws SQLException {

        Connection conn = DB.connect();
        String query = Query.getAvgPriceforcity;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, city);
        ResultSet resultSet = preparableStatement.executeQuery();
        double avgPrice = 0;
        while (resultSet.next()) {
            avgPrice = resultSet.getDouble("AVG(price)");
        }
        return avgPrice;
    }

    public static double giveAvgListingPrice() throws SQLException {

        Connection conn = DB.connect();
        String query = Query.getAvgPriceforcity2;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        double avgPrice = 0;
        while (resultSet.next()) {
            avgPrice = resultSet.getDouble("AVG(price)");
        }
        return avgPrice;
    }

    public static double givePriceCityTypePostal(String city, String type, String postal) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.getAvgPriceforCityTypePostal;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, city);
        preparableStatement.setString(2, type);
        preparableStatement.setString(3, postal);
        ResultSet resultSet = preparableStatement.executeQuery();
        double avgPrice = 0;
        while (resultSet.next()) {
            avgPrice = resultSet.getDouble("AVG(price)");
        }
        return avgPrice;
    }

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
        preparableStatement.execute();
        preparableStatement.close();
    }

    // public static void JoinBookingCalender() throws SQLException {
    // Connection conn = DB.connect();
    // String query = Query.joinBookingCalenderListing;
    // Statement statement = conn.createStatement();
    // ResultSet resultSet = statement.executeQuery(query);
    // // print every elemenr of resultset
    // for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
    // System.out.print(resultSet.getMetaData().getColumnName(i) + " ");
    // }
    // System.out.println();
    // while (resultSet.next()) {
    // for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
    // System.out.print(resultSet.getString(i) + " ");
    // }
    // System.out.println();
    // }
    // System.out.println("Booking and Calender joined successfully");
    // statement.close();

    public static double getPrice(int lid) throws SQLException {
        Connection conn = DB.connect();
        PreparedStatement preparedStatement = conn.prepareStatement(Query.getPrice);
        preparedStatement.setInt(1, lid);
        ResultSet resultSet = preparedStatement.executeQuery();
        double price = 0;
        while (resultSet.next()) {
            price = resultSet.getDouble("price");
        }
        return price;
    }

    public static double getPriceforaid(int aid) throws SQLException {
        Connection conn = DB.connect();
        PreparedStatement preparedStatement = conn.prepareStatement(Query.listingamentitiesreadforaid);
        preparedStatement.setInt(1, aid);
        ResultSet resultSet = preparedStatement.executeQuery();
        double price = 0;
        while (resultSet.next()) {
            price = resultSet.getDouble("price");
        }
        return price;
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
        statement.close();
        return listings;
    }

    public static void updateListing(int lid, int hid, double price) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, hid);
        preparableStatement.setDouble(2, price);
        preparableStatement.setInt(3, lid);
        preparableStatement.executeUpdate();
        preparableStatement.close();
    }

    public static ArrayList<Listing> readListingPostal(String postal) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycitypostal5;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, postal.substring(0, 3) + "%");
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<Listing> listings = new ArrayList<Listing>();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7),
                    resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            listings.add(listing);
        }
        preparableStatement.close();
        return listings;
    }

    public static void deleteListing(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
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
        preparableStatement.close();
        return listings;
    }

    public static double getPricing(int lid) throws SQLException {
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
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> postalcodesearch(String postal_code) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadpostal;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
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
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> addresssearch(String address) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadaddress;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, address);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
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
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> countrysearch(String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountry;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, country);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> countrycitysearch(String country, String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycity;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);

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
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> countrycitypostalsearch(String country, String city, String postal)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycitypostal;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
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
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> countrycitypostalsearch2(String country, String city, String postal, String start,
            String end, double min, double max, ArrayList<Integer> amm, int h)
            throws SQLException {
        ArrayList<Calender> listings1 = new ArrayList<Calender>();
        Connection conn = DB.connect();
        String query = Query.listingreadcountrycitypostal2;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ArrayList<ListingAmentities> listings2 = new ArrayList<ListingAmentities>();
        preparableStatement.setString(1, country);
        preparableStatement.setString(2, city);
        String x = postal.substring(0, 3) + "%";
        preparableStatement.setString(3, x);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            int listing_id = listing.getLid();
            listings2 = ListingAmentitiesDao.readAmenitiesforListingforlid(listing_id);
            ArrayList<Integer> listingk = new ArrayList<Integer>();
            for (ListingAmentities listingAmentities : listings2) {
                listingk.add(listingAmentities.getAid());
            }

            listings1 = CalenderDao.checkIfBookingAvailabCalender(start, end, listing_id);
            double price = listing.getPrice();
            int host_id = listing.getHid();
            ArrayList<Listing> pp = ListingNotinCalender();
            for (Calender calender : listings1) {
                int lid5 = calender.getLid();
                if (lid5 == listing_id && price >= min && price <= max && host_id != h && listingk.containsAll(amm)) {
                    if (!listings.contains(listing)) {
                        listings.add(listing);
                    }
                }
            }
            for (Listing listing2 : pp) {
                if (listing2.getPrice() >= min && listing2.getPrice() <= max && host_id != h
                        && listingk.containsAll(amm)) {
                    if (!listings.contains(listing)) {
                        listings.add(listing);
                    }
                }
            }
        }
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<String> citysearch() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadaddress5;
        ArrayList<String> listings = new ArrayList<String>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        // static String listingreadaddress5 = "SELECT DISTINCT city FROM listing";
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            listings.add(resultSet.getString(1));
        }
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<String> citysearch2() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadaddress6;
        ArrayList<String> listings = new ArrayList<String>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            listings.add(resultSet.getString(1));
        }
        preparableStatement.close();
        return listings;
    }

    public static ArrayList<Listing> ListingNotinCalender() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadnotincalender;
        ArrayList<Listing> listings = new ArrayList<Listing>();
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Listing listing = new Listing(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10));
            listings.add(listing);
        }
        preparableStatement.close();
        return listings;
    }

    public static void ListingHostCountryRanking(String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcountryhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, country);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("Host ID: " + resultSet.getInt(1) + " Number of listings: " + resultSet.getInt(2));
            break;
        }
        preparableStatement.close();
    }

    public static ArrayList<String> ListingHostCountryRanking2() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadforhost2;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ArrayList<String> listings = new ArrayList<String>();
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            listings.add(resultSet.getString(1) + " " + resultSet.getString(2));
        }
        preparableStatement.close();
        return listings;
    }

    public static void ListingHostCityRanking(String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadcityhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ArrayList<String> listings = new ArrayList<String>();
        preparableStatement.setString(1, city);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("Host ID: " + resultSet.getInt(1) + " Number of listings: " + resultSet.getInt(2));
            break;
        }
        preparableStatement.close();
    }

    // static String listingreadcountryhost10 = "SELECT host_sin, name,
    // table1.country FROM (SELECT host_sin, name, COUNT(lid) AS NumberOfListings,
    // country FROM listing, users WHERE host_sin = sin GROUP BY host_sin, country
    // ORDER BY NumberOfListings DESC) table1, (SELECT country, COUNT(*) AS
    // CountryListings FROM listing GROUP BY country) table2 WHERE
    // table1.NumberOfListings >= (0.1 * table2.CountryListings) AND table1.country
    // = table2.country AND table1.country = ? AND table1.city = ?";
    // give the code as a funciton for the above query
    public static void TenPercentListing(String city, String country) throws SQLException {
        int total = TotalListings(city, country);
        Connection conn = DB.connect();
        String query = Query.listingreadcityhost;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        System.out.println("\nHosts with more than 10% of listings in " + city + ", " + country + ":");
        preparableStatement.setString(1, city);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt(2) >= (0.1 * total)) {
                System.out.println("Host ID: " + resultSet.getInt(1) + " Number of listings: " + resultSet.getInt(2));
            }
        }
        preparableStatement.close();

    }

    public static int TotalListings(String city, String country) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listingreadtotal;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, city);
        preparableStatement.setString(2, country);
        ResultSet resultSet = preparableStatement.executeQuery();
        int total = 0;
        while (resultSet.next()) {
            total = resultSet.getInt(1);
        }
        preparableStatement.close();
        return total;
    }

    public static int getuser(int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.listinggetuser;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        int uid = 0;
        while (resultSet.next()) {
            uid = resultSet.getInt(1);
        }
        preparableStatement.close();
        return uid;
    }
}
