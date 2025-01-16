/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Validation;
import java.util.ArrayList;
import model.Car;

/**
 *
 * @author nguyen ngoc quang
 */
public class Controller {
    Validation valid=new Validation();
    public void addCar(ArrayList<Car> list){
        String[] listColorAudi ={"White", "Yellow","Orange"};
        double[] listPriceAudi ={5500, 3000, 4500};
        String[] listDayAudi={"Friday", "Sunday", "Monday"};
        list.add(new Car("Audi", listColorAudi, listPriceAudi, listDayAudi));
       
        String[] listColorMercedes = {"Green", "Blue", "Purple"};
        double[] listPriceMercedes = {5000, 6000, 8500};
        String[] listDayMercedes = {"TuesDay", "Saturday", "Wednesday"};
        list.add(new Car("Mercedes", listColorMercedes, listPriceMercedes, listDayMercedes));        
        
        String[] listColorBMW = {"Pink", "Red", "Brown"};
        double[] listPriceBMW = {2500, 3000, 3500};
        String[] listDayBMW = {"Monday", "Sunday", "Thursday"};
        list.add(new Car("BMW", listColorBMW, listPriceBMW, listDayBMW));
    }


}
