package com.zyou.ops.service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-20 09:41
 * @Description: ${Description}
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(new InnerRunnable());
        t.start();
        System.out.println("        thread: " + t);
        long threadId = t.getId();
        System.out.println(threadId);

        // 一：通过线程组遍历获得线程
        Thread s = findThread(threadId);
        System.out.println("   find thread: " + s);
        System.out.println("current thread: " + Thread.currentThread());


        // 二：通过 JMX 可以通过线程 ID 获得线程信息
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        ThreadInfo info = tmx.getThreadInfo(threadId);
        System.out.println(info.getThreadState());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.interrupt();
    }


    /**
     * 通过线程组获得线程
     *
     * @param threadId
     * @return
     */
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

    private static class InnerRunnable implements Runnable {

        private int i = 0;

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(i++);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("mythread is interrupted!");
            }
        }
    }
}
