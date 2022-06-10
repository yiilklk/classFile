package com.zwb.handler;

import com.zwb.type.*;

import java.nio.ByteBuffer;

public class MethodHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        // 排在字段解析器的后面
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMethodsCount(new U2(codeBuf.get(), codeBuf.get()));
        // 获取方法总数
        int len = classFile.getMethodsCount().toInt();
        if (len == 0) {
            return;
        }
        // 创建方法表
        MethodInfo[] methodInfos = new MethodInfo[len];
        classFile.setMethods(methodInfos);
        for (int i = 0; i < methodInfos.length; i++) {
            // 解析方法
            methodInfos[i] = new MethodInfo();
            methodInfos[i].setAccessFlags(new U2(codeBuf.get(), codeBuf.get()));
            methodInfos[i].setNameIndex(new U2(codeBuf.get(), codeBuf.get()));
            methodInfos[i].setDescriptorIndex(new U2(codeBuf.get(), codeBuf.get()));
            methodInfos[i].setAttributesCount(new U2(codeBuf.get(), codeBuf.get()));
            // 获取方法的属性总数
            int attr_len = methodInfos[i].getAttributesCount().toInt();
            if (attr_len == 0) {
                continue;
            }
            // 创建方法的属性表
            methodInfos[i].setAttributes(new AttributeInfo[attr_len]);
            for (int j = 0; j < attr_len; j++) {
                methodInfos[i].getAttributes()[j] = new AttributeInfo();
                // 解析方法的属性
                methodInfos[i].getAttributes()[j]
                        .setAttributeNameIndex(new U2(codeBuf.get(), codeBuf.get()));
                // 获取属性info的长度
                U4 attr_info_len = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
                methodInfos[i].getAttributes()[j]
                        .setAttributeLength(attr_info_len);
                if (attr_info_len.toInt() == 0) {
                    continue;
                }
                // 解析info
                byte[] info = new byte[attr_info_len.toInt()];
                codeBuf.get(info, 0, attr_info_len.toInt());
                methodInfos[i].getAttributes()[j].setInfo(info);
            }
        }
    }

}
