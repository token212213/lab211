
package j1.s.p0006;

public class J1SP0006 {

    public static void main(String[] args) {
        binarySearch search = new binarySearch();
        int number_Array = search.enterNumberArray();
        int arr[] = new int [number_Array];
        //tao mang
        search.createArray(arr, number_Array);
        //nhap gia tri can tim
        int search_Value = search.enterSearchValue();  
        //sap xep mang
        search.bubbleSort(arr);
        //in mang
        search.printArray(arr);
        //tim vi tri gia tri can tim
        int index = search.binarySearch(arr, 0, arr.length -1, search_Value);
        //in ra vi tri gia tri can tim
        search.displayIndex(search_Value, index);
        
    }
    
}
