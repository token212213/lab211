
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Student;

public class ClassifyStudentController {
    
    Student st = new Student();
    ArrayList<Student> students = new ArrayList<>();
    
    public void addStudent(Student st){
        students.add(st);
    }
    
    public ArrayList<Student> averageStudent(){
        ArrayList<Student> averageStudents = new ArrayList<>();
        for(int i=0; i< students.size();i++){
            double markMath = students.get(i).getMarkMath();
            double markPhysic = students.get(i).getMarkPhysic();
            double markChemis = students.get(i).getMarkChemis();
            double markaverage = (markChemis + markMath + markPhysic) / 3;
            String type = st.selectType(markaverage);
            students.get(i).setType(type);
            students.get(i).setMarkAverage(markaverage);
            Student st = students.get(i);
            averageStudents.add(st);
        }
        return averageStudents;
    }
    
    public HashMap<String, Double> getPercentTypeStudent(ArrayList<Student> listStudent){
        Map<String, Double> getPercentTypeStudent = new HashMap<>();
        int totalStudent = listStudent.size();
        
        double numberOfTypeA = 0;
        double numberOfTypeB = 0;
        double numberOfTypeC = 0;
        double numberOfTypeD = 0;
        
        for(int i=0; i< totalStudent;i++){
            String type = listStudent.get(i).getType();
            if(type.equals("A")) numberOfTypeA++;
            else if(type.equals("B")) numberOfTypeB++;
            else if(type.equals("C")) numberOfTypeC++;
            else if(type.equals('D')) numberOfTypeD++;
        }
        
        getPercentTypeStudent.put("A", numberOfTypeA/totalStudent*100);
        getPercentTypeStudent.put("B", numberOfTypeB/totalStudent*100);
        getPercentTypeStudent.put("C", numberOfTypeC/totalStudent*100);
        getPercentTypeStudent.put("D", numberOfTypeD/totalStudent*100);
        
        return (HashMap<String, Double>) getPercentTypeStudent;
    }
}
