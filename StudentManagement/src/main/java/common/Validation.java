
package common;

import java.util.Scanner;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public int inputInt(int min, int max){ // chuan hoa du du lieu nhap vao la so nguyen trong khoang gia tri min max
        boolean success = false;
        while (success==false) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                if(num<min || num >max){
                    System.out.println("Please enter number between ("+min+"->"+max+")");  // neu ngoai khoang thi yeu cau nhap lai
                }else {
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
    
    
    public String inputString(){ // chuan hoa du lieu nhap voa tu ban phim la string khong phai la string rong
        String str = ""; 
        boolean success = false;
        while (success==false) {
                str = sc.nextLine(); // nhap string vao tu ban phim
                str.trim(); // xoa dau cach o dau va cuoi string
                if(str.isEmpty() || str.matches("^\\s{1,}")){ // neu string empty hoac chi chua hoan toan dau cach thi yeu cau nhap lai
                    System.out.println("Please enter a non-empty string!");
                }else{
                    success = true;
                }
        }
        
        return str; // tra ve string khong rong 
    }
    
    public String InputYN(){ // chuan hoa du lieu nhap vao laf Y hoac N , y hoac n
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
    
     public String InputUD(){ // chuan hoa du lieu nhap vao la U hoac u, D hoac d
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
     
     public boolean courseCheck(String course){ // check xem course nhap vao tu ban phim co tuong ung voi ba khoa hoc mac dinh khong
        boolean result = false;
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++") ){
            result = true;
        }
        return result; // neu dung thi tra ve true, nguoc lai tra ve false
    }
}
