package com.zyou.ops.test;

import com.zyou.ops.entity.SShMessage;
import com.zyou.ops.service.SShMessageService;
import com.zyou.ops.util.utils.ByteStringUtil;
import com.zyou.ops.util.utils.DESUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-06-06 15:32
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class SShMessageServiceImplTest {
    @Autowired
    private SShMessageService sShMessageService;

    @Test
    public void test() throws Exception {
//        List<SShMessage> sShMessages = sShMessageService.searchAll();
//        String pwd= sShMessages.get(0).getSsh_pwd();
//        byte[] decrypt = DESUtil.decrypt(ByteStringUtil.toByteArray(pwd), DESUtil.password);
//        System.out.println(new String(decrypt));
        List<SShMessage> sShMessages = sShMessageService.selectByServer();
        for (SShMessage sShMessage : sShMessages) {
            System.out.println(sShMessage.getServerIp().getSv_ip());
        }
    }
}
