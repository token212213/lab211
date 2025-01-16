/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.Validate;

/**
 *
 * @author Acer Nitro5
 */
public class Controller {
    //ham check kích co ma tran bang nhau
    public int inputEqualNum(int num, String title) {
        int number;
        Validate m = new Validate();
        while (true) {
            number = m.inputInt("Enter " + title + " matrix 2: ", 1, Integer.MAX_VALUE);
            // neu gia tri của só hang va cot cua ma tran 2 
            //bằng gia tri của số hang va cot của ma tran 1 
            // chương trình sẽ chạy tiếp
            if (number == num) {
                break;
            } else {
                // Không bằng in ra thông báo và yêu cầu nhập lại
                System.out.println(title + " 2 must equal "+title+" 1");
            }
        }
        return number;
    }
    //phep cong ma tran
    public int[][] addMatrix(int matrix1[][], int matrix2[][]) {
         Validate m = new Validate();
        int row1 = m.inputInt("Enter row matrix 1: ", 1, Integer.MAX_VALUE);
        int col1 = m.inputInt("Enter column matrix 1: ", 1, Integer.MAX_VALUE);
        matrix1 = m.getMatrix(col1, row1); // in ra ma trận 1

        int row2;
        int col2;
        // check số hàng và cột ma trận 2
        row2 = inputEqualNum(row1, "row");
        col2 = inputEqualNum(col1, "column");
         matrix2 = m.getMatrix(col2, row2); // in ra ma trận 2
        
        // phep cong ma tran
        int result[][] = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        //in ra ket quả phép cộng ma trận
        System.out.println("-----Result-----");
        m.printMatrix(matrix1, row1, col1);
        System.out.println("+");
        m.printMatrix(matrix2, row2, col2);
        System.out.println("=");
        m.printMatrix(result, row2, col2);
        return result;
    }
    //phep tru ma tran
    public void subMatrix() {
        Validate m = new Validate();
        int row1 = m.inputInt("Enter row matrix 1: ", 1, Integer.MAX_VALUE);
        int col1 = m.inputInt("Enter column matrix 1: ", 1, Integer.MAX_VALUE);
        int matrix1[][] = m.getMatrix(col1, row1); // in ra ma trận 1

        int row2 ;
        int col2 ;
        // check số hàng và cột ma trận 2
        row2 = inputEqualNum(row1, "row");
        col2 = inputEqualNum(col1, "column");
        int matrix2[][] = m.getMatrix(col2, row2);
        
        // phep tru ma tran
        int result[][] = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        //in ra ket quả phép trừ ma trận
        System.out.println("-----Result-----");
        m.printMatrix(matrix1, row1, col1);
        System.out.println("-");
        m.printMatrix(matrix2, row2, col2);
        System.out.println("=");
        m.printMatrix(result, row2, col2);
    }
    
    // phep nhan ma tran
    public void multiMatrix() {
        Validate m = new Validate();
        int row1 = m.inputInt("Enter row matrix 1: ",1,Integer.MAX_VALUE);
        int col1 = m.inputInt("Enter column matrix 1: ",1,Integer.MAX_VALUE);
        int matrix1[][] = m.getMatrix(col1, row1); // in ra ma trận 1
        int row2;
        while (true) {
            // diều kiên của phép nhân ma trận:
            // số cột của matrix 1 bằng số hàng của matrix 2
            row2 = m.inputInt("Enter row matrix 2: ",1,Integer.MAX_VALUE);
            if (row2 == col1) {
                break;
                // Không sẽ in ra thông báo và yêu cầu nhập lại
            } else {
                System.out.println("Row 2 must equal col 1");
            }
        }
        int col2 = m.inputInt("Enter column matrix 2: ",1,Integer.MAX_VALUE);

        int matrix2[][] = m.getMatrix(col2, row2);
       
        //phep nhan ma tran
        int result[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) { // chỉ số chung của 2 ma trận
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        //in ra ket quả phép nhan ma trận
        System.out.println("-----Result-----");
        m.printMatrix(matrix1, row1, col1);
        System.out.println("*");
        m.printMatrix(matrix2, row2, col2);
        System.out.println("=");
        m.printMatrix(result, row1, col2);
    }
}
