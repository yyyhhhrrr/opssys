package com.zyou.ops.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-02-18 18:02
 * @Description: ${Description}
 */
public class StringToMap {

    public static Map<String, Object> stringToMap(String str) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (str.startsWith("{") && str.endsWith("}")) {
            str = str.substring(1, str.length());
            str = str.substring(0, str.length() - 1);
            String[] eArr = str.split("=");
            String key = "";
            for (int i = 0; i < eArr.length; i++) {
                String tempStr = eArr[i];
                //如果为最后一个直接做为值进行封装
                if (i == eArr.length - 1) {
                    map.put(key, tempStr.replace(" ", ""));
                } else {
                    //判断字符串中是否包含又"'{', '}','[',']'"字符
                    if ((tempStr).contains("{") || (tempStr).contains("[") || (tempStr).contains("}") || (tempStr).contains("]")) {
                        Stack<String> stackChar = new Stack<String>();
                        Integer stackLength = null;
                        for (int j = 0; j < tempStr.length(); j++) {
                            char c = tempStr.charAt(j);
                            if ((c + "").equals("{") || (c + "").equals("[")) {
                                stackChar.push(c + "");
                                stackLength = stackChar.size();
                            } else if ((c + "").equals("}") || (c + "").equals("]")) {
                                stackChar.pop();
                                stackLength = stackChar.size();
                            } else if ((c + "").equals(",")) {
                                if (stackLength == 0) {
                                    //跳出该循环，并从该处进行分离
                                    String jsonStr = tempStr.substring(0, j);
                                    String newKey = tempStr.substring(j + 1, tempStr.length());
                                    map.put(key, jsonStr.replace(" ", ""));
                                    key = newKey.replace(" ", "");
                                    //清空栈
                                    stackChar.clear();
                                    break;
                                }
                            }
                        }
                    } else {
                        //判断是否有逗号
                        if (tempStr.contains(",")) {
                            Stack<String> stack = new Stack<String>();

                            //从分离的字符串中获取上一个key的value和下一个key的name
                            for (int j = 0; j < tempStr.length(); j++) {
                                char c = tempStr.charAt(j);
                                if (!(c + "").equals(",")) {
                                    stack.push(c + "");
                                } else if ((c + "").equals(" ")) {
                                    continue;
                                } else {
                                    String sStr = stack.pop();
                                    if (sStr.equals("\"")) {
                                        stack.push(sStr);
                                        stack.push(c + "");
                                    } else {
                                        String jsonStr = tempStr.substring(0, j);
                                        String newKey = tempStr.substring(j + 1, tempStr.length());
                                        map.put(key, jsonStr.replace(" ", ""));
                                        key = newKey.replace(" ", "");
                                        //清空栈
                                        stack.clear();
                                        break;
                                    }
                                }
                            }
                        } else {
                            key = tempStr.replace(" ", "");
                        }
                    }
                }
            }
        } else {
            System.out.println("不是正确的Map格式");
        }
        return map;

    }
}