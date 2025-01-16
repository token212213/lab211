
package model;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String location;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
