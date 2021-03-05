package com.zwj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @Author:zengwenjie
 * @Date:2021/3/2 18:27
 */
public class WriteToFile {
    public void write(String string) {
        File file = new File("C:\\Users\\Administrator\\Documents\\Tencent Files\\2352462017\\FileRecv\\dmt-kito-itemprice8081\\algorithm\\src\\com\\zwj\\subsetResult.text");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);

        byte[] gbks = new byte[0];

        gbks = string.getBytes("GBK");

        fileOutputStream.write(gbks);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
