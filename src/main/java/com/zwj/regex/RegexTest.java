package com.zwj.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:zengwenjie
 * @Date:2021/4/11 16:03
 */
public class RegexTest {
    public static void main(String[] args) {
        String ss = "(<Listener)([\\s\\S]+?)(/>) aaabcd sf sf sf fdfd dfdfd fdfd fdfd dfsf saff word word word word word word word word word word FSf SF gF @f";
        String regex = "(\\s?\\w+\\s)\\1{1,}";

        System.out.println(ss);
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(ss);

        String s = matcher.replaceAll("$1");
        System.out.println(s);
    }
}
