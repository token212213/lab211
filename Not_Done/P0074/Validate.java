/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.util.Scanner;

/**
 *
 * @author Acer Nitro5
 */
public class Validate {
    
    Scanner sc = new Scanner(System.in);
   // ham check check input 
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String tb = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(tb);
                //nếu nhập vào là số và trong khoảng ddieuf kien 
                // chuong trình tiep tuc chạy
                if (Integer.parseInt(tb) == Integer.parseInt(tb) && num >= min && num <= max) {
                    return num;
                }else {
                    // nếu là số âm hoặc vượt quá sẽ yêu cầu nhập lại
                        System.out.print("Choice must in range [" + min +" - "
                                + max + "], enter again: ");
                    }
                // yêu cầu nhập lại nếu là ký tự đặc biệt hoặc là chữ
            } catch (NumberFormatException e) {
                System.out.print("You must enter number, enter again: ");
            }
        }
    }
       // hàm gọi ma trận
        public int[][] getMatrix(int col, int row) {
        int matrix[][] = new int[row][col];
    for (int i =0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            matrix[i][j] = inputInt("Enter matrix[" + i + "][" + j + "]: ",Integer.MIN_VALUE,Integer.MAX_VALUE);
            }
        }
        return matrix;
    }
    //hàm in ra ma trận
    public void printMatrix(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }
}
