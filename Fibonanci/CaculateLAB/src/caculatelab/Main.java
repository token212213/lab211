/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caculatelab;

import view.Display;

/**
 *
 * @author nguyen ngoc quang
 */
public class Main {

    public static void main(String[] args) {
        Display d=new Display();
        //loop until user want to exit
        while (true) {
            int choice = d.menu();
            System.out.println();
            switch (choice) {
                case 1:
                    d.superlativeEquation();
                    break;
                case 2:
                    d.quadraticEquation();
                    break;
                case 3:
                    return;                 
            }
        }
    }
}

