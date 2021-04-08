/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 11-03-2021
 *   Time: 06:43 PM
 *   File: BinaryTreeLinkedList.java
 */
package tree.binaryTree;

import java.util.Scanner;

public class BinaryTreeLinkedList {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createNewNode();
        preOrder(root);
        levelOrder(root);
    }

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node createNewNode() {

        System.out.println("Enter the data :  ");
        int data = sc.nextInt();

        if(data == -1) return null;

        Node root = null;
        root = new Node(data);

        System.out.println("Enter the left node of " + data);
        root.left = createNewNode();

        System.out.println("Enter the right node of " + data);
        root.right = createNewNode();

        return root;
    }

    static void levelOrder(Node root) {
        int height = findHeight(root);
        for(int i=1; i<=height; i++)
            printLevel(root, i);
    }

    private static int findHeight(Node root) {

        if(root == null)
            return 0;

         int leftHeight = findHeight(root.left);
         int rightHeight = findHeight(root.right);

         if(leftHeight > rightHeight)
             return leftHeight + 1;
         else
             return rightHeight + 1;
    }

    private static void printLevel(Node root, int level) {

        if (root == null)
            return;
        else if (level == 1)
            System.out.print(root.data + " ");
        else {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }

    }

    static void preOrder(Node root) {
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}