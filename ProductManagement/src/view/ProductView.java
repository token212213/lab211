package view;

import common.Validation;
import controller.ProductController;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import model.*;

public class ProductView {

    Validation valid = new Validation();
    ProductController controller = new ProductController();

    public void createStorekeeper() { // tao mot storekeeper
        System.out.println("Enter storekeeper id: ");//nhap id storekeeper
        String id = valid.inputString();
        while (controller.checkIdStoreKeeperExist(id)) {//kiem tra neu id ton tai yeu cau nhap lai id khac
            System.out.println("ID has existed, please enter id again!");
            id = valid.inputString();
        }
        System.out.println("Enter storekeeper name: ");//nhap name storekeeper
        String name = valid.inputString();
        Storekeeper keeper = new Storekeeper(id, name);
        controller.addStorekeeper(keeper);
        System.out.println("Create successfully!");
    }

    public void createProduct() throws ParseException {
        if (controller.isListStoreKeeperEmpty()) {
            System.out.println("List storekeeper is empty!");
            System.out.println("Please create storekeeper first!");
            return;
        }
        // nhap va kiem tra  du lieu tu ban phim
        System.out.println("Enter product id: ");
        String id = valid.inputString();
        while (controller.checkIdProductExist(id)) {//kiem tra neu id ton tai yeu cau nhap lai id khac
            System.out.println("ID has existed, please enter id again!");
            id = valid.inputString();
        }
        System.out.println("Enter product name: ");
        String name = valid.inputString();
        System.out.println("Enter location: ");
        String location = valid.inputString();
        System.out.println("Enter price: ");
        double price = valid.inputdouble(0);
        
        // enter date
        System.out.println("Enter date of manufacture: ");
        Date manuDate = valid.inputManuDate();
        System.out.println("Enter expire date: ");
        Date expDate = valid.inputDate();
        System.out.println("Enter reception date: ");
        Date receiptDate = valid.inputDate();
        while (valid.compareDate(receiptDate, manuDate) < 0 || valid.compareDate(receiptDate, expDate) > 0) {
            System.out.println("Must Receiptenter date greater than or equal manuDate and less than Expire Date!");
            receiptDate = valid.inputDate();
        }
        while (valid.compareDate(expDate, manuDate) < 0) {
            System.out.println("Expire date must be greater than manuDate, enter again!");
            expDate = valid.inputDate();
        }

        // chon id cua store keeper de lay ra mot doi tuong storekeeper
        System.out.println("Enter id of storekeeper that you want to choose: ");
        controller.printListStorekeeper();
        String idKeeper = valid.inputString();
        while (!controller.checkIdStoreKeeperExist(idKeeper)) {//kiem tra neu id ton tai yeu cau nhap lai id khac
            System.out.println("ID does not exist, please enter id again!");
            idKeeper = valid.inputString();
        }
        Storekeeper keeper = controller.chooseStorekeeper(id);

        System.out.println("Enter category: ");
        String category = valid.inputString();
        //tao doi tuong product
        Product product = new Product(id, name, location, price, expDate, manuDate, keeper, receiptDate, category);
        controller.addProduct(product);
        System.out.println("Create successfully!");
    }

    public void updateProduct() throws ParseException {
        System.out.println("Enter ID of product:");
        String id = valid.inputString();
        while (!controller.checkIdProductExist(id)) {//kiem tra neu id ton tai yeu cau nhap lai id khac
            System.out.println("ID does not exist, please enter id again!");
            id = valid.inputString();
        }
        while (true) {
            System.out.println("Enter product name: ");
            String name = valid.inputString();
            System.out.println("Enter location: ");
            String location = valid.inputString();
            System.out.println("Enter price: ");
            double price = valid.inputdouble(0);

            System.out.println("Enter date of manufacture: ");
            Date manuDate = valid.inputManuDate();
            System.out.println("Enter expire date: ");
            Date expDate = valid.inputDate();
            System.out.println("Enter reception date: ");
            Date receiptDate = valid.inputDate();
            while (valid.compareDate(receiptDate, manuDate) < 0 || valid.compareDate(receiptDate, expDate) > 0) {
                System.out.println("Must Receiptenter date greater than or equal manuDate and less than Expire Date!");
                receiptDate = valid.inputDate();
            }
            while (valid.compareDate(expDate, manuDate) < 0) {
                System.out.println("Expire date must be greater than manuDate, enter again!");
                expDate = valid.inputDate();
            }

            // chon id cua store keeper de lay ra mot doi tuong storekeeper
            System.out.println("Enter id of storekeeper that you want to choose: ");
            controller.printListStorekeeper();
            String idKeeper = valid.inputString();
            while (!controller.checkIdStoreKeeperExist(idKeeper)) {//kiem tra neu id ton tai yeu cau nhap lai id khac
                System.out.println("ID does not exist, please enter id again!");
                idKeeper = valid.inputString();
            }
            Storekeeper keeper = controller.chooseStorekeeper(id);

            System.out.println("Enter category: ");
            String category = valid.inputString();
            Product product = new Product(id, name, location, price, expDate, manuDate, keeper, receiptDate, category);
            controller.updateProduct(product);
            System.out.println("Update successfully!");
        }

    }

    public void searchByCondition() {
        System.out.println("Enter product name: ");
        String name = valid.inputString();
        System.out.println("Enter category: ");
        String category = valid.inputString();
        System.out.println("Enter reception date: ");
        Date receiptDate = valid.inputDate();
    }

}
