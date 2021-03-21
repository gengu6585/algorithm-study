package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/12 18:35
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
//        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preorder = "9,#,92,#,#";
        boolean solution = new VerifyPreorderSerializationOfABinaryTree().solution(preorder);
        System.out.println(solution);


    }
    boolean solution(String preorder) {
        if (preorder == null) {
            return false;
        }
        if (preorder.length() == 0) {
            return false;
        }

        String[] split = preorder.split(",");
        int length = split.length;
        if (length>2&&(!split[length-1] .equals( "#") || !split[length-2] .equals( "#"))) {
            return false;
        }
        int pos = preorder(split, 0);
        if (pos != length - 1) {
            return false;
        }
        return true;
    }

    int  preorder(String[] split, int pos) {
        if (pos > split.length-1) {
            return pos;
        }
        if (split[pos].equals("#")) {
            return pos;
        }
        int leftPos = preorder(split, pos + 1);
        return preorder(split, ++leftPos);
    }
}
