package com.zwj.stream;

import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/4/13 18:02
 */
public class SteamTest {
    public static void main(String[] args) {
        int[]arrays={1,1,1,2,2};
        System.out.println(Arrays.stream(arrays).max().orElse(-1));;
//        Arrays.stream()
    }
}
