/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 28-03-2021
 *   Time: 01:28 PM
 *   File: Main.java
 */

package tree.avlTree;

public class Main {

    public static void main(String[] args) {

        AvlTree tree =  new AvlTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(10);
        tree.insert(0);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(1);
        tree.insert(2);
        tree.preOrder();
        tree.delete(10);
        System.out.println();
        tree.preOrder();
        System.out.println("\n" + tree.search(11));
        System.out.println(tree.search(111));

    }
}