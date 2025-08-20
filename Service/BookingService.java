package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Cab;
import Model.Customer;
import Model.Driver;
import Model.Summary;

public class BookingService {
    static Scanner sc = new Scanner(System.in);
    private Customer currentCustomer;

    public BookingService(Customer currCustomer){
        this.currentCustomer = currCustomer;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public void startService(){
        boolean loop = true;
        while (loop) {
            System.out.println("1. Book a cab");
            System.out.println("2. View your summary");
            System.out.println("3. Log Out");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startBooking();
                    break;
                case 2:
                    viewSummary();
                    break;
                case 3:
                    System.out.println("Logging out");
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("");
    }

    public void viewSummary(){
        System.out.println("Printing the current users summary");
        List<Summary> currentUserSummary = currentCustomer.getUserSummary();
        for(Summary s : currentUserSummary){
            s.toString();
        }
    }

    public void startBooking(){
        System.out.println("Available cabs");
        for(Cab c : Cab.cabList){
            System.out.println("Cab Id: "+ c.getId());
            System.out.println("Location: "+c.getCabPosition());
        }
        System.out.println("Enter your source");
        String source = sc.next();
        System.out.println("Enter your destination");
        char destination = sc.next().charAt(0);
        Cab assignedCab = findNearestCab(source);
        if(assignedCab == null){
            for(Cab c : Cab.cabDriverMap.keySet()){
                if (!Cab.cabDriverMap.get(c).isRest()) {
                    assignedCab = c;
                }
            }
        }
        System.out.println("You are assigned with a nearest cab: "+assignedCab.toString());

        int distance = Cab.cabLocationMap.get(source.charAt(0)) - Cab.cabLocationMap.get(destination);
        distance = Math.abs(distance);
        System.out.println("The Distance of your travel: "+distance);

        double price = distance*10;
        System.out.println("Price of your travel: "+price);

        assignedCab.setCabPosition(destination);
        Model.Driver driver = Cab.cabDriverMap.get(assignedCab);

        Driver.activateDrivers();
        System.out.println("Assigned Driver: "+driver.getName());
        driver.setRest(true);

        Summary newSummary = new Summary(source.charAt(0), destination, currentCustomer.getId(),assignedCab.getId(), price);
        currentCustomer.getUserSummary().add(newSummary);
        assignedCab.getCabSummary().add(newSummary);
        driver.getDriverSummary().add(newSummary);
        Summary.totalSummary.add(newSummary);

        System.out.println();
        System.out.println("Cab Booked");
        System.out.println();
        System.out.println(newSummary.toString());
        System.out.println("Exiting");
        System.out.println();
    }

    public Cab findNearestCab(String source){
        String locations = "ACDFBGHE";
        List<Cab> assignedCab = new ArrayList<>();
        Cab assignedddCab = null;
        Cab finalAssigned = null;
        for(Cab c : Cab.cabList){
            if(c.getCabPosition() == source.charAt(0) && !Cab.cabDriverMap.get(c).isRest()){
                assignedCab.add(c);
                break;
            }
        }
        if (assignedCab.size()==1) {
            System.out.println("Cab Assigned!: "+assignedCab.get(0).getId());
            return assignedCab.get(0);
        }else{
            List<Character> availableCabs = new ArrayList<>();
            for(Cab c : Cab.cabList){
                availableCabs.add(c.getCabPosition());
            }
            char assign = ' ';
            int locIdx = locations.indexOf(source);
            int cabDis = Integer.MAX_VALUE;
            List<Character> assignCabs = new ArrayList<>();
            for(int i = 0 ; i < locations.length() ; i++){
                if (availableCabs.contains(locations.charAt(i))) {
                    int currDis = Math.abs(locIdx-i);
                    cabDis = Math.min(cabDis, currDis);
                    if (currDis==cabDis) {
                        //assign = locations.charAt(i);
                        assignCabs.add(locations.charAt(i));
                    }
                }
                if (assignCabs.size()== 1) {
                    return Cab.cabMap.get(assignCabs.get(0));
                }else{
                    char assigneddCab = ' ';
                    int minDis = Integer.MAX_VALUE;
                    
                    for(int c : assignCabs){
                        char ch = locations.charAt(c);
                        
                        if (Cab.cabLocationMap.get(source.charAt(c)) - Cab.cabLocationMap.get(source.charAt(0)) < minDis) {
                            minDis = Cab.cabLocationMap.get(source.charAt(c)) - Cab.cabLocationMap.get(source.charAt(0));
                            assigneddCab = ch;
                            assignedddCab = Cab.cabMap.get(assigneddCab);
                            if(!Cab.cabDriverMap.get(assignedddCab).isRest()){
                                finalAssigned = assignedddCab;
                            }
                            
                        }
                    }
                }
            }
        }
        return assignedddCab;
    }
}
