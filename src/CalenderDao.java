import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.time.LocalDate;

public class CalenderDao {
    public static void createCalender(int cid, String start, String end, int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderinsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, cid);
        preparableStatement.setString(2, start);
        preparableStatement.setString(3, end);
        preparableStatement.setInt(4, lid);
        System.out.println("Calender created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<Calender> readCalenderForLid(int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderreadforlid;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<Calender> calenders = new ArrayList<Calender>();
        while (resultSet.next()) {
            Calender calender = new Calender(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
            calenders.add(calender);
        }
        System.out.println("Calenders read successfully");
        preparableStatement.close();
        return calenders;
    }

    // public static ArrayList<Calender> checkIfBookingAvailabCalender(String start,
    // String end, int lid)
    // throws SQLException {
    // Connection conn = DB.connect();
    // String query = Query.calenderreadforlid;
    // PreparedStatement preparableStatement = conn.prepareStatement(query);
    // preparableStatement.setString(1, start);
    // preparableStatement.setString(2, end);
    // preparableStatement.setInt(3, lid);
    // ResultSet resultSet = preparableStatement.executeQuery();
    // ArrayList<Calender> calenders = new ArrayList<Calender>();
    // while (resultSet.next()) {
    // Calender calender = new Calender(resultSet.getInt(1), resultSet.getString(2),
    // resultSet.getString(3),
    // resultSet.getInt(4));
    // calenders.add(calender);
    // }
    // System.out.println("Calenders read successfully");
    // preparableStatement.close();
    // return calenders;
    // }

    public static ArrayList<Calender> checkIfBookingAvailabCalender(String start,
            String end, int lid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderreadforlid;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        preparableStatement.setInt(1, lid);
        ResultSet resultSet = preparableStatement.executeQuery();
        ArrayList<Calender> calenders = new ArrayList<Calender>();
        while (resultSet.next()) {
            Calender calender = new Calender(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
            String start2 = calender.getStart();
            String end2 = calender.getEnd();
            LocalDate startDate2 = LocalDate.parse(start2);
            LocalDate endDate2 = LocalDate.parse(end2);
            boolean isBetween = startDate.isAfter(startDate2) || endDate.isBefore(endDate2);
            if (!isBetween) {
                calenders.add(calender);
            }
            System.out.println("Booking unavailable");
        }
        System.out.println("Calenders read successfully");
        preparableStatement.close();
        return calenders;
    }

    public static ArrayList<Calender> readCalender() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Calender> calenders = new ArrayList<Calender>();
        while (resultSet.next()) {
            Calender calender = new Calender(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
            calenders.add(calender);
        }
        System.out.println("Calenders read successfully");
        statement.close();
        return calenders;
    }

    public static void updateCalender(int cid, String start, String end) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, start);
        preparableStatement.setString(2, end);
        preparableStatement.setInt(3, cid);
        System.out.println("Calender updated successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void deleteCalender(int cid) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.calenderdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, cid);
        System.out.println("Calender deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

}
