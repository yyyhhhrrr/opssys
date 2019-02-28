package com.zyou.ops.thread;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.thread
 * @Author: yang
 * @CreateTime: 2019-02-20 10:04
 * @Description: ${Description}
 */
public class ThreadUtil {
    public static Thread findThread(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadId == threads[i].getId()) {
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }
}
