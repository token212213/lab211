

package model;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Student implements Comparable<Student>{ // tao doi tuong student implements phuong thuc comparable de so sanh
    
    private String id;
    private String name;
    private String courseName;
    private String semester;

    public Student() {
    }

    public Student(String id, String name, String courseName, String semester) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public int compareTo(Student t) { // abstract method dung de so sanh ten cua hoc sinh
        return this.name.compareTo(t.name);
    }

    public void print(){
        System.out.printf("%-15s%-15s%-15s\n", name, semester, courseName);// in student theo format
    }
}
