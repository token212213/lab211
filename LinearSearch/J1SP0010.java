
package j1.s.p0010;

public class J1SP0010 {

    public static void main(String[] args) {
        linearSearch search = new linearSearch();
        //nhap so luong ki tu trong day
        int number_Array = search.enterNumberArray();
        int arr[] = new int [number_Array];
        //tao mang
        search.createArray(arr, number_Array);
        //nhap gia tri can tim
        int search_Value = search.enterSearchValue();  
        //in mang
        search.printArray(arr);
        //tim vi tri gia tri can tim
        int index = search.linearSearch(arr, search_Value);
        //in ra vi tri gia tri can tim
        search.displayIndex(search_Value, index);
        
    }
    
}
