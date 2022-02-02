public class ReverseString{
    public static void reverse(char[] arrayOfChars) {

        int leftIndex = 0;
        int rightIndex = arrayOfChars.length - 1;
    
        while (leftIndex < rightIndex) {
    
            // swap characters
            char temp = arrayOfChars[leftIndex];
            arrayOfChars[leftIndex] = arrayOfChars[rightIndex];
            arrayOfChars[rightIndex] = temp;
    
            // move towards middle
            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {
        char[] myString= {'f','a','c','e','b','o','o','k'};
        reverse(myString);
        for(char ch : myString){
            System.out.print(ch);
        }
    }
}
