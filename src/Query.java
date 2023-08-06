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
    static String listingreadforhost = "SELECT * FROM listing WHERE hid = ?";
    static String listingreadprice = "SELECT price FROM listing WHERE lid = ?";

    static String bookinginsert = "INSERT INTO booking (bid, lid, rid, book_date, start, end, cost, ccInfo, is_cancelled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String bookingread = "SELECT * FROM booking";
    static String bookingupdate = "UPDATE booking SET book_date = ?, start = ?, end = ?, is_cancelled = ? WHERE bid = ?";
    static String bookingdelete = "DELETE FROM booking WHERE bid = ?";
    static String bookingreadforuser = "SELECT * FROM booking WHERE rid = ?";

    static String amenitiesinsert = "INSERT INTO amenities (aid, name, price) VALUES (?, ?, ?)";
    static String amenitiesread = "SELECT * FROM amenities";
    static String amenitiesupdate = "UPDATE amenities SET name = ?, price = ? WHERE aid = ?";
    static String amenitiesdelete = "DELETE FROM amenities WHERE aid = ?";
}
