/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 25-03-2021
 *   Time: 11:06 PM
 *   File: BinarySearchTree.java
 */

package tree.binarySearchTree;

import tree.binaryTree.BinaryTreeLinkedList;

class BinarySearchTree implements BinarySearchTreeADT{

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, new Node(value));
    }

    private Node insertNode(Node root, Node newNode) {
        if(root == null) {
            root = newNode;
            return root;
        }
        if(newNode.data < root.data)
            root.left = insertNode(root.left, newNode);
        else
            root.right = insertNode(root.right, newNode);
        return root;
    }

    public boolean search(int  value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node root, int value) {
        if(root != null) {
            if(root.data == value)
                return true;
            else if(value < root.data)
                return searchNode(root.left, value);
            else
                return searchNode(root.right, value);
        }
        return false;
    }

    public void delete(int value) {
            root = deleteNode(root, value);
    }

    private Node deleteNode(Node root, int value) {
        if(root == null)
            return root;
        if(value < root.data)
            root.left = deleteNode(root.left, value);
        else if(value > root.data)
            root.right = deleteNode(root.right, value);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else {
                root.data = minValue(root.right);
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }

    private int  minValue(Node root) {
        int minValue = root.data;
        while(root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void preOrder() {
        preOrderTraversal(root);
    }

    public void preOrderTraversal(Node root) {
        if(root!=null) {
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if(root!=null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    public void postOrder() {
        postOrderTraversal(root);
    }

    public void postOrderTraversal(Node root) {
        if(root!=null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node root) {
        int height = findHeight(root);
        for(int i=1; i<=height; i++)
            printLevel(root, i);
    }

    private int findHeight(Node root) {

        if(root == null)
            return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    private void printLevel(Node root, int level) {

        if (root == null)
            return;
        else if (level == 1)
            System.out.print(root.data + " ");
        else {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }

    }

}