/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 31-03-2021
 *   Time: 01:21 AM
 *   File: AvlTreeADT.java
 */

package tree.avlTree;

interface AvlTreeADT {

    public boolean search(int data);

    public void insert(int data);

    public void delete(int data);

    public void inOrder();

    public void preOrder();

    public void postOrder();

    public void levelOrder();

}