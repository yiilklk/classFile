package com.zwb.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClassFile {

    private U4 magic; // 魔数
    private U2 minorVersion; // 次版本号
    private U2 majorVersion; // 主版本号
    private U2 constantPoolCount; // 常量池计数器
    private CpInfo[] constantPool; // 常量池
    private U2 accessFlags; // 访问标志
    private U2 thisClass; // 类索引
    private U2 superClass; // 父类索引
    private U2 interfacesCount; // 接口计数器
    private U2[] interfaces; // 接口索引集合
    private U2 fieldsCount; // 字段表计数器
    private FieldInfo[] fields; // 字段表集合
    private U2 methodsCount; // 方法表计数器
    private MethodInfo[] methods; // 方法表集合
    private U2 attributesCount; // 属性表计数器
    private AttributeInfo[] attributes; // 属性表集合

}
