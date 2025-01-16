/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

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

    public String InputUD() { // chuan hoa du lieu nhap vao la U hoac u, D hoac d
        boolean success = false;
        String luaChon = inputString();
        while (success == false) {

            if (luaChon.equalsIgnoreCase("u") || luaChon.equalsIgnoreCase("d")) {
                success = true;//neu dung thoat khoi vong lap
            } else {
                System.out.println("Enter accurate option D or U, please enter again!");//neu sai yeu cau nhap lai
                luaChon = inputString();
            }

        }
        return luaChon;// tra ve du lieu duoc chuan hoa
    }

    public boolean courseCheck(String course) { // check xem course nhap vao tu ban phim co tuong ung voi ba khoa hoc mac dinh khong
        boolean result = false;
        if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
            result = true;
        }
        return result; // neu dung thi tra ve true, nguoc lai tra ve false
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
    
    public Date inputDate() {
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        //force user input exectly a date
        while(true) {
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                return date;
            } catch (Exception e) {
                System.out.print("Please input valid date (dd/MM/yyyy): ");
            }
        }
    }

    public Date inputManuDate() throws ParseException {
        Date date = inputDate();
        while (true) {
           //get current date
                Date curDate = Calendar.getInstance().getTime();
                //check range of date
                if (curDate.compareTo(date) < 0) {
                    System.out.print("Please input date that before current date: ");
                    date = inputDate();
                }else break;
        }
        return date;
    }
    
    public int compareDate(Date date1,Date date2){
        return date1.compareTo(date2);
    }
}
