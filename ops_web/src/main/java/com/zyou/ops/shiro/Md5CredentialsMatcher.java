package com.zyou.ops.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.shiro
 * @Author: yang
 * @CreateTime: 2019-05-21 10:04
 * @Description: MD5加密
 */
public class Md5CredentialsMatcher extends HashedCredentialsMatcher {

    public Md5CredentialsMatcher() {
        super();
        setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
    }
}