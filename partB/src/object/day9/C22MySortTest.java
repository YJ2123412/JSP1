package object.day9;

import java.util.Arrays;

public class C22MySortTest {
    public static void main(String[] args) {
        
    
        int[] numbers = {67,34, 65, 89,54};
        System.out.println("초기 numbers : "+Arrays.toString(numbers));
        for (int i = 0; i < numbers.length-1; i++) {
           for (int j = i+1; j < numbers.length; j++) {
               // numbers[i]와 numbers[j]교환
               if(numbers[i]>numbers[j]){
                int temp=0;
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
               }
            }
        }
         System.out.println("오름차순 정렬 후 numbers : "+Arrays.toString(numbers));   

       
        }
        
       
      

}