public class Query {

    static String usersinsert = "INSERT INTO users (uid, name, address, dob, occupation, sin, payment_info) VALUES (?, ?, ?, ?, ?, ?, ?)";
    static String usersread = "SELECT * FROM users";
    static String usersupdate = "UPDATE users SET name = ?, address = ?, dob = ?, occupation = ?, sin = ?, payment_info = ? WHERE uid = ?";
    static String usersdelete = "DELETE FROM users WHERE uid = ?";
    static String userslogin = "SELECT * FROM users WHERE uid = ? AND name = ?";

    static String listinginsert = "INSERT INTO listing (lid, hid, type, price, latitude, longitude, address, postal, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String listingread = "SELECT * FROM listing";
    static String listingupdate = "UPDATE listing SET hid = ?, type = ?, price = ?, latitude = ?, longitude = ?, address = ?, postal = ?, city = ?, country = ? WHERE lid = ?";
    static String listingdelete = "DELETE FROM listing WHERE lid = ?";
}
