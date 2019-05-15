package com.zyou.ops.util.utils;

import java.math.BigDecimal;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.utils
 * @Author: yang
 * @CreateTime: 2019-05-10 10:14
 * @Description: ${Description}
 */
public class ToDoubleUtils {
    public static void main(String[] args) {
      Double v=LongtoDouble(100L);
      System.out.println((Double)v);
      Double v2=BigDecimaltoDouble(new BigDecimal("123.123"));
      System.out.println(v2);

    }

    public static Double LongtoDouble(Long l){
        double v = l.doubleValue();
        Double v2=v;
        return v2;
    }

    public static Double BigDecimaltoDouble(BigDecimal b){
        double v = b.doubleValue();
        Double v2=v;
        return v2;
    }


}
