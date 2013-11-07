package com.zillow;

/* Author: Roshan Subudhi
 * Purpose: Zillow Interview 
 * Date: 11/07/2013
 * Web: www.roshansubudhi.wordpress.co
 */

class ZillowNode {
	int key;
	ZillowNode left;
	ZillowNode middle;
	ZillowNode right;

	public ZillowNode(int key) {
		this.key = key;
		this.left = this.middle = this.right = null;
	}
}

class ZillowTree {
	ZillowNode root;

	public ZillowTree() {
		root = null;
	}

	public ZillowNode insert(ZillowNode node, int key) {
		if (node == null) {
			node = new ZillowNode(key);
		} else if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key == node.key) {
			node.middle = insert(node.middle, key) ;
		} else {
			node.right = insert(node.right, key);
		}
		return node;
	}

	public ZillowNode findMin(ZillowNode node) { //used in delete, to replace the deleted node
		if (node != null) {
			while (node.left != null) {
				return findMin(node.left);
			}
		} 
		return node;
	}

	public ZillowNode delete(ZillowNode node, int key) {
		if (node == null) {
			System.out.println("Element not found.");
		} else if (key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else {
			if (node.middle != null) {
				node.middle = delete(node.middle, key);
			} else if (node.right != null) {
				node.key = findMin(node.right).key;
				node.right = delete(node.right, findMin(node.right).key); //replacing with next least value in tree
			} else {
				node = node.left;
			}
		}
		return node;
	}  

	public void traverse(ZillowNode node) { // no specific order traversal
		if (node == null) { return;}
		if (node.left != null) {traverse(node.left);}
		if (node.middle != null) {traverse(node.middle);}
		if (node.right != null) {traverse(node.right);}

		System.out.println("  Traversed " + node.key);

	}

	public static void main(String[] args){

		ZillowNode base = new ZillowNode(5);

		ZillowTree tree = new ZillowTree();
		tree.insert(base, 4);
		tree.insert(base, 9);
		tree.insert(base, 5);
		tree.insert(base, 7);
		tree.insert(base, 2);
		tree.insert(base, 2);
		System.out.println("-------------------");
		tree.traverse(base);
		System.out.println("-------------------");
		tree.delete(base, 7);
		System.out.println("-------------------");
		tree.traverse(base);
	}

}