/*   Created by IntelliJ IDEA.
 *   Author: Harsh Agarwal
 *   Date: 31-03-2021
 *   Time: 05:23 PM
 *   File: Trie.java
 */

package tree.trie;

public class Trie implements TrieADT{

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String data) {
        int index;

        Node node = root;

        for (int level = 0; level < data.length(); level++) {
            index = data.charAt(level) - 'a';
            if(node.children[index] == null)
                node.children[index] = new Node();

            node = node.children[index];
        }

        node.lastAlphabet = true;
    }

    public boolean search(String data) {
        int index;

        Node node = root;

        for (int level = 0; level < data.length(); level++) {
            index = data.charAt(level) - 'a';
            if(node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return (node != null && node.lastAlphabet);
    }

    public boolean isEmpty(Node root) {
        for (int i = 0; i < root.NO_OF_ALPHABETS; i++) {
            if(root.children[i] != null)
                return false;
        }
        return true;
    }

    public void delete(String data) {
        delete(root, data, 0);
    }

    private Node delete(Node root, String data, int depth) {
        if(root == null)
            return null;

        if(depth == data.length()) {
            if(root.lastAlphabet)
                root.lastAlphabet = false;
            if(isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int index = data.charAt(depth) -  'a';
        root.children[index] = delete(root.children[index], data, depth+1);

        if(isEmpty(root) && root.lastAlphabet == false) {
            root = null;
        }
        return root;
    }

}