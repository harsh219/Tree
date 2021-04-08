/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 26-03-2021
 *   Time: 02:35 PM
 *   File: BinarySearchTreeADT.java
 */

package tree.binarySearchTree;

interface BinarySearchTreeADT {

    public boolean search(int data);

    public void insert(int data);

    public void delete(int data);

    public void inOrder();

    public void preOrder();

    public void postOrder();

    public void levelOrder();
}