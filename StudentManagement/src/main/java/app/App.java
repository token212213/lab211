package app;

/**
 *
 * @author Đàm Quang Chiến
 */
import common.Validation;
import java.util.Scanner;

import view.StudentManagementView;

public class App {

    Validation valid = new Validation();// tao doi tuong view trong class management
    Scanner sc = new Scanner(System.in);

    public int Menu() {// tao menu voi option theo de bai
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        int luaChon = valid.inputInt(1, 5);
        return luaChon;     //tra ve option duoc tron
    }

    public static void main(String[] args) {
        App new_App = new App();
        StudentManagementView view = new StudentManagementView();
        int luaChon = new_App.Menu();// hhien thi menu

        while (luaChon != 5) { // swtich case cac option 
            switch (luaChon) {
                case 1: {
                    while (view.creatStudent()) {
                        view.creatStudent();
                    }
                    luaChon=new_App.Menu();
                    break;
                }
                case 2: {
                    view.FindAndSort();
                    luaChon=new_App.Menu();
                    break;
                }
                case 3: {
                    view.UpdateOrDelete();
                    luaChon=new_App.Menu();
                    break;
                }
                case 4: {
                    view.Report();
                    luaChon=new_App.Menu();
                    break;
                }
            }
        }

    }
}
