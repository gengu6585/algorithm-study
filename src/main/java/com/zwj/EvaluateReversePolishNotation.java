package com.zwj;

import java.util.ArrayDeque;

/***
 * description: 逆波兰表达式的求值
 * LeetCodeLink：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/3/20 23:58
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int reuslt = new EvaluateReversePolishNotation().solution(tokens);
        System.out.println(reuslt);
    }
    public int solution(String[] tokens) {
        if (tokens == null) {
            return -1;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        if (tokens.length == 2) {
            return -1;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            Integer number2 = 0;
            Integer number1 = 0;
            switch (tokens[i]) {
                case "+":
                    number2 = stack.pop();
                    number1 = stack.pop();
                    stack.push(number1+number2);
                    break;
                case "-":
                    number2 = stack.pop();
                    number1 = stack.pop();
                    stack.push(number1-number2);
                    break;
                case "*":
                    number2 = stack.pop();
                    number1 = stack.pop();
                    stack.push(number1*number2);
                    break;
                case "/":
                    number2 = stack.pop();
                    number1 = stack.pop();
                    stack.push(number1/number2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
