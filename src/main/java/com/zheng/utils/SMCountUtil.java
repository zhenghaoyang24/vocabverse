package com.zheng.utils;

public class SMCountUtil {


    //每更新q执行
    public static double getNewEF(double EF, int quality) {
        if (quality == 2) {
            EF = EF -0.05;
            if(EF<1.4)
                return 1.4;
            else{
                return EF-0.05;
            }
        }
        double ef1;
//        double ef2;
        ef1 = EF + (0.1 - (3 - quality) * (0.08 + (3 - quality) * 0.02));
//        System.out.println(ef1);
//        ef2=EF-0.8+0.28*q-0.02*q*q;
        if (ef1 > 2.5) {
            return 2.5;
        } else return Math.max(ef1, 1.4);
    }


    //quality=3 计算下次学习间隔天数
    public static int nextDay(int totalCount, double ef, int quality, double difficult, double weight) {
        if (weight <= 0)
            weight = 0.1;
        if (totalCount == 0 && quality == 3 && ef == 2.5)  //第一次就认识
            return 7;
        else if (totalCount <= 1) {
            return (int) (ef * ((11 - difficult) * 0.1));
        } else {
            int v = (int) ((totalCount - 1) * ef * ((11 - difficult) * 0.1) * weight);
            if (v <= 0)
                return 1;
            else {
                return v;
            }
        }
    }

    //quality=3  机算权重用来计算day
    public static double countDayWeight(int q_0,int q_1,int q_2,int day_studyCount){
        return  (double) (1 / day_studyCount) + 0.1 * q_1 + 0.2 * q_2 - q_0 * 0.2;

    }

}
