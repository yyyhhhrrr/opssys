package com.zyou.ops.util.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.utils
 * @Author: yang
 * @CreateTime: 2019-04-19 13:16
 * @Description: ${Description}
 */
public class StringMatchUtil {
    public static boolean match( String parent,String child ) {

        int count = 0;
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(parent);
        if(m.find()){
            return true;
        }
        return false;
    }
}
