import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;

public class Query {

    static String usersinsert = "INSERT INTO users (uid, name, address, dob, occupation, sin, payment_info) VALUES (?, ?, ?, ?, ?, ?, ?)";
    static String usersread = "SELECT * FROM users";
    static String usersupdate = "UPDATE users SET name = ?, address = ?, dob = ?, occupation = ?, sin = ?, payment_info = ? WHERE uid = ?";
    static String usersdelete = "DELETE FROM users WHERE uid = ?";
    static String userslogin = "SELECT * FROM users WHERE uid = ? AND name = ?";

    static String listinginsert = "INSERT INTO listing (lid, hid, type, price, latitude, longitude, address, postal, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String listingread = "SELECT * FROM listing";
    static String listingupdate = "UPDATE listing SET hid = ?, price = ? WHERE lid = ?";
    static String listingdelete = "DELETE FROM listing WHERE lid = ?";
    static String listingreadforhost = "SELECT * FROM listing WHERE hid = ?";
    static String listingreadprice = "SELECT price FROM listing WHERE lid = ?";

    static String listingreadpostalcode = "SELECT * FROM listing WHERE postal = ?";

    static String getAvgPriceforcity = "SELECT AVG(price) FROM listing WHERE city = ?";
    static String getAvgPriceforcity2 = "SELECT AVG(price) FROM listing";
    static String getAvgPriceforCityTypePostal = "SELECT AVG(price) FROM listing WHERE city = ? AND type = ? AND postal = ?";

    static String bookinginsert = "INSERT INTO booking (bid, lid, rid, book_date, start, end, cost, ccInfo, is_cancelled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String bookingread = "SELECT * FROM booking";
    static String bookingupdate = "UPDATE booking SET book_date = ?, start = ?, end = ?, is_cancelled = ? WHERE bid = ?";
    static String bookingdelete = "DELETE FROM booking WHERE bid = ?";
    static String bookingreadforuser = "SELECT * FROM booking WHERE rid = ?";
    static String bookingreadforlisting = "SELECT * FROM booking WHERE lid = ?";
    static String bookingcancel = "UPDATE booking SET is_cancelled = true WHERE bid = ?";
    // give the join for listing and booking and replace ? ? ? ofr start end and
    // city
    static String bookingread34 = "SELECT DISTINCT * FROM booking b JOIN listing l ON b.lid = l.lid";

    static String bookingreadmostcancel = "SELECT lid, COUNT(*) FROM booking WHERE is_cancelled = true GROUP BY lid ORDER BY COUNT(*) DESC";
    static String bookingreadmostcancelrid = "SELECT rid, COUNT(*) FROM booking WHERE is_cancelled = true GROUP BY rid ORDER BY COUNT(*) DESC";

    static String amenitiesinsert = "INSERT INTO amenities (aid, name, price) VALUES (?, ?, ?)";
    static String amenitiesread = "SELECT * FROM amenities";
    // give the query to find the averager rpice of the amenities
    static String findAvgAmmenityPrice = "SELECT AVG(price) FROM amenities";
    static String amenitiesupdate = "UPDATE amenities SET name = ?, price = ? WHERE aid = ?";
    static String amenitiesdelete = "DELETE FROM amenities WHERE aid = ?";
    // give the ranking to the amenties on the absis of how many times it has been
    // used and price use calculations for it

    static String listingamentitiesinsert = "INSERT INTO listing_amenities (lid, aid) VALUES (?, ?)";
    static String listingamentitiesread = "SELECT * FROM listing_amenities";
    static String listingamentitiesupdate = "UPDATE listing_amenities SET aid = ? WHERE lid = ?";
    static String listingamentitiesdelete = "DELETE FROM listing_amenities WHERE lid = ? AND aid = ?";
    static String listingamentitiesreadforlid = "SELECT * FROM listing_amenities WHERE lid = ?";
    static String listingamentitiesreadforaid2 = "SELECT name, price, COUNT(*) FROM Amenities l JOIN listing_amenities la ON l.aid = la.aid GROUP BY la.aid ORDER BY COUNT(*) DESC";
    // also joing it with listing and givhe tjoin for all three of them
    static String join = "SELECT * FROM listing l JOIN listing_amenities la ON l.lid = la.lid JOIN amenities a ON la.aid = a.aid";

    static String userratinginsert = "INSERT INTO user_rating (urid, rater, ratee, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String userratingread = "SELECT * FROM user_rating";
    static String userratingupdate = "UPDATE user_rating SET rating = ?, body = ?, date = ? WHERE urid = ?";
    static String userratingdelete = "DELETE FROM user_rating WHERE urid = ?";
    // give quety such that it reunts the reviews such that it can be in either
    // rater or ratee
    static String calenderinsert = "INSERT INTO calendar (cid, start, end, lid) VALUES (?, ?, ?, ?)";
    static String calenderread = "SELECT * FROM calendar";
    static String calenderupdate = "UPDATE calendar SET start = ?, end = ? WHERE cid = ?";
    static String calenderdelete = "DELETE FROM calendar WHERE cid = ?";
    static String calenderreadforlid = "SELECT * FROM calendar WHERE lid = ?";

    static String userratingreadforuser = "SELECT * FROM user_rating WHERE rater = ? OR ratee = ?";

    static String listratinginsert = "INSERT INTO listing_rating (lrid, rater, listing, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String listratingread = "SELECT * FROM listing_rating WHERE listing = ?";
    // give teh query to find giveht eh body of all the reviews for a listing
    static String listratingreadbody = "SELECT * FROM listing_rating WHERE listing = ?";

    static String listingreadnearby = "SELECT * FROM listing WHERE (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) <= ? * ? ORDER BY (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) ASC";
    static String listingreadpricewise = "SELECT * FROM listing ORDER BY price ASC";
    static String listingPriceHighttoLow = "SELECT * FROM listing ORDER BY price DESC";

    static String listingreadaddress = "SELECT * FROM listing WHERE address = ?";
    static String listingreadpostal = "SELECT * FROM listing WHERE postal LIKE CONCAT(SUBSTRING(?, 1, CHAR_LENGTH(?) - 1), '_', SUBSTRING(?, -1)) ORDER BY ABS(postal - ?) LIMIT 5";

    static String listingreadcountry = "SELECT * FROM listing WHERE country = ?";
    static String listingreadcountrycity = "SELECT * FROM listing WHERE country = ? AND city = ?";
    static String listingreadcountrycitypostal = "SELECT * FROM listing WHERE country = ? AND city = ? AND postal = ?";
    static String listingreadcountryhost = "SELECT hid, COUNT(*) FROM listing WHERE country = ? GROUP BY hid ORDER BY COUNT(*) DESC";
    static String listingreadcityhost = "SELECT hid, COUNT(*) FROM listing WHERE city = ? GROUP BY hid ORDER BY COUNT(*) DESC";
    static String listingreadtotal = "SELECT COUNT(*) FROM listing WHERE city = ? AND country = ?";
}
