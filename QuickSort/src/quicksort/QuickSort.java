
package quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class QuickSort {
    static final Scanner sc = new Scanner(System.in);
    
    //ham checkInputInt kiem tra ky tu nhap la so nguyen duong
    static int checkInputInt() {
        System.out.println("Enter number of array: ");
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n < 0) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println("Please enter positive decimal number.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    //ham tra ve kich co cua mang sau khi nhap so nguyen duong
    static int inputSizeArray(int n) {
        return n;
    }
    
    //ham gan gia tri random vao mang, tra ve mang a[] 
    static int[] inputValueArray(int n) {
        Random rd = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(10);
        }
        System.out.println("Unsorted array: " + Arrays.toString(a));
        return a;
    }

//    ham nhan phan tu nhau nhien lam chot,
//    sap xep cac phan tu nho hon chot o truoc
//    va lon hon o sau no,
    static int partition(int a[], int left, int right) {
        
        //khai bao 2 bien dem 
        int i = left, j = right;
        
        //khai bao pivot vi tri ngau nhien trong mang
        int randomValue = new Random().nextInt(right-left)+left;
        int pivot = a[randomValue];
        
        //sap xep cac phan tu trong mang
        while (i <= j) {
            //neu phan tu ben trai nho hon pivot, tang gia tri cua no len 1
            while (a[i] > pivot) {
                i++;
            }
            //neu phan ben phai lon hon pivot, giam gia tri cua no di 1
            while (a[j] < pivot) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        return i;
    }
    //chia mang ra va sap xep tra ve mang con da duoc sap xep(de quy)
    static int[] quickSort(int a[], int left, int right) {
        // index la chi muc, a[index] la vi tri chot 
        int index = partition(a, left, right);
        
        if (left < index - 1) {
            quickSort(a, left, index - 1);// truoc index
        }
        if (index < right) {
            quickSort(a, index, right);// sau index
        }
        return a;
    }
    //ham doi gia tri o vi tri i,j
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //ham in ra gia tri cua mang da sap xep
    static void outPut(int[] a) {
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        for(int i =0; i<=9999; i++){
            if(i<10)System.out.println("000"+i);
            else if(i<100)System.out.println("00"+i);
            else if(i<1000)System.out.println("0"+i);
            else System.out.println(i);
        }
    }
}
