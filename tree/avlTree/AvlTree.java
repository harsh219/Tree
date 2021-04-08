/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 28-03-2021
 *   Time: 01:29 PM
 *   File: AvlTree.java
 */

package tree.avlTree;

import org.jetbrains.annotations.NotNull;

public class AvlTree implements AvlTreeADT{

    Node root;

    public AvlTree() {
        root = null;
    }

    private int height(Node node) {
        if(node == null)
            return 0;
        return node.height;
    }

    private int max(int a, int b) {
        return (a>b ? a : b);
    }

    private Node leftRotate(Node root) {
        Node newRoot = root.right;
        Node temp = newRoot.left;

        newRoot.left = root;
        root.right = temp;

        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        root.height = max(height(root.left), height(root.right)) + 1;

        return newRoot;
    }

    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        Node temp = newRoot.right;

        newRoot.right = root;
        root.left = temp;

        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        root.height = max(height(root.left), height(root.right)) + 1;

        return newRoot;
    }

    private int getBalance(Node node) {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node balancingRoot(Node root, int data, int balance) {

        if (balance < -1 && data > root.right.data)
            return leftRotate(root);

        else if(balance > 1 && data < root.left.data)
            return rightRotate(root);

        else if(balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        else if(balance > 1 && data > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        return root;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {

        if (root == null) {
            return (new Node(data));
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);
        else
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        return balancingRoot(root, data, balance);
    }

    private int minValue(@NotNull Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if(root == null)
            return root;

        if(data < root.data)
            root.left = delete(root.left, data);
        else if(data > root.data)
            root.right = delete(root.right, data);
        else {
            if(root.right == null)
                root = root.left;
            else if(root.left == null)
                root = root.right;
            else {
                root.data = minValue(root);
                root.right = delete(root.right, root.data);
            }
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        return balancingRoot(root, data, balance);
    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node root, int data) {
        if(root != null) {
            if(data < root.data)
                return search(root.left, data);
            else if(data > root.data)
                return search(root.right, data);
            else
                return true;
        }
        return false;
    }

    public void preOrder() {
        preOrder(root);
    }

    void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root!=null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrder() {
            levelOrder(root);
    }

    private void levelOrder(Node root) {
        if(root != null)
            for(int i=1; i<=root.height; i++)
                printLevel(root, i);
    }

    private void printLevel(Node root, int level) {
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.data + " ");
        else
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
    }

}