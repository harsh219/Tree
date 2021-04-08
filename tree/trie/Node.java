/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 31-03-2021
 *   Time: 05:23 PM
 *   File: Node.java
 */

package tree.trie;

public class Node {

    final int NO_OF_ALPHABETS = 26;

    Node[] children = new Node[NO_OF_ALPHABETS];

    boolean lastAlphabet;

    public Node() {
        lastAlphabet = false;

        for (int i = 0; i < NO_OF_ALPHABETS; i++) {
            children[i] = null;
        }
    }
}