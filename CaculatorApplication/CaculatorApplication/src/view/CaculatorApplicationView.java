
package view;

import common.Validation;

public class CaculatorApplicationView {
    Validation valid = new Validation();
    
    

    public void normalCalculator(){
        System.out.println("----- Normal Calculator -----");
        double memory;
        System.out.print("Enter a number: ");
        memory = valid.inputdouble();
        while(true){
            System.out.print("Enter Operator: ");
            String operator = valid.inputOperator();
            switch (operator) {
                case "+":{
                    System.out.print("Enter a number: ");
                    memory += valid.inputdouble();
                    System.out.println("Memory: "+memory);
                    break;
                }
                case "-":{
                    System.out.print("Enter a number: ");
                    memory -= valid.inputdouble();
                    System.out.println("Memory: "+memory);
                    break;
                }
                case "*":{
                    System.out.print("Enter a number: ");
                    memory *= valid.inputdouble();
                    System.out.println("Memory: "+memory);
                    break;
                }
                case "/":{
                    System.out.print("Enter a number: ");
                    memory /= valid.inputdouble();
                    System.out.println("Memory: "+memory);
                    break;
                }
                case "^":{
                    System.out.print("Enter a number: ");
                    memory = Math.pow(memory, valid.inputdouble());
                    System.out.println("Memory: "+memory);
                    break;
                }
                case "=":{
                    System.out.println("Result: "+memory);
                    return;
                }

            }
        }
    }
    
    public void IBMCalculator() {
        double weight = valid.inputdoubleBMI("Enter Weight(kg): ");
        double height = valid.inputdoubleBMI("Enter Height(cm): ");
        double BMI = weight / Math.pow(height / 100, 2);
        System.out.println("BMI Number: " + Math.round(BMI * 10) / 10);
        if (BMI < 19) {
            System.out.println("Under-standard");
        } else if ( BMI < 25) {
            System.out.println("Standard");
        } else if ( BMI < 30) {
            System.out.println("Overweight");
        } else if ( BMI < 40) {
            System.out.println("Fat - should lose weight");
        } else {
            System.out.println("Very fat - should lose weight immediately");
        }
    }
    
}
