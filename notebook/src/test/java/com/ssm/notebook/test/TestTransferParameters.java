package com.ssm.notebook.test;

import com.ssm.notebook.model.Man;

/***
 * Java对对象采用的不是引用调用，实际上，对象引用进行的是值传递。
 *
 * 总结一下java中方法参数的使用情况：
 *
 * 一个方法不能修改一个基本数据类型的参数(即数值型和布尔型)
 *
 * 一个方法可以改变一个对象参数的状态
 *
 * 一个方法不能让对象参数引用一个新的对象
 */
public class TestTransferParameters {

    public static void main(String[] args){
        Man a = new Man("A",000);
        Man b = new Man("B",111);
        method01(a,b);
        a.toString();
        b.toString();

    }

    public static void method01(Man x,Man y){
        Man temp = new Man("temp",222);
        temp = x;
        x = y;
        y = temp;
        temp.toString();
        x.toString();
        y.toString();
    }

}
