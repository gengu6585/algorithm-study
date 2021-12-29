package com.zwj.huawei.campusRecruitment;

import java.util.Scanner;

/***
 * description:
 * @param:
 * @return:
 * @author zwj
 * @date: 2021/5/12 15:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ss= scanner.nextLine();
            String[] split1 = ss.split(",");
            int s = Integer.parseInt(split1[0]);
            double water=Double.parseDouble(split1[1]);

            double[] last = new double[1];
            last[0] = water;
            if (s == 0) {
                System.out.println(_toString(Double.toString(water)));
            }
            if (s < 0) {
                System.out.println("null");
            }
            for (int i = 1; i < s+1 ; i++) {
                double[] cur = new double[i + 1];
                for (int j = 0; j < cur.length; j++) {
                    if (j == 0) {
                        if (last[0] > 1.0) {
                            cur[0] = (last[0] - 1.0) / 2;
                        }

                    } else if (j == cur.length-1) {
                        if (last[last.length - 1] > 1.0) {
                            cur[cur.length - 1] = (last[last.length - 1] - 1.0) / 2;
                        }

                    } else {
                        if (last[j] > 1.0) {
                            cur[j] += (last[j] - 1.0) / 2;
                        }
                        if (last[j -1] > 1.0) {
                            cur[j] += (last[j-1] - 1.0) / 2;
                        }

                    }

                }
                double min = Double.MAX_VALUE;

                double max = Double.MIN_VALUE;
                if (i==s) {
                    for (double v : cur) {
                        min=Math.min(min, v);
                        max=Math.max(max, v);
                    }
                    double ans = max - min;
                    String res = Double.toString(ans);


                    System.out.println(_toString(res));



                }
                last = cur;


            }
        }



    }
    public static String _toString(String res){
        String[] split = res.split("\\.");
        if (split[1].length() < 4) {
            int _len = 4 - split[1].length();
            for (int j = 0; j <_len ; j++) {
                split[1] += "0";
            }
        } else {
            split[1] = split[1].substring(0, 4);
        }
        return split[0] + "." + split[1];
    };
}
