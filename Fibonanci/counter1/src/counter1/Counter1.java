package counter1;

import java.util.HashMap; //tao cac lop trong java
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter1 {

    public static void main(String[] args) {
        String str = "viet     nam";
        String regex = "\\s{1,}";
        str = str.replaceAll(regex, " ");
        System.out.println(str);
    }


    //ham display dung de hien thi ket qua cua cac MAP wordcounter va charcounter
    public void display(Map<Character, Integer> charCounter, Map<String, Integer> wordCounter) {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    //ham analyze dung de phan tich chuoi 
    public Map<Character, Integer> analyze(String content) {
        Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
        for (char ch : content.toCharArray()) { // vong for dung de duyet qua tat ca cac ky tu trong chuoi
            if (Character.isSpaceChar(ch)) {
                continue;    //neu ky tu do la 1 dau cach thi se tiep tuc va khong dem ky tu do 
            }
            if (!charCounter.containsKey(ch)) {   //neu ki tu  chua duoc dem
                charCounter.put(ch, 1); // no se them vao charcounter voi gia tri 1
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);  //neu ki tu da duoc dem truoc do thi no se tang gia tri hien tai them 1
            }
        }

        return charCounter;
    }

    public Map<String, Integer> analyze2(String content) {
        Map<String, Integer> wordCounter = new HashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(content, " ,.;:|@#$%^&*?/~-=+");  //tach cac chuoi dau vao
        while (tokenizer.hasMoreTokens()) { //ham while dung de duyet qua tung tu
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) { // neu tu do chua duoc dem truoc do 
                wordCounter.put(token, 1); //thi se them vao wordcounter va dat gia tri la 1
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1); //neu da duoc dem truoc do thi se tang gia tri len 1
            }
        }
        return wordCounter;
    }

    
}
