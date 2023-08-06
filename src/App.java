import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static int exit_program = 0;

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
                int uid = scanner.nextInt();
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
                            "2. Read User 5. Your Listings 6. Book a new Listing 7. View your Bookings 8. View Amentities for hosts 9. Logout");
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
                                        "2. Create new Listing 5. Update existing Listing 6. Delete a listing 7. Add amentities 9. Go back to home-page");
                                scanner = new Scanner(System.in);
                                int x2 = scanner.nextInt();

                                switch (x2) {
                                    case 2:
                                        System.out.println(
                                                "Create Listing: id, hid, type, price, latitude, longitude, address, postal, city, country");
                                        scanner.nextLine();
                                        int lid = scanner.nextInt();
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
                                        Listing listing = new Listing(lid, hid, type, price, latitude, longitude,
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
                            System.out.println("Please select a listing to book");
                            ArrayList<Listing> listings5 = ListingDao.readListing();
                            for (Listing l : listings5) {
                                System.out.println(l);
                            }
                            System.out.println("Please enter bid");
                            int bid = scanner.nextInt();
                            System.out.println("Please enter the lid of the listing you want to book");
                            int lid = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Please enter the start date of your booking in the format YYYY-MM-DD");
                            String start = scanner.nextLine();
                            System.out.println("Please enter the end date of your booking in the format YYYY-MM-DD");
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
                                Booking booking = new Booking(bid, lid, uid, book_date, start, end, cost, ccInfo,
                                        false);
                                BookingDao.createBooking(booking);
                                System.out.println("Your booking has been confirmed");
                            } else {
                                System.out.println("Your booking has been cancelled");
                            }
                            break;

                        case 7:
                            System.out.println("Here are your Bookings");
                            BookingDao.readBookingforUser(uid);
                            int booking = 0;

                            while (booking == 0) {
                                System.out.println("Please enter your choice:");
                                System.out.println("1. Cancel a booking 2. update a booking 9. Go back to home-page");
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
