package com.zwj.pingDuoDuo.test1;

import java.util.Scanner;

/*** 
 * description: 
 * @param: 
 * @return: 
 * @author zwj
 * @date: 2021/5/12 15:23
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            long target = scanner.nextLong();
            long[] trees = new long[length];
            for (int i = 0; i < length; i++) {
                trees[i] = scanner.nextLong();
            }
            int ans = 0;

            for (int i = 1; i < length+1; i++) {
                for ( int j = 0; j < i; j++) {
                    long sum = 0;
                    for (int k = j; k <i ; k++) {
                        sum += trees[k];
                    }
                    if (sum % target == 0) {
                        ans++;
                    }
                }

            }
            System.out.println(ans);

        }


    }

    static int dfs(long[] trees, int start, int end,long target) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            if (trees[start] % target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int mid = (start + end) / 2;
        int leftNums = dfs(trees, start, mid - 1,target);
        int rightNums = dfs(trees, mid + 1, end,target);
        int midNums = 0;

        for (int i = 0; i < mid - start+1; i++) {

            for (int j = 0; j < end - mid+1; j++) {
                long sum = 0;
                for (int k  =mid-i; k <= mid+j; k++) {
                    sum += trees[k];
                }
                if (sum % target == 0) {
                    midNums++;
                }
            }
        }

        return leftNums + rightNums + midNums;
    }
}
