
package j1.s.p0006;

import java.util.Random;
import java.util.Scanner;

public class binarySearch {
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
    
    //sap xep
    void bubbleSort(int [] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1] ) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //in ham
    void printArray (int [] a) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            }else System.out.print(a[i] + ", ");
        }
        System.out.print("]");
    }  
    //linear search
    int binarySearch(int [] a,int l, int r, int search_Value) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // Nếu phần tử có ở chính giữa
            if (a[mid] == search_Value)
                return mid;
            // Nếu phần tử nhỏ hơn giữa, thì nó chỉ có thể
            // hiện diện trong mảng con bên trái
            if (a[mid] > search_Value)
                return binarySearch(a, l, mid - 1, search_Value);
            // Ngược lại, phần tử chỉ có thể có mặt
            // trong mảng con bên phải
            return binarySearch(a, mid + 1, r, search_Value);
        }
        // Nếu phần tử không có trong mảng
        return -1;
    }
    
    //in ra vi tri can tim
    void displayIndex(int search_Value, int index) {
        if (index == -1) {
            System.out.println("\nNo value");
        }else System.out.println("\nFound " + search_Value + " at index: " + index );
    } 
}
