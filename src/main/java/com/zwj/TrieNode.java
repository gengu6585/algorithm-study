package com.zwj;

import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/12 15:31
 */
public class TrieNode {
    final static int MAX_CHAR_NUM = 26;
    TrieNode[] child;
    boolean is_end;

    public TrieNode(boolean is_end) {
        this.child = new TrieNode[MAX_CHAR_NUM];
        this.is_end = is_end;
    }


    public boolean insert(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int pos = 0;
        TrieNode node=this;
        while (pos != word.length()) {
            if (node.child[(int) word.charAt(pos) - 'a'] == null) {
                if (pos == word.length() - 1) {
                    TrieNode childNode = new TrieNode(true);
                    node.child[(int) word.charAt(pos) - 'a'] = childNode;
                    node = childNode;
                } else {
                    TrieNode childNode = new TrieNode(false);
                    node.child[(int) word.charAt(pos) - 'a'] = childNode;
                    node = childNode;
                }
            } else {
                if (pos == word.length() - 1) {
                    node.is_end = true;
                }
                node = node.child[(int) word.charAt(pos) - 'a'];

            }
            pos++;
        }
        return true;
    }



    @Override
    public String toString() {
        return "TrieNode{" +
                "child=" + Arrays.toString(child) +
                ", is_end=" + is_end +
                '}';
    }

    public static void main(String[] args) {
        TrieNode node = new TrieNode(false);
        node.insert("aa");
        node.insert("bbbb");
        node.insert("abbcd");
        System.out.println(node);
    }
}
