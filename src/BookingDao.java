import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

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
}