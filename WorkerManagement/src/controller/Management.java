
package controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.Worker;
import common.Validation;
import model.SalaryHistory;

public class Management {
    Scanner sc = new Scanner(System.in);
    
    ArrayList<Worker> listWorker = new ArrayList<>(); // tao danh sach cac worker
    ArrayList<SalaryHistory> listHistory = new ArrayList<>(); // tao danh sach lich su chinh sua luong cua worker
    
    Validation valid = new Validation(); // tao doi tuong validation de chuan hoa thong tin dua vao
    
    //check function
    public boolean checkWorkerExist(String id){ // ham kiem tra worker co ton tai trong listworker khong tra ve gia tri true false so sanh qua id worker
        boolean check =true;
        for(Worker obj : listWorker){
            if(obj.getId().equals(id)){
                check =false;
            }
        }
        return check; // neu ton tai tra ve false con khong ton tai tra ve true
    }
    
    public void addWorker(Worker worker){
        listWorker.add(worker);
    }
    
    // print list of worker
    public void printHistory(){ // in danh sach lich su thay doi luong cua worker trong danh sach
        sortList(); // sap xep theo id
        System.out.printf("%-8s%-15s%-5s%-8s%-8s%-10s \n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        for(SalaryHistory obj : listHistory){ // in ra theo fomat cua de bai
            obj.printHistory();
        }
    }
    
    //sort a list
    public void sortList(){ // sap xep danh sach dua tren id
        for(int i=0; i<listHistory.size()-1;i++){
            for(int j=i+1; j<listHistory.size();j++){
                SalaryHistory h1 = listHistory.get(i);
                SalaryHistory h2 = listHistory.get(j);
                if(h1.getId().compareTo(h2.getId())<0){ // neu id sau be hon id truoc thi dao vi tri 
                    Collections.swap(listHistory, i, j);
                }
            }
        }
    }
    
    
    // module in program
    
    public void upSalary(String id, double amount) {
        
        for (Worker obj : listWorker) {
            if (obj.getId().equals(id)) {
                double oldSalary = obj.getSalary();
                obj.setSalary(oldSalary + amount);
                String status = "UP";
                String date = valid.inputCurrentDate();
                String name = obj.getName();
                int age = obj.getAge();
                double salary = obj.getSalary();
                String location = obj.getLocation();
                SalaryHistory history = new SalaryHistory(status, date, id, name, age, salary, location);
                listHistory.add(history);
            }
        }
    }
    
    public void downSalary(String id, double amount){
        for (Worker obj : listWorker) {
                if (obj.getId().equals(id)) {
                    double oldSalary = obj.getSalary();
                    if(amount>oldSalary){
                        obj.setSalary(0);
                    }else{
                        obj.setSalary(oldSalary - amount);
                    }                
                    String status = "DOWN";
                    String date = valid.inputCurrentDate();
                    String name = obj.getName();
                    int age = obj.getAge();
                    double salary = obj.getSalary();
                    String location = obj.getLocation();
                    SalaryHistory history = new SalaryHistory(status, date, id, name, age, salary, location);
                    listHistory.add(history);
                }
            }
    }
}
