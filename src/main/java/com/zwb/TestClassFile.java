package com.zwb;

/**
 * @author zhengweibo
 * @Date 2022/6/9
 */
public class TestClassFile {
    private static final String finalField = "field_final";
    private static String staticField = "field_static";
    private String stringField = "field_string";
    private Integer intField = 11;

    public static void staticMethod() {
        System.out.println("这是一个静态方法");
    }

    public void method1(Double d) {
        double c = d;
        System.out.println("普通方法" + c);
    }

    public TestClassFile(String stringField, Integer intField) {
        this.stringField = stringField;
        this.intField = intField;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }
}
