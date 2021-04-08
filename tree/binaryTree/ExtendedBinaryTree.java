/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 11-03-2021
 *   Time: 06:43 PM
 *   File: BinaryTreeLinkedList.java
 */
package tree.binaryTree;

import java.util.Scanner;

public class ExtendedBinaryTree {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createNewNode();
        inOrder(root);
    }

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right =null;
        }
    }

    static Node createNewNode() {

        System.out.println("Enter the data :  ");
        int data = sc.nextInt();

        if (data == -1) return new Node(data);

        Node root = null;
        root = new Node(data);

        System.out.println("Enter the left node of " + data);
        root.left = createNewNode();

        System.out.println("Enter the right node of " + data);
        root.right = createNewNode();

        return root;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}