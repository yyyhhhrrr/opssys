package com.zyou.ops.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
