
package model;


public class Student {
    private String stuName;
    private String className;
    private double markMath, markPhysic, markChemis;
    private double markAverage;
    private String type;

    public Student() {
    }

    public Student(String stuName, String className, double markMath, double markPhysic, double markChemis, double markAverage, String type) {
        this.stuName = stuName;
        this.className = className;
        this.markMath = markMath;
        this.markPhysic = markPhysic;
        this.markChemis = markChemis;
        this.markAverage = markAverage;
        this.type = type;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMarkMath() {
        return markMath;
    }

    public void setMarkMath(double markMath) {
        this.markMath = markMath;
    }

    public double getMarkPhysic() {
        return markPhysic;
    }

    public void setMarkPhysic(double markPhysic) {
        this.markPhysic = markPhysic;
    }

    public double getMarkChemis() {
        return markChemis;
    }

    public void setMarkChemis(double markChemis) {
        this.markChemis = markChemis;
    }

    public double getMarkAverage() {
        return markAverage;
    }

    public void setMarkAverage(double markAverage) {
        this.markAverage = markAverage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String selectType(double avgMark){
        if(avgMark > 7.5) return "A";
        else if(avgMark>=6 && avgMark <=7.5) return "B";
        else if(avgMark>=4 && avgMark <6) return "C";
        else return "D";
    }
    
    public void print(){
        System.out.println("Name: " +this.stuName);
        System.out.println("Classes: " + this.className);
        System.out.println("AVG: "+this.markAverage);
        System.out.println("Type: "+this.type);
    }
    
    
}
