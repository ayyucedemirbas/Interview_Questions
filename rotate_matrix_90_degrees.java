import java.util.*;
class rotate {
//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree/0
/*Given an square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.
Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of the square matrix.The second line of each test case contains NxN space separated values of the matrix M.
Output:
Corresponding to each test case, in a new line, print the rotated array.
Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 50
Example:
Input
1
3
1 2 3 4 5 6 7 8 9
Output
3 6 9 2 5 8 1 4 7
*/


    static void rotateMatrix(int N, int mat[][])  {
       
        for (int x = 0; x < N / 2; x++){
           
            for (int y = x; y < N-x-1; y++) {
               
                int temp = mat[x][y];
      
               
                mat[x][y] = mat[y][N-1-x];
      
                
                mat[y][N-1-x] = mat[N-1-x][N-1-y];
      
              
                mat[N-1-x][N-1-y] = mat[N-1-y][x];
      
               
                mat[N-1-y][x] = temp;
            }
        }
    }
   
    public static int[][] convert(int[] a, int size){
    	int[][] b= new int[size][size]; 
    	int x=0;
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			b[i][j]=a[x];
    			x++;
    		}
    	}
    	return b;
    }
    
    
   
   static void displayMatrix(int N, int mat[][]){
        for (int i = 0; i < N; i++)  {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + mat[i][j]);}
      
            
        }
      
    }
      
   
    public static void main (String[] args)  {
    	
    	Scanner s= new Scanner(System.in);
    	System.out.println("Size of matrix: ");
    	int n= s.nextInt();
    	int size= n*n;
    	int[] arr = new int[size];
    	System.out.println("Enter the numbers: ");
    	for(int i=0; i<size; i++) {
    		arr[i]=s.nextInt();
    	}
    	
    	int[][] array2d= convert(arr, n);
    	rotateMatrix(n, array2d);
    	displayMatrix(n, array2d);
    	
    	s.close();
    
    }
    }
