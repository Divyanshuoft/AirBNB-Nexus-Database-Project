import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static int exit_program = 0;
    public static int uid = 0;
    static LocalDate currentDate = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static String present_day = currentDate.format(formatter);

    public static void main(String[] args) throws Exception {
        while (exit_program == 0) {
            int logged_in = 0;
            System.out.println("\n********************************************");
            System.out.println("Welcome to MyBNB! ~ by Divyansh Kachchhava\n");
            System.out.println("Please choose an option:");
            System.out.println("1. Login \n2. Register\n3. Exit");
            System.out.print("\nEnter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice");
                continue;
            }
            if (choice == 3) {
                System.out.println("Goodbye!");
                exit_program = 1;
                break;
            } else if (choice == 2) {
                System.out.println("\n********************************************");
                System.out.println("Please register to continue");
                System.out.println("Please enter your username: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Please enter your password: [ONLY INTEGER PASSWORDS ARE ALLOWED]");
                int password = scanner.nextInt();
                scanner.nextLine();
                int id = password;
                System.out.println("Please enter your address: ");
                String address = scanner.nextLine();
                System.out.println("Please enter your date of birth in the format yyyy-mm-dd: ");
                String dob = scanner.nextLine();
                int age = 0;
                String[] dob_split = dob.split("-");
                int year = Integer.parseInt(dob_split[0]);
                int month = Integer.parseInt(dob_split[1]);
                int day = Integer.parseInt(dob_split[2]);
                if (month > currentDate.getMonthValue()) {
                    age = currentDate.getYear() - year - 1;
                } else if (month == currentDate.getMonthValue()) {
                    if (day > currentDate.getDayOfMonth()) {
                        age = currentDate.getYear() - year - 1;
                    } else {
                        age = currentDate.getYear() - year;
                    }
                } else {
                    age = currentDate.getYear() - year;
                }
                if (age >= 18) {
                    System.out.println(
                            "You are eligible to register as your age is " + age + " which is greater than 18");
                } else {
                    System.out.println(
                            "You are not eligible to register as your age is " + age + " which is less than 18");
                    exit_program = 1;
                    break;
                }
                System.out.println("Please enter your occupation: ");
                String occupation = scanner.nextLine();
                System.out.println("Please enter your social insurance number: ");
                String sin = scanner.nextLine();
                System.out.println("Please enter your payment information: ");
                String payment_info = scanner.nextLine();
                Employee employee = new Employee(id, name, address, dob, occupation, sin, payment_info);
                EmployeeDao.createEmployee(employee);
                System.out.println(name);
            } else {
                System.out.println("\n********************************************");

                System.out.println("\nPlease enter your credentials to login");
                System.out.println("Enter your UID/Password");
                uid = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter your username (name) which you received while registering");
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

                    System.out.println("\n********************************************");
                    System.out.println("\nWelcome " + username + "!");
                    System.out.println("\nToday date is " + present_day);
                    System.out.println("\nPlease choose an option:");
                    System.out.println(
                            "1. Get User from UID\n2. Get All user list\n3. Search Listing\n4. View Reports\n5. Your Listings\n6. Book a new Listing\n7. View your Bookings\n8. View Amentities for hosts\n10. View reviews\n9. Logout\n11. Delete your account\n");
                    System.out.print("Enter your choice: ");
                    scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\n********************************************");
                            System.out.println("You are on the Get User from UID page\n");
                            System.out.println("Please enter the UID of the user you want to search: ");
                            int uid21 = scanner.nextInt();
                            scanner.nextLine();
                            String flag = EmployeeDao.getEmployeeName(uid21);
                            System.out.println("The user with UID " + uid21 + " is " + flag);
                            break;
                        case 2:
                            ArrayList<Employee> employees = EmployeeDao.readEmployees();
                            for (Employee employee : employees) {
                                System.out.println(employee);
                            }
                            break;
                        case 4:
                            int kp = 0;
                            while (kp == 0) {
                                System.out.println("\n********************************************");
                                System.out.println("You are on the View Reports page\n");
                                System.out.println("Please choose an option:");
                                System.out.println(
                                        "1. Ranking of renters in a specific date range by city in specific time");
                                System.out.println("2. Total number of bookings in a specific date range by city");
                                System.out
                                        .println("3. Total number of bookings in a city by postal code");
                                // System.out.println("3. total number of listings per country and city and
                                // postal code");
                                System.out.println(
                                        "4. Hosts which have more than 10% of the number of listings in the city and country");
                                System.out.println("5. Total number of bookings in a specific date range by city");
                                System.out.println("6. Most cancellations by an host or a renter");
                                System.out.println("7. Hosts which have the most booking in the country");
                                System.out.println("8. Hosts which have the most booking in the city");
                                System.out.println("9. total number of listings per country");
                                System.out.println("10. total number of listings per country and city");
                                System.out
                                        .println("11. total number of listings per country and city and postal code");
                                System.out
                                        .println("12. Word cloud for each listing");
                                System.out
                                        .println("13 Go Back to Dashboard\n");
                                System.out.print("Enter your choice: ");
                                int choice2 = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice2) {
                                    case 5:
                                        System.out.println("Enter year");
                                        int year = scanner.nextInt();
                                        scanner.nextLine();
                                        BookingDao.asdasd12(year);
                                        break;
                                    case 13:
                                        kp = 1;
                                        break;
                                    case 12:
                                        ArrayList<Integer> listingsp = new ArrayList<Integer>();
                                        listingsp = BookingDao.getListingIds();
                                        for (Integer listing : listingsp) {
                                            ListRatingDao.CombinedBodyForListing(listing);
                                        }
                                        break;
                                    case 1:
                                        System.out.println("Enter start date");
                                        String start_date = scanner.nextLine();
                                        System.out.println("Enter end date");
                                        String end_date = scanner.nextLine();
                                        System.out.println(
                                                "Ranking of renters in a specific date range by city in specific time\n");
                                        ArrayList<String> listings = new ArrayList<String>();
                                        listings = ListingDao.citysearch();
                                        for (String listing : listings) {
                                            BookingDao.asdasd(start_date, end_date, listing);
                                        }

                                        System.out.println(
                                                "\nRanking of renters in a specific date range in specific time\n");
                                        BookingDao.asdasd2(start_date, end_date);
                                        break;
                                    // case 2:
                                    // System.out.println("Enter postal code");
                                    // String postal_code = scanner.nextLine();
                                    // ArrayList<Listing> xasd = ListingDao.readListingPostal(postal_code);
                                    // for (Listing l : xasd) {
                                    // System.out.println(l);
                                    // }
                                    // break;
                                    case 4:
                                        System.out.println("Top 10% of hosts");
                                        listings = new ArrayList<String>();
                                        listings = ListingDao.ListingHostCountryRanking2();
                                        for (String listing : listings) {
                                            String[] ccc = listing.split(" ");
                                            String city = ccc[0];
                                            String country = ccc[1];
                                            ListingDao.TenPercentListing(city, country);
                                        }
                                        // System.out.println("Enter city");
                                        // String city3 = scanner.nextLine();
                                        // System.out.println("Enter country");
                                        // String country = scanner.nextLine();
                                        // ListingDao.TenPercentListing(city3, country);
                                        break;
                                    case 6:
                                        BookingDao.mostcancellation();
                                        BookingDao.mostcancellationrid();
                                        break;
                                    case 7:
                                        listings = ListingDao.citysearch2();
                                        System.out.println("\n********************************************\n");
                                        System.out.println("Ranking of host by country");
                                        for (String listing : listings) {
                                            ListingDao.ListingHostCountryRanking(listing);
                                            System.out.print(" in " + listing + "\n");
                                        }
                                        break;
                                    case 8:
                                        listings = ListingDao.citysearch();
                                        System.out.println("\n********************************************\n");
                                        System.out.println("Ranking of host by city");
                                        for (String listing : listings) {
                                            ListingDao.ListingHostCityRanking(listing);
                                            System.out.print(" in " + listing + "\n");
                                        }
                                        break;

                                    case 9:
                                        listings = ListingDao.citysearch2();
                                        int count = 0;
                                        System.out.println("\n********************************************\n");
                                        System.out.println("Total number of listings per country\n");
                                        for (String l2 : listings) {
                                            ArrayList<Listing> listingsc = ListingDao.countrysearch(l2);
                                            System.out.println("Here are the listings in " + l2);
                                            count = 0;
                                            for (Listing l : listingsc) {
                                                System.out.println(l);
                                                count++;
                                            }
                                            System.out.println("Total listings: " + count + "\n");
                                        }
                                        break;
                                    case 10:
                                        System.out.println("Enter city and country");
                                        String city31 = scanner.nextLine();
                                        String country1 = scanner.nextLine();
                                        count = 0;
                                        System.out.println("Here are the listings in " + city31 + ", " + country1);
                                        ArrayList<Listing> listingscc = ListingDao.countrycitysearch(country1, city31);
                                        for (Listing l : listingscc) {
                                            System.out.println(l);
                                            count++;

                                        }
                                        System.out.println("Total listings: " + count);

                                        break;

                                    case 11:
                                        System.out.println("Enter city, postal code and country");
                                        String city1 = scanner.nextLine();
                                        String postal_code2 = scanner.nextLine();
                                        String country2 = scanner.nextLine();
                                        count = 0;
                                        System.out.println("Here are the listings in " + city1 + ", " + postal_code2
                                                + ", " + country2);
                                        ArrayList<Listing> listingscpc = ListingDao.countrycitypostalsearch(
                                                country2, city1, postal_code2);
                                        for (Listing l : listingscpc) {
                                            System.out.println(l);
                                            count++;

                                        }
                                        System.out.println("Total listings: " + count);

                                        break;
                                    case 3:
                                        System.out.println("Enter city");
                                        String city = scanner.nextLine();
                                        System.out.println("Enter Zipcode");
                                        String zipcode = scanner.nextLine();
                                        BookingDao.totalBookingForCityZip(zipcode, city);
                                        break;
                                    case 2:
                                        System.out.println("Enter city");
                                        String city13 = scanner.nextLine();
                                        System.out.println("Enter start date");
                                        String start_date13 = scanner.nextLine();
                                        System.out.println("Enter end date");
                                        String end_date13 = scanner.nextLine();
                                        BookingDao.totalBookingForCity(start_date13, end_date13, city13);
                                        break;
                                    // System.out.println("Here are the reviews for the listing");
                                    // ArrayList<ListingRating> reviesws = ListRatingDao
                                    // .readListRatingforListing(lid2);
                                    // for (ListingRating l : reviews) {
                                    // System.out.println(l);
                                    // }

                                    // System.out.println("These are the top 5 word clouds for this listing");
                                    // ListRatingDao.CombinedBodyForListing(lid2);
                                }
                            }
                            break;
                        case 11:
                            System.out.println("Delete your account");
                            System.out.println("Are you sure you want to delete your account? (y/n)");
                            scanner.nextLine();
                            String delete = scanner.nextLine();

                            if (delete.equals("y")) {
                                EmployeeDao.deleteEmployee(uid);
                                System.out.println("Your account has been deleted");
                                logged_in = 1;
                                break;
                            } else {
                                System.out.println("Your account has not been deleted");
                                logged_in = 0;
                                break;
                            }

                            // case 2:
                            // System.out.println("Read User");
                            // ArrayList<Employee> employees = EmployeeDao.readEmployees();
                            // for (Employee e : employees) {
                            // System.out.println(e);
                            // }
                            // break;
                        case 3:
                            System.out.println("\n********************************************\n");

                            System.out.println("Search Listing");
                            int search_id = 0;
                            while (search_id == 0) {
                                System.out.println(
                                        "1. Search with master filters\n2. Filter with lattitudes and longitudes\n3. Filer price low to high\n4. Filter price high to low\n5. Filter by Postal\n6. Find Address\n7. Book the listing\n8. So to Database Menu ");
                                System.out.print("\nEnter your choice: ");
                                int search = scanner.nextInt();
                                scanner.nextLine();
                                switch (search) {
                                    case 8:
                                        search_id = 1;
                                        break;
                                    case 7:
                                        System.out.println("Book a listing");
                                        System.out.println(
                                                "Please select a listing from the above listing which you have searched with filters");
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
                                                    int lid = lid2;
                                                    int bid = 100 * lid2 + 10 * uid;
                                                    if (ListingDao.getuser(lid) == uid) {
                                                        System.out.println("You cannot book your own listing");
                                                        break;
                                                    }
                                                    scanner.nextLine();
                                                    System.out.println(
                                                            "Please enter the start date of your booking in the format YYYY-MM-DD");
                                                    String start = scanner.nextLine();
                                                    System.out.println(
                                                            "Please enter the end date of your booking in the format YYYY-MM-DD");
                                                    String end = scanner.nextLine();
                                                    ArrayList<Calender> calender = CalenderDao.readCalenderForLid(lid);
                                                    int counter = 0;
                                                    for (Calender c : calender) {
                                                        if (c.getLid() == lid) {

                                                            String start2 = c.getStart();
                                                            String end2 = c.getEnd();

                                                            String[] start_date = start.split("-");
                                                            String[] end_date = end.split("-");
                                                            String[] start_date2 = start2.split("-");
                                                            String[] end_date2 = end2.split("-");

                                                            String present_date = present_day;

                                                            // Parse the start and end dates from strings to LocalDate
                                                            // objects
                                                            LocalDate startDate = LocalDate.parse(start);
                                                            LocalDate endDate = LocalDate.parse(end);

                                                            LocalDate startDate2 = LocalDate.parse(start2);
                                                            LocalDate endDate2 = LocalDate.parse(end2);

                                                            // Check if the the user selected date is between the start
                                                            // and end
                                                            // dates
                                                            boolean isBetween = startDate.isAfter(startDate2)
                                                                    || endDate.isBefore(endDate2);

                                                            // Print "yes" if present day is between start and end,
                                                            // otherwise print
                                                            // "no"
                                                            if (isBetween) {
                                                                counter++;
                                                            }
                                                        }
                                                    }
                                                    if (counter != 0) {
                                                        System.out
                                                                .println("You cannot book the listing as it is booked");
                                                        break;
                                                    }
                                                    System.out
                                                            .println("You can book the listing as it's not yet booked");
                                                    System.out
                                                            .println(
                                                                    "Please enter how would you like to pay? [VISA/Mastercard]");
                                                    String ccInfo = scanner.nextLine();
                                                    String book_date = present_day;
                                                    double cost = ListingDao.getPricing(lid);
                                                    System.out.println("How many guests are you booking for?");
                                                    int guests = scanner.nextInt();
                                                    scanner.nextLine();
                                                    cost = cost * guests;
                                                    System.out.println("The cost of your booking is: " + cost);
                                                    System.out.println(
                                                            "Please enter the cid of the listing you want to book");
                                                    int cidbooking = scanner.nextInt();
                                                    scanner.nextLine();
                                                    System.out.println(
                                                            "Please enter 1 to confirm your booking or 0 to cancel");
                                                    // please print the year, month and days for this start
                                                    // and end date
                                                    String[] dateParts = start.split("-");
                                                    System.out.println("Year: " + dateParts[0]);
                                                    System.out.println("Month: " + dateParts[1]);
                                                    System.out.println("Day: " + dateParts[2]);
                                                    int confirm = scanner.nextInt();
                                                    if (confirm == 1) {
                                                        Booking booking = new Booking(bid, lid, uid, book_date, start,
                                                                end, cost,
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

                                                    System.out.println(
                                                            "These are the top 5 word clouds for this listing");
                                                    ListRatingDao.CombinedBodyForListing(lid2);
                                                    break;

                                                case 3:
                                                    listing_entered2 = 1;
                                                    System.out.println(
                                                            "Please select a listing from the following listings");
                                                    break;
                                            }
                                        }

                                        break;

                                    case 1:

                                        System.out.println("Enter start date");
                                        String start_date = scanner.nextLine();
                                        System.out.println("Enter end date");
                                        String end_date = scanner.nextLine();
                                        System.out.println("Enter city");
                                        String city3 = scanner.nextLine();
                                        System.out.println("Enter Zipcode");
                                        String zipcode4 = scanner.nextLine();
                                        System.out.println("Enter Country");
                                        String countryq = scanner.nextLine();
                                        System.out.println("Enter price range (min)");
                                        double min = scanner.nextDouble();
                                        System.out.println("Enter price range (max)");
                                        double max = scanner.nextDouble();
                                        ArrayList<Integer> user_ids = new ArrayList<Integer>();
                                        System.out.println(
                                                "\nPlease enter the array for the aid you want to use: (a1, a2, a3)");
                                        Scanner scanner2 = new Scanner(System.in);
                                        String aid112 = scanner2.nextLine();
                                        String[] aid_split = aid112.split(",");
                                        for (int i = 0; i < aid_split.length; i++) {
                                            user_ids.add(Integer.parseInt(aid_split[i]));
                                        }
                                        ArrayList<Listing> tt = ListingDao.countrycitypostalsearch2(countryq, city3,
                                                zipcode4, start_date,
                                                end_date, min, max, user_ids, uid);
                                        for (Listing l : tt) {
                                            System.out.println(l);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Enter latitude and longitude");
                                        double latitude2 = scanner.nextDouble();
                                        double longitude2 = scanner.nextDouble();
                                        System.out.println("Enter distance");
                                        double distance = scanner.nextDouble();
                                        ArrayList<Listing> listingsi = ListingDao.readListings(latitude2, longitude2,
                                                distance);
                                        for (Listing l : listingsi) {
                                            System.out.println(l);
                                        }
                                        break;
                                    case 3:
                                        ArrayList<Listing> listingsp = ListingDao.readListingsPriceWiseSortLowtoHigh();
                                        System.out.println("Here are the listings sorted by price low to high");
                                        for (Listing l : listingsp) {
                                            System.out.println(l);
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Enter postal code");
                                        String postal_code = scanner.nextLine();
                                        ArrayList<Listing> listingspc = ListingDao.readListingPostal(postal_code);
                                        for (Listing l : listingspc) {
                                            System.out.println(l);
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Enter address");
                                        String address = scanner.nextLine();
                                        ArrayList<Listing> listingsa = ListingDao.addresssearch(address);
                                        for (Listing l : listingsa) {
                                            System.out.println(l);
                                        }
                                        break;
                                    case 4:
                                        ArrayList<Listing> listingsph = ListingDao.pricehigtolow();
                                        System.out.println("Here are the listings sorted by price high to low");
                                        for (Listing l : listingsph) {
                                            System.out.println(l);
                                        }
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
                                        System.out.println(
                                                "*****************************************************************");
                                        System.out.println("Here are the Listings which you have created");

                                        listings2 = ListingDao.readListingforHost(uid);
                                        for (Listing l : listings2) {
                                            System.out.println(l);
                                        }
                                        System.out.println("\nPlease enter the listing id you want to view");
                                        int lid = scanner.nextInt();
                                        int listing_entered = 0;
                                        if (ListingDao.getuser(lid) != uid) {
                                            System.out.println("You are not the host for this listing");
                                            listing_entered = 1;
                                        }
                                        while (listing_entered == 0) {
                                            System.out.print("Please enter your choice:");
                                            System.out.println(
                                                    "1. View Amenitites 2. View Listing Reviews 3. Give Review for renter 4. Go back to Listing page 5. View booking history for this listing 6. Delete booking for your listing");
                                            int x3 = scanner.nextInt();

                                            switch (x3) {
                                                case 2:
                                                    System.out.println("Here are the reviews for the listing");
                                                    ArrayList<ListingRating> reviews12 = ListRatingDao
                                                            .readListRatingforListing(lid);
                                                    for (ListingRating l : reviews12) {
                                                        System.out.println(l);
                                                    }

                                                    System.out.println(
                                                            "These are the top 5 word clouds for this listing");
                                                    ListRatingDao.CombinedBodyForListing(lid);
                                                case 6:
                                                    System.out.println("Here are the bookings for this listing");
                                                    ArrayList<Booking> bookings2 = BookingDao
                                                            .readBookingforListing(lid);
                                                    for (Booking b : bookings2) {
                                                        System.out.println(b);
                                                    }
                                                    System.out.println("Please enter the booking id");
                                                    int bid = scanner.nextInt();
                                                    BookingDao.deleteBooking(bid);
                                                    System.out
                                                            .println(
                                                                    "Here are the updated bookings after cancelling booking");
                                                    bookings2 = BookingDao.readBookingforListing(lid);
                                                    for (Booking b : bookings2) {
                                                        System.out.println(b);
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.println("Here is the booking history for this listing");
                                                    ArrayList<Booking> bookings21 = BookingDao
                                                            .readBookingforListing(lid);
                                                    for (Booking b : bookings21) {
                                                        System.out.println(b);
                                                    }
                                                    break;
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
                                                "Please enter the type of listing 1. apartments 2. houses 3. rooms");
                                        String type = "apartments";
                                        if (scanner.nextInt() == 2) {
                                            type = "houses";
                                        } else if (scanner.nextInt() == 3) {
                                            type = "rooms";
                                        }
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
                                        double m = 1;
                                        System.out.println(type);
                                        if (type.equals("apartments")) {
                                            System.out.println(
                                                    "As you have selected apartments, we recommend the price to be 1.5 times the average price of the city");
                                            m = 1.5;
                                        }
                                        if (type.equals("houses")) {
                                            System.out.println(
                                                    "As you have selected houses, we recommend the price to be 2 times the average price of the city");
                                            m = 2;
                                        }
                                        if (type.equals("rooms")) {
                                            System.out.println(
                                                    "As you have selected rooms, we recommend the price to be 1 times the average price of the city");
                                            m = 1;
                                        }
                                        if (latitude > 30 && latitude < 35 && longitude > 30 && longitude < 35) {
                                            System.out.println(
                                                    "As you have selected a listing in the Central, we recommend the price to be 3 times the average price of the city");
                                            m = 3;
                                        }
                                        if (ListingDao.givePriceCityTypePostal(city, type, postal) != 0) {
                                            System.out.println("The price for the city, type and postal is: "
                                                    + ListingDao.givePriceCityTypePostal(city, type, postal) * m);
                                        } else if (ListingDao.givePriceCity(city) != 0) {
                                            System.out.println("The price for the city is: "
                                                    + ListingDao.givePriceCity(city) * m);
                                        } else {
                                            System.out.println("The average city price in our database is "
                                                    + ListingDao.giveAvgListingPrice() * m);
                                        }
                                        System.out.println("Please enter the price that you want to list");
                                        System.out.println(
                                                "It is recommended to list the price as per the above recommendation");
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
                                        System.out.println(
                                                "If you add ammenities, the price will be added to the listing price, so you will make more profit");
                                        System.out.println("Do you want to add amenities to your listing? [ y/n ]\n");
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
                                                                    double pric = ListingDao.getPrice(lidx);
                                                                    // add ammenity price
                                                                    pric += pric + ListingDao.getPriceforaid(aid1);
                                                                    System.out.println(
                                                                            "You have increased the original price by "
                                                                                    + ListingDao.getPriceforaid(aid1));
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
                                                String start = c.getStart();
                                                String end = c.getEnd();
                                                LocalDate startDate = LocalDate.parse(start);
                                                LocalDate endDate = LocalDate.parse(end);
                                                LocalDate presentDate2 = LocalDate.parse(datea);
                                                boolean isBetween = presentDate2.isAfter(startDate)
                                                        && presentDate2.isBefore(endDate);
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
                                        if (ListingDao.getuser(lid) != uid) {
                                            System.out.println("You are not the owner of this listing");
                                            break;
                                        }
                                        ArrayList<Calender> calender = CalenderDao.readCalenderForLid(lid);
                                        for (Calender c : calender) {
                                            if (c.getLid() == lid) {
                                                String start = c.getStart();
                                                String end = c.getEnd();
                                                String[] start_date = start.split("-");
                                                String[] end_date = end.split("-");
                                                String present_date = present_day;
                                                String[] presentdsd = present_date.split("-");
                                                LocalDate presentDate = LocalDate.now();

                                                LocalDate startDate = LocalDate.parse(start);
                                                LocalDate endDate = LocalDate.parse(end);

                                                boolean isBetween = presentDate.isAfter(startDate)
                                                        && presentDate.isBefore(endDate);

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
                                        if (ListingDao.getuser(lid) != uid) {
                                            System.out.println("You are not the owner of this listing");
                                            break;
                                        }
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
                                if (l.getHid() != uid) {
                                    System.out.println(l);
                                }
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
                                        int lid = lid2;
                                        int bid = 100 * lid2 + 10 * uid;
                                        if (ListingDao.getuser(lid) == uid) {
                                            System.out.println("You cannot book your own listing");
                                            break;
                                        }
                                        scanner.nextLine();
                                        System.out.println(
                                                "Please enter the start date of your booking in the format YYYY-MM-DD");
                                        String start = scanner.nextLine();
                                        System.out.println(
                                                "Please enter the end date of your booking in the format YYYY-MM-DD");
                                        String end = scanner.nextLine();
                                        ArrayList<Calender> calender = CalenderDao.readCalenderForLid(lid);
                                        int counter = 0;
                                        for (Calender c : calender) {
                                            if (c.getLid() == lid) {

                                                String start2 = c.getStart();
                                                String end2 = c.getEnd();

                                                String[] start_date = start.split("-");
                                                String[] end_date = end.split("-");
                                                String[] start_date2 = start2.split("-");
                                                String[] end_date2 = end2.split("-");

                                                String present_date = present_day;

                                                // Parse the start and end dates from strings to LocalDate objects
                                                LocalDate startDate = LocalDate.parse(start);
                                                LocalDate endDate = LocalDate.parse(end);

                                                LocalDate startDate2 = LocalDate.parse(start2);
                                                LocalDate endDate2 = LocalDate.parse(end2);

                                                // Check if the the user selected date is between the start and end
                                                // dates
                                                boolean isBetween = startDate.isAfter(startDate2)
                                                        || endDate.isBefore(endDate2);

                                                // Print "yes" if present day is between start and end, otherwise print
                                                // "no"
                                                if (isBetween) {
                                                    counter++;
                                                }
                                            }
                                        }
                                        if (counter != 0) {
                                            System.out.println("You cannot book the listing as it is booked");
                                            break;
                                        }
                                        System.out.println("You can book the listing as it's not yet booked");
                                        System.out
                                                .println("Please enter how would you like to pay? [VISA/Mastercard]");
                                        String ccInfo = scanner.nextLine();
                                        String book_date = present_day;
                                        double cost = ListingDao.getPricing(lid);
                                        System.out.println("How many guests are you booking for?");
                                        int guests = scanner.nextInt();
                                        scanner.nextLine();
                                        cost = cost * guests;
                                        System.out.println("The cost of your booking is: " + cost);
                                        System.out.println(
                                                "Please enter the cid of the listing you want to book");
                                        int cidbooking = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println(
                                                "Please enter 1 to confirm your booking or 0 to cancel");
                                        // please print the year, month and days for this start
                                        // and end date
                                        String[] dateParts = start.split("-");
                                        System.out.println("Year: " + dateParts[0]);
                                        System.out.println("Month: " + dateParts[1]);
                                        System.out.println("Day: " + dateParts[2]);
                                        int confirm = scanner.nextInt();
                                        if (confirm == 1) {
                                            Booking booking = new Booking(bid, lid, uid, book_date, start,
                                                    end, cost,
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

                                        System.out.println("These are the top 5 word clouds for this listing");
                                        ListRatingDao.CombinedBodyForListing(lid2);
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
                                        // if (BookingDao.checkBooking(bid2, uid) == false) {
                                        // System.out.println(
                                        // "You cannot cancel the booking as you did not make the booking");
                                        // break;
                                        // }
                                        // enter the cid of the booking
                                        System.out
                                                .println("Please enter the cid of the booking you want to cancel");
                                        int cidcancel = scanner.nextInt();
                                        scanner.nextLine();
                                        CalenderDao.deleteCalender(cidcancel);
                                        BookingDao.deleteBooking2(bid2);
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
                                        if (BookingDao.checkBooking2(lid3, uid) == false) {
                                            System.out.println(
                                                    "You cannot cancel the booking as you did not make the booking");
                                            break;
                                        }
                                        if (ListingDao.getuser(lid3) == uid) {
                                            System.out.println("You cannot review your own listing");
                                            break;
                                        }
                                        int lrid = uid + lid3 * 10;
                                        System.out.println("Please enter your rating for the listing from 1 to 5");
                                        int rating = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out
                                                .println("Please give your review for the listing, how was your stay?");
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
