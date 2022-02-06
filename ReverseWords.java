class ReverseWords{
    public static void reverseWords(char[] message) {

        // first we reverse all the characters in the entire message array
        // this gives us the right word order
        // but with each word backward
        reverseCharacters(message, 0, message.length - 1);
    
        // now we'll make the words forward again
        // by reversing each word's characters
    
        // we hold the index of the *start* of the current word
        // as we look for the *end* of the current word
        int currentWordStartIndex = 0;
        for (int i = 0; i <= message.length; i++) {
    
            // found the end of the current word!
            if (i == message.length || message[i] == ' ') {
    
                // if we haven't exhausted the array, our
                // next word's start is one character ahead
                reverseCharacters(message, currentWordStartIndex, i - 1);
                currentWordStartIndex = i + 1;
            }
        }
    }
    
    private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {
    
        // walk towards the middle, from both sides
        while (leftIndex < rightIndex) {
    
            // swap the left char and right char
            char temp = message[leftIndex];
            message[leftIndex] = message[rightIndex];
            message[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {

        char[] message = { 'c', 'a', 'k', 'e', ' ',
        'p', 'o', 'u', 'n', 'd', ' ',
        's', 't', 'e', 'a', 'l' };

        reverseWords(message);

        System.out.println(message);
        
    }
}
