package com.zwb;

import java.io.Serializable;

/**
 * @author zhengweibo
 * @Date 2022/6/9
 */
public class DemoClass extends Throwable implements Serializable {

    // 常量
    private static final String FINAL_FIELD = "finalField";
    // 静态变量
    private static String staticField = "JVM";
    // 类变量
    private Integer integerField = 10;

    /**
     * 构造器
     */
    public DemoClass(Integer integerField) {
        this.integerField = integerField;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public void setIntegerField(Integer integerField) {
        this.integerField = integerField;
    }

    /**
     * 静态方法
     */
    public static int add(Integer a, Integer b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(staticField);
    }
}
