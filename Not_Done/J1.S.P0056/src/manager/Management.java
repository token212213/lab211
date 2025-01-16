
package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import project.SalaryHistory;
import project.Worker;

public class Management {
    private Scanner sc = new Scanner(System.in);
    private List<Worker> wList;
    private List<SalaryHistory> shList;
    Validation valid = new Validation();

    public Management() {
        wList = new ArrayList<>();
        shList = new ArrayList<>();
   }

    public void addWorker() {
        String id, name, workLocation;
        int age;
        double salary;
//        id = sc.nextLine();
        id = valid.getId("Id must be in database and not null ", wList, 1);
        
        System.out.print("Enter Name: ");
        name = sc.nextLine().trim();
        
        age = valid.getInt("Enter Age: ",18,50);
        
        salary = valid.getSalary();
        
        System.out.print("Enter work location: ");
        workLocation = sc.nextLine();
        
        wList.add(new Worker(id, name, age, salary, workLocation));
    }
    
    public void updateSalary(int mode) {
        //mode 1: tang luong
        //mode 2: giam luong
        String id = valid.getId("Id must be in database and not null ", wList, 2);
        
        double money = valid.getSalary();
        
        Worker worker = valid.checkId(id, wList);
        
        double update = 0;
        String status = " ";
        
        if (mode == 1) {
            update = worker.getSalary() + money;
            status = "UP";
        }else if (mode == 2) {
            status = "DOWN";
            if (worker.getSalary() > money) {
                update = worker.getSalary() - money;
            }
        }
        
        worker.setSalary(update);
        
        shList.add(new SalaryHistory(id, worker.getName(), worker.getAge(), worker.getSalary(), status, java.time.LocalDate.now()));
    }
    
    public void getInformation() {
        if (shList.isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        display(shList);
    }
    
    private void display(List list) {
        for (Object worker : list) {
            System.out.println(worker);
        }
    }
    
}
