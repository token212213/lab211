
package gui;

import java.util.Scanner;
import manager.Validation;

public class Menu {
    Validation valid = new Validation();
    Scanner sc = new Scanner(System.in);
    public int menu() {
        System.out.println("=======Worker Management=======");
        System.out.println("\t1. Add worker");
        System.out.println("\t2. Up salary");
        System.out.println("\t3. Down salary");
        System.out.println("\t4. Display Information salary");
        System.out.println("\t5. Exit");
        int luaChon = valid.getInt("Enter choice: ", 1, 5);
        return luaChon;
    }
}
