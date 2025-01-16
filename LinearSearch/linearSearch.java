
package j1.s.p0010;

import java.util.Random;
import java.util.Scanner;

public class linearSearch {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    
    //kiem tra dau vao
    int enterNumberArray() {
        int number_Array = 0;
        while (true) {
            try {
                System.out.println("Enter the number of array: ");
                number_Array = Integer.parseInt(sc.next());
                if (number_Array > 0) {
                    break;
                }else System.out.println("The number of array must be positive");
            }catch (NumberFormatException e) {
                System.err.println("Please input the number!");    
            }
        }
        return number_Array;
    }
    
    //nhap gia tri can tim
    int enterSearchValue() {
        int number_Search = 0;
        while (true) {
            try {
                System.out.println("Enter search value: ");
                number_Search = Integer.parseInt(sc.next());
                if (number_Search >= 0) {
                    break;
                }else System.out.println("The number must be positive");
            }catch (NumberFormatException e) {
                System.err.println("Please input the number!");    
            }
        }
        return number_Search;
    }
    
    //tao ham
    int [] createArray(int [] a, int n) {
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(n);
        }
        return a;
    }
    
    //in ham
    void printArray (int [] a) {
        System.out.print("The array: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            }else System.out.print(a[i] + ", ");
        }
        System.out.print("]");
    }
    
    //linear search
    int linearSearch(int [] a, int search_Value) {
        int i=0;
        int index=-1;
        while (i<a.length) {            
            if(a[i]==search_Value) index=i;
        }
        return index;
    }
    
    //in ra vi tri can tim
    void displayIndex(int search_Value, int index) {
        if (index == -1) {
            System.out.println("\nNo value");
        }else System.out.println("\nFound " + search_Value + " at index: " + index );
    }
}
