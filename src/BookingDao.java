import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.sql.Statement;
import java.time.LocalDate;

public class BookingDao {
    public static void createBooking(Booking booking) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookinginsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, booking.getBid());
        preparableStatement.setInt(2, booking.getLid());
        preparableStatement.setInt(3, booking.getRid());
        preparableStatement.setString(4, booking.getBook_date());
        preparableStatement.setString(5, booking.getStart());
        preparableStatement.setString(6, booking.getEnd());
        preparableStatement.setDouble(7, booking.getCost());
        preparableStatement.setString(8, booking.getCcInfo());
        preparableStatement.setBoolean(9, booking.isIs_cancelled());
        System.out.println("Booking created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<Booking> readBooking() throws SQLException {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Connection conn = DB.connect();
        String query = Query.bookingread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Booking booking = new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDouble(7),
                    resultSet.getString(8), resultSet.getBoolean(9));
            bookings.add(booking);
        }
        System.out.println("Bookings read successfully");
        statement.close();
        return bookings;
    }

    public static void readBooking2(String start, String end) throws SQLException {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Connection conn = DB.connect();
        String query = Query.bookingread;
        String s = start;
        String e = end;
        LocalDate startDate2 = LocalDate.parse(s);
        LocalDate endDate2 = LocalDate.parse(e);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Integer> Rids = new ArrayList<Integer>();
        // create a linkedlist that contains 2 feilds rid and count
        // Map<int, int> map = new HashMap<int, int>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (resultSet.next()) {
            LocalDate startDate1 = LocalDate.parse(resultSet.getString(5));
            LocalDate endDate1 = LocalDate.parse(resultSet.getString(6));
            // Check if (start1, end1) lies within (start2, end2)
            boolean isWithin = startDate1.isAfter(startDate2)
                    && endDate1.isBefore(endDate2);
            if (isWithin) {
                // Booking booking = new Booking(resultSet.getInt(1), resultSet.getInt(2),
                // resultSet.getInt(3),
                // resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                // resultSet.getDouble(7),
                // resultSet.getString(8), resultSet.getBoolean(9));
                // bookings.add(booking);
                if (map.containsKey(resultSet.getInt(3))) {
                    map.put(resultSet.getInt(3), map.get(resultSet.getInt(3)) + 1);
                } else {
                    map.put(resultSet.getInt(3), 1);
                }
            }
        }
        // sort the map by value of rid whichis the key

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out
                    .println("User ID: " + entry.getKey() + " has rented: " + entry.getValue() + " time betwen " + start
                            + " and " + end);
        }
        System.out.println("Bookings read successfully");
        statement.close();
        // return bookings;
    }

    public static void deleteBooking(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("Booking deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void updateBooking(int id, String book_date, String start, String end, boolean is_cancelled)
            throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, book_date);
        preparableStatement.setString(2, start);
        preparableStatement.setString(3, end);
        preparableStatement.setBoolean(4, is_cancelled);
        preparableStatement.setInt(5, id);
        System.out.println("Booking updated successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void readBookingforUser(int uid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingreadforuser;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, uid);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Booking ID: " + resultSet.getInt(1));
            System.out.print(", Lisiting ID: " + resultSet.getInt(2));
            System.out.print(", User ID: " + resultSet.getInt(3));
            System.out.print(", Booking Date: " + resultSet.getString(4));
            System.out.print(", Start Time: " + resultSet.getString(5));
            System.out.print(", End Time: " + resultSet.getString(6));
            System.out.print(", Cost: " + resultSet.getDouble(7));
            System.out.print(", Credit Card Info: " + resultSet.getString(8));
            System.out.print(", Is Cancelled: " + resultSet.getBoolean(9));
            System.out.println();
        }
    }

    public static ArrayList<Booking> readBookingforListing(int lid) throws SQLException {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Connection conn = DB.connect();
        String query = Query.bookingreadforlisting;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            Booking booking = new Booking(
                    resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                    resultSet.getDouble(7), resultSet.getString(8), resultSet.getBoolean(9));
            bookings.add(booking);
        }
        preparableStatement.close();
        return bookings;
    }

    // give code for this static String bookingdelete = "DELETE FROM booking WHERE
    // bid = ?";
    public static void deleteBooking2(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("Booking deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static boolean checkBooking(int bid, int rid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingreadforlisting2;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, bid);
        preparableStatement.setInt(2, rid);
        ResultSet resultSet = preparableStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkBooking2(int lid, int rid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingreadforlisting3;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        preparableStatement.setInt(2, rid);
        ResultSet resultSet = preparableStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static void mostcancellation() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingreadmostcancel;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Listing ID: " + resultSet.getInt(1));
            System.out.print(", Number of Cancellations: " + resultSet.getInt(2));
            System.out.println();
        }
        mostcancellationrid();
    }

    public static void mostcancellationrid() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingreadmostcancelrid;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Renter ID: " + resultSet.getInt(1));
            System.out.print(", Number of Cancellations: " + resultSet.getInt(2));
            System.out.println();
        }
    }

    public static void asdasd(String start_date, String end_date, String city) throws SQLException {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Connection conn = DB.connect();
        String query = Query.bookingread34;
        String s = start_date;
        String e = end_date;
        String c = city;
        LocalDate startDate2 = LocalDate.parse(s);
        LocalDate endDate2 = LocalDate.parse(e);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Integer> Rids = new ArrayList<Integer>();
        // create a linkedlist that contains 2 feilds rid and count
        // Map<int, int> map = new HashMap<int, int>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (resultSet.next()) {
            LocalDate startDate1 = LocalDate.parse(resultSet.getString(5));
            LocalDate endDate1 = LocalDate.parse(resultSet.getString(6));
            // System.out.println(resultSet.getString(5));
            // System.out.println(resultSet.getString(6));
            // System.out.println(resultSet.getString(14));
            // System.out.println(resultSet.getString(15));
            // System.out.println(resultSet.getString(16));

            // Check if (start1, end1) lies within (start2, end2)
            boolean isWithin = startDate1.isAfter(startDate2)
                    && endDate1.isBefore(endDate2) && resultSet.getString(18).equals(c);
            if (isWithin) {
                // Booking booking = new Booking(resultSet.getInt(1), resultSet.getInt(2),
                // resultSet.getInt(3),
                // resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                // resultSet.getDouble(7),
                // resultSet.getString(8), resultSet.getBoolean(9));
                // bookings.add(booking);
                // System.out.println("resultSet.getInt(3): " + resultSet.getInt(3));
                if (map.containsKey(resultSet.getInt(3))) {
                    map.put(resultSet.getInt(3), map.get(resultSet.getInt(3)) + 1);
                } else {
                    map.put(resultSet.getInt(3), 1);
                }
            }
        }
        // sort the map by value of rid whichis the key

        for (

        Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out
                    .println("User ID: " + entry.getKey() + " has rented: " + entry.getValue() + " time betwen "
                            + start_date
                            + " and " + end_date + " in " + city);
        }
        System.out.println("Bookings read successfully");
        statement.close();
    }

    public static void totalBookingForCity(String start_date, String end_date, String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingread34;
        String s = start_date;
        String e = end_date;
        String c = city;
        LocalDate startDate2 = LocalDate.parse(s);
        LocalDate endDate2 = LocalDate.parse(e);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int c2 = 0;
        while (resultSet.next()) {
            LocalDate startDate1 = LocalDate.parse(resultSet.getString(5));
            LocalDate endDate1 = LocalDate.parse(resultSet.getString(6));
            boolean isWithin = startDate1.isAfter(startDate2)
                    && endDate1.isBefore(endDate2) && resultSet.getString(18).equals(c);
            if (isWithin) {
                c2++;
            }
        }
        // sort the map by value of rid whichis the key

        System.out.println("Total number of bookings in " + city + " between " + start_date + " and " + end_date
                + " is: " + c2);
        System.out.println("Bookings read successfully");
        statement.close();
    }

    public static void totalBookingForCityZip(String zip, String city) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingread34;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int c2 = 0;
        while (resultSet.next()) {
            boolean isWithin = resultSet.getString(18).equals(city) && resultSet.getString(17).equals(zip);
            if (isWithin) {
                c2++;
            }
        }
        System.out.println("Total number of bookings in " + city + " with zip code " + zip + " is: " + c2);
        System.out.println("Bookings read successfully");
        statement.close();
    }

    public static void asdasd12(int year) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.bookingread34;
        int y = year;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        // create a linkedlist that contains 2 feilds rid and count
        // Map<int, int> map = new HashMap<int, int>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (resultSet.next()) {
            LocalDate startDate1 = LocalDate.parse(resultSet.getString(4));
            System.out.println(resultSet.getString(4));
            int z = startDate1.getYear();
            System.out.println(z);

            // System.out.println(resultSet.getString(5));
            // System.out.println(resultSet.getString(6));
            // System.out.println(resultSet.getString(14));
            // System.out.println(resultSet.getString(15));
            // System.out.println(resultSet.getString(16));

            // Check if (start1, end1) lies within (start2, end2)
            boolean isWithin = z == y;
            if (isWithin) {
                if (map.containsKey(resultSet.getInt(3))) {
                    map.put(resultSet.getInt(3), map.get(resultSet.getInt(3)) + 1);
                } else {
                    map.put(resultSet.getInt(3), 1);
                }
            }
        }
        // sort the map by value of rid whichis the key

        for (

        Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out
                    .println("User ID: " + entry.getKey() + " has rented: " + entry.getValue() + " times in " + year);
        }
        System.out.println("Bookings read successfully");
        statement.close();
    }
}