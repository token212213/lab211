package app;

import common.Validation;
import view.CaculatorApplicationView;

public class App {

    Validation valid = new Validation();

    public int menu() {
        System.out.println("==== Calculator Program ====");
        System.out.println("1. Normal Calculator\n"
                + "2. BMI Calculator\n"
                + "3. Exit\n"
                + "Please choose one option: ");
        return valid.inputInt(1, 3);
    }

    public static void main(String[] args) {
        App app = new App();
        CaculatorApplicationView view = new CaculatorApplicationView();
        int luaChon = app.menu();
        while (luaChon != 3) {
            switch (luaChon) {
                case 1: {
                    view.normalCalculator();
                    luaChon = app.menu();
                    break;
                }
                case 2: {
                    view.IBMCalculator();
                    luaChon = app.menu();
                    break;
                }

            }
        }

    }

}
