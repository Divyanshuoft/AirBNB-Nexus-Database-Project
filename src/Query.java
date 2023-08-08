//These are the queries that are used in the program. 
//They are all static and final so that they can be used in the program without having to create a new instance of the class.

public class Query {

    // user queries
    // insert, read, update, delete, login
    static String usersinsert = "INSERT INTO users (uid, name, address, dob, occupation, sin, payment_info) VALUES (?, ?, ?, ?, ?, ?, ?)";
    static String usersread = "SELECT * FROM users";
    static String usersupdate = "UPDATE users SET name = ?, address = ?, dob = ?, occupation = ?, sin = ?, payment_info = ? WHERE uid = ?";
    static String usersdelete = "DELETE FROM users WHERE uid = ?";
    static String userslogin = "SELECT * FROM users WHERE uid = ? AND name = ?";

    // lisitng queries
    // insert, read, update, delete, readforhost, readprice, getuser, readforuser,
    // readforuser2, readpostalcode
    static String listinginsert = "INSERT INTO listing (lid, hid, type, price, latitude, longitude, address, postal, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String listingread = "SELECT * FROM listing";
    static String listingupdate = "UPDATE listing SET hid = ?, price = ? WHERE lid = ?";
    static String listingdelete = "DELETE FROM listing WHERE lid = ?";
    static String listingreadforhost = "SELECT * FROM listing WHERE hid = ?";
    static String listingreadprice = "SELECT price FROM listing WHERE lid = ?";
    static String listinggetuser = "SELECT hid FROM listing WHERE lid = ?";
    static String listingreadforuser = "SELECT * FROM listing l JOIN booking b ON l.lid = b.lid";
    static String listingreadforuser2 = "SELECT l.lid, l.hid, l.type, l.price, l.latitude, l.longitude, l.address, l.postal, l.city, l.country FROM listing l JOIN booking b ON l.lid = b.lid WHERE b.rid = ? AND b.start <= ? AND b.end >= ? AND b.is_cancelled = false";
    static String listingreadpostalcode = "SELECT * FROM listing WHERE postal = ?";

    // Average price queries
    // getAvgPriceforcity, getAvgPriceforcity2, getAvgPriceforCityTypePostal
    static String getAvgPriceforcity = "SELECT AVG(price) FROM listing WHERE city = ?";
    static String getAvgPriceforcity2 = "SELECT AVG(price) FROM listing";
    static String getAvgPriceforCityTypePostal = "SELECT AVG(price) FROM listing WHERE city = ? AND type = ? AND postal = ?";

    // booking queries
    // insert, read, update, delete, readforuser, readforlisting, readforlisting2,
    // readforlisting3, cancel
    static String bookinginsert = "INSERT INTO booking (bid, lid, rid, book_date, start, end, cost, ccInfo, is_cancelled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static String bookingread = "SELECT * FROM booking";
    static String bookingupdate = "UPDATE booking SET book_date = ?, start = ?, end = ?, is_cancelled = ? WHERE bid = ?";
    static String bookingdelete = "DELETE FROM booking WHERE bid = ?";
    static String bookingreadforuser = "SELECT * FROM booking WHERE rid = ?";
    static String bookingreadforlisting = "SELECT * FROM booking WHERE lid = ?";
    static String bookingreadforlisting2 = "SELECT * FROM booking WHERE bid = ? AND rid = ?";
    static String bookingreadforlisting3 = "SELECT * FROM booking WHERE lid = ? AND rid = ?";
    static String bookingcancel = "UPDATE booking SET is_cancelled = true WHERE bid = ?";

    // read for listing
    static String bookingread34 = "SELECT DISTINCT * FROM booking b JOIN listing l ON b.lid = l.lid";

    // query for most cancelled rid and lid
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

    // listing amenities queries
    // insert, read, update, delete, readforlid, readforaid
    static String listingamentitiesinsert = "INSERT INTO listing_amenities (lid, aid) VALUES (?, ?)";
    static String listingamentitiesread = "SELECT * FROM listing_amenities";
    static String listingamentitiesupdate = "UPDATE listing_amenities SET aid = ? WHERE lid = ?";
    static String listingamentitiesdelete = "DELETE FROM listing_amenities WHERE lid = ? AND aid = ?";
    static String listingamentitiesreadforlid = "SELECT * FROM listing_amenities WHERE lid = ?";

