/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class MergeSort {

    /**
     * @param array
     */
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
    //ham tra ve kich co cua mang
    static int inputSizeArray(int n) {
        return n;
    }
    //ham random gia tri cua mang, tra ve gia tri mang a[]
    static int[] inputValueArray(int n) {
        Random rd = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(10);
        }
        System.out.println("Unsorted array: " + Arrays.toString(a));
        return a;
    }
    
    //chia va sap xep mang a sau do hop lai (de quy)
    static int[] sort(int a[], int left, int right) {
        if (left < right) {
            // Tim diem chinh giua
            int mid = (left + right) / 2;
            
            // ham de quy tiep tuc chia doi
            sort(a, left, mid);
            sort(a, mid + 1, right);
            
            //Hop lai sau khi sap xep
            merge(a, left, mid, right);
        }
        //tra ve ham da duoc sap xep
        return a;
    }
    
    // chia mang ra va sap xep tra ve mang con da duoc sap xep
    static void merge(int a[], int left, int mid, int right) {
        // tim khick thuoc 2 mang con
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // tao mang tam
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy du lieu vao mang tam
        for (int i = 0; i < n1; ++i) {
            L[i] = a[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[mid + 1 + j];
        }

        // hop cac mang tam
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        // sao chep cac phan tu con lai cua L[] neu co
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        // sao chep cac phan tu con lai cua R[] neu co
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
    //ham in ra gia tri cua mang da sap xep
    static void outPut(int[] a) {
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        int arr[] = inputValueArray(inputSizeArray(checkInputInt()));
        outPut(sort(arr,0,arr.length-1)); 
    }
}
