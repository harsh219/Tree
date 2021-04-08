/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 28-03-2021
 *   Time: 01:28 PM
 *   File: Node.java
 */

package tree.avlTree;

public class Node {
    int data;
    Node left, right;
    int height;

    public Node(int data) {
        this.data = data;
        this.height = 1;
    }
}