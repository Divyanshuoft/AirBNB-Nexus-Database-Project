import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
    // driver load
    // conn establish
    // statement execute
    // execute query
    // close connection
    public void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "CREATE DATABASE" + dbName;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("Database created successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url + dbName, username, password);
            Statement statement = connection.createStatement();
            // String query = "CREATE TABLE users (uid INT NOT NULL AUTO_INCREMENT PRIMARY
            // KEY, name varchar(100) NOT NULL, address varchar(200) NOT NULL, dob
            // varchar(20) NOT NULL, occupation varchar(30) NOT NULL, sin varchar(20) NOT
            // NULL, payment_info VARCHAR(255))";

            // String query = "CREATE TABLE listing (lid INT NOT NULL AUTO_INCREMENT PRIMARY
            // KEY, hid INT NOT NULL, type varchar(20) NOT NULL, price decimal(9, 2) NOT
            // NULL, latitude decimal(9, 7) NOT NULL, longitude decimal (10, 7) NOT NULL,
            // address varchar(100) NOT NULL, postal varchar(10) NOT NULL, city varchar(30)
            // NOT NULL, country varchar(30) NOT NULL, FOREIGN KEY (hid) REFERENCES users
            // (uid) ON DELETE CASCADE)";

            // String query = "CREATE TABLE amenities (aid INT NOT NULL AUTO_INCREMENT
            // PRIMARY KEY, name VARCHAR(100) NOT NULL, price decimal(9, 2) NOT NULL)";

            // String query = "CREATE TABLE listing_amenities (lid INT NOT NULL, aid INT NOT
            // NULL,
            // FOREIGN KEY (lid) REFERENCES listing(lid), FOREIGN KEY (aid) REFERENCES
            // amenities(aid))";
            String query = "CREATE TABLE calendar (cid INT NOT NULL AUTO_INCREMENT PRIMARY KEY, start varchar(20) NOT NULL, end varchar(20) NOT NULL, lid INT NOT NULL, FOREIGN KEY (lid) REFERENCES listing (lid))";

            // String query = "CREATE TABLE booking (bid INT NOT NULL AUTO_INCREMENT PRIMARY
            // KEY, lid INT, rid INT, book_date varchar(20) NOT NULL, start varchar(20) NOT
            // NULL, end varchar(20) NOT NULL, cost decimal(9, 2) NOT NULL, ccInfo
            // varchar(30), is_cancelled BOOLEAN NOT NULL DEFAULT false, FOREIGN KEY (lid)
            // REFERENCES Listing (lid) ON DELETE CASCADE, FOREIGN KEY (rid) REFERENCES
            // users (uid) ON DELETE SET NULL)";
            // String query = "CREATE TABLE user_rating (urid INT AUTO_INCREMENT PRIMARY
            // KEY, rater INT NOT NULL, ratee INT NOT NULL, rating INT NOT NULL DEFAULT 0,
            // body VARCHAR(200) NOT NULL DEFAULT '', date DATE NOT NULL, FOREIGN KEY
            // (rater) REFERENCES users(uid), FOREIGN KEY (ratee) REFERENCES users(uid))";

            // String query = "CREATE TABLE listing_rating (lrid INT AUTO_INCREMENT PRIMARY
            // KEY, rater INT NOT NULL, listing INT NOT NULL, rating INT NOT NULL DEFAULT 0,
            // body VARCHAR(200) NOT NULL DEFAULT '', date DATE NOT NULL, FOREIGN KEY
            // (rater) REFERENCES users(uid), FOREIGN KEY (listing) REFERENCES
            // listing(lid))";
            statement.execute(query);
            System.out.println("Table created successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url + dbName, username, password);
            String query = "INSERT INTO student (sid, sname, saddress) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 3);
            statement.setString(2, "DS");
            statement.setString(3, "Kathmdsandu");
            statement.execute();
            System.out.println("Data inserted successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url + dbName, username, password);
            String query = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                        + resultSet.getString(3));
            }

            System.out.println("Data read successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url + dbName, username, password);
            String query = "UPDATE student SET sname = ?, saddress = ? WHERE sid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "Dipesh");
            statement.setString(2, "Kathmandu");
            statement.setInt(3, 3);
            statement.execute();
            System.out.println("Data updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeleteData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "test";
            String username = "root";
            String password = "Canada@2021";
            Connection connection = DriverManager.getConnection(url + dbName, username, password);
            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 3);
            statement.execute();
            System.out.println("Data deleted successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
