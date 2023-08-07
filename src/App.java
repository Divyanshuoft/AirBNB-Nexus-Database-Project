import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static int exit_program = 0;
    public static int uid = 0;
    static LocalDate currentDate = LocalDate.now();

    // Define the date format
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Format the current date as per the defined format
    static String present_day = currentDate.format(formatter);

    // Print the present date
    public static void main(String[] args) throws Exception {
        ListRatingDao.CombinedBodyForListing(53);
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
                System.out.println("name, address, dob, occupation, sin, payment_info");
                scanner.nextLine();
                String name = scanner.nextLine();
                int id = name.hashCode();
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
                            "2. Read User 3. Search Listing 5. Your Listings 6. Book a new Listing 7. View your Bookings 8. View Amentities for hosts 10. View reviews 9. Logout");
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
                        case 3:
                            System.out.println("Search Listing");
                            int search_id = 0;
                            while (search_id == 0) {
                                System.out.println("Enter your choice:");
                                System.out.println(
                                        "1. Total booking for a city with a zipcode");
                                int search = scanner.nextInt();
                                scanner.nextLine();
                                switch (search) {
                                    case 1:
                                        System.out.println("Enter city");
                                        String city = scanner.nextLine();
                                        System.out.println("Enter Zipcode");
                                        String zipcode = scanner.nextLine();
                                        BookingDao.totalBookingForCityZip(zipcode, city);
                                        break;

                                    // case 1:
                                    // System.out.println("Enter city");
                                    // String city = scanner.nextLine();
                                    // System.out.println("Enter start date");
                                    // String start_date = scanner.nextLine();
                                    // System.out.println("Enter end date");
                                    // String end_date = scanner.nextLine();
                                    // BookingDao.totalBookingForCity(start_date, end_date, city);
                                    // break;
                                    // case 7:
                                    // System.out.println("Enter year");
                                    // int year = scanner.nextInt();
                                    // scanner.nextLine();
                                    // BookingDao.asdasd12(year);
                                    // break;
                                    // case 5:
                                    // System.out.println("Enter start date");
                                    // String start_date = scanner.nextLine();
                                    // System.out.println("Enter end date");
                                    // String end_date = scanner.nextLine();
                                    // BookingDao.readBooking2(start_date, end_date);
                                    // break;
                                    // case 1:
                                    // System.out.println("Top 10% of hosts");
                                    // System.out.println("Enter city");
                                    // String city = scanner.nextLine();
                                    // System.out.println("Enter country");
                                    // String country = scanner.nextLine();
                                    // ListingDao.TenPercentListing(city, country);
                                    // break;
                                    // case 6:
                                    // System.out.println("Enter start date");
                                    // String start_date = scanner.nextLine();
                                    // System.out.println("Enter end date");
                                    // String end_date = scanner.nextLine();
                                    // System.out.println("Enter city");
                                    // String city = scanner.nextLine();
                                    // BookingDao.asdasd(start_date, end_date, city);
                                    // break;
                                    // case 2:
                                    // BookingDao.mostcancellation();
                                    // break;

                                    // case 3:
                                    // System.out.println("Enter postal code");
                                    // String postal_code = scanner.nextLine();
                                    // ArrayList<Listing> xasd = ListingDao.readListingPostal(postal_code);
                                    // for (Listing l : xasd) {
                                    // System.out.println(l);
                                    // }
                                    // break;

                                    // case 4:
                                    // System.out.println("Enter start date");
                                    // String start_date = scanner.nextLine();
                                    // System.out.println("Enter end date");
                                    // String end_date = scanner.nextLine();
                                    // ArrayList<Calender> xasas = CalenderDao.readCalender();
                                    // for (Calender l : xasas) {
                                    // String s = l.getStart();
                                    // String e = l.getEnd();
                                    // LocalDate startDate1 = LocalDate.parse(start_date);
                                    // LocalDate endDate1 = LocalDate.parse(end_date);
                                    // LocalDate startDate2 = LocalDate.parse(s);
                                    // LocalDate endDate2 = LocalDate.parse(e);

                                    // // Check if (start1, end1) lies within (start2, end2)
                                    // boolean isWithin = startDate2.isAfter(startDate1)
                                    // && endDate2.isBefore(endDate1);

                                    // // Print the result
                                    // if (isWithin) {
                                    // System.out.println(l);
                                    // }
                                    // }
                                    // break;
                                    // case 5:
                                    // System.out.println("Enter country");
                                    // String country = scanner.nextLine();
                                    // ListingDao.ListingHostCountryRanking(country);
                                    // break;
                                    // case 6:
                                    // System.out.println("Enter city");
                                    // String city = scanner.nextLine();
                                    // ListingDao.ListingHostCityRanking(city);
                                    // break;

                                    // case 6:
                                    // System.out.println("Enter country");
                                    // String country = scanner.nextLine();
                                    // ArrayList<Listing> listingsc = ListingDao.countrysearch(country);
                                    // System.out.println("Here are the listings in " + country);
                                    // int count = 0;
                                    // for (Listing l : listingsc) {
                                    // System.out.println(l);
                                    // count++;
                                    // }
                                    // System.out.println("Total listings: " + count);
                                    // break;

                                    // case 7:
                                    // System.out.println("Enter city and country");
                                    // String city = scanner.nextLine();
                                    // String country1 = scanner.nextLine();
                                    // count = 0;
                                    // System.out.println("Here are the listings in " + city + ", " + country1);
                                    // ArrayList<Listing> listingscc = ListingDao.countrycitysearch(country1, city);
                                    // for (Listing l : listingscc) {
                                    // System.out.println(l);
                                    // count++;

                                    // }
                                    // System.out.println("Total listings: " + count);

                                    // break;

                                    // case 8:
                                    // System.out.println("Enter city, postal code and country");
                                    // String city1 = scanner.nextLine();
                                    // String postal_code = scanner.nextLine();
                                    // String country2 = scanner.nextLine();
                                    // count = 0;
                                    // System.out.println("Here are the listings in " + city1 + ", " + postal_code
                                    // + ", " + country2);
                                    // ArrayList<Listing> listingscpc = ListingDao.countrycitypostalsearch(
                                    // country2, city1, postal_code);
                                    // for (Listing l : listingscpc) {
                                    // System.out.println(l);
                                    // count++;

                                    // }
                                    // System.out.println("Total listings: " + count);

                                    // break;
                                    // case 1:
                                    // System.out.println("Enter latitude and longitude");
                                    // double latitude2 = scanner.nextDouble();
                                    // double longitude2 = scanner.nextDouble();
                                    // System.out.println("Enter distance");
                                    // double distance = scanner.nextDouble();
                                    // ArrayList<Listing> listingsi = ListingDao.readListings(latitude2, longitude2,
                                    // distance);
                                    // for (Listing l : listingsi) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                    // case 2:
                                    // ArrayList<Listing> listingsp =
                                    // ListingDao.readListingsPriceWiseSortLowtoHigh();
                                    // System.out.println("Here are the listings sorted by price low to high");
                                    // for (Listing l : listingsp) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                    // case 3:
                                    // System.out.println("Enter postal code");
                                    // String postal_code = scanner.nextLine();
                                    // ArrayList<Listing> listingspc = ListingDao.postalcodesearch(postal_code);
                                    // for (Listing l : listingspc) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                    // case 4:
                                    // System.out.println("Enter address");
                                    // String address = scanner.nextLine();
                                    // ArrayList<Listing> listingsa = ListingDao.addresssearch(address);
                                    // for (Listing l : listingsa) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                    // case 5:
                                    // ArrayList<Listing> listingsph = ListingDao.pricehigtolow();
                                    // System.out.println("Here are the listings sorted by price high to low");
                                    // for (Listing l : listingsph) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                }
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
                                        "1. View Listing 2. Create new Listing 4. Make a Listing unavailable 5. Update existing Listing 6. Delete a listing 7. Add amentities 9. Go back to home-page");
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
                                                                ListingAmentitiesDao.mostCommonAmmenitites();
                                                                System.out.println(
                                                                        "Here are all the amenities you can add");
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
                                                                System.out.println(
                                                                        "View updated Amentities for your Listing");
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
                                                    String date = present_day;
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
                                                "Please enter the details to create a new listing");
                                        int hid = uid;
                                        System.out.println(
                                                "Please enter the type of listing [ apartments, houses, rooms ]");
                                        String type = scanner.nextLine();
                                        scanner.nextLine();
                                        System.out.println("Please enter the latitude [ -90, 90 ]]");
                                        double latitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        System.out.println("Please enter the longitude [ -180, 180 ]");
                                        double longitude = scanner.nextDouble();
                                        scanner.nextLine();
                                        int lidx = (int) (latitude * 100000 + longitude * 100000
                                                + Math.random() * 1000);
                                        System.out.println("Please enter the address [ number, street ]");
                                        String address2 = scanner.nextLine();
                                        System.out.println("Please enter the postal [ A1A1A1 ]");
                                        String postal = scanner.nextLine();
                                        System.out.println("Please enter the city [ city ]");
                                        String city = scanner.nextLine();
                                        System.out.println("Please enter the country [ country ]");
                                        String country = scanner.nextLine();
                                        System.out.println("Based on our databse, we recommend the following price");
                                        if (ListingDao.givePriceCityTypePostal(city, type, postal) != 0) {
                                            System.out.println("The price for the city, type and postal is: "
                                                    + ListingDao.givePriceCityTypePostal(city, type, postal));
                                        } else if (ListingDao.givePriceCity(city) != 0) {
                                            System.out.println("The price for the city is: "
                                                    + ListingDao.givePriceCity(city));
                                        } else {
                                            System.out.println("The average city price in our databse is "
                                                    + ListingDao.giveAvgListingPrice());
                                        }
                                        System.out.println("Please enter the price that you want to list");
                                        double price = scanner.nextDouble();
                                        scanner.nextLine();
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
                                        System.out.println("Do you want to add amenities to your listing? [ y/n ]");
                                        ListingAmentitiesDao.findAvgAmmenityPrice();

                                        String amenity = scanner.nextLine();
                                        if (amenity.equals("y")) {
                                            listing_entered = 0;

                                            while (listing_entered == 0) {
                                                System.out.println("Please enter your choice:");
                                                System.out.println(
                                                        "1. View Amenitites 2. View Listing Reviews 3. Give Review for renter 4. Go back to Listing page");
                                                int x3 = scanner.nextInt();

                                                switch (x3) {
                                                    case 1:
                                                        System.out.println("View Amenitites for the listing");
                                                        ArrayList<ListingAmentities> amenities2 = ListingAmentitiesDao
                                                                .readAmenitiesforListingforlid(lidx);
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
                                                                    ListingAmentitiesDao.mostCommonAmmenitites();
                                                                    System.out.println(
                                                                            "Here are all the amenities you can add");
                                                                    amenities = AmenitiesDao.readAmenities();
                                                                    for (Amenities a : amenities) {
                                                                        System.out.println(a);
                                                                    }
                                                                    System.out.println(
                                                                            "Add new amenity from above: aid");
                                                                    int aid1 = scanner.nextInt();
                                                                    scanner.nextLine();
                                                                    ListingAmentities amenity2 = new ListingAmentities(
                                                                            lidx,
                                                                            aid1);
                                                                    System.out.println(
                                                                            "View updated Amentities for your Listing");
                                                                    ListingAmentitiesDao
                                                                            .createListingAmentities(amenity2);
                                                                    amenities2 = ListingAmentitiesDao
                                                                            .readAmenitiesforListingforlid(lidx);
                                                                    for (ListingAmentities a : amenities2) {
                                                                        System.out.println(a);
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println(
                                                                            "Here are all the amenities for your listing");
                                                                    amenities2 = ListingAmentitiesDao
                                                                            .readAmenitiesforListingforlid(lidx);
                                                                    for (ListingAmentities a : amenities2) {
                                                                        System.out.println(a);
                                                                    }
                                                                    System.out.println("Delete amenity: aid");
                                                                    aid1 = scanner.nextInt();
                                                                    ListingAmentitiesDao
                                                                            .deleteListingAmentities(aid1, lidx);
                                                                    System.out.println(
                                                                            "View updated Amentities for hosts");
                                                                    amenities2 = ListingAmentitiesDao
                                                                            .readAmenitiesforListingforlid(lidx);
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
                                                }
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        System.out.println("Make a listing unavailable: lid, date (YYYY-MM-DD)");
                                        int lida = scanner.nextInt();
                                        scanner.nextLine();
                                        String datea = scanner.nextLine();
                                        System.out.println("Enter the cid");
                                        int cida = scanner.nextInt();
                                        scanner.nextLine();
                                        ArrayList<Calender> calender2 = CalenderDao.readCalenderForLid(lida);
                                        int counter = 0;
                                        for (Calender c : calender2) {
                                            if (c.getLid() == lida) {
                                                // present date is present_date, teh start date is start adn end date is
                                                // end in teh calendar
                                                // if the present date is between start and end date then dont update
                                                // give code
                                                String start = c.getStart();
                                                String end = c.getEnd();
                                                // Get the current date
                                                // Parse the start and end dates from strings to LocalDate objects
                                                LocalDate startDate = LocalDate.parse(start);
                                                LocalDate endDate = LocalDate.parse(end);
                                                LocalDate presentDate2 = LocalDate.parse(datea);

                                                // Check if the present day is between the start and end dates
                                                boolean isBetween = presentDate2.isAfter(startDate)
                                                        && presentDate2.isBefore(endDate);

                                                // Print "yes" if present day is between start and end, otherwise print
                                                // "no"
                                                if (isBetween) {
                                                    counter = 1;
                                                }
                                            }
                                        }
                                        if (counter == 0) {
                                            CalenderDao.createCalender(cida, datea, datea, lida);
                                        } else {
                                            System.out.println(
                                                    "You cannot change the availability of the listing for this date as it's already booked");
                                        }
                                        break;

                                    case 5:
                                        System.out.println(
                                                "Update Listing: lid, hid, type, price, latitude, longitude, address, postal, city, country");
                                        lid = scanner.nextInt();
                                        scanner.nextLine();
                                        hid = uid;
                                        price = scanner.nextDouble();
                                        scanner.nextLine();
                                        if (hid != uid) {
                                            System.out.println("You are not the host of this listing");
                                            break;
                                        }
                                        // check if teh listing is there in the calender for lid
                                        // if yes then dont update
                                        // if no then update
                                        ArrayList<Calender> calender = CalenderDao.readCalenderForLid(lid);
                                        for (Calender c : calender) {
                                            if (c.getLid() == lid) {
                                                // present date is present_date, teh start date is start adn end date is
                                                // end in teh calendar
                                                // if the present date is between start and end date then dont update
                                                // give code
                                                String start = c.getStart();
                                                String end = c.getEnd();
                                                String[] start_date = start.split("-");
                                                String[] end_date = end.split("-");
                                                String present_date = present_day;
                                                String[] presentdsd = present_date.split("-");
                                                // Get the current date
                                                LocalDate presentDate = LocalDate.now();

                                                // Parse the start and end dates from strings to LocalDate objects
                                                LocalDate startDate = LocalDate.parse(start);
                                                LocalDate endDate = LocalDate.parse(end);

                                                // Check if the present day is between the start and end dates
                                                boolean isBetween = presentDate.isAfter(startDate)
                                                        && presentDate.isBefore(endDate);

                                                // Print "yes" if present day is between start and end, otherwise print
                                                // "no"
                                                if (isBetween) {
                                                    System.out.println("You cannot update the listing as it is booked");
                                                } else {
                                                    ListingDao.updateListing(lid, hid, price);
                                                    System.out.println("Here are your updated Listings");
                                                    listings2 = ListingDao.readListingforHost(uid);
                                                    for (Listing l : listings2) {
                                                        System.out.println(l);
                                                    }
                                                }
                                            }
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
                                        String book_date = present_day;
                                        double cost = ListingDao.getPricing(lid);
                                        System.out.println("The cost of your booking is: " + cost);
                                        System.out.println("Please enter the cid of the listing you want to book");
                                        int cidbooking = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Please enter 1 to confirm your booking or 0 to cancel");
                                        // please print the year, month and days for this start
                                        // and end date
                                        String[] dateParts = start.split("-");
                                        System.out.println("Year: " + dateParts[0]);
                                        System.out.println("Month: " + dateParts[1]);
                                        System.out.println("Day: " + dateParts[2]);
                                        int confirm = scanner.nextInt();
                                        if (confirm == 1) {
                                            Booking booking = new Booking(bid, lid, uid, book_date, start, end, cost,
                                                    ccInfo,
                                                    false);
                                            BookingDao.createBooking(booking);
                                            CalenderDao.createCalender(cidbooking, start, end, lid);
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
                                        scanner.nextLine();
                                        // enter the cid of the booking
                                        System.out.println("Please enter the cid of the booking you want to cancel");
                                        int cidcancel = scanner.nextInt();
                                        scanner.nextLine();
                                        CalenderDao.deleteCalender(cidcancel);
                                        BookingDao.cancelBooking(bid2);
                                        System.out.println("Your booking has been cancelled");
                                        break;
                                    case 9:
                                        booking = 1;
                                        System.out.println("You are now on the home-page");
                                        break;
                                    case 2:
                                        System.out.println("Please enter the bid of the booking you want to update");
                                        int bid3 = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Please enter the cid of the booking you want to update");
                                        int cidupdate = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println(
                                                "Please enter the start date of your booking in the format YYYY-MM-DD");
                                        String start2 = scanner.nextLine();
                                        System.out.println(
                                                "Please enter the end date of your booking in the format YYYY-MM-DD");
                                        String end2 = scanner.nextLine();

                                        String book_date2 = present_day;
                                        System.out.println("Please enter 1 to update your booking or 0 to cancel");
                                        int confirm2 = scanner.nextInt();
                                        if (confirm2 == 1) {
                                            BookingDao.updateBooking(bid3, book_date2, start2, end2, false);
                                            CalenderDao.updateCalender(cidupdate, start2, end2);
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
                                        String date = present_day;
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
