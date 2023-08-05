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
                            "2. Read User 5. Your Listings 6. Book a new Listing 9. Logout");
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
                            Listing listing = new Listing(lid, hid, type, price, latitude, longitude, address2, postal,
                                    city,
                                    country);
                            ListingDao.createListing(listing);
                            break;

                        case 6:
                            System.out.println("Read Listing");
                            ArrayList<Listing> listings = ListingDao.readListing();
                            for (Listing l : listings) {
                                System.out.println(l);
                            }
                            break;

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
                            break;
                    }
                }
            }
        }
    }
}
