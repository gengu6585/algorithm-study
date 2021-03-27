package com.zwj.io;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * @Author:zengwenjie
 * @Date:2021/3/24 23:18
 */

public class IoStream implements Serializable {
    String name = "iostram";
    Date date = new Date();

    @Override
    public String toString() {
        return "IoStream{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) {
        String bashPath = "F://study//code//algorithm//src//main//java//com//zwj//io//dir";
        File file = new File(bashPath+"/test.txt");
        int nums[] = {1, 2, 3, 4, 5, 6};
        System.arraycopy(nums,0,nums,3,3);
        System.out.println(Arrays.toString(nums));
        try {
            FileOutputStream fot = new FileOutputStream(bashPath+"/test.text");
            BufferedOutputStream bfo = new BufferedOutputStream(fot);
            ObjectOutputStream objOut = new ObjectOutputStream(bfo);
            objOut.writeObject(new IoStream());
            objOut.close();

            FileInputStream input = new FileInputStream(bashPath+"/test.text");
            BufferedInputStream buffInput = new BufferedInputStream(input);
            ObjectInputStream objectInputStream = new ObjectInputStream(buffInput);
            IoStream o = (IoStream)objectInputStream.readObject();
            int lastBack = Integer.MIN_VALUE;
            String s = o.date.toString();
            String result = "";
            for(int i=0;i<3;i++){
                lastBack = s.lastIndexOf(" ");
                result = s.substring(lastBack + 1);
                s = s.substring(0, lastBack);

            }
            String[] split = result.split(":");
            int[] ints = Arrays.stream(split).mapToInt((t)->Integer.valueOf(t)).toArray();
            System.out.println(Arrays.toString(ints));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    int toInt(String s) {
        return Integer.valueOf(s) + 1;
    }
}
