package com.zwj;

/**
 * @Author:zengwenjie
 * @Date:2021/3/29 9:11
 */
public class ReverseBits {
    public static void main(String[] args) {
        new ReverseBits().solution(1);
    }
    int solution(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
                result = result | ((n << i & 1 << 31 - i )== (1 << 31 - i) ? 1 << i : 0);
        }
        return result;
    }
}
