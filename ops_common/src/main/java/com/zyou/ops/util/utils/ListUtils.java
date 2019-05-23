package com.zyou.ops.util.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.utils
 * @Author: yang
 * @CreateTime: 2019-05-22 13:33
 * @Description: ${Description}
 */
public class ListUtils<T> {
    /**
     * @function:从list中随机抽取若干不重复元素
     * @param paramList:被抽取list
     * @param count:抽取元素的个数
     * @return:由抽取元素组成的新list
     */
    public  List getRandomList(List<T> paramList, int count){
        if(count==0){
            return null;
        }
        Random random=new Random();
        List<Integer> tempList=new ArrayList<Integer>();//临时存放产生的list索引，去除重复的索引
        List newList=new ArrayList();//生成新的list集合
        int temp=0;
        if(count<=1){//如果数据小于1，取一条数据
            temp = random.nextInt(paramList.size());
            newList.add(paramList.get(temp));
        }else {
            for(int i=0;i<Math.ceil(count);i++){
                temp=random.nextInt(paramList.size());//初始化一个随机数，将产生的随机数作为被抽list的索引
                if(!tempList.contains(temp)){//判断随机抽取的随机数
                    tempList.add(temp);
                    newList.add(paramList.get(temp));
                }
                else{
                    i--;
                }
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ListUtils<Integer> util=new ListUtils<>();
        List randomList = util.getRandomList(list,1);
        System.out.println(randomList);
    }

}
