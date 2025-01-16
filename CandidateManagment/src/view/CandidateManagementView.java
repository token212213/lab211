
package view;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.CandidateList;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCadidate;
import java.util.regex.*;


public class CandidateManagementView {

    private static int dob;
    private static String phone;
    private static String email;
    private static int exp;
    private static String rank;
    
    private FresherCandidate fresherCan;
    private InternCadidate internCan;
    
    
    
    public static int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Candidate Management System\n"
                + "1. Experience\n"
                + "2. Fresher\n"
                + "3. Internship\n"
                + "4. Searching\n"
                + "5. Exit"); 
        int luaChon = sc.nextInt();
        return luaChon;
    }
    
    // tạo các hàm check theo đề bài
    public static int checkDOB(int dob){
        Scanner sc = new Scanner(System.in);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        while(dob<1900 || dob > year){
            System.out.println("Unvalid data DOB, try again: ");
            dob= sc.nextInt();
            sc.nextLine();
        }
        return dob;
    }
    
    public static String CheckPhone(String phone){
        Scanner sc = new Scanner(System.in);
        String regex = "^\\d{10,}";
        while(!phone.matches(regex)){
            System.out.println("nhap lai sdt");
            phone = sc.nextLine();
        }
        return phone;
    }
    
    public static String checkEmail(String email){
        Scanner sc = new Scanner(System.in);
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        while(!email.matches(regex)){
            System.out.println("nhap lai email");
            email = sc.nextLine();
        }
        return email;
    }
    
    public static String checkRank(String rank){
        Scanner sc = new Scanner(System.in);
        while(!rank.equalsIgnoreCase("Excellence") && !rank.equalsIgnoreCase("Good") && !rank.equalsIgnoreCase("Fair") && !rank.equalsIgnoreCase("Poor")){
            System.out.println("Nhap lai rank");
            rank = sc.nextLine();
        }
        return rank;
    }
    
    
    // tạo hàm tìm kiếm 
    public static void searchCan(CandidateList canList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap firstname hoac lastname");
        String search = sc.nextLine();
        System.out.println("nhap type of candidate");
        int type = sc.nextInt();
        sc.nextLine();
//        String regex = "."+search+".";
        System.out.println("The candidate found: ");
        if(type==0){
            for(ExperienceCandidate expCan : canList.getListExp()){
                String name = expCan.getFirstName()+" "+expCan.getLastName();
                if(name.contains(search)){
                    System.out.println(name+" | "+expCan.getBirthDate()+" | "+expCan.getAddress()+" | "+expCan.getPhoneNumber()+" | "+expCan.getEmail()+" | "+expCan.getCandidateType());
                }
            }
        }else if(type==1){
            for(FresherCandidate fresherCan : canList.getListFresher()){
                String name = fresherCan.getFirstName()+" "+fresherCan.getLastName();
                if(name.contains(search)){
                    System.out.println(name+" | "+fresherCan.getBirthDate()+" | "+fresherCan.getAddress()+" | "+fresherCan.getPhoneNumber()+" | "+fresherCan.getEmail()+" | "+fresherCan.getCandidateType());
                }
            }
        }else if(type==2){
            for(InternCadidate internCan : canList.getListIntern()){
                String name = internCan.getFirstName()+" "+internCan.getLastName();
                if(name.contains(search)){
                    System.out.println(name+" | "+internCan.getBirthDate()+" | "+internCan.getAddress()+" | "+internCan.getPhoneNumber()+" | "+internCan.getEmail()+" | "+internCan.getCandidateType());
                }
            }
        }
    }
    
    
    //tạo hàm khởi tạo ứng viên
    public static String createExp(CandidateList canList){ // tao doi tuong experience
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter candidate id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("enter dob: ");
        dob = checkDOB(sc.nextInt());
        sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        System.out.println("enter phone number: ");
        phone = CheckPhone(sc.nextLine());
        System.out.println("enter email: ");
        email = checkEmail(sc.nextLine());
        System.out.println("enter year of experience: ");
        exp = sc.nextInt();
        sc.nextLine();
        System.out.println("enter proSkill: ");
        String skill = sc.nextLine();
        ExperienceCandidate expCan = new ExperienceCandidate(id, firstName, lastName, dob, address, phone, email, 0, exp, skill);
        canList.getListExp().add(expCan);
        System.out.println("Do you want to continue?(Y/N)");
        String luaChon = sc.nextLine();
        return luaChon;
    }
    
    public static String createFresher(CandidateList canList){ // tao ung vien fresher
        Scanner sc = new Scanner(System.in);
        
        int id =0;
        boolean success = false;
        
        while(success ==false){
            try {
                System.out.println("Enter candidate id: ");
                id = sc.nextInt();
                sc.nextLine();
                success =true;
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
                sc.next();
            }
        }
        
        System.out.println("enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("enter dob: ");
        dob = checkDOB(sc.nextInt());
        sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        System.out.println("enter phone number: ");
        phone = CheckPhone(sc.nextLine());
        System.out.println("enter email: ");
        email = checkEmail(sc.nextLine());
        System.out.println("enter graduation time: ");
        int gradTime = sc.nextInt();
        sc.nextLine();
        System.out.println("enter rank of graduation: (Excellence, Good, Fair, Poor) ");
        rank = checkRank(sc.nextLine());
        System.out.println("enter name of university:  ");
        String uniName = sc.nextLine();
        FresherCandidate fresherCan = new FresherCandidate(gradTime, firstName, lastName, dob, address, phone, email, 1, gradTime, rank, email);
        canList.getListFresher().add(fresherCan);
        System.out.println("Do you want to continue?(Y/N)");
        String luaChon = sc.nextLine();
        return luaChon;
    }
    
    public static String createIntern(CandidateList canList){ // tao ung vien intern
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter candidate id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("enter dob: ");
        dob = checkDOB(sc.nextInt());
        sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        System.out.println("enter phone number: ");
        phone = CheckPhone(sc.nextLine());
        System.out.println("enter email: ");
        email = checkEmail(sc.nextLine());
        System.out.println("enter major: ");
        String major = sc.nextLine();
        System.out.println("enter semester:  ");
        int semester = sc.nextInt();
        sc.nextLine();
        System.out.println("enter name of university:  ");
        String uniName = sc.nextLine();
        InternCadidate internCan = new InternCadidate(id, firstName, lastName, dob, address, phone, email, 2, major, semester, uniName);
        canList.getListIntern().add(internCan);
        System.out.println("Do you want to continue?(Y/N)");
        String luaChon = sc.nextLine();
        return luaChon;
    }
    
    
    
    public static void printListCan(CandidateList canList){
        System.out.println("=====Exp====");
        canList.printExpList();
        System.out.println("=====Fresher====");
        canList.printFresherList();
        System.out.println("=====Intern=====");
        canList.printInternList();
    }
    


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CandidateList canList = new CandidateList();
        
        
        int luaChon = Menu();
        String luaChon2 = "Y";
        while(luaChon!=5){
            if (luaChon == 1) {
                while (luaChon2.equalsIgnoreCase("Y")) {
                    luaChon2 = createExp(canList);
                }
            } else if (luaChon == 2) {
                while (luaChon2.equalsIgnoreCase("Y")) {
                    luaChon2 = createFresher(canList);
                }
            } else if (luaChon == 3) {
                while (luaChon2.equalsIgnoreCase("Y")) {
                    luaChon2 = createIntern(canList);
                }
            } else if (luaChon == 4) {
                searchCan(canList);
                System.exit(0);
            }
            if(luaChon2.equalsIgnoreCase("N")){
                printListCan(canList);
                Menu();
                luaChon = sc.nextInt();
                luaChon2="Y";
            }
        
        }
    }
}