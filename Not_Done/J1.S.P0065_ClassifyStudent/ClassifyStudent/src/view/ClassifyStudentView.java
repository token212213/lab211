
package view;

import common.Validation;
import model.Student;
import controller.ClassifyStudentController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassifyStudentView {

    Validation valid = new Validation();
    Student st = new Student();
    ClassifyStudentController controller = new ClassifyStudentController();
 
    public Student createStudent() {
        //enter data of a student
        System.out.println("===== Management Student Program =====");
        System.out.print("Name: ");
        String name = valid.inputName();
        System.out.print("Classes: ");
        String className = valid.inputString();
        System.out.print("Maths: ");
        double markMath = valid.inputdouble("Maths: ",0, 10);
        System.out.print("Physics: ");
        double markPhysic = valid.inputdouble("Physics: ",0, 10);
        System.out.print("Chemistry: ");
        double markChemis = valid.inputdouble("Chemistry: ",0, 10);   
        Student new_st = new Student(name, className, markMath, markPhysic, markChemis, 0, null);
        return new_st;
    } 
    public void addStudent(){
        while(true){
            Student new_st = createStudent();
            controller.addStudent(new_st);
            System.out.println("Do you want to continue?(Y/N)");
            String luaChon = valid.InputYN();
            if(luaChon.equalsIgnoreCase("n")) return;
        }
    }
    
    public void display(){
        ArrayList<Student> clasifyListStudent = controller.averageStudent();
        HashMap<String, Double> listPercentType = controller.getPercentTypeStudent(clasifyListStudent);
        for(Student obj : clasifyListStudent){
            System.out.println("---- Student"+clasifyListStudent.indexOf(obj)+1+" Info ----");
            obj.print();
        }
        System.out.println("---- Classification Info ----");
        for(Map.Entry student : listPercentType.entrySet()){
            System.out.println(student.getKey() +": "+student.getValue() +"%");
        }
    }
    
}
