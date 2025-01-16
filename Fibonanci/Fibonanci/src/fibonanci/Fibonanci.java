
package fibonanci;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Fibonanci {


    public static double Fibonanci(double term, double lower, double higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " \n");
        return Fibonanci(term - 1, higher, higher + lower);
    }
    
    
    public static void main(String[] args) {
        System.out.println("The  sequence fibonacci");
        Fibonanci(1000, 1, 0);
    }
}   
    
    
