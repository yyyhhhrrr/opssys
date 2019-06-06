package com.zyou.ops.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.entity
 * @Author: yang
 * @CreateTime: 2019-06-06 16:52
 * @Description: ${Description}
 */
public class LinuxMessage implements Serializable {

    private Integer ssh_id;
    private Map<String,Double> systemMessage;

    public LinuxMessage() {
    }

    public LinuxMessage(Integer ssh_id, Map<String, Double> systemMessage) {
        this.ssh_id = ssh_id;
        this.systemMessage = systemMessage;
    }

    public Integer getSsh_id() {
        return ssh_id;
    }

    public void setSsh_id(Integer ssh_id) {
        this.ssh_id = ssh_id;
    }

    public Map<String, Double> getSystemMessage() {
        return systemMessage;
    }

    public void setSystemMessage(Map<String, Double> systemMessage) {
        this.systemMessage = systemMessage;
    }
}
