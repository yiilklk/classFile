package com.zwb.util;

import com.zwb.type.U2;

import java.util.HashMap;
import java.util.Map;

public class FieldAccessFlagUtils {
    private static final Map<Integer, String> fieldAccessFlagMap = new HashMap<>();

    static {
        // 声明为public
        fieldAccessFlagMap.put(0x0001, "public");
        // 声明为private
        fieldAccessFlagMap.put(0x0002, "private");
        // 声明为protected
        fieldAccessFlagMap.put(0x0004, "protected");
        // 声明为static
        fieldAccessFlagMap.put(0x0008, "static");
        // 声明为final
        fieldAccessFlagMap.put(0x0010, "final");
        // 声明为volatile
        fieldAccessFlagMap.put(0x0040, "volatile");
        // 声明为transient
        fieldAccessFlagMap.put(0x0080, "transient");
        // 标志该字段由编译器产生，不在源码中
        fieldAccessFlagMap.put(0x1000, "synthtic");
        // 声明为枚举类型的成员
        fieldAccessFlagMap.put(0x4000, "enum");
    }

    /**
     * 获取16进制对应的访问标志和属性字符串表示 （仅用于类的访问标志）
     *
     * @param flag 字段的访问标志
     */
    public static String toFieldAccessFlagsString(U2 flag) {
        final int flagValue = flag.toInt();
        StringBuilder flagBuild = new StringBuilder();
        fieldAccessFlagMap.keySet()
                .forEach(key -> {
                    if ((flagValue & key) == key) {
                        flagBuild.append(fieldAccessFlagMap.get(key)).append(",");
                    }
                });
        return flagBuild.length() > 0 && flagBuild.charAt(flagBuild.length() - 1) == ',' ?
                flagBuild.substring(0, flagBuild.length() - 1)
                : flagBuild.toString();
    }

}
