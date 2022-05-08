package transaction.record;

public class Main {
	//Initialize root of right skewed tree
	static Node rootRightSkewed=null;

	static class Node{
		int data;
		Node left;
		Node right;
	};

	//create new node
	public static Node newNode(int key) {
		Node node=new Node();
		node.data=key;
		node.left=null;
		node.right=null;
		return node;
	}

	//insert new node into BST
	public static Node insertNode(Node root, int key) {
		Node newnode=newNode(key);
		Node x=root;
		Node y=x;

		while (x!=null) {
			y=x;
			if (key<x.data) {
				x=x.left;
			}
			else if (key>x.data) {
				x=x.right;
			}
			else {
				System.out.print("Duplicate element not allowed");
				return newnode;
			}
		}
		if (y==null) {
			y=newnode;
		}
		else if (key<y.data) {
			y.left=newnode;
		}
		else {
			y.right=newnode;
		}
		return y;		
	}

	//insert new node into right skewed tree
	public static Node insertRightNode(Node root, int key) {
		Node newnode=newNode(key);
		Node x=root;
		Node y=x;

		while (x!=null) {
			y=x;
			x=x.right;
		}
		if (y==null) {
			y=newnode;
		}
		else {
			y.right=newnode;
		}
		return y;		
	}

	//Display right skewed tree
	public static void rightSkewTraversal(Node root) {
		if (root==null)
			return;
		else {
			System.out.print(root.data+" ");
			rightSkewTraversal(root.right);
		}
	}

	//creating right skewed tree
	public static void rightSkewed(Node root) {
		if (root==null)
			return;
		else {
			rightSkewed(root.left);
			if (rootRightSkewed==null)
				rootRightSkewed=insertRightNode(rootRightSkewed,root.data);
			else
				insertRightNode(rootRightSkewed,root.data);
			rightSkewed(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialize root of original BST
		Node root=null;

		//Inserting nodes into BST
		root=insertNode(root,50); 
		insertNode(root,30);
		insertNode(root,60); 
		insertNode(root,10);
		insertNode(root,55); 

		//Creating right skewed tree
		rightSkewed(root);

		System.out.println("Right Skewed tree:");		
		rightSkewTraversal(rootRightSkewed);
	}
}
