package com.zwb.handler;

import com.zwb.type.*;

import java.nio.ByteBuffer;

public class FieldHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        // 排在接口解析器的后面
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setFieldsCount(new U2(codeBuf.get(), codeBuf.get()));
        // 获取字段总数
        int len = classFile.getFieldsCount().toInt();
        if (len == 0) {
            return;
        }
        // 创建字段表
        FieldInfo[] fieldInfos = new FieldInfo[len];
        classFile.setFields(fieldInfos);
        for (int i = 0; i < fieldInfos.length; i++) {
            // 解析字段
            fieldInfos[i] = new FieldInfo();
            fieldInfos[i].setAccessFlags(new U2(codeBuf.get(), codeBuf.get()));
            fieldInfos[i].setNameIndex(new U2(codeBuf.get(), codeBuf.get()));
            fieldInfos[i].setDescriptorIndex(new U2(codeBuf.get(), codeBuf.get()));
            fieldInfos[i].setAttributesCount(new U2(codeBuf.get(), codeBuf.get()));
            // 获取字段的属性总数
            int attr_len = fieldInfos[i].getAttributesCount().toInt();
            if (attr_len == 0) {
                continue;
            }
            // 创建字段的属性表
            fieldInfos[i].setAttributes(new AttributeInfo[attr_len]);
            for (int j = 0; j < attr_len; j++) {
                fieldInfos[i].getAttributes()[j] = new AttributeInfo();
                // 解析字段的属性
                fieldInfos[i].getAttributes()[j]
                        .setAttributeNameIndex(new U2(codeBuf.get(), codeBuf.get()));
                // 获取属性info的长度
                U4 attr_info_len = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
                fieldInfos[i].getAttributes()[j]
                        .setAttributeLength(attr_info_len);
                if (attr_info_len.toInt() == 0) {
                    continue;
                }
                // 解析info
                byte[] info = new byte[attr_info_len.toInt()];
                codeBuf.get(info, 0, attr_info_len.toInt());
                fieldInfos[i].getAttributes()[j].setInfo(info);
            }
        }
    }

}
