
package app;

import view.ClassifyStudentView;

public class App {
    public static void main(String[] args) {
        ClassifyStudentView view = new ClassifyStudentView();
        view.addStudent();
        view.display();
    }
}
