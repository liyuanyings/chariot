package com.example.base.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils {

    /**
     * 占比计算保留小数的位数方法
     * 转成百分数
     * 当前数除以总数
     * @author: WT1124
     * @create: 2018-11-27 15:42
     * @param  num1, num2
     * @return  rate  保留2位小数的
     */
    public static String  division(int num1, int num2){
        String rate="0.00%";
        //定义格式化起始位数
        String format="0.00";
        if(num2 != 0 && num1 != 0){
            DecimalFormat dec = new DecimalFormat(format);
            rate =  dec.format((double) num1 / num2*100)+"%";
            while(true){
                if(rate.equals(format+"%")){
                    format=format+"0";
                    DecimalFormat dec1 = new DecimalFormat(format);
                    rate =  dec1.format((double) num1 / num2*100)+"%";
                }else {
                    break;
                }
            }
        }else if(num1 != 0 && num2 == 0){
            rate = "100%";
        }
        return rate;
    }

    public static BigDecimal perToDecimal(String percent){
        String decimal = percent.substring(0,percent.indexOf("%"));
        BigDecimal bigDecimal = new BigDecimal(decimal);
        bigDecimal.divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_UP);
        return bigDecimal;
    }

}
