package com.zwj.io.dir;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;

/**
 * @Author:zengwenjie
 * @Date:2021/3/25 11:25
 */
public class IoPractice {
    public static void main(String[] args) {
        String path = IoPractice.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        for (int i = 0; i < 3; i++) {
            int lastpos = path.lastIndexOf("/");
            path = path.substring(0, lastpos);
        }
        String lastPath =path+ "/src/main/java/com/zwj/io";
        try {
            FileReader inputRead = new FileReader(lastPath + "/dir/test.txt");
            BufferedReader br = new BufferedReader(inputRead);
            File outFile = new File(lastPath + "/dir/result.txt");
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            String s;
            while ((s = br.readLine()) != null) {
                int[] ints = Arrays.stream(s.split(" ")).mapToInt((t) -> Integer.valueOf(t)).toArray();
                int sum = 0;
                for (int i = 0; i < ints.length; i++) {
                    sum += ints[i];
                }

                buffWriter.append(String.valueOf(sum));
                buffWriter.newLine();
            }
            buffWriter.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
