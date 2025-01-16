
package app;
/**
 *
 * @author Đàm Quang Chiến
 */
import common.Validation;
import view.WorkerManagementView;
public class App {
    
    Validation valid = new Validation();
    
    public int Menu() {
        System.out.println("1. Add a Worker.\n"
                + "2. Increase salary for worker.\n"
                + "3. Decrease for worker.\n"
                + "4. Show adjusted salary worker information.\n"
                + "5.Exit");
        int luaChon = valid.inputInt(1, 5);
        return luaChon;
    }
    
    public static void main(String[] args) {
        App new_App = new App();
        WorkerManagementView view = new WorkerManagementView();
        int luaChon = new_App.Menu();
        
        while (luaChon != 5) {
            switch (luaChon) {
                case 1: {
                    view.createWorker();
                    luaChon = new_App.Menu();
                    break;
                }
                case 2: {
                    view.changeUpSalary();
                    luaChon = new_App.Menu();
                    break;
                }
                case 3:{
                    view.changeDownSalary();
                    luaChon = new_App.Menu();
                    break;
                }
                case 4:{
                    view.printListHistory();
                    luaChon = new_App.Menu();
                    break;
                }

            }
        }
    }
}
