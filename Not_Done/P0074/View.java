/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Common.Validate;
import Controller.Controller;

/**
 *
 * @author Acer Nitro5
 */
public class View {
    public void menu(){
    Controller c = new Controller();
    Validate m = new Validate();
        while (true) {
        int matrix1,matrix2;
        //bảng menu
        System.out.println("======Calculator program=====");
        System.out.println("1. Addition matrix");
        System.out.println("2. Subtraction matrix");
        System.out.println("3. Multion matrix"); 
        System.out.println("4. Quit");
        int choice = m.inputInt("Enter Your choice: ",1, 4); 
            switch (choice) {
                case 1:
                    c.addMatrix();
                    break;
                case 2:
                    c.subMatrix();
                    break;
                case 3:
                    c.multiMatrix();
                    break;
                case 4:
                    return;
            }
        }
        }
}
