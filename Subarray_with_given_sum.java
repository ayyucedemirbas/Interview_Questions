/*Given an unsorted array A of size N that contains only non-negative integers, 
find a continuous sub-array which adds to a given number S.*/


// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Array{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Subarray obj = new Subarray();
            ArrayList<Integer> res = obj.subarraySum(n, s, m);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Subarray{
    static ArrayList<Integer> subarraySum(int n, int sum, int[] arr) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int curr_sum = arr[0], start = 0, i; 
       for (i = 1; i <= n; i++) { 
            // If curr_sum exceeds the sum, 
            // then remove the starting elements 
            while (curr_sum > sum && start < i - 1) { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
  
            // If curr_sum becomes equal to sum, 
            // then return true 
            if (curr_sum == sum) { 
                int p = i - 1; 
                indexes.add(start+1);
                indexes.add(p+1);
                return indexes; 
            } 
  
            // Add this element to curr_sum 
            if (i < n) 
                curr_sum = curr_sum + arr[i]; 
        } 
        indexes.add(-1);
        return indexes; 
        
    }
}
