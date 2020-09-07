package com.leetcode.solution;

public class ImplementTrie {

    class Trie {

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chars = word.toCharArray();

            TrieNode cur = root;
            for (char ch : chars) {
                if (cur.contains(ch)) {
                    cur = cur.get(ch);
                } else {
                    TrieNode tmp = new TrieNode();
                    cur.put(ch, tmp);
                    cur = tmp;
                }
            }

            cur.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();

            TrieNode cur = root;
            for (char ch : chars) {
                if (!cur.contains(ch)) {
                    return false;
                } else {
                    cur = cur.get(ch);
                }
            }

            return cur.getEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();

            TrieNode cur = root;
            for (char ch : chars) {
                if (!cur.contains(ch)) {
                    return false;
                } else {
                    cur = cur.get(ch);
                }
            }

            return cur != null;
        }

        private class TrieNode {

            private final int R = 26;

            private TrieNode[] links;
            private boolean isEnd;

            private TrieNode() {

                isEnd = false;
                links = new TrieNode[R];
            }

            private boolean contains(char ch) {
                return links[ch - 'a'] != null;
            }

            private void put(char ch, TrieNode node) {

                links[ch - 'a'] = node;
            }

            private TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            private void setEnd() {
                isEnd = true;
            }

            private boolean getEnd() {
                return isEnd;
            }

        }
    }

}
