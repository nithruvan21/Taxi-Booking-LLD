package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer extends User{
    public static int staticId = 5;

    private List<Summary> userSummary;

    public static Map<String, Customer> customerMap = new HashMap<>();
    
    public Customer(int id, String name, String password, int age, char gender){
        super(id, name, password, age, gender);
        this.userSummary = new ArrayList<>();
    }

    public List<Summary> getUserSummary() {
        return userSummary;
    }

    public void setUserSummary(List<Summary> userSummary) {
        this.userSummary = userSummary;
    }

}
