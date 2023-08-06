import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static int exit_program = 0;
    public static int uid = 0;

    public static void main(String[] args) throws Exception {
        while (exit_program == 0) {
            int logged_in = 0;
            System.out.println("Welcome to MyBNB!");
            System.out.print("1. Login 2. Register 3. Exit ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice");
                continue;
            }
            if (choice == 3) {
                System.out.println("Goodbye!");
                exit_program = 1;
                // write code to exit the program on terminal
                break;
            } else if (choice == 2) {
                System.out.println("Please register: enter");
                System.out.println("uid, name, address, dob, occupation, sin, payment_info");
                scanner.nextLine();
                int id = scanner.nextInt();
                scanner.nextLine();
                String name = scanner.nextLine();
                String address = scanner.nextLine();
                String dob = scanner.nextLine();
                String occupation = scanner.nextLine();
                String sin = scanner.nextLine();
                String payment_info = scanner.nextLine();
                Employee employee = new Employee(id, name, address, dob, occupation, sin, payment_info);
                EmployeeDao.createEmployee(employee);
                System.out.println(name);
            } else {
                System.out.println("Login User");
                System.out.println("Enter UID and Username");
                uid = scanner.nextInt();
                scanner.nextLine();
                String username = scanner.nextLine();
                boolean x = EmployeeDao.loginEmployee(uid, username);
                if (x == false) {
                    System.out.println("Invalid username or password");
                    System.out.println("Please try again");
                    logged_in = 1;
                } else {
                    logged_in = 0;
                }
                while (logged_in == 0) {
                    System.out.println(
                            "2. Read User 5. Your Listings 6. Book a new Listing 7. View your Bookings 8. View Amentities for hosts 10. View reviews 9. Logout");
                    System.out.print("\nEnter your choice: ");
                    scanner = new Scanner(System.in);
                    choice = scanner.nextInt();

                    // if (choice < 1 || choice > 8) {
                    // System.out.println("Invalid choice");
                    // continue;
                    // }

                    switch (choice) {
                        case 2:
                            System.out.println("Read User");
                            ArrayList<Employee> employees = EmployeeDao.readEmployees();
                            for (Employee e : employees) {
                                System.out.println(e);
                            }
                            break;

                        case 10:
                            System.out.println("View reviews");
                            System.out
                                    .println("Here are the reviews where you are either the host or the guest");
                            UserRatingDao.readUserRatingforUser(uid);

                            break;

                        case 8:
                            System.out.println("View Amentities for hosts");
                            ArrayList<Amenities> amenities = AmenitiesDao.readAmenities();
                            for (Amenities a : amenities) {
                                System.out.println(a);
                            }
                            int amt = 0;
                            while (amt == 0) {
                                System.out.println("Please enter your choice:");
                                System.out.println(
                                        "1. Add new amenity 2. Update existing amenity 3. Delete amenity 4. Go back to home-page");
                                int aid = scanner.nextInt();
                                scanner.nextLine();
                                switch (aid) {
                                    case 1:
                                        System.out.println("Add new amenity: aid, name, price");
                                        int aid1 = scanner.nextInt();
                                        scanner.nextLine();
                                        String name = scanner.nextLine();
                                        double price = scanner.nextDouble();
                                        Amenities amenity = new Amenities(aid1, name, price);
                                        System.out.println("View updated Amentities for hosts");
                                        AmenitiesDao.createAmenitites(amenity);
                                        amenities = AmenitiesDao.readAmenities();
                                        for (Amenities a : amenities) {
                                            System.out.println(a);
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Update existing amenity: id, name, price");
                                        aid1 = scanner.nextInt();
                                        scanner.nextLine();
                                        name = scanner.nextLine();
                                        price = scanner.nextDouble();
                                        AmenitiesDao.updateAmenities(aid1, name, price);
                                        System.out.println("View updated Amentities for hosts");
                                        amenities = AmenitiesDao.readAmenities();
                                        for (Amenities a : amenities) {
                                            System.out.println(a);
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Delete amenity: id");
                                        aid1 = scanner.nextInt();
                                        AmenitiesDao.deleteAmenities(aid1);
                                        System.out.println("View updated Amentities for hosts");
                                        amenities = AmenitiesDao.readAmenities();
                                        for (Amenities a : amenities) {
                                            System.out.println(a);
                                        }
                                        break;
                                    case 4:
                                        amt = 1;
                                        break;
                                }
                            }
                            break;
                        // case 3:
                        // System.out.println("Update User: id, name, address, dob, occupation, sin,
                        // payment_info");
                        // int id = scanner.nextInt();
                        // scanner.nextLine();
                        // String name = scanner.nextLine();
                        // String address = scanner.nextLine();
                        // String dob = scanner.nextLine();
                        // String occupation = scanner.nextLine();
                        // String sin = scanner.nextLine();
                        // String payment_info = scanner.nextLine();
                        // EmployeeDao.updateEmployee(id, name, address, dob, occupation, sin,
                        // payment_info);
                        // break;

                        // case 4:
                        // System.out.println("Delete User: id ");
                        // id = scanner.nextInt();
                        // EmployeeDao.deleteEmployee(id);
                        // break;

                        case 5:
                            System.out.println("Here are your Listings");
                            ArrayList<Listing> listings2 = ListingDao.readListingforHost(uid);
                            for (Listing l : listings2) {
                                System.out.println(l);
                            }
                            int host_listing = 0;
                            while (host_listing == 0) {
                                System.out.println("Please enter your choice:");
                                System.out.println(
                                        "1. View Listing 2. Create new Listing 5. Update existing Listing 6. Delete a listing 7. Add amentities 9. Go back to home-page");
                                scanner = new Scanner(System.in);
                                int x7 = scanner.nextInt();

                                switch (x7) {
                                    case 1:
                                        System.out.println("Here are your Listings");
                                        listings2 = ListingDao.readListingforHost(uid);
                                        for (Listing l : listings2) {
                                            System.out.println(l);
                                        }
                                        System.out.println("Please enter the listing id");
                                        int lid = scanner.nextInt();
                                        int listing_entered = 0;

                                        while (listing_entered == 0) {
                                            System.out.println("Please enter your choice:");
                                            System.out.println(
                                                    "1. View Amenitites 2. View Listing Reviews 3. Give Review for renter 4. Go back to Listing page");
                                            int x3 = scanner.nextInt();

                                            switch (x3) {
                                                case 1:
                                                    System.out.println("View Amenitites for the listing");
                                                    ArrayList<ListingAmentities> amenities2 = ListingAmentitiesDao
                                                            .readAmenitiesforListingforlid(lid);
                                                    for (ListingAmentities a : amenities2) {
                                                        System.out.println(a);
                                                    }
                                                    int listing_amenity = 0;
                                                    while (listing_amenity == 0) {
                                                        System.out.println("Please enter your choice:");
                                                        System.out.println(
                                                                "1. Add new amenity 2. Delete amenity 3. Go back to your Listing");
                                                        int aid2 = scanner.nextInt();
                                                        scanner.nextLine();
                                                        switch (aid2) {
                                                            case 1:
                                                                System.out.println("Here are all the amenities");
                                                                amenities = AmenitiesDao.readAmenities();
                                                                for (Amenities a : amenities) {
                                                                    System.out.println(a);
                                                                }
                                                                System.out.println(
                                                                        "Add new amenity from above: aid");
                                                                int aid1 = scanner.nextInt();
                                                                scanner.nextLine();
                                                                ListingAmentities amenity = new ListingAmentities(lid,
                                                                        aid1);
                                                                System.out.println("View updated Amentities for hosts");
                                                                ListingAmentitiesDao.createListingAmentities(amenity);
                                                                amenities2 = ListingAmentitiesDao
                                                                        .readAmenitiesforListingforlid(lid);
                                                                for (ListingAmentities a : amenities2) {
                                                                    System.out.println(a);
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println(
                                                                        "Here are all the amenities for your listing");
                                                                amenities2 = ListingAmentitiesDao
                                                                        .readAmenitiesforListingforlid(lid);
                                                                for (ListingAmentities a : amenities2) {
                                                                    System.out.println(a);
                                                                }
                                                                System.out.println("Delete amenity: aid");
                                                                aid1 = scanner.nextInt();
                                                                ListingAmentitiesDao
                                                                        .deleteListingAmentities(aid1, lid);
                                                                System.out.println(
                                                                        "View updated Amentities for hosts");
                                                                amenities2 = ListingAmentitiesDao
                                                                        .readAmenitiesforListingforlid(lid);
                                                                for (ListingAmentities a : amenities2) {
                                                                    System.out.println(a);
                                                                }
                                                                break;
                                                            case 3:
                                                                listing_amenity = 1;
                                                                System.out.println("Go back to your Listing");
                                                                break;
                                                        }
                                                    }
                                                    break;

                                                // case 2:
                                                // System.out.println("View Listing Reviews");
                                                // ArrayList<Review> reviews = ReviewDao
                                                // .readReviewsforListing(lid);
                                                // for (Review r : reviews) {
                                                // System.out.println(r);
                                                // }
                                                // break;

                                                case 3:
                                                    System.out.println("Give Review for renter");
                                                    // gdt the renter id from the booking table
                                                    ArrayList<Booking> bookings = BookingDao.readBookingforListing(lid);
                                                    int rid = 0;
                                                    for (Booking b : bookings) {
                                                        System.out.println("The renter with renter id: " + b.getRid()
                                                                + " has booked your listing with booking id: "
                                                                + b.getBid());
                                                        rid = b.getRid();
                                                    }
                                                    System.out.println("Please  the review for the renter");
                                                    System.out.println("Please give the rating for the renter");
                                                    System.out.println("Please give urid");
                                                    int urid = scanner.nextInt();
                                                    scanner.nextLine();
                                                    System.out.println("Please give the rating for the renter");
                                                    int rating = scanner.nextInt();
                                                    scanner.nextLine();
                                                    System.out.println("Please give the review for the renter");
                                                    String body = scanner.nextLine();
                                                    String date = "2020-12-12";
                                                    System.out.println(urid);
                                                    System.out.println(uid);
                                                    System.out.println(rid);
                                                    System.out.println(rating);
                                                    System.out.println(body);
                                                    System.out.println(date);

                                                    UserRatingDao.createUserRating(urid, uid, rid, rating, body,
                                                            date);
                                                    System.out.println("Review added for the renter");
                                                    break;

                                                case 4:
                                                    listing_entered = 1;
                                                    break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        System.out.println(
                                                "Create Listing: id, hid, type, price, latitude, longitude, address, postal, city, country");
                                        scanner.nextLine();
                                        int lidx = scanner.nextInt();
                                        scanner.nextLine();
                                        int hid = scanner.nextInt();
                                        scanner.nextLine();
                                        String type = scanner.nextLine();
                                        double price = scanner.nextDouble();
                                        scanner.nextLine();
                                        double latitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        double longitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        String address2 = scanner.nextLine();
                                        String postal = scanner.nextLine();
                                        String city = scanner.nextLine();
                                        String country = scanner.nextLine();
                                        Listing listing = new Listing(lidx, hid, type, price, latitude, longitude,
                                                address2, postal,
                                                city,
                                                country);
                                        ListingDao.createListing(listing);
                                        System.out.println("Here are your updated Listings");
                                        listings2 = ListingDao.readListingforHost(uid);
                                        for (Listing l : listings2) {
                                            System.out.println(l);
                                        }
                                        break;

                                    case 5:
                                        System.out.println(
                                                "Update Listing: lid, hid, type, price, latitude, longitude, address, postal, city, country");
                                        lid = scanner.nextInt();
                                        scanner.nextLine();
                                        hid = scanner.nextInt();
                                        scanner.nextLine();
                                        type = scanner.nextLine();
                                        price = scanner.nextDouble();
                                        scanner.nextLine();
                                        latitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        longitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        address2 = scanner.nextLine();
                                        postal = scanner.nextLine();
                                        city = scanner.nextLine();
                                        country = scanner.nextLine();
                                        if (hid != uid) {
                                            System.out.println("You are not the host of this listing");
                                            break;
                                        }
                                        ListingDao.updateListing(lid, hid, type, price, latitude, longitude, address2,
                                                postal, city, country);
                                        System.out.println("Here are your updated Listings");
                                        listings2 = ListingDao.readListingforHost(uid);
                                        for (Listing l : listings2) {
                                            System.out.println(l);
                                        }
                                        break;

                                    case 6:
                                        System.out.println("Delete Listing: lid");
                                        lid = scanner.nextInt();
                                        ListingDao.deleteListing(lid);
                                        System.out.println("Here are your updated Listings");
                                        listings2 = ListingDao.readListingforHost(uid);
                                        for (Listing l : listings2) {
                                            System.out.println(l);
                                        }
                                        break;

                                    // case 7:
                                    // System.out.println("Add amentities: lid, amenity");
                                    // lid = scanner.nextInt();
                                    // scanner.nextLine();
                                    // String amenity = scanner.nextLine();
                                    // ListingDao.addAmenityforListing(lid, amenity);
                                    // System.out.println("Here are your updated Listings");
                                    // listings2 = ListingDao.readListingforHost(uid);
                                    // for (Listing l : listings2) {
                                    // System.out.println(l);
                                    // }
                                    case 9:
                                        host_listing = 1;
                                        System.out.println("You are now on the home-page");
                                        break;
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Book a listing");
                            System.out.println("Please select a listing from the following listings");
                            ArrayList<Listing> listings5 = ListingDao.readListing();
                            for (Listing l : listings5) {
                                System.out.println(l);
                            }
                            System.out.println("Please enter the lid of the listing you want to view");
                            int lid2 = scanner.nextInt();
                            int listing_entered2 = 0;
                            while (listing_entered2 == 0) {
                                System.out.println("Please enter your choice:");
                                System.out.println(
                                        "1. Book the listing 2. See Review for the Listing 3. Go back to see other Listings");
                                scanner = new Scanner(System.in);
                                int x3 = scanner.nextInt();
                                switch (x3) {
                                    case 1:
                                        System.out.println("Please enter bid");
                                        int bid = scanner.nextInt();
                                        System.out.println("Please enter the lid of the listing you want to book");
                                        int lid = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println(
                                                "Please enter the start date of your booking in the format YYYY-MM-DD");
                                        String start = scanner.nextLine();
                                        System.out.println(
                                                "Please enter the end date of your booking in the format YYYY-MM-DD");
                                        String end = scanner.nextLine();
                                        System.out.println("Please enter your credit card information");
                                        String ccInfo = scanner.nextLine();
                                        scanner.nextLine();
                                        String book_date = "2020-11-11";
                                        double cost = ListingDao.getPricing(lid);
                                        System.out.println("The cost of your booking is: " + cost);
                                        System.out.println("Please enter 1 to confirm your booking or 0 to cancel");
                                        int confirm = scanner.nextInt();
                                        if (confirm == 1) {
                                            Booking booking = new Booking(bid, lid, uid, book_date, start, end, cost,
                                                    ccInfo,
                                                    false);
                                            BookingDao.createBooking(booking);
                                            System.out.println("Your booking has been confirmed");
                                        } else {
                                            System.out.println("Your booking has been cancelled");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Here are the reviews for the listing");
                                        ArrayList<ListingRating> reviews = ListRatingDao
                                                .readListRatingforListing(lid2);
                                        for (ListingRating l : reviews) {
                                            System.out.println(l);
                                        }
                                        break;

                                    case 3:
                                        listing_entered2 = 1;
                                        System.out.println("Please select a listing from the following listings");
                                        break;
                                }
                            }

                            break;

                        case 7:
                            System.out.println("Here are your Bookings");
                            BookingDao.readBookingforUser(uid);
                            int booking = 0;

                            while (booking == 0) {
                                System.out.println("Please enter your choice:");
                                System.out.println(
                                        "1. Cancel a booking 2. update a booking 3. Give Review for the listing 9. Go back to home-page");
                                scanner = new Scanner(System.in);
                                int x4 = scanner.nextInt();
                                switch (x4) {
                                    case 1:
                                        System.out.println("Please enter the bid of the booking you want to cancel");
                                        int bid2 = scanner.nextInt();
                                        BookingDao.deleteBooking(bid2);
                                        System.out.println("Your booking has been cancelled");
                                        System.out.println("Here are your updated Bookings");
                                        BookingDao.readBookingforUser(uid);
                                        break;
                                    case 9:
                                        booking = 1;
                                        System.out.println("You are now on the home-page");
                                        break;
                                    case 2:
                                        System.out.println("Please enter the bid of the booking you want to update");
                                        int bid3 = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println(
                                                "Please enter the start date of your booking in the format YYYY-MM-DD");
                                        String start2 = scanner.nextLine();
                                        System.out.println(
                                                "Please enter the end date of your booking in the format YYYY-MM-DD");
                                        String end2 = scanner.nextLine();

                                        String book_date2 = "2020-11-11";
                                        System.out.println("Please enter 1 to update your booking or 0 to cancel");
                                        int confirm2 = scanner.nextInt();
                                        if (confirm2 == 1) {
                                            BookingDao.updateBooking(bid3, book_date2, start2, end2, false);
                                            System.out.println("Your booking has been confirmed");
                                        } else {
                                            System.out.println("Your booking has been cancelled");
                                        }
                                        System.out.println("Here are your updated Bookings");
                                        BookingDao.readBookingforUser(uid);
                                        break;

                                    case 3:

                                        System.out.println("Please review the listing");
                                        System.out.println("Please enter the lid of the listing you want to review");
                                        int lid3 = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Please enter the lrid for the listing you want to give");
                                        int lrid = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Please enter your rating for the listing");
                                        int rating = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Please enter your review for the listing");
                                        String body = scanner.nextLine();
                                        String date = "2020-11-11";
                                        ListRatingDao.createListRating(lrid, uid, lid3, rating, body, date);
                                }
                            }
                            break;

                        // case 6:
                        // System.out.println("Read Listing");
                        // ArrayList<Listing> listings = ListingDao.readListing();
                        // for (Listing l : listings) {
                        // System.out.println(l);
                        // }
                        // break;

                        // case 7:
                        // System.out.println(
                        // "Update Listing: lid, hid, type, price, latitude, longitude, address, postal,
                        // city, country");
                        // lid = scanner.nextInt();
                        // scanner.nextLine();
                        // hid = scanner.nextInt();
                        // scanner.nextLine();
                        // type = scanner.nextLine();
                        // price = scanner.nextDouble();
                        // scanner.nextLine();
                        // latitude = scanner.nextDouble();
                        // scanner.nextLine();
                        // longitude = scanner.nextDouble();
                        // scanner.nextLine();
                        // address = scanner.nextLine();
                        // postal = scanner.nextLine();
                        // city = scanner.nextLine();
                        // country = scanner.nextLine();
                        // ListingDao.updateListing(lid, hid, type, price, latitude, longitude, address,
                        // postal, city,
                        // country);
                        // break;

                        // case 8:
                        // System.out.println("Delete Listing: lid ");
                        // lid = scanner.nextInt();
                        // ListingDao.deleteListing(lid);
                        // break;

                        case 9:
                            logged_in = 1;
                            System.out.println("Logged out");
                            break;
                    }
                }
            }
        }
    }
}
