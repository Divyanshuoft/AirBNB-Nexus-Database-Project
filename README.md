<a name="br1"></a> 

Page **1** of **6**

**CSCC43H3**

**Introduction to Databases**

**Database Design Project (MyBNB) Report**

**By Divyansh Kachchhava**

**Student Number : 1008378462**

**August 8, 2023**

**Department of Computer Science and Mathematics**

**University of Toronto at Scarborough**



<a name="br2"></a> 

Page **2** of **6**

1\. Purpose of the Project:

The purpose of this project is to design a database that supports the operations of a home-sharing

platform like Airbnb. The database should be able to record and manage information related to

listings, users (both renters and hosts), availability calendars, bookings, comments, ratings, and more.

The main goal is to create a robust and efficient system that allows users to search for available

listings, make bookings, manage their profiles, and provide feedback on their experiences.

2\. Conceptual Problems Encountered and Solutions:

2\.1 User Representation:

I’m using the same table to store the users and for each user they can be either a hot or a renter, each

user can rent from the listing and each user can also create a listing for rental. The user who created

the listing cannot rent their own listings.

2\.2 Creating a new Listing:

Any user who is in the database can be a host and make a listing available, the host will be asked to

give the details of the listing as well as they have the option to add amenities, they can see who has

booked their listing and when, they can cancel any booking they want. They have access to the

reviews of their listing and what are the word cloud which the user use while reviewing their listing.

The user can only increase the pricing of the listing once they have created and only when it’s

available. If the booking is cancelled it’s recorded for future references.

2\.3 Handling Bookings and Availability:

To handle bookings and availability, I’ve implemented transaction mechanisms and apply appropriate

locks to prevent concurrent modifications. When a user makes a booking, the system will check the

availability calendar for the specified listing and update it atomically to avoid conflicts. Similarly,

when a host updates the availability or price of a listing, the system will ensure that the listing is not

booked during the specified date range. The host can also make the listing unavailable for 1 day for

renovation period. The user can cancel their booking whenever they want.

2\.4 Comment and Rating Constraints:

We will implement validation checks in the system to ensure that a user can only comment on and rate

a listing or host if they have completed a stay recently. This will be based on the booking history

recorded for each user. They can only comment if it has been in a year (it’s recent I mean). A word

cloud is formed by the comments which the user makes anyone who wants to make the booking in

future can see it.



<a name="br3"></a> 

Page **3** of **6**

3\. Database Design and Schema:

The database schema will consist of the following tables:


Users: Contains user information

Listings: Stores information about the available listings

Calendar: Records the availability and current bookings

Bookings: Tracks the bookings made by renters for specific listings [Booking history]

User Rating: Store the review for the renters made by the hosts.

Listing Rating: Store the review for the listings made by the renters.

Amenities: The host can add them to their listing to increase their revenue

Listing Amenities: The table which stores the Amenities which the listing has.

4\. Operations to Support:

•

•

•

•

•

User creation and deletion (renter or host).

Booking listings and creating new listings.

Cancelling bookings and removing listings.

Updating listing price and availability.

Inserting comments and ratings.

5\. Queries to Support:

•

•

•

•

•

Search listings by location, distance, and price.

Search by postal code.

Exact search by address.

Search with temporal filter (date range).

Search with filters (amenities, availability, price range).

6\. Reports to Support:

•

•

•

•

•

•

•

•

Total number of bookings by city and zip code in a date range.

Total number of listings by country, city, and postal code.

Rank hosts by total number of listings by country and city.

Identify hosts with more than 10% of listings in a city.

Rank renters by number of bookings in a period.

Rank renters by number of bookings per city.

Report hosts and renters with the most cancellations.

Generate a report of popular noun phrases associated with each listing.

5\. Host Toolkit:

•

•

•

Create a function to suggest listing price.

Suggest amenities to add to listings.

Estimate revenue increase for adding amenities.



<a name="br4"></a> 

Page **4** of **6**

6\. Pricing Algorithm:

The pricing algorithm will analyse similar listings in the location, suppose that the user creates the

listing in a big city then the pricing from the average of the price which are in that city, if the city is

small or big then the price will be suggested accordingly. Furthermore, if the user adds the amenities,

then the price of each amenity is added to the price of the listing so the host can make more revenue.

7\. Amenities Suggestion:

The amenities suggestion algorithm will give the most used amenities in our database to the user

when they created a new listing, the user can add one or more than amenities as per their choice, they

can even come back after they have created the listing to add more amenities.

8\. My Reasonable Assumptions

•

•

•

I’ve setup the login for the user, such that they only need to enter the username and they will

get a uid which is like password for them, and they need to use that to login.

The users need to enter the information in the format they have asked for, if they don’t do this

then it can hurt very bad the program Eg. Enter the date in the format YYYY-MM-DD

For the search query to see the listing you have option to either view the search result

individually or search support at the same time for all the queries

•

•

A user can make multiple bookings at the same at different places.

Distances between latitudes and longitudes will be calculated using the Haversine formula,

providing accurate relative distances suitable for ranking listings and location-based searches.

The user needs to enter this, and the query will rank the listing accordingly.

•

In the report where I’m asked the total number of listing per city and country and postal, I’ve

modified this such that it will ask the user which country to make it more meaningful.

9\. Schema

Users (uid, name, address, dob, occupation, sin, payment info)

Listing (lid, hid, type, price, latitude, longitude, address, postal, city, country)

Amenities (aid, name, price)

Listing Amenities (lid, aid)

Calendar (cid, start, end, lid)

Booking (bid, lid, rid, book date, start, end, cost, ccInfo, is\_cancelled)

User\_Rating (urid, rater, ratee, rating, body, date)

Listing\_Rating (lrid, rater, listing, rating, body, date)



<a name="br5"></a> 

Page **5** of **6**

10\. ER Diagram

11\. System limitations:

Scalability and Performance: As the database accumulates more data over time, the performance

might degrade due to increased query complexity and larger data sets. Managing and optimizing the

database for efficient performance as it grows could become a challenge.

Security and Privacy: While user data, including personal information and payment details, is

essential for the platform's functionality, it also presents security and privacy concerns. Ensuring

robust encryption, authentication, and access control mechanisms is critical to protect user data.

Real-time Updates: The system's ability to handle real-time updates, such as availability changes,

booking cancellations, and price adjustments, may be limited. Ensuring timely updates and

maintaining data consistency across all parts of the system could be challenging.

Complexity of Search Queries: The extensive range of search options and filters, along with the need

for spatial and temporal constraints, might lead to complex query design. Balancing query

performance with the flexibility of search options could be a trade-off.



<a name="br6"></a> 

Page **6** of **6**

Host Toolkit Accuracy: The accuracy of the host toolkit's price and amenity suggestions, as well as

revenue increase estimates, relies on the underlying algorithms and assumptions. The actual impact of

suggested changes on revenue might vary based on market dynamics and user preferences.

12\. Conclusion:

The MyBnB database design project aims to create a robust and efficient platform for home-sharing

services. The proposed solutions address conceptual problems related to user representation, booking

management, and comment constraints. The database schema allows for easy querying and reporting

to provide valuable insights to users.

With a focus on data integrity, security, scalability, and user experience, MyBnB can become a trusted

and popular platform for both renters and hosts. By employing advanced algorithms in the host

toolkit, hosts can optimize their listings and attract more renters, creating a win-win situation for all

stakeholders involved. The continuous improvement and maintenance of the platform will ensure it

remains relevant and competitive in the dynamic market of home-sharing services.


