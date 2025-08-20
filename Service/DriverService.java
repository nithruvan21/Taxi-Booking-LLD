package Service;

import java.util.Scanner;

import Model.Cab;
import Model.Driver;

public class DriverService {
    static Scanner sc = new Scanner(System.in);
    public void startDriverService(){
        System.out.println("Enter your username: ");
        String username = sc.next();
        Driver currentDriver = null;
        currentDriver = Driver.driverMap.get(username);

        if(currentDriver == null){
            System.out.println("No driver found");
            return;
        }
        System.out.println("Hello "+currentDriver.getName());
        System.out.println("Enter your password: ");
        String password = sc.next();
        if(!currentDriver.getPassword().equals(password)){
            System.out.println("Invalid password");
            return;
        }
        System.out.println("Logging in...");

        boolean loop = true;
        while (loop) {
            System.out.println("1.View your summary");
            System.out.println("2. View your cab summary");
            System.out.println("3. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(currentDriver.getDriverSummary());
                    break;
                case 2:
                    System.out.println("Enter the cab id: ");
                    int cabid = sc.nextInt();
                    Cab cab = null;
                    for(Cab c : Cab.cabList){
                        if (c.getId() == cabid) {
                            cab = c;
                            break;
                        }
                    }
                    if (cab == null) {
                        System.out.println("No cab found");
                        break;
                    }
                    cab.printSummary();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
