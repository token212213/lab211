
package model;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Report extends Student{ // tao doi tuong report extends doi tuong student
    
    private int totalCourse; // doi tuong report co them thuoc tinh la so luong course tham gia

    public Report() {
    }


    public Report(int totalCourse, String id, String name, String courseName, String semester) {
        super(id, name, courseName, semester);
        this.totalCourse = totalCourse;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    public void print(){
        System.out.printf("%-15s|%-15s|%-15d\n",this.getName(), this.getCourseName(), totalCourse); // in ra ten va courseName theo format
    }
}
