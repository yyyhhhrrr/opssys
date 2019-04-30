package com.zyou.ops.util.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-02-01 15:26
 * @Description: ${Description}
 */
public class RequestUtils  {

    public static String getString(HttpServletRequest request,String key){
        String value=request.getParameter(key);
        if(StringUtils.isEmpty(value)){
            return StringUtils.trimAllWhitespace(value);
        }
      return  value;
    }

}
