
package view;

import java.util.Scanner;
import common.Validation;
import controller.Management;
import model.Student;

public class StudentManagementView {
    
    Management manage = new Management();// tao doi tuong management trong class view
    Validation valid = new Validation(); // tao doi tuong validation
    
    // option 1: create student(s)
    public boolean creatStudent() {      
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID: ");// nhap id student
            String id = valid.inputString();

            System.out.println("Enter name of student: ");//nhap ten student
            String name = valid.inputString();

            System.out.println("Enter semester: ");//nhap ky hoc cua student do
            String semester = valid.inputString();

            System.out.println("Enter name of course: (Java, .Net, C/C++)");//nhap mon hoc cua student do
            String course = valid.inputString();
            while (!valid.courseCheck(course)) { // kiem tra mon hoc co nhap dung ten trong 3 mon hoc (Java, .Net, C/C++) khong
                System.out.println("Wrong course name, please enter course's name again! (Java, .Net, C/C++)");//nhap sai yeu cau nhap lai
                course = valid.inputString();
            }

            Student st = new Student(id, name, course, semester);// tao mot doi tuong student moi
            
            if (manage.addStudent(st)) { // check xem ban ghi co ton tai trong list student chua neu co thi khong chap nhan con khong thi add vao list
                System.out.println("Create successfully!");
            }else{
                System.out.println("Student has existed!");
            }

            if(manage.getSizeListStudent()>1){ // kiem tra xem so luong hoc sinh trong list hoc sinh co lon hon so luong quy dinh khong 
                System.out.println("Do you want to continue?(Y/N)");
                String option = valid.InputYN();
                if(option.equalsIgnoreCase("n")) {
                    return false;
                }
            }
        }
    }

    //option 2: find and sort
    public void FindAndSort(){
        System.out.println("Enter name of student: ");
        String name = valid.inputString();
        manage.findStudentByName(name);
    }
    
    
    //option 3: update and delete student 
    
    public void UpdateOrDelete(){
        int index=0;
        System.out.println("Enter student's ID: "); // nhap id hoc sinh
        String id = valid.inputString();
        while (!manage.checkIdExist(id)) {
            System.out.println("ID does not exist, enter ID again!"); // kiem tra xem id nhap vao co ton tai trong list khong neu khong co yeu cau nhap lai
            id = valid.inputString();
        }
        
        System.out.println("Do you want to update(U) or delete(D) student?"); // hoi nguoi dung muon su dung tac vu nao
        String luaChon = valid.InputUD();
   
        if(luaChon.equalsIgnoreCase("d")){ // neu nguoi dung chon 'd' hoac 'D' thi delete hoc sinh do
            manage.printStudentAndIndex(id);
            System.out.println("Which position do you want to delete?(Enter 0 to delete all!)");//dua ra cho nguoi dung lua chon xoa 1 student hoac xoa het
            index = valid.inputInt(0, manage.getSizeListStudent()+1);
            if(index==0) manage.deleteAll(id);
            else manage.delete(index-1);         
            manage.printListStudent();
        }
        else if(luaChon.equalsIgnoreCase("u")){ // neu nguoi dung chon 'u' hoac 'U' thi update hoc sinh do
            manage.printStudentAndIndex(id);
            System.out.println("Which position do you want to update?");//dua ra cho nguoi dung lua chon xoa 1 student hoac xoa het
            index = valid.inputInt(0, manage.getSizeListStudent()+1);
            
            // nhap thong tin update
            System.out.println("Enter name of student: ");//nhap ten student
            String name = valid.inputString();

            System.out.println("Enter semester: ");//nhap ky hoc cua student do
            String semester = valid.inputString();

            System.out.println("Enter name of course: (Java, .Net, C/C++)");//nhap mon hoc cua student do
            String course = valid.inputString();
            while (!valid.courseCheck(course)) { // kiem tra mon hoc co nhap dung ten trong 3 mon hoc (Java, .Net, C/C++) khong
                System.out.println("Wrong course name, please enter course's name again! (Java, .Net, C/C++)");//nhap sai yeu cau nhap lai
                course = valid.inputString();
            }
            
            
            manage.update(index, id, name, semester, course);
            manage.printListStudent();
            
        }
    }
    
    //option 4: report
    public void Report(){
        manage.deleteAllReport();
        manage.createReportList();
        manage.printListReport();
    }

}
