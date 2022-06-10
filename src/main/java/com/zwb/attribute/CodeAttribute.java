package com.zwb.attribute;

import com.zwb.type.AttributeInfo;
import com.zwb.type.U2;
import com.zwb.type.U4;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeAttribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 maxStack;
    private U2 maxLocals;
    private U4 codeLength;
    private byte[] code;
    private U4 exceptionTableLength;

    @Getter
    @Setter
    public static class Exception {
        private U2 startPc;
        private U2 endPc;
        private U2 handlerPc;
        private U2 catchType;
    }

    private Exception[] exceptionTable;
    private U2 attributesCount;
    private AttributeInfo[] attributes;

}
