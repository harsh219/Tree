/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 26-03-2021
 *   Time: 04:38 PM
 *   File: Main.java
 */

package tree.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(30);
        tree.insert(10);
        tree.insert(14);
        tree.insert(35);
        tree.insert(7);
        tree.inOrder();
        System.out.println(tree.search(10));
        tree.delete(10);
        tree.inOrder();
    }
}