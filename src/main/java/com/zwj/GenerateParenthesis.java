package com.zwj;

import java.util.ArrayList;

/**
 * @Author:zengwenjie
 * @Date:2021/4/24 11:29
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        ArrayList<String> res=new ArrayList();
        dfs(8,8,res,"");
        System.out.println(res.toString());
        System.out.println(res.size());

    }
    static void dfs(int l, int r, ArrayList<String> res, String comb){
        if(l>r){
            return;
        }
        if(l==0&&r==0){
            res.add(comb);
            return;
        }
        if(l-1>=0){
            comb+="(";
            dfs(l-1,r,res,comb);
            comb=comb.substring(0,comb.length()-1);



        }
        if(r-1>=0){
            comb+=")";
            dfs(l,r-1,res,comb);
            comb=comb.substring(0,comb.length()-1);
        }


    }
}
