package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver extends User{
    public static int staticId = 1;

    private boolean rest;
    private List<Summary> driverSummary;

    static public List<Driver> driversList = new ArrayList<>();
    static public Map<String, Driver> driverMap = new HashMap<>();
    


    public Driver(int id, String name, String password, int age, char gender, boolean rest){
        super(id, name, password, age, gender);
        this.rest = rest;
        this.driverSummary = new ArrayList<>();
    }

    public boolean isRest() {
        return rest;
    }

    public void setRest(boolean rest) {
        this.rest = rest;
    }

    public static void activateDrivers(){
        for(Model.Driver d : driversList){
            d.setRest(false);
        }
    }

    public List<Summary> getDriverSummary() {
        return driverSummary;
    }

    public void setDriverSummary(List<Summary> driverSummary) {
        this.driverSummary = driverSummary;
    }
    
}
