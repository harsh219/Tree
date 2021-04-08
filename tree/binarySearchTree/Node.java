/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 26-03-2021
 *   Time: 02:32 PM
 *   File: Node.java
 */

package tree.binarySearchTree;

public class Node {
    int data;
    Node right, left;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }
}