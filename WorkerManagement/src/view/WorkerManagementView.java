
package view;

import java.util.Scanner;
import common.Validation;
import controller.Management;
import model.Worker;

/**
 *
 * @author Đàm Quang Chiến
 */
public class WorkerManagementView {
    
    Validation valid = new Validation();
    Management manage = new Management();
    
    
   public void createWorker(){ // khoi tao worker theo yeu cau de bai
//        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        String id = valid.inputString();
        
        while(!manage.checkWorkerExist(id)){ // kiem tra id co ton tai khong neu ton tai yeu cau nhap id moi
            System.out.println("ID existed, please enter another ID!");
            id = valid.inputString();
        }
        
        System.out.println("Enter name:");
        String name = valid.inputString();
        while(!name.matches("^[a-zA-Z\\s]{1,}")){ // ten chi duoc cho phep neu la chu cai in thuong hoac in hoa
            System.out.println("Enter name again!");
            name = valid.inputString();
        }
        
        System.out.println("Enter age:");// tuoi gioi han tu 18 den 50 
        int age = valid.inputInt(18, 50);
        
        System.out.println("Enter salary:"); // luong cua worker lon hon 0
        double salary = valid.inputdouble(0);
        
        System.out.println("Enter work location:");
        String location = valid.inputString();
        
        Worker newWorker = new Worker(id, name, age, salary, location); // tao ra mot doi tuong worker moi
        manage.addWorker(newWorker);
        System.out.println("Create successfully!");
    }
   
    public void changeUpSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of worker:"); // nhap id vao de tim kiem worker
        String id = sc.nextLine();
        while(manage.checkWorkerExist(id)){
            System.out.println("ID does not exist, please enter id again!");
            id = sc.nextLine();
        }
        System.out.println("Enter amount to increase:");
        double amount = valid.inputdouble(0);
        manage.upSalary(id, amount);
        System.out.println("Update successfully");
    }
    
    public void changeDownSalary(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of worker:"); // nhap id vao de tim kiem worker
        String id = sc.nextLine();
        while(manage.checkWorkerExist(id)){
            System.out.println("ID does not exist, please enter id again!");
            id = sc.nextLine();
        }
        System.out.println("Enter amount to increase:");
        double amount = valid.inputdouble(0);
        manage.downSalary(id, amount);
        System.out.println("Update successfully");
    }
    
    public void printListHistory(){
        manage.printHistory();
    }
    
}
