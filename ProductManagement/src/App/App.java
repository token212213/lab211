
package App;
import common.Validation;
import java.text.ParseException;
import java.util.Scanner;
import view.ProductView;

public class App {
    
    
    
    public int Menu() { // tao menu 
        Validation valid = new Validation();
        System.out.println("Main menu:\n"
                + "1. Add Storekeeper\n"
                + "2. Add product\n"
                + "3. Update product\n"
                + "4. Search product byExpiry date, Date of m (Name, Category, Storekeeper, ReceiptDate)\n"
                + "5. Sort product by Expiry date, Date of manufacture\n"
                + "0. Exit");
        return valid.inputInt(0, 5);
    }
    
    public static void main(String[] args) throws ParseException {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        ProductView view = new ProductView();
        
        
        int luaChon = app.Menu();
        
        while (luaChon != 0) { // swtich case cac option 
            switch (luaChon) {
                case 1: {
                    view.createStorekeeper();
                    luaChon = app.Menu();
                    break;
                }
                case 2: {
                    view.createProduct();
                    luaChon = app.Menu();
                    break;
                }
                case 3: {
                    view.updateProduct();
                    luaChon = app.Menu();
                    break;
                }
                case 4: {
                    
                    break;
                }
                case 5:{
                
                }
            }
        }
        
    }
}
