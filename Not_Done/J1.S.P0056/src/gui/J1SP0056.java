
package gui;

import manager.Management;
import manager.Validation;

public class J1SP0056 {
    Validation valid = new Validation();
    public int menu() {
        System.out.println("=======Worker Management=======");
        System.out.println("1. Add worker\n");
        System.out.println("2. Up salary\n");
        System.out.println("3. Down salary\n");
        System.out.println("4. Display Information salary\n");
        System.out.println("5. Exit\n");
        int luaChon = valid.getInt("Enter choice: ", 1, 5);
        return luaChon;
    }
    public static void main(String[] args) {        
        Management manager = new Management();
        Validation valid = new Validation();
        J1SP0056 menu = new J1SP0056();
        int choice = menu.menu();
        while(choice!=5){
            switch (choice) {
                case 1 : {
                    manager.addWorker();
                    choice = menu.menu();
                    break;
                }
                case 2 : {
                    manager.updateSalary(1);
                    choice = menu.menu();
                    break;
                }
                case 3 : {
                    manager.updateSalary(2);
                    choice = valid.getInt("Your choice: ", 1, 5);
                    break;
                }
                case 4 : {
                    manager.getInformation();
                    choice = valid.getInt("Your choice: ", 1, 5);
                    break;
                }
              
            }
        }
    }
}
