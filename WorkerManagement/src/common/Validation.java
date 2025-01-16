/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int inputInt(int min, int max) {
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

            } catch (Exception e) {
                System.out.println("Invalid,please enter a number:");
                sc.next();
            }
        }
        return 0;
    }

    public double inputdouble(int min) {
        boolean success = false;
        while (success == false) {
            try {
                double num = sc.nextDouble();
                sc.nextLine();
                if (num < min) {
                    System.out.println("Please enter number greater or equal: " + min);
                } else {
                    success = true;
                    return num;
                }

            } catch (Exception e) {
                System.out.println("Invalid,please enter a number:");
                sc.next();
            }
        }
        return 0;
    }

    public String inputString() {
        String str = "";
        boolean success = false;
        while (success == false) {
            str = sc.nextLine();
            if (str.isEmpty() || str.matches("^\\s{1,}")) {
                System.out.println("Please enter a non-empty string!");
            } else {
                success = true;
            }
        }

        return str;
    }

    public String inputCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
