package com.zwb.attribute;

import com.zwb.type.AttributeInfo;
import com.zwb.type.U2;
import com.zwb.type.U4;

import java.nio.ByteBuffer;

/**
 * 属性加工厂，即对属性进行二次解析
 */
public class AttributeProcessingFactory {

    public static ConstantValueAttribute processingConstantValue(AttributeInfo attributeInfo) {
        ConstantValueAttribute attribute = new ConstantValueAttribute();
        attribute.setAttributeNameIndex(attributeInfo.getAttributeNameIndex());
        attribute.setAttributeLength(attributeInfo.getAttributeLength());
        attribute.setConstantvalueIndex(new U2(attributeInfo.getInfo()[0], attributeInfo.getInfo()[1]));
        return attribute;
    }

    public static CodeAttribute processingCode(AttributeInfo attributeInfo) {
        CodeAttribute code = new CodeAttribute();
        ByteBuffer body = ByteBuffer.wrap(attributeInfo.getInfo());
        // 操作数栈大小
        code.setMaxStack(new U2(body.get(),body.get()));
        // 局部变量表大小
        code.setMaxLocals(new U2(body.get(),body.get()));
        // 字节码数组长度
        code.setCodeLength(new U4(body.get(),body.get(),body.get(),body.get()));
        // 解析获取字节码
        byte[] byteCode = new byte[code.getCodeLength().toInt()];
        body.get(byteCode,0,byteCode.length);
        code.setCode(byteCode);
        // 其它暂时不做解析
        body.clear();
        return code;
    }

}
