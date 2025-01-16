
package controller;

/**
 *
 * @author Đàm Quang Chiến
 */
import java.util.ArrayList;
import java.util.Date;
import model.*;


public class ProductController {
    ArrayList<Storekeeper> listStoreKeeper = new ArrayList<>();
    ArrayList<Product> listProduct = new ArrayList<>();
    
    //check Function
    public boolean checkIdStoreKeeperExist(String id){ // check id da ton tai trong danh sach keeper hay chua
        boolean result = false;
        for(Storekeeper obj : listStoreKeeper){
            if(obj.getStorekeeperId().equals(id)) {
                result= true;
                break;
            }
        }
        return result;
    }
    
    public boolean checkIdProductExist(String id){ // check id da ton tai trong danh sach product hay chua
        for(Product obj : listProduct){
            if(obj.getId().equals(id)) return true;
        }
        return false;
    }
    
    public boolean isListStoreKeeperEmpty(){
        return listStoreKeeper.isEmpty();
    }
    
    public boolean checkDuplicateProduct(Product pro){
        boolean result = true;
        for(Product product : listProduct){
            if(product.equals(pro)){
                result =false;
                break;
            }
        }
        return result;
    }
    
    // add function
    public void addStorekeeper(Storekeeper keeper){
        listStoreKeeper.add(keeper);
        
    }
    
    public void addProduct(Product product){
        listProduct.add(product);
    }
    
    
    
    // chon storekeeper tu list 
    public Storekeeper chooseStorekeeper(String id){
       
        for(Storekeeper keeper : listStoreKeeper){
            if(keeper.getStorekeeperId().equals(id)) return keeper;;
        }  
        return null;
    }
    
    
    //print list storekeeper
    public void printListStorekeeper(){
        System.out.printf("%-5s%5s\n","ID","Name");
        for(Storekeeper keeper : listStoreKeeper){
            keeper.print();
        }
    }
    
    public void updateProduct(Product pro){
        int index =0;
        for(Product product : listProduct){
            if(pro.getId().equals(product.getId())){
                product.setCategory(pro.getCategory());
                product.setExpDate(pro.getExpDate());
                product.setLocation(pro.getLocation());
                product.setManuDate(pro.getManuDate());
                product.setName(pro.getName());
                product.setPrice(pro.getPrice());
                product.setReceiptDate(pro.getReceiptDate());
                product.setStorekeeper(pro.getStorekeeper());
            } 
        }   
    }
    
    public ArrayList sreachByCondition(String name, String category, Date ReceiptDate){
        //    String id, String name, String location, double price, Date expDate, Date manuDate, Storekeeper storekeeper, Date receiptDate, String category
        ArrayList<Product> list = new ArrayList<>();
        System.out.printf("%-5s%-15s%-10s%-5s%-8s%-8s%-8s%-15s%-8s\n", "ID", "Name", "Location", "Price", "ExpDate", "ManuDate", "RecriptDate","Storekeeper", "Category");
        for(Product product : listProduct){
            if(product.getName().equalsIgnoreCase(name) && product.getCategory().equalsIgnoreCase(category) && product.getReceiptDate().compareTo(ReceiptDate)==0){
                list.add(product);
            }
        }
        return list;
    }
}
