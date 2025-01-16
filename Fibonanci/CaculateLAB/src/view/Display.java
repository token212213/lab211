/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import validation.Valid;

/**
 *
 * @author nguyen ngoc quang
 */
public class Display {

    Valid vl = new Valid();
    Controller control = new Controller();
    
    
    public int menu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Superlative Equation");
        System.out.println("3. Exit");
        int choice = vl.checkIntputIntLimit(1, 3);
        return choice;
    }

    public void DisplaySuperlativeEquation() {
        System.out.println("----- Calculate Equation -----");
        System.out.print("Enter A: ");
        double a = vl.checkInputDouble();
        System.out.print("Enter B: ");
        double b = vl.checkInputDouble();
    }
    
    public void printCheck(ArrayList<Double> list){
        String listOdd = "Number is odd: ";
        String listEven = "Number is Even: ";
        String listSquare = "Number is Perfect Square: ";
        for(int i=0; i<control.getArrayList().size();i++){
            if(vl.checkOdd(control.getArrayList().get(i))){
                listOdd = listOdd + control.getArrayList().get(i) +", ";
            }else listEven = listEven + control.getArrayList().get(i) +", ";
            
            if(vl.checkSquareNumber(control.getArrayList().get(i))) listSquare = listSquare + control.getArrayList().get(i) +", ";
        }
        System.out.println(listOdd.substring(0, listOdd.length()-2));
        System.out.println(listEven.substring(0, listEven.length()-2));
        System.out.println(listSquare.substring(0, listSquare.length()-2));
        
    }

    public void superlativeEquation() {
        System.out.println("----- Calculate Equation -----");
        System.out.print("Enter A: ");
        double a = vl.checkInputDouble();
        System.out.print("Enter B: ");
        double b = vl.checkInputDouble();
        double x = -b / a;
        System.out.println("Solution: x=" + x);
        control.addNum(a);
        control.addNum(b);
        control.addNum(x);
        printCheck(control.getArrayList()); 
        control.clearList();
    }

    public void quadraticEquation() {
        //calculate
        System.out.println("----- Calculate Quadratic Equation -----");
        System.out.print("Enter A: ");
        double a = vl.checkInputDouble();
        System.out.print("Enter B: ");
        double b = vl.checkInputDouble();
        System.out.print("Enter C: ");
        double c = vl.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        control.addNum(a);
        control.addNum(b);
        control.addNum(c);
        control.addNum(x1);
        control.addNum(x2);
        printCheck(control.getArrayList()); 
        control.clearList();
    } 
}
