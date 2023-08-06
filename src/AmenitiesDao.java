import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AmenitiesDao {
    public static void createAmenitites(Amenities amenities) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.amenitiesinsert;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, amenities.getAid());
        preparableStatement.setString(2, amenities.getName());
        preparableStatement.setDouble(3, amenities.getPrice());
        System.out.println("Amenities created successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static ArrayList<Amenities> readAmenities() throws SQLException {
        Connection conn = DB.connect();
        String query = Query.amenitiesread;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Amenities> amenit_list = new ArrayList<Amenities>();
        while (resultSet.next()) {
            Amenities amenities = new Amenities(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
            amenit_list.add(amenities);
        }
        System.out.println("Amenities read successfully");
        statement.close();
        return amenit_list;
    }

    public static void deleteAmenities(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.amenitiesdelete;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setInt(1, id);
        System.out.println("Amenities deleted successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }

    public static void updateAmenities(int id, String name, double price) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.amenitiesupdate;
        PreparedStatement preparableStatement = conn.prepareStatement(query);
        preparableStatement.setString(1, name);
        preparableStatement.setDouble(2, price);
        preparableStatement.setInt(3, id);
        System.out.println("Amenities updated successfully");
        preparableStatement.execute();
        preparableStatement.close();
    }
}
