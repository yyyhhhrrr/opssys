package com.zyou.ops.util.task;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.task
 * @Author: yang
 * @CreateTime: 2019-05-20 09:30
 * @Description: ${Description}
 */
public class UserTask {

    private String type;
    private String name;
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserTask() {
    }

    public UserTask(String type, String name, String content) {
        this.type = type;
        this.name = name;
        this.content = content;
    }
}
