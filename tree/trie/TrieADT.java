/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 31-03-2021
 *   Time: 05:22 PM
 *   File: TrieADT.java
 */

package tree.trie;

interface TrieADT {

    public void insert(String data);

    public boolean search(String data);

    public void delete(String data);
}