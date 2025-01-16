/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int inputInt(int min, int max) { // chuan hoa du du lieu nhap vao la so nguyen trong khoang gia tri min max
        boolean success = false;
        while (success == false) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                if (num < min || num > max) {
                    System.out.println("Please enter number between (" + min + "->" + max + ")");  // neu ngoai khoang thi yeu cau nhap lai
                } else {
                    success = true;
                    return num; // nhap dung kieu du lieu va trong khoang gioi han thi tra ve so nhap tu ban phim do
                }

            } catch (Exception e) { // neu nhap sai kieu du lieju yeu cau nhap lai
                System.out.println("Invalid,please enter a number:");
                sc.next();
            }
        }
        return 0;
    }

    public String inputString() { // chuan hoa du lieu nhap voa tu ban phim la string khong phai la string rong
        String str = "";
        boolean success = false;
        while (success == false) {
            str = sc.nextLine(); // nhap string vao tu ban phim
            str.trim(); // xoa dau cach o dau va cuoi string
            if (str.isEmpty() || str.matches("^\\s{1,}")) { // neu string empty hoac chi chua hoan toan dau cach thi yeu cau nhap lai
                System.out.println("Please enter a non-empty string!");
            } else {
                success = true;
            }
        }

        return str; // tra ve string khong rong 
    }
    
    public String inputName(){
        String name = "";
        boolean success = false;
        while (success == false) {            
            name = inputString();
            
            if(!name.matches("[a-zA-Z]{1,}")){
                System.out.println("Please enter name has alphabetic characters only!");
                name = inputString();
            }else success =true;
        }
        return name;
    }

    public String InputYN() { // chuan hoa du lieu nhap vao laf Y hoac N , y hoac n
        boolean success = false;
        String luaChon = inputString();
        while (success == false) {

            if (luaChon.equalsIgnoreCase("y") || luaChon.equalsIgnoreCase("n")) {// neu dung thoat khoi vong lap
                success = true;
            } else {
                System.out.println("Enter accurate option Y or N, please enter again!"); // sai thi yeu cau nhap lai
                luaChon = inputString();
            }

        }
        return luaChon; // tra ve du lieu duoc chuan hoa
    }

    public double inputdouble(String massage, int min, int max) {
        boolean success = false;
        while (success == false) {
            try {
                double num = sc.nextDouble();
                sc.nextLine();
                if (num < min) {
                    System.out.println("Please enter number greater than or equal: " + min);
                    System.out.print(massage);
                }
                else if(num > max){
                    System.out.println("Please enter number less than or equal: " + max);
                    System.out.print(massage);
                }
                else {
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
    
   
}
