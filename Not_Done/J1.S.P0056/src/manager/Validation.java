
package manager;

import java.util.List;
import java.util.Scanner;
import project.Worker;

public class Validation {
    
    Scanner sc = new Scanner(System.in);
    
    //nhap tuoi
    public int getInt(String msg, int min, int max) {
        boolean success = false;
        while (success == false) {
            try {
                int num = sc.nextInt();
                if (num < min || num > max) {
                    System.out.println("Please enter number between (" + min + "->" + max + ")");
                } else {
                    success = true;
                    return num;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid,please enter a number:");
                sc.next();
            }
        }
        return 0;
    }
    
    //nhap luong
    public double getSalary() {
        double salary;
        while (true) {
            try {
                System.out.print("Enter Salary: ");
                salary = Double.parseDouble(sc.next().trim());
                if (salary > 0) {
                    break;
                }else System.out.println("The age must be greater than 0!");
            }catch (NumberFormatException e) {
                System.err.println("Please input the number!");    
            }
        }
        return salary;
    }
    
     //nhap code(id)
    public String getId(String err, List<Worker> wList, int mode) {
        //mode 1: input - id k duoc trong
        //mode 2: update salary - id ko duoc trung
        String id = "";
        boolean success = false;
        while (success == false) {
            System.out.print("Enter Code: ");
            id = sc.nextLine();
            if (!id.isEmpty()) {
                if (mode == 1 ) {
                    if(checkId(id, wList) == null) success=true;
                }else if(mode == 2){
                    if(checkId(id, wList) != null) success=true;
                }
            } else {
                System.err.println(err);
            }
        }

        return id;
    }
    
    //kiem tra code(id) co trong DB hay khong
    public Worker checkId (String id, List<Worker> wList) {
        for (Worker worker : wList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }
}


