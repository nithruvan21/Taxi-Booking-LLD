package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cab {
    private int id;
    private char cabPosition;
    private List<Summary> cabSummary;

    public static Map<Character,Integer> cabLocationMap = new HashMap<>();
    public static List<Cab> cabList = new ArrayList<>();
    public static Map<Character, Cab> cabMap = new HashMap<>();

    static public Map<Cab,Driver> cabDriverMap = new HashMap<>();


    public Cab(int id, char cabPosition) {
        this.id = id;
        this.cabPosition = cabPosition;
        this.cabSummary = new ArrayList<>();
    }

    public void printSummary(){
        System.out.println("Printing the cab summary: "+this.id);
        for(Summary s : cabSummary){
            System.out.println(s.toString());
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCabPosition() {
        return cabPosition;
    }

    public void setCabPosition(char cabPosition) {
        this.cabPosition = cabPosition;
    }

    public List<Summary> getCabSummary() {
        return cabSummary;
    }

    public void setCabSummary(List<Summary> cabSummary) {
        this.cabSummary = cabSummary;
    }

    @Override
    public String toString() {
        return "Cab [id=" + id + ", cabPosition=" + cabPosition + "";
    }

    

}
