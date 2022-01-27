import java.util.*;

public class SliceArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] myArray=new int[10];

        for(int i=0; i<10; i++){
            myArray[i]=rand.nextInt(1000);
        }

        for(int num : myArray){
            System.out.print(num + ", ");
            
        }
        System.out.println(" ");
        int[] tailOfArray = Arrays.copyOfRange(myArray, 1, myArray.length);

        for(int num : tailOfArray){
            System.out.print(num + ", ");
        }

        System.out.println(" ");

        for (int item : Arrays.copyOfRange(myArray, 1, myArray.length)) {
            // whoops, I just spent O(n) time and space!
            System.out.print(item + ", ");
        }
        
        
    }
}
