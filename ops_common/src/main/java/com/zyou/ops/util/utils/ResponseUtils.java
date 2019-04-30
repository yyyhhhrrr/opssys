package com.zyou.ops.util.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-02-11 09:38
 * @Description: ${Description}
 */
public class ResponseUtils {
    public static void send(HttpServletResponse response,String content){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out=null;

        try {
            out = response.getWriter();
            //若发送数据为null 则默认为""
            if(content == null){
                content = "";
            }
            out.write(content);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (out != null){
                out.close();
            }
        }
    }
}
