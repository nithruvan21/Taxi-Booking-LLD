package Model;

public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private char gender;
    public User(int id, String name, String password, int age, char gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    
}
