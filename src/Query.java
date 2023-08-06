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
    static String listingupdate = "UPDATE listing SET hid = ?, type = ?, price = ?, latitude = ?, longitude = ?, address = ?, postal = ?, city = ?, country = ? WHERE lid = ?";
    static String listingdelete = "DELETE FROM listing WHERE lid = ?";
    static String listingreadforhost = "SELECT * FROM listing WHERE hid = ?";
    static String listingreadprice = "SELECT price FROM listing WHERE lid = ?";

    static String bookinginsert = "INSERT INTO booking (bid, lid, rid, book_date, start, end, cost, ccInfo, is_cancelled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String bookingread = "SELECT * FROM booking";
    static String bookingupdate = "UPDATE booking SET book_date = ?, start = ?, end = ?, is_cancelled = ? WHERE bid = ?";
    static String bookingdelete = "DELETE FROM booking WHERE bid = ?";
    static String bookingreadforuser = "SELECT * FROM booking WHERE rid = ?";
    static String bookingreadforlisting = "SELECT * FROM booking WHERE lid = ?";

    static String amenitiesinsert = "INSERT INTO amenities (aid, name, price) VALUES (?, ?, ?)";
    static String amenitiesread = "SELECT * FROM amenities";
    static String amenitiesupdate = "UPDATE amenities SET name = ?, price = ? WHERE aid = ?";
    static String amenitiesdelete = "DELETE FROM amenities WHERE aid = ?";

    static String listingamentitiesinsert = "INSERT INTO listing_amenities (lid, aid) VALUES (?, ?)";
    static String listingamentitiesread = "SELECT * FROM listing_amenities";
    static String listingamentitiesupdate = "UPDATE listing_amenities SET aid = ? WHERE lid = ?";
    static String listingamentitiesdelete = "DELETE FROM listing_amenities WHERE lid = ? AND aid = ?";
    static String listingamentitiesreadforlid = "SELECT * FROM listing_amenities WHERE lid = ?";

    static String userratinginsert = "INSERT INTO user_rating (urid, rater, ratee, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String userratingread = "SELECT * FROM user_rating";
    static String userratingupdate = "UPDATE user_rating SET rating = ?, body = ?, date = ? WHERE urid = ?";
    static String userratingdelete = "DELETE FROM user_rating WHERE urid = ?";
    // give quety such that it reunts the reviews such that it can be in either
    // rater or ratee
    static String userratingreadforuser = "SELECT * FROM user_rating WHERE rater = ? OR ratee = ?";

    static String listratinginsert = "INSERT INTO listing_rating (lrid, rater, listing, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String listratingread = "SELECT * FROM listing_rating WHERE listing = ?";

    // The system at a minimum should be able to search for specific listings in the
    // vicinity of a specific location. Namely if a user specifies a latitude and
    // longitude we should return all listings with a specific distance (the user
    // should have a choice of the distance along with a default provided). The
    // listings returned should be ranked by the distance to the specific search
    // location. You have to decide what distance you will use.
    static String listingreadnearby = "SELECT * FROM listing WHERE (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) <= ? * ? ORDER BY (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) ASC";
    static String listingreadpricewise = "SELECT * FROM listing ORDER BY price ASC";
    static String listingPriceHighttoLow = "SELECT * FROM listing ORDER BY price DESC";
    // Other search options should be possible for example a search by postal code
    // which should return all listings in the same and adjacent postal codes.
    // Please give the query for this adjacent code search
    // SELECT *
    // FROM YourTableName
    // WHERE postal LIKE CONCAT(SUBSTRING(:input_postal, 1,
    // CHAR_LENGTH(:input_postal) - 1), '_', SUBSTRING(:input_postal, -1))
    // ORDER BY ABS(postal - :input_postal)
    // LIMIT 5;

    static String listingreadaddress = "SELECT * FROM listing WHERE address = ?";
    static String listingreadpostal = "SELECT * FROM listing WHERE postal LIKE CONCAT(SUBSTRING(?, 1, CHAR_LENGTH(?) - 1), '_', SUBSTRING(?, -1)) ORDER BY ABS(postal - ?) LIMIT 5";

    // We would like to run a report and provide the total number of listings per
    // country, per country and city as well as per country, city and postal code

    static String listingreadcountry = "SELECT * FROM listing WHERE country = ?";
    static String listingreadcountrycity = "SELECT * FROM listing WHERE country = ? AND city = ?";
    static String listingreadcountrycitypostal = "SELECT * FROM listing WHERE country = ? AND city = ? AND postal = ?";
    static String listingreadcountryhost = "SELECT hid, COUNT(*) FROM listing WHERE country = ? GROUP BY hid ORDER BY COUNT(*) DESC";
    static String listingreadcityhost = "SELECT hid, COUNT(*) FROM listing WHERE city = ? GROUP BY hid ORDER BY COUNT(*) DESC";
}
