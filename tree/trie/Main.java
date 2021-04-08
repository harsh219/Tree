/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 31-03-2021
 *   Time: 05:23 PM
 *   File: Main.java
 */

package tree.trie;

public class Main {

    public static void main(String[] args) {

        String[] arr = { "the", "a", "there", "answer", "any", "by", "bye", "their", "hero", "heroplane" };
        Trie trie = new Trie();

        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        System.out.println(trie.search("the"));

        System.out.println(trie.search("these"));

        System.out.println(trie.search("heroplane"));

        trie.delete("heroplane");

        System.out.println(trie.search("heroplane"));

    }
}