    // query with amenities and give the query for the same
    static String listingamentitiesreadforlid2 = "SELECT * FROM amenities JOIN listing_amenities ON listing_amenities.aid = amenities.aid WHERE listing_amenities.lid = ?";
    static String listingamentitiesreadforaid2 = "SELECT name, price, COUNT(*) FROM Amenities l JOIN listing_amenities la ON l.aid = la.aid GROUP BY la.aid ORDER BY COUNT(*) DESC";

    // query for join of listing and listing amenities and amenities
    static String join = "SELECT * FROM listing l JOIN listing_amenities la ON l.lid = la.lid JOIN amenities a ON la.aid = a.aid";

    // user rating queries
    // insert, read, update, delete
    static String userratinginsert = "INSERT INTO user_rating (urid, rater, ratee, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String userratingread = "SELECT * FROM user_rating";
    static String userratingupdate = "UPDATE user_rating SET rating = ?, body = ?, date = ? WHERE urid = ?";
    static String userratingdelete = "DELETE FROM user_rating WHERE urid = ?";

    // listing rating queries
    // insert, read, update, delete
    static String calenderinsert = "INSERT INTO calendar (cid, start, end, lid) VALUES (?, ?, ?, ?)";
    static String calenderread = "SELECT * FROM calendar";
    static String calenderupdate = "UPDATE calendar SET start = ?, end = ? WHERE cid = ?";
    static String calenderdelete = "DELETE FROM calendar WHERE cid = ?";
    static String calenderreadforlid = "SELECT * FROM calendar WHERE lid = ?";

    // showing the user rating for the user
    static String userratingreadforuser = "SELECT * FROM user_rating WHERE rater = ? OR ratee = ?";

    // listing rating queries
    // insert, read, update, delete
    static String listratinginsert = "INSERT INTO listing_rating (lrid, rater, listing, rating, body, date) VALUES (?, ?, ?, ?, ?, ?)";
    static String listratingread = "SELECT * FROM listing_rating WHERE listing = ?";
    static String listratingreadbody = "SELECT * FROM listing_rating WHERE listing = ?";

    // search queries for the listing
    // search by country, city, postal, country and city, country and city and
    // postal
    static String listingreadnearby = "SELECT * FROM listing WHERE (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) <= ? * ? ORDER BY (latitude - ?) * (latitude - ?) + (longitude - ?) * (longitude - ?) ASC";
    static String listingreadpricewise = "SELECT * FROM listing ORDER BY price ASC";
    static String listingPriceHighttoLow = "SELECT * FROM listing ORDER BY price DESC";
    static String listingreadaddress = "SELECT * FROM listing WHERE address = ?";
    static String listingreadpostal = "SELECT * FROM listing WHERE postal LIKE CONCAT(SUBSTRING(?, 1, CHAR_LENGTH(?) - 1), '_', SUBSTRING(?, -1)) ORDER BY ABS(postal - ?) LIMIT 5";

    // search queries which the user searches for
    // search by country, city, postal, country and city, country and city and
    // postal, country and host, city and host, total
    static String listingreadcountry = "SELECT * FROM listing WHERE country = ?";
    static String listingreadcountrycity = "SELECT * FROM listing WHERE country = ? AND city = ?";
    static String listingreadcountrycitypostal = "SELECT * FROM listing WHERE country = ? AND city = ? AND postal = ?";
    static String listingreadcountrycitypostal2 = "SELECT * FROM listing WHERE country = ? AND city = ? AND postal LIKE ?";
    static String listingreadcountryhost = "SELECT hid, COUNT(*) FROM listing WHERE country = ? GROUP BY hid ORDER BY COUNT(*) DESC";
    static String listingreadcityhost = "SELECT hid, COUNT(*) FROM listing WHERE city = ? GROUP BY hid ORDER BY COUNT(*) DESC";
    static String listingreadtotal = "SELECT COUNT(*) FROM listing WHERE city = ? AND country = ?";

    // query to find the lid which are in listing but not in calender
    static String listingreadnotincalender = "SELECT * FROM listing WHERE lid NOT IN (SELECT lid FROM calendar)";
}
