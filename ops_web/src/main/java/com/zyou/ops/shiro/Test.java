package com.zyou.ops.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.shiro
 * @Author: yang
 * @CreateTime: 2019-05-21 10:11
 * @Description: ${Description}
 */
public class Test {
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "960314";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
        System.out.println(obj);
    }
}
