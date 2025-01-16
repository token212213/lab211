
package controller;

import common.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.*;
/**
 *
 * @author Đàm Quang Chiến
 */
public class Management {
    
    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation(); // tao doi tuong validation trong class management
    ArrayList<Student> listStudent = new ArrayList<>();// tao danh sach hoc sinh
    ArrayList<Report> listReport = new ArrayList<>();// tao danh sach report
    
    //check condition
    public boolean checkStudentExist( Student new_st ){ // check id co ton tai trong danh sach hoc sinh khong
        boolean result = false;
        //lay thong tin cua hoc sinh duoc truyen vao
        String id =new_st.getId();
        String courseName = new_st.getCourseName();
        String name = new_st.getName();
        String semester = new_st.getSemester();
        for(Student st : listStudent){
            if(st.getId().equals(id) && st.getCourseName().equalsIgnoreCase(courseName) && st.getName().equals(name) && st.getSemester().equalsIgnoreCase(semester)){ 
                result = true;
                break;
            }
        }
        return result; // neu trung tra ve true, nguoc lai tra ve false
    }

    public boolean checkReportExist( String id, String courseName, int count){ // kiem tra id, courseName va count da ton tai trong danh sach report hay chua
        for(Report rpt : listReport){
            if(id.equalsIgnoreCase(rpt.getId()) && courseName.equalsIgnoreCase(rpt.getCourseName()) && count==rpt.getTotalCourse()) return false;
            
        }
        return true; //neu ton tai tra ve false, nguoc lai tra ve true
    }
    
    public boolean checkIdExist(String id){
        for(Student st : listStudent){
            if(st.getId().equals(id)) return true;
        }
        return false;
    }
    
    // common function        
   public int getSizeListStudent(){
       return listStudent.size();
   }
   public void printListStudent(){
       for(Student st : listStudent){
           st.print();
       }
   }
   public void printStudentAndIndex(String id){
       for (Student st : listStudent) {
            if (st.getId().equals(id)){
                System.out.print("Index: "+ (listStudent.indexOf(st)+1) +"     ");
                st.print();
            }
        }
   }
    public void printListReport(){ // in danh sach cac report da tao
        for(Report rp : listReport){
            rp.print();
        }
    }
    public void deleteAllReport(){
        for(int i=0; i< listReport.size();i++){
            listReport.remove(i);
        }
    }
       
   

    
    // option 1: create a student
    public boolean addStudent(Student st) {
        if (!checkStudentExist(st)) {
            listStudent.add(st);
            return true;
        } else {
            return false;
        }

    }
    
    public boolean listStudentSizeOption() {
        boolean result=true;
        if (listStudent.size() > 1) {
            System.out.println("Do you want to continue?");
            String option = valid.InputYN();
            if (option.equalsIgnoreCase("n")) {
                result= false;
            } else {
                result= true;
            }
        }
        return result;
    }

   
   //option 2: find and sort list student
    public void findStudentByName( String name){ // tim student theo ten 
        ArrayList<Student> listfindByName = new ArrayList<>(); // tao danh sach student duoc tim kiem theo ten
        for(Student st : listStudent){
            if(st.getName().contains(name)) listfindByName.add(st); // tim trong list student neu co student trung voi ten duoc nhap ben tren thi add vao list findbyName
        }
        listSortByName(listfindByName); // sap xep student trong list findByName theo ten thu tu bang chu cai
        System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name"); // in ra man hinh
        for(Student st : listfindByName){
            st.print();// in thong tin student: name, semester, coursename
        }
    }
    
    public ArrayList<Student> listSortByName(ArrayList<Student> list){ // sap xep student theo ten thu tu bang chu cai
        int n = list.size();
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n;j++){
                if(list.get(i).compareTo(list.get(j))>0) Collections.swap(list, j, i); // neu ten truoc co gia tri trong bang ma ascii lon hon sau thi dao 2 object
            }
        }
        return list; //tra ve list student duoc sap xep
    }
    
    
    
    
    //option 3: update and delete student  
    public void delete(int index){
        listStudent.remove(index);
        System.out.println("Delete successfully ");
    }
    public void deleteAll( String id){ // delete hoc sinh trong list hoc sinh
        int index =0;// tao bien index de luu vi tri cua hoc sinh trong danh sach hoc sinh
        while(checkIdExist(id)){
            for(int i=0; i<getSizeListStudent();i++){
                if(listStudent.get(i).getId().equals(id)) listStudent.remove(i);
            }
        }
        System.out.println("Delete successfully ");
    }
    
    public void update(int index, String id, String name, String semester, String course) {
        Student checkStudent = new Student(id, name, course, semester);
        if(checkStudentExist(checkStudent)) {
            System.out.println("Update fail, duplicate student!");
            return;
        }
        for(Student st : listStudent){
            if(st.getId().equals(checkStudent.getId()) && !st.getName().equalsIgnoreCase(checkStudent.getName())){
                System.out.println("Update fail!");
                return;
            } 
        }
            // cap nhat thong tin cua hoc sinh
            listStudent.get(index).setName(name);
            listStudent.get(index).setSemester(semester);
            listStudent.get(index).setCourseName(course);
            System.out.println("Update successfully!");
        
    }
    
    
    
    //option 4: Report list 
    public void createReportList() { // tao danh sach cac report ve so luong mon hoc tham gia cua tung hoc sinh

        for (Student st : listStudent) { // tao vong lap trong danh sach hoc sinh
            int count = 0; // tao bien count de luu so luong khoa hoc tham gia cua tung hoc sinh sau moi lan duyet
            String id = st.getId();//lay ra id cua tung hoc sinh
            String courseName = st.getCourseName();// lay ten khoa hoc cua tung hoc sinh
            for (Student st1 : listStudent) { // tao them mot vong lap danh sach hoc sinh trong vong lap lon de dem so luong khoa hoc
                if (id.equals(st1.getId()) && courseName.equalsIgnoreCase(st1.getCourseName())) { // kiem tra neu trung id va trung ten khoa hoc thi tang bien count len 1 don  vi
                    count++;
                }
            }
            if (checkReportExist( id, courseName, count)) { // kiem tra id, courseName va count co trung voi object report nao trong danh sach report khong
                Report report = new Report(count, id, st.getName(), courseName, st.getSemester()); // neu khong trung tao doi tuong report moi
                listReport.add(report); // add doi tuong report vao danh sach report
            }
        }

    }
    


    
}
