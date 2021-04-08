/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 26-03-2021
 *   Time: 10:25 PM
 *   File: ThreadedBinaryTree.java
 */

package tree.binaryTree;

import java.util.Scanner;

public class ThreadedBinaryTree {

    static Scanner sc ;

    static public class Node {
        int data;
        Node left, right;
        int isLeft, isRight;

        public Node(int data) {
            this.data = data;
            left = right = null;
            isLeft = isRight = 0;
        }
    }

    public static Node createNewNode() {

        System.out.println("Enter the data :");
        int data = sc.nextInt();

        if(data == -1) return null;

        Node root = null;
        root = new Node(data);

        System.out.println("Enter the left node of " + data);
        root.isLeft = 1;
        root.left = createNewNode();

        System.out.println("Enter the right node of " + data);
        root.isRight = 1;
        root.left = createNewNode();

        return root;
    }

    static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data + " " + root.isLeft + " " + root.isRight);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createNewNode();
        inOrder(root);
    }

}