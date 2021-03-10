package com.zwj;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/3/9 23:56
 */
public class World_Ladder {
    public static void main(String[] args) {
        String[] stringArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(stringArray));
        String beginWord = "hit";
        String endWord = "cog";
        int result = new World_Ladder().solution(beginWord, endWord, wordList);
        System.out.println(result);

    }
    int solution(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> path = new ArrayList<>();

        int[] visited = new int[wordList.size()];
            HashMap<String, Integer> map = new HashMap<>();
            map.put(beginWord, -1);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int result = dfs(entry, wordList, endWord, 1, visited,path);
                if (result != -1) {
                    System.out.println(path.toString());
                    return result;
                }
            }

        return -1;
    }



    int dfs(Map.Entry<String, Integer>  word, List<String> wordList,String endWord ,int deep,int[] visited,ArrayList<String> path) {
        path.add(word.getKey());
        if (word.getKey().equals(endWord)) {
            return deep;
        }
        if (word.getValue() != -1) {
            visited[word.getValue()] = 1;
        }

        HashMap<String,Integer> neiboorWord = findNeiboorWord(word, wordList,visited);
        for (Map.Entry<String, Integer> wordEntry : neiboorWord.entrySet()) {
            int result = dfs(wordEntry, wordList, endWord, ++deep,visited,path);
            if (result != -1) {
                return result;
            }
        }
        path.remove(word.getKey());
        return -1;
    }

    HashMap<String,Integer> findNeiboorWord(Map.Entry<String, Integer>  word, List<String> wordList,int [] visited) {
        HashMap<String,Integer> neiboorWord = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (visited[i] != 0) {
                continue;
            }
            if (s.length() == word.getKey().length()) {
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != word.getKey().charAt(j)) {
                        count++;
                    }
                }
                if (count < 2) {
                    neiboorWord.put(s,i);
                }
            }
        }

        return neiboorWord;
    }
}
