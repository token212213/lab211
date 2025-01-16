/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Validation;
import controller.Controller;
import java.util.ArrayList;
import model.Car;

/**
 *
 * @author nguyen ngoc quang
 */
public class Management {

    ArrayList<Car> lc = new ArrayList<>();
    Validation valid = new Validation();
    Car car = new Car();
    Controller controller = new Controller();

    public boolean checkNameCar(ArrayList<Car> lc, String name, String color,
            double price, String day) {
        boolean check = false;
        for (int i = 0; i < lc.size(); i++) {
            if (name.equalsIgnoreCase(lc.get(i).getName())) {
                if (valid.InputCar(lc.get(i), color, price, day)) {
                    System.out.println("Sell Car");
                    System.out.print("Do you want find more?(Y/N): ");
                    String choice = valid.InputYN();
                    if (choice.equalsIgnoreCase("n")) {
                        System.out.println("Car break");
                        return false;
                    }
                }
            }
            check = true;
            break;
        }
        if (check == false) {
            System.out.println("Can't find car.");
        }
        return true;
    }

    public void Create() {
        System.out.println("===== Showroom car program =====\nInput Information of Car ");
        System.out.println("Name: ");
        String name = valid.inputName();
        System.out.println("Color: ");
        String color = valid.inputString();
        System.out.println("Price: ");
        double price = valid.inputInt();
        System.out.println("Today: ");
        String day = valid.inputString();
        if (!checkNameCar(lc, name, color, price, day)) {
            return;
        }
    }
}
   
