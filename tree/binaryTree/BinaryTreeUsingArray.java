package tree.binaryTree;/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 10-03-2021
 *   Time: 07:54 PM
 *   File: BinaryTree.java
 */

import java.util.Scanner;

public class BinaryTreeUsingArray {
   int index;
   int lastIndex;
   int[] arr;
   int rootValue;

   public BinaryTreeUsingArray(int capacity){
       arr = new int[capacity+1];
       lastIndex = capacity;
       index = 0;
   }

   public void insert(int value) {
       arr[++index] = value;
   }

   public void preOrder(int index) {
       if (index > lastIndex) {
           return;
       }

       System.out.print(arr[index] + " ");
       preOrder(index*2);
       preOrder(index*2 + 1);

   }

    public void inOrder(int index) {
        if (index > lastIndex) {
            return;
        }
        inOrder(index*2);
        System.out.print(arr[index] + " ");
        inOrder(index*2 + 1);

    }

    public void postOrder(int index) {
        if (index > lastIndex) {
            return;
        }
        inOrder(index*2);
        inOrder(index*2 + 1);
        System.out.print(arr[index] + " ");

    }

    public void printList() {
        for (int i = 1; i <= lastIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       System.out.print("Enter the length of the Tree :  ");
       int capacity = sc.nextInt();

       System.out.print("Enter the elements of the tree :  ");
       BinaryTreeUsingArray bt = new BinaryTreeUsingArray(capacity);

        for (int i = 0; i < capacity; i++) {
            bt.insert(sc.nextInt());
        }

        System.out.print("Enter the index from which you want to see the Tree :  ");
        int index = sc.nextInt();

        sc.close();

        System.out.print("Your tree is :  ");
        bt.printList();
        System.out.print("Pre-Order :  ");
        bt.preOrder(index);
        System.out.println();
        System.out.print("In-Order :  ");
        bt.inOrder(index);
        System.out.println();
        System.out.print("Post-Order :  ");
        bt.postOrder(index);
    }
}