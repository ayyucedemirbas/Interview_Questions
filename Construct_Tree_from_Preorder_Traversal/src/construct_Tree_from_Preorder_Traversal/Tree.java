package construct_Tree_from_Preorder_Traversal;
  

//soru: https://practice.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1
public class Tree {
	
	
	 class Node{
		int data;
		 Node left, right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			
		}
	}
	
	
	Node root;
	
	Tree(){
		root=null;
	}
	
	
	
	    int i = 0 ;
	    Node tree(int[] pre , char[] preLN){
	        i++ ;
	        if(i >= pre.length){
	            return null ;
	        }
	        Node node = new Node(pre[i]);
	        if(preLN[i] == 'N'){
	            node.left = tree(pre , preLN);
	            node.right = tree(pre , preLN);
	        }
	        return node ;
	        
	    }
	    Node constructTree(int n, int pre[], char preLN[]){
	        i = 0 ; 
		    Node root = new Node(pre[0]);
		    root.left = tree(pre , preLN);
		    root.right = tree(pre , preLN);
		    
		    return root ;
	    }
  
	    void preOrderTraversal(Node n) {
			if(n!=null) {
				System.out.print(n.data+" ");
				preOrderTraversal(n.left);
				preOrderTraversal(n.right);
			}
		}
  
  public static void main(String[] args) {
	/*5
10 30 20 5 15 
N N L L L */
	  
	int size=5;  
	int pre[]= {10, 30, 20, 5, 15};
	char preLN[]= {'N','N','L','L','L'};
	Tree t= new Tree();
	Node n= t.constructTree(size,pre,preLN);
	t.preOrderTraversal(n);
	  
	  
}
	
	
	   

}
