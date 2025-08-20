package Model;

import java.util.ArrayList;
import java.util.List;

public class Summary {
    private int userId;
    private char source;
    private char destination;
    private int cabId;
    private double fare;

    static public List<Summary> totalSummary = new ArrayList<>();

    public Summary(char source, char destination,int userId, int cabId, double fare) {
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.cabId = cabId;
        this.fare = fare;
    }

    public char getSource() {
        return source;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Summary [userId=" + userId + ", source=" + source + ", destination=" + destination + ", cabId=" + cabId
                + ", fare=" + fare + "]";
    }

    
}
