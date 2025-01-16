/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author nguyen ngoc quang
 */
public class Valid {

    Scanner sc = new Scanner(System.in);

    public int checkIntputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in the rage [" + min + ", " + max + "]");

            }
        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");

            }
        }
    }

    public boolean checkOdd(double n) {
        if (n % 2 !=0) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
