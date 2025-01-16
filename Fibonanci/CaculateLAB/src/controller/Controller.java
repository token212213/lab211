/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import validation.Valid;

/**
 *
 * @author nguyen ngoc quang
 */
public class Controller {

    private static final Scanner in = new Scanner(System.in);
    Valid vl = new Valid();

    ArrayList<Double> arrayList = new ArrayList<>();
    
    public void addNum(double n){
        if(Double.isNaN(n)==false) arrayList.add(n);
    }

    public ArrayList<Double> getArrayList() {
        return arrayList;
    }
   public void clearList(){
       arrayList.clear();
   }
}
