
package model;

import java.util.Date;
import java.util.List;


public class SalaryHistory extends Worker{
    
    private String status;
    private String date;

    public SalaryHistory() {
    }


    public SalaryHistory(String status, String date, String id, String name, int age, double salary, String location) {
        super(id, name, age, salary, location);
        this.status = status;
        this.date = date;
    }
    
  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void printHistory() {
        System.out.printf(
                "%-8s%-15s%-2d   %-8.1f%-8s%-10s \n", this.getId(), this.getName(), this.getAge(), this.getSalary(), this.getStatus(), this.getDate());
    }
}
