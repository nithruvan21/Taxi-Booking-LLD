package Service;

import java.util.Scanner;

import Model.Customer;

public class CustomerService {
    static Scanner sc = new Scanner(System.in);

    public void createCustomer(){
        System.out.println("Enter your username: ");
        String username = sc.next();
        if (Customer.customerMap.containsKey(username)) {
            System.out.println("Try another username");
            return;
        }
        System.out.println("Enter your password: ");
        String password = sc.next();

        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Enter your gender: ");
        String gender = sc.next();


        Customer newCustomer = new Customer(Customer.staticId++, username, password, age, gender.charAt(0));
        Customer.customerMap.put(newCustomer.getName(), newCustomer);
        System.out.println("Customer Created: "+newCustomer.getName());
    }

    public void login(){
        System.out.println("Enter your username: ");
        String username = sc.next();
        Customer currentCustomer = null;
        currentCustomer = Customer.customerMap.get(username);

        if(currentCustomer == null){
            System.out.println("No user found");
            return;
        }
        System.out.println("Hello "+currentCustomer.getName());
        System.out.println("Enter your password: ");
        String password = sc.next();
        if(!currentCustomer.getPassword().equals(password)){
            System.out.println("Invalid password");
            return;
        }
        System.out.println("Logging in...");
        BookingService bs = new BookingService(currentCustomer);
        boolean loop = true;
        while (loop) {
            System.out.println("Enter your choice");
            System.out.println("1.Book a cab");
            System.out.println("2.View your summary");
            System.out.println("3. Logout");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bs.startBooking();
                    break;
                case 2:
                    bs.viewSummary();
                case 3:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void startCustomerService(){
        boolean loop = true;

        while (loop) {
            System.out.println("Welcome Customer");
            System.out.println("Enter 1 for SignUp (New Customer)");
            System.out.println("Enter 2 for SignIn (Exixsting)");
            System.out.println("Enter 3 to exit!");
            int signChoice = sc.nextInt();

            switch (signChoice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting");
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
