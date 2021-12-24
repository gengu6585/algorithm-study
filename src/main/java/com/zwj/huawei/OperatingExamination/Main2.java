    package com.zwj.huawei.OperatingExamination;


    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.Scanner;

    /**
     * @Author:zengwenjie
     * @Date:2021/4/27 17:57
     */
    public class Main2 {
        public static class Pair{
            String key;
            Integer value;

            public Pair(String key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Integer[]> map = new HashMap<>();
            ArrayList<Pair> list = new ArrayList<Pair>();
            while (scanner.hasNextLine()) {

                String s = scanner.nextLine();
                String[] split = s.split(" ");
                String path = split[0];
                String rowNum = split[1];
                int pos = path.lastIndexOf('\\');
                if (pos != -1) {
                    path = path.substring(pos + 1, path.length());
                }
                if (map.containsKey(path + "+" + rowNum)) {
                    Integer[] data = map.get(path + "+" + rowNum);
                    data[1] += 1;
                    list.set((data[0]), new Pair(path + "+" + rowNum, data[1]));
                    map.put(path + "+" + rowNum, data);

                } else {
                        System.out.println(path + "+" + rowNum);
                        list.add(new Pair(path + "+" + rowNum, 1));
                        Integer[] data = new Integer[2];
                        data[0] = list.size() - 1;
                        data[1] = 1;
                        map.put(path + "+" + rowNum, data);


                }

            }
            Pair[] array = Arrays.stream(list.toArray()).toArray(Pair[]::new);
            sort(array);
            for (int i = 0; i < 8; i++) {
                String key = array[i].getKey();
                String[] keys = key.split("\\+");
                if (keys[0].length() > 16) {
                    keys[0] = keys[0].substring(keys[0].length() - 16, keys[0].length());
                }
                System.out.println(keys[0]+" "+keys[1]+" "+array[i].getValue());
            }

        }

        public static void sort(Pair[] array) {
            int pos = array.length;
            while (--pos >= 1) {
                boolean flag = true;
                for (int i = 0; i < pos; i++) {

                    if (array[i].getValue() < array[i + 1].getValue()) {
                        flag = false;
                        swap(array, i, i + 1);
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        public static void swap(Pair[] array, int i, int j) {
            Pair temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
