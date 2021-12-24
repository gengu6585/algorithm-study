package com.zwj.huawei.OperatingExamination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zengwenjie
 * @Date:2021/4/27 21:04
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("-");
            String paiSting1 = split[0];
            String paiSting2 = split[1];
            Pai pai1 = new Pai(paiSting1);
            Pai pai2 = new Pai(paiSting2);
            try {
                if (Compare(pai1, pai2)) {
                    System.out.println(paiSting1);
                }else System.out.println(paiSting2);

            } catch (Exception e) {
                System.out.println("ERROR");
            }

        }
    }
    public enum PaiXing{
        Duizi("duizi"),Zhadan("zhandan"),Shunzi("shunzi"),Wangzha("wangzha"), Gezi("gezi"), SanGe("sange");

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private PaiXing(String paixing) {
            this.type=paixing;
        }
        String type;


    }

    static boolean Compare(Pai pai1, Pai pai2) throws Exception {
        if (pai1.paiXing==PaiXing.Wangzha)
            return true;
        if (pai2.paiXing == PaiXing.Wangzha) {
            return false;
        }
        if (pai1.paiXing == PaiXing.Zhadan && pai2.paiXing != PaiXing.Zhadan) {
            return true;
        }
        if (pai2.paiXing == PaiXing.Zhadan && pai1.paiXing != PaiXing.Zhadan) {
            return false;
        }
        if (pai1.paiXing == PaiXing.Zhadan && pai2.paiXing == PaiXing.Zhadan) {
            return pai1.data[0] > pai2.data[0];
        }
        if (pai1.paiXing == PaiXing.Duizi && pai2.paiXing == PaiXing.Duizi) {
            return pai1.data[0] >pai2.data[0];
        }
        if (pai1.paiXing == PaiXing.SanGe && pai2.paiXing == PaiXing.SanGe) {
            return pai1.data[0] > pai2.data[0];
        }
        if (pai1.paiXing == PaiXing.Gezi && pai2.paiXing == PaiXing.Gezi) {
            return pai1.data[0] > pai2.data[0];
        }
        if (pai1.paiXing == PaiXing.Shunzi && pai2.paiXing == PaiXing.Shunzi) {
            return pai1.data[0] > pai2.data[0];
        } else {
            throw new Exception("无法比较");
        }

    }


    static public class Pai {
        int[] data;
        PaiXing paiXing;

        public Pai(String paiString) {
            String[] data = paiString.split(" ");
            this.data = Arrays.stream(data).mapToInt((a) -> {
                if (a.matches("\\d+")) {
                    return Integer.valueOf(a);
                } else {
                    if (a.equals("J")) {
                        return 11;
                    }
                    if (a.equals("Q")) {
                        return 12;
                    }
                    if (a.equals("K")) {
                        return 13;
                    }
                    if (a.equals("A")) {
                        return 13;
                    }
                    if (a.equals("joker")) {
                        return 14;
                    }
                    if (a.equals("JOKER")) {
                        return 15;
                    }
                }
                return 0;
            }).toArray();

            switch (this.data.length) {
                case 1:
                    this.paiXing = PaiXing.Gezi;
                    break;
                case 2:
                    if (!(this.data[0]==14) && !(this.data[0]==15)) {
                        this.paiXing = PaiXing.Duizi;
                    } else this.paiXing = PaiXing.Wangzha;

                    break;
                case 3:
                    this.paiXing = PaiXing.SanGe;
                    break;
                case 4:
                    this.paiXing = PaiXing.Zhadan;
                    break;
                case 5:
                    this.paiXing = PaiXing.Shunzi;
            }
        }
    }
}
