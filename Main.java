import java.util.Scanner;

import Model.Cab;
import Model.Customer;
import Model.Driver;
import Service.CustomerService;
import Service.DriverService;;

public class Main{
    static Scanner sc = new Scanner(System.in);

    public static void populate(){
        Driver d1 = new Driver(1,"aaa","111",43,'M',false);
        Driver d2 = new Driver(2,"bbb","222",31,'M',false);
        Driver d3 = new Driver(3,"ccc","333",38,'F',false);
        Driver d4 = new Driver(4,"ddd","444",28,'F',false);
        Driver.driversList.add(d1);
        Driver.driversList.add(d3);
        Driver.driversList.add(d2);
        Driver.driversList.add(d4);
        Driver.driverMap.put(d1.getName(), d1);
        Driver.driverMap.put(d2.getName(), d2);
        Driver.driverMap.put(d3.getName(), d3);
        Driver.driverMap.put(d4.getName(), d4);


        Customer c1 = new Customer(1, "zz", "99", 25, 'F');
        Customer c2 = new Customer(2, "yy", "88", 61, 'M');
        Customer c3 = new Customer(3, "xx", "77", 25, 'M');
        Customer c4 = new Customer(4, "ww", "66", 36, 'F');
        Customer.customerMap.put(c1.getName(), c1);
        Customer.customerMap.put(c2.getName(), c2);
        Customer.customerMap.put(c3.getName(), c3);
        Customer.customerMap.put(c4.getName(), c4);



        Cab.cabLocationMap.put('A', 0);
        Cab.cabLocationMap.put('C',4);
        Cab.cabLocationMap.put('D', 7);
        Cab.cabLocationMap.put('F', 9);
        Cab.cabLocationMap.put('B', 15);
        Cab.cabLocationMap.put('G', 18);
        Cab.cabLocationMap.put('H', 20);
        Cab.cabLocationMap.put('E', 23);

        Cab cab1 = new Cab(1, 'E');
        Cab cab2 = new Cab(2, 'G');
        Cab cab3 = new Cab(3, 'H');
        Cab cab4 = new Cab(4, 'A');

        Cab.cabList.add(cab1);
        Cab.cabList.add(cab2);
        Cab.cabList.add(cab3);
        Cab.cabList.add(cab4);
        Cab.cabMap.put(cab1.getCabPosition(), cab1);
        Cab.cabMap.put(cab2.getCabPosition(), cab2);
        Cab.cabMap.put(cab3.getCabPosition(), cab3);
        Cab.cabMap.put(cab4.getCabPosition(), cab4);

        Cab.cabDriverMap.put(cab1, d1);
        Cab.cabDriverMap.put(cab2, d2);
        Cab.cabDriverMap.put(cab3, d3);
        Cab.cabDriverMap.put(cab4, d4);

    }
    public static void main(String[] args) {
        populate();

        boolean loop = true;

        while (loop) {
            System.out.println("Welcome to Zula");
            System.out.println("1. CustomerService");
            System.out.println("2. DriverService");
            System.out.println("3. Exit");
            int serviceChoice = sc.nextInt();

            switch (serviceChoice) {
                case 1:
                    CustomerService cs = new CustomerService();
                    cs.startCustomerService();
                    break;
                case 2:
                    DriverService ds = new DriverService();
                    ds.startDriverService();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        }
    }
}