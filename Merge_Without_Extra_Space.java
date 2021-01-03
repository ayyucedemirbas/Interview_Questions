// { Driver Code Starts
//Initial Template for Java
/*Given two sorted arrays arr1[] and arr2[] of sizes N and M in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements. 
 

Example 1:

Input: 
N = 4, arr1[] = [1 3 5 7] 
M = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation: After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
 

Example 2:

Input: 
N = 2, arr1[] = [10, 12] 
M = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation: After merging two sorted arrays 
we get 5 10 12 18 20.

Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, N and M as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.


Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)*/


import java.util.*;
import java.io.*;
import java.io.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    new MergeSort().merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class MergeSort
{
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here 
        
        /*int  j=0, tmp=0;
        for(int i=m-1; i>=0; i--){
            tmp=arr1[n-1];
            for(j=n-2; j>=0 && arr2[i] < arr1[j]; j--){
                arr1[j+1] = arr1[j];
            }
            
            
            if(j != n-2 || tmp > arr2[i]){
                arr1[j+1] = arr2[i];
                arr2[i] = tmp;
            }
        }*/
        int i=n-1,j=0;
        while (i>=0 && j<m) {
        if(arr1[i]>arr2[j]){
            int temp=arr1[i];
            arr1[i]=arr2[j];
            arr2[j]=temp;
            i--;
        }
        else j++;
            }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
}
