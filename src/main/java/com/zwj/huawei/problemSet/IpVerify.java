package com.zwj.huawei.problemSet;

/**
 * @Author:zengwenjie
 * @Date:2021/5/12 17:06
 */
public class IpVerify {
    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334";

        String result = new IpVerify().solve(s);
        System.out.println(result);
    }
    public String solve(String IP) {
        String regex1= "(\\d+\\.){3}\\d+";
        String regex2 = "(\\w{1,4}:){7}\\w{1,4}";
        IP = IP.toLowerCase();

        if (IP.matches(regex1)) {
            String[] split = IP.split("\\.");
            boolean flag = true;
            for (String s : split) {
                if (s.length() > 0) {
                    if (s.charAt(0) == '0') {
                        flag = false;
                        break;
                    }
                }
                int integer = Integer.parseInt(s);
                if (integer < 0 || integer > 255) {
                    flag = false;
                    break;

                }

            }
            if (flag) {
                return "IPv4";
            }



        } else {
            if (IP.matches(regex2)) {
                String[] split = IP.split(":");
                boolean flag = true;
                for (String s : split) {
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (!( (c>= '0'&& c <='9' )|| (c <= 'f'&&c>='a'))) {
                            flag = false;
                            break;
                        }
                    }


                }
                if (flag) {
                    return "IPv6";
                }
            }
        }
        return "Neither";
    }

}
