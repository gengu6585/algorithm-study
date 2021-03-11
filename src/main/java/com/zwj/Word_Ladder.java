package com.zwj;

import java.util.*;

/**
 * @Author:zengwenjie
 * @Date:2021/3/10 13:12
 */
public class Word_Ladder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] stringArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(stringArray));
        ArrayList<Deque<String>> result = new Word_Ladder().solution(beginWord, endWord, wordList);
//        if (result == null) {
//            return 0;
//        }
//        result.get(0).size()
    }

        public ArrayList<Deque<String>> solution(String beginWord, String endWord, List<String> wordList) {

            ArrayList<String> _wordList = new ArrayList<>();
            _wordList.add(beginWord);
            int _count = 0;
            for (String s : wordList) {
                if (!s.equals(beginWord)&&!s.equals(endWord)) {
                    _wordList.add(s);
                }
                if (s.equals(endWord)) {
                    _count++;

                }

            }
            if (_count == 0) {
                return null;
            } else {
                _wordList.add(endWord);
                ArrayList[] map = new ArrayList[_wordList.size()];
                for (int j = 0; j < _wordList.size(); j++) {
                    map[j] = new ArrayList<Integer>();
                    for (int k = 0; k < _wordList.size(); k++) {
                        if (j == k) {
                            continue;
                        }
                        if (_wordList.get(j).length() == _wordList.get(k).length()) {
                            int count = 0;
                            for (int h = 0; h < _wordList.get(j).length() ; h++) {

                                if (_wordList.get(j).charAt(h) != _wordList.get(k).charAt(h)) {
                                    count++;
                                }
                                if (count > 1) {
                                    break;
                                }
                            }
                            if (count ==1) {
                                map[j].add(k);
                            }
                        }
                    }
                }
                ArrayDeque<Integer> targetPos = new ArrayDeque<>();

                int[] visited = new int[_wordList.size()];
                ArrayList<int[]> deque = new ArrayList<>();
                bfs(_wordList.size() - 1,deque, map, visited, targetPos);
                if (targetPos.size() == 0) {
                    return null;
                }
                System.out.println(deque.toString());
                System.out.println(targetPos);
                ArrayList<Deque<String>> result = new ArrayList<Deque<String>>();
                while (targetPos.size() != 0) {
                    Integer pos = targetPos.pop();
                    ArrayDeque<String> path = new ArrayDeque<>();
                    while (pos != -1) {
                        int[] node = deque.get(pos);
                        path.push(_wordList.get(node[0]));
                        pos = node[1];
                    }
                    result.add(path);

                }
                for (Deque<String> strings : result) {
                    System.out.println(strings);
                }

                return result;
            }


        }

        void bfs(int endWord,ArrayList<int[]> deque, List<Integer>[] map,int[] visited,ArrayDeque<Integer> targetPos) {

    //        数组分别表示,当前结点，上一层结点，当前深度
            int[] firstNode = new int[3];
            firstNode[0]=0;
            firstNode[1] = -1;
            firstNode[2] = 0;
            visited[firstNode[0]] = firstNode[2];
            deque.add(firstNode);
            int minLength = 0;
            int front = 0;
            while (front!=deque.size()) {
                int[] node = deque.get(front);

                if (node[0] == endWord) {
                    front++;
                    continue;
                }
                if (minLength != 0 && visited[node[0]] > minLength) {
                    front++;
                    continue;
                }
                for (Integer neighbor  : map[node[0]]) {
                    if (endWord == neighbor) {
                        if (minLength == 0) {
                            int[] array = new int[3];
                            array[0] = neighbor;
                            array[1] = front;
                            array[2] = node[2] + 1;
                            deque.add(array);
                            targetPos.add(deque.size()-1);
                            minLength = node[2] + 1;
                        } else if (node[2] + 1 <= minLength) {
                            minLength = node[2] + 1;
                            int[] array = new int[3];
                            array[0] = neighbor;
                            array[1] = front;
                            array[2] = node[2] + 1;
                            deque.add(array);
                            targetPos.add(deque.size()-1);
                        }

                    }
                    if (visited[neighbor] == 0) {
                        visited[neighbor] = node[2] + 1;
                        int[] array = new int[3];
                        array[0] = neighbor;
                        array[1] = front;
                        array[2] = node[2] + 1;
                        deque.add(array);
                    } else {
                        if (node[2] + 1 <= visited[neighbor]) {
                            int[] array = new int[3];
                            array[0] = neighbor;
                            array[1] = front;
                            array[2] = node[2] + 1;
                            visited[neighbor] = node[2] + 1;
                            deque.add(array);
                        }
                    }






                }
                front++;
            }
        }


}
