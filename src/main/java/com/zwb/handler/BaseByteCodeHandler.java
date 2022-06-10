package com.zwb.handler;

import com.zwb.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {

    /**
     * 属性在字节流里面的顺序
     */
    int order();

    /**
     * 读取
     *
     * @param codeBuf   字节缓冲区
     * @param classFile class文件的字节缓存
     */
    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;

}
